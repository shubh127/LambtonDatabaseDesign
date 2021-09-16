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

public class TicketInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText tietTicketNo;
    private TextInputEditText tietTicketType;
    private TextInputEditText tietRefNo;
    private TextInputEditText tietTicketPrice;
    private TextInputEditText tietTicketStatus;

    private TextInputLayout tilTicketNo;
    private TextInputLayout tilTicketType;
    private TextInputLayout tilRefNo;
    private TextInputLayout tilTicketPrice;
    private TextInputLayout tilTicketStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_info);

        initViews();
    }

    private void initViews() {
        tietTicketNo = findViewById(R.id.tiet_ticket_no);
        tietTicketType = findViewById(R.id.tiet_ticket_type);
        tietRefNo = findViewById(R.id.tiet_ref_no);
        tietTicketPrice = findViewById(R.id.tiet_price);
        tietTicketStatus = findViewById(R.id.tiet_status);

        tilTicketNo = findViewById(R.id.til_ticket_no);
        tilTicketType = findViewById(R.id.til_ticket_type);
        tilRefNo = findViewById(R.id.til_ref_no);
        tilTicketPrice = findViewById(R.id.til_price);
        tilTicketStatus = findViewById(R.id.til_status);

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

        if (TextUtils.isEmpty(tietTicketNo.getText())) {
            tilTicketNo.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilTicketNo.setErrorEnabled(false);
        }

        if (TextUtils.isEmpty(tietTicketType.getText())) {
            tilTicketType.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilTicketType.setError(null);
        }

        if (TextUtils.isEmpty(tietTicketPrice.getText())) {
            tilTicketPrice.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilTicketPrice.setError(null);
        }

        if (TextUtils.isEmpty(tietTicketStatus.getText())) {
            tilTicketStatus.setError(getString(R.string.empty_error_txt));
            isValid = false;
        } else {
            tilTicketStatus.setError(null);
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
        boolean isSuccess = dbHelper.addTicketInfo(
                Integer.parseInt(Objects.requireNonNull(tietTicketNo.getText()).toString()),
                Objects.requireNonNull(tietTicketType.getText()).toString(),
                Integer.parseInt(Objects.requireNonNull(tietRefNo.getText()).toString()),
                Integer.parseInt(Objects.requireNonNull(tietTicketPrice.getText()).toString()),
                Objects.requireNonNull(tietTicketStatus.getText()).toString());
        dbHelper.close();
        if (isSuccess) {
            finish();
        }
    }

}