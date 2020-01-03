package 二十周Java课设.B题;

import java.util.LinkedList;
import java.util.Queue;

//
public class LoopQueue<B> implements QueueInterface<B> {
    private int head;
    private int tail;
    private B[] Queue;

    //LinkedList<B> linkedList = new LinkedList<>();
    //手动设置队列的容量
    public LoopQueue(int Capacity) {
        if (Capacity < 0) {
            Capacity = -Capacity;
        }
        Queue = (B[]) new Object[Capacity+1];
        head = 0;
        tail = 0;
    }

    //返回队列空间
    public int getCapacity() {
        return Queue.length - 1;
    }

    //队列判空
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    //入队
    @Override
    public void addQueue(B data) {
        if (((tail + 1)% Queue.length) == head) {
            System.out.println("队列已满！无法入队");
        } else {try {
            Queue[tail++] = data;
            tail = tail % Queue.length;
            System.out.println("入队成功！");
        }catch (ArrayIndexOutOfBoundsException e){
            e.getMessage();
            System.out.println("队列空间异常!");
        }

        }
    }

    //出队
    @Override
    public B removeQueue() {
        if (isEmpty()) {

        }
        B s = Queue[head];
        Queue[head] = null;
        head++;
        head = head % Queue.length;
        return s;
    }

    //获取队头元素
    @Override
    public B peek() {
        return Queue[head];
    }
}
