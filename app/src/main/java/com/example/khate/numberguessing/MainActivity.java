package com.example.khate.numberguessing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv1 = (TextView) findViewById(R.id.textView);
        final TextView guessText = (TextView) findViewById(R.id.textView2);
        final EditText userText = (EditText) findViewById(R.id.editText);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String randText = "";
                Random RandGen = new Random();
                int rando = RandGen.nextInt(5) + 1;
                int userNum = Integer.parseInt(userText.getText().toString());


                if ( userNum < 1 || userNum > 5){
                    guessText.setText("Please Guess bw 1-5");
                }
                else if (userNum == rando){
                    guessText.setText("You Guessed!");
                }
                else{
                    guessText.setText("Try again.");
                }

                randText = Integer.toString(rando);
                tv1.setText(randText);

                userText.setText("0");
            }
        });
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
