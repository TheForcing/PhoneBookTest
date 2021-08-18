package PhonebookPJ;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PhoneBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String actionName=req.getParameter("a");
	  if("joinform".equals(actionName)) {
		  
	  
		
		RequestDispatcher rd=
			   req.getRequestDispatcher("/WEB-INF/users/joinform.jsp");
	      rd.forward(req,resp);
	  }else if ("jointsuccess".equals(actionName)) {
		  RequestDispatcher rd= 
				  req.getRequestDispatcher("/WEB-INF/user/joinform.jsp");
		  rd.forward(req, resp);
		  
	  }else if("logout".equals(actionName)) {
		  HttpSession session = req.getSession(false);
		  session.removeAttribute(actionName);
		  session.invalidate();
		  resp.sendRedirect(req.getContextPath());
	  }
	  else {
		  resp.sendError(404);
	  }
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String actionName= req.getParameter("a");
	   if("join".equals(actionName)) {
		   PhoneBookVo vo= new PhoneBookVo();
		   String name = req.getParameter("name");
		   String hp= req.getParameter("hp");
		   String tel=req.getParameter("tel");
		   
		   vo.setName(name);
		   vo.setHp(hp);
		   vo.setTel(tel);
		   System.out.println("PhoneBookVo:"+vo);
	   }
	}
	

}
