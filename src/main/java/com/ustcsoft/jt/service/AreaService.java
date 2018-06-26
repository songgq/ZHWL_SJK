package com.ustcsoft.jt.service;

import com.ustcsoft.jt.vo.AreaVO;

import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */
public interface AreaService {

    /**
     * 根据机构id，区划等级查询区划子区划
     *
     * @param areId
     * @param areaLv
     * @return
     */
    List<AreaVO> getAreaChild(String areId, String areaLv);

    AreaVO getAreaByAreaId(String areaId);

    /**
     * @des 根据父code 查询子区划
     * @param pId
     * @return
     */
    List<AreaVO> getChildByPId(String pId);
}
