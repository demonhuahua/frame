/**
 * 描述:
 * 包名:com.lvmoney.hotel.controller
 * 版本信息: 版本1.0
 * 日期:2018年11月7日  上午10:40:05
 * Copyright xxxx科技有限公司
 */

package com.lvmoney.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lvmoney.drools.service.ProductService;
import com.lvmoney.drools.vo.ProductProp;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年11月7日 上午10:40:05
 */

@RestController
@RequestMapping("product")
@ResponseBody
public class EmployeeController {
    @Autowired
    ProductProp productProp;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "drools", method = RequestMethod.GET)
    private void esSave() {
        double price = productService.getProductPrice(500d);
        System.out.println(price);
        boolean bool = productService.isPassProduct(price, 450d, productProp.getTbCharge(), productProp.getTbProfit());
        System.out.println(bool);
    }

}
