package org.example;

import org.neo4j.driver.*;
import org.neo4j.driver.AuthTokens;
import picocli.CommandLine;

public class Main
{
    public static void main( String[] args )
    {
        try (Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "12345678"))) {
            System.out.println("driver is here");
        try (Session session = driver.session()) {
            System.out.println("session is here");
            try (Transaction tx = session.beginTransaction()) {
                System.out.println("transaction is here");
                Result result = tx.run("CREATE (n:Person {name: 'John Doe'}) RETURN n.name");
                tx.commit();
            }
        }
    }
        int exitCode = new CommandLine(new MainCommand()).execute(args);
        System.exit(exitCode);
    }
}
