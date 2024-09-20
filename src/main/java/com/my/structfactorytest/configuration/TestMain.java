package com.my.structfactorytest.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.activation.DataSource;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {


    public static void main(String[] args) {
        Map<String, List<String>> dataMap = new HashMap<>();
        dataMap.put("NO.1.电工作业", Arrays.asList("NO.1.低压电工作业","NO.2.高压电工作业","NO.3.电力电缆作业","NO.4.继电保护作业","NO.5.作业"));
        dataMap.put("NO.2.焊接与热切割作业",Arrays.asList("NO.1.熔化焊接与热切割作业","NO.2.压力焊作业"));
        dataMap.put("NO.3.高处作业",Arrays.asList("NO.1.登高架设作业","NO.2.悬空作业","NO.3.攀登作业"));
        dataMap.put("NO.4.制冷与空调作业",Arrays.asList("NO.1.制冷与空调作业"));
        dataMap.put("NO.5.煤矿安全作业",Arrays.asList("NO.1.煤矿井下电气","NO.2.煤矿井下爆破","NO.3.煤矿安全监测监控","NO.4.煤矿安全检测监控","NO.5.煤炉瓦斯检查","NO.6.煤炉安全检查","NO.7.煤矿提升机操作","NO.8.煤矿采煤机操作","NO.9.煤矿掘进机操作","NO.10.煤矿瓦斯抽采","NO.11.煤矿探放水","NO.12.煤矿防冲","NO.13.煤矿无轨胶轮车操作"));
        dataMap.put("NO.6.金属非金属矿山安全作业",Arrays.asList("NO.1.金属非金属矿井通风","NO.2.尾矿","NO.3.金属非金属矿山提升机操作","NO.4.金属非金属矿山支护","NO.5.金属非金属地下矿山主排水","NO.6.金属非金属矿山无轨胶轮车操作"));
        dataMap.put("NO.7.石油天然气安全作业",Arrays.asList("NO.1.钻井司钻作业","NO.2.井下作业司钻作业"));
        dataMap.put("NO.8.冶金生产安全作业",Arrays.asList("NO.1.煤气作业"));
        dataMap.put("NO.9.危险化学品安全作业",Arrays.asList("NO.1.光气及光气化工艺作业","NO.2.氯碱电解工艺作业","NO.3.氯化工艺作业","NO.4.硝化工艺作业","NO.5.合作氨工艺作业","NO.6.裂解（裂化）工艺作业","NO.7.氟化工艺作业","NO.8.加氢工艺作业"));
        dataMap.put("NO.10.烟花爆竹安全作业",Arrays.asList("NO.1.烟火药制造作业","NO.2.黑火药制造作业","NO.3.引火线制造作业","NO.4.烟花爆竹产品涉药作业","NO.5.烟花爆竹储存作业"));
        dataMap.put("NO.11.有限空间安全作业",Arrays.asList("NO.1.有限空间监护作业"));
        dataMap.put("NO.12.应急救援作业",Arrays.asList("NO.1.矿山救援作业","NO.2.危险化学品救援作业","NO.3.建筑物坍塌救援作业","NO.4.水域救援作业","NO.5.高空绳索救援作业","NO.6.直升机救援作业"));
        dataMap.put("NO.13.其他作业",Arrays.asList("NO.1.其他操作"));

        String a = "NO.1.电工作业";
        String b = ".";

    }
}
