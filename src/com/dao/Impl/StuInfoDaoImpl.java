package com.dao.Impl;

import com.dao.StuInfoDao;
import com.pojo.Student;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StuInfoDaoImpl implements StuInfoDao {

    //查询
    @Override
    public List<Student> queryStu() {
        String sql = "SELECT * FROM studentinfo  WHERE sid > ? ORDER BY sid DESC";
        Object[] obj = new Object[1];
        obj[0] = 0;
        ResultSet resultSet = JDBC.query(sql, obj);
        List<Student> stuList = new ArrayList<Student>();
        try{
            while(resultSet.next()){
                Student stu = new Student();
                stu.setsId(resultSet.getInt("sid"));
                stu.setsName(resultSet.getString("sname"));
                stu.setsGender(resultSet.getString("sgender"));
                stu.setsAge(resultSet.getInt("sage"));
                stu.setsAddress(resultSet.getString("saddress"));
                stu.setsEmail(resultSet.getString("semail"));
                stuList.add(stu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return stuList;
    }

    //增
    @Override
    public int addStu(Student stu) {
        String sql = "INSERT INTO studentInfo(sname, sgender, sage, saddress, semail) VALUE (?,?,?,?,?)";
        Object[] objects = new Object[5];
        objects[0] = stu.getsName();
        objects[1] = stu.getsGender();
        objects[2] = stu.getsAge();
        objects[3] = stu.getsAddress();
        objects[4] = stu.getsEmail();
        int alter = JDBC.alter(sql, objects);
        return alter;
    }

    //删
    @Override
    public int delStu(Student stu) {
        String sql = "DELETE FROM studentinfo WHERE sid = ?";
        Object[] objects = new Object[1];
        objects[0] = stu.getsId();
        int alter = JDBC.alter(sql, objects);
        return alter;
    }

    //改
    @Override
    public int altStu(Student stu) {
        String sql = "UPDATE studentInfo SET sname = ?,sgender = ?, sage = ?, saddress = ?, semail = ?\n" +
                "WHERE sid = ?";
        Object[] objects = new Object[6];
        objects[0] = stu.getsName();
        objects[1] = stu.getsGender();
        objects[2] = stu.getsAge();
        objects[3] = stu.getsAddress();
        objects[4] = stu.getsEmail();
        objects[5] = stu.getsId();
        int alter = JDBC.alter(sql, objects);
        return alter;
    }

    @Override
    public List<Student> queryStuId(int id) {
        String sql = "SELECT * FROM studentinfo  WHERE sid = ?";
        Object[] objects = new Object[1];
        objects[0] = id;
        ResultSet resultSet = JDBC.query(sql,objects);
        List<Student> studentList = new ArrayList<Student>();
        try{
            while(resultSet.next()){
                Student stu = new Student();
                stu.setsId(resultSet.getInt("sid"));
                stu.setsName(resultSet.getString("sname"));
                stu.setsGender(resultSet.getString("sgender"));
                stu.setsAge(resultSet.getInt("sage"));
                stu.setsAddress(resultSet.getString("saddress"));
                stu.setsEmail(resultSet.getString("semail"));
                studentList.add(stu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
}
