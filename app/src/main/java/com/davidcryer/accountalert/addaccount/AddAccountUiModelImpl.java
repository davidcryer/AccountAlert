package com.davidcryer.accountalert.addaccount;

import android.os.Parcel;
import android.support.annotation.NonNull;

public class AddAccountUiModelImpl implements AddAccountUiModel {
    private String titleError;
    private String reminderError;
    private String genericError;
    private boolean dismiss;

    public AddAccountUiModelImpl() {
        this.titleError = "";
        this.reminderError = "";
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
    public void reminder(AddAccountUi ui, String error) {
        if (ui != null) {
            ui.reminderError(error);
        }
        this.reminderError = error;
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
        ui.reminderError(reminderError);
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
        dest.writeString(this.reminderError);
    }

    private AddAccountUiModelImpl(Parcel in) {
        this.titleError = in.readString();
        this.reminderError = in.readString();
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
