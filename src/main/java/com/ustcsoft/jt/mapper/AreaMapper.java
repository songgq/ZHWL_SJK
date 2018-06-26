package com.ustcsoft.jt.mapper;

import com.ustcsoft.jt.vo.AreaVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */
public interface AreaMapper {

    // 获取区划信息
    List<AreaVO> getAreaChild(String areaId, String areaLv);

    @Select("SELECT qh.XING_ZHENG_QU_HUA_DAI_MA as areaId, qh.XING_ZHENG_QU_HUA_MING_CHENG as areaName, qh.XING_ZHENG_QU_HUA_DENG_JI as areaLV," +
            "qh.FU_XING_ZHENG_QU_HUA_DAI_MA parentAreaId FROM u_com00.m_xzqhdm qh where qh.XING_ZHENG_QU_HUA_DAI_MA = #{0}")
    AreaVO getAreaByAreaId(String areaId);

    List<AreaVO> getChildByPId(@Param("pId") String pId);
}
