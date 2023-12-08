import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class student {
    public static void main(String[] args) {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("学生管理系统" + " \"请输入功能序号\"");
        while (i < 100) {
            System.out.println("==============================");
            System.out.println("1.输入学生信息" + "2.删除学生信息");
            System.out.println("3.查询学生信息" + "4.插入学生信息");
            System.out.println("5.学生学号排序" + "6.退出管理系统");
            System.out.println("==============================");

            switch (scanner.nextInt()) {
                case 1:
                    stu01 stu01 = new stu01();
                    stu01.to01();
                    break;
                case 2:
                    stu02 stu02 = new stu02();
                    stu02.too02();
                    break;
                case 3:
                    stu03 stu03 = new stu03();
                    stu03.Find();
                    break;
                case 4:
                    stu04 stu04 = new stu04();
                    stu04.too04();
                    break;
                case 5:
                    stu05 stu05 = new stu05();
                    stu05.too05();
                    break;
                case 6:
                    stu06 stu06 = new stu06();
                    System.out.println("退出成功");
                    stu06.exit();
                default:
                    System.out.println("输入错误重新输入！！！~~~~");
            }
            i++;
        }
    }

    static ArrayList<Student01> arrayList = new ArrayList<>();
    static ArrayList<Student01> students01 = new ArrayList<>();
}

class stu01 {
    public void to01() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + " " + "姓名" + " " + "学号" + " 专业成绩" + " 数学成绩" + " 英语成绩");
        String name = scanner.next();
        BigInteger studentID = scanner.nextBigInteger();
        String zhuanye = scanner.next();
        String math = scanner.next();
        String english = scanner.next();
        Student01 student01 = new Student01(name, studentID, zhuanye, math, english);
        boolean isDuplicate = false;
        for (int i = 0; i < student.arrayList.size(); i++) {
            Student01 x = student.arrayList.get(i);
            if (Objects.equals(x.studentID, studentID)) {
                System.out.println("学号重复请重新添加");
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            student.arrayList.add(student01);
            System.out.println("添加成功");
        }
    }
}

class stu02 {
    public void too02() {
        if (student.arrayList.isEmpty()) {
            System.out.println("没有学生信息");
            System.out.println("请添加学生信息");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入需要删除的姓名或者学号");
            String input = scanner.next();
            for (int i = 0; i < student.arrayList.size(); i++) {
                Student01 x = student.arrayList.get(i);
                if (input.equals(x.name) || input.equals(x.studentID.toString())) {
                    student.arrayList.remove(i);
                    break;
                }
            }
            System.out.println("删除成功");
        }
    }
}

class stu03 {
    public void Find() {
        if (student.arrayList.isEmpty()) {
            System.out.println("暂无信息");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择输入学生的学号或者姓名来进行查询");
        String input = scanner.next();
        int count = 0;
        for (int i = 0; i < student.arrayList.size(); i++) {
            Student01 x = student.arrayList.get(i);

            if (x.studentID.toString().equals(input) || x.name.equals(input)) {
                count++;
                if (count == 1) {
                    System.out.println("--------你的信息为---------");
                    System.out.println("姓名" + x.name + "学号" + x.studentID + " 专业成绩" + x.zhuanye + " 数学成绩" + x.math + " 英语成绩" + x.english);
                }
            } else if(count==student.arrayList.size()+1){
                System.out.println("没有查询到该学生，请重新查询");
            }
        }
    }
}
class stu04 {
    public void too04() {
        Scanner scanner = new Scanner(System.in);
        if (student.arrayList.isEmpty()) {
            System.out.println("暂无学生信息");
        } else {
            System.out.println("全部同学信息");
            for (int i = 0; i < student.arrayList.size(); i++) {
                Student01 x = student.arrayList.get(i);
                System.out.println("第" + (i + 1) + "位同学" + x.name + " " + x.studentID + " " + x.zhuanye + " " + x.math + " " + x.english + " ");
            }
            System.out.println("请填写插入位置");
            int where = scanner.nextInt();
            System.out.println("请输入姓名  学号    专业成绩    数学成绩   英语成绩");
            String name01 = scanner.next();
            BigInteger age01 = scanner.nextBigInteger();
            String zhuanye01 = scanner.next();
            String math01 = scanner.next();
            String english01 = scanner.next();
            Student01 stu02 = new Student01(name01, age01, zhuanye01, math01, english01);
            boolean charu = false;
            for (int i = 0; i < student.arrayList.size(); i++) {
                Student01 x01 = student.arrayList.get(i);
                if (Objects.equals(x01.studentID, age01)) {
                    System.out.println("学号重复，请重新填写");
                    charu = true;
                    break;
                }
            }
            if (!charu) {
                student.arrayList.add(where, stu02);
                System.out.println("添加成功");
            }
        }
    }
}

//              05为学生成绩排名
class stu05 {
    //todo   上面
    public void too05() {
//        paixu paixu = new paixu();
//        paixu.sort();
        //Student01.sout(student.arrayList);
        chengjisort chengjisort=new chengjisort();
        chengjisort.cjsort();
    }
}

class paixu {
    Student01[] students = new Student01[student.arrayList.size()];
    public void sort() {
        if (student.arrayList.isEmpty()) {
            System.out.println("暂无学生信息");
        }
        Student01 temp;
        for (int i = 0; i < student.arrayList.size(); i++) {
            students[i] = student.arrayList.get(i);
        }
        for (int j = 0; j < students.length; j++) {
            for (int k = 0; k < students.length - j - 1; k++) {
                if (students[k].studentID.compareTo(students[k + 1].studentID) > 0) {
                    temp = students[k];
                    students[k] = students[k + 1];
                    students[k + 1] = temp;
                }
            }
        }
        for (int i = 0; i < student.arrayList.size(); i++) {
            student.arrayList.set(i, students[i]);
            System.out.println(student.arrayList.get(i).name + student.arrayList.get(i).studentID +
             "专业成绩" + student.arrayList.get(i).zhuanye
             + "数学成绩" + student.arrayList.get(i).math + "英语成绩" + student.arrayList.get(i).english + "总成绩为"
             + (student.arrayList.get(i).math + student.arrayList.get(i).zhuanye + student.arrayList.get(i).english));
        }
    }
}
class chengjisort{
    public void cjsort(){
        student.students01 = new ArrayList<>();
        if(student.arrayList.isEmpty()){
            System.out.println("暂无学生信息");
        }
        student.students01.addAll(student.arrayList);
        for (int i = 0; i < student.students01.size(); i++) {
            for (int j = 0; j < student.students01.size()-i-1; j++) {
                if((Integer.parseInt(student.students01.get(j).math) + Integer.parseInt(student.students01.get(j).zhuanye) +Integer.parseInt(student.students01.get(j).english) )<
                ((Integer.parseInt(student.students01.get(j+1).math) + Integer.parseInt(student.students01.get(j+1).zhuanye) + Integer.parseInt(student.students01.get(j+1).english))))
                {
                    Student01 temp = student.students01.get(j);
                    student.students01.set(j, student.students01.get(j+1));
                    student.students01.set(j+1, temp);
                }
            }
        }
        for (int i = 0; i < student.students01.size(); i++) {
            System.out.println("di"+(i+1)+student.students01.get(i).name+"总成绩"+(Integer.parseInt(student.students01.get(i).math)
                    + Integer.parseInt(student.students01.get(i).zhuanye) +Integer.parseInt(student.students01.get(i).english) ));
        }

    }
}

class stu06 {
    public void exit() {
        System.exit(521);
    }
}

class Student01 {
    String name;
    BigInteger studentID;
    String zhuanye;
    String math;

    String english;

    public Student01(String name, BigInteger studentID, String zhuanye, String math, String english) {
        this.name = name;
        this.studentID = studentID;             //构造函数
        this.zhuanye = zhuanye;
        this.math = math;
        this.english = english;
    }

    public void put() {
        System.out.println(this.name + " " + this.studentID + "  " + this.zhuanye + "  " + this.math + " " + this.english);
    }


    public static void sout(ArrayList<Student01> students) {
        for (int i = 0; i < students.size(); i++) {
            students.get(i).put();
        }
    }
}
