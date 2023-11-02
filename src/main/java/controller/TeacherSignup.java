package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDao;
import dto.Teacher;

@WebServlet("/teacherSignup")
public class TeacherSignup extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.fetchByEmail(email);
		
		if(teacher == null) {
			teacher = new Teacher();
			teacher.setName(name);
			teacher.setEmail(email);
			teacher.setPassword(password);
			teacher.setMobile(Long.parseLong(mobile));
			
			teacherDao.save(teacher);
			resp.getWriter().print("<h1>Signup is SuccessFull</h1>");
			req.getRequestDispatcher("TeacherLogin.html").include(req, resp);
		}else {
			resp.getWriter().print("<h1>Already Existing Email</h1>");
			req.getRequestDispatcher("TeacherSignup.html").include(req, resp);
		}
	}
}
