package com.company.design;

import com.company.util.ArrayUtils;

/**
 * @Classname 设计一个ATM机器
 * @Date 2022/4/16 11:16 下午
 * @Created by sheen
 * @Description TODO
 */
public class 设计一个ATM机器 {


    public static void main(String[] args) {
        ATM s = new ATM();
        s.deposit(new int[] {0,0,1,2,1});
        ArrayUtils.print(s.withdraw(600));
        s.deposit(new int[]{0,1,0,1,1});
        ArrayUtils.print(s.withdraw(600));
        ArrayUtils.print(s.withdraw(550));
    }
    static class ATM {
        private int[] atm = new int[] {20, 50, 100, 200, 500};
        private long[] save = new long[5];

        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for(int i = 0; i < banknotesCount.length; i++) {
                save[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];
            for(int i = save.length -1; i >= 0; i -- ){
                if(save[i] == 0) {
                    continue;
                }
                if(atm[i] > amount) {
                    continue;
                }
                long min = Math.min(save[i], amount / atm[i]);
                amount -= min * atm[i];
                res[i] = (int)min;
                if(amount == 0) {
                    break;
                }
            }

            if(amount == 0) {
                for(int i = 0;i < res.length; i++) {
                    save[i] -= res[i];
                }
                return res;
            }

            return new int[]{-1};
        }
    }
}
