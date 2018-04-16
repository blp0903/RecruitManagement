package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker,Integer> {

    JobSeeker findAdminByNum(Integer num);


    JobSeeker findAdminByName(String name);


}
