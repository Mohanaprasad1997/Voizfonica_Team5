package com.project.voizfonica.data;

import com.project.voizfonica.model.MyAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyAccountRepository extends MongoRepository<MyAccount,String> {
}
