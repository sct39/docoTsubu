package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UpdateMutterLogic;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメーターからIDを取得
		// main.jspの更新ボタンのIDのこと
		String id = request.getParameter("id");

		// 〇リクエストスコープにIDを保存
		// あまってるIDをそのまま使っちゃえーでupdate.jspで使用
		request.setAttribute("id", id);

		// 編集画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメーターからIDとTEXTを取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String text = request.getParameter("text");

		// UpdateMutterLogicインスタンスの生成
		UpdateMutterLogic updmutterLogic = new UpdateMutterLogic();

		// updatemutterlogicの処理を実行
		updmutterLogic.execute(id, text);

		// リダイレクト
		response.sendRedirect("/docoTsubuMysql/Main");

	}
}