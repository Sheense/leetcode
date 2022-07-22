package sheen.leetcode.array;

import sheen.leetcode.common.MountainArray;

public class 山脉数组中查找目标值 {

    public static void main(String[] args) {
        山脉数组中查找目标值 s = new 山脉数组中查找目标值();
        MountainArray mountainArray = new MountainArray() {
            int [] arr = {3,5,3,2,0};
            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int length() {
                return arr.length;
            }
        };
        System.out.println(s.findInMountainArray(0,mountainArray));
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int start = 0;
        int end = length-1;
        int n = 0;
        while(start<=end) {
            int mid = (start + end)/2;
            int midNUm = mountainArr.get(mid);
            int midLeftNum =mid-1>=0? mountainArr.get(mid-1):0;
            int midRightNum =mid+1<length? mountainArr.get(mid+1) :0;
            if((mid-1<0||midLeftNum<=midNUm)&&(mid+1>=length||midNUm<=midRightNum)) {
                start = mid+1;
            }else if((mid-1<0||midLeftNum<midNUm)&&(mid+1>=length||midNUm>midRightNum)) {
                n = midNUm;
                break;
            } else {
                end = mid-1;
            }
        }
        int mid = (start+end)/2;
        if(n<target) {
            return -1;
        } if(n==target) {
            return mid;
        } else {
            start = 0;
            end = mid-1;
            while(start<=end) {
                int m = (start+end)/2;
                int num = mountainArr.get(m);
                if(num>target) {
                    end = m-1;
                }else if(num==target) {
                    return m;
                } else {
                    start = m+1;
                }
            }
            start = mid+1;
            end = length-1;
            while(start<=end) {
                int m = (start+end)/2;
                int num = mountainArr.get(m);
                if(num<target) {
                    end = m-1;
                }else if(num==target) {
                    return m;
                } else {
                    start = m+1;
                }
            }
            return -1;
        }
    }



}
