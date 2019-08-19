package com.project.voizfonica.data;

import com.project.voizfonica.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface PlanRepository extends MongoRepository<Plan,String> {

    List<Plan> findAllById(String id);


}