package com.project.voizfonica.data;

import com.project.voizfonica.model.Index;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IndexRepository extends MongoRepository<Index,String> {
}
