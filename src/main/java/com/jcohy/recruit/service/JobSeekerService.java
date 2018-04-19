package com.jcohy.recruit.service;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.JobSeeker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobSeekerService {
    /**
     * 求职者登录
     * @param num  学院编号
     * @param password
     * @return
     * @throws Exception
     */
    JobSeeker login(Integer num, String password) throws Exception;


    /**
     * 分页查询
     * @param Pageable
     * @return
     */
    Page<JobSeeker> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<JobSeeker> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    JobSeeker findById(Integer id);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    JobSeeker findByName(String name);

    /**
     * 新增或者更新求职者
     * @param jobSeeker
     */
    void saveOrUpdate(JobSeeker jobSeeker) throws ServiceException;

    /**
     * 检查求职者是否存在
     * @param num
     * @return
     */
    boolean checkUser(Integer num);

    /**
     * 删除求职者
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改密码
     *
     * @param jobSeeker
     * @param oldpassword
     * @param password1
     * @param password2
     */
    void updatePassword(JobSeeker jobSeeker, String oldpassword, String password1, String password2);
}
