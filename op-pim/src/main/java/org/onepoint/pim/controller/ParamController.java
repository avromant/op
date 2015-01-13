package org.onepoint.pim.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.onepoint.pim.model.GenericParam;
import org.onepoint.pim.repository.GenericParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/params")
public class ParamController {

	@Autowired
	GenericParamRepository repository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	GenericParam getContentById(@PathVariable String id) {
		return repository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	Iterable<GenericParam> getAllContent() {
		return repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody GenericParam createContent(
			@RequestBody GenericParam content) throws JsonProcessingException {

		return repository.save(content);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody GenericParam updateContent(
			@RequestBody GenericParam content) throws JsonProcessingException {

		return repository.save(content);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteContent(@PathVariable String id) {

		repository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}