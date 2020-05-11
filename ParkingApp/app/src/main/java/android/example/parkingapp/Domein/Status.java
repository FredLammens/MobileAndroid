package android.example.parkingapp.Domein;

import android.os.Parcel;
import android.os.Parcelable;

public class Status implements Parcelable {
    //region properties
    private int availableCapacity;
    private int totalCapacity;
    //endregion
    //region constructor

    public Status(int availableCapacity, int totalCapacity) {
        this.availableCapacity = availableCapacity;
        this.totalCapacity = totalCapacity;
    }

    //endregion
    //region getters
    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }
    ///endregion
    //region parcelable
    protected Status(Parcel in) {
        availableCapacity = in.readInt();
        totalCapacity = in.readInt();
    }

    public static final Creator<Status> CREATOR = new Creator<Status>() {
        @Override
        public Status createFromParcel(Parcel in) {
            return new Status(in);
        }

        @Override
        public Status[] newArray(int size) {
            return new Status[size];
        }
    };
    //Creator field
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(availableCapacity);
        dest.writeInt(totalCapacity);
    }

    //endregion
}
