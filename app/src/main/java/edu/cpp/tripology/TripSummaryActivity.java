package edu.cpp.tripology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TripSummaryActivity extends AppCompatActivity {
    @BindView(R.id.buttonTripSummaryBack)
    Button editTripButton;
    @BindView(R.id.buttonTripSummaryInputBudget)
    Button viewTripPlanButton;

    @Override
    protected void onCreate (Bundle bundleSavedInstance) {
        super.onCreate(bundleSavedInstance);
        setContentView(R.layout.activity_trip_summary);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.buttonTripSummaryBack)
    public void goToEditScreen() {
        Intent intent = new Intent (this, DailyCostActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.buttonTripSummaryInputBudget)
    public void goToTripPlan() {
        Intent intent = new Intent(this, BudgetInputActivity.class);
        startActivity(intent);
    }
}
