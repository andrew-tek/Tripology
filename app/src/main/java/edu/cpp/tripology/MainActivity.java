package edu.cpp.tripology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.buttonNewPlan)
    Button startNewTripButton;
    @BindView(R.id.buttonViewPlan)
    Button viewPlanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        ButterKnife.bind(this);
        Paper.init(this);
    }


    @OnClick(R.id.buttonViewPlan)
    public void changeScreenToViewPlan() {
        String destination = Paper.book().read("destination", new String());
        Intent intent;
        if (destination.equals("")) {
            intent = new Intent(this, DestinationInfoActivity.class);
        }
        else {
            intent = new Intent(this, TripPlanActivity.class);
        }
        startActivity(intent);
    }

    @OnClick(R.id.buttonNewPlan)
    public void changeScreenToNewPlan () {
        Paper.book().destroy();
        Intent intent = new Intent(this, DestinationInfoActivity.class);
        startActivity(intent);
    }

}
