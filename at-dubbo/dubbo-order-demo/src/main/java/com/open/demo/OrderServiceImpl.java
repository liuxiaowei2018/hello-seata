package com.open.demo;

import com.open.demo.api.AccountService;
import com.open.demo.api.OrderService;
import com.open.demo.api.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 14:12
 * @Description
 */
@Slf4j
@org.apache.dubbo.config.annotation.Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Reference
    private AccountService accountService;
    @Reference
    private ProductService productService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public Integer createOrder(Long userId, Long productId, Integer price) throws Exception {
        // 购买数量，暂时设置为 1
        Integer amount = 1;

        log.info("[createOrder] 当前 XID: {}", RootContext.getXID());

        // 扣减库存
        productService.reduceStock(productId, amount);

        // 扣减余额
        accountService.reduceBalance(userId, price);

        // 保存订单
        OrderDO order = new OrderDO().setUserId(userId).setProductId(productId).setPayAmount(amount * price);
        orderDao.saveOrder(order);
        log.info("[createOrder] 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }
}
