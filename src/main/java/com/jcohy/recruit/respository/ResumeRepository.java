package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Integer> {

    Resume findAdminByNum(Integer num);


    Resume findAdminByName(String name);

}
