package com.open.seata.service;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 17:52
 * @Description
 */
public interface AccountService {

    /**
     * 扣除余额
     *
     * @param userId 用户编号
     * @param price  扣减金额
     * @throws Exception 失败时抛出异常
     */
    void reduceBalance(Long userId, Integer price) throws Exception;

}
