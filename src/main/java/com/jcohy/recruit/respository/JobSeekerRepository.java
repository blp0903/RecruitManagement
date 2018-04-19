package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker,Integer> {

    JobSeeker findJobSeekerByNum(Integer num);

    JobSeeker findJobSeekerByName(String name);


}
