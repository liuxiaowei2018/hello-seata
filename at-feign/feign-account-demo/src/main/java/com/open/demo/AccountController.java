package com.open.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 14:07
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @PostMapping("/reduce-balance")
//    public Boolean reduceBalance(@RequestBody AccountReduceBalanceDTO accountReduceBalanceDTO) {
//        log.info("[reduceBalance] 收到减少余额请求, 用户:{}, 金额:{}",
//                accountReduceBalanceDTO.getUserId(),
//                accountReduceBalanceDTO.getPrice());
//        try {
//            accountService.reduceBalance(accountReduceBalanceDTO.getUserId(), accountReduceBalanceDTO.getPrice());
//            // 正常扣除余额，返回 true
//            return true;
//        } catch (Exception e) {
//            // 失败扣除余额，返回 false
//            return false;
//        }
//    }

    @PostMapping("/reduce-balance")
    public void reduceBalance(@RequestBody AccountReduceBalanceDTO accountReduceBalanceDTO) throws Exception {
        log.info("[reduceBalance] 收到减少余额请求, 用户:{}, 金额:{}", accountReduceBalanceDTO.getUserId(),
                accountReduceBalanceDTO.getPrice());
        accountService.reduceBalance(accountReduceBalanceDTO.getUserId(), accountReduceBalanceDTO.getPrice());
    }

}