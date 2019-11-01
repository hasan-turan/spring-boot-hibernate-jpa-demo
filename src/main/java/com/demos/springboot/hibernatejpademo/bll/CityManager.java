package com.demos.springboot.hibernatejpademo.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demos.springboot.hibernatejpademo.dal.ICityDal;
import com.demos.springboot.hibernatejpademo.entities.City;
import com.demos.springboot.hibernatejpademo.service.ICityService;

@Service
public class CityManager implements ICityService {

	private ICityDal cityDal;

	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		cityDal.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		cityDal.delete(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		return cityDal.getById(id);
	}

}
