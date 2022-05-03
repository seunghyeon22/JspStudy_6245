package web.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnectionMgr;
import repository.AuthDao;
import repository.AuthDaoImpl;
import web.service.AuthService;
import web.service.AuthServiceImpl;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/auth/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthService authService;
	
	@Override
		public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		authService = new AuthServiceImpl((AuthDao)servletContext.getAttribute("authDao"));
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/auth/signin.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Map<String, ?> msg = authService.signin(username, password);
		
		if(msg.containsKey("200")) {
			HttpSession session =request.getSession();
			session.setAttribute("principalUser", authService.getUser(username));
			response.sendRedirect("/JspStudy_6245/profile/mypage");
			//request.getRequestDispatcher("WEB-INF/views/profile/myPage.jsp").forward(request, response);
			
		}else {
			StringBuilder builder = new StringBuilder();
			builder.append("<body>");
			builder.append("<script>");
			builder.append("alert(\"" + (msg.containsKey("400")?msg.get("400"):msg.get("500")) + "\");");
			builder.append("history.back();");
			builder.append("</script>");
			builder.append("</body>");
			
			out.print(builder.toString());
		}
		
		//request.setAttribute("signin-flage", authService.signin(username, password));
		//request.getRequestDispatcher()
		
	}
}
