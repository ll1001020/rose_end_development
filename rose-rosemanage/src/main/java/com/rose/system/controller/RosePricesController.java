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
import com.rose.system.domain.RosePrices;
import com.rose.system.service.IRosePricesService;
import com.rose.common.utils.poi.ExcelUtil;
import com.rose.common.core.page.TableDataInfo;

/**
 * 价格Controller
 *
 * @author ll1001020
 * @date 2025-02-16
 */
@RestController
@RequestMapping("/system/prices")
public class RosePricesController extends BaseController
{
    @Autowired
    private IRosePricesService rosePricesService;

    /**
     * 查询价格列表
     */
    @PreAuthorize("@ss.hasPermi('system:prices:list')")
    @GetMapping("/list")
    public TableDataInfo list(RosePrices rosePrices)
    {
        startPage();
        List<RosePrices> list = rosePricesService.selectRosePricesList(rosePrices);
        return getDataTable(list);
    }

    /**
     * 导出价格列表
     */
    @PreAuthorize("@ss.hasPermi('system:prices:export')")
    @Log(title = "价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RosePrices rosePrices)
    {
        List<RosePrices> list = rosePricesService.selectRosePricesList(rosePrices);
        ExcelUtil<RosePrices> util = new ExcelUtil<RosePrices>(RosePrices.class);
        util.exportExcel(response, list, "价格数据");
    }

    /**
     * 获取价格详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:prices:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rosePricesService.selectRosePricesById(id));
    }

    /**
     * 新增价格
     */
    @PreAuthorize("@ss.hasPermi('system:prices:add')")
    @Log(title = "价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RosePrices rosePrices)
    {
        return toAjax(rosePricesService.insertRosePrices(rosePrices));
    }

    /**
     * 修改价格
     */
    @PreAuthorize("@ss.hasPermi('system:prices:edit')")
    @Log(title = "价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RosePrices rosePrices)
    {
        return toAjax(rosePricesService.updateRosePrices(rosePrices));
    }

    /**
     * 删除价格
     */
    @PreAuthorize("@ss.hasPermi('system:prices:remove')")
    @Log(title = "价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rosePricesService.deleteRosePricesByIds(ids));
    }
}
