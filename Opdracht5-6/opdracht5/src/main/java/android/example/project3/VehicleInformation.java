package android.example.project3;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class VehicleInformation implements Parcelable {
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
    //region default constructor
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
    //region parcelable
    protected VehicleInformation(Parcel in) {
        brand = in.readString();
        model = in.readString();
        fuelType = in.readString();
        transmissionType = in.readString();
    }

    public static final Creator<VehicleInformation> CREATOR = new Creator<VehicleInformation>() {
        @Override
        public VehicleInformation createFromParcel(Parcel in) {
            return new VehicleInformation(in);
        }

        @Override
        public VehicleInformation[] newArray(int size) {
            return new VehicleInformation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeString(model);
        dest.writeString(fuelType);
        dest.writeString(transmissionType);
    }
    //endregion
}
