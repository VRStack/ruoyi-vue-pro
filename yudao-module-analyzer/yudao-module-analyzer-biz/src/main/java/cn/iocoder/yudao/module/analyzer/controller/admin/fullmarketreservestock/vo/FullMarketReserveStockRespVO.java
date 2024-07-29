package cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 每日全市场预备票池 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FullMarketReserveStockRespVO {

    @Schema(description = "自增主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "32168")
    @ExcelProperty("自增主键")
    private Long id;

    @Schema(description = "日期yymmdd")
    @ExcelProperty("日期yymmdd")
    private Integer date;

    @Schema(description = "股票代码")
    @ExcelProperty("股票代码")
    private Integer stockCode;

    @Schema(description = "最可能所属行业板块id", example = "1064")
    @ExcelProperty("最可能所属行业板块id")
    private Integer industryContinentId;

    @Schema(description = "最可能所属概念板块id", example = "19448")
    @ExcelProperty("最可能所属概念板块id")
    private Integer conceptContinentId;

}