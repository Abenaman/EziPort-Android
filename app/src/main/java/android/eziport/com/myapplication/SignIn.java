package android.eziport.com.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class SignIn extends Activity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_in);

        final Button signUp = (Button) findViewById(R.id.signUp);
        final Button signIn = (Button) findViewById(R.id.signIn);
        final Button cancelButton = (Button) findViewById(R.id.cancelButton);
        final Button signinButton = (Button) findViewById(R.id.signInButton);

        final EditText usrName = (EditText) findViewById(R.id.userName);
        final EditText passWd = (EditText) findViewById(R.id.password);

        usrName.setText("");
        passWd.setText("");

        final RelativeLayout layout = (RelativeLayout ) findViewById(R.id.SignInLayout);
        layout.setVisibility(View.INVISIBLE);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp.setEnabled(false);
                signIn.setEnabled(false);
                layout.setVisibility(View.VISIBLE);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), SignUp.class);
                startActivity(myIntent);
            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usrname = usrName.getText().toString();
                String passwd = passWd.getText().toString();

                if ((usrname.trim()).length()==0 || (passwd.trim()).length()==0 ) {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);
                    dlgAlert.setMessage("User Name & Password Can't Be Empty");
                    dlgAlert.setTitle("Error");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usrName.setText("");
                passWd.setText("");
                layout.setVisibility(View.INVISIBLE);
                signUp.setEnabled(true);
                signIn.setEnabled(true);
            }
        });
    }

}