package Work4.H4;

import java.util.ArrayList;
import java.util.List;

public class Sub {
    public static void main(String[] args) {
        int []num={1,2,3};

        List<List<Integer>> result=new ArrayList<>();
        //加入空集
        result.add(new ArrayList<>());

        for(int i=0;i< num.length;i++){
            int size=result.size();
            for(int j=0;j<size;j++){
                //复制result中的元素，再把当前num中元素加入复制的每个元素中，最后合并到result中
                //1.复制
                List<Integer> copy=new ArrayList<>(result.get(j));
                //2.加入
                copy.add(num[i]);
                //3.合并
                result.add(copy);
            }
        }

        
        System.out.println(result);
    }
}
