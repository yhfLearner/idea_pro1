package com.hwua.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ExceptionConfig {
    @Bean
    public ErrorAttributes errorAttributes(){
        return new MyErrorAttributes();
    }
    class MyErrorAttributes extends DefaultErrorAttributes{
        @Override
        public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
            Map<String,Object> map = new HashMap<>(super.getErrorAttributes(webRequest, includeStackTrace));//保留sprinboot原先的异常处理信息。
            Map<String,Object> extmap = (Map<String,Object>)webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);//从request域中取出我们自定义的那个map对象
            map.putAll(extmap);
            return map;
        }
    }
}
