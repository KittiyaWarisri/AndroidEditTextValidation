package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Option2Activity extends AppCompatActivity implements TextWatcher, View.OnClickListener{

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option2);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name2);
        etPwd = (EditText) findViewById(R.id.et_pwd2);
        etEmail = (EditText) findViewById(R.id.et_email2);
        etPhone = (EditText) findViewById(R.id.et_phone2);
    }

    private void initView(){
        // OnClickListener
        findViewById(R.id.btn_validate2).setOnClickListener(this);

        // TextChangedListener
        etName.addTextChangedListener(this);
        etPwd.addTextChangedListener(this);
        etEmail.addTextChangedListener(this);
        etPhone.addTextChangedListener(this);
    }

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

        validateEditText();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_validate2) {
            if(validateEditText()) {
                Toast.makeText(this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // To validate all EditTexts
    private boolean validateEditText(){
        boolean isValidated = true;
        if (etName.getText().toString().length() == 0) {
            etName.setError("Required");
            isValidated = false;
        }
        else if(!etName.getText().toString().trim().matches("^[a-zA-Z]+[a-z]+[a-z]+")){
            etName.setError("Must be at least 3 characters");
            isValidated = false;
        }
        // TODO: add your EditText validation here
        if (etPwd.getText().toString().length() == 0) {
            etPwd.setError("Pleas Enter Password");
            isValidated = false;
        }
        else if(etPwd.getText().toString().matches("[a-zA-Z ]+")){
            etPwd.setError("Invalid Password");
            isValidated = false;
        }
        else if (etPwd != null && etPwd.length() < 6) {
            etPwd.setError("Must be at least 6 characters");
            isValidated = false;
        }
        if(!etPhone.getText().toString().trim().matches("^[0]+[0-9]+")){
            etPhone.setError("Must start with 0");
            isValidated = false;
        }
        else if (etPhone.getText().toString().length() == 0 ||etPhone.getText().toString().length() <=9 ||etPhone.getText().toString().length() > 10) {
            etPhone.setError("Invalid Phone Number");
            isValidated = false;
        }
        if(!etEmail.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            etEmail.setError("Invalid Email");
            isValidated =false;
        }




        return isValidated;
    }
}
