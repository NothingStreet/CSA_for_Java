package Work2.H4;

import java.util.Arrays;

public class Dynamic {
    public static int count=0;
    public static void Step(int i,int j,int [][]num){
        if(i== num.length-1&&j==num[0].length-1){
            count++;
        }
        else{
            if(i< num.length-1){
                Step(i+1,j,num);
            }
            if(j< num[0].length-1){
                Step(i,j+1,num);
            }
        }
    }
}
