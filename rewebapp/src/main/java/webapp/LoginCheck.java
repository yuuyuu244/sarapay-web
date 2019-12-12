package webapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {

	private final String HOST = "localhost";
	private final String DB_NAME = "webbapp";
	private final String TB_NAME = "user";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession(true);

		System.out.println("ID \t\t:[" + id + "]");
		System.out.println("PASSWORD \t:[" + pass + "]");

		String pagePath = "ng.jsp";
		// check the user account.
		if (user(id, pass)) {
			pagePath = "ok.jsp";
		}

		RequestDispatcher dispatch = request.getRequestDispatcher(pagePath);
		dispatch.forward(request, response);

	}

	protected boolean user(String id, String pass) {
		// nullのとき
		if (id == null) {
			System.out.println("id is null value.");
			return false;
		}
		// lengthが0のとき
		if (id.length() == 0) {
			System.out.println("id is empty.");
			return false;
		}
		if(pass == null) {
			System.out.println("password is null value.");
			return false;
		}
		if (pass.length() == 0) {
			System.out.println("password is empty.");
			return false;
		}
		try {
			String sql = "select * from " + TB_NAME + " where id = ? and password = ?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc://" + HOST + "/" +DB_NAME + "?serverTimezone="
					+ "JST", "root", "root");

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("exist ID/PASSWORD pattern.");
				return true;
			} else {
				System.out.println("doesn't exist ID/PASSWORD pattern.");
				return false;
			}
		} catch (Exception ex) {
			String msg = "ドライバのロードに失敗しました";
			return false;
		}
	}

}
