package org.onepoint.pim.controller;

import org.onepoint.pim.model.GenericContent;

import org.onepoint.pim.repository.GenericContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

	@Autowired
	GenericContentRepository repository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 @ResponseBody
	GenericContent getContentById(@PathVariable String id) {
		return repository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	Iterable<GenericContent> getAllContent() {
		return repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody GenericContent createContent(
			@RequestBody GenericContent content) throws JsonProcessingException {

		return repository.save(content);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody GenericContent updateContent(
			@RequestBody GenericContent content) throws JsonProcessingException {

		return repository.save(content);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteContent(@PathVariable String id) {

		repository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}