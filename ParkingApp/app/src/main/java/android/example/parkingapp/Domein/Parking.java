package android.example.parkingapp.Domein;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Parking implements Parcelable {
    //region properties
    @SerializedName("name")
    private String fullname; // niet zelfde naam als json file => serialized boven zetten .
    @SerializedName("description")
    private String name;
    private String address;
    private String contactInfo;
    private Status parkingStatus;
    //endregion
    //region constructor
    public Parking(String fullname, String name, String address, String contactInfo, Status parkingStatus) {
        this.fullname = fullname;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.parkingStatus = parkingStatus;
    }

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
    //region parcelable
    protected Parking(Parcel in) {
        fullname = in.readString();
        name = in.readString();
        address = in.readString();
        contactInfo = in.readString();
        parkingStatus = in.readParcelable(Status.class.getClassLoader());
    }

    public static final Creator<Parking> CREATOR = new Creator<Parking>() {
        @Override
        public Parking createFromParcel(Parcel in) {
            return new Parking(in);
        }

        @Override
        public Parking[] newArray(int size) {
            return new Parking[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullname);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(contactInfo);
        dest.writeParcelable(parkingStatus, flags);
    }

    //endregion

}
