package com.example.lamtondatabasedesign.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.lamtondatabasedesign.R;

public class DataBaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "AirlineTicketReservation.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME_FLIGHT_INFO = "FLIGHT_INFO";

    public static final String FLIGHT_COLUMN_SR_NO = "sr_no";
    public static final String FLIGHT_COLUMN_FLIGHT_NO = "flight_no";
    public static final String FLIGHT_COLUMN_AIRCRAFT = "aircraft";
    public static final String FLIGHT_COLUMN_SOURCE = "source";
    public static final String FLIGHT_COLUMN_DESTINATION = "destination";
    public static final String FLIGHT_COLUMN_AIRLINE = "airline";
    public static final String FLIGHT_COLUMN_FLIGHT_TIME = "flight_time";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Not Required but we have to override it
    }

    public void createTable() {
        SQLiteDatabase db = this.getWritableDatabase();

        //creating flight table
        db.execSQL( "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_FLIGHT_INFO +
                " (" + FLIGHT_COLUMN_SR_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FLIGHT_COLUMN_FLIGHT_NO + " INTEGER, " +
                FLIGHT_COLUMN_AIRCRAFT + " TEXT, " +
                FLIGHT_COLUMN_SOURCE + " TEXT, " +
                FLIGHT_COLUMN_DESTINATION + " TEXT, " +
                FLIGHT_COLUMN_AIRLINE + " TEXT, " +
                FLIGHT_COLUMN_FLIGHT_TIME + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not Required but we have to override it
    }

    public boolean addFlightInfo(int flightNo, String aircraft, String source, String destination, String airline, String flightTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FLIGHT_COLUMN_FLIGHT_NO, flightNo);
        values.put(FLIGHT_COLUMN_AIRCRAFT, aircraft);
        values.put(FLIGHT_COLUMN_SOURCE, source);
        values.put(FLIGHT_COLUMN_DESTINATION, destination);
        values.put(FLIGHT_COLUMN_AIRLINE, airline);
        values.put(FLIGHT_COLUMN_FLIGHT_TIME, flightTime);

        long result = db.insert(TABLE_NAME_FLIGHT_INFO, null, values);
        if (result == -1) {
            Toast.makeText(context, context.getString(R.string.error_msg), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(context, context.getString(R.string.success_msg), Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
