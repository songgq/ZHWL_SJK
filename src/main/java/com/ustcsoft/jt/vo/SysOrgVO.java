package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;


/**
 * 组织结构VO
 * @author lc
 *
 */
public class SysOrgVO extends BaseVO {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 组织机构ID
	 */
	private String orgId;
	private String searchId;
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	private String parentId;
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 机构名称
	 */
	private String orgName;
	/**
	 * 案件起始编号
	 */
	private String caseNumber;
	/**
	 * 机构编码
	 */
	private String orgCode;
	/**
	 * 机构简称(发文机关带字)
	 */
	private String orgSimpleName;
	/**
	 * 机构说明
	 */
	private String remark;
	/**
	 * 负责人
	 */
	private String manager;
	/**
	 * 联系人
	 */
	private String contactPerson;
	/**
	 * 联系电话
	 */
	private String contactTel;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 单位编号
	 */
	private String bmbh;
	/**
	 * 行业类别
	 */
	private String tradeType;
	/**
	 * 是否独立执法主体
	 */
	private String duLiZhiFa;
	/**
	 * 机构职能
	 */
	private String func;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 网址
	 */
	private String website;
	/**
	 * 单位状态
	 */
	private String status;
	/**
	 * 单位级别
	 */
	private String orgLv;
	/**
	 * 行政区域代码
	 */
	private String regCode;
	/**行政区域名称*/
	private String regName;
	/**
	 * 检测站号
	 */
	private String jianCeZhanHao;
	/**
	 * 是否显示县机构，0：不显示，1：显示
	 */
//	private String viewCounty = "1";
	
	private Integer paiXu;
	
	/**
	 * 新增  实施主体编号
	 * @return
	 */
	private String bh;
	
	/**
	 * 新增处罚
	 * @return
	 */
	private String chufa;
	/**
	 * 新增许可
	 * @return
	 */
	private String xuke;
	
	/**
	 * 新增职权种类ID
	 * @return
	 */
	private String authTypeId;
	/**
	 * 新增发文机关带字
	 * @return
	 */
	private String faWenJiGuanDaiZi;

	
	public String getAuthTypeId() {
		return authTypeId;
	}
	public void setAuthTypeId(String authTypeId) {
		this.authTypeId = authTypeId;
	}
	public String getFaWenJiGuanDaiZi() {
		return faWenJiGuanDaiZi;
	}
	public void setFaWenJiGuanDaiZi(String faWenJiGuanDaiZi) {
		this.faWenJiGuanDaiZi = faWenJiGuanDaiZi;
	}
	public String getChufa() {
		return chufa;
	}
	public void setChufa(String chufa) {
		this.chufa = chufa;
	}
	public String getXuke() {
		return xuke;
	}
	public void setXuke(String xuke) {
		this.xuke = xuke;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * 对应人民政府
	 */
	private String government;
	public String getXiangMuId() {
		return xiangMuId;
	}
	public void setXiangMuId(String xiangMuId) {
		this.xiangMuId = xiangMuId;
	}
	/**执法评议_组织 项目ID*/
	private String xiangMuId;
	/**执法评议_组织 执法人员编号*/
	private String zfrybh;
	/**
	 * 执法评议_组织执法人员id数组
	 */
	private String[] zfrybhArray;
	/**
	 * 执法评议_组织执法人员id数组
	 */
	private String[] orgIdArray;
	
	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 账号
	 */
	private String accountNumber;
	/**
	 * 账号ID
	 */
	private String accountId;
	
	/**邮编*/
	private String youBian;
	
	private String roleType;
	
	/**
	  *行业id 
	  */
	 private String hangYeId;

	/** 机构介绍 */
	private String jieShao;

	/** 区域范围 */
	private String qyfw;

	/** 图片路径 */
	private String tuPian;

	/** 经度 */
	private String lng;

	/** 维度 */
	private String lat;

	private String diZhi;

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getDiZhi() {
		return diZhi;
	}

	public void setDiZhi(String diZhi) {
		this.diZhi = diZhi;
	}

	public String getTuPian() {
		return tuPian;
	}

	public void setTuPian(String tuPian) {
		this.tuPian = tuPian;
	}

	public String getQyfw() {
		return qyfw;
	}

	public void setQyfw(String qyfw) {
		this.qyfw = qyfw;
	}

	public String getJieShao() {
		return jieShao;
	}

	public void setJieShao(String jieShao) {
		this.jieShao = jieShao;
	}

	public String getHangYeId() {
		return hangYeId;
	}
	public void setHangYeId(String hangYeId) {
		this.hangYeId = hangYeId;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String[] getOrgIdArray() {
		return orgIdArray;
	}
	public void setOrgIdArray(String[] orgIdArray) {
		this.orgIdArray = orgIdArray;
	}
	public String[] getZfrybhArray() {
		return zfrybhArray;
	}
	public void setZfrybhArray(String[] zfrybhArray) {
		this.zfrybhArray = zfrybhArray;
	}
	public String getZfrybh() {
		return zfrybh;
	}
	public void setZfrybh(String zfrybh) {
		this.zfrybh = zfrybh;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgSimpleName() {
		return orgSimpleName;
	}
	public void setOrgSimpleName(String orgSimpleName) {
		this.orgSimpleName = orgSimpleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrgLv() {
		return orgLv;
	}
	public void setOrgLv(String orgLv) {
		this.orgLv = orgLv;
	}
	public String getRegCode() {
		return regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBmbh() {
		return bmbh;
	}
	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getGovernment() {
		return government;
	}
	public void setGovernment(String government) {
		this.government = government;
	}
//	public String getViewCounty() {
//		return viewCounty;
//	}
//	public void setViewCounty(String viewCounty) {
//		this.viewCounty = viewCounty;
//	}
	public String getYouBian() {
		return youBian;
	}
	public void setYouBian(String youBian) {
		this.youBian = youBian;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getDuLiZhiFa() {
		return duLiZhiFa;
	}
	public void setDuLiZhiFa(String duLiZhiFa) {
		this.duLiZhiFa = duLiZhiFa;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getJianCeZhanHao() {
		return jianCeZhanHao;
	}
	public void setJianCeZhanHao(String jianCeZhanHao) {
		this.jianCeZhanHao = jianCeZhanHao;
	}
	public Integer getPaiXu() {
		return paiXu;
	}
	public void setPaiXu(Integer paiXu) {
		this.paiXu = paiXu;
	}
	
}