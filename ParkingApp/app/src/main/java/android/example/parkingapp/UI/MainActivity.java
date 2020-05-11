package android.example.parkingapp.UI;

import android.example.parkingapp.Controller.Controller;
import android.example.parkingapp.R;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rv = findViewById(R.id.recyclerview);
        Controller c = new Controller(this);
        c.InsertParkings(rv);
    }
}
