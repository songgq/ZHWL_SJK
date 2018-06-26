package com.ustcsoft.framework.vo;

import java.util.Date;

public class UserVO extends BaseVO {

	private static final long serialVersionUID = -205074496010322966L;
	
	// 性别
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	// 用户Id
	private Long userId;

	// 登录名
	private String userName;

	// 密码
	private String userPwd;

	// 姓名
	private String name;

	// 登录状态
	private String loginStatus;

	// 密码错误次数
	private String pwdWrongNum;

	// 登录次数
	private String loginNum;

	// 上次登录IP
	private String loginIp;

	// 上次登录时间
	private Date loginTime;

	// 所属机构
	private String orgId;

	// 所属机构名称
	private String orgName;
	// 机构简称
	private String orgSimpleName;
	// 机构编号
	private String bmbh;

	// 所在部门ID
	private String deptId;
	// 所在部门名称
	private String deptName;
	// 执法人员编号 zhangye20121205 追加
	private String zfrybh;
	// 行政区划编号 zsy20130123 add
	private String regCode;
	// 实施主体编号
	private String ssztbh1;
	private String ssztbh2;
	// 地址
	private String diZhi;
	// 组织机构联系电话
	private String orgLxdh;
	// 执法证号
	private String zfzh;
	// 联系人
	private String contactPerson;
	// 人民政府
	private String popGoverment;
	// 上级
	private String superName;
	// 网址
	private String website;
	// email
	private String email;
	private String orgLv;
	private String hangYeId;
	private String duLiZhiFa;
	// 组织机构代码
	private String orgCode;
	private String tel;
	private String shenFenZhengHao;

	public String getShenFenZhengHao() {
		return shenFenZhengHao;
	}

	public void setShenFenZhengHao(String shenFenZhengHao) {
		this.shenFenZhengHao = shenFenZhengHao;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 是否打印公章 01:no,00：yes
	 */

	private String isPrintGongZhang;

	/**
	 * 是否使用静态密码 1:是,0：否
	 */

	private String loginType;

	/**
	 * @return isPrintGongZhang
	 */
	public String getIsPrintGongZhang() {
		return isPrintGongZhang;
	}

	/**
	 * @param isPrintGongZhang
	 *            要设置的 isPrintGongZhang
	 */
	public void setIsPrintGongZhang(String isPrintGongZhang) {
		this.isPrintGongZhang = isPrintGongZhang;
	}

	public String getDuLiZhiFa() {
		return duLiZhiFa;
	}

	public void setDuLiZhiFa(String duLiZhiFa) {
		this.duLiZhiFa = duLiZhiFa;
	}

	public String getHangYeId() {
		return hangYeId;
	}

	public void setHangYeId(String hangYeId) {
		this.hangYeId = hangYeId;
	}

	/**
	 * 状态
	 */
	private String status;
	// 2013-06-25 修改
	/**
	 * 删除标识
	 * 
	 * @return
	 */
	private String shanChuBianZhi;
	/**
	 * 证件状态
	 * 
	 * @return
	 */
	private String zhengJianZhuangTai;

	/**
	 * 牌子类别
	 */
	private String deptType;

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getShanChuBianZhi() {
		return shanChuBianZhi;
	}

	public void setShanChuBianZhi(String shanChuBianZhi) {
		this.shanChuBianZhi = shanChuBianZhi;
	}

	public String getZhengJianZhuangTai() {
		return zhengJianZhuangTai;
	}

	public void setZhengJianZhuangTai(String zhengJianZhuangTai) {
		this.zhengJianZhuangTai = zhengJianZhuangTai;
	}

	public String getDiZhi() {
		return diZhi;
	}

	public void setDiZhi(String diZhi) {
		this.diZhi = diZhi;
	}

	public String getOrgLxdh() {
		return orgLxdh;
	}

	public void setOrgLxdh(String orgLxdh) {
		this.orgLxdh = orgLxdh;
	}

	public String getZfzh() {
		return zfzh;
	}

	public void setZfzh(String zfzh) {
		this.zfzh = zfzh;
	}

	public String getSsztbh1() {
		return ssztbh1;
	}

	public void setSsztbh1(String ssztbh1) {
		this.ssztbh1 = ssztbh1;
	}

	public String getSsztbh2() {
		return ssztbh2;
	}

	public void setSsztbh2(String ssztbh2) {
		this.ssztbh2 = ssztbh2;
	}

	/**
	 * 行政区划名称
	 */
	private String xingZhengQuHuaMingCheng;
	// 行政区划id
	private String xingZhengQuHuaId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getPwdWrongNum() {
		return pwdWrongNum;
	}

	public void setPwdWrongNum(String pwdWrongNum) {
		this.pwdWrongNum = pwdWrongNum;
	}

	public String getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName
	 *            the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getOrgSimpleName() {
		return orgSimpleName;
	}

	public void setOrgSimpleName(String orgSimpleName) {
		this.orgSimpleName = orgSimpleName;
	}

	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	public String getZfrybh() {
		return zfrybh;
	}

	public void setZfrybh(String zfrybh) {
		this.zfrybh = zfrybh;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getXingZhengQuHuaMingCheng() {
		return xingZhengQuHuaMingCheng;
	}

	public void setXingZhengQuHuaMingCheng(String xingZhengQuHuaMingCheng) {
		this.xingZhengQuHuaMingCheng = xingZhengQuHuaMingCheng;
	}

	public String getOrgLv() {
		return orgLv;
	}

	public void setOrgLv(String orgLv) {
		this.orgLv = orgLv;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPopGoverment() {
		return popGoverment;
	}

	public void setPopGoverment(String popGoverment) {
		this.popGoverment = popGoverment;
	}

	public String getSuperName() {
		return superName;
	}

	public void setSuperName(String superName) {
		this.superName = superName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getXingZhengQuHuaId() {
		return xingZhengQuHuaId;
	}

	public void setXingZhengQuHuaId(String xingZhengQuHuaId) {
		this.xingZhengQuHuaId = xingZhengQuHuaId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
