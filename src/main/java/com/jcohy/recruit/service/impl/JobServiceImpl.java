package com.jcohy.recruit.service.impl;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.Job;
import com.jcohy.recruit.respository.JobRepository;
import com.jcohy.recruit.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Page<Job> findAll(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
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
            if(job.getCollegeId() != null ) dbUser.setCollegeId(job.getCollegeId());
            if(job.getName() != null ) dbUser.setName(job.getName());
            if(job.getTitle() != null ) dbUser.setTitle(job.getTitle());
            if(job.getDesc() != null ) dbUser.setDesc(job.getDesc());
            if(job.getNum() != null ) dbUser.setNum(job.getNum());
            if(job.getStatus() != null ) dbUser.setStatus(job.getStatus());
            if(job.getTreatment() != null ) dbUser.setTreatment(job.getTreatment());
        }else{
            dbUser = job;
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
}
