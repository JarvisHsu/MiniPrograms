package 二十周Java课设.B题;

import java.util.Collection;

/**
 * 泛型实现循环队列，判空isEmpty()、进队addQueue()、出队removeQueue()、取队头元素peek()
 * @param <B>
 * @author Jarvis
 */

public interface QueueInterface<B> /*extends Collection<B>*/ {
    //判空isEmpty()
    public boolean isEmpty();

    //进队addQueue()
    public void addQueue(B data);

    //出队removeQueue()
    public B removeQueue();

    //取队头元素peek()
    public B peek();
}
