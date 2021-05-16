package com.cloud.datastructyres.queue;

import java.util.Scanner;

/**
 * 使用数组模拟队列
 */
public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.showQueue();
                    break;
                case 'a': // 添加数据
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看头数据
                    try {
                        int res = arrayQueue.headQueue();
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
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 模拟队列的数组

    private ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1; // 指向队列头部，指向第一个元素前一个的位置
        rear = -1; // 指向队列尾，指向最后一个元素的位置
    }

    /**
     * 判断队列是否满
     */
    private boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = n;
    }

    /**
     * 取数据到队列
     */
    private int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        front++;
        return arr[front];
    }

    /**
     * 展示队列数据
     */
    private void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 展示队列头数据
     */
    private int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front + 1];
    }
}
