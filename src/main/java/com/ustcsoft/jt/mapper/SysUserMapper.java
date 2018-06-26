package com.ustcsoft.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.vo.SysUserVO;

public interface SysUserMapper {

	@Select("select * from u_com00.M_user where ORG_ID = #{orgId}")
	List<UserVO> findUserListByOrg(String orgId);

	List<SysUserVO> selectOrgUserPage(@Param("sysUser") SysUserVO sysUser, @Param("page") Page<SysUserVO> pageVO);

	List<SysUserVO> selectOrgUserNotAdminPage(@Param("sysUser") SysUserVO sysUser,
			@Param("page") Page<SysUserVO> pageVO);

	String findMaxUserId();

	void insertSysUser(@Param("sysUser") SysUserVO sysUser);

	void updateUser(@Param("sysUser") SysUserVO sysUser);

	void deleteSysUserRoleByUserId(@Param("sysUser") SysUserVO sysUser);

	void deleteSysUser(@Param("sysUser") SysUserVO sysUser);

	void resetPassword(@Param("sysUser") SysUserVO sysUser);

	SysUserVO findUserByOrgId(@Param("orgId") String orgId);

	@Select("select count(0) from u_com00.m_user where user_name=#{userName} and user_name!=(select user_name from u_com00.m_user where user_id =#{userId})")
	int validateUserNameOfUpdate(@Param("userName") String userName, @Param("userId") String userId);

	@Select("select count(0) from u_com00.m_user where user_name=#{userName}")
	int validateUserName(String userName);

}
