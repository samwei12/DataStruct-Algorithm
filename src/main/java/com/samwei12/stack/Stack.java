package com.samwei12.stack;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/2 10:47 PM
 */
public interface Stack<T> {
    /**
     * 获取栈顶元素
     * @return T
     */
    T pop();

    /**
     * 将元素压入栈顶
     * @param item T
     * @return 如果栈已满则报错
     */
    Boolean push(T item);
}
