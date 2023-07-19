package dataStructure;

import java.util.*;

public class Main {

    public static int[] findBigger(int[] num1,int[] num2){
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        for(int num:num2){
            while(!stack.empty() && stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        int []num3=new int[num1.length];
        for(int i=0;i<num1.length;i++){
            if(map.get(num1[i])==null){
                num3[i]=-1;
            }else {
                num3[i]=map.get(num1[i]);
            }
        }
        return num3;
    }

    public static boolean judgeStack(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k : pushed) {
            stack.push(k);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static int onlyOne(int[] nums){
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.get(num)==null){
                map.put(num,1);
            }
            else{
                map.put(num,map.get(num)+1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }


    public static void main(String[] args) {


        //第一题
        System.out.println("第一题");
        int[] num1={4,1,2};
        int[] num2={1,3,4,2};

        int[] num3 = {2,4};
        int[] num4 = {1,2,3,4};
        System.out.println(Arrays.toString(findBigger(num1, num2)));
        System.out.println(Arrays.toString(findBigger(num3,num4)));
        System.out.println("---------------------------------------");


        //第二题
        System.out.println("第二题");
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        System.out.println(judgeStack(pushed,popped));
        System.out.println("---------------------------------------");


        //第三题
        System.out.println("第三题");
        int[] nums1={1,2,3,2};
        int[] nums2={1,1,1,1,1};
        int[] nums3={1,2,3,4,5};
        System.out.println(onlyOne(nums1));
        System.out.println(onlyOne(nums2));
        System.out.println(onlyOne(nums3));

    }
}
