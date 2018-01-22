package com.davidcryer.accountreminder;

import com.davidc.uiwrapper.UiWrapperFactoryProvider;
import com.davidcryer.accountreminder.common.framework.uiwrapper.UiWrapperFactory;

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
