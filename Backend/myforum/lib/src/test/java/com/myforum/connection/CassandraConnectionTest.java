package com.myforum.connection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.datastax.oss.driver.api.core.CqlSession;

@SpringBootTest
public class CassandraConnectionTest {

    @Autowired
    private CqlSession session;

    @Test
    void testConnection() {
        System.out.println("Connected to cluster: " + session.getMetadata().getClusterName());
    }
}
