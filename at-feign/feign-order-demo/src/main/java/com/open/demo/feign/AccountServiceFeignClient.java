package com.open.demo.feign;

import com.open.demo.feign.dto.AccountReduceBalanceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 17:05
 * @Description
 */
@FeignClient(name = "feign-account-service", fallback = AccountServiceFeignClientFallBack.class)
public interface AccountServiceFeignClient {

    @PostMapping("/account/reduce-balance")
    void reduceBalance(@RequestBody AccountReduceBalanceDTO accountReduceBalanceDTO);

}
