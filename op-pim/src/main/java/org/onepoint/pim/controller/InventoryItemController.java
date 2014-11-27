package org.onepoint.pim.controller;

import org.onepoint.pim.model.GenericContent;
import org.onepoint.pim.repository.GenericContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class InventoryItemController {

	@Autowired
	GenericContentRepository repository;

	@RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
	@ResponseBody
	GenericContent getContentById(@PathVariable String id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/content", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody GenericContent createContent(
			@RequestBody GenericContent content) throws JsonProcessingException {

		return repository.save(content);

	}

	@RequestMapping(value = "/content", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody GenericContent updateContent(
			@RequestBody GenericContent content) throws JsonProcessingException {

		return repository.save(content);
	}

	@RequestMapping(value = "/content/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteitem(@PathVariable String id) {

		repository.delete(id);
		return "OK biloute user deleted";
	}
}