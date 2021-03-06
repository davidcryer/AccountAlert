package com.davidcryer.accountalert.addaccount;

import com.davidc.uiwrapper.UiModel;

public interface AddAccountUiModel extends UiModel<AddAccountUi> {
    void dismiss(AddAccountUi ui);
    void title(AddAccountUi ui, String error);
    void expiry(AddAccountUi ui, String error);
    void generic(AddAccountUi ui, String error);
}
