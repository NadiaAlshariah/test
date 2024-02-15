package org.example;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;

import java.util.List;
import java.util.stream.Collectors;

import static org.neo4j.driver.Values.parameters;

public class DirectoryRepostiory {
    public void saveDirectory(Directory directory){
        try (Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "12345678"))) {
            try (Session session = driver.session()) {
                try (Transaction tx = session.beginTransaction()) {
                    String cypherQuery = "CREATE (d:Directory {path: $path}) RETURN d.path";
                    Result result = tx.run(cypherQuery, parameters("path", directory.getPath()));
                    tx.commit();
                }
            }
        }
    }

    public void findById(String path){
        try (Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "12345678"))) {
            try (Session session = driver.session()) {
                try (Transaction tx = session.beginTransaction()) {
                    Result result = tx.run("MATCH (d:Directory) WHERE d.path = $path RETURN d.path", parameters("path", path));
                    Record record = result.next();
                }
            }
        }
    }

}
