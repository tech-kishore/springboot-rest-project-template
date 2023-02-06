package com.kishore.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("filtering") // error response will display because '@JsonFilter("SimpleFilter")' is added in
								// SomeBean and MappingJacksonValue filter is not implemented here
	public SomeBean filtering() {
		return new SomeBean(1, "Some_User_Name", "Some_user_Address");
	}

	@GetMapping("dynamic-filtering-list") // error response will display because '@JsonFilter("SimpleFilter")' is added
											// in SomeBean and MappingJacksonValue filter is not implemented here
	public List<SomeBean> filteringList() {
		List<SomeBean> list = someBeansList();
		return list;
	}

	@GetMapping("dynamic-filtering") // filtering out 'id' dynamically
	public MappingJacksonValue dynamicFiltering() {

		List<SomeBean> list = someBeansList();

//		SomeBean someBean = new SomeBean(1, "Some_User_Name", "Some_user_Address");
//		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "address");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SimpleFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

	@GetMapping("dynamic-filtering-address") // filtering out 'address' dynamically
	public MappingJacksonValue dynamicAddressFiltering() {

		List<SomeBean> list = someBeansList();

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

		Set<String> properties = new HashSet<>();
		properties.add("id");
		properties.add("name");
		createFilter(mappingJacksonValue, properties);
		return mappingJacksonValue;
	}

	private void createFilter(MappingJacksonValue mappingJacksonValue, Set<String> filterProperties) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filterProperties);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SimpleFilter", filter); // add
																								// '@JsonFilter("SimpleFilter")'
																								// in SomeBean
		mappingJacksonValue.setFilters(filters);
	}

	private List<SomeBean> someBeansList() {
		List<SomeBean> list = new ArrayList<>();
		list.add(new SomeBean(1, "Some_User_Name", "Some_user_Address"));
		list.add(new SomeBean(2, "1_User_Name", "1_user_Address"));
		list.add(new SomeBean(3, "2_User_Name", "2_user_Address"));
		return list;
	}

}
