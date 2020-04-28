package android.example.project3;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PoolCar implements Parcelable {
    //region properties
    @SerializedName("vehicleInformation")
    VehicleInformation vehicleInformation;
    @SerializedName("displayName")
    String displayName;

    //endregion
    //region constructor
    public PoolCar(VehicleInformation vehicleInformation) {
        this.vehicleInformation = vehicleInformation;
    }

    //endregion constructor
    //region getter
    public VehicleInformation getVehicleInformation() {
        return vehicleInformation;
    }

    //endregion
    //region parcelable
    protected PoolCar(Parcel in) {
        vehicleInformation = in.readParcelable(VehicleInformation.class.getClassLoader());
        displayName = in.readString();
    }

    public static final Creator<PoolCar> CREATOR = new Creator<PoolCar>() {
        @Override
        public PoolCar createFromParcel(Parcel in) {
            return new PoolCar(in);
        }

        @Override
        public PoolCar[] newArray(int size) {
            return new PoolCar[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(vehicleInformation, flags);
        dest.writeString(displayName);
    }
    //endregion
}
