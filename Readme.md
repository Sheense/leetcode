二分：确定上下线，并确定推进方法
DP：推出转化方程
数组：前缀和,单调栈(是一个动态遍历的过程，不是扫描一遍的结果)
滑动窗口：双指针
排序：带着序号排序

n 个正整数的排列:指1到n的一个排列，例如：1到3的排列有2，1，3；

===============================
最长上升子序列nlogn做法（只输出长度）
用一个栈保存最长子序列，当栈顶元素小于新加入的值时，直接进栈，
当栈顶元素大于新加入的值时，用二分找到第一个大于等于它的数，并替换，
最后栈的大小为最大上升子序列,栈中的序列非最长上升子序列。

如果需要输出最长上升子序列，可以用一个和原数组长度相同的数组，记录原
数组在栈中的位置，然后从右到左递推
int maxx=999999; //从右往左打印，
for(int i=n;i>=1;i--) {
   if(index==0) break;
   if(pos2[i]==index&&maxx>a[i]) { //先找第一个在lower数组index位置，再找第一个在lower数组index-1位置直到index=0
      answer[index]=i;//保存答案
      index-=1;
      maxx=a[i];
   }
}

