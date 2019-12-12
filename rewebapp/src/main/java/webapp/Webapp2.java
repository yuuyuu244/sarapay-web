package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ooptest2
 */
@WebServlet("/Webapp2")
public class Webapp2 extends HttpServlet {
	private String encoding = "UTF-8";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html; charset="+encoding);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"ooptest.css\">");
		out.println("<title>メインメニュー</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>メインメニュー</h1>");
		out.println("<div>");
		out.println("<button id=\"b\" type=\"button\" onclick=\"location.href='./ooptest.html'\">"+"ログアウト");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}
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
//	}


}
