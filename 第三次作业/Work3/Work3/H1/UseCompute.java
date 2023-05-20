package Work3.H1;

public class UseCompute {
    public static void useCom(Compute com,int one,int two){
        if (com.getClass()== Add.class){
            System.out.println("加法结果为："+com.Computer(one,two));
        } else if (com.getClass()==Sub.class) {
            System.out.println("减法结果为："+com.Computer(one,two));
        } else if (com.getClass()==Mul.class) {
            System.out.println("乘法结果为："+com.Computer(one,two));
        }
        else {
            System.out.println("除法结果为："+com.Computer(one,two));
        }
    }
}
