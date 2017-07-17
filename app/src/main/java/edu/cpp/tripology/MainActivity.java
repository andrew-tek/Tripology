package edu.cpp.tripology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.cpp.tripology.data.TripInformation;
import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.buttonNewPlan)
    Button startNewTripButton;
    @BindView(R.id.buttonViewPlan)
    Button viewPlanButton;
    private TripInformation tripInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        ButterKnife.bind(this);
        loadDataLocally();
    }

    public void loadDataLocally() {
        tripInfo = Paper.book().read("tripInfo", new TripInformation());
    }

    @OnClick(R.id.buttonViewPlan)
    public void changeScreenToViewPlan() {
        if (tripInfo == null) {
            Intent intent = new Intent(this, TripPlanActivity.class);
        }
        else {
            Intent intent = new Intent(this, DestinationInfoActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.buttonNewPlan)
    public void changeScreenToNewPlan () {
        Intent intent = new Intent(this, DestinationInfoActivity.class);
        startActivity(intent);
    }
}
