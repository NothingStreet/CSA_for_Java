public class Student {        //学生信息类
    private String name;
    private double grade;
    private String subject;

    public Student(String name,double grade,String subject){
        this.name=name;
        this.grade=grade;
        this.subject=subject;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getGrade() {return grade;}
    public void setGrade(double grade) {this.grade = grade;}
    public String getSubject() {return subject;}
    public void setSubject(String subject) {this.subject = subject;}


}
