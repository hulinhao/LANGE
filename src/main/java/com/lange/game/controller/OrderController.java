package com.lange.game.controller;/**
 * @Author linhao Hu
 * @Date 2020/6/23 20:22
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lange.enums.ResponseEnum;
import com.lange.game.domian.bills;
import com.lange.game.mapper.OrderMapper;
import com.lange.utils.AppResponseResult;
import com.lange.utils.CommUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/23 20:22
 *
 */
@RestController
@RequestMapping("order/")
@Slf4j
public class OrderController {
    @Resource
    private OrderMapper orderMapper;

    @RequestMapping("addOrder")
    public AppResponseResult addOrder(@RequestBody Map params){
        if(CommUtils.isNull(params.get("betParam"))){
            return AppResponseResult.error();
        }
        List betParam = (List) params.get("betParam");
        for (Object m : betParam) {
            bills order = JSONArray.parseObject( JSON.toJSONString(m), bills.class);
            order.setType(0);
            order.setCreateTime(new Date());
            orderMapper.insert(order);
            log.info("下单成功，userId:{}",order.getUserId());
        }

        return AppResponseResult.success(ResponseEnum.DATA_EMPTY);
    }
}
