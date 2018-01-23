package com.davidcryer.accountreminder.addaccount;

import com.davidc.uiwrapper.UiModel;

public interface AddAccountUiModel extends UiModel<AddAccountUi> {
    void dismiss(AddAccountUi ui);
    void title(AddAccountUi ui, String error);
    void description(AddAccountUi ui, String error);
    void nextNotification(AddAccountUi ui, String error);
    void generic(AddAccountUi ui, String error);
}
