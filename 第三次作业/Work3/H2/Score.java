package Work3.H2;

import java.util.Scanner;

public class Score {
    public static void ShowScore(int n)throws UnexpectedScoreException {
        if(n<0||n>100){
            throw new UnexpectedScoreException(n+"的范围不在0-100之间");
        }else{
            System.out.println("分数为："+n);
        }
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        while(true){
            try{
                System.out.println("请输入分数：");
                int score=sc.nextInt();
                ShowScore(score);
                break;
            }catch (UnexpectedScoreException e){
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
