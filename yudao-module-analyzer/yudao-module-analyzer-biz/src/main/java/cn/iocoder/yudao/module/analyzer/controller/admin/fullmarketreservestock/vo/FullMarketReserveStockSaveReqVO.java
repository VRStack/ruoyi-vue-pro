package cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 每日全市场预备票池新增/修改 Request VO")
@Data
public class FullMarketReserveStockSaveReqVO {

    private Long id;

    @Schema(description = "日期yymmdd")
    private Integer date;

    @Schema(description = "股票代码")
    private Integer stockCode;

    @Schema(description = "最可能所属行业板块id", example = "1064")
    private Integer industryContinentId;

    @Schema(description = "最可能所属概念板块id", example = "19448")
    private Integer conceptContinentId;

}