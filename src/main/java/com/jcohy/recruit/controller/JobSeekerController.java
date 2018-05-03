package com.jcohy.recruit.controller;

import com.jcohy.lang.StringUtils;
import com.jcohy.recruit.common.JsonResult;
import com.jcohy.recruit.model.DeliveryRecord;
import com.jcohy.recruit.model.Job;
import com.jcohy.recruit.model.JobSeeker;
import com.jcohy.recruit.model.Resume;
import com.jcohy.recruit.service.DeliveryRecordService;
import com.jcohy.recruit.service.JobSeekerService;
import com.jcohy.recruit.service.JobService;
import com.jcohy.recruit.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private JobService jobService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private DeliveryRecordService deliveryRecordService;


    /**
     * 求职者登陆接口
     * @param num 登录号
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public JsonResult login(Integer num, String password){
        JobSeeker login = null;
        try {
            if(num == null || StringUtils.isEmpty(password)){
                return JsonResult.fail("用户名或者密码不能为空");
            }

            login = jobSeekerService.login(num, password);

            if(login == null){
                return JsonResult.fail("登录失败,用户名不存在");
            }
            if(!login.getPassword().equals(password)){
                return JsonResult.fail("登录失败,用户名账号密码不匹配");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok("登录成功").set("data",login);
    }

    /**
     * 注册接口
     * @param num 账号 必填
     * @param phone 电话 必填
     * @param password 密码 必填
     * @param name 姓名 必填
     * @return
     */
    @GetMapping("/register")
    public JsonResult register(Integer num, String phone, String password, String name){
        if(num == null||phone == null || StringUtils.hashEmpty(name,password)){
            return JsonResult.fail("参数不能为空");
        }
        boolean exist = jobSeekerService.checkUser(num);
        if(exist){
            return JsonResult.fail("用户已存在");
        }
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setNum(num);
        jobSeeker.setPassword(password);
        jobSeeker.setName(name);
        jobSeeker.setPhone(phone);
        jobSeekerService.saveOrUpdate(jobSeeker);
        return JsonResult.ok("注册成功").set("data", jobSeeker);
    }

    /**
     * 更新求职者信息
     * @param jobSeeker
     * @return
     */
    @GetMapping("/update")
    public JsonResult update(JobSeeker jobSeeker){
        try {
            JobSeeker stu = jobSeekerService.saveOrUpdate(jobSeeker);
            return JsonResult.ok().set("data",stu);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 增加简历
     * @param resume
     * @return
     */
    @GetMapping("/addResume")
    public JsonResult addResume(Resume resume){
        try {
            Resume res = resumeService.saveOrUpdate(resume);
            Resume res1 = resumeService.findByName(resume.getName());
            JobSeeker jobSeeker = new JobSeeker();
            jobSeeker.setResumeId(res1.getId());
            jobSeekerService.saveOrUpdate(jobSeeker);
            return JsonResult.ok("添加成功").set("data", res);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 获取全部job
     * @return
     */
    @GetMapping("/jobs")
    public JsonResult findAllJobs(){
        List<Job> all = jobService.findAll();
        return JsonResult.ok("获取成功").set("data",all);
    }


    /**
     * 投递job
     * @param userId  用户id
     * @param  jobId  工作id
     */
    @GetMapping("/send")
    public JsonResult send(Integer userId, Integer jobId){
        try {
            JobSeeker jobSeeker = jobSeekerService.findById(userId);
            Job job = jobService.findById(jobId);
            if (jobSeeker.getResumeId() == null) {
                return JsonResult.fail("还没有简历，先去添加一份简历吧！");
            }
            DeliveryRecord deliveryRecord = new DeliveryRecord();
            deliveryRecord.setCollegeId(job.getCollegeId());
            deliveryRecord.setJobSeekerId(jobSeeker.getId());
            deliveryRecord.setResumeId(jobSeeker.getResumeId());
            deliveryRecord.setJobId(job.getId());
            deliveryRecord.setNum(jobSeeker.getId());
            Date date = new Date();
            deliveryRecord.setDeliveryTime(date);
            deliveryRecordService.saveOrUpdate(deliveryRecord);
            return JsonResult.ok("投递成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 查看投递记录
     * @param userId
     * @return
     */
    @GetMapping("/deliveryRecord")
    public JsonResult findSend(Integer userId){
        DeliveryRecord deliveryRecord = new DeliveryRecord();
        deliveryRecord = deliveryRecordService.findByNum(userId);
        return JsonResult.ok("获取成功").set("data",deliveryRecord);
    }



}
