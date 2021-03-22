package com.company.array;

public class 设计停车系统 {
    class ParkingSystem {

        private int[] arr = new int[3];
        public ParkingSystem(int big, int medium, int small) {
            arr[0] = big;
            arr[1] = medium;
            arr[2] = small;
        }

        public boolean addCar(int carType) {
            return --arr[carType - 1]>=0;
        }
    }
}
