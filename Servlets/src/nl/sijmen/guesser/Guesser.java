package nl.sijmen.guesser;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.sijmen.htmlwriter.HTMLWriter;

/**
 * Servlet implementation class Guesser
 */
@WebServlet("/guesser")
public class Guesser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int secret;
	private static int tries;
	private static final int max = 128;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Guesser() {
		super();
		init();
	}

	/**
	 * init()
	 */
	public void init() {
		secret = new Random().nextInt(max) + 1;
		tries = 1; // sdf
	}

	private String processGuess(int i) {
		if (i <= 0 || i>max) {
			throw new NumberFormatException("The number must be within range (0,"+max+")");
		}
		
		tries++;
		if (secret < i) {
			return "<span i=\"guess\">Lower</span>";
		} else if (secret > i) {
			return "<span i=\"guess\">Higher</span>";
		} else if (secret == i) {
			String winMsg = "<span id=\"win\">Nice!! The number was indeed " + i + ".</span><br/><br/>" + "You needed "
					+ (tries - 1) + " turns." + "<p>Start a new game directly by inputting your next guess!";
			init();
			return winMsg;
		}
		throw new RuntimeException("This may not happen");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HTMLWriter html = new HTMLWriter();
		html.appendFile(getServletContext().getRealPath("/head.html"));

		html.append("<h2>Guess the secret number (below "+max+")</h3>");
		String guess = request.getParameter("guess");
		if (guess != null) {
			try {
				int i = Integer.parseInt(guess.trim());

				html.append("<p>You guessed: " + i  + "    (turn: " + tries + ")</p>");
				String str = processGuess(i);
				html.append(str);

			} catch (NumberFormatException e) {
				html.append("<p class=error>You must enter number between 0-"+max+" (not inclusive)</p>");
			}

		}

		html.append("<form method=\"get\" action=\"guesser\">");
		html.append("<label for=\"guess\">Input a number: </label>");
		html.append("<input type=\"number\" min=\"1\" max=\""+max+"\" step=\"1\" name=\"guess\" autofocus><br/>");
		html.append("<input type=\"submit\" style=\"display:none\">");
		html.append("</form>");

		html.appendFile(getServletContext().getRealPath("/foot.html"));
		response.getWriter().append(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
