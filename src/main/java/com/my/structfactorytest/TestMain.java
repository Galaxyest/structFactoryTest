package com.my.structfactorytest;

import com.baomidou.mybatisplus.extension.api.R;
import com.my.structfactorytest.Interfaces.Idempotent;
import com.my.structfactorytest.entity.SafetyModifyRecord;
import com.my.structfactorytest.study.Math;
import com.my.structfactorytest.toolMain.test1;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

import static com.alibaba.fastjson.JSONPatch.OperationType.test;

public class TestMain {


    public static void main(String[] args) {
        System.out.println(test1.ACTIVITY);
        System.out.println(test1.ACTIVITY.getCode());
        System.out.println(test1.ACTIVITY.getName());

        String a = "活动表";

        int age = 0;

        System.out.println(age);


    }


}
