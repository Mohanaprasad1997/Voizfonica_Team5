package com.project.voizfonica.data;

import com.project.voizfonica.model.HelpAndSupport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HelpAndSupportRepository extends MongoRepository<HelpAndSupport,String> {
}
