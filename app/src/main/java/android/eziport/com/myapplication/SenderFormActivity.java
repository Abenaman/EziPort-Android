package android.eziport.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SenderFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText destinationBox = (EditText) findViewById(R.id.destinationBox);
                String destination = destinationBox.getText().toString();

                EditText weightBox = (EditText) findViewById(R.id.weightBox);
                int weight = Integer.valueOf(weightBox.getText().toString());

                EditText fromDateBox = (EditText) findViewById(R.id.fromDateBox);
                String fromDate = fromDateBox.getText().toString();

                EditText toDateBox = (EditText) findViewById(R.id.toDateBox);
                String toDate = toDateBox.getText().toString();

                EditText detailsBox = (EditText) findViewById(R.id.detailsBox);
                String details = detailsBox.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
