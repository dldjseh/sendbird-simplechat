package com.android.architecture_components.worker;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Message;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.UserMessage;

import io.reactivex.subjects.PublishSubject;

public class SendMessageWorker extends GetChannelWorker {

    public final static String MESSAGE_KEY = "message";

    @Override
    protected void handleResult(OpenChannel openChannel) {
        final PublishSubject<UserMessage> publishSubject = PublishSubject.create();

        openChannel.sendUserMessage(getString(MESSAGE_KEY), new BaseChannel.SendUserMessageHandler() {
            @Override
            public void onSent(UserMessage userMessage, SendBirdException e) {
                publishSubject.onNext(userMessage);
            }
        });

        ChatDatabase.getInstance(getApplicationContext()).getMessageDao()
                .save(Message.create(publishSubject.blockingFirst()));
    }
}
