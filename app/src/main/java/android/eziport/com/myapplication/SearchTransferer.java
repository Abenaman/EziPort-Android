package android.eziport.com.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchTransferer extends AppCompatActivity {

    private Spinner spinner1;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_transferer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addItemsOnSpinner1();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner_dest);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener());

    }
    public void addListenerOnButton() {


        btnSearch = (Button) findViewById(R.id.search_transferer);

        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(SearchTransferer.this,
                        "Send query to server.." , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
