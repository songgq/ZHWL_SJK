package com.ustcsoft.jt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// 不指定responsebody 返回页面VIEW
	@RequestMapping("sysMenu/sysMenuManageInit.do")
	public String sysMenuManageInit() {
		logger.info("sysMenu/sysMenuManageInit.do");
		return "system/menuManager";
	}

	@RequestMapping("sysRole/sysRoleManageInit.do")
	public String sysRoleManageInit() {
		logger.info("sysMenu/sysRoleManageInit.do");
		return "system/roleManager";
	}
	
	@RequestMapping("deptorg/initOrgManageInit.do")
	public String initOrgManageInit() {
		logger.info("deptorg/initOrgManageInit.do");
		return "system/orgManager";
	}

	@RequestMapping("deptorg/orgBusiness.do")
	public String orgBusiness() {
		logger.info("deptorg/orgBusiness.do");
		return "system/orgBusiness";
	}
	@RequestMapping("deptorg/orgArea.do")
	public String orgArea() {
		logger.info("deptorg/orgArea.do");
		return "system/orgArea";
	}
	@RequestMapping("deptorg/orgIndustry.do")
	public String orgIndustry() {
		logger.info("deptorg/orgIndustry.do");
		return "system/orgIndustry";
	}
	@RequestMapping("system/newCategoryList.do")
	public String newCategoryList() {
		logger.info("system/newCategoryList.do");
		return "system/newCategoryList";
	}
	
	@RequestMapping("system/systemCodeManagerInit.do")
	public String systemCodeManageInit() {
		logger.info("system/systemCodeManagerInit.do");
		return "system/codeAdministration";
	}

	@RequestMapping("system/documentList.do")
	public String documentList() {
		logger.info("system/documentList.do");
		return "system/documentList";
	}
	
	@RequestMapping("system/processmanager.do")
	public String processmanager() {
		logger.info("system/processmanager.do");
		return "system/processmanager";
	}
	
	@RequestMapping("sysUser/sysUserManageInit.do")
	public String sysUserManageInit() {
		logger.info("sysUser/sysUserManageInit");
		return "system/sysUserManager";
	}
	@RequestMapping("code/authTypeManageInit.do")
	public String authTypeManageInit() {
		logger.info("authItemManageInit");
		return "system/authTypeManage";
	}
	@RequestMapping("auth/authItemManage_add.do")
	public String authItemManage_add() {
		logger.info("auth/authItemManage_add.do");
		return "system/authItemManager_add";
	}

	@RequestMapping("system/systemAnnouncementManageInit.do")
	public String systemAnnouncementManageInit() {
		logger.info("system/systemAnnouncementManageInit.do");
		return "system/announcementManage";
	}
	@RequestMapping("system/viewAnnouncement.do")
	public String viewAnnouncement() {
		logger.info("system/viewAnnouncement.do");
		return "system/viewYdzfAnnouncement";
	}
	@RequestMapping("system/tableRelationInit.do")
	public String tableRelationInit() {
		logger.info("system/tableRelationInit.do");
		return "system/tableRelation";
	}	
	@RequestMapping("system/keyWordInit.do")
	public String keyWordInit() {
		logger.info("system/keyWordInit.do");
		return "system/keyWord";
	} 
	@RequestMapping("sysTemplet/sysTempletInit.do")
	public String sysTempletInit() {
		logger.info("sysTemplet/sysTempletInit.do");
		return "system/sysTempletList";
	}
	@RequestMapping("laws/legalBasisManageInit.do")
	public String legalBasisManageInit() {
		logger.info("laws/legalBasisManageInit.do");
		return "system/legalBasisManager";
	}
	@RequestMapping("legalBasis/legalBasisEditionList.do")
	public String legalBasisEditionList() {
		logger.info("legalBasis/legalBasisEditionList.do");
		return "system/legalBasisEditionList";
	}
	@RequestMapping("laws/legalBasisEditionViewInit.do")
	public String legalBasisEditionViewInit() {
		logger.info("laws/legalBasisEditionViewInit.do");
		return "system/legalBasisEditionViewForm";
	}
	@RequestMapping("auth/authItemManage_update.do")
	public String authItemManage_update() {
		logger.info("auth/authItemManage_update.do");
		return "system/authItemManager_update";
	}
	@RequestMapping("authItem/authLegal.do")
	public String authLegal() {
		logger.info("authItem/authLegal.do");
		return "system/authLegal";
	}
	
	
	@RequestMapping("auth/authItemManageInit.do")
	public String authItemManageInit() {
		logger.info("auth/authItemManageInit");
		return "system/authItemManager";
	}
	@RequestMapping("system/asistDocument.do")
	public String asistDocument() {
		logger.info("system/asistDocument.do");
		return "system/asistDocument";
	}
	@RequestMapping("auth/authItemConfigInit.do")
	public String authItemConfigInit() {
		logger.info("auth/authItemConfigInit.do");
		return "system/authItemConfig";
	}
	@RequestMapping("auth/unitAuthItemManageInit.do")
	public String unitAuthItemManageInit() {
		logger.info("auth/unitAuthItemManageInit.do");
		return "system/unitAuthItemManage";
	}
	@RequestMapping("auth/unitAuthItemManage_add.do")
	public String unitAuthItemManage_add() {
		logger.info("auth/unitAuthItemManage_add.do");
		return "system/unitAuthItemManage_add";
	}
	@RequestMapping("auth/unitAuthItemManage_update.do")
	public String unitAuthItemManage_update() {
		logger.info("auth/unitAuthItemManage_update.do");
		return "system/unitAuthItemManage_update";
	}
	@RequestMapping("authItem/unitAuthLegal.do")
	public String unitAuthLegal() {
		logger.info("authItem/unitAuthLegal.do");
		return "system/unitAuthLegal";
	}
	@RequestMapping("laws/lawsManageInit.do")
	public String lawsManageInit() {
		logger.info("laws/lawsManageInit.do");
		return "system/lawsManage";
	}
	
}
