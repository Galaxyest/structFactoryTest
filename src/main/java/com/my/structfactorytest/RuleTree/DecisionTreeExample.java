package com.my.structfactorytest.RuleTree;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48; // 使用J48算法，类似于C4.5
import weka.classifiers.Evaluation;
//决策树->训练模型用的
public class DecisionTreeExample {
    public static void main(String[] args) throws Exception {
        // 加载数据集
        DataSource source = new DataSource("path_to_your_data.arff");
        Instances dataset = source.getDataSet();

        // 设置类别索引，Weka规定类别属性是最后一个属性
        if (dataset.classIndex() == -1)
            dataset.setClassIndex(dataset.numAttributes() - 1);

        // 初始化决策树分类器
        J48 tree = new J48();

        // 训练模型
        tree.buildClassifier(dataset);

        // 评估模型
        Evaluation eval = new Evaluation(dataset);
        eval.crossValidateModel(tree, dataset, 10, new java.util.Random(1));

        // 打印评估结果
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));
    }


}
