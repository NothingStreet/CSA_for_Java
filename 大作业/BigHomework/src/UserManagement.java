import java.util.HashMap;
import java.util.Map;

public class UserManagement {   //用户管理类
    private Map<String,User> users;

    public UserManagement(){
        users=new HashMap<>();
    }


    //注册
    public boolean Register(String userName,String password){
        //不准注册相同用户名的账号
        if(users.containsKey(userName)){
            return false;
        }
        users.put(userName,new User(userName,password));
        return true;
    }

    //登录
    public boolean LogIn(String userName,String password){
        User user=users.get(userName);
        return (user!=null&&user.getPassWord().equals(password));
    }
}
