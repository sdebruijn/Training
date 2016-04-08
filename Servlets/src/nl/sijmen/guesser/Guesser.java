package nl.sijmen.guesser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Guesser
 */
@WebServlet("/Guesser")
public class Guesser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guesser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//File file = new File("C:/Users/Student/workspace/ServletDemo1/index.txt");
		File head = new File(getServletContext().getRealPath("/head.html"));
		
		Scanner sc = new Scanner(head);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			response.getWriter().append(str+"\n");
		}
		sc.close();
	
		
		File foot = new File(getServletContext().getRealPath("/foot.html"));
		sc = new Scanner(foot);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			response.getWriter().append(str+"\n");
		}
		sc.close();

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
