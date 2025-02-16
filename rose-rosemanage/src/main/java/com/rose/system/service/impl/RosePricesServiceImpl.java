package com.rose.system.service.impl;

import java.util.List;
import com.rose.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rose.system.mapper.RosePricesMapper;
import com.rose.system.domain.RosePrices;
import com.rose.system.service.IRosePricesService;

/**
 * 价格Service业务层处理
 *
 * @author ll1001020
 * @date 2025-02-16
 */
@Service
public class RosePricesServiceImpl implements IRosePricesService
{
    @Autowired
    private RosePricesMapper rosePricesMapper;

    /**
     * 查询价格
     *
     * @param id 价格主键
     * @return 价格
     */
    @Override
    public RosePrices selectRosePricesById(Long id)
    {
        return rosePricesMapper.selectRosePricesById(id);
    }

    /**
     * 查询价格列表
     *
     * @param rosePrices 价格
     * @return 价格
     */
    @Override
    public List<RosePrices> selectRosePricesList(RosePrices rosePrices)
    {
        return rosePricesMapper.selectRosePricesList(rosePrices);
    }

    /**
     * 新增价格
     *
     * @param rosePrices 价格
     * @return 结果
     */
    @Override
    public int insertRosePrices(RosePrices rosePrices)
    {
        rosePrices.setCreateTime(DateUtils.getNowDate());
        return rosePricesMapper.insertRosePrices(rosePrices);
    }

    /**
     * 修改价格
     *
     * @param rosePrices 价格
     * @return 结果
     */
    @Override
    public int updateRosePrices(RosePrices rosePrices)
    {
        rosePrices.setUpdateTime(DateUtils.getNowDate());
        return rosePricesMapper.updateRosePrices(rosePrices);
    }

    /**
     * 批量删除价格
     *
     * @param ids 需要删除的价格主键
     * @return 结果
     */
    @Override
    public int deleteRosePricesByIds(Long[] ids)
    {
        return rosePricesMapper.deleteRosePricesByIds(ids);
    }

    /**
     * 删除价格信息
     *
     * @param id 价格主键
     * @return 结果
     */
    @Override
    public int deleteRosePricesById(Long id)
    {
        return rosePricesMapper.deleteRosePricesById(id);
    }
}
