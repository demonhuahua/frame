package com.lvmoney.k8s.feign.vo.req;

import lombok.Data;

/**
 * Created by Administrator on 2019/5/23.
 */
@Data
public class LoginVoReq {
    private String username;
    private String password;
}
