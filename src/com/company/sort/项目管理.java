package com.company.sort;

import com.company.util.ArrayUtils;

import java.util.*;

//拓扑排序
public class 项目管理 {
    public static void main(String[] args) {
        项目管理  s = new 项目管理();
        ArrayUtils.print(s.sortItems(10,4, new int[]{0,1,1,2,3,-1,0,0,0,1},Arrays.asList(Arrays.asList(2,5),Arrays.asList(3,5,4,6,8,7,2),Arrays.asList(7),Arrays.asList(),Arrays.asList(),Arrays.asList(),Arrays.asList(),Arrays.asList(),Arrays.asList(),Arrays.asList())));
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i=0;i<group.length;i++) {
            if(group[i]==-1) group[i] = m;
        }
        int[] itemArr = new int[n];
        int[] groupArr = new int[m+1];
        Map<Integer, List<Integer>> itemMap = new HashMap<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for(int i=0;i<beforeItems.size();i++) {
            itemArr[i] += beforeItems.get(i).size();
            for(int j=0;j<beforeItems.get(i).size();j++) {
                int itemId = beforeItems.get(i).get(j);
                itemMap.computeIfAbsent(itemId, x -> new ArrayList<>()).add(i);
                if(group[itemId]!=group[i]&&group[i]!=m) {
                    groupArr[group[i]] ++;
                    groupMap.computeIfAbsent(itemId, x -> new ArrayList<>()).add(group[i]);
                }
            }
        }
        Map<Integer, List<Integer>> zeroGroupIdToItemIds = new HashMap<>();
        for(int i=0;i<itemArr.length;i++) {
            if(itemArr[i]==0) {
                zeroGroupIdToItemIds.computeIfAbsent(group[i], x-> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>(zeroGroupIdToItemIds.keySet());
        if(queue.isEmpty()) return new int[]{};
        int index = 0;
        int res[] = new int[n];
        while(!queue.isEmpty()){
            int size = queue.size();
            while(groupArr[queue.peek()]!=0&&size--!=0) {
                queue.add(queue.poll());
            }
            if(size==0) break;
            int groupId = queue.poll();
            List<Integer> list = zeroGroupIdToItemIds.get(groupId);
            //没有小组负责的项目不用排列在一起，入度为0，立马可以打印，打印完移除，免得后面再加入没有小组负责的项目后，重复打印
            if(groupId==m) {
                zeroGroupIdToItemIds.remove(groupId);
            }
            int i = 0;
            while(i<list.size()) {
                int itemId = list.get(i++);
                res[index++] = itemId;
                List<Integer> nextGroupId = groupMap.get(itemId);
                //下游项目入度-1
                if (itemMap.containsKey(itemId)) {
                    List<Integer> nextItemId = itemMap.get(itemId);
                    for(int id : nextItemId){
                        itemArr[id]--;
                        //如果下游项目入度为0，加入队列
                        if(itemArr[id]==0) {
                            int idGroupId = group[id];
                            //判断该项目是否存在队列中
                            if (zeroGroupIdToItemIds.containsKey(idGroupId)) {
                                zeroGroupIdToItemIds.get(idGroupId).add(id);
                            }else {
                                zeroGroupIdToItemIds.computeIfAbsent(idGroupId, x-> new ArrayList<>()).add(id);
                                queue.add(idGroupId);
                            }
                        }
                    }
                }
                if(groupMap.containsKey(itemId)) {
                    //下游项目的小组入度-1
                    for(int id : nextGroupId) {
                        groupArr[id]--;
                    }
                }
            }
        }
        if(index<n) return new int[]{};
        return res;
    }
}
