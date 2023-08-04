package com.studentManage.dao;

import com.studentManage.db.DBConnection;
import com.studentManage.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao implements StudentDaoInterface{
    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        try{
            Connection con = DBConnection.createConnection();
            String query = "insert into student_details(sname,clgname,city,percentage) value(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,s.getName());
            pst.setString(2, s.getClgName());
            pst.setString(3,s.getCity());
            pst.setDouble(4,s.getPercentage());
            pst.executeUpdate();
            flag = true;

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int roll) {
        boolean flag = false;

        try{
            Connection con = DBConnection.createConnection();
            String query = "delete from student_details where rollnum="+roll;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            flag = true;

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int roll, String update, int ch, Student s) {
        int choice = ch;
        boolean flag = false;
        if(choice == 1){
            try{
                Connection con = DBConnection.createConnection();
                String query = "update student_details set sname=? where rollnum =?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag =true;
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(choice == 2){
            try{
                Connection con = DBConnection.createConnection();
                String query = "update student_details set clgname=? where rollnum =?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag =true;
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(choice == 3){
            try{
                Connection con = DBConnection.createConnection();
                String query = "update student_details set city=? where rollnum =?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag =true;
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public void showAllStudent() {
        try {
            Connection con = DBConnection.createConnection();
            String query = "select * from student_details";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("RollNumber : "+rs.getInt(1)+"\nStudent Name : "+rs.getString(2)
                +"\ncollege Name : "+rs.getString(3)+"\nCity : "+rs.getString(4)+"\nPercentage : "+rs.getDouble(5));
                System.out.println("---------------------------");
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public boolean showStudentById(int roll) {
        try {
            Connection con = DBConnection.createConnection();
            String query = "select * from student_details where rollnum ="+roll;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("RollNumber : "+rs.getInt(1)+"\nStudent Name : "+rs.getString(2)
                        +"\ncollege Name : "+rs.getString(3)+"\nCity : "+rs.getString(4)+"\n5Percentage : "+rs.getDouble(5));
                System.out.println("---------------------------");
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
