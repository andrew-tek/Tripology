package edu.cpp.tripology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;

/**
 * Created by andrewtek on 7/16/17.
 */

public class DailyCostActivity extends AppCompatActivity {
    @BindView(R.id.buttonViewPlan)
    Button viewPlan;
    @BindView(R.id.buttonDailyCostBack)
    Button back;
    @BindView(R.id.editTextFood)
    EditText food;
    @BindView(R.id.editTextHotel)
    EditText hotel;
    @BindView(R.id.editTextEntertainment)
    EditText entertainment;
    @BindView(R.id.editTextMisc)
    EditText misc;
    @BindView(R.id.editTextTransportation)
    EditText transportation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_cost);
        ButterKnife.bind(this);
        loadInfo();
    }

    @OnClick (R.id.buttonViewPlan)
    public void changeScreenToTripSummary (){
        if (saveInfo()) {
            Intent intent = new Intent(this, TripSummaryActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(DailyCostActivity.this, "Please Fill In All Fields.", Toast.LENGTH_SHORT).show();

    }

    @OnClick (R.id.buttonDailyCostBack)
    public void changeScreenBackToTripInfo(){
        saveInfo();
        Intent intent = new Intent (this, DestinationInfoActivity.class);
        startActivity(intent);
    }
    public boolean saveInfo() {
        if(food.getText().toString().equals("") || hotel.getText().toString().equals("")
            || entertainment.getText().toString().equals("") || misc.getText().toString().equals("")
            || misc.getText().toString().equals("") || transportation.getText().toString().equals("")) {
            return false;
        } else {
            Paper.book().write("food", food.getText().toString());
            Paper.book().write("hotel", hotel.getText().toString());
            Paper.book().write("entertainment", entertainment.getText().toString());
            Paper.book().write("misc", misc.getText().toString());
            Paper.book().write("transportation", transportation.getText().toString());
            return true;
        }
    }

    public void loadInfo() {
        food.setText(Paper.book().read("food", "").toString());
        hotel.setText(Paper.book().read("hotel", "").toString());
        entertainment.setText(Paper.book().read("entertainment", "").toString());
        misc.setText(Paper.book().read("misc", "").toString());
        transportation.setText(Paper.book().read("transportation", "").toString());


    }

}
