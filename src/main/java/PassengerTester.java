import java.util.List;

import controller.PassengerHelper;
import model.Passenger;

public class PassengerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Passenger nick = new Passenger("Nick");
		PassengerHelper sh = new PassengerHelper();
		
		sh.insertPassenger(nick);
		
		Passenger jim = new Passenger("Jim");
		sh.insertPassenger(jim);
		
		List<Passenger> allPassengers = sh.showAllPassengers();
		for(Passenger a: allPassengers) {
			System.out.println(a.toString());
		}
	}
}