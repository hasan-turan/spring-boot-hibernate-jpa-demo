package com.demos.springboot.hibernatejpademo.dal.hibernate;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demos.springboot.hibernatejpademo.dal.ICityDal;
import com.demos.springboot.hibernatejpademo.entities.City;

@Repository
public class HibernateCityDal implements ICityDal {

	private EntityManager entityManager;

	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // AOP -Aspect orianted programming: generates code blocks for transaction
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City", City.class).getResultList();
		return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.save(city);

	}

	@Override
	@Transactional
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToBeDeleted = this.getById(city.getId());
		session.delete(cityToBeDeleted);
	}

	@Override
	@Transactional
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(City.class, id);
	}

}
