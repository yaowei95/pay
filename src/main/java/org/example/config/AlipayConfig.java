package org.example.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {
    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(
                "https://openapi-sandbox.dl.alipaydev.com/gateway.do", // 沙箱环境网关
                "9021000142602981",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDe4XxL+pa2oBtuiSI0b4+5X6KQZTowK0Ls510/Dn4ZWLdya2zgzOqFupMi7n08ME7LDbkb8uSqjLrGicds8CnReM8M3V+bceSKWp8cQdjkr4U0+8fVXoe5dO2WY44IyUMZURRBgA/LmFVlpiIHmE9gndczdk+WxCOIK/m9ewClbxs5BIBjv/Hx7ayat4/N12THrlfuRMzDxsLhWVduvsnvj+K/BAW8dZx2jTSZWnJddPF3fhEydbbiJyRpIyhjW1tW5TD7vWGGf8n+YpqmTSazUbsttsPgd1a2kc/HryI9GlPHLWfXCshZ12KfMeO+omyqHLrTXw7JLQn3UdEubZGxAgMBAAECggEAE1nMauRU1YJNH2m0mIzfE58kBBll1ezLoLnttJ3TgOvc8Yg2KcZgzj+Gqs+9+83N6X9FhRGvnMcfKEGqGOE5IEC26U0HEf3vc7uueMuWwzQiApmhnfrZGdb3EcmO+WBP/RC3C4DM3kZZk7u61KH6sk7B8mvhORvKYfY/dp4JTlOPsV0UMBL7jRAbfMIe05Jn+2iV82KL5WB07xGXbpKzNKC92g6VDP0bsYF4XKoGY0/tDk6H6Q7MU3IWoc9XEfLkvFJC1T9ieavz7k6Yat/4/OtOknPtZBt6xA/ZLQ5lSJMjtM91fWC5x92d+cEZPvuoofYT8wS3YGXtpYiczWStYQKBgQD1TdCGxplJGGK8mGXvVIkfm5x43dLkxPmzqB7w4xWYSFy5DW6bIpGn3PUnm81rWqmMz0Yl/RZn3pady5AIROl+uSs9iHoYCqo9ooxD4KiRlhY/3GUmIIrFFkNyEUha8uQ7R4zTX5XZCVId7A0/e1fkRJZ8umJ1+axgW/VNNFZjtQKBgQDomV/REeVCW5Urt+vJEdxIVHJFdy64wgwIfwfl3P/EWs6hg6xP5Unf92StPjsYlln/r7Sf6WUva0uvj+YMtvd0c6jkcf5IckbaobrcmYixsEAX/OSQhU5uMZmgKzfK2HRZ0/p1eZtOISB+xEgMupEvsOXO1HrqGsJZAb/uVfxrjQKBgQDaxhCQ8vRopXABxWU8AsfcwbrWbPeWgjo0yV729YAf9YGEpP8dKsJ+1Ghsb97PvOb0JzPn04U1E+Z+SrtlNJiOJXT0BxDk+jYEjEDOlMGiPhoP0G8BhwpcZdO3GsTOIEv+tnxZU6lgDJkJCKp0EHw9oBIaoVwI3ains7vdpCzb9QKBgAs508kIXxM7zlBE2SlkJkiLYtR9cxDRtLj4QI5Ugzeb1lsvOrLEczNPAlnmJf4Cy6cueL47CnomaIm5nTXB4uGI737PDaG7ejX1FkqtUk6ZHg7KUtGyzV0+IZb8Xv34Qm1PcMgYrWkw6huUJ5INsxIlLII1+RSxY+3dysCa/8rFAoGAQkRNdmakAmtIxhI2nLb7BeA5wBddsYGORdwHbuWeGiS+IxEhOdPzuoqLxBOR5IEtCsXofmJ2EBgPyk8NFvgqie/VdTGlrWOkd63gw+iHXXqupwrgZY7xh4gvl+Q0ooM0+nfY3IaDNNiZxijwHyjAgZXLy1ynKJ+2LVFrGFp7Cq4=",
                "json",
                "UTF-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApfwOjUwNUuKdaohP63pRRJcv51igeKSlQqe9t1MYOy7FHEceJ0Marfkk/PGKOfuWKTQwNl+QJNblNzMR2eZ/Qo88rFHOYox8RjsR3itBFABzg3+b/lUnNpBlgJmOSOcq9pl/+BhdGPmoIdCTrb6fCmxTU991GOpwsAYHHg2LH6rZ0wyKOJDiOKLsUGAA/vcZgueHSm4A3Q38Z72dm4zeHR5T+DXwGer2vcyhVgNLLOP1Xcihjkf0Gy0qyzIu9oRuAiRHQBchaMNNsFw7v0FP7rKi/1Wtg59ki6mr+J6Hjwhiuru4MCRTle0pOxlFOmFtvlZePh2C5MhlhHvPoQ1cEQIDAQAB",
                "RSA2"
        );
    }
}
