package com.ideaaedi.boot;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.ideaaedi.boot.config.DemoPermissionProvider;
import com.ideaaedi.zoo.commonbase.entity.BaseCodeMsgEnum;
import com.ideaaedi.zoo.commonbase.entity.Result;
import com.ideaaedi.zoo.commonbase.util.HttpUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class SaTokenTest extends BaseTest {

    String host = "http://localhost:8080";
    
    /*
     * 提示：运行单元测试前，请先将项目运行起来
     *
     * 提示：因为在application.yml中有以下配置，所以token为JD-AUTH-TOKEN， 前缀为Bearer，注意：传header时，前缀和token之前需要有一个空格
     * sa-token:
     *   token-name: JD-AUTH-TOKEN # token 名称（同时也是 cookie 名称）
     *   token-prefix: Bearer
     */
    @Test
    @SneakyThrows
    void test() {
        visitPages(DemoPermissionProvider.ZHANG_SAN_NAME);

        System.out.println();
        System.out.println();
        System.out.println();
        visitPages(DemoPermissionProvider.LI_SI_NAME);
        
        System.out.println();
        System.out.println();
        System.out.println();
        visitPages(DemoPermissionProvider.WANG_WU_NAME);
    
    }
    
    private void visitPages(String name) throws InterruptedException {
        String resp = HttpUtil.postJson(host + "/login/doLogin?name=" + name, null);
        System.err.println(name + " 登录：" + resp);
        Result<String> result = JSON.parseObject(resp, new TypeReference<Result<String>>() {});
        Assertions.assertEquals(BaseCodeMsgEnum.SUCCESS.code(), result.getCode(), "登录失败！");
        String token = result.getData();
        
        resp = HttpUtil.postJson(host + "/admin", null, MapUtil.of("JD-AUTH-TOKEN", "Bearer " + token));
        System.err.println(name + " 访问/admin页，返回：" + resp);
        TimeUnit.MILLISECONDS.sleep(100);
        
        resp = HttpUtil.postJson(host + "/dba", null, MapUtil.of("JD-AUTH-TOKEN", "Bearer " + token));
        System.err.println(name + " 访问/dba页，返回：" + resp);
        TimeUnit.MILLISECONDS.sleep(100);
        
        resp = HttpUtil.postJson(host + "/developer", null, MapUtil.of("JD-AUTH-TOKEN", "Bearer " + token));
        System.err.println(name + " 访问/developer页，返回：" + resp);
        resp = HttpUtil.postJson(host + "/login/logout", null);
        
        System.err.println(name + " 登出：" + resp);
    }
    
}