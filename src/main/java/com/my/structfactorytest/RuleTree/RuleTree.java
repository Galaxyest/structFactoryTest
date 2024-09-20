package com.my.structfactorytest.RuleTree;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
class RuleTree {

    /**
     * 树的根节点(起始节点)
     * */
    private RuleNode node;

    /**
     * 流转状态集合
     * */
    private List<BigInteger> flows;
    //项目中的流转状态
    /**
     * HashMap<String,Object>
     *     Key : Status Name
     *     Value : Status Value
     *     ValueType : Integer,String.
     * */
    private HashMap<String,Object> statusMap;


    public RuleTree(String rootRule, BigInteger statusCode, Object o) {
        this.node = new RuleNode(rootRule, statusCode, o);
    }

    public RuleNode getNode() {
        return node;
    }

    //步入流程
    public void stepInFlows(RuleNode node){
        this.flows.add(node.getstatusCode());

    }



//    // 递归遍历规则树
//    public void traverse(RuleNode node) {
//        if (node == null) return;
//
//        // 打印当前节点的规则
//        System.out.println(node.getRule());
//        for (RuleNode child : node.getChildren()) {
//            // 遍历子节点
//            traverse(child);
//        }
//    }
}