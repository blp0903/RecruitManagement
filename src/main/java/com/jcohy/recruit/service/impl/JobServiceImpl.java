package com.jcohy.recruit.service.impl;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.Job;
import com.jcohy.recruit.respository.JobRepository;
import com.jcohy.recruit.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return jobRepository.save(job);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        jobRepository.deleteById(id);
    }
}
