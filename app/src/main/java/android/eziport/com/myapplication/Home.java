package android.eziport.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    private static final int REPLY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button status = (Button) findViewById(R.id.button1);
        Button sender = (Button) findViewById(R.id.button2);
        Button transfer = (Button) findViewById(R.id.button3);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Status.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Sender.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Reciever.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
}
