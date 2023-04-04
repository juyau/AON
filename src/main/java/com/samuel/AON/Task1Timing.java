package com.samuel.AON;

public class Task1Timing {
    public static void main(String[] args) {
        MyIncDecProxy myIncDecProxy = new MyIncDecProxy(new MyIncDec(1));
        myIncDecProxy.increment();
        myIncDecProxy.decrement();
    }

    public interface IncDec
    {
        void increment();
        void decrement();
    }

    public static class MyIncDec implements IncDec
    {
        private int x;

        public MyIncDec(int x) {
            this.x = x;
        }

        public void increment() {
            this.x++;
        }

        public void decrement() {
            this.x--;
        }
    }

    public static class MyIncDecProxy implements IncDec
    {
        private final IncDec myIncDec;

        public MyIncDecProxy(IncDec incDec) {
            this.myIncDec = incDec;
        }

        public void increment() {
            long start = System.currentTimeMillis();
            try{
                this.myIncDec.increment();
            } finally {
                System.out.println("Increment method time cost: " + (System.currentTimeMillis() - start));
            }
        }

        public void decrement() {
            long start = System.currentTimeMillis();
            try{
                this.myIncDec.decrement();;
            } finally {
                System.out.println("Decrement method time cost: " + (System.currentTimeMillis() - start));
            }
        }
    }


}
