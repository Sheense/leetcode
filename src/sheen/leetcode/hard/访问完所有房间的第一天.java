package sheen.leetcode.hard;

/**
 * @Classname 访问完所有房间的第一天
 * @Date 2024/3/28 00:44
 * @Created by sheen
 * @Description Hard
 *
 * 方法一：动态规划
 * 思路
 *
 * 分析题意发现 nextVisit[i]\textit{nextVisit}[i]nextVisit[i] 的范围属于 [0,i][0,i][0,i]，意味着当你首次到达房间 iii 时会回退到房间 nextVisit[i]\textit{nextVisit}[i]nextVisit[i]。而只有访问过该房间偶数次时才会到达下一个房间，进而推断出到达 iii 时，[0,i)[0,i)[0,i) 的房间已经被访问过偶数次。
 *
 * 定义 f[i]\textit{f}[i]f[i] 表示从奇数次到房间 iii，到奇数次到达房间 i+1i+1i+1 所需要的天数。以下用 tototo 代表 nextVisit[i]\textit{nextVisit}[i]nextVisit[i]，回退到房间 tototo 时是奇数次访问，又需要花费 f[to]\textit{f}[to]f[to] 才会到达房间 to+1to + 1to+1。从 iii 访问 tototo 和 i+1i+1i+1 又分别需要花费一天，所以有转移方程:
 *
 * f[i]=∑j=toi−1f[j]+2\textit{f}[i] = \sum_{j=to}^{i-1}\textit{f}[j] + 2
 * f[i]=
 * j=to
 * ∑
 * i−1
 * ​
 *  f[j]+2
 * 但这样做时间复杂度是 O(n2)O(n^2)O(n
 * 2
 *  )，考虑到求和可以用前缀和预处理达到 O(1)O(1)O(1) 转移。定义 dp[i]\textit{dp}[i]dp[i] 表示从 000 号房间出发首次到 i+1i+1i+1 花费的天数，经化简有转移方程:
 *
 * dp[i]=dp[i−1]−dp[to]+2\textit{dp}[i] = \textit{dp}[i - 1] - \textit{dp}[to] + 2
 * dp[i]=dp[i−1]−dp[to]+2
 * dp[n−1]\textit{dp}[n-1]dp[n−1] 就是第一次到达 nnn 号房间花费的天数。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/solutions/2710218/fang-wen-wan-suo-you-fang-jian-de-di-yi-p7fc2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


public class 访问完所有房间的第一天 {

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod = 1000000007;
        int[] dp = new int[nextVisit.length];
        dp[0] = 0;
        for(int i = 1; i < nextVisit.length; i++) {
            int to = nextVisit[i];
            dp[i] = 2 + dp[i - 1];
            if(to > 0) {
                dp[i] = (dp[i] - dp[to - 1] + mod) % mod;
            }
            dp[i] = (dp[i - 1] + dp[i]) % mod;
        }
        return dp[nextVisit.length - 2];
    }
}
