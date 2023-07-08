-- 1.创建student表
CREATE TABLE cqupt_student (  
studentid VARCHAR(10) NOT NULL,  
name varchar(20) NOT NULL,  
sex VARCHAR(2) NOT NULL,  
age INT,  
Fee DECIMAL(10,2),-- 储存10位数，然后小数部分为2位  
address VARCHAR(50),  
memo varchar(300)  
); 


-- 2.创建courseAa表
CREATE TABLE CourseAa (  
Aa1 VARCHAR(20),  
Aa2 INT,  
Aa3 DECIMAL(10)  
);  



-- 3.创建courseBb表
CREATE TABLE choosebb(  
Bb1 VARCHAR(30),  
Bb2 INT,  
Bb3 DECIMAL(6)  
);


-- 4和5.更新表
ALTER TABLE choosebb ADD Bb4 VARCHAR ( 20 ) NOT NULL DEFAULT '系统测试值';  
ALTER TABLE choosebb ADD Bb5 VARCHAR ( 10 ) NOT NULL PRIMARY KEY; 


-- 6.创建视图
CREATE VIEW View_ChooseBb AS SELECT  
Bb1 AS View_Bb1,  
Bb4 AS View_Bb2,  
Bb5 AS View_Bb3   
FROM  
   choosebb;  


-- 7.删除视图

drop VIEW view_choosebb;


-- 8.创建index
CREATE INDEX Index_Bb2 ON choosebb ( Bb2 ASC );  
CREATE INDEX Index_Bb4 ON choosebb ( Bb4 DESC );


-- 9.删除index
DROP INDEX Index_Bb2 ON choosebb;


-- 10.创建test表
CREATE TABLE test ( 
NAME VARCHAR ( 20 ), 
Age INT, 
Score NUMERIC ( 10, 2 ), -- 总共10位，小数占2位  
Adress VARCHAR ( 60 ) );  


-- 11.插入
INSERT INTO test (Name,Age,Score,Adress) VALUES ('赵一',20,580.00,'重邮宿舍 12-3-5');  
INSERT INTO test (Name,Age,Score,Adress) VALUES ('赵二',19,540.00,'南福苑 5-2-9');  
INSERT INTO test (Name,Age,Score,Adress) VALUES ('孙三',21,555.50,'学生新区 21-5-15');  
INSERT INTO test (Name,Age,Score,Adress) VALUES ('李四',22,505.00,'重邮宿舍 8-6-22');  
INSERT INTO test (Name,Age,Score,Adress) VALUES ('周五',20,495.50,'学生新区 23-4-8');  
INSERT INTO test (Name,Age,Score,Adress) VALUES ('吴六',19,435.00,'南福苑 2-5-12');  


-- 12.创建test_temp
CREATE TABLE test_temp ( 
NAME VARCHAR ( 20 ), 
Age INT, 
Score NUMERIC ( 10, 2 ), -- 总共10位，小数占2位  
Adress VARCHAR ( 60 ) 
); 


-- 13.插入
INSERT INTO test_temp (Name,Age,Score,Adress) VALUES('郑七',21,490.50,'重游宿舍 11-2-1');  
INSERT INTO test_temp (Name,Age,Score,Adress) VALUES('张八',20,560.00,'南福苑 3-3-3');  
INSERT INTO test_temp (Name,Age,Score,Adress) VALUES('王九',19,515.00,'学生新区 19-7-1');  



-- 14.将test_temp表中的数据插入test中

INSERT INTO test (Name,Age,Score,Adress)   
SELECT Name,Age,Score,Adress   
FROM test_temp; 


-- 15.更新
UPDATE test SET Score=Score+5 WHERE age<=20; 

-- 16.更新
UPDATE test   
SET age=age-1   
WHERE Adress LIKE '南福苑%'; 


-- 17.删除
DELETE FROM test   
WHERE Age>=21 AND Score>=500.00; 


-- 18.删除
DELETE FROM test   
WHERE Score<550 AND  
Adress LIKE '重邮宿舍%'; 



-- 19.创建student表
CREATE TABLE student(  
SNO VARCHAR(20),  
Name VARCHAR(10),  
Age INT,  
College VARCHAR(30)  
);


-- 20.创建course表
CREATE TABLE Course(  
CourseID VARCHAR(15),  
CourseName VARCHAR(30),  
CourseBeforeID VARCHAR(15)  
); 


-- 21.创建choose表
CREATE TABLE Choose(  
SNO VARCHAR(20),  
CourseID VARCHAR(30),  
Score DECIMAL(5,2)  
);  



-- 22.插入
INSERT INTO student   
(SNO,Name,Age,College) VALUES  
('S00001','张三',20,'计算机学院');  
INSERT INTO student   
(SNO,Name,Age,College) VALUES  
('S00002','李四',19,'通信学院');  
INSERT INTO student   
(SNO,Name,Age,College) VALUES  
('S00003','王五',21,'计算机学院'); 



-- 23.插入
NSERT INTO course  
(CourseID,CourseName,CourseBeforeID) VALUES  
('C1','计算机引论',NULL);  
INSERT INTO course  
(CourseID,CourseName,CourseBeforeID) VALUES  
('C2','C语言','C1');  
INSERT INTO course  
(CourseID,CourseName,CourseBeforeID) VALUES  
('C3','数据结构','C2'); 



-- 24.插入

INSERT INTO choose  
(SNO,CourseID,Score) VALUES  
('S00001','C1',95);  
INSERT INTO choose  
(SNO,CourseID,Score) VALUES  
('S00001','C2',80);  
INSERT INTO choose  
(SNO,CourseID,Score) VALUES  
('S00001','C3',84);  
INSERT INTO choose  
(SNO,CourseID,Score) VALUES  
('S00002','C1',80);  
INSERT INTO choose  
(SNO,CourseID,Score) VALUES  
('S00002','C2',85);  
INSERT INTO choose  
(SNO,CourseID,Score) VALUES  
('S00003','C1',78);  
INSERT INTO choose  
(SNO,CourseID,Score) VALUES  
('S00003','C3',70); 



-- 25.select
SELECT SNO,Name   
FROM student   
WHERE College='计算机学院'; 


-- 26.select
SELECT *   
FROM student  
WHERE Age BETWEEN 20 AND 23;


-- 27.select
SELECT COUNT(*)  
FROM student;


-- 28.select
SELECT MAX(Score)  
FROM choose  
WHERE CourseID LIKE 'C1';  
SELECT min(Score)  
FROM choose  
WHERE CourseID LIKE 'C1';    
SELECT sum(Score)  
FROM choose  
WHERE CourseID LIKE 'C1';  	  
SELECT avg(Score)  
FROM choose  
WHERE CourseID LIKE 'C1'; 


-- 29.select
SELECT CourseID,CourseName  
FROM course  
WHERE CourseBeforeID IS NULL;


--30.select
SELECT student.SNO,student.Name,course.CourseName,choose.Score  
FROM student,course,choose  
WHERE student.SNO=choose.SNO AND choose.CourseID=course.CourseID  
ORDER BY SNO ASC; 


-- 31.select
SELECT * 
from student s1 
WHERE  EXISTS 
(SELECT * FROM  student s2 
WHERE s2.`Name`='张三' and s1.college=s2.college); 



-- 32.select
SELECT h1.SNO,h1.Score from choose h1 
WHERE h1.CourseID='C1' AND h1.Score<ANY 
(SELECT h2.Score  from choose h2 ,student 
where student.`Name`='张三' and h2.SNO=student.SNO );


-- 33.select
SELECT choose.SNO FROM choose 
WHERE choose.CourseID='C1' 
UNION SELECT choose.SNO FROM choose 
WHERE choose.CourseID='C3';



-- 34.select
SELECT  DISTINCT choose.SNO,choose.CourseID FROM choose 
WHERE choose.CourseID='C1' 
UNION SELECT DISTINCT choose.SNO,choose.CourseID FROM choose 
WHERE choose.CourseID='C3'; 






















