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
    public void setPoolCars(ArrayList<PoolCar> poolCars) {
        this.poolCars = poolCars;
    }

    ArrayList<PoolCar> poolCars;
    private CardItemClickListener onCardItemListener;
    public CardAdapter(CardItemClickListener listener) {
        this.onCardItemListener = listener;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView logo;
        public TextView carBrand;
        public TextView carModel;
        CardItemClickListener onCardListener;
        public CardViewHolder(@NonNull View itemView, CardItemClickListener listener) {
            super(itemView);
            logo = itemView.findViewById(R.id.imView);
            carBrand = itemView.findViewById(R.id.carBrand);
            carModel = itemView.findViewById(R.id.carModel);
            onCardListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCardListener.onCardItemClick(getAdapterPosition());
        }
    }
    public interface CardItemClickListener{
        void onCardItemClick(int clickedItemIndex);
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        CardViewHolder evh = new CardViewHolder(v,onCardItemListener);
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
