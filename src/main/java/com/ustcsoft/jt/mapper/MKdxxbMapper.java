package com.ustcsoft.jt.mapper;


import com.ustcsoft.jt.vo.Location;
import com.ustcsoft.jt.vo.MKdxxb;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.ustcsoft.jt.mybatis.Page;


public interface MKdxxbMapper {

    /** 分页查询 */
    List<MKdxxb> queryPage(@Param("mKdxxb")MKdxxb mKdxxb, @Param("page") Page<MKdxxb> page);

    /** 新增 */
    int insert(MKdxxb mKdxxb);

    /** 修改 */
    int update(MKdxxb mKdxxb);

    /** 根据区划获取库点信息 */
    List<MKdxxb> getKdxxByAreaId(@Param("areaId") String areaId);

    List<MKdxxb> findkd(@Param("parms")Map<String, String> parms);

    /**  根据type 获取不同收粮状态的库点 */
    List<MKdxxb> findKslkd(@Param("parms")Map<String, String> parms);
}
