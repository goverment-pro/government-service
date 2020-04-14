package com.sinosoft.fgw.listmanage.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinosoft.fgw.listmanage.entity.LmAddress;
import com.sinosoft.fgw.listmanage.mapper.LmAddressMapper;
import com.sinosoft.fgw.listmanage.service.ILmAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bj
 * @since 2020-04-08
 */
@Service
public class LmAddressServiceImpl extends ServiceImpl<LmAddressMapper, LmAddress> implements ILmAddressService {

    @Autowired
    private LmAddressMapper lmAddressMapper;

    @Override
    public List<LmAddress> queryLmAddress(LmAddress lmAddress) {
        return lmAddressMapper.selectList(Wrappers.<LmAddress>lambdaQuery()
                .eq(StringUtils.isNotEmpty(lmAddress.getUpplaceCode()), LmAddress::getUpplaceCode, lmAddress.getUpplaceCode())
                .eq(StringUtils.isNotEmpty(lmAddress.getPlaceCode()), LmAddress::getPlaceCode, lmAddress.getPlaceCode())
                .eq(StringUtils.isNotEmpty(lmAddress.getPlaceType()), LmAddress::getPlaceType, lmAddress.getPlaceType()));
    }
}
