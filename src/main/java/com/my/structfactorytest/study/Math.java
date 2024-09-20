package com.my.structfactorytest.study;

import com.my.structfactorytest.Interfaces.Idempotent;

public class Math {

    @Idempotent
   public static void sss(int age){
        age++;
    };

}
