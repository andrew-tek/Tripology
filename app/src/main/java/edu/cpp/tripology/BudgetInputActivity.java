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

public class BudgetInputActivity extends AppCompatActivity {
    @BindView(R.id.buttonBudgetInputBack)
    Button backButton;
    @BindView(R.id.buttonBudgetInputContinue)
    Button continueButton;

    @Override
    public void onCreate (Bundle saveBundleInstance) {
        super.onCreate(saveBundleInstance);
        setContentView(R.layout.activity_budget_input);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.buttonBudgetInputBack)
    public void changeScreenBack() {
        Intent intent = new Intent(this, TripSummaryActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonBudgetInputContinue)
    public void changeScreenContinue() {
        Intent intent = new Intent(this, TripPlanActivity.class);
        startActivity(intent);
    }

}
