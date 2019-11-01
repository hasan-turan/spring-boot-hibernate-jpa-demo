package com.demos.springboot.hibernatejpademo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demos.springboot.hibernatejpademo.entities.City;
import com.demos.springboot.hibernatejpademo.service.ICityService;

@RestController
@RequestMapping(value = "/api/cities")
public class CityController {

	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping(value = { "/" })
	public List<City> getAll() {
		return cityService.getAll();
	}

	@PostMapping(value = "/add")
	public void add(@RequestBody City city) {
		cityService.add(city);
	}

	@PostMapping(value = "/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}

	@PostMapping(value = "/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}

	@GetMapping(value = "/{id}")
	public City getById(@PathVariable int id) {
		return cityService.getById(id);
	}
}
