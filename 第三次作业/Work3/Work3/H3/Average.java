package Work3.H3;

import java.util.Scanner;

public class Average {

    public static void ScanNumber(Scanner sc,int[] array,int n)throws UnexpectedNumberException{
        int number=sc.nextInt();
        if(number<0){
            throw new UnexpectedNumberException("必须是正数或者0");
        }else{
            array[n]=number;
        }
    }
    public static void InsertN(Scanner sc,int[] array) {
        for (int i = 0; i < array.length; i++) {
            while(true) {
                try {
                    System.out.println("请输入第"+(i+1)+"个数据");
                    ScanNumber(sc,array,i);
                    break;
                }catch (UnexpectedNumberException e){
                    e.printStackTrace();
                }

            }
        }


    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入需要计算平均值的个数N：");
        int N=sc.nextInt();
        int[] array=new int[N];

        InsertN(sc,array);
        float average=0;
        for (int j : array) {
            average += j;
        }
        System.out.println("平均数为："+(average=average/array.length));

        sc.close();
    }
}
