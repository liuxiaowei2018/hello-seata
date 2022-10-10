package com.open.demo.feign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 17:03
 * @Description
 */
@Data
@Accessors(chain = true)
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
