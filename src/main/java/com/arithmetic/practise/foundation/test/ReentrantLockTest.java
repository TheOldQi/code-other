package com.arithmetic.practise.foundation.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {

    private static int curr = 0;
    /**
     * 公平锁
     */
    private static Lock lock = new ReentrantLock(true);

    @Override
    public void run() {

//		lock.lock();
        try {
            // 增加点儿复杂计算
            String str = "";
            for (int i = 1; i < 100; i <<= 1)
                for (int j = 0; j < i; j++)
                    str += "";

//			if (curr == 9) {
//				curr = 0;
//			} else {
//				curr++;
//			}
            curr++;
            curr--;
            System.out.println("当前值" + curr);
            if (curr != 0) {
                System.err.println("不靠谱");
                return;
            }
        } finally {
//			lock.unlock();
        }
    }

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if (i == 10000) {
                return;
            }
            Thread t = new Thread(new ReentrantLockTest());
            t.start();
            i++;
        }

    }
}
