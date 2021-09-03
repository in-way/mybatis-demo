package com.batis.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivy
 * @date 2021年09月02日 8:58
 */
@Data
public class BaseEntity implements Serializable {
    @JsonIgnore
    private Long createUser;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Integer createUserType;
    @JsonIgnore
    private String createIp;
    @JsonIgnore
    private Long updateUser;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    private Integer updateUserType;
    @JsonIgnore
    private String updateIp;
    @JsonIgnore
    private Integer deleted;
}
