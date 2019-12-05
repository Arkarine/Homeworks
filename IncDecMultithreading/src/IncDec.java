public class IncDec {
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
        threadDecrement.join();
        threadDecrement.start();
        System.out.println(counter.getCount());

    }
}

class Counter {
    private int count;
    public int increment(){
        return count++;
    }
    public int decrement(){
        return count--;
    }

    public int getCount() {
        return count;
    }
}
