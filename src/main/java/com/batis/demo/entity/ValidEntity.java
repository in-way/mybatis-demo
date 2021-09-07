package com.batis.demo.entity;

import com.gbps.webex.validator.MobileValid;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author ivy
 * @date 2021年09月07日 15:45
 */
@Data
public class ValidEntity {
    @NotNull
    private String id ;
    @MobileValid
    private String phone;
}
