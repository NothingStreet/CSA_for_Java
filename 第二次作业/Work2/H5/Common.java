package Work2.H5;

public class Common {
    public static String Judge(String[] s) {
        if(s.length==0){
            return "";
        }
        else{
            String flag=s[0];//将第一个设置为前缀
            for(int i=1;i<s.length;i++){
                for(int j=0;j<s[i].length()&&j<flag.length();j++){
                    if(flag.charAt(j)!=s[i].charAt(j)){
                        flag=flag.substring(0,j);
                        break;
                    }
                }
            }
            return flag;
        }
    }
}