package com.jcohy.recruit.service.impl;

import com.jcohy.lang.StringUtils;
import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.JobSeeker;
import com.jcohy.recruit.respository.JobSeekerRepository;
import com.jcohy.recruit.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Override
    public JobSeeker login(Integer num, String password) throws Exception {
        return jobSeekerRepository.findJobSeekerByNum(num);
    }

    @Override
    public Page<JobSeeker> findAll(Pageable pageable) {
        return jobSeekerRepository.findAll(pageable);
    }

    @Override
    public List<JobSeeker> findAll() {
        return jobSeekerRepository.findAll();
    }

    @Override
    public JobSeeker findById(Integer id) {
        return jobSeekerRepository.findById(id).get();
    }

    @Override
    public JobSeeker findByName(String name) {
        return jobSeekerRepository.findJobSeekerByName(name);
    }

    @Override
    public void saveOrUpdate(JobSeeker jobSeeker) throws ServiceException {
        jobSeekerRepository.save(jobSeeker);
    }

    @Override
    public boolean checkUser(Integer num) {
        JobSeeker dbUser = jobSeekerRepository.findJobSeekerByNum(num);
        return dbUser != null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        jobSeekerRepository.deleteById(id);
    }

    @Override
    public void updatePassword(JobSeeker jobSeeker, String oldpassword, String password1, String password2) {
        if(StringUtils.isBlank(oldpassword) || StringUtils.isBlank(password1) || StringUtils.isBlank(password2)){
            throw new ServiceException("参数不完整");
        }
        if(!password1.equals(password2)){
            throw new ServiceException("两次输入密码不一致");
        }
        JobSeeker dbUser = findById(jobSeeker.getId());
        if(!jobSeeker.getPassword().equals(oldpassword)){
            throw new ServiceException("旧密码不正确");
        }
        dbUser.setPassword(password1);
        jobSeekerRepository.saveAndFlush(dbUser);
    }
}
