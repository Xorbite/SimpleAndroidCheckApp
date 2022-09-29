package com.orb.snackbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button doecheck = findViewById(R.id.doecheckbutton);
        doecheck.setOnClickListener(v -> AgeCheck());
//        doecheck.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                AgeCheck();
//            }
//        });

    }

    public void AgeCheck() {
        EditText age = findViewById(R.id.agebar);
        TextView answer = findViewById(R.id.Antwoord);
        String agestring = age.getText().toString();

        Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show();

        try {
            int actualage = Integer.parseInt(agestring);

                if (actualage <= 18 && actualage > 0)
                    answer.setText("U heeft recht op kinderbijslag");
                else if (actualage >= 67 && actualage <= 150)
                    answer.setText("U heeft recht op AOW");
                else if (actualage > 150)
                    answer.setText("Wooh, bent u nou zo oud? U moet alle waardes naar de waarheid invullen!");
                else if (actualage <= 0) answer.setText("Onjuiste waarde!");

                else answer.setText("U valt helaas niet onder de huidige categorieen!");
        } catch(Exception e){
            System.out.println("Something went wrong!");
        }
    }

    public void Burgelijkestaat(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();
        TextView answer2 = findViewById(R.id.Antwoord2);

        // Check which radio button was clicked
        switch (v.getId()) {
            case R.id.gehuwd:
                if (checked)
                    answer2.setText("Leuk voor je...");
                break;
            case R.id.ongehuwd:
                if (checked)
                    answer2.setText("Nog vrijgezel zie ik, he?");
                break;
        }
    }
}

