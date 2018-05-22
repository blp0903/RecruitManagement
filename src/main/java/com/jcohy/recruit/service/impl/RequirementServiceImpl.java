package com.jcohy.recruit.service.impl;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.Requirement;
import com.jcohy.recruit.respository.RequirementRespository;
import com.jcohy.recruit.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementRespository requirementRespository;


    @Override
    public Page<Requirement> findAll(Pageable pageable) {
        return requirementRespository.findAll(pageable);
    }

    @Override
    public List<Requirement> findAll() {
        return requirementRespository.findAll();
    }

    @Override
    public Requirement findById(Integer id) {
        return requirementRespository.findById(id).get();
    }

    @Override
    public Requirement saveOrUpdate(Requirement job) throws ServiceException {
        Requirement dbUser = null;
        if(job.getId() != null){
            dbUser = findById(job.getId());
            if(job.getCollege() != null ) dbUser.setCollege(job.getCollege());
            if(job.getName() != null ) dbUser.setName(job.getName());
            if(job.getTitle() != null ) dbUser.setTitle(job.getTitle());
            if(job.getDesc() != null ) dbUser.setDesc(job.getDesc());
            if(job.getNum() != null ) dbUser.setNum(job.getNum());
            if(job.getStatus() != null ) dbUser.setStatus(job.getStatus());
            if(job.getLocation() != null ) dbUser.setLocation(job.getLocation());
            if(job.getNumbers() != null ) dbUser.setNumbers(job.getNumbers());
            if(job.getExperience() != null ) dbUser.setExperience(job.getExperience());
        }else{
            dbUser = job;
        }
        dbUser.setCreateTime(new Date());
        return requirementRespository.save(dbUser);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        requirementRespository.deleteById(id);
    }

    @Override
    public void changeStatus(Integer id, String type) {
        Requirement requirement = findById(id);
        requirement.setStatus(Integer.parseInt(type));
        requirementRespository.saveAndFlush(requirement);
    }

    @Override
    public List<Requirement> findByStatus(Integer status) {
        return requirementRespository.findAllByStatusGreaterThanEqual(status);
    }
}
