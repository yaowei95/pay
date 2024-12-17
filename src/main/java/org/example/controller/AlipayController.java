package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
@Slf4j
public class AlipayController {
    @Autowired
    private AlipayService alipayService;

    @PostMapping("/create")
    public String createPayment(@RequestParam String orderId,
                                @RequestParam BigDecimal amount) {
        return alipayService.createPayQrCode(orderId, amount);
    }

    @PostMapping("/notify")
    public String payNotify(HttpServletRequest request) {
        // 1. 打印基本请求信息
        log.info("收到支付宝回调通知");
        log.info("请求URL: {}", request.getRequestURL());
        log.info("请求方法: {}", request.getMethod());

        // 2. 打印所有请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info("请求头 {}: {}", headerName, request.getHeader(headerName));
        }

        // 3. 打印所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((key, values) -> {
            log.info("参数 {}: {}", key, Arrays.toString(values));
        });

        // 4. 打印原始请求体数据
        try {
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            log.info("原始请求体数据: {}", sb.toString());
        } catch (IOException e) {
            log.error("读取请求体失败", e);
        }

        // 5. 转换成格式化的JSON打印（如果是JSON数据）
        try {
            Map<String, String> params = new HashMap<>();
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                String key = entry.getKey();
                String[] values = entry.getValue();
                params.put(key, values[0]);
            }
            log.info("回调参数JSON格式: {}", new ObjectMapper().writeValueAsString(params));


        } catch (JsonProcessingException e) {
            log.error("JSON转换失败", e);
        }

        return "success";
    }
}
