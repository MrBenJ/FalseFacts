package io.mrbenj.falsefacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private TextView fact;
    private ArrayList<String> factLibrary;
    private EditText addFactInput;
    private Button generateFactButton;
    private Button addFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFactLibrary();

        initViews();

        generateFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = (int) (Math.random() * factLibrary.size());

                fact.setText(factLibrary.get(randomNumber));
            }
        });

        addFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(addFactInput.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Enter some text!", Toast.LENGTH_LONG).show();
                }
                else {
                    factLibrary.add(addFactInput.getText().toString());
                    addFactInput.setText("");
                    Toast.makeText(MainActivity.this, getString(R.string.added), Toast.LENGTH_LONG)
                            .show();
                }

            }
        });









    }

    private void initViews() {
        fact = (TextView) findViewById(R.id.fact);
        generateFactButton = (Button) findViewById(R.id.button);
        addFactButton = (Button) findViewById(R.id.addFactButton);
        addFactInput = (EditText) findViewById(R.id.addFactInput);
    }

    private void initFactLibrary() {
        factLibrary = new ArrayList<>();

        factLibrary.add("Kittens have spiked fur.");
        factLibrary.add("Nalgene bottles hydrate better than regular bottles");
        factLibrary.add("The internet is a series of tubes underground");
        factLibrary.add("North Korea is Best Korea!");
        factLibrary.add("Roses are red, violets are blue, in Soviet Russia, POEM WRITES YOU!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
