package com.company.hash;

public class LFUCache {

    private int capacity;
    private int size;
    private int minFreq = 1;
    private KeyNode[] keyTable;
    private FreqNode[] freqTable;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyTable = new KeyNode[1000];
        freqTable = new FreqNode[10000];
    }

    public int get(int key) {
        if(capacity==0) return -1;
        int index = key%keyTable.length;
        if(keyTable[index]==null) return -1;
        KeyNode keyNode;
        //查找key是否存在
        if(keyTable[index].key==key) {
            keyNode = keyTable[index];
        }else {
            keyNode = keyTable[index].next;
            while(keyNode!=keyTable[index]) {
                if(keyNode.key==key) break;
                keyNode = keyNode.next;
            }
            if(keyNode==keyTable[index]) return -1;
        }
        //存在,更新频率表
        updateTable(keyNode);
        return keyNode.value;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        int index = key%keyTable.length;
        KeyNode keyNode;
        if(keyTable[index]==null) {
            updateCap();
            keyNode = create(key, value);
            keyTable[index] = keyNode;
        } else {
            //查找key是否存在
            if(keyTable[index].key==key) {
                keyNode = keyTable[index];
                keyNode.value = value;
                updateTable(keyNode);
            }else {
                keyNode = keyTable[index].next;
                while(keyNode!=keyTable[index]) {
                    if(keyNode.key==key) break;
                    keyNode = keyNode.next;
                }
                if(keyNode==keyTable[index]) {
                    updateCap();
                    size++;
                    keyNode = create(key, value);
                    keyTable[index].pre.next = keyNode;
                    keyTable[index].next.pre = keyNode;
                }
            }
        }
    }

    private void updateCap() {
        if(size == capacity) {
            FreqNode freqNode = freqTable[minFreq%freqTable.length];
            KeyNode keyNode;
            if(freqNode.pre==freqNode&&freqNode.next==freqNode) {
                keyNode = freqNode.keyNode;
                freqTable[minFreq%freqTable.length] = null;
            }else {
                FreqNode pre = freqNode.pre;
                pre.pre.next = freqNode;
                freqNode.pre = pre.pre;
                keyNode = pre.keyNode;
            }
            if(keyNode.next == keyNode&&keyNode.pre == keyNode) {
                keyTable[keyNode.key] = null;
            }else {
                KeyNode item = keyNode.next;
                item.pre = keyNode.pre;
                keyNode.pre.next = item;
            }
            updateMin();
            size--;
        }
        size++;
    }

    private void updateTable(KeyNode keyNode) {
        int index = keyNode.freq%freqTable.length;
        FreqNode freqNode = keyNode.freqNode;
        if(freqNode.next==freqNode && freqNode.pre == freqNode) {
            freqTable[index] = null;
            if(keyNode.freq==minFreq) minFreq++;
        }else {
            FreqNode item = freqNode.next;
            freqNode.pre.next = item;
            item.pre = freqNode.pre;
            if(freqTable[index]==freqNode) freqTable[index] = item;
        }
        keyNode.freq++;
        index = keyNode.freq%freqTable.length;
        if(freqTable[index]==null) {
            freqNode.next = freqNode;
            freqNode.pre = freqNode;
            freqTable[index] = freqNode;
        }else {
            freqNode.next = freqTable[index];
            freqNode.pre = freqTable[index].pre;
            freqTable[index].pre.next = freqNode;
            freqTable[index].pre = freqNode;
            freqTable[index] = freqNode;
        }
    }

    private void updateMin() {
        for(int i=minFreq;i<freqTable.length;i++) {
            if(freqTable[i]!=null) {
                minFreq = i;
                return;
            }
        }
        minFreq = 1;
    }

    private KeyNode create(int key, int value) {
        minFreq = 1;
        KeyNode keyNode = new KeyNode(key, value, 1);
        keyNode.freqNode = new FreqNode();
        keyNode.freqNode.next = keyNode.freqNode;
        keyNode.freqNode.pre = keyNode.freqNode;
        keyNode.freqNode.keyNode = keyNode;
        keyNode.next = keyNode;
        keyNode.pre = keyNode;
        int index = 1%freqTable.length;
        if(freqTable[index] == null) {
            freqTable[index] = keyNode.freqNode;
        }else {
            keyNode.freqNode.next = freqTable[index];
            keyNode.freqNode.pre = freqTable[index].pre;
            freqTable[index].pre.next = keyNode.freqNode;
            freqTable[index].pre =  keyNode.freqNode;
            freqTable[index] = keyNode.freqNode;
        }
        return keyNode;
    }

    public class KeyNode{
        public KeyNode(int key, int value, int freq){
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
        KeyNode pre;
        KeyNode next;
        int key;
        int value;
        int freq;
        FreqNode freqNode;
    }

    public class FreqNode{
        KeyNode keyNode;
        FreqNode pre;
        FreqNode next;
    }
}
