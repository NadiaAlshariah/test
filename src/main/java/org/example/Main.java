package org.example;

import org.neo4j.driver.*;
import picocli.CommandLine;

public class Main
{
    public static void main( String[] args )
    {
        try (Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "12345678"))) {

        try (Session session = driver.session()) {
            try (Transaction tx = session.beginTransaction()) {
                Result result = tx.run("CREATE (n:Person {name: 'John Doe'}) RETURN n.name");
                tx.commit();
            }
        }
    }
        CommandLine.run(new MainCommand(), args);
    }
}
