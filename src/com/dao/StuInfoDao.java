package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StuInfoDao {
    //查
    public List<Student> queryStu();

    //增
    public int addStu(Student stu);

    // 删
    public int delStu(Student stu);

    // 改
    public int altStu(Student stu);

    //通过id返回学员信息
    public List<Student> queryStuId(int id);
}
