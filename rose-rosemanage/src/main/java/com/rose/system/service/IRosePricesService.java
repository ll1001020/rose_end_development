package com.rose.system.service;

import java.util.List;
import com.rose.system.domain.RosePrices;

/**
 * 价格Service接口
 * 
 * @author ll1001020
 * @date 2025-02-16
 */
public interface IRosePricesService 
{
    /**
     * 查询价格
     * 
     * @param id 价格主键
     * @return 价格
     */
    public RosePrices selectRosePricesById(Long id);

    /**
     * 查询价格列表
     * 
     * @param rosePrices 价格
     * @return 价格集合
     */
    public List<RosePrices> selectRosePricesList(RosePrices rosePrices);

    /**
     * 新增价格
     * 
     * @param rosePrices 价格
     * @return 结果
     */
    public int insertRosePrices(RosePrices rosePrices);

    /**
     * 修改价格
     * 
     * @param rosePrices 价格
     * @return 结果
     */
    public int updateRosePrices(RosePrices rosePrices);

    /**
     * 批量删除价格
     * 
     * @param ids 需要删除的价格主键集合
     * @return 结果
     */
    public int deleteRosePricesByIds(Long[] ids);

    /**
     * 删除价格信息
     * 
     * @param id 价格主键
     * @return 结果
     */
    public int deleteRosePricesById(Long id);
}
