import java.util.*;

public class Priority_queue {
    public static void main(String[] args) {
        PriorityQueue p=new PriorityQueue<>(Collections.reverseOrder()); // works as max heap
        p.add(10);
        p.add(6);
        p.add(11);
        p.add(20);
        System.out.println(p.peek());
        System.out.println(p);

    }
}
