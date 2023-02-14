package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Flight;

public class FlightTrackerHelper {
		// Create database connection
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FlightTracker2");

		public void insertItem(Flight li) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(li);
			em.getTransaction().commit();
			em.close();

		}

		//Query flight table in database and return all rows
		public List<Flight> showAllFlights() {
			EntityManager em = emfactory.createEntityManager();
			List<Flight> allFlights = em.createQuery("SELECT i from Flight i").getResultList();
			return allFlights;

		}

		//Delete a row selected by the user from the flight table
		public void deleteItem(Flight toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Flight> typedQuery = em.createQuery(
					"select li from Flight li where li.destination = :selectedDestination and li.airline = :selectedAirline and li.flightNumber = :selectedFlightNumber",
					Flight.class);

			typedQuery.setParameter("selectedDestination", toDelete.getDestination());
			typedQuery.setParameter("selectedAirline", toDelete.getAirline());
			typedQuery.setParameter("selectedFlightNumber", toDelete.getFlightNumber());

			typedQuery.setMaxResults(1);

			Flight result = typedQuery.getSingleResult();

			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}

		//Query flight table using ID
		public Flight searchForFlightById(int idToEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();

			Flight found = em.find(Flight.class, idToEdit);
			em.close();
			return found;
		}

		//Update flight in flight table using user selections
		public void updateFlight(Flight toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();

			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}

		//Query flight table by using Destination
		public List<Flight> searchForItemByDestination(String destinationName) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Flight> typedQuery = em.createQuery("select li from Flight li where li.destination = :selectedDestination",
					Flight.class);

			typedQuery.setParameter("selectedDestination", destinationName);

			List<Flight> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}

		//Query flight table by using airline name
		public List<Flight> searchForItemByAirline(String airlineName) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Flight> typedQuery = em.createQuery("select li from Flight li where li.airline = :selectedAirline",
					Flight.class);

			typedQuery.setParameter("selectedAirline", airlineName);

			List<Flight> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}

		//Query flight table by using flight number
		public List<Flight> searchForItemByFlightNumber(String flightNum) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Flight> typedQuery = em.createQuery("select li from Flight li where li.flightNumber = :selectedFlightNumber",
					Flight.class);

			typedQuery.setParameter("selectedFlightNumber", flightNum);

			List<Flight> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}

		// Closing the Entity Manager Factory
		public void cleanUp() {
			emfactory.close();
		}

	}

