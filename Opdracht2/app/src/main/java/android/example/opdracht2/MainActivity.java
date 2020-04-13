package android.example.opdracht2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView first_PoolCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first_PoolCar = findViewById(R.id.first_poolCar);
        Controller.InsertPoolCar(first_PoolCar);
    }
}
