package com.in28minutes.rest.webservices.restfulwebservices.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	// Solo quiero mandar field1 y field2 en el response
	@GetMapping("/filtering")
	public MappingJacksonValue retireveSomeBean() {
		
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	// Solo quiero mandar field2 y field3 en el response
	@GetMapping("/filtering-list")
	public MappingJacksonValue retireveListOfSomeBeans() {
		
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
/*
	// Solo quiero mandar field2 y field3 en el response
	@GetMapping("/filtering-list")
	public List<SomeBean> retireveListOfSomeBeans() {
		
		return Arrays.asList(new SomeBean("value1","value2","value3"),
		new SomeBean("value12","value22","value32"));
	}*/
}