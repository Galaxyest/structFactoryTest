package com.my.structfactorytest.configuration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private final Map<String, String> serviceEndpoints = new HashMap<>();

    public GatewayController() {
        // 初始化服务端点映射
        serviceEndpoints.put("service1", "http://service1.gatewayDemo.com");
        serviceEndpoints.put("service2", "http://service2.gatewayDemo.com");
    }

    @PostMapping("/request")
    public String forwardRequest(@RequestBody Map<String, Object> request) {
        String serviceName = (String) request.get("service");
        String endpoint = serviceEndpoints.get(serviceName);

        if (endpoint == null) {
            return "Unknown Service";
        }

        // 这里使用RestTemplate来转发请求，实际应用中可能需要更复杂的逻辑
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(endpoint + "/request", request, String.class);



        return response;
    }
}
