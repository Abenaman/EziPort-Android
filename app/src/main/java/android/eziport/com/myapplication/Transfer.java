package android.eziport.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

import NonActivity.Classes.SendTransfer;

public class Transfer extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private String weight,date,name,time,Spin1,Spin2;
    EditText date_txt;
    EditText name_txt;
    EditText weight_txt;
    EditText time_txt;
    ArrayList<String> transferList = new ArrayList<String>();
    String transferData[];
    SendTransfer tr= new SendTransfer(weight,date,name,time,transferList,Spin1,Spin2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        addItemsOnSpinner1();
        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        date_txt = (EditText) findViewById(R.id.date_p);
        name_txt=(EditText) findViewById(R.id.name);
        weight_txt=(EditText) findViewById(R.id.weight_p);
        time_txt=(EditText) findViewById(R.id.time_p);
        tr= new SendTransfer(weight,date,name,time,transferList,Spin1,Spin2);
        btnSubmit=(Button)findViewById(R.id.submit_button);
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
                    transferList.add(weight);
                    transferList.add(date);
                    transferList.add(time);
                    transferList.add(name);
                    transferList.add(Spin1);
                    transferList.add(Spin2);
                    tr.setDate(date);
                    tr.setName(name);
                    tr.setWeight(weight);
                    tr.setTime(time);
                    tr.setTransferList(transferList);
                    //                    JSONArray jsonArray = new JSONArray(Arrays.asList(transferList));
                    date_txt.setText("");
                    time_txt.setText("");
                    name_txt.setText("");
                    weight_txt.setText("");
                    Toast.makeText(Transfer.this,
                            "You have Submited your data"+transferList, Toast.LENGTH_SHORT).show();
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
    public void addListenerOnButton() {

}
}