package com.crizto.findaplumber;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5);
        final EditText editTextSalutation = (EditText) findViewById(R.id.editTextSalutation);
        final EditText editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        final EditText editTextGivenName = (EditText) findViewById(R.id.editTextGivenName);
        final EditText editTextDOB = (EditText) findViewById(R.id.editTextDOB);
        final EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        final EditText editTextMobile = (EditText) findViewById(R.id.editTextMobile);
        final EditText editTextAddress1 = (EditText) findViewById(R.id.editTextAddress1);
        final EditText editTextAddress2 = (EditText) findViewById(R.id.editTextAddress2);
        final EditText editTextPostalCode = (EditText) findViewById(R.id.editTextPostalCode);
        final EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        final EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        Button button = (Button) findViewById(R.id.buttonHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity5.this, activity1.class);
                startActivity(intent);
            }
        });

        Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        final TextView textView = (TextView) findViewById(R.id.textView1);

        final SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String Salutation = sp.getString("Salutation", null);
        String Surname = sp.getString("Surname", null);
        String GivenName = sp.getString("Given Name", null);
        String DOB = sp.getString("Date Of Birth", null);
        String Email = sp.getString("Email", null);
        String Mobile = sp.getString("Mobile", null);
        String Address1 = sp.getString("Address1", null);
        String Address2 = sp.getString("Address2", null);
        String PostalCode = sp.getString("Postal Code", null);
        String Username = sp.getString("Username", null);
        final String Password = sp.getString("Password", null);


//        if (Username != null && Password != null) {
//            textView.setText(Username + " : " + Password);
//        } else {
//            textView.setText("User data not yet input");
//        }

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Salutation = editTextSalutation.getText().toString();
                String Surname = editTextSurname.getText().toString();
                String GivenName = editTextGivenName.getText().toString();
                String DOB = editTextDOB.getText().toString();
                String Email = editTextDOB.getText().toString();
                String Mobile = editTextMobile.getText().toString();
                String Address1 = editTextMobile.getText().toString();
                String Address2 = editTextMobile.getText().toString();
                String PostalCode = editTextMobile.getText().toString();
                String Username = editTextUsername.getText().toString();
                String Password = editTextPassword.getText().toString();


                if (Username.length() > 0 && Password.length() > 0) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Username", Username);
                    editor.putString("Password", Password);
                    editor.commit();
                    textView.setText(Username + " : " + Password);

                    Intent intent = new Intent(activity5.this, activity6.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(activity5.this, "please input name and phone", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
