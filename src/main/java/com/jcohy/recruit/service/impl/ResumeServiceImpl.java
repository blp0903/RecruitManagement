package com.jcohy.recruit.service.impl;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.Resume;
import com.jcohy.recruit.respository.ResumeRepository;
import com.jcohy.recruit.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Page<Resume> findAll(Pageable pageable) {
        return resumeRepository.findAll(pageable);
    }

    @Override
    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume findById(Integer id) {
        return resumeRepository.findById(id).get();
    }

    @Override
    public Resume findByName(String name) {
        return resumeRepository.findResumeByName(name);
    }

    @Override
    public void saveOrUpdate(Resume resume) throws ServiceException {
        resumeRepository.save(resume);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        resumeRepository.deleteById(id);
    }
}
