package sheen.leetcode.array;

public class 三合一 {
    public static void main(String[] args) {
        TripleInOne s = new TripleInOne(1);
        s.push(0 ,1);
        s.push(0, 2);

    }
    static class TripleInOne {
        private int arr[];
        private int stack[];
        private int stackSize;
        public TripleInOne(int stackSize) {
            this.arr = new int[stackSize*3];
            this.stack = new int[]{-1, stackSize-1, 2*stackSize-1};
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            if(stack[stackNum] +1 == (stackNum+1)*stackSize) return;
            stack[stackNum]++;
            arr[stack[stackNum]] = value;
        }

        public int pop(int stackNum) {
            if(stack[stackNum] == stackNum*stackSize -1) return -1;
            int res = arr[stack[stackNum]];
            stack[stackNum] --;
            return res;
        }

        public int peek(int stackNum) {
            if(stack[stackNum] == stackNum *stackSize -1) return -1;
            return arr[stack[stackNum]];
        }

        public boolean isEmpty(int stackNum) {
            return stack[stackNum] == stackNum *stackSize-1;
        }
    }
}
