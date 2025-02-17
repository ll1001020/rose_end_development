package com.rose.system.service.impl;

import java.util.List;
import com.rose.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rose.system.mapper.RoseVarietiesMapper;
import com.rose.system.domain.RoseVarieties;
import com.rose.system.service.IRoseVarietiesService;

/**
 * 品种Service业务层处理
 *
 * @author rose
 * @date 2025-02-17
 */
@Service
public class RoseVarietiesServiceImpl implements IRoseVarietiesService
{
    @Autowired
    private RoseVarietiesMapper roseVarietiesMapper;

    /**
     * 查询品种
     *
     * @param id 品种主键
     * @return 品种
     */
    @Override
    public RoseVarieties selectRoseVarietiesById(Long id)
    {
        return roseVarietiesMapper.selectRoseVarietiesById(id);
    }

    /**
     * 查询品种列表
     *
     * @param roseVarieties 品种
     * @return 品种
     */
    @Override
    public List<RoseVarieties> selectRoseVarietiesList(RoseVarieties roseVarieties)
    {
        return roseVarietiesMapper.selectRoseVarietiesList(roseVarieties);
    }

    /**
     * 新增品种
     *
     * @param roseVarieties 品种
     * @return 结果
     */
    @Override
    public int insertRoseVarieties(RoseVarieties roseVarieties)
    {
        roseVarieties.setCreateTime(DateUtils.getNowDate());
        return roseVarietiesMapper.insertRoseVarieties(roseVarieties);
    }

    /**
     * 修改品种
     *
     * @param roseVarieties 品种
     * @return 结果
     */
    @Override
    public int updateRoseVarieties(RoseVarieties roseVarieties)
    {
        roseVarieties.setUpdateTime(DateUtils.getNowDate());
        return roseVarietiesMapper.updateRoseVarieties(roseVarieties);
    }

    /**
     * 批量删除品种
     *
     * @param ids 需要删除的品种主键
     * @return 结果
     */
    @Override
    public int deleteRoseVarietiesByIds(Long[] ids)
    {
        return roseVarietiesMapper.deleteRoseVarietiesByIds(ids);
    }

    /**
     * 删除品种信息
     *
     * @param id 品种主键
     * @return 结果
     */
    @Override
    public int deleteRoseVarietiesById(Long id)
    {
        return roseVarietiesMapper.deleteRoseVarietiesById(id);
    }
}
