package com.open.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 17:08
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/reduce-stock")
    public void reduceStock(@RequestBody ProductReduceStockDTO productReduceStockDTO) throws Exception {
        log.info("[reduceStock] 收到减少库存请求, 商品:{}, 价格:{}",
                productReduceStockDTO.getProductId(),
                productReduceStockDTO.getAmount());
        productService.reduceStock(productReduceStockDTO.getProductId(), productReduceStockDTO.getAmount());
    }

}