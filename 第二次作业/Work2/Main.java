package Work2;
import java.util.*;
import Work2.H1.*;
import Work2.H2.*;
import Work2.H3.BigData;
import Work2.H4.Dynamic;
import Work2.H5.Common;

public class Main {
    public static void main(String[] args) {
        System.out.println("<-----------------第一题----------------->\n");

        Monkey m1=new Monkey("猴子1");
        System.out.print("m1‘s name："+m1.getName()+"\nm1 speak:");
        m1.Speak();
        People p1=new People("人类1");
        System.out.print("\np1‘s name："+p1.getName()+"\np1 speak:");
        p1.Speak();
        Monkey p2=new People("上转型人类");
        System.out.print("\np2‘s name："+p2.getName()+"\np2 speak:");
        p2.Speak();

        System.out.println("\n<-----------------第二题----------------->\n");

        System.out.println("例子1：");
        Car c1=new Car(4,1150,3);
        c1.printInfo();
        c1.Judge();
        System.out.println("------------------------");
        Truck t1=new Truck(6,15000,1,3000);
        t1.printInfo();
        t1.Judge();
        System.out.println("例子2：");
        Car c2=new Car(4,1150,6);
        c2.printInfo();
        c2.Judge();
        System.out.println("------------------------");
        Truck t2=new Truck(6,15000,1,7000);
        t2.printInfo();
        t2.Judge();

        System.out.println("\n<-----------------第三题----------------->\n");

        Scanner sc=new Scanner(System.in);
        System.out.print("请输入a=");
        String a=sc.next();
        System.out.print("请输入b=");
        String b=sc.next();
        System.out.println("c="+BigData.getSum(a,b));


        System.out.println("\n<-----------------第四题----------------->\n");

        System.out.print("请输入行：");
        int m=sc.nextInt();
        System.out.print("请输入列：");
        int n=sc.nextInt();
        int [][]num=new int[m][n];
        Dynamic.Step(0,0,num);
        System.out.println("步数："+Dynamic.count);
        sc.close();

        System.out.println("\n<-----------------第五题----------------->\n");

        String []s={"f1ower","f1ow","f1ight"};
        String []s2={"dog","racecar '","car"};
        String []s3={"dog"};
        String []s4={};
        System.out.println(Common.Judge(s));
        System.out.println(Common.Judge(s2));//空字符
        System.out.println(Common.Judge(s3));
        System.out.println(Common.Judge(s4));//空字符

    }
}
