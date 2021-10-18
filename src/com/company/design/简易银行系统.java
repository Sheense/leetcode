package com.company.design;

/**
 * @Classname 简易银行系统
 * @Date 2021/10/17 12:08 下午
 * @Created by sheen
 * @Description TODO
 */
public class 简易银行系统 {
    public static void main(String[] args) {
        Bank s = new Bank(new long[]{10,100,20,50,30});
        s.withdraw(3, 10);
        s.transfer(5, 1, 20);
        s.deposit(5, 20);
        s.transfer(3, 4, 15);
        s.withdraw(10, 50);
        System.out.println();
    }
    static class Bank {

        private long[] balance;
        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if(!isExist(account1) || !isExist(account2)) {
                return false;
            }
            if(balance[account1 - 1] < money) {
                return false;
            }
            balance[account1 - 1]-=money;
            if(deposit(account2, money)) {
                return true;
            }
            balance[account1 - 1] += money;
            return false;
        }

        public boolean deposit(int account, long money) {
            if(!isExist(account)) {
                return false;
            }
            if(Long.MAX_VALUE - money < balance[account - 1]) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if(!isExist(account)) {
                return false;
            }
            if(balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }

        private boolean isExist(int account) {
            return account <= balance.length && account > 0;
        }
    }
}
