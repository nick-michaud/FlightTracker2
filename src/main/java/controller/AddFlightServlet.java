package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Flight;

/**
 * Servlet implementation class AddFlightServlet
 */
@WebServlet("/addFlightServlet")
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String destination = request.getParameter("destination");
		String airline = request.getParameter("airline");
		try {
			int flightNumber = Integer.parseInt(request.getParameter("flight number"));
			Flight li = new Flight(destination, airline, flightNumber);
			FlightTrackerHelper dao = new FlightTrackerHelper();
			dao.insertItem(li);

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println("Flight Number must be an integer");
		}

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
