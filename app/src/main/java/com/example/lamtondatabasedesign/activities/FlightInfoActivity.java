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

public class FlightInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText tietFlightNumber;
    private TextInputEditText tietAircraft;
    private TextInputEditText tietSource;
    private TextInputEditText tietDestination;
    private TextInputEditText tietAirline;
    private TextInputEditText tietFlightTime;

    private TextInputLayout tilFlightNumber;
    private TextInputLayout tilAircraft;
    private TextInputLayout tilSource;
    private TextInputLayout tilDestination;
    private TextInputLayout tilAirline;
    private TextInputLayout tilFlightTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_info);

        initViews();
    }

    private void initViews() {
        tietFlightNumber = findViewById(R.id.tiet_flight_no);
        tietAircraft = findViewById(R.id.tiet_aircraft);
        tietSource = findViewById(R.id.tiet_source);
        tietDestination = findViewById(R.id.tiet_destination);
        tietAirline = findViewById(R.id.tiet_airline);
        tietFlightTime = findViewById(R.id.tiet_flight_time);

        tilFlightNumber = findViewById(R.id.til_flight_no);
        tilAircraft = findViewById(R.id.til_aircraft);
        tilSource = findViewById(R.id.til_source);
        tilDestination = findViewById(R.id.til_destination);
        tilAirline = findViewById(R.id.til_airline);
        tilFlightTime = findViewById(R.id.til_flight_time);

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

        if (TextUtils.isEmpty(tietFlightNumber.getText())) {
            tilFlightNumber.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilFlightNumber.setErrorEnabled(false);
        }

        if (TextUtils.isEmpty(tietAircraft.getText())) {
            tilAircraft.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilAircraft.setError(null);
        }

        if (TextUtils.isEmpty(tietSource.getText())) {
            tilSource.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilSource.setError(null);
        }

        if (TextUtils.isEmpty(tietDestination.getText())) {
            tilDestination.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilDestination.setError(null);
        }

        if (TextUtils.isEmpty(tietAirline.getText())) {
            tilAirline.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilAirline.setError(null);
        }

        if (TextUtils.isEmpty(tietFlightTime.getText())) {
            tilFlightTime.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilFlightTime.setError(null);
        }

        return isValid;
    }

    private void saveDataToDatabase() {
        DataBaseHelper dbHelper = new DataBaseHelper(this);
        dbHelper.addFlightInfo(Integer.parseInt(Objects.requireNonNull(tietFlightNumber.getText()).toString()),
                Objects.requireNonNull(tietAircraft.getText()).toString(),
                Objects.requireNonNull(tietSource.getText()).toString(),
                Objects.requireNonNull(tietDestination.getText()).toString(),
                Objects.requireNonNull(tietAirline.getText()).toString(),
                Objects.requireNonNull(tietFlightTime.getText()).toString());
    }

}