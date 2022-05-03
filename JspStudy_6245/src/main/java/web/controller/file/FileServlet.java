package web.controller.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import repository.FileDao;
import repository.file.FileEntity;
import web.service.FileService;
import web.service.FileServiceImpl;


@MultipartConfig( //jsp에서 "multipart/form-data"를 사용할 때 필요 
		fileSizeThreshold = 1024*1024,//메모리에 저장되는 임시파일 크기를 지정 (1MB)			
		maxFileSize = 1024*1024*50, //업로드 할 때 파일의 최대 크기 (50MB)
		maxRequestSize = 1024*1024*50*3 // 요청시에 최대 크기 (150MB)
		)
@WebServlet("/file-upload")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileService fileService;
	
       
	@Override
    public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		fileService = new FileServiceImpl((FileDao)servletContext.getAttribute("fileDao"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/file/file.jsp").forward(request, response);
	
	}
	//db에는 파일 명만 저장해서 저장소에서 같은 이름의 파일을 찾아 불러온다.		
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> fileList = new ArrayList<String>(); //arraylist에 FileEntity넣어 객체로 생성
		
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		for(Part part : parts) {
			String uuid =UUID.randomUUID().toString().replaceAll("-", "");
			
			String fileName = part.getSubmittedFileName();
			String tempFileName = uuid+"_"+fileName;
			
			InputStream is = part.getInputStream(); //파일 업로드
			String realPath = request.getServletContext().getRealPath("/static/fileupload"); // 저장할 위치 잡아주기
			File path = new File(realPath); //파일 객체에 path를 잡아줌
			if(!path.exists()) { //경로가 있는지 확인
				path.mkdirs(); //파일을 저장할 경로 만들기
			}
			
			String filePath = realPath + File.separator +fileName; //separator는 경로에 /나\ 알아서 처리함
			//filePath는 경로와 파일 이름 
			FileOutputStream fos = new FileOutputStream(filePath); 
			int size =0; //초기화
			byte[] buf = new byte[1024];
			while((size=is.read(buf)) !=-1) { 
				fos.write(buf,0,size);
			}
			fileList.add(tempFileName);
		}
		fileService.uploadFile(fileList);
		response.sendRedirect("/JspStudy_6245/file-upload");
				
	}

}
