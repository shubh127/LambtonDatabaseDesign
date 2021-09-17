package com.example.lamtondatabasedesign.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.lamtondatabasedesign.R;
import com.example.lamtondatabasedesign.database.DataBaseHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class PassengerInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText tietPId;
    private TextInputEditText tietPassengerName;
    private TextInputEditText tietAddress;
    private TextInputEditText tietPostalCode;
    private TextInputEditText tietCity;
    private TextInputEditText tietProvince;
    private TextInputEditText tietCountry;
    private TextInputEditText tietPhone;
    private TextInputEditText tietEmail;
    private TextInputEditText tietDOB;
    private TextInputEditText tietTicketNo;
    private TextInputEditText tietRefNo;

    private TextInputLayout tilPId;
    private TextInputLayout tilPassengerName;
    private TextInputLayout tilAddress;
    private TextInputLayout tilPostalCode;
    private TextInputLayout tilCity;
    private TextInputLayout tilProvince;
    private TextInputLayout tilCountry;
    private TextInputLayout tilPhone;
    private TextInputLayout tilEmail;
    private TextInputLayout tilDOB;
    private TextInputLayout tilTicketNo;
    private TextInputLayout tilRefNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_info);

        initViews();
    }

    private void initViews() {
        tietPId = findViewById(R.id.tiet_p_id);
        tietPassengerName = findViewById(R.id.tiet_passenger_name);
        tietAddress = findViewById(R.id.tiet_address);
        tietPostalCode = findViewById(R.id.tiet_postal_code);
        tietCity = findViewById(R.id.tiet_city);
        tietProvince = findViewById(R.id.tiet_province);
        tietCountry = findViewById(R.id.tiet_country);
        tietPhone = findViewById(R.id.tiet_phone);
        tietEmail = findViewById(R.id.tiet_email);
        tietDOB = findViewById(R.id.tiet_dob);
        tietTicketNo = findViewById(R.id.tiet_ticket_no);
        tietRefNo = findViewById(R.id.tiet_ref_no);

        tilPId = findViewById(R.id.til_p_id);
        tilPassengerName = findViewById(R.id.til_passenger_name);
        tilAddress = findViewById(R.id.til_address);
        tilPostalCode = findViewById(R.id.til_postal_code);
        tilCity = findViewById(R.id.til_city);
        tilProvince = findViewById(R.id.til_province);
        tilCountry = findViewById(R.id.til_country);
        tilPhone = findViewById(R.id.til_phone);
        tilEmail = findViewById(R.id.til_email);
        tilDOB = findViewById(R.id.til_dob);
        tilTicketNo = findViewById(R.id.til_ticket_no);
        tilRefNo = findViewById(R.id.til_ref_no);

        Button btnSubmit = findViewById(R.id.btn_submit_details);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit_details && validateDetails()) {
            saveDataToDatabase();
        }
    }

    private boolean validateDetails() {

        boolean isValid = true;

        if (TextUtils.isEmpty(tietPId.getText())) {
            tilPId.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilPId.setErrorEnabled(false);
        }

        if (TextUtils.isEmpty(tietPassengerName.getText())) {
            tilPassengerName.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilPassengerName.setError(null);
        }

        if (TextUtils.isEmpty(tietAddress.getText())) {
            tilAddress.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilAddress.setError(null);
        }

        if (TextUtils.isEmpty(tietPostalCode.getText())) {
            tilPostalCode.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilPostalCode.setError(null);
        }

        if (TextUtils.isEmpty(tietCity.getText())) {
            tilCity.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilCity.setError(null);
        }

        if (TextUtils.isEmpty(tietProvince.getText())) {
            tilProvince.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilProvince.setError(null);
        }

        if (TextUtils.isEmpty(tietCountry.getText())) {
            tilCountry.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilCountry.setError(null);
        }

        if (TextUtils.isEmpty(tietPhone.getText())) {
            tilPhone.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilPhone.setError(null);
        }

        if (TextUtils.isEmpty(tietEmail.getText())) {
            tilEmail.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilEmail.setError(null);
        }

        if (TextUtils.isEmpty(tietDOB.getText())) {
            tilDOB.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilDOB.setError(null);
        }

        if (TextUtils.isEmpty(tietTicketNo.getText())) {
            tilTicketNo.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilTicketNo.setError(null);
        }

        if (TextUtils.isEmpty(tietRefNo.getText())) {
            tilRefNo.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilRefNo.setError(null);
        }

        return isValid;
    }

    private void saveDataToDatabase() {

        DataBaseHelper dbHelper = new DataBaseHelper(this);
        boolean isSuccess = dbHelper.addPassengerInfo(
                Integer.parseInt(Objects.requireNonNull(tietPId.getText()).toString()),
                Objects.requireNonNull(tietPassengerName.getText()).toString(),
                Objects.requireNonNull(tietAddress.getText()).toString(),
                Objects.requireNonNull(tietPostalCode.getText()).toString(),
                Objects.requireNonNull(tietCity.getText()).toString(),
                Objects.requireNonNull(tietProvince.getText()).toString(),
                Objects.requireNonNull(tietCountry.getText()).toString(),
                Integer.parseInt(Objects.requireNonNull(tietPhone.getText()).toString()),
                Objects.requireNonNull(tietEmail.getText()).toString(),
                Objects.requireNonNull(tietDOB.getText()).toString(),
                Integer.parseInt(Objects.requireNonNull(tietTicketNo.getText()).toString()),
                Integer.parseInt(Objects.requireNonNull(tietRefNo.getText()).toString()));
        dbHelper.close();
        if (isSuccess) {
            finish();
        }
    }
}