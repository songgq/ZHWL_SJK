package com.ustcsoft.jt.mapper;


import com.ustcsoft.jt.vo.BZhiBiao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ustcsoft.jt.mybatis.Page;


public interface BZhiBiaoMapper {

    /** 分页查询 */
    List<BZhiBiao> queryPage(@Param("bZhiBiao")BZhiBiao bZhiBiao, @Param("page") Page<BZhiBiao> page);

    /** 新增 */
    int insert(BZhiBiao bZhiBiao);

    /** 修改 */
    int update(BZhiBiao bZhiBiao);
}
