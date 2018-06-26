package com.ustcsoft.jt.mapper;

import com.ustcsoft.jt.vo.Aeration;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AerationMapper {

    Integer batchAdd(@Param(value = "list") List<Aeration> list, @Param(value = "orgCode") String orgCode, @Param(value = "entCode") String entCode);

}