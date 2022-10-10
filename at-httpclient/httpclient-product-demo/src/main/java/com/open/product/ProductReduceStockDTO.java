package com.open.product;

import lombok.Data;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 14:17
 * @Description
 */
@Data
public class ProductReduceStockDTO {

    /**
     * 商品编号
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer amount;
}
