package com.myforum.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AstraConfig {

    @Value("${datastax.astra.db.id}")
    private String astraId;

    @Value("${datastax.astra.db.region}")
    private String astraRegion;

    @Value("${datastax.astra.db.keyspace}")
    private String astraKeyspace;

    @Value("${datastax.astra.db.token}")
    private String astraToken;

    public String getAstraId() {
        return astraId;
    }

    public String getAstraRegion() {
        return astraRegion;
    }

    public String getAstraKeyspace() {
        return astraKeyspace;
    }

    public String getAstraToken() {
        return astraToken;
    }
}
