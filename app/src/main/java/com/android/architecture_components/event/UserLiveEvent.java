package com.android.architecture_components.event;

public class UserLiveEvent extends LiveEvent<UserEvent> {

    public static UserLiveEvent create() {
        return new UserLiveEvent();
    }
}
