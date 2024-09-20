package com.my.structfactorytest.configuration;

import java.util.Random;

//模拟波函数坍缩->规则和随机都有
public class WaveFunctionCollapse {

    public static void main(String[] args) {
        // 定义波函数的概率幅，这里假设有3个可能的本征态
        double[] waveFunction = {0.6, 0.3, 0.1};

        // 模拟波函数坍缩
        int collapsedState = simulateWaveFunctionCollapse(waveFunction);

        // 打印结果
        System.out.println("波函数坍缩到本征态 " + collapsedState + " 的概率为 " + waveFunction[collapsedState]);
    }

    private static int simulateWaveFunctionCollapse(double[] waveFunction) {
        // 计算波函数的总概率
        double totalProbability = 0;
        for (double probability : waveFunction) {
            totalProbability += probability;


        }

        // 生成一个随机数，用于选择本征态
        Random random = new Random();
        double randomValue = random.nextDouble() * totalProbability;

        // 根据随机数选择本征态
        int state = 0;
        for (double probability : waveFunction) {
            if (randomValue <= probability) {
                return state;
            }
            randomValue -= probability;
            state++;
        }

        // 如果出现错误，返回-1
        return -1;
    }
}