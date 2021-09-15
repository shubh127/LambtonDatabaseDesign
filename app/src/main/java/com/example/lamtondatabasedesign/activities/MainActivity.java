package com.example.lamtondatabasedesign.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lamtondatabasedesign.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        Button btnPopulateData = findViewById(R.id.btn_populate_data);
        Button btnRetrieveData = findViewById(R.id.btn_retrieve_data);

        btnPopulateData.setOnClickListener(this);
        btnRetrieveData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_populate_data) {
            handlePopulateDataOnClick();
        } else if (view.getId() == R.id.btn_retrieve_data) {
            handleRetrieveDataOnClick();
        }
    }

    private void handleRetrieveDataOnClick() {
        startActivity(new Intent(this, RetrieveDataActivity.class));
    }

    private void handlePopulateDataOnClick() {
        startActivity(new Intent(this, PopulateDataActivity.class));
    }
}