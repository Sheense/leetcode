package sheen.leetcode.design;

import java.util.Iterator;

/**
 * @Classname 窥探迭代器
 * @Date 2021/10/5 1:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 窥探迭代器 {
    class PeekingIterator implements Iterator<Integer> {

        private boolean has = false;
        private Iterator<Integer> iterator;
        private int first;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if(iterator.hasNext()) {
                first = this.iterator.next();
                has = true;
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return first;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int res = first;
            if(iterator.hasNext()) {
                first = iterator.next();
            }else {
                has = false;
            }
            return res;
        }

        @Override
        public boolean hasNext() {
            return has;
        }
    }
}
