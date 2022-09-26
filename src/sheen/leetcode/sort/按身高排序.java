package sheen.leetcode.sort;

/**
 * @Classname 按身高排序
 * @Date 2022/9/25 11:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 按身高排序 {
    public String[] sortPeople(String[] names, int[] heights) {
        sort(names, heights, 0, names.length - 1);
        return names;
    }

    public void sort(String[] names, int[] heights, int left, int right) {
        if(left >= right) return;
        int begin = left;
        int end = right;
        String name = names[left];
        int height = heights[left];
        while (begin < end) {
            while (begin < end && height >= heights[end]) end--;
            heights[begin] = heights[end];
            names[begin] = names[end];
            while (begin < end && heights[begin] >= height) begin++;
            heights[end] = heights[begin];
            names[end] = names[begin];
        }
        heights[begin] = height;
        names[begin] = name;
        sort(names, heights, left, begin - 1);
        sort(names, heights, begin + 1, right);
    }
}
