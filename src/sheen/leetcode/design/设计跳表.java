package sheen.leetcode.design;

import java.util.*;

/**
 * @Classname 设计跳表
 * @Date 2022/7/26 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 设计跳表 {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        /*String[] op = extract("[\"Skiplist\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"search\",\"add\",\"erase\",\"search\",\"erase\",\"search\",\"erase\",\"erase\",\"erase\",\"add\",\"erase\",\"add\",\"search\",\"erase\",\"search\",\"add\",\"erase\",\"erase\",\"erase\",\"add\",\"erase\",\"erase\",\"add\",\"erase\",\"add\",\"erase\",\"search\",\"erase\",\"search\",\"search\",\"erase\",\"search\",\"search\",\"add\",\"erase\",\"search\",\"search\",\"erase\",\"search\",\"add\",\"add\",\"search\",\"erase\",\"search\",\"search\",\"search\",\"add\",\"search\",\"add\",\"add\",\"add\",\"add\",\"search\",\"erase\",\"add\",\"search\",\"add\",\"search\",\"erase\",\"add\",\"add\",\"add\",\"erase\",\"search\",\"search\",\"search\",\"add\",\"add\",\"erase\",\"add\",\"erase\",\"add\",\"search\",\"add\",\"search\",\"search\",\"search\",\"search\",\"erase\",\"add\",\"erase\",\"search\",\"search\",\"search\",\"search\",\"erase\",\"search\",\"erase\",\"add\",\"add\",\"add\",\"search\",\"erase\",\"search\",\"search\",\"add\",\"add\",\"erase\",\"add\",\"erase\",\"search\",\"erase\",\"search\",\"erase\",\"add\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\"]");
        String[] v = extract("[[],[22],[25],[0],[11],[8],[1],[22],[3],[26],[15],[14],[3],[28],[17],[26],[21],[20],[11],[2],[17],[14],[9],[24],[13],[10],[29],[4],[25],[28],[7],[8],[29],[2],[9],[0],[23],[2],[3],[6],[9],[26],[1],[18],[13],[0],[15],[18],[7],[2],[9],[22],[1],[12],[13],[12],[15],[4],[19],[14],[21],[6],[3],[8],[1],[24],[1],[26],[27],[0],[21],[16],[27],[22],[23],[28],[5],[2],[9],[16],[1],[16],[23],[8],[5],[6],[19],[6],[27],[0],[21],[26],[5],[14],[25],[24],[21],[4],[21],[28],[25],[28],[23],[8],[27],[24],[1],[8],[17],[4],[21],[4],[19],[8],[23],[4],[11],[22],[25],[6],[9],[28],[11],[8],[25],[6],[5],[18],[29],[20],[15],[2],[3],[26],[15],[6]]");
        String[] res = extract("[null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,null,true,false,true,true,false,false,false,null,false,null,true,true,false,null,false,false,false,null,false,false,null,false,null,true,true,false,false,true,true,false,false,null,true,true,true,false,false,null,null,true,false,true,false,false,null,true,null,null,null,null,false,true,null,false,null,true,false,null,null,null,false,false,true,false,null,null,true,null,false,null,true,null,true,true,false,true,true,null,true,true,false,true,false,true,true,true,null,null,null,true,false,true,false,null,null,true,null,true,false,true,false,true,null,false,false,true,false,true,false,false,false,true,true,true,true,true,true,true]");
        for(int i = 1; i < op.length; i++) {
            process(op[i], v[i], res[i], skiplist);
            skiplist.print();
        }*/
        build(skiplist);
        skiplist.add(3);
        skiplist.print();
        /*skiplist.add(22);
        skiplist.add(25);
        skiplist.add(0);
        skiplist.add(11);
        skiplist.add(8);
        skiplist.add(1);
        skiplist.add(22);
        skiplist.add(3);
        skiplist.add(26);
        skiplist.print();
        skiplist.add(15);
        skiplist.print();*/
    }
    public static void process(String op, String v, String r,  Skiplist skiplist) {
        System.out.println(op + " " + v);
        String realR = "null";
        switch (op) {
            case "add": skiplist.add(Integer.valueOf(v)); break;
            case "erase": realR = String.valueOf(skiplist.erase(Integer.valueOf(v))); break;
            case "search": realR = String.valueOf(skiplist.search(Integer.valueOf(v))); break;
        }
        if(!realR.equals(r)) {
            System.out.println("error，" + r + ":" + realR);
        }
    }

    public static String[] extract(String line) {
        line = line.replace("[", "");
        line = line.replace("]", "");
        line = line.replace("\"", "");
        return line.split(",");
    }

    public static void build(Skiplist skiplist) {
        Skiplist.Item _0 = new Skiplist.Item();
        _0.val = 0;
        Skiplist.Item _1 = new Skiplist.Item();
        _1.val = 1;
        Skiplist.Item _8 = new Skiplist.Item();
        _8.val = 8;
        Skiplist.Item _11 = new Skiplist.Item();
        _11.val = 11;
        Skiplist.Item _22 = new Skiplist.Item();
        _22.val = 22;
        Skiplist.Item _25 = new Skiplist.Item();
        _25.val = 25;

        _0.floor = new Skiplist.Item[]{_1,_8,_8,_8,_8,_8,_8,_8,_11,_11,_11,_11,_11,_11,_11,_22};
        _1.floor = new Skiplist.Item[]{_8};
        _8.floor = new Skiplist.Item[]{_11,_11,_11,_11,_11,_11,_11,_11};
        _11.floor = new Skiplist.Item[]{_22,_22,_22,_22,_22,_22,_22,_22,_22,_22,_22,_22,_22,_22,_22};
        _22.floor = new Skiplist.Item[]{_25,_25,_25,null,null,null,null,null,null,null,null,null,null,null,null,null};
        _25.floor = new Skiplist.Item[]{null,null,null};
        skiplist.root = _0;
        skiplist.map.put(0, 1);
        skiplist.map.put(1, 1);
        skiplist.map.put(8, 1);
        skiplist.map.put(11, 1);
        skiplist.map.put(22, 1);
        skiplist.map.put(25, 1);
    }

    static class Skiplist {

        private static final int SIZE = 16;
        private Item root;
        private Map<Integer, Integer> map = new HashMap<>();
        private Random random = new Random();
        public Skiplist() {

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

        public void print() {
            Item node = this.root;
            while (node != null) {
                String res = node.val + "=";
                int i = 0;
                while (i < node.floor.length) {
                    res += (node.floor[i] == null ? "null" : node.floor[i].val) + ",";
                    i++;
                }
                System.out.println(res);
                node = node.floor[0];
            }
        }

    }
}

