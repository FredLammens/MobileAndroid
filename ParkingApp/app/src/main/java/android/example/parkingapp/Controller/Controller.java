package android.example.parkingapp.Controller;

import android.content.Context;
import android.content.Intent;
import android.example.parkingapp.Domein.Parking;
import android.example.parkingapp.Domein.ParkingApi;
import android.example.parkingapp.UI.ParkingInfo;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements ParkingAdapter.OnParkingClickListener {
    //region properties
    static final String BASE_URL = "https://datatank.stad.gent/4/";
    ArrayList<Parking> parkinglijst;
    ParkingAdapter adapter = new ParkingAdapter(this);
    Context context;
    //endregion
    //region constructor
    public Controller(Context context) {this.context = context;}
    //endregion
    //region methods
    public void InsertParkings(RecyclerView view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) // place to append relative url to
                .addConverterFactory(GsonConverterFactory.create()) // parse response to gson
                .build();
        ParkingApi parkingApi = retrofit.create(ParkingApi.class); // create retrofit object
        //Execute network request
        Call<List<Parking>> callParkings = parkingApi.getParkings();
        callParkings.enqueue(new Callback<List<Parking>>() {//execute call asyncronously and get response back
            @Override
            public void onResponse(Call<List<Parking>> call, Response<List<Parking>> response) {  // when response back from server (not nessecarily succesfull)
                if(!response.isSuccessful()){ // checks if http code is >300  <400
                    Log.e("httpError", "Code: " + response.code());
                    return; // leave method
                }
                parkinglijst= (ArrayList<Parking>) response.body();
                //region setup recyclerview
                view.setHasFixedSize(true);// if recyclerview does not change in size = true => makes performance better
                RecyclerView.LayoutManager manager = new LinearLayoutManager(context);
                adapter.setParkings(parkinglijst);
                view.setLayoutManager(manager);
                view.setAdapter(adapter);
                //endregion
            }

            @Override
            public void onFailure(Call<List<Parking>> call, Throwable t) { // when something went wrong with communication or response
                t.printStackTrace(); // print error message
            }
        });
    }

    @Override
    public void onParkingClick(int clickedItemIndex) {
       Intent intent = new Intent(context, ParkingInfo.class);
       intent.putExtra("clickedParking",parkinglijst.get(clickedItemIndex));
       context.startActivity(intent);
    }
    //endregion
}
