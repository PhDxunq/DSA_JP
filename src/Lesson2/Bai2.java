package Lesson2;

import java.util.LinkedList;
import java.util.Queue;

public class Bai2 {
    public static void main(String[] args) {
        Queue<String> newQueue = new LinkedList<>();
        // Enqueue new task
        newQueue.add("Tac vu dau tien.");
        newQueue.add("Tac vu thu 2.");
        newQueue.add("Tac vu thu 3.");
        // Dequeue
        System.out.println(newQueue.poll());
        System.out.println(newQueue.peek());
        System.out.println("Các phần tử còn lại trong queue:");
        for (String element : newQueue) {
            System.out.println(element);
        }
    }
}
