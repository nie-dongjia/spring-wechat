package com.djn.cn.wechat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 主页controller
 *
 * @author nie-dongjia
 * @date 2020/12/4 11:28
 */
@RequestMapping("/")
@RestController
@Slf4j
public class IndexController {

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "signature", required = false) String signature,
                          @RequestParam(name = "timestamp", required = false) String timestamp,
                          @RequestParam(name = "nonce", required = false) String nonce,
                          @RequestParam(name = "echostr", required = false) String echostr) {

        log.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
                timestamp, nonce, echostr);
        return echostr;

    }
//    // 服务器注册
//    @GetMapping(value = "")
//    public void index(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        System.out.println("========WeChatApplication========= ");
//
//
//        Enumeration pNames = request.getParameterNames();
//        while (pNames.hasMoreElements()) {
//            String name = (String) pNames.nextElement();
//            String value = request.getParameter(name);
//            String log = "name =" + name + "     value =" + value;
//            System.out.println("log:"+log);
//
//        }
//        System.out.println("========WeChatApplication========= ");
//        String signature = request.getParameter("signature");/// 微信加密签名
//        String timestamp = request.getParameter("timestamp");/// 时间戳
//        String nonce = request.getParameter("nonce"); /// 随机数
//        String echostr = request.getParameter("echostr"); // 随机字符串
//        PrintWriter out = response.getWriter();
//
//        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
//            System.out.println("校验成功！！！！！！！！！！！！！");
//            out.print(echostr);
//        }
//
//        out.close();
//    }
    // oGq5b5ymjVZImhhZTkC1AqWGhebk  黄志新  账户名  绑定成功
    // oGq5b50fQnjThQ88TyBO_QMNOXtU  聂冬佳  账户名  绑定成功
    @PostMapping(value = "send-info")
    public Object sendInfo() {
        // 获取
        LocalDateTime time = LocalDateTime.now();
        //
        return time.toString();
    }
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(
                       @RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("openid") String openid,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        log.info("\n接收微信请求：[openid=[{}], [signature=[{}], encType=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                openid, signature, encType, msgSignature, timestamp, nonce, requestBody);


        return "";
    }
}

