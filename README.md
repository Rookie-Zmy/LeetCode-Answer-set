# LeetCode-Answer-set
LeetCode练习集

## **Author: ZMY**

- 2019.01.31 增加 **982** , **983** , **984**

- **982 Triples With BitWise And Equal To Zero**  
  [题目链接](https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/)  

  **题目大意：**  
  从N个数字中选出三个数，其相与后的值为0，可以重复选取同一数字

  **解题思路：**  
  采用了dp的处理了该题，时间复杂度为 o(3 * 2^16 * N), 空间复杂度为 o(3 * 2^16)，因数据范围 0 <= A < 2^16
  故可以枚举所有的情况

  另外在提交代码中看到了段效率比较高的代码，优化了枚举过程，读者亦可了解下  
  [实现代码](LeetCode/src/com/code/leetcode/LeetCode982TriplesWithBitWiseAndEqualToZero.java)


- **983 Triples With BitWise And Equal To Zero**  
  [题目链接](https://leetcode.com/problems/minimum-cost-for-tickets/)  

  **题目大意：**  
  在一年中的某些日子要做火车出去旅游，车票类型分为日票、周票、月票，在确定出行日期与不同车票价格的情况，求出最小花费

  **解题思路：**  
  采用了dp的处理了该题，时间复杂度为 o(2 * N), 空间复杂度为 o(2 * 366)，从第一天开始枚举每一天最小的花费

  [实现代码](LeetCode/src/com/code/leetcode/LeetCode983MinimumCostForTickets.java)

- **984 LeetCode984 String Without AAA or BBB**  
  [题目链接](https://leetcode.com/problems/string-without-aaa-or-bbb/)  

  **题目大意：**  
  给你 **N** 个 **a** 与 **M** 个 **b** ，返回任意不存在aaa或bbb的字符串，保证存在至少1种情况

  **解题思路：**  
  模拟题，莫名感觉写的稍微丑了点

  [实现代码](LeetCode/src/com/code/leetcode/LeetCode984_String_Without_AAA_or_BBB.java)  
