package com.example.lamtondatabasedesign.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.lamtondatabasedesign.R;

public class DataBaseHelper extends SQLiteOpenHelper {

    private final Context context;
    public static final String DATABASE_NAME = "AirlineTicketReservation.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME_FLIGHT_INFO = "FLIGHT_INFO";
    public static final String TABLE_NAME_REFERENCE_INFO = "REFERENCE_INFO";
    public static final String TABLE_NAME_PASSENGER_INFO = "PASSENGER_INFO";
    public static final String TABLE_NAME_TICKET_INFO = "TICKET_INFO";

    public static final String COLUMN_FLIGHT_NO = "flightNo";
    public static final String COLUMN_AIRCRAFT = "aircraft";
    public static final String COLUMN_AIRCRAFT_TYPE = "aircraftType";
    public static final String COLUMN_DESTINATION = "destination";
    public static final String COLUMN_AIRLINE_CODE = "AirlineCode";
    public static final String COLUMN_FLIGHT_TIME = "flightTime";
    public static final String COLUMN_SOURCE = "source";
    public static final String COLUMN_REF_NO = "referenceNo";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_TICKET_NO = "ticketNo";
    public static final String COLUMN_PID = "passengerId";
    public static final String COLUMN_NAME = "passengerName";
    public static final String COLUMN_ADDRESS = "passengerAddress";
    public static final String COLUMN_POSTAL_CODE = "postalCode";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_PROVINCE = "province";
    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_PHONE_NO = "phoneNo";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_TICKET_TYPE = "ticketType";
    public static final String COLUMN_TICKET_PRICE = "ticketPrice";
    public static final String COLUMN_TICKET_STATUS = "ticketStatus";


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
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_FLIGHT_INFO +
                " (" + COLUMN_FLIGHT_NO + " INTEGER PRIMARY KEY , " +
                COLUMN_AIRCRAFT + " TEXT, " +
                COLUMN_AIRCRAFT_TYPE + " TEXT, " +
                COLUMN_DESTINATION + " TEXT, " +
                COLUMN_AIRLINE_CODE + " TEXT, " +
                COLUMN_FLIGHT_TIME + " TEXT, " +
                COLUMN_SOURCE + " TEXT, " +
                COLUMN_REF_NO + " INTEGER);");

        //creating reference table
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_REFERENCE_INFO +
                " (" + COLUMN_REF_NO + " INTEGER PRIMARY KEY , " +
                COLUMN_AIRLINE_CODE + " TEXT, " +
                COLUMN_SOURCE + " TEXT, " +
                COLUMN_DESTINATION + " TEXT, " +
                COLUMN_PHONE + " INTEGER, " +
                COLUMN_TICKET_NO + " INTEGER, " +
                COLUMN_PID + " INTEGER, " +
                COLUMN_FLIGHT_NO + " INTEGER);");

        //creating passenger table
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_PASSENGER_INFO +
                " (" + COLUMN_PID + " INTEGER PRIMARY KEY , " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_POSTAL_CODE + " TEXT, " +
                COLUMN_CITY + " TEXT, " +
                COLUMN_PROVINCE + " TEXT, " +
                COLUMN_COUNTRY + " TEXT, " +
                COLUMN_PHONE_NO + " INTEGER, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_DOB + " TEXT, " +
                COLUMN_TICKET_NO + " INTEGER, " +
                COLUMN_REF_NO + " INTEGER);");

        //creating ticket table
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_TICKET_INFO +
                " (" + COLUMN_TICKET_NO + " INTEGER PRIMARY KEY , " +
                COLUMN_TICKET_TYPE + " TEXT, " +
                COLUMN_REF_NO + " INTEGER, " +
                COLUMN_TICKET_PRICE + " INTEGER, " +
                COLUMN_TICKET_STATUS + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not Required but we have to override it
    }

    public boolean addFlightInfo(int flightNo, String aircraft, String aircraftType, String destination, String airlineCode, String flightTime, String flightSource, int refNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_FLIGHT_NO, flightNo);
        values.put(COLUMN_AIRCRAFT, aircraft);
        values.put(COLUMN_AIRCRAFT_TYPE, aircraftType);
        values.put(COLUMN_DESTINATION, destination);
        values.put(COLUMN_AIRLINE_CODE, airlineCode);
        values.put(COLUMN_FLIGHT_TIME, flightTime);
        values.put(COLUMN_SOURCE, flightSource);
        values.put(COLUMN_REF_NO, refNo);

        long result = db.insert(TABLE_NAME_FLIGHT_INFO, null, values);
        if (result == -1) {
            Toast.makeText(context, context.getString(R.string.error_msg), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(context, context.getString(R.string.success_msg), Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean addTicketInfo(int ticketNo, String ticketType, int refNo, int price, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TICKET_NO, ticketNo);
        values.put(COLUMN_TICKET_TYPE, ticketType);
        values.put(COLUMN_REF_NO, refNo);
        values.put(COLUMN_TICKET_PRICE, price);
        values.put(COLUMN_TICKET_STATUS, status);

        long result = db.insert(TABLE_NAME_TICKET_INFO, null, values);
        if (result == -1) {
            Toast.makeText(context, context.getString(R.string.error_msg), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(context, context.getString(R.string.success_msg), Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
