package org.onepoint.pim.repository;

import org.onepoint.pim.model.GenericContent;
import org.onepoint.pim.model.GenericDocument;
import org.springframework.data.repository.CrudRepository;

public interface GenericContentRepository extends CrudRepository<GenericContent, String> {
	
}