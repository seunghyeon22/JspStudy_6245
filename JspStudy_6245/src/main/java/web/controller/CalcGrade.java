package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/calc-grade")
public class CalcGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String[] subject = request.getParameterValues("subject");
		String[] grade = request.getParameterValues("grade");
		String[] time = request.getParameterValues("time");

		double gradeScore = 0.0;
		int totalTime=0;
		double gradeAvg =0;
		
		for(int i=0;i<subject.length;i++){
			totalTime+=Integer.parseInt(time[i]);
			if(grade[i].equals("A+")){
				gradeScore +=(4.5*Integer.parseInt(time[i]));
			}else if(grade[i].equals("A")){
				gradeScore +=(4.0*Integer.parseInt(time[i]));
			}else if(grade[i].equals("B+")){
				gradeScore +=(3.5*Integer.parseInt(time[i]));
			}else if(grade[i].equals("B")){
				gradeScore +=(3.0*Integer.parseInt(time[i]));
			}else if(grade[i].equals("C+")){
				gradeScore +=(2.5*Integer.parseInt(time[i]));
			}else if(grade[i].equals("C")){
				gradeScore +=(2.0*Integer.parseInt(time[i]));
			}else if(grade[i].equals("D+")){
				gradeScore +=(1.5*Integer.parseInt(time[i]));
			}else if(grade[i].equals("D")){
				gradeScore +=(1.0*Integer.parseInt(time[i]));
			}else{
				gradeScore +=0; 
			}
		}
		
		gradeAvg = gradeScore/totalTime;	
		
		//System.out.println(gradeAvg);
		
		//request.setAttribute("grade", gradeAvg);
		

		//StringBuilder
		//builder.append
		
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("<body>");
		builder.append("<script>");
		builder.append("alert(\"총평점:"+gradeAvg+"\");");
		builder.append("history.back();");
		builder.append("</script>");	
		builder.append("</body>");

		out.write(builder.toString());
		
	}

}
