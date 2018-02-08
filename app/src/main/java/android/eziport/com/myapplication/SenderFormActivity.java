package android.eziport.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SenderFormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String lastDestination = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Spinner destinationSpinner = (Spinner) findViewById(R.id.destinationSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(adapter);
        destinationSpinner.setOnItemSelectedListener(this);

        Button button = findViewById(R.id.submit_button_sender);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EditText titleBox = (EditText) findViewById(R.id.titleBox);
//                String title = titleBox.getText().toString();
//
//                String destination = lastDestination;
//
//                EditText weightBox = (EditText) findViewById(R.id.weightBox);
//                int weight = Integer.valueOf(weightBox.getText().toString());
//
//                EditText fromDateBox = (EditText) findViewById(R.id.fromDateBox);
//                String fromDate = fromDateBox.getText().toString();
//
//                EditText toDateBox = (EditText) findViewById(R.id.toDateBox);
//                String toDate = toDateBox.getText().toString();
//
//                EditText detailsBox = (EditText) findViewById(R.id.detailsBox);
//                String details = detailsBox.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        lastDestination = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
