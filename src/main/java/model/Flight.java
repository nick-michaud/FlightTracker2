package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name="DESTINATION")
	private String destination;
	@Column(name = "AIRLINE")
	private String airline;
	@Column(name="FLIGHTNUMBER")
	private int flightNumber;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(String destination, String airline, int flightNumber) {
		super();
		this.destination = destination;
		this.airline = airline;
		this.flightNumber = flightNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", destination=" + destination + ", airline=" + airline + ", flightNumber="
				+ flightNumber + "]";
	}

	public String returnItemDetails() {
		return "Destination: " + this.destination + ", Airline: " + this.airline + ", Flight Number: " + this.flightNumber;
	}
}
