package com.mmdz.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MMDZ
 * @description: TODO
 * @date 2021/5/6 12:33
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

}
