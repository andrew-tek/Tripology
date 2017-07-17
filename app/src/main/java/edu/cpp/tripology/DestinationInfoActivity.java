package edu.cpp.tripology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DestinationInfoActivity extends AppCompatActivity {
    @BindView(R.id.buttonContinue)
    Button continueButton;
    @BindView(R.id.buttonBack)
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_info);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonContinue)
    public void changeScreenToDaily () {
        Intent intent = new Intent (this, DailyCostActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonBack)
    public void changeScreenToHome() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
