package com.demos.springboot.hibernatejpademo.service;

import java.util.List;

import com.demos.springboot.hibernatejpademo.entities.City;

public interface ICityService {

	City getById(int id);

	List<City> getAll();

	void add(City city);

	void update(City city);

	void delete(City city);
}
