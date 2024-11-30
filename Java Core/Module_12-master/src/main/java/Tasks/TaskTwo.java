package Tasks;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class TaskTwo {
    int value = 16;
    int count = 1;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void printNumber() {
        lock.lock();
        try {
            while (count <= value) {
                if (count % 3 != 0 && count % 5 != 0) {
                    System.out.print(count + ", ");
                    count++;
                    condition.signalAll();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printFizz() {
        lock.lock();
        try {
            while (count <= value) {
                if (count % 3 == 0 && count % 5 != 0) {
                    System.out.print("fizz, ");
                    count++;
                    condition.signalAll();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printBuzz() {
        lock.lock();
        try {
            while (count <= value) {
                if (count % 5 == 0 && count % 3 != 0){
                    System.out.print("buzz, ");
                    count++;
                    condition.signalAll();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printFizzBuzz() {
        lock.lock();
        try {
            while (count <= value) {
                if (count % 5 == 0 && count % 3 == 0) {
                    System.out.print("fizzbuzz, ");
                    count++;
                    condition.signalAll();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TaskTwo taskTwo = new TaskTwo();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(taskTwo::printNumber);
        executorService.submit(taskTwo::printFizz);
        executorService.submit(taskTwo::printBuzz);
        executorService.submit(taskTwo::printFizzBuzz);

        executorService.shutdown();
    }
}

