package cn.iocoder.yudao.module.analyzer.dal.dataobject.fullmarketreservestock;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 每日全市场预备票池 DO
 *
 * @author Alics
 */
@TableName("daily_full_market_reserve_stock")
@KeySequence("daily_full_market_reserve_stock_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullMarketReserveStockDO extends BaseDO {

    /**
     * 自增主键
     */
    @TableId
    private Long id;
    /**
     * 日期yymmdd
     */
    private Integer date;
    /**
     * 股票代码
     */
    private Integer stockCode;
    /**
     * 最可能所属行业板块id
     */
    private Integer industryContinentId;
    /**
     * 最可能所属概念板块id
     */
    private Integer conceptContinentId;

}