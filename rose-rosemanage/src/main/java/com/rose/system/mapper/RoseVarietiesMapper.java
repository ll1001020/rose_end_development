package com.rose.system.mapper;

import java.util.List;
import com.rose.system.domain.RoseVarieties;

/**
 * 品种Mapper接口
 * 
 * @author rose
 * @date 2025-02-17
 */
public interface RoseVarietiesMapper 
{
    /**
     * 查询品种
     * 
     * @param id 品种主键
     * @return 品种
     */
    public RoseVarieties selectRoseVarietiesById(Long id);

    /**
     * 查询品种列表
     * 
     * @param roseVarieties 品种
     * @return 品种集合
     */
    public List<RoseVarieties> selectRoseVarietiesList(RoseVarieties roseVarieties);

    /**
     * 新增品种
     * 
     * @param roseVarieties 品种
     * @return 结果
     */
    public int insertRoseVarieties(RoseVarieties roseVarieties);

    /**
     * 修改品种
     * 
     * @param roseVarieties 品种
     * @return 结果
     */
    public int updateRoseVarieties(RoseVarieties roseVarieties);

    /**
     * 删除品种
     * 
     * @param id 品种主键
     * @return 结果
     */
    public int deleteRoseVarietiesById(Long id);

    /**
     * 批量删除品种
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRoseVarietiesByIds(Long[] ids);
}
