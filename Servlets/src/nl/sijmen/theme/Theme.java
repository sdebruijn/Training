package nl.sijmen.theme;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.sijmen.htmlwriter.HTMLWriter;

/**
 * Servlet implementation class Theme
 */
@WebServlet(name = "theme", urlPatterns = { "/theme" })
public class Theme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Theme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HTMLWriter html = new HTMLWriter();
		
		html.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\">"
				+ "<link rel=\"stylesheet\" href=\"style.css\">"
						+ "<title>Theme changer</title></head><body>"
						+ "<header><h1>Theme changer</h1></header><main>");
		
		html.append("<form method=\"post\" action=\"theme\">");
		html.append("<label for=\"kleur\">Kleur: </label>");
		
		html.append("<select name=\"kleur\">"+
			"<option value=\"yellow\">Yellow</option>" +
			"<option value=\"red\">Red</option>" +
			"<option value=\"blue\">Blue</option>" +
			"</select>");
		html.append("<input type=\"submit\" value=\"Select color\">");
		html.append("</form>");

		html.appendFile(getServletContext().getRealPath("/foot.html"));
		response.getWriter().append(html.toString());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strColor = request.getParameter("kleur");
		
		Cookie ck = new Cookie("color", strColor);
		response.addCookie(ck);
		
		
		
		HTMLWriter html = new HTMLWriter();
		html.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\">"
				+ "<link rel=\"stylesheet\" href=\"style.css\">");
		html.append("<style type=\"text/css\">body { background-color: "+strColor+";}</style>");
		html.append("<title>Theme changer</title></head><body>"
						+ "<header><h1>Theme changer</h1></header><main>");
		html.append("<p>You chose: " + strColor + "</p>");
		html.appendFile(getServletContext().getRealPath("/foot.html"));
		response.getWriter().append(html.toString());
	}
}
