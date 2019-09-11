package com.lvmoney.lock.service;/**
 * 描述:
 * 包名:com.lvmoney.jwt.annotation
 * 版本信息: 版本1.0
 * 日期:2019/3/26
 * Copyright xxxx科技有限公司
 */


import com.lvmoney.lock.vo.req.ProdLockInitReqVo;
import com.lvmoney.lock.vo.req.ProdLockStockReqVo;
import com.lvmoney.lock.vo.req.ProdLockUpdateReqVo;
import com.lvmoney.lock.vo.resp.ProdLockStockRespVo;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年10月30日 下午3:29:38
 */
public interface ProdLockService {
    /**
     * 商品数量的扣减
     *
     * @param prodLockStockReqVo: 商品锁实体
     * @throws
     * @return: com.lvmoney.lock.vo.resp.ProdLockStockRespVo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/9 20:58
     */
    ProdLockStockRespVo getStock(ProdLockStockReqVo prodLockStockReqVo);

    /**
     * 初始化商品库存
     *
     * @param prodLockInitReqVo: 初始化实体
     * @throws
     * @return: boolean
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/9 20:59
     */
    boolean initLockStock(ProdLockInitReqVo prodLockInitReqVo);

    /**
     * 更新商品库存
     *
     * @param prodLockUpdateReqVo: 初始化实体
     * @throws
     * @return: com.lvmoney.lock.vo.resp.ProdLockStockRespVo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/9 20:59
     */
    ProdLockStockRespVo updateLockStock(ProdLockUpdateReqVo prodLockUpdateReqVo);
}
