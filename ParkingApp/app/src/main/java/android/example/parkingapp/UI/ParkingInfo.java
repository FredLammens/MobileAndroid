package android.example.parkingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.parkingapp.Controller.UISetter;
import android.example.parkingapp.Domein.Parking;
import android.example.parkingapp.R;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ParkingInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//enables backbutton => parentactivity set in androidmanifest
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Parking currentParking = intent.getParcelableExtra("clickedParking");
        //region head
        Button availableSpace = findViewById(R.id.availableSpace);
        TextView fullname = findViewById(R.id.fullname);
        UISetter.setupCard(currentParking, availableSpace, fullname);
        //endregion
        //region body
        TextView name = findViewById(R.id.nameData);
        name.setText(currentParking.getName());
        TextView adres = findViewById(R.id.adresData);
        adres.setText(currentParking.getAddress());
        TextView contactInfo = findViewById(R.id.contactInfoData);
        contactInfo.setText(currentParking.getContactInfo());
        TextView totCap = findViewById(R.id.totaleCapaciteitData);
        totCap.setText(Integer.toString(currentParking.getParkingStatus().getTotalCapacity()));
        //endregion
    }

    //region clickhandler
    public void OpenMaps(View view){
        TextView tv = (TextView) view;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("google.navigation:q="+tv.getText()));
        startActivity(intent);
    }
    //endregion
}
