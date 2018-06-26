package com.ustcsoft.jt.mapper;


import com.ustcsoft.jt.vo.AppUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ustcsoft.jt.mybatis.Page;


public interface AppUserMapper {

    /** 分页查询 */
    List<AppUser> queryPage(@Param("appUser")AppUser appUser, @Param("page") Page<AppUser> page);

    /** 新增 */
    int insert(AppUser appUser);

    /** 修改 */
    int update(AppUser appUser);

    AppUser loadAppUserByUsername(String username);
}
