package Work4.H3;

import java.util.Scanner;

public class Floor {
    public static int countFloor(int n){

        //递归出口
        if(n==1||n==2){
            return n;
        }

        int n_1=2,n_2=1,count=0;
        for(int i=3;i<=n;i++){
            count=n_1+n_2;
            n_2=n_1;
            n_1=count;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        System.out.println(countFloor(n));
    }
}
