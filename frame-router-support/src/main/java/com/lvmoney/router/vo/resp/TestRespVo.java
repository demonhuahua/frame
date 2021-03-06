/**
 * 描述:
 * 包名:com.lvmoney.router.ro.resp
 * 版本信息: 版本1.0
 * 日期:2018年12月29日  下午1:48:50
 * Copyright xxxx科技有限公司
 */

package com.lvmoney.router.vo.resp;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年12月29日 下午1:48:50
 */

public class TestRespVo extends CommonRespVo {
    /**
     *
     */


    private static final long serialVersionUID = -1061460496809339311L;
    private int age;
    private String name;
    private String address;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
