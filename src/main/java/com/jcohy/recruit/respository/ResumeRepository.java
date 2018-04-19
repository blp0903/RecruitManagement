package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Integer> {

    Resume findResumeByNum(Integer num);

    Resume findResumeByName(String name);

}
