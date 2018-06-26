package com.ustcsoft.jt.service.impl;

import com.ustcsoft.jt.vo.AppUser;
import com.ustcsoft.jt.mapper.AppUserMapper;
import com.ustcsoft.jt.mybatis.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ustcsoft.jt.service.AppUserService;

/**
* Created by mapp on 2018-3-28 12:28:54.
*/
@Service
public class AppUserServiceImpl implements AppUserService{

    @Resource
    private AppUserMapper appUserMapper;

    @Override
    public Page<AppUser> queryPage(AppUser appUser, int page, int rows) {
        Page<AppUser> pageVO = Page.buildPageRequest(page, rows);
        List<AppUser> list = null;
        list = appUserMapper.queryPage(appUser, pageVO);
        pageVO.setItems(list);
        return pageVO;
    }
}