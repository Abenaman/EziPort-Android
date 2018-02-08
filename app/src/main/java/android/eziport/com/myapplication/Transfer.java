package android.eziport.com.myapplication;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
//htttp
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

//http
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Transfer extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private String weight,date,name,time,Spin1,Spin2,status;
    EditText date_txt;
    EditText name_txt;
    EditText weight_txt;
    EditText time_txt;
    ArrayList<String> transferList = new ArrayList<String>();
    String transferData[];
    SendTransfer tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        addItemsOnSpinner1();
        addItemsOnSpinner2();
        addListenerOnSpinnerItemSelection();
        date_txt = (EditText) findViewById(R.id.date_p);
        name_txt=(EditText) findViewById(R.id.name);
        weight_txt=(EditText) findViewById(R.id.weight_p);
        time_txt=(EditText) findViewById(R.id.time_p);
        btnSubmit=(Button)findViewById(R.id.submit_button);
        weight=weight_txt.getText().toString().trim();
        date=date_txt.getText().toString().trim();
        time=time_txt.getText().toString().trim();
        name=name_txt.getText().toString().trim();
        Spin1=spinner1.getSelectedItem().toString().trim();
        Spin2=spinner2.getSelectedItem().toString().trim();


        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                weight=weight_txt.getText().toString().trim();
                date=date_txt.getText().toString().trim();
                time=time_txt.getText().toString().trim();
                name=name_txt.getText().toString().trim();
                Spin1=spinner1.getSelectedItem().toString().trim();
                Spin2=spinner2.getSelectedItem().toString().trim();

                if(weight.length() != 0 && date.length() !=0 && time.length() !=0 && name.length() !=0) {
                    SendTransfer  tr= new SendTransfer(Spin1,Spin2,date,status,name,weight,time,transferList);
                    transferList.add(weight);
                    transferList.add(date);
                    transferList.add(time);
                    transferList.add(name);
                    transferList.add(Spin1);
                    transferList.add(Spin2);
                    tr.setTo(Spin1);
                    tr.setFrom(Spin2);
                    tr.setDate(date);
                    tr.setName(name);
                    tr.setWeight(weight);
                    tr.setTime(time);
                    tr.setTransferList(transferList);
//                    JSONArray jsonArray = new JSONArray(Arrays.asList(transferList));
//                    date_txt.setText("");
//                    time_txt.setText("");
//                    name_txt.setText("");
//                    weight_txt.setText("");
                    try{
                        if(isConnected()&& validate()){
                            new HttpAsyncTask().execute("http://172.19.20.68:8080/post-transfer");
                            Toast.makeText(Transfer.this,
                                    "You have Submited your data", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Transfer.this,
                                    "Connection Error", Toast.LENGTH_SHORT).show();

                        }
                    }
                    catch(Exception e){

                        e.getMessage();
                    }


                }
                else {
                    Toast.makeText(Transfer.this,
                            "Please Enter a full data", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    // add items into spinner dynamically
    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner_from);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
    }
    public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner_to);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner_to);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener());
        spinner2 = (Spinner) findViewById(R.id.spinner_from);
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener());
    }

    //send the Json to http server

    public static String POST(String url, SendTransfer data){
        InputStream inputStream = null;
        String result = "";
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("countryFrom", data.getFrom());
            jsonObject.accumulate("countryTo", data.getTo());
            jsonObject.accumulate("date", data.getDate());
            jsonObject.accumulate("status", data.getStatus());
            jsonObject.accumulate("username", data.getName());
            jsonObject.accumulate("weight", data.getWeight());

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // ** Alternative way to convert Person object to JSON string usin Jackson Lib
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person);

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        // 11. return result
        return result;
    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            tr= new SendTransfer(Spin1,Spin2,date,status,name,weight,time,transferList);

            tr.setFrom(spinner1.getSelectedItem().toString().trim());
            tr.setTo(spinner2.getSelectedItem().toString().trim());
            tr.setDate(date_txt.getText().toString());
            tr.setStatus("1");
            tr.setName(name_txt.getText().toString());
            tr.setWeight(weight_txt.getText().toString());
            return POST(urls[0],tr);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validate(){
        if(name_txt.getText().toString().trim().equals(""))
            return false;
        else if(weight_txt.getText().toString().trim().equals(""))
            return false;
        else if(date_txt.getText().toString().trim().equals(""))
            return false;
        else if(time_txt.getText().toString().trim().equals(""))
            return false;
        else if(Spin1.equals(""))
            return false;
        else if(Spin2.equals(""))
            return false;
        else
            return true;
    }
    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

//    public void onClick(View view) {
//
//        switch(view.getId()){
//            case R.id.submit_button:
//                if(!validate())
//                    Toast.makeText(getBaseContext(), "Enter some data!", Toast.LENGTH_LONG).show();
//                // call AsynTask to perform network operation on separate thread
//                new HttpAsyncTask().execute("echo.jsontest.com");
//                break;
//        }
//
//    }


}


