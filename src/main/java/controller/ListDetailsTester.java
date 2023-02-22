package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Flight;
import model.ListDetails;
import model.Passenger;

public class ListDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Passenger cameron = new Passenger("Cameron");
		
		//PassengerHelper sh = new PassengerHelper();
		
		//sh.insertPassenger(cameron);
		
		Flight test1 = new Flight("Miami", "United", 1234);
		Flight test2 = new Flight("Target", "Spirit", 5678);
		
		List<Flight> cameronsFlight = new ArrayList<Flight>();
		cameronsFlight.add(test1);
		cameronsFlight.add(test2);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails cameronList = new ListDetails("Cameron's List", LocalDate.now(), cameron);
		cameronList.setListOfItems(cameronsFlight);
		
		ldh.insertNewListDetails(cameronList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}