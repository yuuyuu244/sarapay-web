package webapp;

import java.io.IOException;

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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession(true);

//		boolean check = user(id,pass);
//		if(check==true) {
			RequestDispatcher dispatch =request.getRequestDispatcher("Webapp2");
//			dispatch.forward(request,response);
//		}
//
//	}
//	protected boolean user(String id,String pass) {
//		if (id == null || id.length() == 0 || pass == null || pass.length() == 0){
//		      return false;
//		    }
//		try {
//			String sql = "select * from user where id = ? and password = ?" ;
//			Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc://192.168.10.11/webapp?serverTimezone="
//						+ "JST","root","root");
//
//				PreparedStatement stmt = con.prepareStatement(sql);
//				stmt.setString(1,id);
//				stmt.setString(2,pass);
//				ResultSet rs = stmt.executeQuery();
//
//				if (rs.next()){
//			        return true;
//			      }else{
//			        return false;
//			      }
//			}catch(Exception ex) {
//				String msg = "ドライバのロードに失敗しました";
//				return false;
//			}
	}


}
