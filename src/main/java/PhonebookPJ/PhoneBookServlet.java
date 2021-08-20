package PhonebookPJ;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pb")
public class PhoneBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if ("form".equals(actionName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/users/form.jsp");

			rd.forward(req, resp);

		} else if ("search".equals(actionName)) {
			PhoneBookDAO dao = new PhoneBookDAOImpl();
			String ser = req.getParameter("search");
			List<PhoneBookVo> list = dao.search(ser);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/users/list.jsp");
			req.setAttribute("list", list);
			rd.forward(req, resp);
		} else {
			PhoneBookDAO dao = new PhoneBookDAOImpl();
			List<PhoneBookVo> list = dao.getlist();
			req.setAttribute("list", list);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/users/list.jsp");

			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");

		if ("add".equals(actionName)) {
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");
			String tel = req.getParameter("tel");

			PhoneBookVo vo = new PhoneBookVo();
			vo.setName(name);
			vo.setHp(hp);
			vo.setTel(tel);

			PhoneBookDAO dao = new PhoneBookDAOImpl();
			int insertedCount = dao.insert(vo);

			resp.sendRedirect(req.getContextPath() + "/pb");

		} else if ("delete".equals(actionName)) {
			Long id = Long.valueOf(req.getParameter("id"));
			PhoneBookDAO dao = new PhoneBookDAOImpl();

			int deletedCount = dao.delete(id);
			resp.sendRedirect(req.getContextPath() + "/pb");
		} else {
			doGet(req, resp);
		}

	}
}
