package Work2.H1;

public class People extends Monkey{
    public People(String s){
        super(s);
    }
    @Override
    public void Speak(){
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    public void Think(){
        System.out.println("别说话！认真思考！");
    }
}
