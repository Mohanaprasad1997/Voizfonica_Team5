package com.project.voizfonica.data;

import com.project.voizfonica.model.SignUp;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SignUpRepository extends MongoRepository<SignUp,String> {
    List<SignUp> findByContactAndPassword(String contact,String password);
    List<SignUp> findAllByContact(String contact);
    List<SignUp> findByContact(String contact);
}
