package Work4.H2;

import java.util.Scanner;

public class IntReverse {
    public static int reverseInt(int x){
        int flag=1;
        String s=Integer.toString(x);
        if(x<0){
            flag=-1;
            s=s.substring(1);
        }
        try{
            return Integer.parseInt(new StringBuilder(s).reverse().toString())*flag;
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("x=");
        int x=sc.nextInt();
        sc.close();
        System.out.println(reverseInt(x));
    }
}
