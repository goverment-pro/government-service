package com.sinosoft.fgw.listmanage.service;

import com.sinosoft.fgw.listmanage.entity.LmAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bj
 * @since 2020-04-08
 */
public interface ILmAddressService extends IService<LmAddress> {

    public List<LmAddress> queryLmAddress(LmAddress lmAddress);

}
