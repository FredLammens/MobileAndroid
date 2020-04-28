package android.example.project3;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements CardAdapter.CardItemClickListener {
    CardAdapter cardAdapter = new CardAdapter(this);
    ArrayList<PoolCar> poolCars;
    Context context;
    public Controller(Context context){
        this.context = context;
    }
    static final String BASE_URL = "https://datatank.stad.gent/4/";

    public void InsertPoolCars(final RecyclerView view) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PoolCarAPI poolCarAPI = retrofit.create(PoolCarAPI.class);
        Call<List<PoolCar>> call = poolCarAPI.loadPoolCars();
        call.enqueue(new Callback<List<PoolCar>>() {
            @Override
            public void onResponse(Call<List<PoolCar>> call, Response<List<PoolCar>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Post Failed", "error code :" + response.code());
                } else {
                    poolCars = (ArrayList<PoolCar>) response.body();
                    view.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                    cardAdapter.setPoolCars(poolCars);
                    RecyclerView.Adapter adapter = cardAdapter;
                    view.setLayoutManager(layoutManager);
                    view.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<PoolCar>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onCardItemClick(int clickedItemIndex) {
        Log.d("testclick","werkt");
        Intent intent = new Intent(context,CarInfo.class);
        //intent.putExtra("clickedCar", (Serializable) poolCars.get(clickedItemIndex));
        context.startActivity(intent);
    }
}
