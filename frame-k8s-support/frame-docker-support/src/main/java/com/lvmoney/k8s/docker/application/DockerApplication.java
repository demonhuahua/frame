package com.lvmoney.k8s.docker.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */
@SpringBootApplication(scanBasePackages = {"com.lvmoney.**"})
@Configuration
public class DockerApplication {
    /**
     * @describe: shiro, jwt, redis整合成功。1、事务注解是否生效校验。2、自定义shiro标签中的url的过滤
     * @param: [args]
     * @return: void
     * @author: lvmoney /XXXXXX科技有限公司
     * 2019/9/9 10:07
     */
    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

}