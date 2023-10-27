package org.example;

import java.util.Queue;
import java.util.LinkedList;


interface MarketBehavior {
    void placeOrder(Order order);

    Order takeOrder();

    boolean hasOrder();
}

class Market implements QueueBehaviour, MarketBehavior {
    private Queue queue;
    private Queue orders;

    public Market() {
        queue =new LinkedList();

        orders =new LinkedList();
    }
    public String toString(Object kaa){
        return String.valueOf(kaa);
    }



    @Override
    public void enqueue(Person person) {
        queue.add(person);
    }

    @Override
    public Person dequeue() {
        return (Person) queue.poll();
    }

    @Override
    public Object dequeue(Person person) {
        return queue.poll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void placeOrder(Order order) {
        orders.add(order);
    }

    @Override
    public Order takeOrder() {
        return (Order) orders.poll();
    }

    @Override
    public boolean hasOrder() {
        return !orders.isEmpty();
    }




    public void update() {
        if (hasOrder()) {
            Order order = takeOrder();
            System.out.println("Заказ обработан: " + order.toString());
        } else {
            System.out.println("Заказов нету");
        }
    }



}



public class Main{
            public static void main(String[] args){
                Market market = new Market();

                Person person1 = new Person("Иван");
                Person person2 = new Person("Матвей");
                Person person3 = new Person("Андрей");

                market.enqueue(person1);
                market.enqueue(person2);
                market.enqueue(person3);

                System.out.println("Размер очереди: " + market.size());
                System.out.println("Первый человек в очереди: " + market.dequeue());
                System.out.println("РАзмер очереди после удаления: "+ market.size());

                Order order1 = new Order("Заказ 1");
                Order order2 = new Order("Заказ 2");
                Order order3 = new Order("Заказ 3");

                market.placeOrder(order1);
                market.placeOrder(order2);
                market.placeOrder(order3);

                market.update();
                market.update();
                market.update();

            }
}
