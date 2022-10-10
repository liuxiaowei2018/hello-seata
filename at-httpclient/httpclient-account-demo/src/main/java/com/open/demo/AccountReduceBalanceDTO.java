package com.open.demo;

import lombok.Data;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 14:08
 * @Description
 */
@Data
public class AccountReduceBalanceDTO {

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 扣减金额
     */
    private Integer price;

}

