package edu.cpp.tripology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;


public class TripPlanActivity extends AppCompatActivity {

    @BindView(R.id.buttonMoneySaved)
    Button recordMoney;
    @BindView(R.id.buttonTripPlanEdit)
    Button editPlan;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.editTextMoneySaved)
    EditText moneySaved;
    @BindView(R.id.textViewWeeksUntilVacation)
    TextView weeksUntilVacation;
    @BindView(R.id.textViewAmountPerWeek)
    TextView amountPerWeek;
    @BindView(R.id.textViewCostRemaining)
    TextView costRemaining;

    private int amountSaved;
    private int grandTotal;
    private int weeks;
    private Date targetDate;
    private int weekAmount;
    private String remainingTotal;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_trip_plan);
        ButterKnife.bind(this);
        initializeView();

    }

    @OnClick (R.id.buttonMoneySaved)
    public void makePayment() {
        amountSaved += Integer.parseInt(moneySaved.getText().toString());
        if (amountSaved > 0) {
            progressBar.setProgress(amountSaved);
            remainingTotal = new String("$");
            remainingTotal += String.valueOf(grandTotal - amountSaved);
            costRemaining.setText(remainingTotal);
            Paper.book().write("moneySaved", String.valueOf(amountSaved));
            moneySaved.setText("");
        }

    }

    @OnClick (R.id.buttonTripPlanEdit)
    public void editPlan() {
        Intent intent = new Intent (this, DestinationInfoActivity.class);
        startActivity(intent);
    }
    public void initializeView() {
        grandTotal = Integer.parseInt(Paper.book().read("grandTotal", "100"));
        progressBar.setMax(grandTotal);
        weekAmount = Integer.parseInt(Paper.book().read("amountPerWeek", "-1"));
        amountSaved = Integer.parseInt(Paper.book().read("moneySaved", "0"));
        progressBar.setProgress(amountSaved);
        int year = Paper.book().read("year", 0);
        year -= 1900;
        int month = Paper.book().read("month", 0);
        int day = Paper.book().read("dayOfMonth", 0);
        targetDate = new Date (year, month, day);
        long tempWeeks;
        long targetSeconds = targetDate.getTime();
        Date currentDate = new Date(System.currentTimeMillis());
        long currentSeconds = currentDate.getTime();
        tempWeeks = (targetSeconds - currentSeconds) / 604800000;
        weeks = (int) tempWeeks;
        weeksUntilVacation.setText(String.valueOf(weeks));

        if (weekAmount == -1) {
            if (weeks == 0)
                weeks = 1;
            weekAmount = grandTotal / weeks;
            Paper.book().write("amountPerWeek", String.valueOf(weekAmount));
        }
        amountPerWeek.setText(String.valueOf(weekAmount));

        remainingTotal = new String ("$" + String.valueOf(grandTotal - amountSaved));
        costRemaining.setText(remainingTotal);
    }

}
