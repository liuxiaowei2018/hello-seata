package com.open.seata.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 11:59
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDO {

    /**
     * 订单编号
     **/
    private Integer id;

    /**
     * 用户编号
     **/
    private Long userId;

    /**
     * 产品编号
     **/
    private Long productId;

    /**
     * 支付金额
     **/
    private Integer payAmount;
}
