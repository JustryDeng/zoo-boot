package com.ideaaedi.boot.controller;

import com.ideaaedi.boot.po.UserInfoLikePO;
import com.ideaaedi.boot.service.UserInfoLikeService;
import com.ideaaedi.zoo.commonbase.entity.Result;
import com.ideaaedi.zoo.diy.artifact.apidoc.knife4j.annotation.ApiTag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 查询
 */
@RestController
@RequestMapping("/user-info/")
@ApiTag(name = "多租户测试页面页面", order = 2)
public class UserInfoLikeController {
    
    @Resource
    private UserInfoLikeService userInfoLikeService;
    
    @Operation(summary = "用户列表")
    @RequestMapping("list")
    public Result<List<UserInfoLikePO>> list() {
        return Result.success(userInfoLikeService.list());
    }
    
}
