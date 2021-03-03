package com.stu.otsea.content.controller;

import com.stu.otsea.content.service.RecommendService;
import com.stu.otsea.entity.vo.DiscoveryListVo;
import com.stu.otsea.web.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 17:59
 * @Description:
 */
@RestController
@RequestMapping(value = "/otsea/content/recommend", method = {RequestMethod.POST, RequestMethod.GET})
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    @RequestMapping("/discovery")
    public Rest<DiscoveryListVo> discovery() {
        return recommendService.discovery();
    }
}
