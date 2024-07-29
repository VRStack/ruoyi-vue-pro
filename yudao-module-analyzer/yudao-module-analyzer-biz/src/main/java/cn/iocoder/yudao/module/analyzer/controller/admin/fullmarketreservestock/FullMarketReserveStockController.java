package cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock.vo.*;
import cn.iocoder.yudao.module.analyzer.dal.dataobject.fullmarketreservestock.FullMarketReserveStockDO;
import cn.iocoder.yudao.module.analyzer.service.fullmarketreservestock.FullMarketReserveStockService;

@Tag(name = "管理后台 - 每日全市场预备票池")
@RestController
@RequestMapping("/analyzer/fullMarketReserveStock")
@Validated
public class FullMarketReserveStockController {

    @Resource
    private FullMarketReserveStockService fullMarketReserveStockService;

    @PostMapping("/create")
    @Operation(summary = "创建每日全市场预备票池")
    @PreAuthorize("@ss.hasPermission('analyzer:full-market-reserve-stock:create')")
    public CommonResult<Long> createFullMarketReserveStock(@Valid @RequestBody FullMarketReserveStockSaveReqVO createReqVO) {
        return success(fullMarketReserveStockService.createFullMarketReserveStock(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新每日全市场预备票池")
    @PreAuthorize("@ss.hasPermission('analyzer:full-market-reserve-stock:update')")
    public CommonResult<Boolean> updateFullMarketReserveStock(@Valid @RequestBody FullMarketReserveStockSaveReqVO updateReqVO) {
        fullMarketReserveStockService.updateFullMarketReserveStock(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除每日全市场预备票池")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('analyzer:full-market-reserve-stock:delete')")
    public CommonResult<Boolean> deleteFullMarketReserveStock(@RequestParam("id") Long id) {
        fullMarketReserveStockService.deleteFullMarketReserveStock(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得每日全市场预备票池")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('analyzer:full-market-reserve-stock:query')")
    public CommonResult<FullMarketReserveStockRespVO> getFullMarketReserveStock(@RequestParam("id") Long id) {
        FullMarketReserveStockDO fullMarketReserveStock = fullMarketReserveStockService.getFullMarketReserveStock(id);
        return success(BeanUtils.toBean(fullMarketReserveStock, FullMarketReserveStockRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得每日全市场预备票池分页")
    @PreAuthorize("@ss.hasPermission('analyzer:full-market-reserve-stock:query')")
    public CommonResult<PageResult<FullMarketReserveStockRespVO>> getFullMarketReserveStockPage(@Valid FullMarketReserveStockPageReqVO pageReqVO) {
        PageResult<FullMarketReserveStockDO> pageResult = fullMarketReserveStockService.getFullMarketReserveStockPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FullMarketReserveStockRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出每日全市场预备票池 Excel")
    @PreAuthorize("@ss.hasPermission('analyzer:full-market-reserve-stock:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFullMarketReserveStockExcel(@Valid FullMarketReserveStockPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FullMarketReserveStockDO> list = fullMarketReserveStockService.getFullMarketReserveStockPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "每日全市场预备票池.xls", "数据", FullMarketReserveStockRespVO.class,
                        BeanUtils.toBean(list, FullMarketReserveStockRespVO.class));
    }

}