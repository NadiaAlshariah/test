package org.example;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4jSession {
    private static Session session;

    private Neo4jSession() {
        Configuration configuration = new Configuration.Builder()
                .uri("bolt://localhost:7687")
                .credentials("neo4j", "12345678")
                .connectionPoolSize(10)
                .build();

        SessionFactory sessionFactory = new SessionFactory(configuration, "org.example");
        session = sessionFactory.openSession();
    }

    public static synchronized Session getSession() {
        if (session == null){
            new Neo4jSession();
        }
        return session;
    }
}
