# CSA作业仓库
## 目录
 * [第一次作业](#第一次作业)
 * [第二次作业](#第二次作业)
 * [第三次作业](#第三次作业)
 * [大作业](#大作业)
 * [第四次作业](#第四次作业)
 * [第五次作业](#第五次作业)
 * [第六次作业](#第六次作业)

## 第一次作业
Stresm流快速判断数组最大最小

## 第二次作业
暂无心得

## 第三次作业
运用桶数据结构和二分查找进行字符匹配

## 大作业
文件中有说明

## 第四次作业
第一题数据库正常的DDL，DML，DQL

第二题整数反转，用了字符串进行反转，并通过捕获异常来判断是否超出范围

第三题爬楼梯用的动态规划递归，其余方法见：https://leetcode.cn/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/

第四题也类似于递归，主要方法是假设num数组为[1,2,3]

首先，创建嵌套arraylist，并添加第一个元素空集：list[ [] ]

进行复制，并将num第一个元素加入到复制的集合中,最后合并：

                                            list[ [] ]->copy：[]

                                            add 1->copy：[1]

                                            合并->list[ [] [1] ]

                                            list[ [] [1] ]->copy:[],[1]

                                            add 2->copy:[2],[1,2]

                                            合并->list[ [] [1] [2] [1,2] ]


## 第五次作业
### 连接步骤

1.注册驱动

2.获取连接

3.获取数据库操作对象

4.执行SQL语句

5.处理查询集（如果第4步没有SELECT语句，直接跳至6）

6.释放资源


## 第六次作业
mybatis帮助文档地址：https://mybatis.org/mybatis-3/zh/index.html
#### mybatis连接步骤：
1.配置pom.xml,导入mybatis，mysql，junit等

2.配置mybatis-config.xml，主要包含数据库相关信息，以及mapper配置文件

3.创建相关的mapper接口和mapper.xml文件，xml用来存储相关sql语句（注意，xml和接口的文件夹路径必须一致，但xml还是在resourcce文件夹中，接口在java文件夹中）
