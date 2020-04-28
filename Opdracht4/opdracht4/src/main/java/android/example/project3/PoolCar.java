package android.example.project3;

import com.google.gson.annotations.SerializedName;

public class PoolCar {
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
}
