package com.open.demo.feign;

import com.mysql.cj.log.Log;
import com.open.demo.feign.dto.AccountReduceBalanceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 17:32
 * @Description
 */
@Slf4j
@Service
public class AccountServiceFeignClientFallBack implements AccountServiceFeignClient{

    @Override
    public void reduceBalance(AccountReduceBalanceDTO accountReduceBalanceDTO) {
      log.warn("扣减余额服务降级");
    }
}
