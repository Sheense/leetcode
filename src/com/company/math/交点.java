package com.company.math;

import com.company.util.ArrayUtils;

public class 交点 {

    public static void main(String[] args) {
        交点 s = new 交点();
        ArrayUtils.print(s.intersection(new int[]{1,0},new int[]{1,1},new int[]{-1,0},new int[]{3,2}));
    }

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if(Math.max(Math.max(start1[0],end1[0]), Math.max(start2[0],end2[0]))-Math.min(Math.min(start1[0],end1[0]),Math.min(start2[0],end2[0]))>
                            ((Math.max(start1[0],end1[0])-Math.min(start1[0],end1[0]))  +  (Math.max(start2[0],end2[0])-Math.min(start2[0],end2[0])))||
                            Math.max(Math.max(start1[1],end1[1]), Math.max(start2[1],end2[1]))-Math.min(Math.min(start1[1],end1[1]),Math.min(start2[1],end2[1]))>
                                                ((Math.max(start1[1],end1[1])-Math.min(start1[1],end1[1]))  +  (Math.max(start2[1],end2[1])-Math.min(start2[1],end2[1]))) ) {
            return new double[]{};
        }
        double a1 = 0.0;
        double a2 = 0.0;
        if(end1[0]-start1[0] == 0||end2[0]-start2[0]==0) {
            if(end1[0]-start1[0] == 0&&end2[0]-start2[0]!=0) {
                double x = start1[0];
                a2 =(double) (end2[1]-start2[1])/(end2[0]-start2[0]);
                double y = a2*(x-end2[0]) + end2[1];
                return new double[]{x,y};
            }else if(end1[0]-start1[0] != 0&&end2[0]-start2[0]==0){
                double x = start2[0];
                a1 = (end1[1]-start1[1])/(end1[0]-start1[0]);
                double y = a1*(x - end1[0]) + end1[1];
                return new double[]{x,y};
            }else {
                if(end1[0]!=end2[0]) return  new double[]{};
                return check(1,start1,end1,start2,end2);
            }
        }else {
            a1 = (double)(end1[1]-start1[1])/(end1[0]-start1[0]);
            a2 = (double)(end2[1]-start2[1])/(end2[0]-start2[0]);
        }
        if(a1==a2) {
            if(a1==0) {
                return check(0,start1,end1,start2,end2);
            }
            double a = (end2[1]-end1[1])/(end2[0]-end1[0]);
            if(end2[0]-end1[0]==0||a!=a1) {
                return new double[]{};
            }else {
                return check(0,start1,end1,start2,end2);
            }
        }
        double b1 = -a1*end1[0] + end1[1];
        double b2 = -a2*end2[0]+end2[1];
        double x = (b2-b1)/(a1-a2);
        double y = a1*x + b1;
        return judge(start1,end1,start2,end2,x,y);
    }
    public double[] judge(int[] start1, int[] end1, int[]start2,int[] end2,double x, double y){
        if(x>=Math.min(start1[0],end1[0])&&x<=Math.max(start1[0],end1[0])&&
                            y>=Math.min(start1[1],end1[1])&&y<=Math.max(start1[1],end1[1])&&
                            x>=Math.min(start2[0],end2[0])&&x<=Math.max(start2[0],end2[0]) &&
                            y>=Math.min(start2[1],end2[1])&&y<=Math.max(start2[1],end2[1])
        ){
            return new double[]{x,y};
        }
        return new double[]{};
    }


    public double[] check(int byIndex, int[] start1, int[] end1, int[]start2,int[] end2) {
        int[][] arr = new int[4][2];
        arr[0] = start1;
        arr[1] = end1;
        arr[2] = start2;
        arr[3] = end2;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i][byIndex]>arr[j][byIndex]) {
                    int[] item = arr[i];
                    arr[i] = arr[j];
                    arr[j] = item;
                }
            }
        }
        return new double[]{arr[1][0], arr[1][1]};
    }




    /*public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double a1 = 0.0;
        double a2 = 0.0;
        if(end1[0]-start1[0] == 0||end2[0]-start2[0]==0) {
            if(end1[0]-start1[0] == 0&&end2[0]-start2[0]!=0) {
                double x = start1[0];
                a2 =(double) (end2[1]-start2[1])/(end2[0]-start2[0]);
                double y = x*a2 + end2[0] - end2[1];
                return check(new double[]{x,y},0,0,true, false, new double[]{start1[0],start1[1]},new double[]{end1[0],end1[1]},new double[]{start2[0],start2[1]},new double[]{end2[0],end2[1]});
            }else if(end1[0]-start1[0] != 0&&end2[0]-start2[0]==0){
                double x = start2[0];
                a1 = (end1[1]-start1[1])/(end1[0]-start1[0]);
                double y = x*a1 + end1[0] - end1[1];
                return check(new double[]{x,y},0,0,false, true, new double[]{start1[0],start1[1]},new double[]{end1[0],end1[1]},new double[]{start2[0],start2[1]},new double[]{end2[0],end2[1]});
            }else {
                if(end1[0]!=end2[0]) return new double[]{};
                else {

                }
            }
        }else {
            a1 = (double)(end1[1]-start1[1])/(end1[0]-start1[0]);
            a2 = (double)(end2[1]-start2[1])/(end2[0]-start2[0]);
        }
        if(a1==a2) {
            double a = (end2[1]-end1[1])/(end2[0]-end1[0]);
            if(a==a1) {

                return new double[]{p[0],p[1]};
            }else {
                return new double[]{};
            }
        }
        double b1 = -a1*end1[0] + end1[1];
        double b2 = -a2*end2[0]+end2[1];
        double x = (b2-b1)/(a1-a2);
        double y = a1*x + b1;
        double[] target = new double[]{x,y};

    }

    public double[] check(double[] target ,double a1, double a2,boolean flag1,boolean flag2, double[] start1,double[]end1,double[]start2,double[]end2) {
        if(flag1||flag2) {
            if(flag1&&!flag2) {
                if(target[1]<=Math.max(start2[1],end2[1])&&target[1]>=Math.min(start2[1],end2[1])) {
                    return target;
                }else {
                    return new double[]{};
                }
            }else if(!flag1&&flag2) {
                if(target[1]<=Math.max(start1[1],end1[1])&&target[1]>=Math.min(start1[1],end1[1])) {
                    return target;
                }else {
                    return new double[]{};
                }
            }else {
                if(Math.max(start1[1],end1[1])<Math.min(start2[1],end2[1])&&Math.max(start2[1],end2[1])<Math.min(start1[1],end1[1])) {
                    return new double[]{};
                }else if()
            }
        }



        if (Math.min(start1[0], end1[0]) <= target[0] && target[0] <= Math.max(start1[0], end1[0]) && Math.min(start2[0], end2[0]) <= target[0] && target[0] <= Math.max(start2[0], end2[0])) {
            return target;
        }else {
            return new double[]{};
        }
    }*/
}
