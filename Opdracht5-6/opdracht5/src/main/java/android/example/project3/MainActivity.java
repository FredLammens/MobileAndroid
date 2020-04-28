package android.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcView);
        Controller c = new Controller(this);
        c.InsertPoolCars(recyclerView);
        SharedPreferences pref = this.getSharedPreferences("project5", getApplicationContext().MODE_PRIVATE);
        boolean visited = pref.getBoolean("visited",false);
        if(!visited){
            Toast.makeText(this,"Welcome!",Toast.LENGTH_SHORT).show();
            pref.edit().putBoolean("visited",true).commit();
        }
    }
}
