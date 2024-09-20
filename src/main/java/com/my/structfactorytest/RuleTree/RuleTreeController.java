package com.my.structfactorytest.RuleTree;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class RuleTreeController {

    private static final Logger log = LoggerFactory.getLogger(RuleTreeController.class);

    //添加节点到节点树：
    public void insertNodeToTree(RuleNode node){
        //创建业务规则树
        RuleTree tree = new RuleTree();
        //添加业务起始节点
        if (tree.getNode() == null) {
            tree.getFlows().add(node.getstatusCode());
            tree.setNode(node);
            log.info("添加业务流程起点：{}", tree);
            log.info("当前节点流转为: {}",node.getstatusCode());
        }

        //得到当前的业务节点
        //规则树添加当前业务节点
        while(tree.getNode().getChildren() == null){
            tree.getFlows().add(node.getstatusCode());
            tree.getNode().setChildren(node);
            log.info("当前节点已添加，当前的节点流转为: {}",node.getstatusCode());
            log.info("总体的节点流为: {}",tree.getFlows());
        }
    }


    //将树数转化为数组
    public List<RuleNode> treeToList(RuleTree tree){
        List<RuleNode> nodeList = new ArrayList<>();
        while(tree.getNode().getChildren() != null){
            RuleNode node = tree.getNode();
            nodeList.add(node);
        }
        log.info("当前规则树已转化为list: {}",nodeList);
        return nodeList;

    }

    //步入节点
    public RuleNode stepInTree(RuleTree tree, BigInteger code){

        while(code == tree.getNode().getstatusCode()){
            return tree.getNode();
        }
        return null;
    }











}
