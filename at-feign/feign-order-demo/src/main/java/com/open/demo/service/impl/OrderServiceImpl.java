package com.open.demo.service.impl;

import com.open.demo.feign.AccountServiceFeignClient;
import com.open.demo.feign.ProductServiceFeignClient;
import com.open.demo.feign.dto.AccountReduceBalanceDTO;
import com.open.demo.feign.dto.ProductReduceStockDTO;
import com.open.demo.mapper.OrderMapper;
import com.open.demo.pojo.OrderDO;
import com.open.demo.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 16:58
 * @Description
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private AccountServiceFeignClient accountService;
    @Autowired
    private ProductServiceFeignClient productService;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    @GlobalTransactional
    public Integer createOrder(Long userId, Long productId, Integer price) {

        // 购买数量，暂时设置为 1
        Integer amount = 1;

        log.info("[createOrder] 当前 XID: {}", RootContext.getXID());

        // 扣减库存
        productService.reduceStock(new ProductReduceStockDTO().setProductId(productId).setAmount(amount));

        // 扣减余额
        accountService.reduceBalance(new AccountReduceBalanceDTO().setUserId(userId).setPrice(price));

        // 保存订单
        OrderDO order = new OrderDO().setUserId(userId).setProductId(productId).setPayAmount(amount * price);
        orderMapper.saveOrder(order);
        log.info("[createOrder] 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }
}