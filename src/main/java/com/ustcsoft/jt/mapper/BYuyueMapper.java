package com.ustcsoft.jt.mapper;


import com.ustcsoft.jt.vo.BGxjdbZy;
import com.ustcsoft.jt.vo.BYuyue;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.ustcsoft.jt.mybatis.Page;
import org.apache.ibatis.annotations.Select;


public interface BYuyueMapper {

    /** 分页查询 */
    List<BYuyue> queryPage(@Param("bYuyue")BYuyue bYuyue, @Param("page") Page<BYuyue> page);

    /** 新增 */
    int insert(BYuyue bYuyue);

    /** 修改 */
    int update(BYuyue bYuyue);

    /** 根据用户id查询预约结果 */
    BYuyue queryYuYueResult(String userId);

    /** 获取购销计划对应的排队人数 */
    @Select("SELECT count(1)  FROM b_yuyue yy LEFT JOIN u_01_tkyw.b_gxjdb_zy gx on yy.gxId = gx.id where yy.`status` = '0' and gx.id = #{gxjhId}")
    int getGxjhPdrs(String gxjhId);

    /** 查询用户预约的购销计划 对应的预约信息 的状态 */
    @Select("SELECT yy.`status` FROM b_yuyue yy where creater = #{parms.userId} and yy.gxId = #{parms.gxId}")
    List<BYuyue> getYyxxByUserIdAndGxId(@Param("parms") Map<String, String> parms);
}
