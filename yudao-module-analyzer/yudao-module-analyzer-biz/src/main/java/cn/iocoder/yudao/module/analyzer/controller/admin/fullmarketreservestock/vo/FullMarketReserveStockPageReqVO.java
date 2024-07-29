package cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 每日全市场预备票池分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FullMarketReserveStockPageReqVO extends PageParam {

    @Schema(description = "日期yymmdd")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Integer[] date;

    @Schema(description = "股票代码")
    private Integer stockCode;

    @Schema(description = "最可能所属行业板块id", example = "1064")
    private Integer industryContinentId;

    @Schema(description = "最可能所属概念板块id", example = "19448")
    private Integer conceptContinentId;

}