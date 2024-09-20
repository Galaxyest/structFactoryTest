package com.my.structfactorytest.Monitor;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkMonitor {

    public static void main(String[] args) {
        // 示例请求URL
        String requestUrl = "https://www.baidu.com";

        // 发送网络请求并监控
        try {
            sendNetworkRequest(requestUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendNetworkRequest(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // 获取响应代码
        int responseCode = connection.getResponseCode();
        StringBuilder response = new StringBuilder();

        if (responseCode == 200) { // HTTP OK
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            // 弹窗提示请求信息
            showPopup("网络请求已发送", "请求URL: " + requestUrl);
        } else {
            showPopup("网络请求失败", "请求URL: " + requestUrl);
        }

        connection.disconnect();
    }

    public static void showPopup(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
