package Work3.H4;

public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract  void earning();

    @Override
    public String toString() {
        return "姓名："+name+" number:"+number+" birthday:"+birthday.getYear()+"年"+birthday.getMonth()+"月"+birthday.getDate()+"日";
    }



    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getNumber() {return number;}
    public void setNumber(int number) {this.number = number;}
    public MyDate getBirthday() {return birthday;}
    public void setBirthday(MyDate birthday) {this.birthday = birthday;}
}
