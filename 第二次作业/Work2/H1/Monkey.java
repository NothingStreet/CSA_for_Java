package Work2.H1;

public class Monkey {
    protected String name;

    public Monkey(String s){
        name=s;
    }
    public String getName(){
        return name;
    }

    public void Speak(){
        System.out.println("咿咿呀呀 ......");
    }
}
