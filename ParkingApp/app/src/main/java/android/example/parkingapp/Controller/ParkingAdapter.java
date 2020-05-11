package android.example.parkingapp.Controller;

import android.example.parkingapp.R;
import android.example.parkingapp.Domein.Parking;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.ParkingViewHolder> {
    //region viewholder
    public static class ParkingViewHolder extends ViewHolder implements View.OnClickListener { //avoids frequently calling the findviewbyid => only inflate view when none to reuse
        private Button availableSpace;
        private TextView fullname;
        OnParkingClickListener onclickListener;

        public ParkingViewHolder(@NonNull View itemView, OnParkingClickListener onclickListener) {
            super(itemView);
            availableSpace = itemView.findViewById(R.id.availableSpace);
            fullname = itemView.findViewById(R.id.fullname);
            this.onclickListener = onclickListener;
            itemView.setOnClickListener(this);
        }

        public void bindData(Parking currentParking) {
            UISetter.setupCard(currentParking,availableSpace,fullname);
        }

        @Override
        public void onClick(View v) {
            onclickListener.onParkingClick(getAdapterPosition());
        }
    }

    //endregion
    //region constructor
    // getting data for adapter
    private ArrayList<Parking> parkings;
    private OnParkingClickListener onClickListener;
    public ParkingAdapter(OnParkingClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    //endregion
    //region setter
    public void setParkings(ArrayList<Parking> parkings) {
        this.parkings = parkings;
    }
    //endregion
    //region adapter
    @NonNull
    @Override
    public ParkingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //pass layout to adapter
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.parking_item, parent, false); //instanciate layout into view
        ParkingViewHolder pvh = new ParkingViewHolder(v,onClickListener);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingViewHolder holder, int position) { // position is item in list
        //pass values to viewholder ids
        Parking currentParking = parkings.get(position); //item at position
        //pass information to view
        holder.bindData(currentParking);
    }

    @Override
    public int getItemCount() {
        return parkings.size();
    }

    //endregion
    //region interface onclick
    public interface OnParkingClickListener { //  detect click and use method to send position
        void onParkingClick(int clickedItemIndex);
    }
    //endregion
}
