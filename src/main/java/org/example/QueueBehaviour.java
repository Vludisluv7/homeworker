package org.example;

public interface QueueBehaviour {
    void enqueue(Person person);

    Person dequeue();

    Object dequeue(Person person);

    boolean isEmpty();

    int size();
}
