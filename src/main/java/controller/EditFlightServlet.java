package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Flight;

/**
 * Servlet implementation class EditFlightServlet
 */
@WebServlet("/editFlightServlet")
public class EditFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FlightTrackerHelper dao = new FlightTrackerHelper();
		String destination = request.getParameter("destination");
		String airline = request.getParameter("airline");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Flight flightToUpdate = dao.searchForFlightById(tempId);
		try {
			int flightNumber = Integer.parseInt(request.getParameter("flight number"));
			flightToUpdate.setFlightNumber(flightNumber);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}

		flightToUpdate.setDestination(destination);
		flightToUpdate.setAirline(airline);

		dao.updateFlight(flightToUpdate);
		getServletContext().getRequestDispatcher("/viewAllFlightsServlet").forward(request, response);
	}

}
