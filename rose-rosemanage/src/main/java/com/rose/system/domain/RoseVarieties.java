package com.rose.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rose.common.annotation.Excel;
import com.rose.common.core.domain.BaseEntity;

/**
 * 品种对象 rose_rose_varieties
 *
 * @author rose
 * @date 2025-02-17
 */
public class RoseVarieties extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 玫瑰品种 */
    @Excel(name = "玫瑰品种")
    private String roseVarieties;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setRoseVarieties(String roseVarieties)
    {
        this.roseVarieties = roseVarieties;
    }

    public String getRoseVarieties()
    {
        return roseVarieties;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roseVarieties", getRoseVarieties())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
