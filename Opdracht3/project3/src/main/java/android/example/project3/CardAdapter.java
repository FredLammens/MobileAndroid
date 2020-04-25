package android.example.project3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    ArrayList<PoolCar> poolCars;
    public CardAdapter(ArrayList<PoolCar> poolCars) {
        this.poolCars = poolCars;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public ImageView logo;
        public TextView carBrand;
        public TextView carModel;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.imView);
            carBrand = itemView.findViewById(R.id.carBrand);
            carModel = itemView.findViewById(R.id.carModel);
        }
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        CardViewHolder evh = new CardViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        PoolCar currentCar = poolCars.get(position);
        int logo;
        if (currentCar.vehicleInformation.getTransmissionType() == "automatic") {
            holder.logo.setImageResource(R.drawable.ic_automatic);
        } else {
            holder.logo.setImageResource(R.drawable.ic_manual);
        }
        holder.carBrand.setText(currentCar.vehicleInformation.getBrand());
        holder.carModel.setText(currentCar.vehicleInformation.getModel());
    }

    @Override
    public int getItemCount() {
        return poolCars.size();
    }


}
