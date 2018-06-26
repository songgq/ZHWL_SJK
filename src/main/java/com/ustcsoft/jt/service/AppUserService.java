package com.ustcsoft.jt.service;

import com.ustcsoft.jt.vo.AppUser;
import com.ustcsoft.jt.mybatis.Page;

/**
* Created by mapp on 2018-3-28 12:28:54.
*/
public interface AppUserService {

    Page<AppUser> queryPage(AppUser appUser, int page, int rows);
}