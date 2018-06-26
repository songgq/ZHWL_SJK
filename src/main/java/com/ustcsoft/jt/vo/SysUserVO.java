package com.ustcsoft.jt.vo;

import java.util.Date;

import com.ustcsoft.framework.vo.BaseVO;

public class SysUserVO extends BaseVO{
	private static final long serialVersionUID = 3429130096599748431L;

		// 用户Id
		private String userId;
		
		// 用户Id综合
		private Long userIdZH;
		
		// 登录名
		private String userName;
		
		// 登录名综合
		private String userNameZH;
		
		
		// 密码
		private String userPwd;
		
		// 密码
		private String userPwdWithoutMD5;
		// 姓名
		private String name;
		
		// 所属机构
		private String orgId;
		private String searchOrgId;
		public String getSearchOrgId() {
			return searchOrgId;
		}

		public void setSearchOrgId(String searchOrgId) {
			this.searchOrgId = searchOrgId;
		}

		//单位级别
		private String orgLv;
		//机构名称
		private String regName;
		//机构编码
		private String orgCode;
		//达文机关带字
		private String orgSimpleName;
		//行业类别
		private String tradeType;
		
		private String duLiZhiFa;
		
		private String government;
		
		private String manager;
		
		private String contactPerson;
		
		private String contactTel;
		
		public String getOrgLv() {
			return orgLv;
		}

		public void setOrgLv(String orgLv) {
			this.orgLv = orgLv;
		}

		public String getRegName() {
			return regName;
		}

		public void setRegName(String regName) {
			this.regName = regName;
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

		public String getGovernment() {
			return government;
		}

		public void setGovernment(String government) {
			this.government = government;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getYouBian() {
			return youBian;
		}

		public void setYouBian(String youBian) {
			this.youBian = youBian;
		}

		public String getFunc() {
			return func;
		}

		public void setFunc(String func) {
			this.func = func;
		}

		public String getJianCeZhanHao() {
			return jianCeZhanHao;
		}

		public void setJianCeZhanHao(String jianCeZhanHao) {
			this.jianCeZhanHao = jianCeZhanHao;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		private String status;
		
		private String website;
		
		private String address;
		
		private String youBian;
		
		
		private String func;
		
		private String jianCeZhanHao;
		
		private String remark;
		
		// roleType
		private String roleType;
		
		// 所属机构综合
		private String orgIdZH;
		
		// 行业name
		private String hangYe;
		//
		private String syncFlag;
		//
		private String seqStatus;
		//
		private String seq;
		//
		private String no;
		/**
		 * 证件管理-登记日期
		 */
		private String djrq;
		/**
		 * 证件管理--创建日期
		 */
		private Date createDate;
		/**
		 * 证件管理--发证状态
		 */
		private String fzzt;
		/**
		 * 证件管理--安徽省交通运输厅审批
		 */
		private String deptsp;
		/**
		 * 证件管理--证件状态
		 */
		private String zjzt;	
		
		
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
		
		// 性别
		private String sex;
		
		//身份证号码
		private String idNo;
		
		// 联系电话
		private String tel;
		
		// 邮箱
		private String email;
		
		//部门id
		private String deptId;
		
		//部门id综合
		private String deptIdZH;
		
		//
		private Boolean ifZongHeZhiFa;
		
		//部门名称
		private String deptName;
		// 删除标志
//		private String delflg;
		// 行政区划编号 zsy20130123 add
		private String regCode;
		// 父节点
		private String parentId;
		
		private String certId;
		
		private String zfrybh;
		
		//执法证号
		private String zhiFaZhengHao;
		
		//职务
		private String zhiWu;
		
		//所属科室id
		private String keShiID;

		//所属科室name
		private String keShiName;
		
		//查询方式
		private String chaXunFangShi;
		//是否是海事用户
		private String isHaiShi;
		
		//用户签章号
		private String qianZhangHao;
		
		//签章类别
		private String qianZhangLeiBie;
		
		
		/**
		 * 是否使用静态密码 1:是,0：否
		 */
	 
	    private String loginType;
	    
		
		/**
		 * 证件管理
		 * 是否与其他库同步   是：1  否：0
		 */
		private String canBeSYNC;
		private String userIdVar;
		
		

		// 所属机构名称
		private String orgName;
		
		// 所属机构名称
		private String orgNameZH;
		
		

		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public String getOrgNameZH() {
			return orgNameZH;
		}

		public void setOrgNameZH(String orgNameZH) {
			this.orgNameZH = orgNameZH;
		}

		public String getLoginType() {
			return loginType;
		}

		public void setLoginType(String loginType) {
			this.loginType = loginType;
		}

		public String getCanBeSYNC() {
			return canBeSYNC;
		}

		public void setCanBeSYNC(String canBeSYNC) {
			this.canBeSYNC = canBeSYNC;
		}

		public String getUserIdVar() {
			return userIdVar;
		}

		public void setUserIdVar(String userIdVar) {
			this.userIdVar = userIdVar;
		}

		public String getDeptName() {
			return deptName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public String getRegCode() {
			return regCode;
		}

		public void setRegCode(String regCode) {
			this.regCode = regCode;
		}

		public String getParentId() {
			return parentId;
		}

		public void setParentId(String parentId) {
			this.parentId = parentId;
		}

		public String getCertId() {
			return certId;
		}

		public void setCertId(String certId) {
			this.certId = certId;
		}

		public String getZfrybh() {
			return zfrybh;
		}

		public void setZfrybh(String zfrybh) {
			this.zfrybh = zfrybh;
		}

		public String getZhiFaZhengHao() {
			return zhiFaZhengHao;
		}

		public void setZhiFaZhengHao(String zhiFaZhengHao) {
			this.zhiFaZhengHao = zhiFaZhengHao;
		}

		public String getZhiWu() {
			return zhiWu;
		}

		public void setZhiWu(String zhiWu) {
			this.zhiWu = zhiWu;
		}

		public String getKeShiID() {
			return keShiID;
		}

		public void setKeShiID(String keShiID) {
			this.keShiID = keShiID;
		}

		public String getKeShiName() {
			return keShiName;
		}

		public void setKeShiName(String keShiName) {
			this.keShiName = keShiName;
		}

		public String getChaXunFangShi() {
			return chaXunFangShi;
		}

		public void setChaXunFangShi(String chaXunFangShi) {
			this.chaXunFangShi = chaXunFangShi;
		}

		public String getIsHaiShi() {
			return isHaiShi;
		}

		public void setIsHaiShi(String isHaiShi) {
			this.isHaiShi = isHaiShi;
		}

		public String getQianZhangHao() {
			return qianZhangHao;
		}

		public void setQianZhangHao(String qianZhangHao) {
			this.qianZhangHao = qianZhangHao;
		}

		public String getQianZhangLeiBie() {
			return qianZhangLeiBie;
		}

		public void setQianZhangLeiBie(String qianZhangLeiBie) {
			this.qianZhangLeiBie = qianZhangLeiBie;
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

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getIdNo() {
			return idNo;
		}

		public void setIdNo(String idNo) {
			this.idNo = idNo;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDeptId() {
			return deptId;
		}

		public void setDeptId(String deptId) {
			this.deptId = deptId;
		}

		public String getDeptIdZH() {
			return deptIdZH;
		}

		public void setDeptIdZH(String deptIdZH) {
			this.deptIdZH = deptIdZH;
		}

		public Boolean getIfZongHeZhiFa() {
			return ifZongHeZhiFa;
		}

		public void setIfZongHeZhiFa(Boolean ifZongHeZhiFa) {
			this.ifZongHeZhiFa = ifZongHeZhiFa;
		}

		public String getDjrq() {
			return djrq;
		}

		

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public Long getUserIdZH() {
			return userIdZH;
		}

		public void setUserIdZH(Long userIdZH) {
			this.userIdZH = userIdZH;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserNameZH() {
			return userNameZH;
		}

		public void setUserNameZH(String userNameZH) {
			this.userNameZH = userNameZH;
		}

		public String getUserPwd() {
			return userPwd;
		}

		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
		}

		public String getUserPwdWithoutMD5() {
			return userPwdWithoutMD5;
		}

		public void setUserPwdWithoutMD5(String userPwdWithoutMD5) {
			this.userPwdWithoutMD5 = userPwdWithoutMD5;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getOrgId() {
			return orgId;
		}

		public void setOrgId(String orgId) {
			this.orgId = orgId;
		}

		public String getRoleType() {
			return roleType;
		}

		public void setRoleType(String roleType) {
			this.roleType = roleType;
		}

		public String getOrgIdZH() {
			return orgIdZH;
		}

		public void setOrgIdZH(String orgIdZH) {
			this.orgIdZH = orgIdZH;
		}

		public String getHangYe() {
			return hangYe;
		}

		public void setHangYe(String hangYe) {
			this.hangYe = hangYe;
		}

		public String getSyncFlag() {
			return syncFlag;
		}

		public void setSyncFlag(String syncFlag) {
			this.syncFlag = syncFlag;
		}

		public String getSeqStatus() {
			return seqStatus;
		}

		public void setSeqStatus(String seqStatus) {
			this.seqStatus = seqStatus;
		}

		public String getSeq() {
			return seq;
		}

		public void setSeq(String seq) {
			this.seq = seq;
		}

		public String getNo() {
			return no;
		}

		public void setNo(String no) {
			this.no = no;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public String getFzzt() {
			return fzzt;
		}

		public void setFzzt(String fzzt) {
			this.fzzt = fzzt;
		}

		public String getDeptsp() {
			return deptsp;
		}

		public void setDeptsp(String deptsp) {
			this.deptsp = deptsp;
		}

		public String getZjzt() {
			return zjzt;
		}

		public void setZjzt(String zjzt) {
			this.zjzt = zjzt;
		}

		public void setDjrq(String djrq) {
			this.djrq = djrq;
		}
		

}
