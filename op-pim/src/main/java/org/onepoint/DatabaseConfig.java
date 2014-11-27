package org.onepoint;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories
public class DatabaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    protected List<String> bootstrapHosts() {
    	return Arrays.asList("127.0.0.1");
    }

    @Override
    protected String getBucketName() {
        return "products";
    }

    @Override
    protected String getBucketPassword() {
        return "";
    }
}
