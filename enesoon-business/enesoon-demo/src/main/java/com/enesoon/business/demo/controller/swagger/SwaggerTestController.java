package com.enesoon.business.demo.controller.swagger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/swaggerTest")
@Api(value = "eureka-provider", description = "学生查询接口")
public class SwaggerTestController {


    /**
     * 查询所有的学生信息
     *
     * @param sname
     * @param age
     * @param modelMap
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    
    public String list(
                    @ApiParam(value = "姓名") @RequestParam(required = false) String sname,
                    @ApiParam(value = "年龄") @RequestParam(required = false) Integer age,
                       ModelMap modelMap) {
        return "1111";
    }

}
