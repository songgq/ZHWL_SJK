package com.ustcsoft.jt.mapper;

import com.ustcsoft.jt.vo.DrugManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugManageDetailMapper {
    Integer batchAddDetail(@Param(value = "list") List<DrugManage> list, @Param(value = "orgCode") String orgCode, @Param(value = "entCode") String entCode);

}