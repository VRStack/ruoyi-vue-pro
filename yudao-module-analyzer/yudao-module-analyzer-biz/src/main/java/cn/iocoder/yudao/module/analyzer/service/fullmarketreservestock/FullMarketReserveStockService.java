package cn.iocoder.yudao.module.analyzer.service.fullmarketreservestock;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock.vo.*;
import cn.iocoder.yudao.module.analyzer.dal.dataobject.fullmarketreservestock.FullMarketReserveStockDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 每日全市场预备票池 Service 接口
 *
 * @author Alics
 */
public interface FullMarketReserveStockService {

    /**
     * 创建每日全市场预备票池
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFullMarketReserveStock(@Valid FullMarketReserveStockSaveReqVO createReqVO);

    /**
     * 更新每日全市场预备票池
     *
     * @param updateReqVO 更新信息
     */
    void updateFullMarketReserveStock(@Valid FullMarketReserveStockSaveReqVO updateReqVO);

    /**
     * 删除每日全市场预备票池
     *
     * @param id 编号
     */
    void deleteFullMarketReserveStock(Long id);

    /**
     * 获得每日全市场预备票池
     *
     * @param id 编号
     * @return 每日全市场预备票池
     */
    FullMarketReserveStockDO getFullMarketReserveStock(Long id);

    /**
     * 获得每日全市场预备票池分页
     *
     * @param pageReqVO 分页查询
     * @return 每日全市场预备票池分页
     */
    PageResult<FullMarketReserveStockDO> getFullMarketReserveStockPage(FullMarketReserveStockPageReqVO pageReqVO);

}