package com.example.consumer.application;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Alexander Gladun on 2019-06-28.
 */
public interface StudentChannel {
    String INPUT = "input";

    @Input(StudentChannel.INPUT)
    SubscribableChannel input();
}
