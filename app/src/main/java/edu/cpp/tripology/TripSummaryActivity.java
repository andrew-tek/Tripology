package edu.cpp.tripology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;


public class TripSummaryActivity extends AppCompatActivity {
    @BindView(R.id.buttonTripSummaryBack)
    Button editTripButton;
    @BindView(R.id.buttonTripSummaryInputBudget)
    Button viewTripPlanButton;
    @BindView(R.id.textViewGrandTotal)
    TextView grandTotalTextView;
    @BindView(R.id.textViewDailyCost)
    TextView dailyCostTextView;
    @BindView(R.id.textViewDurationOfTrip)
    TextView duration;
    @BindView(R.id.textViewSummaryDestination)
    TextView destinationTextView;
    @BindView(R.id.textViewSummaryCurrency)
    TextView currencyTextView;
    private int tripDuration;
    private int food;
    private int hotel;
    private int entertainment;
    private int transportation;
    private int misc;
    private int airFare;
    private int grandTotal;
    private int dailyCost;
    private double currencyRate;
    private String currencyName;
    private String destination;



    @Override
    protected void onCreate (Bundle bundleSavedInstance) {
        super.onCreate(bundleSavedInstance);
        destination = Paper.book().read("destination");
        tripDuration = Integer.parseInt(Paper.book().read("tripDuration").toString());
        food = Integer.parseInt(Paper.book().read("food").toString());
        hotel = Integer.parseInt(Paper.book().read("hotel").toString());
        entertainment = Integer.parseInt(Paper.book().read("entertainment").toString());
        transportation = Integer.parseInt(Paper.book().read("transportation").toString());
        misc = Integer.parseInt(Paper.book().read("misc").toString());
        airFare = Integer.parseInt(Paper.book().read("airFare").toString());
        currencyRate = Double.parseDouble(Paper.book().read("currencyRate").toString());
        currencyName = Paper.book().read("currencyName").toString();

        setContentView(R.layout.activity_trip_summary);
        ButterKnife.bind(this);

        grandTotalTextView.setText(getGrandTotal());
        dailyCostTextView.setText(getDailyCost());
        duration.setText(String.valueOf(tripDuration) + " day(s)");
        int costPerDay = (int)currencyRate * (food + hotel + entertainment + transportation + misc);
        String cost = String.valueOf(costPerDay) + " " + currencyName;
        destinationTextView.setText(destination.toString());
        currencyTextView.setText(cost);



    }

    @OnClick (R.id.buttonTripSummaryBack)
    public void goToEditScreen() {
        saveInfo();
        Intent intent = new Intent (this, DailyCostActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.buttonTripSummaryInputBudget)
    public void goToTripPlan() {
        saveInfo();
        Intent intent = new Intent(this, BudgetInputActivity.class);
        startActivity(intent);
    }
    public void saveInfo() {
        Paper.book().write("grandTotal", String.valueOf(grandTotal));
        Paper.book().write("dailyCost", String.valueOf(dailyCost));
    }
    public String getGrandTotal() {
        grandTotal = airFare + (tripDuration * (food + hotel + entertainment + transportation + misc));
        return "$" + String.valueOf(grandTotal);
    }
    public String getDailyCost() {
        dailyCost = food + hotel + entertainment + transportation + misc;
        return "$" + String.valueOf(dailyCost);
    }

}
