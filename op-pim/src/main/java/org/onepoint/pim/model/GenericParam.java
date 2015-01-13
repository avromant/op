package org.onepoint.pim.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.List;

/**
 * Created by AVROMA10 on 08/01/2015.
 */
@Document
public class GenericParam extends GenericDocument{

    @Field
    private List<String> params;

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
