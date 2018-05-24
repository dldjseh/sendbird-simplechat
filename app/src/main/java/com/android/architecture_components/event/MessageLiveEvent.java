package com.android.architecture_components.event;

public class MessageLiveEvent extends LiveEvent<UserEvent> {

    public static MessageLiveEvent create() {
        return new MessageLiveEvent();
    }
}
