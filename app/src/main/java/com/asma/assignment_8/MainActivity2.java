package com.asma.assignment_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText name_show, email_show, con_show, add_show, city_show, division_show, dob_show, gender_show,
            marital_show, dept_show, sec_show, switch_show, feedback_show ,rate_show;
    EditText ex1, ex2;
    EditText ex3;
    EditText ex4;
    EditText ex5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name_show = findViewById(R.id.name_show);
        email_show = findViewById(R.id.email_show);
        con_show = findViewById(R.id.con_show);
        add_show = findViewById(R.id.add_show);

        dob_show = findViewById(R.id.dob_show);
        dept_show = findViewById(R.id.dept_show);
        sec_show = findViewById(R.id.sec_show);
        feedback_show = findViewById(R.id.feedback_show);

        rate_show = findViewById(R.id.rate_show);

        String username = getIntent().getExtras().getString("key1");
        name_show.setText(username);
        String useremail = getIntent().getExtras().getString("key2");
        email_show.setText(useremail);
        String usercontact = getIntent().getExtras().getString("key3");
        con_show.setText(usercontact);
        String address = getIntent().getExtras().getString("key4");
        add_show.setText(address);


      //  EditText ex1 = (EditText)findViewById(R.id.et1);
        EditText ex2 = (EditText)findViewById(R.id.et2);
     //   String value1 = getIntent().getExtras().getString("grade1");
      //  ex1.setText(value1);
        String value2 = getIntent().getExtras().getString("grade2");
        ex2.setText(value2);
        //======radio group
        ex3 = (EditText)findViewById(R.id.et1);
        String value1 = getIntent().getExtras().getString("keyrdata");
        ex3.setText(value1);///====radio group



   /**     ex4 = (EditText)findViewById(R.id.et3);
        ex5 = (EditText)findViewById(R.id.et4);

        String value3 = getIntent().getExtras().getString("toggButtondata1");
        ex1.setText(value3);


        String value4 = getIntent().getExtras().getString("toggButtondata2");
        ex2.setText(value4);**/



        String dob = getIntent().getExtras().getString("key7");
        dob_show.setText(dob);

        String feedback = getIntent().getExtras().getString("key");
        feedback_show.setText(feedback);





    }
}