# CSA作业仓库
## 目录
 * [第一次作业](#第一次作业)
 * [第二次作业](#第二次作业)
 * [第三次作业](#第三次作业)
 * [大作业](#大作业)
 * [第四次作业](#第四次作业)

## 第一次作业
Stresm流快速判断数组最大最小

## 第二次作业
暂无心得

## 第三次作业
运用桶数据结构和二分查找进行字符匹配

## 大作业
文件中有说明

## 第四次作业
第一题数据库正常的DDL和DML

第二题整数反转，用了字符串进行反转，并通过捕获异常来判断是否超出范围

第三题爬楼梯用的动态规划递归，其余方法见：https://leetcode.cn/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/

第四题也类似于递归，主要方法是假设num数组为[1,2,3]

首先，创建嵌套arraylist，并添加第一个元素空集：list[ [] ]

进行复制，并将num第一个元素加入到复制的集合中：list[ [] ]->copy：[]

                                            add 1->copy：[1]

                                            合并->list[ [] [1] ]

                                            list[ [] [1] ]->copy:[],[1]

                                            add 2->copy:[2],[1,2]

                                            合并->list[ [] [1] [2] [1,2] ]
