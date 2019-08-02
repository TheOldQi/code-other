package com.concurrent.art.basic.communicate;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * <P>Description: 利用管道进行线程间通信，和普通的基于文件和基于网络的输入输出流不同，管道直接调用内存资源. </P>
 * <p>PipedOutputStream、PipedInputStream、PipedReader和PipedWriter</p>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class Pipe {

    public static void main(String[] args) throws IOException {
        PipedWriter pw = new PipedWriter();
        PipedReader pr = new PipedReader();
        pw.connect(pr);
        Thread t = new Thread(new Printer(pr), "Thread - Printer");
        t.start();
        int receive;
        try {
            while (-1 != (receive = System.in.read())) {
                pw.write(receive);
            }

        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    static class Printer implements Runnable {
        PipedReader pr;

        Printer(PipedReader pr) {
            this.pr = pr;
        }

        @Override
        public void run() {
            int receive;
            try {
                while (-1 != (receive = pr.read())) {
                    System.out.println(Thread.currentThread().getName() + "receive:" + (char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (pr != null) {
                    try {
                        pr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
