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

public class ReferenceInfoActivity extends AppCompatActivity  implements View.OnClickListener{
    private TextInputEditText tietRefNo;
    private TextInputEditText tietAirlineCode;
    private TextInputEditText tietFlightSource;
    private TextInputEditText tietDestination;
    private TextInputEditText tietPhone;
    private TextInputEditText tietTicketNo;
    private TextInputEditText tietPId;
    private TextInputEditText tietFlightNo;

    private TextInputLayout tilRefNo;
    private TextInputLayout tilAirlineCode;
    private TextInputLayout tilFlightSource;
    private TextInputLayout tilDestination;
    private TextInputLayout tilPhone;
    private TextInputLayout tilTicketNo;
    private TextInputLayout tilPId;
    private TextInputLayout tilFlightNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_info);

        initViews();
    }

    private void initViews() {

        tietRefNo = findViewById(R.id.tiet_ref_no);
        tietAirlineCode = findViewById(R.id.tiet_airline_code);
        tietFlightSource = findViewById(R.id.tiet_flight_source);
        tietDestination = findViewById(R.id.tiet_destination);
        tietPhone = findViewById(R.id.tiet_phone);
        tietTicketNo = findViewById(R.id.tiet_ticket_no);
        tietPId = findViewById(R.id.tiet_p_id);
        tietFlightNo = findViewById(R.id.tiet_flight_no);

        tilRefNo = findViewById(R.id.til_ref_no);
        tilAirlineCode = findViewById(R.id.til_airline_code);
        tilFlightSource = findViewById(R.id.til_flight_source);
        tilDestination = findViewById(R.id.til_destination);
        tilPhone = findViewById(R.id.til_phone);
        tilTicketNo = findViewById(R.id.til_ticket_no);
        tilPId = findViewById(R.id.til_p_id);
        tilFlightNo = findViewById(R.id.til_flight_no);

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

        if (TextUtils.isEmpty(tietRefNo.getText())) {
            tilRefNo.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilRefNo.setErrorEnabled(false);
        }

        if (TextUtils.isEmpty(tietAirlineCode.getText())) {
            tilAirlineCode.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilAirlineCode.setError(null);
        }

        if (TextUtils.isEmpty(tietFlightSource.getText())) {
            tilFlightSource.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilFlightSource.setError(null);
        }

        if (TextUtils.isEmpty(tietDestination.getText())) {
            tilDestination.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilDestination.setError(null);
        }

        if (TextUtils.isEmpty(tietPhone.getText())) {
            tilPhone.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilPhone.setError(null);
        }

        if (TextUtils.isEmpty(tietTicketNo.getText())) {
            tilTicketNo.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilTicketNo.setError(null);
        }

        if (TextUtils.isEmpty(tietPId.getText())) {
            tilPId.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilPId.setError(null);
        }

        if (TextUtils.isEmpty(tietFlightNo.getText())) {
            tilFlightNo.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilFlightNo.setError(null);
        }

        return isValid;
    }

    private void saveDataToDatabase() {

        DataBaseHelper dbHelper = new DataBaseHelper(this);
        boolean isSuccess = dbHelper.addReferenceInfo(
                Integer.parseInt(Objects.requireNonNull(tietRefNo.getText()).toString()),
                Objects.requireNonNull(tietAirlineCode.getText()).toString(),
                Objects.requireNonNull(tietFlightSource.getText()).toString(),
                Objects.requireNonNull(tietDestination.getText()).toString(),
                Integer.parseInt(Objects.requireNonNull(tietPhone.getText()).toString()),
                Integer.parseInt(Objects.requireNonNull(tietTicketNo.getText()).toString()),
                Integer.parseInt(Objects.requireNonNull(tietPId.getText()).toString()),
                Integer.parseInt(Objects.requireNonNull(tietFlightNo.getText()).toString()));
        dbHelper.close();
        if (isSuccess) {
            finish();
        }
    }
}