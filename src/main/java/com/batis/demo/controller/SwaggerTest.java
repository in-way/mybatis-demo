package com.batis.demo.controller;

import com.batis.demo.annoation.GbpsRest;
import com.gbps.webex.entity.GbpsResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author ivy
 * @date 2021年08月26日 10:49
 */
@Api(tags = "测试模块")
@RestController
@RequestMapping("/api/test")
@GbpsRest
public class SwaggerTest {

    @ApiOperation(value="测试",notes="随边说点啥")
    @ApiImplicitParams({
            @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
            @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
    })
    @ApiResponses({
            @ApiResponse(code=200,message="请求成功"),
    })
    @GetMapping("/list")
    @GbpsRest
    public List list(){
        //TODO
        return Arrays.asList(1,3);
    }

}
