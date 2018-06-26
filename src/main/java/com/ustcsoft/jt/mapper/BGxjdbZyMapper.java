package com.ustcsoft.jt.mapper;


import com.ustcsoft.jt.vo.BGxjdbZy;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ustcsoft.jt.mybatis.Page;


public interface BGxjdbZyMapper {

    /** 分页查询 */
    List<BGxjdbZy> queryPage(@Param("bGxjdbZy")BGxjdbZy bGxjdbZy, @Param("page") Page<BGxjdbZy> page);

    /** 新增 */
    int insert(BGxjdbZy bGxjdbZy);

    /** 修改 */
    int update(BGxjdbZy bGxjdbZy);

    /** 根据库点id查询库点购销计划 */
    List<BGxjdbZy> getGxjxByKdId(@Param("kdId") String kdId);

    /** 根据机构id查询库点购销计划 */
    public List<BGxjdbZy> getGxjxByOrgId(@Param("orgId") String orgId);

    /** 查询外网用户预约的购销计划列表 */
    List<BGxjdbZy> getGxjhList(@Param("userId") String userId);
}
