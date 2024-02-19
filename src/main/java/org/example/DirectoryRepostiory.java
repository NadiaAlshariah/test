package org.example;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;

public class DirectoryRepostiory {
    public void saveDirectory(Directory directory){
        Session session = Neo4jSession.getSession();
        try(Transaction transaction = session.beginTransaction()){
            session.save(directory);
            transaction.commit();
        }
    }

    public void findById(String path){

    }

}
