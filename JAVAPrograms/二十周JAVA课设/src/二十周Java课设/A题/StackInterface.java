package 二十周Java课设.A题;

/**
 * 泛型接口，栈的基本四种方法。判空isEmpty()、进栈push()、出栈pop()、取栈顶元素peek()
 *
 * @param <A>
 * @author Jarvis
 */
public interface StackInterface<A> {
    //判空isEmpty
    public boolean isEmpty();

    //进栈push
    public void push(A data);

    //出栈pop,(要删除当前元素后返回)
    public A pop();

    //取栈顶元素peek()
    public A peek();
}
