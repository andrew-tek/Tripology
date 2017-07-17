package edu.cpp.tripology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;


public class DestinationInfoActivity extends AppCompatActivity {
    @BindView(R.id.buttonContinue)
    Button continueButton;
    @BindView(R.id.buttonBack)
    Button backButton;
    @BindView(R.id.editTextDestination)
    EditText destination;
    @BindView(R.id.editTextTripDuration)
    EditText tripDuration;
    @BindView(R.id.editTextCurrencyName)
    EditText currencyName;
    @BindView(R.id.editTextCurrenyRate)
    EditText currencyRate;
    @BindView(R.id.editTextAirFare)
    EditText airFare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_info);
        ButterKnife.bind(this);
        loadInfo();
    }

    @OnClick(R.id.buttonContinue)
    public void changeScreenToDaily () {
        if (saveInfo()) {
            Intent intent = new Intent(this, DailyCostActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(DestinationInfoActivity.this, "Please Fill In All Fields.", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.buttonBack)
    public void changeScreenToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loadInfo() {

        destination.setText(Paper.book().read("destination", "").toString());
        tripDuration.setText(Paper.book().read("tripDuration", "").toString());
        currencyName.setText(Paper.book().read("currencyName", "").toString());
        currencyRate.setText(Paper.book().read("currencyRate", "").toString());
        airFare.setText(Paper.book().read("airFare", "").toString());
    }
    public boolean saveInfo() {
        if(destination.getText().toString().equals("") || tripDuration.getText().toString().equals("")
                || currencyName.getText().toString().equals("") || currencyRate.getText().toString().equals("")
                || airFare.getText().toString().equals("")) {
            return false;
        } else {
            Paper.book().write("destination", destination.getText().toString());
            Paper.book().write("tripDuration", tripDuration.getText().toString());
            Paper.book().write("currencyRate", currencyRate.getText().toString());
            Paper.book().write("currencyName", currencyName.getText().toString());
            Paper.book().write("airFare", airFare.getText().toString());
            return true;
        }
    }
}
