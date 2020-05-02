package com.samwei12.stack;

import java.util.Arrays;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/2 10:35 PM
 * A Stack based on Array
 */
public class ArrayStack<T> implements Stack<T> {
    private Object[] items;
    private final Integer count;
    private Integer curIndex;

    public ArrayStack(Integer count) {
        items = new Object[count];
        this.count = count;
        this.curIndex = -1;
    }

    /**
     * 获取栈顶元素
     * @return T
     */
    @Override
    public T pop() {
        T  result = (T)items[curIndex];
        items[curIndex--] = null;
        return result;
    }

    /**
     * 将元素压入栈顶
     * @param item T
     * @return 如果栈已满则报错
     */
    @Override
    public Boolean push(T item) {
        if (curIndex.equals(count-1)) {
            return false;
        }
        items[++curIndex] = item;
        return true;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
            "items=" + Arrays.toString(items) +
            ", count=" + count +
            ", curIndex=" + curIndex +
            '}';
    }
}
