package sheen.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class 计数质数 {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] flag = new boolean[n];
        List<Integer> prism = new ArrayList<>();
        flag[0] = true;//0和1不是质数
        flag[1] = true;
        for(int i=2;i<=n;i++) {
            if(!flag[i]) {
               prism.add(i);
            }
            for(int j=0;j<prism.size();j++) {//i *到它的最小质因数时结束
                if(i*prism.get(j)>=n) break;
                flag[prism.get(j)*i] = true;
                if(i%prism.get(j)==0) break;
            }
        }
        return prism.size();
    }
}
