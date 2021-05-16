package com.cloud.datastructyres.queue;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char key = ' '; // 接收输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("s：显示队列");
        System.out.println("e：退出队列");
        System.out.println("a：添加数据");
        System.out.println("g：获取数据");
        System.out.println("h：查看头数据");
        while (loop) {
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's': // 展示队列
                    circleArrayQueue.showQueue();
                    break;
                case 'a': // 添加数据
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circleArrayQueue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看头数据
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.printf("队列的头数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

    private int maxSize; // 数组的最大容量
    private int front; // 队列头，指向队列的第一个元素
    private int rear; // 队列尾，指向队列后一个元素
    private int[] arr; // 模拟队列的数组

    private CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否满
     */
    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    private boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据到队列
     */
    private void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取数据到队列
     */
    private int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    /**
     * 展示队列数据
     */
    private void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 虎丘队列长度
     *
     * @return 队列长度
     */
    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 展示队列头数据
     */
    private int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }
}
