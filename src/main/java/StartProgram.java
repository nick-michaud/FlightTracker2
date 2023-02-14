import java.util.List;
import java.util.Scanner;

import controller.FlightTrackerHelper;
import model.Flight;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static FlightTrackerHelper lih = new FlightTrackerHelper();

	// add a country
	private static void addAFlight() {
		System.out.print("Enter a Destination: ");
		String destination = in.nextLine();
		System.out.print("Enter an airline: ");
		String airline = in.nextLine();
		System.out.print("Enter a flight number: ");
		int flightNumber = in.nextInt();
		Flight toAdd = new Flight(destination, airline, flightNumber);
		lih.insertItem(toAdd);

	}

	// Delete a flight
	private static void deleteItem1() {
		System.out.print("Enter the destination to delete ");
		String destination = in.nextLine();
		System.out.print("Enter the airline to delete: ");
		String airline = in.nextLine();
		System.out.print("Enter the flight number to delete: ");
		int flightNumber = in.nextInt();
		Flight toDelete = new Flight(destination, airline, flightNumber);
		lih.deleteItem(toDelete);

	}

	// Edit a flight
	private static void editAFlight() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by destination");
		System.out.println("2 : Search by airline");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Flight> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the destination's name: ");
			String destinationName = in.nextLine();
			foundItems = lih.searchForItemByDestination(destinationName);
		} else {
			System.out.print("Enter the airline: ");
			String airlineName = in.nextLine();
			foundItems = lih.searchForItemByAirline(airlineName);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Flight l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Flight toEdit = lih.searchForFlightById(idToEdit);
			System.out.println("Retrieved " + toEdit.getDestination() + " from " + toEdit.getAirline() + "with"
					+ toEdit.getFlightNumber());
			System.out.println("1 : Update Destination");
			System.out.println("2 : Update Airline");
			System.out.println("3 : Update Flight Number");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Destination: ");
				String newDestination = in.nextLine();
				toEdit.setDestination(newDestination);
			} else if (update == 2) {
				System.out.print("New Airline: ");
				String newAirline = in.nextLine();
				toEdit.setAirline(newAirline);
			} else if (update == 3) {
				System.out.print("New Flight Number: ");
				int newFlightNumber = in.nextInt();
				toEdit.setFlightNumber(newFlightNumber);

			}

			lih.updateFlight(toEdit);

		} else {
			System.out.println("---- No results found----");
		}

	}

	public static void main(String[] args) {
		runMenu();

	}

	// Displays option for the user and calls FlightTrackerHelper to execute the
	// selection
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to Flight Tracker ---");
		while (goAgain) {
			System.out.println("*  Select and option below:");
			System.out.println("*  1 -- Add a Flight");
			System.out.println("*  2 -- Edit a Flight");
			System.out.println("*  3 -- Delete a Flight");
			System.out.println("*  4 -- View all Flights");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAFlight();
			} else if (selection == 2) {
				editAFlight();
			} else if (selection == 3) {
				deleteItem1();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	// view all flights
	private static void viewTheList() {
		List<Flight> allFlights = lih.showAllFlights();
		for (Flight singleFlight : allFlights) {
			System.out.println(singleFlight.returnItemDetails());
		}

	}

}
