package com.my.structfactorytest.RuleTree;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


@Data
@NoArgsConstructor
class RuleNode {
    // 规则
    private String rule;
    // 子节点
    private RuleNode children;
    //存放节点当前的业务实体类
    private Object o;
    //存放流程节点当前的流转状态
    private BigInteger statusCode;


    public RuleNode(String rule,BigInteger statusCode,Object o) {
        this.rule = rule;
        this.children = null;
        this.statusCode = statusCode;
        this.o = o;
    }


    public Object getObj(){
        return o;
    }

    public String getRule() {
        return rule;
    }

    public RuleNode getChildren() {
        return children;
    }

    public BigInteger getstatusCode(){
        return statusCode;
    }

    public void addChild(RuleNode child) {
        this.children = child;
    }
}