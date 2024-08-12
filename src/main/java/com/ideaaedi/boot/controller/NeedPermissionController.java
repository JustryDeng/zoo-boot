package com.ideaaedi.boot.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.ideaaedi.boot.config.DemoPermissionProvider;
import com.ideaaedi.zoo.commonbase.entity.Result;
import com.ideaaedi.zoo.diy.artifact.apidoc.knife4j.annotation.ApiTag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@ApiTag(name = "认证鉴权测试页面", order = 2)
public class NeedPermissionController {
    
    @Operation(summary = "admin才有权限访问的页面")
    @RequestMapping("admin")
    public Result<String> admin() {
        return Result.success(
                    String.format("admin页面： 你好%s！",
                    DemoPermissionProvider.userIdAndNameMap.get(Long.parseLong(StpUtil.getLoginId().toString()))
                )
        );
    }
    
    @Operation(summary = "dba才有权限访问的页面")
    @RequestMapping("dba")
    public Result<String> dba() {
        return Result.success(
                    String.format("dba页面： 你好%s！",
                    DemoPermissionProvider.userIdAndNameMap.get(Long.parseLong(StpUtil.getLoginId().toString()))
                )
        );
    }
    
    @Operation(summary = "developer才有权限访问的页面")
    @RequestMapping("developer")
    public Result<String> developer() {
        return Result.success(
                    String.format("developer页面： 你好%s！",
                    DemoPermissionProvider.userIdAndNameMap.get(Long.parseLong(StpUtil.getLoginId().toString()))
                )
        );
    }
    
}
