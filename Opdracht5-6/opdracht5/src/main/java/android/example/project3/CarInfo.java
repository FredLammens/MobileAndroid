package android.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class CarInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        PoolCar currentCar = intent.getParcelableExtra("clickedCar");
        TextView displayName = findViewById(R.id.displayName);
        TextView displayObject = findViewById(R.id.displayObject);
        displayName.setText(currentCar.displayName);
        displayObject.append("Brand: " + currentCar.vehicleInformation.getBrand());
        displayObject.append("\nModel: " + currentCar.vehicleInformation.getModel());
        displayObject.append("\nFuel type: " + currentCar.vehicleInformation.getFuelType());
        displayObject.append("\nTransmission: " + currentCar.vehicleInformation.getTransmissionType());
    }
}
