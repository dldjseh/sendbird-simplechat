package com.android.architecture_components.worker;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Message;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.PreviousMessageListQuery;
import com.sendbird.android.SendBirdException;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class LoadMessagesWorker extends GetChannelWorker {

    @Override
    protected void handleResult(OpenChannel openChannel) {
        final PublishSubject<List<BaseMessage>> publishSubject = PublishSubject.create();

        openChannel.createPreviousMessageListQuery().load(30, false, new PreviousMessageListQuery.MessageListQueryResult() {
            @Override
            public void onResult(List<BaseMessage> list, SendBirdException e) {
                publishSubject.onNext(list);
            }
        });

        ChatDatabase.getInstance(getApplicationContext()).getMessageDao()
                .save(Message.create(publishSubject.blockingFirst()));
    }
}
