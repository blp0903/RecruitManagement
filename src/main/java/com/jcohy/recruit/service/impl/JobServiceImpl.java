package com.jcohy.recruit.service.impl;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.DeliveryRecord;
import com.jcohy.recruit.model.Job;
import com.jcohy.recruit.model.Requirement;
import com.jcohy.recruit.respository.JobRepository;
import com.jcohy.recruit.service.DeliveryRecordService;
import com.jcohy.recruit.service.JobService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RequirementServiceImpl requirementService;

    @Override
    public Page<Job> findAll(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> findAllByStatus() {
        return jobRepository.findByStatus(1);
    }

    @Override
    public List<Job> findByNameLike(String name) {
        return jobRepository.findByName(name);
    }

    @Override
    public Job findById(Integer id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public Job saveOrUpdate(Job job) throws ServiceException {
        Job dbUser = null;
        if(job.getId() != null){
            dbUser = findById(job.getId());
            if(job.getCollege() != null ) dbUser.setCollege(job.getRequirement().getCollege());
            if(job.getName() != null ) dbUser.setName(job.getName());
            if(job.getTitle() != null ) dbUser.setTitle(job.getTitle());
            if(job.getDesc() != null ) dbUser.setDesc(job.getDesc());
            if(job.getNum() != null ) dbUser.setNum(job.getNum());
            if(job.getStatus() != null ) dbUser.setStatus(job.getStatus());
            if(job.getTreatment() != null ) dbUser.setTreatment(job.getTreatment());
            if(job.getLocation() != null ) dbUser.setLocation(job.getLocation());
            if(job.getNumbers() != null ) dbUser.setNumbers(job.getNumbers());
            if(job.getExperience() != null ) dbUser.setExperience(job.getExperience());
        }else{
            dbUser = new Job();
            dbUser = job;
            dbUser.setCollege(job.getRequirement().getCollege());
            dbUser.setStatus(0);
        }
        dbUser.setCreateTime(new Date());
        return jobRepository.save(dbUser);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        jobRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void changeStatus(Integer id) {
        Job job = jobRepository.findById(id).get();
        Requirement requirement = job.getRequirement();

        if(job.getStatus() == 0 ){
            requirementService.changeStatus(requirement.getId(),"2","已发布");
        }else{
            requirementService.changeStatus(requirement.getId(),"1","已发布");
        }
        job.setStatus(job.getStatus()==0?1:0);

        jobRepository.save(job);
    }
}
