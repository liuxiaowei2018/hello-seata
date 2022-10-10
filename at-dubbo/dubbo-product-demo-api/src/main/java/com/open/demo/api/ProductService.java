package com.open.demo.api;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 14:46
 * @Description
 */
public interface ProductService {

    /**
     * 扣减库存
     *
     * @param productId 商品 ID
     * @param amount    扣减数量
     * @throws Exception 扣减失败时抛出异常
     */
    void reduceStock(Long productId, Integer amount) throws Exception;
}

