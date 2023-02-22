package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Passenger;

public class PassengerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FlightTracker2");

	public void insertPassenger(Passenger s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<Passenger> showAllPassengers(){
		EntityManager em = emfactory.createEntityManager();
		List<Passenger> allPassengers = em.createQuery("SELECT s from Passenger s").getResultList();
		return allPassengers;
	}
	public Passenger findPassenger(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Passenger> typedQuery = em.createQuery("SELECT pa from Passenger pa where pa.passengerName = :selectedName",Passenger.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Passenger foundPassenger;
		try {
			foundPassenger = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundPassenger = new Passenger(nameToLookUp);
		}
		em.close();

		return foundPassenger;
	}
}

