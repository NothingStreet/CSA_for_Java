package Work2.H3;
import java.util.ArrayList;
import java.util.List;

public class BigData {
    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for (int i = a.length() - 1; i >= 0; --i) {
            la.add(a.charAt(i) - '0');

        }
        for (int i = b.length() - 1; i >= 0; --i) {
            lb.add(b.charAt(i) - '0');

        }

        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        List<Integer> max=(la.size()>= lb.size()?la:lb);
        List<Integer> min=(la.size()>= lb.size()?lb:la);
        List<Integer> temp=new ArrayList<>();
        //加法
        for(int i=0;i<max.size();i++){
            if(i<=min.size()-1){
                int flag=max.get(i)+ min.get(i);
                temp.add(flag);
            }
            else{
                temp.add(max.get(i));
            }
        }
        //处理进位
        temp.add(0);
        for(int i=0;i< temp.size();i++){
            if(temp.get(i)/10==1){
                temp.set(i,temp.get(i)%10);
                temp.set(i+1,temp.get(i+1)+1);
            }
        }
        //去0
        if(temp.get(temp.size()-1)==0){
            temp.remove(temp.size()-1);
        }
        //翻转拼接
        for (int i = temp.size()-1; i>=0; i--) {
            c+=temp.get(i).toString();//也可以用StringBuilder
        }
        return c;

    }

}
