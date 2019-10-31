package com.demos.springboot.hibernatejpademo.dal;

import java.util.List;

import com.demos.springboot.hibernatejpademo.entities.City;

public interface ICityDal {
	List<City> getAll();

	void add(City city);

	void update(City city);

	void delete(City city);
}
