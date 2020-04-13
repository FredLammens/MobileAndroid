package android.example.opdracht2;

import com.google.gson.annotations.SerializedName;

public class VehicleInformation {
    //region properties
    @SerializedName("brand")
    private String brand;
    @SerializedName("model")
    private String model;
    @SerializedName("fuelType")
    private String fuelType;
    @SerializedName("transmissionType")
    private String transmissionType;
    //endregion
    //region constructor
    public VehicleInformation(String brand, String model, String fuelType, String transmissionType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
    }
    //endregion
    //region getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }
    //endregion
}
