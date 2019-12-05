public class Multithreading {

    public static void main(String[] args) throws InterruptedException {

        //--------------------Homework---------------------------

        Counter counter = new Counter();

        Thread threadIncrement = new Thread(counter::increment);

        Thread threadDecrement = new Thread(counter::decrement);

        threadIncrement.start();
        threadIncrement.join();
        threadDecrement.start();
        threadDecrement.join();

        System.out.println(counter.getCount());

    }
}

class Counter {
    private int count;
    public synchronized void increment(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
    }
    public synchronized void decrement(){
        for (int i = 0; i < 100; i++) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

