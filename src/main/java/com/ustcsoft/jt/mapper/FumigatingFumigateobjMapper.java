package com.ustcsoft.jt.mapper;

import com.ustcsoft.jt.vo.Fumigating;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FumigatingFumigateobjMapper {
    Integer batchAddFumigateobj(@Param(value = "list") List<Fumigating> list, @Param(value = "orgCode") String orgCode, @Param(value = "entCode") String entCode);

}