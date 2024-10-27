package com.asma.assignment_8;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextInputLayout i_name, i_email,  i_contact, i_address, i_city, i_division,  i_dob, feadback;
    TextInputEditText usernameEditText, et_email, et_contact, et_address, et_dob, textfeadback;
    CheckBox ch1, ch2;
    RadioGroup radioSimGroup;
    RadioButton radioSimButton;
    Switch simpleSwitch1;
    Switch simpleswitch2;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    EditText ee;

    String[] Myarray ={"A. Dhaka to Jeddah" ,"B. Chittagong to Jeddah","C. Chittagong to Dhaka"};
    String[] set ={"A. Window Seat" ,"B. Front Seat","C. Back Seat","D. Middle Seat","E. First Class" ,"F. Business Class","G. Economy Class"};

    Spinner sp_1;
    Spinner sp_2;
    Button v_b_datapass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();


        i_name = findViewById(R.id.i_name);
        usernameEditText  = findViewById(R.id.usernameEditText );
        i_email = findViewById(R.id.i_email);
        et_email = findViewById(R.id.et_email);
        i_contact = findViewById(R.id.i_contact);
        et_contact = findViewById(R.id.et_contact);
        i_address = findViewById(R.id.i_address);
        et_address = findViewById(R.id.et_address);
        ch1 = findViewById(R.id.male);
        ch2 = findViewById(R.id.female);
        simpleSwitch1 = (Switch) findViewById(R.id.switch1);
        simpleswitch2 = (Switch) findViewById(R.id.switch2);
        i_dob = findViewById(R.id.i_dob);
        et_dob = findViewById(R.id.et_dob);
        sp_1=findViewById(R.id.spinner);
        sp_2=findViewById(R.id.spinner2);
        //Destination
        ArrayAdapter<String> adapater_sp= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Myarray);
        sp_1.setAdapter(adapater_sp);
        //seat
        ArrayAdapter<String> adapater_sp1= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,set);
        sp_2.setAdapter(adapater_sp1);

        feadback = findViewById(R.id.feadback);
        textfeadback = findViewById(R.id.textfeadback);

       // ee = findViewById(R.id.et_rating);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        v_b_datapass = findViewById(R.id.b_name);


        ////date
        et_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);
                String date = month + "/" + dayOfMonth + "/" + year;
                et_dob.setText(date);
            }
        };



        v_b_datapass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ch1 = findViewById(R.id.male);
                ch2 = findViewById(R.id.female);
              //  String statusSwitch1, statusSwitch2;

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                boolean isValid=true;
                //=========user name
                String  username = usernameEditText .getText().toString().trim();
                if(usernameEditText .getText().toString().isEmpty()){
                    i_name.setError("Required");
                    isValid = false;
                }
                else {
                    i_name.setErrorEnabled(false);
                }
                intent.putExtra("key1", username);
                //=============end username

                //=============user email
                String  useremail = et_email .getText().toString().trim();
                if(et_email .getText().toString().isEmpty()){
                    i_email.setError("Required");
                    isValid = false;
                }
                else {
                    i_email.setErrorEnabled(false);
                }
                intent.putExtra("key2", useremail);
                //=============end user email

                //==============user contact
                String  usercontact = et_contact.getText().toString().trim();
                if(et_contact .getText().toString().isEmpty()){
                    i_contact.setError("Required");
                    isValid = false;
                }
                else {
                    i_contact.setErrorEnabled(false);
                }
                intent.putExtra("key3", usercontact);
                //===============end user contact

                //===============address
                String  address = et_address .getText().toString().trim();
                if(et_address .getText().toString().isEmpty()){
                    i_address.setError("Required");
                    isValid = false;
                }
                else {
                    i_address.setErrorEnabled(false);
                }
                intent.putExtra("key4", address);
                //==============end address

            /**    //===============gender
                if (ch1.isChecked()){
                    String ch = ch1.getText().toString().trim();
                    intent.putExtra("key8",ch);
                }
                if (ch2.isChecked()){
                    String chh = ch2.getText().toString().trim();
                    intent.putExtra("key9",chh);
                }
                //===============end gender
**/
              /**  if (ch1.isChecked()){
                    String result = "Male";
                    intent.putExtra("grade1",result);
                }**/


                if (ch2.isChecked()){
                    String result2 = "Female";
                    intent.putExtra("grade2",result2);

                }
//====radio group
                int selectedId = radioSimGroup.getCheckedRadioButtonId();

                radioSimButton = (RadioButton)findViewById(selectedId);

                //data show by toast
              //  Toast.makeText(getApplicationContext(),radioSimButton.getText(),Toast.LENGTH_SHORT).show();
                //datapass
                String rbdata = radioSimButton.getText().toString().trim();
                intent.putExtra("keyrdata",rbdata);
///=====end radio group

//=====switch
            /**    if (simpleSwitch1.isChecked())
                    statusSwitch1=simpleSwitch1.getTextOn().toString();
                else
                    statusSwitch1=simpleSwitch1.getTextOn().toString();

                if (simpleswitch2.isChecked())
                    statusSwitch2=simpleswitch2.getTextOn().toString();
                else
                    statusSwitch2=simpleswitch2.getTextOn().toString();


                intent.putExtra("toggButtondata1",statusSwitch1);
                intent.putExtra("toggButtondata2",statusSwitch2);**/

                //==============date of birth
                String  dob = et_dob.getText().toString().trim();
                if(et_dob.getText().toString().isEmpty()){
                    i_dob.setError("Required");
                    isValid = false;
                }
                else {
                    i_dob.setErrorEnabled(false);
                }
                intent.putExtra("key7", dob);
                //==============end date of birth

//=========user feedback
                String  feedback = textfeadback .getText().toString().trim();
                if(textfeadback .getText().toString().isEmpty()){
                    feadback.setError("Required");
                    isValid = false;
                }
                else {
                    feadback.setErrorEnabled(false);
                }
                intent.putExtra("key", feedback);
                //=============end feadback

             /**   String msg = String.valueOf(ratingBar.getRating());

                ee.setText(msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();**/

                startActivity(intent);

            }
        });
    }

    private void addListenerOnButton() {
        radioSimGroup=(RadioGroup)findViewById(R.id.radiosim);
        v_b_datapass=(Button)findViewById(R.id.b_name);
    }
}