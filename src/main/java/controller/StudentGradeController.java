package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDao;
import dto.StudentGrade;
import dto.Teacher;

@WebServlet("/studentGrade")
public class StudentGradeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Teacher teacher = (Teacher) req.getSession().getAttribute("teacher");
		if(teacher == null) {
			resp.getWriter().println("<h1>Session Experide</h1>");
			req.getRequestDispatcher("TeacherLogin.html").include(req, resp);
		}else {
		
		String name = req.getParameter("name");
		int classs = Integer.parseInt(req.getParameter("classs"));
		int sub1 = Integer.parseInt(req.getParameter("sub1"));
		int sub2 = Integer.parseInt(req.getParameter("sub2"));
		int sub3 = Integer.parseInt(req.getParameter("sub3"));
		int sub4 = Integer.parseInt(req.getParameter("sub4"));
		int sub5 = Integer.parseInt(req.getParameter("sub5"));
		int sub6 = Integer.parseInt(req.getParameter("sub6"));
		
		StudentGrade grade = new StudentGrade();
		grade.setName(name);
		grade.setClasss(classs);
		grade.setSub1(sub1);
		grade.setSub2(sub2);
		grade.setSub3(sub3);
		grade.setSub4(sub4);
		grade.setSub5(sub5);
		grade.setSub6(sub6);
		
		List<StudentGrade> list = teacher.getGrade();
		if(list == null) {
			list = new ArrayList(list);
		}
		list.add(grade);
		teacher.setGrade(list);
		
		TeacherDao dao = new TeacherDao();
		dao.save(grade);
		dao.update(teacher);
		
		resp.getWriter().println("<h1 style='color:Red>Student Add Successfully</h1>");
		req.setAttribute("list", teacher.getGrade());
		req.getRequestDispatcher("StudentGradee.jsp").include(req, resp);
	}
	}
}
