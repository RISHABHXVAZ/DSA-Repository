class Foo {
    ReentrantLock lock;
    Condition condition;
    int turn;
    public Foo() {
       lock = new ReentrantLock();
       condition = lock.newCondition();
       turn = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            printFirst.run();
            turn = 1;
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(turn != 1){
                condition.await();
            }
            printSecond.run();
            turn = 2;
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        lock.lock();
        try{
            while(turn != 2){
                condition.await();
            }
            printThird.run();
            turn = 3;
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }
}