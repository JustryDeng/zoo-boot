package com.ideaaedi.boot.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("user_info_like")
@Schema(description = "用户信息")
public class UserInfoLikePO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "id")
    private Integer id;
    
    @TableField("tenant")
    @Schema(description = "租户")
    private String tenant;
    
    @TableField("name")
    @Schema(description = "姓名")
    private String name;
    
    @TableField("性别")
    @Schema(description = "用户信息")
    private Integer gender;
    
    /*
     * 是否已删除
     */
    @TableLogic(delval = "1", value = "0")
    @Schema(description = "是否已删除")
    private Integer deleted;
    
}
