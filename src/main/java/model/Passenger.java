package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")

public class Passenger {
	@Id
	@GeneratedValue
	private int id;
	private String passengerName;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(int id, String passengerName) {
		super();
		this.id = id;
		this.passengerName = passengerName;
	}
	public Passenger (String passengerName) {
		super();
		this.passengerName = passengerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", passengerName=" + passengerName + "]";
	}
	
	
}
