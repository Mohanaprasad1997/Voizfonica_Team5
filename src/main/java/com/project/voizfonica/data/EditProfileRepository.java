package com.project.voizfonica.data;

import com.project.voizfonica.model.SignUp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EditProfileRepository extends MongoRepository<SignUp,String> {
}
