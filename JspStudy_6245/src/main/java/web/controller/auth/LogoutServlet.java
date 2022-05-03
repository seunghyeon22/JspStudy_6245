package web.controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //로그아웃  페이지
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션 가져오기
		session.invalidate();// 세션 삭제
		response.sendRedirect("/JspStudy_6245/auth/signin");
	}

}
