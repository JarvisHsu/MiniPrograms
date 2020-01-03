package 二十周Java课设.A题;

import org.omg.CORBA.Object;

/**
 * 顺序栈操作的基本实现
 *
 * @param <A>
 * @author Jarvis
 */

public class SequentialStack<A> implements StackInterface<A> {
    //成员变量实现顺序栈存储结构
    private static final int STACK_SIZE = 100;
    protected A[] stack;
    protected int top;

    //初始化
    public SequentialStack() {
        stack = (A[]) (new Object[STACK_SIZE]);
        top = -1;
    }

    //1、判空操作
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    //2、入栈操作
    @Override
    public void push(A data) {
        if (top == STACK_SIZE) {
            System.out.println("栈为满，无法入栈！");
        } else {
            stack[++top] = data;
            System.out.println("入栈操作成功！");
        }
    }

    //3、出栈操作
    @Override
    public A pop() {
        A data = null;
        if (isEmpty()) {
            System.out.println("栈为空，无法出栈！");
        } else {
            data = stack[top--];
        }
        return data;
    }

    //4、获取栈顶元素
    @Override
    public A peek() {
        A data = null;
        if(isEmpty()){
            System.out.println("栈为空，无法取栈！");
        }else{
            data = stack[top];
        }
        return data;
    }
}
