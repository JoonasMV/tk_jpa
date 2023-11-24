package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import entity.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

	public void saveDevice(Device device) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(device);
        
        em.getTransaction().commit();
        em.close();
	}

	public Device getDevice(int id) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Device device = em.find(Device.class, id);

		em.getTransaction().commit();
		em.close();
		return device;
	}

	public boolean updateDeviceDescription(int id, String newDescription) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		try {
			Device device = em.find(Device.class, id);
			device.setDescription(newDescription);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			em.close();
			return false;
		}
	}

	public boolean deleteDevice(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		try {
			Device device = em.find(Device.class, id);
			em.remove(device);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			em.close();
			return false;
		}

	}
}
