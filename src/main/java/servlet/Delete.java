package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteMutterLogic;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメーターからID取得
		// 〇idが型の不一致のため型変換、インテジャー使う(string→int)
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		// DeleteMutterLogicインスタンスの生成
		DeleteMutterLogic delMutterLogic = new DeleteMutterLogic();
		
		// DeleteMutterLogicの処理を実行
		delMutterLogic.execute(id);

		//リダイレクト
		response.sendRedirect("/docoTsubuMysql/Main");
	}

}
