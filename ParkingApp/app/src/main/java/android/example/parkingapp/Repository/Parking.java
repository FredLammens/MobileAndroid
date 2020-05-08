package android.example.parkingapp.Repository;

import com.google.gson.annotations.SerializedName;

public class Parking {
    //region properties
    @SerializedName("name")
    private String fullname; // niet zelfde naam als json file => serialized boven zetten .
    @SerializedName("description")
    private String name;
    private String address;
    private String contactInfo;
    private Status parkingStatus;
    //endregion
    //region getters
    public String getFullname() {
        return fullname;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public Status getParkingStatus() {
        return parkingStatus;
    }
    //endregion

}
