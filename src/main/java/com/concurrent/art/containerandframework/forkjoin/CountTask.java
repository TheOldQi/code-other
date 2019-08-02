package com.concurrent.art.containerandframework.forkjoin;

import com.concurrent.art.basic.communicate.ThreadClock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * <P>Description: ForkJoin示例，计算多个连续数字相加的和，因为是有结果的，
 * 所以继承RecurisiveTask，如果是不需要结果的任务，继承RecursiveAction. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2018/1/5</P>
 * <P>UPDATE DATE: 2018/1/5</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class CountTask extends RecursiveTask<Integer> {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        // 生成计算任务
        ThreadClock.begin();
        CountTask task = new CountTask(1, Integer.MAX_VALUE >>> 1);
        final ForkJoinTask<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        int sum = 0;
//        for (int i = 1, len = Integer.MAX_VALUE >>> 1; i <= len; i++) {
//            sum += Math.sqrt(i);
//        }
//        System.out.println(sum);
        System.out.println(ThreadClock.stop());

    }

    private static final long serialVersionUID = -175291797269861079L;
    /**
     * 分割任务的阀值，大于这个值才会被分割.
     */
    private static int THRESHOLD = Integer.MAX_VALUE >>> 3;

    /**
     *
     */
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;

    }

    /**
     * 对任务进行分割，每次最多将一个任务或子任务分割成两份，直到所有子任务的大小都不大于阀值.
     * 然后异步对每个子任务进行计算，最后合并结果.
     *
     * @return 计算结果
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        // 如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            System.out.println("start=" + start + ",end=" + end);
            for (int i = start; i <= end; i++) {
                sum += Math.sqrt(i);
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

}
