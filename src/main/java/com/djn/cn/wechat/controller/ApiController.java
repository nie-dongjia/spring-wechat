package com.djn.cn.wechat.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ApiController
 *
 * @author nie-dongjia
 * @date 2020/12/7 14:05
 */
@RequestMapping("/api/")
@Slf4j
@RestController
@AllArgsConstructor
public class ApiController {
    private final WxMpService wxMpService;

    // oGq5b5ymjVZImhhZTkC1AqWGhebk  黄志新  账户名  绑定成功
    // oGq5b50fQnjThQ88TyBO_QMNOXtU  聂冬佳  账户名  绑定成功
    // oGq5b50fQnjThQ88TyBO_QMNOXtU
    // 内网调用
    /**
     * sendInfo   TODO
     *        
     * @param
     * @return java.lang.Object 
     * @since 1.0
     * @author zt.nie-dongjia  
     */
    @PostMapping(value = "send-info")
    public Object sendInfo() {
        String deviceName = "@@@@设备,武汉线";
        String content="你好！设备报警"+deviceName;


        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("oGq5b50fQnjThQ88TyBO_QMNOXtU")
                .templateId("YMoP6cS3UidxklMo8bUDv1yNq4Rzqtw1eMs2YEOPG9g").build();


        templateMessage.addData(new WxMpTemplateData("alertTime", new Date().toString()));
        templateMessage.addData(new WxMpTemplateData("alertContent", content));

        try {
            String result = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            log.info(result);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        // 获取
        LocalDateTime time = LocalDateTime.now();
        return time.toString();
    }
    @PostMapping(value = "send-url")
    public Object sendUrl() {

        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("oGq5b5ymjVZImhhZTkC1AqWGhebk")
                .templateId("7PKMdpKa6zBZpZPL2YIh64lgkw3SAWFRu8_br0oeE_s").build();


        templateMessage.addData(new WxMpTemplateData("time", new Date().toString()));
        templateMessage.addData(new WxMpTemplateData("remark", "点击查看详情"));
        templateMessage.setUrl("www.baidu.com");
        try {
            String result = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            log.info(result);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        // 获取
        LocalDateTime time = LocalDateTime.now();
        return time.toString();
    }
}
