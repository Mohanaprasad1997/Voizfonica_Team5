package com.project.voizfonica.data;

import com.project.voizfonica.model.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DashboardRepository extends MongoRepository<Dashboard,String> {
}
