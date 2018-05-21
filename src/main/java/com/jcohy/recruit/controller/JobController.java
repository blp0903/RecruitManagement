package com.jcohy.recruit.controller;

import com.jcohy.recruit.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jiac on 2018/5/21.
 * ClassName  : com.jcohy.recruit.controller
 * Description  :
 */
public class JobController extends BaseController{

    @Autowired
    private JobService jobService;
}
