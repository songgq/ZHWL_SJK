package com.ustcsoft.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.vo.SysOrgVO;

public interface SysOrgMapper {

	List<SysOrgVO> searchOrgTree(@Param("searchId") String searchId);

	List<SysOrgVO> searchOrgListPage(@Param("org") SysOrgVO org, @Param("page") Page<SysOrgVO> page);

	@Select("select * from u_com00.M_org where parent_id = #{orgId}")
	List<SysOrgVO> findAllOrgInfo(String id);

	@Select("select * from u_com00.M_org where ORG_NAME = #{orgName}")
	List<SysOrgVO> queryByName(String orgName);

	String findBusinessId(@Param("orgBusiness") String orgBusiness);

	String findMaxId(@Param("searchId") String searchId);

	void addOrgInfo(@Param("org") SysOrgVO org);

	void updateOrg(@Param("org") SysOrgVO org);

	void deleteOrg(@Param("businessId") String businessId);

	String findReCode(@Param("regName") String regName);

	List<SysOrgVO> searchOrgBankList(@Param("org") SysOrgVO org, @Param("page") Page<SysOrgVO> page);

	void addBank(@Param("org") SysOrgVO org);

	void delBank(@Param("org") SysOrgVO org);

	String findMaxOrgId();

	List<SysOrgVO> searchOrgTreePeizhi(@Param("org") SysOrgVO org);

	void setPeizhi(@Param("org") SysOrgVO org);

	String findSelfOrgId(@Param("areaId") String areaId);

	void delPeizhi(@Param("areaId") String areaId);

	List<SysOrgVO> searchOrgTreePeizhiIndustry(@Param("org") SysOrgVO org);

	void setPeizhiIndustry(@Param("org") SysOrgVO org);

	void delPeizhiIndustry(@Param("industryId") String industryId);

	String searBusinessId(@Param("orgId") String orgId);

	String searAreaId(@Param("orgId") String orgId);

	String searIndustryId(@Param("orgId") String orgId);

	@Select("select * from u_com00.M_ORG where org_id = #{orgId}")
	SysOrgVO selectByOrgId(@Param("orgId") String orgId);

	SysOrgVO searchOrg(@Param("org") SysOrgVO org);

	String seachOrgBusinessByBusinessId(@Param("searchId") String searchId);

	@Select("select ORG_ID from  u_com00.M_ORG where industry_Id =#{industryId}")
	String findSelfOrgIdByIndustryId(@Param("industryId") String industryId);

	@Select("select BUSINESS_ID from  u_com00.M_ORG where ORG_ID =#{orgId}")
	String findBusinessIdByOrgId(@Param("orgId") String orgId);

	@Select("select count(0) from  u_com00.M_ORG where org_name =#{orgName}")
	int validataOrgName(@Param("orgName") String orgName);

	@Select("select count(0) from  u_com00.M_ORG where org_name =#{orgName} and org_name!=(select org_name from u_com00.M_ORG where org_id=#{orgId})")
	int validataOrgNameOfUpdate(@Param("orgName") String orgName, @Param("orgId") String orgId);

	@Select("select MANAGER_ID from  u_com00.M_ORG where ORG_ID =#{orgId}")
	String searManagerId(@Param("orgId") String orgId);

	@Select("select  max(O.MANAGER_ID)  FROM  u_com00.M_ORG O 	where  O.MANAGER_ID like '${managerId}%'")
	String findMaxManageId(@Param("managerId") String managerId);

	@Select("select org_name from  u_com00.M_ORG where manager_id=#{searchManagerId}")
	String seachManagerByManagerId(@Param("searchManagerId") String searchManagerId);

	@Select("select org_id from u_com00.m_org where business_id=#{businessId}")
	String findOrgIdByBusinessId(@Param("businessId") String businessId);

	List<SysOrgVO> getOrgByAreaId(String areaId);

	List<SysOrgVO> getCityOrgs();

	/** 获取附近粮食局 */
	List<SysOrgVO> getNearOrgs();
}
