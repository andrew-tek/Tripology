package edu.cpp.tripology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;

/**
 * Created by andrewtek on 7/16/17.
 */

public class BudgetInputActivity extends AppCompatActivity {
    @BindView(R.id.buttonBudgetInputBack)
    Button backButton;
    @BindView(R.id.buttonBudgetInputContinue)
    Button continueButton;
    @BindView(R.id.datePicker)
    DatePicker datePicker;
    private Date date;
    private int year;
    private int month;
    private int dayOfMonth;

    @Override
    public void onCreate (Bundle saveBundleInstance) {
        super.onCreate(saveBundleInstance);
        setContentView(R.layout.activity_budget_input);
        ButterKnife.bind(this);
        datePicker.setMinDate(System.currentTimeMillis());
        loadDate();
    }
    @OnClick (R.id.buttonBudgetInputBack)
    public void changeScreenBack() {
        getDate();
        Paper.book().write("startDate", date.getTime());
        Paper.book().write("dayMonth", datePicker.getDayOfMonth());
        Intent intent = new Intent(this, TripSummaryActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonBudgetInputContinue)
    public void changeScreenContinue() {
        getDate();
//        Paper.book().write("startDate", date.getTime());
        Paper.book().write("dayMonth", datePicker.getDayOfMonth());

        Paper.book().write("year", datePicker.getYear());
        Paper.book().write("month", datePicker.getMonth());
        Paper.book().write("dayOfMonth", datePicker.getDayOfMonth());

        Intent intent = new Intent(this, TripPlanActivity.class);
        startActivity(intent);
    }

    void getDate() {
        date = new Date (datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
    }
    void loadDate() {
        year = Paper.book().read("year", 0);
        if (year != 0) {
            month = Paper.book().read("month");
            dayOfMonth = Paper.book().read("dayOfMonth");
            datePicker.updateDate(year, month, dayOfMonth);
        }
    }

}
