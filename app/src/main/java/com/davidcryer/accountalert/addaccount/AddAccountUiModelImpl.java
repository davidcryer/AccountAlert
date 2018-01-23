package com.davidcryer.accountalert.addaccount;

import android.os.Parcel;
import android.support.annotation.NonNull;

public class AddAccountUiModelImpl implements AddAccountUiModel {
    private String titleError;
    private String descriptionError;
    private String nextNotificationError;
    private String genericError;
    private boolean dismiss;

    public AddAccountUiModelImpl() {
        this.titleError = "";
        this.descriptionError = "";
        this.nextNotificationError = "";
        this.genericError = "";
        this.dismiss = false;
    }

    @Override
    public void dismiss(AddAccountUi ui) {
        if (ui != null) {
            ui.dismiss();
        }
        this.dismiss = true;
    }

    @Override
    public void title(AddAccountUi ui, String error) {
        if (ui != null) {
            ui.titleError(error);
        }
        this.titleError = error;
    }

    @Override
    public void description(AddAccountUi ui, String error) {
        if (ui != null) {
            ui.descriptionError(error);
        }
        this.descriptionError = error;
    }

    @Override
    public void nextNotification(AddAccountUi ui, String error) {
        if (ui != null) {
            ui.nextNotificationError(error);
        }
        this.nextNotificationError = error;
    }

    @Override
    public void generic(AddAccountUi ui, String error) {
        if (ui != null) {
            ui.genericError(error);
        }
        this.genericError = error;
    }

    @Override
    public void onto(@NonNull AddAccountUi ui) {
        ui.titleError(titleError);
        ui.descriptionError(descriptionError);
        ui.nextNotificationError(nextNotificationError);
        ui.genericError(genericError);
        if (dismiss) {
            ui.dismiss();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleError);
        dest.writeString(this.descriptionError);
        dest.writeString(this.nextNotificationError);
    }

    private AddAccountUiModelImpl(Parcel in) {
        this.titleError = in.readString();
        this.descriptionError = in.readString();
        this.nextNotificationError = in.readString();
    }

    public static final Creator<AddAccountUiModelImpl> CREATOR = new Creator<AddAccountUiModelImpl>() {
        @Override
        public AddAccountUiModelImpl createFromParcel(Parcel source) {
            return new AddAccountUiModelImpl(source);
        }

        @Override
        public AddAccountUiModelImpl[] newArray(int size) {
            return new AddAccountUiModelImpl[size];
        }
    };
}
