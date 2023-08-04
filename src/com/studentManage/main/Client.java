package com.studentManage.main;

import com.studentManage.dao.StudentDao;
import com.studentManage.dao.StudentDaoInterface;
import com.studentManage.model.Student;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        StudentDaoInterface dao = new StudentDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Management App");
        while(true){
            System.out.println("\n1. Add Student"
            + "\n2. Show All Student"
            + "\n3. Get Student based on the roll number"
            + "\n4. Delete Student"
            + "\n5. Update Student"
            + "\n6. Exit\n");
            System.out.println("Enter Choice");
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Add Student:");
                    System.out.println("Enter student name:");
                    String name = sc.next();
                    System.out.println("Enter student college name:");
                    String clgName = sc.next();
                    System.out.println("Enter city:");
                    String city = sc.next();
                    System.out.println("Enter Percentage");
                    double percentage = sc.nextDouble();
                    Student st = new Student(name,clgName,city,percentage);

                    boolean ans = dao.insertStudent(st);
                    if(ans)
                        System.out.println("Record inserted successfully!!");
                    else
                        System.out.println("Something went wrong,Please try again....");
                    break;
                case 2:
                    System.out.println("Show All Student:");
                    dao.showAllStudent();
                    break;
                case 3:
                    System.out.println("Get Student based on rollNumber:");
                    System.out.println("Enter roll number");
                    int roll = sc.nextInt();
                    boolean f = dao.showStudentById(roll);
                    if(!f)
                        System.out.println("Student with this id is not available in our system");
                    break;
                case 4:
                    System.out.println("Delete Student:");
                    System.out.println("Enter roll number to delete");
                    int rollnum = sc.nextInt();
                    boolean ff = dao.delete(rollnum);
                    if(ff)
                        System.out.println("Record delete successfully....");
                    else
                        System.out.println("Something went wrong.");
                    break;
                case 5:
                    System.out.println("Update Student:");
                    System.out.println("\n1. Update name\n2. Update clgName\n3. Update City\n");
                    System.out.println("Enter Choice:");
                    int chi  = sc.nextInt();
                    if(chi == 1){
                        System.out.println("Enter roll number:");
                        int rNum = sc.nextInt();
                        System.out.println("Enter new Name:");
                        String nName = sc.next();
                        Student std = new Student();
                        std.setName(nName);
                        boolean flag = dao.update(rNum,nName,chi,std);
                        if(flag)
                            System.out.println("Name updated successfully...");
                        else
                            System.out.println("Something went wrong....");
                    }
                    else if(chi == 2){
                        System.out.println("Enter roll number:");
                        int rNum = sc.nextInt();
                        System.out.println("Enter new clgName:");
                        String nClgName = sc.next();
                        Student std = new Student();
                        std.setName(nClgName);
                        boolean flag = dao.update(rNum,nClgName,chi,std);
                        if(flag)
                            System.out.println("Name updated successfully...");
                        else
                            System.out.println("Something went wrong....");
                    }
                    else if(chi == 3){
                        System.out.println("Enter roll number:");
                        int rNum = sc.nextInt();
                        System.out.println("Enter new City:");
                        String nClgName = sc.next();
                        Student std = new Student();
                        std.setName(nClgName);
                        boolean flag = dao.update(rNum,nClgName,chi,std);
                        if(flag)
                            System.out.println("Name updated successfully...");
                        else
                            System.out.println("Something went wrong....");
                    }else
                    System.out.println("Enter correct choice......");
                    break;
                case 6:
                    System.out.println("Thank you for using the Application!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid choice.");
            }
        }
    }
}
