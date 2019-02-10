package com.example.myapplication;


import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
    private EditText grade1_in;
    private EditText grade2_in;
    private EditText grade3_in;
    private EditText grade4_in;
    private EditText grade5_in;
    private EditText credits1;
    private EditText credits2;
    private EditText credits3;
    private EditText credits4;
    private EditText credits5;

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    grade1_in = (EditText) findViewById(R.id.grade1);
    grade2_in = (EditText) findViewById(R.id.grade2);
    grade3_in = (EditText) findViewById(R.id.grade3);
    grade4_in = (EditText) findViewById(R.id.grade4);
    grade5_in = (EditText) findViewById(R.id.grade5);

    credits1 = (EditText) findViewById(R.id.credits1);
    credits2 = (EditText) findViewById(R.id.credits2);
    credits3 = (EditText) findViewById(R.id.credits3);
    credits4 = (EditText) findViewById(R.id.credits4);
    credits5 = (EditText) findViewById(R.id.credits5);


    Button calculate = (Button) findViewById(R.id.compute);

    result = (TextView) findViewById(R.id.result);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (grade1_in.length() == 0) { grade1_in.setError("enter you grade here");}
                if (grade2_in.length() == 0) { grade2_in.setError("enter you grade here");}
                if (grade3_in.length() == 0) { grade3_in.setError("enter you grade here");}
                if (grade4_in.length() == 0) { grade4_in.setError("enter you grade here");}
                if (grade5_in.length() == 0) { grade5_in.setError("enter you grade here");}

                if (credits1.length() == 0) { credits1.setError("enter you grade here");}
                if (credits2.length() == 0) { credits2.setError("enter you grade here");}
                if (credits3.length() == 0) { credits3.setError("enter you grade here");}
                if (credits4.length() == 0) { credits4.setError("enter you grade here");}
                if (credits5.length() == 0) { credits5.setError("enter you grade here");}

                    makeCalculations();
                credits1.setText(null);
                credits2.setText(null);
                credits3.setText(null);
                credits4.setText(null);
                credits5.setText(null);
                grade1_in.setText(null);
                grade2_in.setText(null);
                grade3_in.setText(null);
                grade4_in.setText(null);
                grade5_in.setText(null);
  }
        });
}


    private void makeCalculations() {

        try {
            double n1 = Double.valueOf(grade1_in.getText().toString());
            double n2 = Double.valueOf(grade2_in.getText().toString());
            double n3 = Double.valueOf(grade3_in.getText().toString());
            double n4 = Double.valueOf(grade4_in.getText().toString());
            double n5 = Double.valueOf(grade5_in.getText().toString());

            double c1 = Double.valueOf(credits1.getText().toString());
            double c2 = Double.valueOf(credits2.getText().toString());
            double c3 = Double.valueOf(credits3.getText().toString());
            double c4 = Double.valueOf(credits4.getText().toString());
            double c5 = Double.valueOf(credits2.getText().toString());

            double total_credits = c1 + c2 + c3 + c4 + c5;
            double cn = (n1 * c1) + (n2 * c2) + (n3 * c3) + (n4 * c4) + (n5 * c5);
            double gpa = cn / total_credits;
            Resources res = getResources();
            int RED = res.getColor(R.color.red);
            int YELLOW = res.getColor(R.color.yellow);
            int GREEN = res.getColor(R.color.green);
            if (gpa < 60) {
                findViewById(R.id.layout).setBackgroundColor(RED);
            } else if (gpa > 60 && gpa < 80) {
                findViewById(R.id.layout).setBackgroundColor(YELLOW);
            } else {
                findViewById(R.id.layout).setBackgroundColor(GREEN);
            }

            result.setText("YOUR GPA IS" + "  " + gpa);
        } catch(Exception e){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "You should complete all the fields ",
                        Toast.LENGTH_SHORT);
            }
        }

        }



