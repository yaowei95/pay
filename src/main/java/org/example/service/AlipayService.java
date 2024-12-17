package org.example.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AlipayService {
    @Autowired
    private AlipayClient alipayClient;

    public String createPayQrCode(String orderId, BigDecimal amount) {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();

        model.setOutTradeNo(orderId);
        model.setTotalAmount(amount.toString());
        model.setSubject("测试商品");
        model.setProductCode("FAST_INSTANT_TRADE_PAY");

        request.setBizModel(model);
        request.setNotifyUrl("http://8.148.7.208:8080/pay/notify");

        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request, "POST");
            if(response.isSuccess()) {
                return response.getBody();// 返回二维码链接
            }
        } catch (AlipayApiException e) {
            // 异常处理
        }
        return null;
    }
}
