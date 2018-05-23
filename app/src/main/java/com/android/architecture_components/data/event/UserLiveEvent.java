package com.android.architecture_components.data.event;

public class UserLiveEvent extends LiveEvent<UserEvent> {

    public static UserLiveEvent create() {
        return new UserLiveEvent();
    }
}
