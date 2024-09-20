package com.my.structfactorytest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 修改记录表(SafetyModifyRecord)实体类
 *
 * @author makejava
 * @since 2024-05-14 20:49:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SafetyModifyRecord implements Serializable {
    /**
     * 主键，自增
     */
    private Long id;
    /**
     * 修改类型
     */
    private String moduleType;
    /**
     * 修改数据id
     */
    private Long moduleId;
    /**
     * 修改后内容
     */
    private String modifyContent;
    /**
     * 提交人id
     */
    private Long submitBy;
    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;
    /**
     * 审核人id
     */
    private Long auditBy;
    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date auditTime;
    /**
     * 审批状态 1:新增 2:修改 3:审核通过 4:审核驳回 5:审核关闭 6:审核转交 7:审核挂起 8L:暂存
     */
    private Long auditState;
    /**
     * 审核备注
     */
    private String auditRemark;
    /**
     * 审核部门id
     */
    private Long auditDeptId;

    /**
     * 审核人姓名
     */
    private String auditName;
    /**
     * 审核部门名称
     */
    private String auditDeptName;

    /**
     * 提交人名称
     */
    private String submitName;

    /**
     * 提交人联系电话
     */
    private String submitPhone;


}

