package android.example.parkingapp.Repository;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParkingRepository {
    //region properties
    static final String BASE_URL = "https://datatank.stad.gent/4/";
    ArrayList<Parking> parkinglijst;
    //endregion
    //region constructor
    ParkingRepository(){
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
                parkinglijst = (ArrayList<Parking>) response.body();
            }

            @Override
            public void onFailure(Call<List<Parking>> call, Throwable t) { // when something went wrong with communication or response
                t.printStackTrace(); // print error message
            }
        });
    }
    //endregion
    //region getters
    public ArrayList<Parking> getParkinglijst() {
        return parkinglijst;
    }
    //endregion
}
