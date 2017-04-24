package pl.uwm.edu.java.science.club.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.uwm.edu.java.science.club.ob.MessageOB;

/**
 * Created by jakub on 24.04.17.
 */
@Repository
public interface IMessageRepository extends MongoRepository<MessageOB, String> {
}
