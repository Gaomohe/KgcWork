package com.servlet;

import com.pojo.Student;
import com.util.BaseServlet;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static com.util.Vessel.stuInfoSer;

@WebServlet("/student")
public class StudentServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return StudentServlet.class;
    }

    public String queryStu(HttpServletRequest request, HttpServletResponse response){
        List<Student> studentList = stuInfoSer.queryStu();
        HttpSession session = request.getSession();
        session.setAttribute("studentList",studentList);
        return "queryStu";
    }

    public ResultData stuDel(HttpServletRequest request, HttpServletResponse response){
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Student student = new Student();
        student.setsId(id);
        int num = stuInfoSer.delStu(student);

        ResultData resultData = new ResultData();
        if(num > 0){
            resultData.setStatus(200);
            resultData.setMsg("delete complete");
            resultData.setData(null);
        }else {
            resultData.setStatus(200);
            resultData.setMsg("delete ");
            resultData.setData(null);
        }
        return resultData;
    }

    public String findStu(HttpServletRequest request, HttpServletResponse response){
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        List<Student> stuList = stuInfoSer.queryStuId(id);
        HttpSession session = request.getSession();
        session.setAttribute("stuList",stuList);
        return "stuAlter";
    }

}
