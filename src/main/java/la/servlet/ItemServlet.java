package la.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの文字コードを設定
		request.setCharacterEncoding("utf-8");
		try {
			// すべての商品を取得
			ItemDAO dao = new ItemDAO();
			List<ItemBean> list = dao.findAll();
			// 取得した商品リストをスコープに登録
			request.setAttribute("items", list);
			// 遷移先URLの設定
			String nextPage = "/items.jsp";
			// 遷移先URLに遷移
			gotoPage(request, response, nextPage);
		} catch (DAOException e) {
			// スタックトレースに表示
			e.printStackTrace();
			// エラーメッセージをスコープに登録
			request.setAttribute("message", "内部エラーが発生しました。");
			// エラーページに遷移
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 指定された画面にフォワードする
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @param nextPage 遷移先URL
	 * @throws ServletException
	 * @throws IOException
	 */
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	
}
