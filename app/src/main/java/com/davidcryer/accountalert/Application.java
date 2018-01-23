package com.davidcryer.accountalert;

import com.davidc.uiwrapper.UiWrapperFactoryProvider;
import com.davidcryer.accountalert.common.framework.uiwrapper.UiWrapperFactory;

public class Application extends android.app.Application implements UiWrapperFactoryProvider<UiWrapperFactory> {
    private UiWrapperFactory uiWrapperFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        uiWrapperFactory = AppDependencies.uiWrapperFactory();
    }

    @Override
    public UiWrapperFactory getUiWrapperFactory() {
        return uiWrapperFactory;
    }
}
