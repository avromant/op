package org.onepoint.pim.model.catalog;

import org.onepoint.pim.model.GenericContent;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Node extends GenericContent {
	
	@Field
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
