package nl.sijmen.mastermind;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class game
 */
@WebServlet("/game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String GAMESTATE = "gamestate";
	public static final String ERROR = "error";
	public static final String GAME_JSP = "/WEB-INF/game.jsp";
	public static final String SUCCESS_JSP = "/WEB-INF/success.jsp";
	
	private MastermindState getGameState(HttpServletRequest r){
		return (MastermindState)r.getSession().getAttribute(GAMESTATE);
	}
	
	private void makeGameState(HttpServletRequest r){
		r.getSession().setAttribute(GAMESTATE, new MastermindState());
	}
	
	
	private int[] getGuess(HttpServletRequest req) {
		String input = req.getParameter("guess").trim().toLowerCase();
		System.out.println(input);
		// process string input to int array
		// 
		
		if(input == null || input.isEmpty()){
			return null;
		}
		
		MastermindState gs = getGameState(req);
		
		int length = gs.getLength();
		if (input.length() != length) {
			return new int[]{-1};
		}
	
		int[] result = new int[length];
		for (int i=0; i<length; i++) {
			char ch = input.charAt(i);
			int num = ch - '0';
			
			if (num < 0 || num > gs.getMaxColor()) {
				return new int[]{-1}; 
			}
			result[i] = num;
		}
		return result;
	}
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(getGameState(request) == null){
			makeGameState(request);
		}
				
		request.getRequestDispatcher(GAME_JSP).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MastermindState gs = getGameState(request);
		if(gs == null){
			doGet(request, response);
			return;
		}
		
		String error = null;
		int[] guess = getGuess(request);
		
		if (guess == null) {
			error = "Please enter your guess";
		} else if (guess[0] == -1) {
			error = "That's not a valid guess!";
		} else if (gs.isCode(guess)) {
			System.out.println("The correct code!!!! ");
			request.setAttribute(GAMESTATE, gs);
			request.getSession().invalidate();
			request.getRequestDispatcher(SUCCESS_JSP).forward(request, response);
			return;
		} else {
			int[] hint = gs.computeHint(guess);
			request.setAttribute("hint", hint);
		}

		request.setAttribute("error", error);
		request.getRequestDispatcher(GAME_JSP).forward(request, response);

	}

}
