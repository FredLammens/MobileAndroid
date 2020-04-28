package android.example.project3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PoolCarAPI {
    @GET("mobiliteit/deelwagenspartago.json")
    Call<List<PoolCar>> loadPoolCars();
}
