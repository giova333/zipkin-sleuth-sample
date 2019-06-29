package com.example.producer.application;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Alexander Gladun on 2019-06-29.
 */

@Service
class StudentService {

    private final List<Student> storage;
    private final StudentChannel studentChannel;

    StudentService(StudentChannel studentChannel) {
        this.studentChannel = studentChannel;
        this.storage = new CopyOnWriteArrayList<>();
    }

    List<Student> getAll() {
        return storage;
    }

    void addStudent(Student student) {
        storage.add(student);
        studentChannel.output()
                .send(MessageBuilder.withPayload(student).build()
                );
    }

}
