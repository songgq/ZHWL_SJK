package com.ustcsoft.jt.mapper;

import com.ustcsoft.framework.vo.UserVO;

public interface UserMapper {

	UserVO loadUserByUsername(String username);
}
