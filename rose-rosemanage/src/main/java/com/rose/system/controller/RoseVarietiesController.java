package com.rose.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rose.common.annotation.Log;
import com.rose.common.core.controller.BaseController;
import com.rose.common.core.domain.AjaxResult;
import com.rose.common.enums.BusinessType;
import com.rose.system.domain.RoseVarieties;
import com.rose.system.service.IRoseVarietiesService;
import com.rose.common.utils.poi.ExcelUtil;
import com.rose.common.core.page.TableDataInfo;

/**
 * 品种Controller
 *
 * @author rose
 * @date 2025-02-17
 */
@RestController
@RequestMapping("/system/varieties")
public class RoseVarietiesController extends BaseController
{
    @Autowired
    private IRoseVarietiesService roseVarietiesService;

    /**
     * 查询品种列表
     */
    @PreAuthorize("@ss.hasPermi('system:varieties:list')")
    @GetMapping("/list")
    public TableDataInfo list(RoseVarieties roseVarieties)
    {
        startPage();
        List<RoseVarieties> list = roseVarietiesService.selectRoseVarietiesList(roseVarieties);
        return getDataTable(list);
    }

    /**
     * 导出品种列表
     */
    @PreAuthorize("@ss.hasPermi('system:varieties:export')")
    @Log(title = "品种", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RoseVarieties roseVarieties)
    {
        List<RoseVarieties> list = roseVarietiesService.selectRoseVarietiesList(roseVarieties);
        ExcelUtil<RoseVarieties> util = new ExcelUtil<RoseVarieties>(RoseVarieties.class);
        util.exportExcel(response, list, "品种数据");
    }

    /**
     * 获取品种详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:varieties:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(roseVarietiesService.selectRoseVarietiesById(id));
    }

    /**
     * 新增品种
     */
    @PreAuthorize("@ss.hasPermi('system:varieties:add')")
    @Log(title = "品种", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RoseVarieties roseVarieties)
    {
        return toAjax(roseVarietiesService.insertRoseVarieties(roseVarieties));
    }

    /**
     * 修改品种
     */
    @PreAuthorize("@ss.hasPermi('system:varieties:edit')")
    @Log(title = "品种", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RoseVarieties roseVarieties)
    {
        return toAjax(roseVarietiesService.updateRoseVarieties(roseVarieties));
    }

    /**
     * 删除品种
     */
    @PreAuthorize("@ss.hasPermi('system:varieties:remove')")
    @Log(title = "品种", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(roseVarietiesService.deleteRoseVarietiesByIds(ids));
    }
}
