package com.lvmoney.mysql.base.utils;/**
 * 描述:
 * 包名:com.lvmoney.mysql.utils
 * 版本信息: 版本1.0
 * 日期:2019/9/5
 * Copyright XXXXXX科技有限公司
 */


import com.alibaba.druid.filter.config.ConfigTools;
import com.lvmoney.mysql.base.vo.DruidPasswod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/9/5 16:23
 */
public class EncryptPwdUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptPwdUtil.class);

    public static void main(String[] args) {
        try {
            String password = "test";
            String[] arr = ConfigTools.genKeyPair(512);

            // System.out.println("privateKey:" + arr[0]);
            System.out.println("publicKey:" + arr[1]);
            System.out.println("password:" + ConfigTools.encrypt(arr[0], password));

            System.out.println("password:" + ConfigTools.encrypt(password));
            System.out.println(getDruidPass("test", true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DruidPasswod getDruidPass(String plaintext, boolean isPublicKey) {
        DruidPasswod druidPasswod = new DruidPasswod();
        if (isPublicKey) {
            String[] arr = new String[0];
            try {
                arr = ConfigTools.genKeyPair(512);
                try {
                    String password = ConfigTools.encrypt(arr[0], plaintext);
                    String publicKey = arr[1];
                    druidPasswod.setPassword(password);
                    druidPasswod.setPublicKey(publicKey);
                    druidPasswod.setPlaintext(plaintext);
                } catch (Exception e) {
                    logger.error("通过公钥获得druid密钥报错:{}", e.getMessage());
                }
            } catch (NoSuchAlgorithmException e) {
                logger.error("通过公钥获得druid密钥报错:{}", e.getMessage());
            } catch (NoSuchProviderException e) {
                logger.error("通过公钥获得druid密钥报错:{}", e.getMessage());
            }

        } else {
            try {
                druidPasswod.setPassword(ConfigTools.encrypt(plaintext));
            } catch (Exception e) {
                logger.error("不用公钥获得druid密钥报错:{}", e.getMessage());
            }
            druidPasswod.setPlaintext(plaintext);
        }
        return druidPasswod;

    }

}
