package sheen.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 动物收容所 {
    class AnimalShelf {

        private int index = 0;
        private Queue<int[]> cat = new LinkedList<>();
        private Queue<int[]> dog = new LinkedList<>();
        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            switch (animal[1]) {
                case 0: {
                    cat.offer(new int[]{index++, animal[0]});
                    break;
                }
                case 1:{
                    dog.offer(new int[]{index++, animal[0]});
                    break;
                }
            }
        }

        public int[] dequeueAny() {
            if(dog.isEmpty() && cat.isEmpty()) {
                return new int[]{-1,-1};
            }else if(dog.isEmpty()) {
                int [] res = cat.poll();
                return new int[]{res[1], 0};
            }else if(cat.isEmpty()) {
                int [] res = dog.poll();
                return new int[]{res[1], 1};
            }else {
                if(dog.peek()[0] > cat.peek()[0]) {
                    int [] res = cat.poll();
                    return new int[]{res[1], 0};
                }else {
                    int [] res = dog.poll();
                    return new int[]{res[1], 1};
                }
            }
        }

        public int[] dequeueDog() {
            if(dog.isEmpty()) return new int[]{-1, -1};
            int [] res = dog.poll();
            return new int[]{res[1], 1};
        }

        public int[] dequeueCat() {
            if(cat.isEmpty()) return new int[]{-1, -1};
            int [] res = cat.poll();
            return new int[]{res[1], 0};
        }
    }
}
