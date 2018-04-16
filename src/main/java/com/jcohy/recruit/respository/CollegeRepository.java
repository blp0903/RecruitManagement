package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Integer> {

    College findAdminByNum(Integer num);


    College findAdminByName(String name);

}
