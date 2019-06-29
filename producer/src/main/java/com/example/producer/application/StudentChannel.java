package com.example.producer.application;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Alexander Gladun on 2019-06-28.
 */
public interface StudentChannel {
    String OUTPUT = "output";

    @Output(StudentChannel.OUTPUT)
    MessageChannel output();
}
