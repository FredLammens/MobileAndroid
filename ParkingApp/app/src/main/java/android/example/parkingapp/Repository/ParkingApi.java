package android.example.parkingapp.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ParkingApi // for rest api
{
    //retrofit annotation so retrofit makes all the nesecary code for the get request
    @GET("mobiliteit/bezettingparkingsrealtime.json") //relative url , base url passed in class that implements this interface
    Call<List<Parking>> getParkings();
}
