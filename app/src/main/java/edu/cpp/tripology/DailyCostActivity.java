package edu.cpp.tripology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by andrewtek on 7/16/17.
 */

public class DailyCostActivity extends AppCompatActivity {
    @BindView(R.id.buttonViewPlan)
    Button viewPlan;
    @BindView(R.id.buttonDailyCostBack)
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_cost);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.buttonViewPlan)
    public void changeScreenToTripSummary (){
        Intent intent = new Intent (this, TripSummaryActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.buttonDailyCostBack)
    public void changeScreenBackToTripInfo(){
        Intent intent = new Intent (this, DestinationInfoActivity.class);
        startActivity(intent);

    }

}
