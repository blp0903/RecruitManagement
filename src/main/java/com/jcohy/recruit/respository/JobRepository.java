package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {

    Job findAdminByNum(Integer num);


    Job findAdminByName(String name);

}
