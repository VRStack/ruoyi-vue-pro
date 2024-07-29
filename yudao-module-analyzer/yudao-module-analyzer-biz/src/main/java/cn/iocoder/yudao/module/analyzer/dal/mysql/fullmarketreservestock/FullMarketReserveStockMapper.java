package cn.iocoder.yudao.module.analyzer.dal.mysql.fullmarketreservestock;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.analyzer.dal.dataobject.fullmarketreservestock.FullMarketReserveStockDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock.vo.*;

/**
 * 每日全市场预备票池 Mapper
 *
 * @author Alics
 */
@Mapper
public interface FullMarketReserveStockMapper extends BaseMapperX<FullMarketReserveStockDO> {

    default PageResult<FullMarketReserveStockDO> selectPage(FullMarketReserveStockPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FullMarketReserveStockDO>()
                .betweenIfPresent(FullMarketReserveStockDO::getDate, reqVO.getDate())
                .eqIfPresent(FullMarketReserveStockDO::getStockCode, reqVO.getStockCode())
                .eqIfPresent(FullMarketReserveStockDO::getIndustryContinentId, reqVO.getIndustryContinentId())
                .eqIfPresent(FullMarketReserveStockDO::getConceptContinentId, reqVO.getConceptContinentId())
                .orderByDesc(FullMarketReserveStockDO::getId));
    }

}