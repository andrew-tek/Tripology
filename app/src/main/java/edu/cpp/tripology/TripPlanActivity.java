package edu.cpp.tripology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TripPlanActivity extends AppCompatActivity {

    @BindView(R.id.buttonMoneySaved)
    Button recordMoney;
    @BindView(R.id.buttonTripPlanEdit)
    Button editPlan;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_trip_plan);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.buttonMoneySaved)
    public void makePayment() {
        Intent intent = new Intent (this, DestinationInfoActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.buttonTripPlanEdit)
    public void editPlan() {
        Intent intent = new Intent (this, DestinationInfoActivity.class);
        startActivity(intent);
    }



}
