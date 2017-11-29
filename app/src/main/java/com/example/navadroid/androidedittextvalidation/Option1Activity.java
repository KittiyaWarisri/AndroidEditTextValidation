package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Option1Activity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name1);
        etPwd = (EditText) findViewById(R.id.et_pwd1);
        etEmail = (EditText) findViewById(R.id.et_email1);
        etPhone = (EditText) findViewById(R.id.et_phone1);
    }

    private void initView(){
        findViewById(R.id.btn_validate1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditText()) {
                    Toast.makeText(Option1Activity.this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
                    // SnackBar?
                }
                else{
                    Toast.makeText(Option1Activity.this, "Pleat Fill in Again", Toast.LENGTH_SHORT).show();

                }
            }
        });

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This can be ignored
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This can be ignored
            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditText(); // OR validation can be specific (only for this EditText)
            }
        });

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO: add your Password validation here
                validateEditPass();
            }
        });

        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditPhone();
            }
        });
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditEmail();
            }
        });


    }

    // To validate all EditTexts
    private boolean validateEditText(){
        boolean isValidatedName = true;


        if (etName.getText().toString().length() == 0) {
            etName.setError("FIELD CANNOT BE EMPTY");
            isValidatedName = false;
        }
        // TODO: add your EditText validation here
        else if(!etName.getText().toString().trim().matches("^[a-zA-Z]+[a-z]+[a-z]+")){
            etName.setError("Must be at least 3 characters");
            isValidatedName = false;
        }
        return isValidatedName;
    }

    private boolean validateEditPass(){
        boolean isValidatedPass = true;
        if (etPwd.getText().toString().length() == 0) {
            etPwd.setError("Please Enter Password");
            isValidatedPass = false;
        }
        else if(etPwd.getText().toString().matches("[a-zA-Z ]+")){
            etPwd.setError("Please Enter Number Only");
            isValidatedPass = false;
        }
        else if (etPwd != null && etPwd.length() < 6) {
            etPwd.setError("Must be at least 6 characters");
            isValidatedPass = false;
        }


        return isValidatedPass;
    }


    private boolean validateEditPhone(){
        boolean isValidatedPhone = true;
        if(!etPhone.getText().toString().trim().matches("^[0]+[0-9]+")){
            etPhone.setError("Must start with 0");
            isValidatedPhone = false;
        }
        else if (etPhone.getText().toString().length() == 0 ||etPhone.getText().toString().length() <=9 ||etPhone.getText().toString().length() > 10) {
            etPhone.setError("Invalid Phone Number");
            isValidatedPhone = false;
        }
        return isValidatedPhone;
    }

    private boolean validateEditEmail(){
        boolean isValidatedEmail = true;


        if(!etEmail.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            etEmail.setError("Invalid Email");
            isValidatedEmail =false;
        }


        return isValidatedEmail;
    }





}
