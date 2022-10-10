package com.open.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.open.seata.mapper.OrderMapper;
import com.open.seata.pojo.OrderDO;
import com.open.seata.service.AccountService;
import com.open.seata.service.OrderService;
import com.open.seata.service.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 12:08
 * @Description
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;

    @Override
    @DS(value = "order-ds")
    @GlobalTransactional
    public Integer createOrder(Long userId, Long productId, Integer price) throws Exception {

        log.info("[createOrder] 当前 XID: {}", RootContext.getXID());

        // 购买数量，暂时设置为 1
        Integer amount = 1;
        // 扣减库存
        productService.reduceStock(productId, amount);

        // 扣减余额
        accountService.reduceBalance(userId, price);

        // 保存订单
        OrderDO order = new OrderDO().setUserId(userId).setProductId(productId).setPayAmount(amount * price);
        orderMapper.saveOrder(order);
        log.info("[createOrder] 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }

}
