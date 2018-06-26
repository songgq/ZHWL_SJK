package com.ustcsoft.jt.mapper;

import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.vo.Aeration;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ShengjkMapper {
    @Select("SELECT * FROM u_com00.m_cc_qyxx t")
    List<Map> getQyxxPage(@Param("page") Page<Map> page);

    @Select("SELECT\n" +
            "\tIFNULL(qymc, \"\") AS qymc,\n" +
            "\tIFNULL(qydm, \"\") AS qydm,\n" +
            "\t'10' AS qylx,\n" +
            "\tIFNULL(qyxzbh, \"\") AS qyxz,\n" +
            "\tIFNULL(address, \"\") AS yydz,\n" +
            "\t'' AS lsgx,\n" +
            "\tIFNULL(zcsj, \"\") AS zcsj,\n" +
            "\tIFNULL(zczb, 0) AS zczb,\n" +
            "\t0 AS zcze,\n" +
            "\tIFNULL(yzbm, \"\") AS yzbm,\n" +
            "\tIFNULL(frdb, \"\") AS fddbr,\n" +
            "\t\"\" AS sfzh,\n" +
            "\tIFNULL(phoneno, \"\") AS frsjh,\n" +
            "\tIFNULL(qyfzr, \"\") AS qylxr,\n" +
            "\tIFNULL(tel, \"\") AS bgdh,\n" +
            "\t\"\" AS qylxrdh,\n" +
            "\t0 AS njgl,\n" +
            "\t\"\" AS zyjgpz,\n" +
            "\t0 AS njyl,\n" +
            "\tIFNULL(jyfw, \"\") AS zyjypz,\n" +
            "\t0 AS nsgl,\n" +
            "\t\"\" AS zysgpz,\n" +
            "\t\"\" AS sgxkz,\n" +
            "IF (is_emergency = 'Y', '1', '0') AS sflryjtx,\n" +
            " 0 AS zyzj,\n" +
            " 0 AS ccrl,\n" +
            " 0 AS jd,\n" +
            " 0 AS wd,\n" +
            "\"\" AS bgrymd,\n" +
            "\"\" AS yzrymd,\n" +
            "\"\" AS jysbmc,\n" +
            "\"\" AS jlsbmc,\n" +
            "\"\" AS babh,\n" +
            "\"\" AS barq,\n" +
            "IF (\n" +
            "\tis_valid = 'Y'\n" +
            "\tOR is_valid = '1',\n" +
            "\t'0',\n" +
            "\t'1'\n" +
            ") AS sfsc\n" +
            "FROM\n" +
            "\tu_com00.m_cc_qyxx t where t.update_date BETWEEN #{startTime} and #{endTime}")
    List<Map> getUpQyxx(@Param("startTime")String startTime,@Param("endTime")String endTime);


    @Select("SELECT IFNULL(qymc, \"\") AS qymc,IFNULL(qydm, \"\") AS qydm,10 AS qylx,IFNULL(qyxzbh, \"\") AS qyxzbh," +
            "IFNULL(address, \"\") AS yydz,IFNULL(lsgx, \"\") AS lsgx,IFNULL(zcsj, \"\") AS zcsj,IFNULL(zczb, \"\") AS zczb," +
            "0 AS zcze,IFNULL(yzbm, \"\") AS yzbm,IFNULL(frdb, \"\") AS fddbr,\"\" AS sfzh,IFNULL(phoneno, \"\") AS frsjh," +
            "IFNULL(qyfzr, \"\") AS qylxr,IFNULL(tel, \"\") AS bgdh,\"\" AS qylxrdh,0 AS njgl,\"\" AS zyjgpz,0 AS njyl," +
            "IFNULL(jyfw, \"\") AS zyjypz,0 AS nsgl,\"\" AS zysgpz,\"\" AS sgxkz,IF (is_emergency = 'Y', 1, 0) AS sflryjtx," +
            "0 AS zyzj,0 AS ccrl,0 AS jd,0 AS wd,IF (is_valid = 'Y'OR is_valid = '1','0','1') AS sfsc " +
            "FROM u_com00.m_cc_qyxx t where t.update_date BETWEEN #{startTime} and #{endTime} ")
    List<Map> getUpCcdw(@Param("startTime")String startTime,@Param("endTime")String endTime);

    @Select("SELECT\n" +
            "\tCONCAT(\n" +
            "\t\tq.qydm,\n" +
            "\t\tt.graindepot_gb_code,\n" +
            "\t\ts.storehouse_gb_code,\n" +
            "\t\tt.warehouse_gb_code\n" +
            "\t) AS ajbh,\n" +
            "\tifnull(t.warehouse_name, '') AS ajmc,\n" +
            "\tifnull(CONCAT(\n" +
            "\t\tq.qydm,\n" +
            "\t\tt.graindepot_gb_code,\n" +
            "\t\ts.storehouse_gb_code\n" +
            "\t), '') AS cfbh,\n" +
            "\tifnull(s.storehouse_name, '') AS cfmc,\n" +
            "\tifnull(t.length, 0) AS ajcd,\n" +
            "\tifnull(t.width, 0) AS ajkd,\n" +
            "\tifnull(t.height, 0) AS ajgd,\n" +
            "\tifnull(t.actual_capacity, 0) AS ajsjcr,\n" +
            "\tifnull(t.actual_capacity, 0) AS ajsjrl,\n" +
            "\t'' AS ajlxdh,\n" +
            "\t'' AS ajqyrq,\n" +
            "\t'1' AS qjzt,\n" +
            "\tifnull(t.remark, '') AS bz,\n" +
            "\t'0' AS sfsc\n" +
            "FROM\n" +
            "\tu_com00.tb_warehouse t\n" +
            "LEFT JOIN u_com00.m_cc_qyxx q ON t.enterprise_id = q.idx\n" +
            "LEFT JOIN u_com00.tb_storehouse s ON s.id = t.storehouse_id\n" +
            "where t.update_date BETWEEN #{startTime} and #{endTime}")
    List<Map> getUpAjxx(@Param("startTime")String startTime,@Param("endTime")String endTime);

    @Select("SELECT\n" +
            "\tifnull(\n" +
            "\t\tCONCAT(\n" +
            "\t\t\tqy.qydm,\n" +
            "\t\t\tt2.graindepot_gb_code,\n" +
            "\t\t\tt1.storehouse_gb_code\n" +
            "\t\t),\n" +
            "\t\t''\n" +
            "\t) AS cfbh,\n" +
            "\tt1.storehouse_name cfmc,\n" +
            "\tifnull(\n" +
            "\t\tCONCAT(\n" +
            "\t\t\tqy.qydm,\n" +
            "\t\t\tt2.graindepot_gb_code\n" +
            "\t\t),\n" +
            "\t\t''\n" +
            "\t) kqbh,\n" +
            "\tlpad(t1.storehouse_type, 7, '0') cflxnm,\n" +
            "\t'' cflxmc,\n" +
            "\t'2018-01-01' jfsyrq,\n" +
            "\tifnull(t1.wall,'99') qtjg,\n" +
            "\tifnull(t1.roof,'99')  fdjg,\n" +
            "\t'99' fjjg,\n" +
            "\tifnull(t1.ground,'99')  dmjg,\n" +
            "\tt1.design_capacity sjcr,\n" +
            "\tt1.actual_capacity sjcrong,\n" +
            "\t0 cwc,\n" +
            "\t0 cwk,\n" +
            "\t0 cwyg,\n" +
            "\t0 cwdg,\n" +
            "\t0 cwtcwj,\n" +
            "\tifnull(t1.length,0)  cnc,\n" +
            "\tifnull(t1.width,0) cnk,\n" +
            "\tifnull(t1.height,0) cnyg,\n" +
            "\tifnull(t1.lade_line_height,0) cnzlxg,\n" +
            "\t0 sjzlxg,\n" +
            "\t0 cntcnj,\n" +
            "\t0 cntj,\n" +
            "\t0 ldtj,\n" +
            "\t1 cmsl,\n" +
            "\t'' cmwz,\n" +
            "\t0 cmgd,\n" +
            "\t0 cmkd,\n" +
            "\t'1' cfsfwh,\n" +
            "\t'0' nfgrbw,\n" +
            "\t'0' nfszcc,\n" +
            "\t'0' ywfsfqfczz,\n" +
            "\t'0' ywfhfbfdss,\n" +
            "\t'0' ywlqjcss,\n" +
            "\t'0' ywjxtfss,\n" +
            "\t'0' nfhlxzsc,\n" +
            "\t'0' nffddyqtcl,\n" +
            "\t'0' nfcwcc,\n" +
            "\t1 ajs,\n" +
            "\t'1' lyqk,\n" +
            "\tCONCAT('0',t1.use_type) cfsyqk,\n" +
            "\tCONCAT(cast(t1.storehouse_state as signed),'') cfzt,\n" +
            "\t'0' sfsc\n" +
            "\t\n" +
            "FROM\n" +
            "\tu_com00.tb_storehouse t1\n" +
            "LEFT JOIN u_com00.TB_GrainDepot t2 ON t1.graindepot_id = t2.id\n" +
            "LEFT JOIN u_com00.m_cc_qyxx qy ON t1.enterprise_id = qy.idx\n" +
            "\n" +
            "WHERE  t1.update_date BETWEEN #{startTime} and #{endTime};")
    List<Map> getUpCfxx(@Param("startTime")String startTime,@Param("endTime")String endTime);


    @Select("SELECT\n" +
            "\tCONCAT(\n" +
            "\t\tq.qydm,\n" +
            "\t\ts.graindepot_gb_code,\n" +
            "\t\ts.storehouse_gb_code,\n" +
            "\t\tw.warehouse_gb_code,\n" +
            "\t\tt.grainallocation_code,\n" +
            "\t\t'2016' \n" +
            "\t) AS hwbh,\n" +
            "\tifnull(t.grainallocation_name, '') AS hwmc,\n" +
            "\tifnull(\n" +
            "\t\tCONCAT(\n" +
            "\t\t\tq.qydm,\n" +
            "\t\t\ts.graindepot_gb_code,\n" +
            "\t\t\ts.storehouse_gb_code,\n" +
            "\t\t\tw.warehouse_gb_code\n" +
            "\t\t),\n" +
            "\t\t''\n" +
            "\t) AS ajbh,\n" +
            "\tifnull(w.warehouse_name, '') AS ajmc,\n" +
            "\tifnull(\n" +
            "\t\tCONCAT(\n" +
            "\t\t\tq.qydm,\n" +
            "\t\t\ts.graindepot_gb_code,\n" +
            "\t\t\ts.storehouse_gb_code\n" +
            "\t\t),\n" +
            "\t\t''\n" +
            "\t) AS cfbh,\n" +
            "\tifnull(s.storehouse_name, '') AS cfmc,\n" +
            "\t'2017-01-01' AS hwqyrq,\n" +
            "\t'3' AS hwzt,\n" +
            "\t'1' AS clfs,\n" +
            "\tifnull(w.actual_capacity, 2000.000) AS hwrl,\n" +
            "\t'' AS bgy,\n" +
            "\t'' AS shr,\n" +
            "\tifnull(t.remark, '') AS bz,\n" +
            "\t'0' AS sfsc\n" +
            "FROM\n" +
            "\tu_com00.tb_grainallocation t\n" +
            "LEFT JOIN u_com00.tb_warehouse w ON t.warehouse_id = w.id \n" +
            "LEFT JOIN u_com00.tb_storehouse s ON w.storehouse_id = s.id\n" +
            "\n" +
            "LEFT JOIN u_com00.m_cc_qyxx q ON s.enterprise_id = q.idx " +
            "where s.id is not null and s.id<>'' and t.update_date BETWEEN #{startTime} and #{endTime} and t.create_date='2018-06-06 15:01:59'")
    List<Map> getUpHwxx(@Param("startTime")String startTime,@Param("endTime")String endTime);//TODO 去掉测试用的 where id

    @Select("SELECT \n" +
            "CONCAT(g.enterprise_code,'000000000',g.graindepot_gb_code,g.storehouse_gb_code,g.warehouse_gb_code,g.grainallocation_code,'2016',right(g.id,6)) as bm,\n" +
            "ifnull(g.grain_situation_gather_time,'1900-01-01 00:00:00') as jcsj,\n" +
            "ifnull(grain_outside_temperature,0) as cfww,\n" +
            "ifnull(grain_outside_humidity,0) as cfws,\n" +
            "ifnull(grain_inside_temperature,0) as cfnw,\n" +
            "ifnull(grain_inside_humidity,0) as cfns,\n" +
            "id as lswdzjh,\n" +
            "\"\" as lssdzjh,\n" +
            "\"\" as lssfzjh,\n" +
            "\"\" as lhqzjh,\n" +
            "\"\" as yqzjh,\n" +
            "\"\" as eyhtzjh,\n" +
            "\"\" as hcmd,\n" +
            "0 as zb1,\n" +
            "0 as zb2,\n" +
            "0 as zb3,\n" +
            "0 as jd,\n" +
            "0 as wlzb1,\n" +
            "0 as wlzb2,\n" +
            "0 as wlzb3,\n" +
            "\"\" as cwdbh,\n" +
            "\"\" as csdbh,\n" +
            "\"\" as csfdbh,\n" +
            "\"\" as ccdbh,\n" +
            "\"\" as clhqdbh,\n" +
            "\"\" as cyqdbh,\n" +
            "\"\" as ceyhtdbh,\n" +
            "\"0\" as sfsc\n" +
            "from u_02_ccyw.grainsituationrecord g\n" +
            "where g.grainallocation_code is not null and g.upload_time BETWEEN #{startTime} and #{endTime} limit 10")
    List<Map> getUpLqjcxx(@Param("startTime")String startTime,@Param("endTime")String endTime);//TODO 去掉测试用的 where id

    @Select("SELECT \n" +
            "t.id,g.id,CONVERT(t.x_coordinate/5,SIGNED) x,CONVERT(t.y_coordinate/5,SIGNED) y,f.temperature_surface_number z,CONVERT(t.temperature_value*10,SIGNED) val\n" +
            "from u_02_ccyw.temperature t\n" +
            "LEFT JOIN u_02_ccyw.grainsituationrecord g on t.gsr_id=g.id\n" +
            "LEFT JOIN u_02_ccyw.temperaturesurface f on t.t_surface_id=f.id\n" +
            "where g.id=#{gId}\n" +
            "ORDER BY z,x,y")
    List<Map> getUpLqjcxxPoint(@Param("gId")String gId);


    @Select("SELECT \n" +
            "CONCAT(g.enterprise_code,'000000000',g.graindepot_gb_code,g.storehouse_gb_code,g.warehouse_gb_code,g.grainallocation_code,'2016',right(g.id,6)) as bm,\n" +
            "ifnull(g.grain_situation_gather_time,'1900-01-01 00:00:00') as jcsj,\n" +
            "ifnull(grain_outside_temperature,0) as cfww,\n" +
            "ifnull(grain_outside_humidity,0) as cfws,\n" +
            "ifnull(grain_inside_temperature,0) as cfnw,\n" +
            "ifnull(grain_inside_humidity,0) as cfns,\n" +
            "g.id as lswdzjh,\n" +
            "\"\" as lssdzjh,\n" +
            "\"\" as lssfzjh,\n" +
            "\"\" as lhqzjh,\n" +
            "\"\" as yqzjh,\n" +
            "\"\" as eyhtzjh,\n" +
            "\"\" as hcmd,\n" +
            "ifnull(w.length,0) as zb1,\n" +
            "ifnull(w.width,0) as zb2,\n" +
            "ifnull(w.height,0) as zb3," +
            "0 as jd,\n" +
            "0 as wlzb1,\n" +
            "0 as wlzb2,\n" +
            "0 as wlzb3,\n" +
            "\"\" as cwdbh,\n" +
            "\"\" as csdbh,\n" +
            "\"\" as csfdbh,\n" +
            "\"\" as ccdbh,\n" +
            "\"\" as clhqdbh,\n" +
            "\"\" as cyqdbh,\n" +
            "\"\" as ceyhtdbh,\n" +
            "\"0\" as sfsc\n" +
            "from u_02_hx.grainsituationrecord_history g\n" +
            " LEFT JOIN u_com00.tb_warehouse w on g.warehouse_id=w.id \n"+
            "where g.grainallocation_code is not null and g.upload_time BETWEEN #{startTime} and #{endTime} ")
    List<Map> getUpLqjcxxH(@Param("startTime")String startTime,@Param("endTime")String endTime);//TODO 去掉测试用的 where id

    @Select("SELECT \n" +
            "t.id,g.id,CONVERT(t.x_coordinate/5,SIGNED) x,CONVERT(t.y_coordinate/5,SIGNED) y,f.temperature_surface_number z,CONVERT(t.temperature_value*10,SIGNED) val\n" +
            "from u_02_hx.temperature_history t\n" +
            "LEFT JOIN u_02_hx.grainsituationrecord_history g on t.gsr_id=g.id\n" +
            "LEFT JOIN u_02_hx.temperaturesurface_history f on t.t_surface_id=f.id\n" +
            "where g.id=#{gId}\n" +
            "ORDER BY z,x,y")
    List<Map> getUpLqjcxxPointH(@Param("gId")String gId);
   /* @Select("SELECT top 10 \n" +
            "g.enterprise_code+'000000000'+g.graindepot_gb_code+g.storehouse_gb_code+g.warehouse_gb_code+g.grainallocation_code+'2016'+right(g.id,6)   bm,\n" +
            "ISNULL(g.grain_situation_gather_time,'1900-01-01 00:00:00')   jcsj,\n" +
            "ISNULL(grain_outside_temperature,0)   cfww,\n" +
            "ISNULL(grain_outside_humidity,0)   cfws,\n" +
            "ISNULL(grain_inside_temperature,0)   cfnw,\n" +
            "ISNULL(grain_inside_humidity,0)   cfns,\n" +
            "id   [lswdzjh],\n" +
            "''   [lssdzjh],\n" +
            "''   [lssfzjh],\n" +
            "''   [lhqzjh],\n" +
            "''   [yqzjh],\n" +
            "''   [eyhtzjh],\n" +
            "''   [hcmd],\n" +
            "0   [zb1],\n" +
            "0   [zb2],\n" +
            "0   [zb3],\n" +
            "0   [jd],\n" +
            "0   [wlzb1],\n" +
            "0   [wlzb2],\n" +
            "0   [wlzb3],\n" +
            "''   [cwdbh],\n" +
            "''   [csdbh],\n" +
            "''   [csfdbh],\n" +
            "''   [ccdbh],\n" +
            "''   [clhqdbh],\n" +
            "''   [cyqdbh],\n" +
            "''   [ceyhtdbh],\n" +
            "'0'   [sfsc]\n" +
            "from grainsituationrecord g\n" +
            "where g.grainallocation_code is not null and g.upload_time BETWEEN #{startTime} and #{endTime} ")
    List<Map> getUpLqjcxxSSV(@Param("startTime")String startTime,@Param("endTime")String endTime);//TODO 去掉测试用的 where id

    @Select("SELECT t.id,g.id,CONVERT(int,t.x_coordinate/5) x,CONVERT(int,t.y_coordinate/5) y,f.temperature_surface_number z,CONVERT(int,t.temperature_value*10) val\n" +
            "from temperature t\n" +
            "LEFT JOIN grainsituationrecord g on t.gsr_id=g.id\n" +
            "LEFT JOIN temperaturesurface f on t.t_surface_id=f.id\n" +
            "where g.id=#{gId}\n" +
            "ORDER BY z,x,y")
    List<Map> getUpLqjcxxPointSSV(@Param("gId")String gId);*/
}/*t.update_date BETWEEN #{startTime} and #{endTime};*/