package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.SearchMutterLogic;
import model.User;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");

		// つぶやきリストを取得して、リクエストスコープに保存
		SearchMutterLogic searchMutterLogic = new SearchMutterLogic();
		List<Mutter> mutterList = searchMutterLogic.execute(keyword);
		request.setAttribute("mutterList", mutterList);

		// ログインしているか確認するため
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		// ログインしていない
		if (loginUser == null) {
			// リダイレクト
			response.sendRedirect("/docoTsubuMysql/");
		} else { // ログイン済
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);

		}
	}

}