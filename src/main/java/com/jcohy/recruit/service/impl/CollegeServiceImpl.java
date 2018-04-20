package com.jcohy.recruit.service.impl;

import com.jcohy.lang.StringUtils;
import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.College;
import com.jcohy.recruit.respository.CollegeRepository;
import com.jcohy.recruit.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public College login(Integer num, String password) throws Exception {
        return collegeRepository.findCollegeByNum(num);
    }

    @Override
    public Page<College> findAll(Pageable pageable) {
        return collegeRepository.findAll(pageable);
    }

    @Override
    public List<College> findAll() {
        return collegeRepository.findAll();
    }

    @Override
    public College findById(Integer id) {
        return collegeRepository.findById(id).get();
    }

    @Override
    public College findByName(String name) {
        return collegeRepository.findCollegeByName(name);
    }

    @Override
    public College saveOrUpdate(College college) throws ServiceException {
        College dbUser =null;
        if(college.getId() != null){
            dbUser = findById(college.getId());
            if(college.getCollegeChairman() != null ) dbUser.setCollegeChairman(college.getCollegeChairman());
            if(college.getName() != null ) dbUser.setName(college.getName());
            if(college.getCollegeDesc() != null ) dbUser.setCollegeDesc(college.getCollegeDesc());
            if(college.getCollegeTel() != null ) dbUser.setCollegeTel(college.getCollegeTel());
            if(college.getEmail() != null ) dbUser.setEmail(college.getEmail());
            if(college.getPassword() != null ) dbUser.setPassword(college.getPassword());
        }else{
            dbUser = college;
        }
        dbUser.setUpdateTime(new Date());
        return collegeRepository.save(dbUser);
    }

    @Override
    public boolean checkUser(Integer num) {
        College dbUser = collegeRepository.findCollegeByNum(num);
        return dbUser != null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        collegeRepository.deleteById(id);
    }

    @Override
    public void updatePassword(College college, String oldpassword, String password1, String password2) {
        if(StringUtils.isBlank(oldpassword) || StringUtils.isBlank(password1) || StringUtils.isBlank(password2)){
            throw new ServiceException("参数不完整");
        }
        if(!password1.equals(password2)){
            throw new ServiceException("两次输入密码不一致");
        }
        College dbUser = findById(college.getId());
        if(!college.getPassword().equals(oldpassword)){
            throw new ServiceException("旧密码不正确");
        }
        dbUser.setPassword(password1);
        collegeRepository.saveAndFlush(dbUser);
    }
}
