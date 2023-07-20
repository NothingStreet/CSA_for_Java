package work7;

import java.util.HashMap;
import java.util.Map;

import java.util.Random;
public class Main {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1("abbc","dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
            System.out.println("target:"+target+"\tresult"+task3(new int[]
                    {0,4,5,6,8},target));
        }
    }

    public static void main(String[] args) {
        test();
    }
    public static boolean task1(String pattern, String str) {
//第一题代码
        boolean res=true;

        if(pattern==null||str==null) {
            res = false;
            return res;
        }
        String[] s=str.split(" ");

        if(pattern.length()!=s.length) {
            res = false;
            return res;
        }

        Map<Character,String> map=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            if(map.containsKey(c)){

                if(!map.get(c).equals(s[i])){
                    res=false;
                    return res;
                }
            }
            else{

                if(map.containsValue(s[i])) {
                    res=false;
                    return res;
                }
                else {
                    map.put(c,s[i]);
                }
            }
        }

        return res;
    }

    public static int task2(int[] nums) {
//第二题代码
        int res=-1;
        int[] temp=new int[nums.length];
        for(int i=0;i< nums.length;i++){
            temp[nums[i]]++;
            if(temp[nums[i]]>1)
                res=nums[i];
        }
        return res;
    }
    public static int task3(int []nums,int target){
//第三题代码
        int res=0;
        int min=0,max=nums.length-1;

        while(true){
            if(min>max)
                return res;
            int mid=(max+min)/2;
            if(nums[mid]>target){
                max=mid-1;
                res=-mid;
            }
            else if(nums[mid]<target){
                min=mid+1;
                res=-mid;
            }else{
                return mid;
            }
        }
    }
}
