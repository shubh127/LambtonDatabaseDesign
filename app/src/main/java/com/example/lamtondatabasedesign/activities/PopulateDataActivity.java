package com.example.lamtondatabasedesign.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lamtondatabasedesign.R;

public class PopulateDataActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populate_data);
        initViews();
    }

    private void initViews() {
        Button btnTableFlight = findViewById(R.id.btn_flight_table);
        Button btnTableReservation = findViewById(R.id.btn_reservation_table);
        Button btnTableTicket = findViewById(R.id.btn_ticket_table);
        Button btnTablePassenger = findViewById(R.id.btn_passenger_table);

        btnTableFlight.setOnClickListener(this);
        btnTableReservation.setOnClickListener(this);
        btnTableTicket.setOnClickListener(this);
        btnTablePassenger.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_flight_table) {
            openFlightInfoActivity();
        } else if (view.getId() == R.id.btn_reservation_table) {
            openReservationInfoActivity();
        } else if (view.getId() == R.id.btn_ticket_table) {
            openTicketInfoActivity();
        } else if (view.getId() == R.id.btn_passenger_table) {
            openPassengerInfoActivity();
        }
    }

    private void openPassengerInfoActivity() {
        startActivity(new Intent(this, PassengerInfoActivity.class));
    }

    private void openTicketInfoActivity() {
        startActivity(new Intent(this, TicketInfoActivity.class));
    }

    private void openReservationInfoActivity() {
        startActivity(new Intent(this, FlightInfoActivity.class));
    }

    private void openFlightInfoActivity() {
        startActivity(new Intent(this, FlightInfoActivity.class));
    }

}