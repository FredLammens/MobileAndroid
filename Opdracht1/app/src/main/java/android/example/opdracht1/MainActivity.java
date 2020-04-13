package android.example.opdracht1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    String Datum = java.text.DateFormat.getDateTimeInstance().format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tekst = findViewById(R.id.DatumTijd);
        tekst.setText(Datum);
    }

}
