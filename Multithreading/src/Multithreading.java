public class Multithreading {

    public static void main(String[] args) throws InterruptedException {

        //--------------------Homework---------------------------

        Counter counter = new Counter();

        Thread threadIncrement = new Thread(() -> {
            System.out.println(counter.increment());
        });

        Thread threadDecrement = new Thread(() -> {
            System.out.println(counter.decrement());
        });

        threadIncrement.start();
        threadIncrement.join();
        threadDecrement.start();
        threadDecrement.join();

        System.out.println(counter.getCount());

    }
}

class Counter {
    private int count;
    public synchronized int increment(){
        return count++;
    }
    public synchronized int decrement(){
        return count--;
    }

    public int getCount() {
        return count;
    }
}

