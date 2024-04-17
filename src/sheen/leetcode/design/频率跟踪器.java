package sheen.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 频率跟踪器
 * @Date 2024/3/21 00:02
 * @Created by sheen
 * @Description TODO
 */
public class 频率跟踪器 {
    static class FrequencyTracker {

        private Map<Integer, Integer> count = new HashMap<>();
        private Map<Integer, Integer> fruCount = new HashMap<>();
        public FrequencyTracker() {

        }

        public void add(int number) {
            if(!count.containsKey(number)) {
                count.put(number, 1);
                fruCount.put(1, fruCount.getOrDefault(1, 0) + 1);
            }else {
                int oldCount = count.get(number);
                int newCount = oldCount + 1;
                count.put(number, newCount);
                fruCount.put(newCount, fruCount.getOrDefault(newCount, 0) + 1);
                fruCount.put(oldCount, fruCount.getOrDefault(oldCount, 0) - 1);
                if(fruCount.get(oldCount) == 0) {
                    fruCount.remove(oldCount);
                }
            }
        }

        public void deleteOne(int number) {
            if(count.containsKey(number)) {
                int oldCount = count.get(number);
                int newCount = oldCount - 1;

                count.put(number, newCount);
                if(newCount == 0) {
                    count.remove(number);
                }


                fruCount.put(newCount, fruCount.getOrDefault(newCount, 0) + 1);
                fruCount.put(oldCount, fruCount.get(oldCount) - 1);
                if(fruCount.get(oldCount) == 0) {
                    fruCount.remove(oldCount);
                }


            }
        }

        public boolean hasFrequency(int frequency) {
            return fruCount.containsKey(frequency) && fruCount.get(frequency) > 0;
        }
    }
}
