package android.example.opdracht2;


import android.util.Log;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller{

    static final String BASE_URL = "https://datatank.stad.gent/4/";

    public static void InsertPoolCar(final TextView view){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PoolCarAPI poolCarAPI = retrofit.create(PoolCarAPI.class);
        Call<List<PoolCar>> call = poolCarAPI.loadPoolCars();
        call.enqueue(new Callback<List<PoolCar>>(){
            @Override
            public void onResponse(Call<List<PoolCar>> call, Response<List<PoolCar>> response) {
                if(!response.isSuccessful()){
                    Log.e("Post Failed","error code :" + response.code());
                }else {
                    List<PoolCar> PoolCars = response.body();
                    String content = "";
                    content += PoolCars.get(0).getVehicleInformation().getBrand() + "\n";
                    content += PoolCars.get(0).getVehicleInformation().getModel() + "\n";
                    content += PoolCars.get(0).getVehicleInformation().getFuelType() + "\n";
                    view.setText(content);
                }
            }
            @Override
            public void onFailure(Call<List<PoolCar>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
