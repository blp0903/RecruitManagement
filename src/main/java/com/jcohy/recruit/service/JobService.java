package com.jcohy.recruit.service;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {
    /**
     * 分页查询
     * @param Pageable
     * @return
     */
    Page<Job> findAll(Pageable pageable);

    /**
     *  查询
     * @return
     */
    List<Job> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Job findById(Integer id);


    /**
     * 新增或者更新职位
     * @param job
     */
    void saveOrUpdate(Job job) throws ServiceException;


    /**
     * 删除职位
     * @param id
     */
    void delete(Integer id);

}
