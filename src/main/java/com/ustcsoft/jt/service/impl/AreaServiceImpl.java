package com.ustcsoft.jt.service.impl;

import com.ustcsoft.jt.mapper.AreaMapper;
import com.ustcsoft.jt.service.AreaService;
import com.ustcsoft.jt.vo.AreaVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    @Override
    public List<AreaVO> getAreaChild(String areId, String areaLv) {
        return areaMapper.getAreaChild(areId, areaLv);
    }


    @Override
    public AreaVO getAreaByAreaId(String areaId) {
        return areaMapper.getAreaByAreaId(areaId);
    }

    @Override
    public List<AreaVO> getChildByPId(String pId) {
        return areaMapper.getChildByPId(pId);
    }
}
