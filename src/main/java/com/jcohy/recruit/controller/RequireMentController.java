package com.jcohy.recruit.controller;

import com.jcohy.recruit.common.JsonResult;
import com.jcohy.recruit.controller.BaseController;
import com.jcohy.recruit.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiac on 2018/5/22.
 * ClassName  : com.jcohy.recruit.service.impl
 * Description  :
 */
@RestController
@RequestMapping("/required")
public class RequireMentController extends BaseController{

    @Autowired
    private RequirementService requirementService;

    @GetMapping("/change/{id}")
    private JsonResult change(@PathVariable Integer id,String type,String reason){
        requirementService.changeStatus(id,type,reason);
        return JsonResult.ok();
    }
}
