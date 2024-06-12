package com.service.Impl;

import com.pojo.Student;
import com.service.StuInfoSer;

import java.util.List;

import static com.util.Vessel.stuInfoDao;

public class StuInfoSerImpl implements StuInfoSer {
    @Override
    public List<Student> queryStu() {
        return stuInfoDao.queryStu();
    }

    @Override
    public int addStu(Student stu) {
        return stuInfoDao.addStu(stu);
    }

    @Override
    public int delStu(Student stu) {
        return stuInfoDao.delStu(stu);
    }

    @Override
    public int altStu(Student stu) {
        return stuInfoDao.altStu(stu);
    }

    @Override
    public List<Student> queryStuId(int id) {
        return stuInfoDao.queryStuId(id);
    }
}
