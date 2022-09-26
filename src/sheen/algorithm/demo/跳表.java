package sheen.algorithm.demo;

import java.util.Random;

/**
 * @Classname 跳表
 * @Date 2022/7/26 3:28 下午
 * @Created by sheen
 * @Description TODO
 */
public class 跳表 {
    private static final int SIZE = 16;
    private Item root;
    private Random random = new Random();
    public 跳表() {

    }

    public boolean search(int target) {
        return find(target, this.root.floor.length - 1, this.root) != null;
    }

    private Item find(int target, int index, Item item) {
        if(item.val == target) {
            return item;
        }

        while (index > 0 && item.floor[index] == null) {
            index --;
        }

        if(index == 0 && item.floor[index] == null) {
            return null;
        }

        while (index > 0 && item.floor[index].val > target) {
            index--;
        }

        if(item.floor[index].val > target) {
            return null;
        }else {
            return find(target, index, item.floor[index]);
        }
    }

    public void add(int num) {
        if(root == null) {
            root = new Item();
            root.floor = new Item[SIZE];
            root.val = num;
            return;
        }
        if(this.root.val > num) {
            Item newItem = new Item();
            newItem.floor = new Item[this.root.floor.length];
            newItem.val = num;
            for(int i = this.root.floor.length - 1; i >= 0; i--) {
                newItem.floor[i] = this.root;
            }
            this.root = newItem;
            return;
        }

        Item ans = find(num, this.root.floor.length - 1, this.root);
        if(ans == null) {
            insert(num, this.root.floor.length - 1, this.root);
        }else {
            ans.count += 1;
        }
    }

    private Item insert(int val, int index, Item item) {
        Item[] floor = item.floor;
        int end = index;
        while (index > 0 && floor[index] == null) {
            index--;
        }
        if(index == 0 && floor[index] == null) {
            int newSize = random.nextInt(SIZE) + 1;
            Item newItem = new Item();
            newItem.val = val;
            newItem.floor = new Item[newSize];
            for(int i = Math.min(newSize - 1, end); i >= 0; i--) {
                item.floor[i] = newItem;
            }
            return newItem;
        }

        if(floor[index].val < val) {
            return processInsert(val, index, end, item);
        }
        while (index > 0 && floor[index].val > val) {
            index--;
        }

        if(index == 0 && floor[index].val > val) {
            int newSize = random.nextInt(SIZE) + 1;
            Item newItem = new Item();
            newItem.val = val;
            newItem.floor = new Item[newSize];
            for(int i = Math.min(newSize - 1, end); i >= 0; i--) {
                Item z = item.floor[i];
                item.floor[i] = newItem;
                newItem.floor[i] = z;
            }
            return newItem;
        }

        return processInsert(val, index, end, item);
    }

    private Item processInsert(int val, int start, int end, Item item) {
        Item newItem = insert(val, start, item.floor[start]);
        for(int i = start + 1; i < Math.min(newItem.floor.length, end + 1); i++) {
            Item copy = item.floor[i];
            item.floor[i] = newItem;
            newItem.floor[i] = copy;
        }
        return newItem;
    }

    public boolean erase(int num) {
        Item ans = find(num, this.root.floor.length - 1, this.root);
        if(ans == null) {
            return false;
        }

        ans.count -= 1;
        if(ans.count == 0) {
            if(num == root.val) {
                this.root = this.root.floor[0];
            }else {
                delete(num, this.root.floor.length - 1, this.root);
            }
        }

        return true;
    }

    private void delete(int val, int index, Item item) {
        if(item == null) {
            return;
        }

        Item[] floor = item.floor;
        while (index >= 0 && (floor[index] == null || floor[index].val >= val) ) {
            if(floor[index] != null && floor[index].val == val) {
                item.floor[index] = floor[index].floor[index];
            }
            index--;
        }
        if(index < 0) {
            return;
        }
        delete(val, index, floor[index]);
    }

    private static class Item{
        private Item[] floor;
        private int val;
        private int count = 1;
    }

}
