import java.util.Arrays;

public class First_Homework {
    //打印三角形
    public static void showTriangle(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n-1-i));
            System.out.println("*".repeat(2*i+1));
        }
    }

    //颠倒字符串
    public static void reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c;
            int re=chars.length-i-1;
            if(re-i<=0){
                break;
            }
            c=chars[i];
            chars[i]=chars[re];
            chars[re]=c;
        }
        String s1 = String.valueOf(chars);
        System.out.println(s1) ;
    }

    //回文数
    public static void isPalindrome(int num) {
        boolean flag = false;
        int reNUm=0,temp=num;
        while(temp!=0){
            reNUm=reNUm*10+temp%10;
            temp=temp/10;
        }
        flag=(reNUm==num);

        if (flag) {
            System.out.println("是的") ; }
        else
            System.out.println("不是") ;
    }

    //水仙花数
    public static void ShuiXianHua() {
        for (int i = 100; i <=999; i++) {
            int num=0;
            int temp=i;
            while(temp!=0) {
                num += Math.pow(temp % 10, 3);
                temp =temp/10;
            }
            if(num==i)
                System.out.print(i+" ");
        }
    }

    //最大值和最小值之和
    public static void arraysDemo() {
        int []a={1,2,3,4,5,6,7,8,9,10};
        int max=Arrays.stream(a).max().getAsInt();
        int min=Arrays.stream(a).min().getAsInt();
        System.out.println("最大值："+max+" 最小值：" +min+" 和："+(max+min));
    }



    public static void main(String[] args) {
        //选择题
        System.out.println("1、B 2、B 3、D 4、B 5、D");
        System.out.println();

        //打印三角
        showTriangle(4);
        System.out.println();

        //颠倒
        reverseString("abcde");
        reverseString("abcd");
        System.out.println();

        //回文数
        isPalindrome(121);
        isPalindrome(123);
        System.out.println();

        //水仙花数
        ShuiXianHua();
        System.out.println("\n");

        //最大值和最小值之和
        arraysDemo();
    }
}
