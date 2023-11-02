package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeacherDao;
import dto.Teacher;

@WebServlet("/teacherLogin")
public class TeacherLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.fetchByEmail(email);
		
		if(teacher == null) {
			resp.getWriter().println("<h1>Invalid Email</h1>");
			req.getRequestDispatcher("TeacherLogin.html").include(req, resp);
		}else {
			if(teacher.getPassword().equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("teacher", teacher);
				resp.getWriter().print("<h1>Login Success full</h1>");
				req.getRequestDispatcher("StudentGradee.jsp").include(req, resp);
			}else {
				resp.getWriter().println("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("TeacherLogin.html").include(req, resp);
			}
		}
		
		
	}
}
