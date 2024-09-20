package com.my.structfactorytest.tensorFlow;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.nio.charset.StandardCharsets;

public class testFlow {
    public static void main(String[] args) {
        try (Graph graph = new Graph()) {
            // 在图中构建操作
            final String query = "Hello from TensorFlow.js";
            Tensor<String> t = Tensor.create(query.getBytes(StandardCharsets.UTF_8), String.class);

            

            // 执行
            try (Session session = new Session(graph)) {
                // 这里可以添加图的计算逻辑，并通过Session执行
                // 示例操作（具体操作内容根据实际需求修改）
                // session.runner().fetch(...).run();
            }
        }
    }
}
