import java.text.Collator;
import java.util.*;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement(){
        students=new ArrayList<>();
    }

    //添加
    public void addStudent(String name,double grade,String subject){
        students.add(new Student(name,grade,subject));
    }

    //删除
    public boolean removeStudent(String name){
        for (Student student : students) {
            if (student.getName().equals(name)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    //更新
    public void updateStudent(String name,double grade,String subject){
        for(Student student:students){
            if(student.getName().equals(name)){
                student.setGrade(grade);
                student.setSubject(subject);
            }
        }
    }

    //查找
    public Student findStudent(String name){
        for(Student student:students){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    //按成绩排序
    public void sortStudentsByGrade(){
        //比冒泡排序更快
        Collections.sort(students, new Comparator<>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getGrade(), s2.getGrade());
            }
        });
    }


    //按姓名排序
    public void sortStudentsByName() {
        //因为想要中文正常排序，所以写一个中文的Comparator比较器
        Comparator<Student> comparator = (s1, s2) -> {
            Collator collator = Collator.getInstance(Locale.CHINA);
            return collator.compare(s1.getName(), s2.getName());
        };
        students.sort(comparator);
    }

    //获取学科平均成绩
    public double getAverageGrade(String subject){
        double total=0;
        int count=0;
        for(Student student:students){
            if(student.getSubject().equals(subject)){
                total+=student.getGrade();
                count++;
            }
        }
        if(count==0){
            return 0;
        }
        return total/count;
    }

    public void ShowALLStudentInfo(){
        if(students.size()!=0){
            for(Student student:students){
                System.out.println("姓名："+student.getName()+"  学科："+student.getSubject()+"  成绩："+student.getGrade());
            }
        }
        else{
            System.out.println("还没有学生信息。");
        }
    }
}
