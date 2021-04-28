package com.company.array;

public class 珠玑妙算 {
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2];
        for(int i=0;i<guess.length();i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res[0] ++;

                StringBuilder sb = new StringBuilder(solution);
                sb.setCharAt(i, 'X');
                solution = sb.toString();

                sb = new StringBuilder(guess);
                sb.setCharAt(i, 'X');
                guess = sb.toString();
            }

        }
        for(int i=0;i<guess.length();i++) {
            if (guess.charAt(i) != 'X') {
                for(int j = 0; j< solution.length(); j++) {
                    if(solution.charAt(j) == guess.charAt(i)) {
                        res[1] ++;
                        StringBuilder sb = new StringBuilder(solution);
                        sb.setCharAt(j, 'X');
                        solution = sb.toString();
                        break;
                    }
                }
            }
        }
        return res;
    }
}
