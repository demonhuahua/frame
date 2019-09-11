package com.lvmoney.k8s.seata.client.vo.req;

import lombok.Data;

import java.io.Serializable;


/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */
@Data
public class UserReqVo implements Serializable {
    private String userId;
    private String username;
    private String password;
}
