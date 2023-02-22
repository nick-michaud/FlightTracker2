package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Passenger passenger;
	@OneToMany (cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Flight> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListDetails(int id, String listName, LocalDate tripDate, model.Passenger passenger,
			List<Flight> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.passenger = passenger;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate tripDate, model.Passenger passenger, List<Flight> listOfItems) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.passenger = passenger;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate tripDate, model.Passenger passenger) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.passenger = passenger;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public List<Flight> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<Flight> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", Passenger="
				+ passenger + ", listOfItems=" + listOfItems + "]";
	}
	
	
	
}
