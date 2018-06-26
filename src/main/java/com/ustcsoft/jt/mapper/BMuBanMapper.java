package com.ustcsoft.jt.mapper;


import com.ustcsoft.jt.vo.BMuBan;
import com.ustcsoft.jt.vo.BZhiBiao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.ustcsoft.jt.mybatis.Page;
import org.apache.ibatis.annotations.Update;


public interface BMuBanMapper {

    /** 分页查询 */
    List<BMuBan> queryPage(@Param("bMuBan")BMuBan bMuBan, @Param("page") Page<BMuBan> page);

    /** 新增 */
    Long insert(BMuBan bMuBan);

    /** 修改 */
    int update(@Param("bMuBan") BMuBan bMuBan);

    void insertMuBanAndZhiBiao(List<Map<String, String>> zhiBiaoIds);

    List<BZhiBiao> getMuBanAndZhiBiao(String muBanId);

    void deleteMuBan(String muBanid);

    void deleteMuBanZHiBiaos(String muBanId);

    /**
     * 这个删除 用于更新模板指标时， 删除该模板之前的指标。
     * 系统模板指标关系表只保存一个版本的模板指标关系
     * @param muBanId
     */
    @Delete("delete from b_muban_zhibiao where muban_id = #{muBanId} ")
    void deleteZhiBiaos(String muBanId);

    @Update("UPDATE b_mu_ban set status = '1' WHERE id = #{muBanId}")
    void releaseMuBan(String muBanId);
}
