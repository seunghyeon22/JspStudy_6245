package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import db.DBConnectionMgr;
import repository.AuthDao;
import repository.AuthDaoImpl;
import repository.FileDao;
import repository.FileDaoImpl;
import repository.UserDao;
import repository.UserDaoImpl;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName = "servletContextInit")
public class InitFilter implements Filter {
	private DBConnectionMgr pool;
	private AuthDao authDao;
	private UserDao userDao;
	private FileDao fileDao;

	public void init(FilterConfig fConfig) throws ServletException {
		pool = DBConnectionMgr.getInstance();
		authDao = new AuthDaoImpl(pool);
		userDao = new UserDaoImpl(pool);
		fileDao = new FileDaoImpl(pool);
		
		ServletContext servletContext =  fConfig.getServletContext(); //전부 공유하는 영역(어플리케이션)
		servletContext.setAttribute("authDao", authDao);
		servletContext.setAttribute("userDao", userDao);
		servletContext.setAttribute("fileDao", fileDao);

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		
	}

	public void destroy() {

	}

}
