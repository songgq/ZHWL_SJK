package com.ustcsoft.jt.controller;

import com.ustcsoft.framework.vo.BaseVO;
import com.ustcsoft.jt.cache.CacheManagerUtil;
import com.ustcsoft.jt.constant.Constant;
import com.ustcsoft.jt.vo.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.vo.User;

import java.sql.Timestamp;
import java.util.Date;

public abstract class AbstractRestController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected UserVO getCurrentUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUserVo();
	}

	/**
	 * 从缓存中获取当前登录用户信息
	 * @param tokenId
	 * @return
	 */
	protected AppUser getCurrentAppUser(String tokenId) {
		return (AppUser) CacheManagerUtil.get(Constant.USERTOKENCACH, tokenId);

	}

	/**
	 * 设置创建人，创建时间等基本信息
	 */
	protected void createEntity(BaseVO baseVO, String tokenId) {
		baseVO.setCreater(getCurrentAppUser(tokenId).getId());
		baseVO.setCreateTime(new Timestamp(new Date().getTime()));
		baseVO.setUpdater(getCurrentAppUser(tokenId).getId());
		baseVO.setUpdateTime(new Timestamp(new Date().getTime()));
	}
	/**
	 * 设置更新人，更新时间
	 */
	protected void updateEntity(BaseVO baseVO, String tokenId) {
		baseVO.setUpdater(getCurrentAppUser(tokenId).getId());
		baseVO.setUpdateTime(new Timestamp(new Date().getTime()));
	}
}
