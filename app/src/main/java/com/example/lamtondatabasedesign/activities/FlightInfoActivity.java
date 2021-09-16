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
    private TextInputEditText tietAircraftType;
    private TextInputEditText tietDestination;
    private TextInputEditText tietAirlineCode;
    private TextInputEditText tietFlightTime;
    private TextInputEditText tietFlightSource;
    private TextInputEditText tietRefNo;

    private TextInputLayout tilFlightNumber;
    private TextInputLayout tilAircraft;
    private TextInputLayout tilAircraftType;
    private TextInputLayout tilDestination;
    private TextInputLayout tilAirlineCode;
    private TextInputLayout tilFlightTime;
    private TextInputLayout tilFlightSource;
    private TextInputLayout tilRefNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_info);

        initViews();
    }

    private void initViews() {
        tietFlightNumber = findViewById(R.id.tiet_flight_no);
        tietAircraft = findViewById(R.id.tiet_aircraft);
        tietAircraftType = findViewById(R.id.tiet_aircraft_type);
        tietDestination = findViewById(R.id.tiet_destination);
        tietAirlineCode = findViewById(R.id.tiet_airline_code);
        tietFlightTime = findViewById(R.id.tiet_flight_time);
        tietFlightSource = findViewById(R.id.tiet_flight_source);
        tietRefNo = findViewById(R.id.tiet_ref_no);


        tilFlightNumber = findViewById(R.id.til_flight_no);
        tilAircraft = findViewById(R.id.til_aircraft);
        tilAircraftType = findViewById(R.id.til_aircraft_type);
        tilDestination = findViewById(R.id.til_destination);
        tilAirlineCode = findViewById(R.id.til_airline_code);
        tilFlightTime = findViewById(R.id.til_flight_time);
        tilFlightSource= findViewById(R.id.til_flight_source);
        tilRefNo= findViewById(R.id.til_ref_no);

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

        if (TextUtils.isEmpty(tietAircraftType.getText())) {
            tilAircraftType.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilAircraftType.setError(null);
        }

        if (TextUtils.isEmpty(tietDestination.getText())) {
            tilDestination.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilDestination.setError(null);
        }

        if (TextUtils.isEmpty(tietAirlineCode.getText())) {
            tilAirlineCode.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilAirlineCode.setError(null);
        }

        if (TextUtils.isEmpty(tietFlightTime.getText())) {
            tilFlightTime.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilFlightTime.setError(null);
        }

        if (TextUtils.isEmpty(tietFlightSource.getText())) {
            tilFlightSource.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilFlightSource.setError(null);
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
        boolean isSuccess = dbHelper.addFlightInfo(
                Integer.parseInt(Objects.requireNonNull(tietFlightNumber.getText()).toString()),
                Objects.requireNonNull(tietAircraft.getText()).toString(),
                Objects.requireNonNull(tietAircraftType.getText()).toString(),
                Objects.requireNonNull(tietDestination.getText()).toString(),
                Objects.requireNonNull(tietAirlineCode.getText()).toString(),
                Objects.requireNonNull(tietFlightTime.getText()).toString(),
                Objects.requireNonNull(tietFlightSource.getText()).toString(),
                Integer.parseInt(Objects.requireNonNull(tietRefNo.getText()).toString()));
        dbHelper.close();
        if (isSuccess) {
            finish();
        }
    }

}