package com.project.voizfonica.data;

import com.project.voizfonica.model.NewConnection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewConnectionRepository extends MongoRepository<NewConnection,String> {

}
