import java.util.InputMismatchException;
import java.util.Scanner;

//测试
public class Main {

    static final UserManagement userManagement=new UserManagement();
    static final StudentManagement studentManagement=new StudentManagement();
    static final Scanner sc=new Scanner(System.in);


    //注册
     static void Register() {
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        if (userManagement.Register(username, password)) {
            System.out.println("注册成功。");
        } else {
            System.out.println("注册失败，用户名可能已被使用。");
        }
    }

    //登录
    static boolean LogIn() {
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        if (userManagement.LogIn(username, password)) {
            System.out.println("登录成功。");
            return true;
        } else {
            System.out.println("登录失败，用户名或密码错误。");
            return false;
        }
    }

    //管理学生信息
    static boolean manageStudents() {
        System.out.println("1. 添加学生");
        System.out.println("2. 删除学生");
        System.out.println("3. 修改学生信息");
        System.out.println("4. 查询学生信息");
        System.out.println("5. 按成绩排序");
        System.out.println("6. 按姓名排序");
        System.out.println("7. 计算科目平均分");
        System.out.println("8. 所有学生信息");
        System.out.println("9. 退出");
        System.out.println("请选择：");

        int choice;

        while(true) {
            try {
                choice= sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("请输入有效的数字：");
            }
        }

        sc.nextLine();
        switch (choice) {
            case 1 -> {
                addStudent();
                return true;
            }
            case 2 -> {
                removeStudent();
                return true;
            }
            case 3 -> {
                updateStudent();
                return true;
            }
            case 4 -> {
                findStudent();
                return true;
            }
            case 5 -> {
                sortStudentsByGrade();
                return true;
            }
            case 6 -> {
                sortStudentsByName();
                return true;
            }
            case 7 -> {
                calculateAverageGrade();
                return true;
            }
            case 8 -> {
                studentManagement.ShowALLStudentInfo();
                return true;
            }
            case 9 -> {
                return false;
            }
            default -> {
                System.out.println("无效的选项。");
                return true;
            }
        }
    }

    //增加
    static void addStudent() {
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生成绩：");
        double grade;
        while(true) {
            try {
                grade = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("请输入有效的数字：");
            }
        }
        sc.nextLine();
        System.out.println("请输入学生科目：");
        String subject = sc.nextLine();
        studentManagement.addStudent(name, grade, subject);
        System.out.println("添加学生成功。");
    }

    //删除
    static void removeStudent() {
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        if (studentManagement.removeStudent(name)) {
            System.out.println("删除学生成功。");
        } else {
            System.out.println("删除学生失败，姓名错误或者没有该学生。");
        }
    }

    //更新
    static void updateStudent() {
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生成绩：");
        double grade;
        while(true) {
            try {
                grade = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("请输入有效的数字：");
            }
        }
        sc.nextLine();
        System.out.println("请输入学生科目：");
        String subject = sc.nextLine();
        studentManagement.updateStudent(name, grade, subject);
        System.out.println("更新学生信息成功。");
    }

    //查找
    static void findStudent() {
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        Student student = studentManagement.findStudent(name);
        if (student != null) {
            System.out.println("学生姓名：" + student.getName());
            System.out.println("学生成绩：" + student.getGrade());
            System.out.println("学生科目：" + student.getSubject());
        } else {
            System.out.println("找不到这个学生。");
        }
    }

    static void sortStudentsByGrade() {
        studentManagement.sortStudentsByGrade();
        System.out.println("学生已按成绩排序。");
    }

    static void sortStudentsByName() {
        studentManagement.sortStudentsByName();
        System.out.println("学生已按姓名排序。");
    }

    static void calculateAverageGrade() {
        System.out.println("请输入科目：");
        String subject = sc.nextLine();
        double average = studentManagement.getAverageGrade(subject);
        System.out.println(subject + "的平均分是：" + average);
    }



    public static void main(String[] args) {
        while (true) {
            System.out.println("1. 注册");
            System.out.println("2. 登录");
            System.out.println("3. 退出");
            System.out.println("请选择：");
            int choice;

            while(true) {
                try {
                     choice= sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    sc.nextLine();
                    System.out.println("请输入有效的数字：");
                }
            }

            sc.nextLine();
            switch (choice) {
                case 1 -> Register();
                case 2 -> {
                    if (LogIn()) {
                        while (manageStudents()) {
                        }
                    }
                }
                case 3 -> System.exit(0);
                default -> System.out.println("无效的选项。");
            }
        }
    }
}