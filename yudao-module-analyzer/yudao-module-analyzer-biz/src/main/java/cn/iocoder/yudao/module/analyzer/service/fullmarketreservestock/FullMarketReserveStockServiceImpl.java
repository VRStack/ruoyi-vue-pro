package cn.iocoder.yudao.module.analyzer.service.fullmarketreservestock;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.analyzer.controller.admin.fullmarketreservestock.vo.*;
import cn.iocoder.yudao.module.analyzer.dal.dataobject.fullmarketreservestock.FullMarketReserveStockDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.analyzer.dal.mysql.fullmarketreservestock.FullMarketReserveStockMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.analyzer.enums.ErrorCodeConstants.*;

/**
 * 每日全市场预备票池 Service 实现类
 *
 * @author Alics
 */
@Service
@Validated
public class FullMarketReserveStockServiceImpl implements FullMarketReserveStockService {

    @Resource
    private FullMarketReserveStockMapper fullMarketReserveStockMapper;

    @Override
    public Long createFullMarketReserveStock(FullMarketReserveStockSaveReqVO createReqVO) {
        // 插入
        FullMarketReserveStockDO fullMarketReserveStock = BeanUtils.toBean(createReqVO, FullMarketReserveStockDO.class);
        fullMarketReserveStockMapper.insert(fullMarketReserveStock);
        // 返回
        return fullMarketReserveStock.getId();
    }

    @Override
    public void updateFullMarketReserveStock(FullMarketReserveStockSaveReqVO updateReqVO) {
        // 校验存在
        validateFullMarketReserveStockExists(updateReqVO.getId());
        // 更新
        FullMarketReserveStockDO updateObj = BeanUtils.toBean(updateReqVO, FullMarketReserveStockDO.class);
        fullMarketReserveStockMapper.updateById(updateObj);
    }

    @Override
    public void deleteFullMarketReserveStock(Long id) {
        // 校验存在
        validateFullMarketReserveStockExists(id);
        // 删除
        fullMarketReserveStockMapper.deleteById(id);
    }

    private void validateFullMarketReserveStockExists(Long id) {
        if (fullMarketReserveStockMapper.selectById(id) == null) {
            throw exception(FULL_MARKET_RESERVE_STOCK_NOT_EXISTS);
        }
    }

    @Override
    public FullMarketReserveStockDO getFullMarketReserveStock(Long id) {
        return fullMarketReserveStockMapper.selectById(id);
    }

    @Override
    public PageResult<FullMarketReserveStockDO> getFullMarketReserveStockPage(FullMarketReserveStockPageReqVO pageReqVO) {
        return fullMarketReserveStockMapper.selectPage(pageReqVO);
    }

}