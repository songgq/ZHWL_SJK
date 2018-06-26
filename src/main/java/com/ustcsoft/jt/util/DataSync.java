package com.ustcsoft.jt.util;

/**
 * 粮情数据同步工具类
 * Created by Songgq on 2018/6/10.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ustcsoft.jt.constant.ApiConstants;
import net.sf.json.JSONObject;

public class DataSync {
    public static String[] errorMsg = new String[]{"成功", "加载数据库驱动错误", "未找到配置文件", "读取配置文件出错", "连接数据库错误", "未初始化", "JSON数据错误", "数据库操作失败", "库区信息不存在", "仓房信息不存在", "廒间信息不存在"};
    private boolean isinit = false;
    private String url;
    private String user;
    private String password;

    public DataSync() {
    }

    public int Initialize() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException var7) {
            System.out.println(var7);
            return errorCode.DriverError.ordinal();
        }

        String str;

       /* try {
            FileInputStream in = new FileInputStream("config.json");
            byte[] byt = new byte[1024];
            int len = in.read(byt);
            in.close();
            str = new String(byt, 0, len);
        } catch (FileNotFoundException var5) {
            System.out.println(var5);
            return errorCode.FileNotFound.ordinal();
        } catch (Exception var6) {
            System.out.println(var6);
            return errorCode.ReadConfigFileError.ordinal();
        }

        try {
            JSONObject jsonObject = JSONObject.fromObject(str);
            if (jsonObject == null || jsonObject.isNullObject()) {
                return errorCode.JsonDataError.ordinal();
            }

            this.url = jsonObject.getString("url");
            this.user = jsonObject.getString("user");
            this.password = jsonObject.getString("password");
        } catch (Exception var8) {
            System.out.println(var8);
            return errorCode.JsonDataError.ordinal();
        }
*/
        this.url = ApiConstants.LIANGQING_URL;
        this.user = ApiConstants.LIANGQING_USER;
        this.password = ApiConstants.LIANGQING_PWD;
        this.isinit = true;
        return errorCode.OK.ordinal();
    }

    private Connection getConn() {
        try {
            Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
            return conn;
        } catch (Exception var3) {
            System.out.println(var3);
            return null;
        }
    }

    private int OperateStoreinfo(Storeinfo storeinfo, OperateType operatetype) {
        Connection conn = this.getConn();
        int oldstoreID = 0;
        if (conn == null) {
            return errorCode.ConnDBError.ordinal();
        } else {
            try {
                String sql;
                PreparedStatement ps1;
                if (operatetype == OperateType.Insert) {
                    System.out.println("Insert");
                    System.out.println(0);
                    sql = "insert into 库区信息(库区名称, 库区编码, 库区组织机构代码) values(?, ?, ?)";
                    ps1 = conn.prepareStatement(sql);
                    ps1.setString(1, storeinfo.storename);
                    ps1.setString(2, storeinfo.storecode);
                    ps1.setString(3, storeinfo.storeorgancode);
                    ps1.executeUpdate();
                    ps1.close();
                } else {
                    PreparedStatement ps;
                    ResultSet rs;
                    if (operatetype == OperateType.Update) {
                        System.out.println("Update");
                        System.out.println(storeinfo.oldstorecode);
                        sql = "select ID from 库区信息  where 库区编码 = ? and 库区组织机构代码 = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, storeinfo.oldstorecode);
                        ps.setString(2, storeinfo.oldstoreorgancode);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            oldstoreID = rs.getInt(1);
                        }

                        rs.close();
                        ps.close();
                        if (oldstoreID == 0) {
                            conn.close();
                            return errorCode.StoreInfoNoExit.ordinal();
                        }

                        sql = "update 库区信息 set 库区名称 = ?, 库区编码 = ?, 库区组织机构代码 = ? where ID = ?";
                        ps1 = conn.prepareStatement(sql);
                        ps1.setString(1, storeinfo.storename);
                        ps1.setString(2, storeinfo.storecode);
                        ps1.setString(3, storeinfo.storeorgancode);
                        ps1.setInt(4, oldstoreID);
                        ps1.executeUpdate();
                        ps1.close();
                    } else if (operatetype == OperateType.Delete) {
                        System.out.println("Delete");
                        System.out.println(storeinfo.oldstorecode);
                        sql = "select ID from 库区信息  where 库区编码 = ? and 库区组织机构代码 = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, storeinfo.oldstorecode);
                        ps.setString(2, storeinfo.oldstoreorgancode);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            oldstoreID = rs.getInt(1);
                        }

                        rs.close();
                        ps.close();
                        if (oldstoreID == 0) {
                            conn.close();
                            return errorCode.StoreInfoNoExit.ordinal();
                        }

                        List<Integer> depotID = new ArrayList();
                        sql = "select ID from 仓房信息  where 库区ID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, oldstoreID);
                        rs = ps.executeQuery();

                        while(rs.next()) {
                            depotID.add(rs.getInt(1));
                        }

                        rs.close();
                        ps.close();
                        int i = 0;

                        while(true) {
                            if (i >= depotID.size()) {
                                sql = "delete from 仓房信息  where 库区ID = ?";
                                ps = conn.prepareStatement(sql);
                                ps.setInt(1, oldstoreID);
                                ps.executeUpdate();
                                ps.close();
                                sql = "delete from 库区信息  where ID = ?";
                                ps = conn.prepareStatement(sql);
                                ps.setInt(1, oldstoreID);
                                ps.executeUpdate();
                                ps.close();
                                break;
                            }

                            List<Integer> warehouseID = new ArrayList();
                            sql = "select ID from 廒间信息  where 仓房ID = ?";
                            ps = conn.prepareStatement(sql);
                            ps.setInt(1, (Integer)depotID.get(i));
                            rs = ps.executeQuery();

                            while(rs.next()) {
                                warehouseID.add(rs.getInt(1));
                            }

                            rs.close();
                            ps.close();

                            for(int j = 0; j < warehouseID.size(); ++j) {
                                sql = "delete from 平方仓信息  where 廒间ID = ?";
                                ps = conn.prepareStatement(sql);
                                ps.setInt(1, (Integer)warehouseID.get(j));
                                ps.executeUpdate();
                                ps.close();
                                sql = "delete from 浅圆仓筒仓信息  where 廒间ID = ?";
                                ps = conn.prepareStatement(sql);
                                ps.setInt(1, (Integer)warehouseID.get(j));
                                ps.executeUpdate();
                                ps.close();
                            }

                            sql = "delete from 廒间信息  where 仓房ID = ?";
                            ps = conn.prepareStatement(sql);
                            ps.setInt(1, (Integer)depotID.get(i));
                            ps.executeUpdate();
                            ps.close();
                            ++i;
                        }
                    }
                }

                conn.close();
            } catch (Exception var12) {
                System.out.println(var12);
                return errorCode.ExecuteSQLError.ordinal();
            }

            return errorCode.OK.ordinal();
        }
    }

    private int OperateDeportinfo(Depotinfo depotinfo, OperateType operatetype) {
        int storeID = 0;
        int oldstoreID = 0;
        int olddepotID = 0;
        Connection conn = this.getConn();
        if (conn == null) {
            return errorCode.ConnDBError.ordinal();
        } else {
            try {
                String sql;
                PreparedStatement ps;
                ResultSet rs;
                if (operatetype == OperateType.Insert) {
                    System.out.println("Insert");
                    System.out.println(0);
                    sql = "select ID from 库区信息  where 库区编码 = ? and 库区组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, depotinfo.storecode);
                    ps.setString(2, depotinfo.storeorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        storeID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    if (storeID == 0) {
                        conn.close();
                        return errorCode.StoreInfoNoExit.ordinal();
                    }

                    sql = "insert into 仓房信息(库区ID, 仓房名称, 仓房编码, 仓房类型, 仓房组织机构代码) values(?, ?, ?, ?, ?)";
                    PreparedStatement ps1 = conn.prepareStatement(sql);
                    ps1.setInt(1, storeID);
                    ps1.setString(2, depotinfo.depotname);
                    ps1.setString(3, depotinfo.depotcode);
                    ps1.setString(4, depotinfo.depottype);
                    ps1.setString(5, depotinfo.depotorgancode);
                    ps1.executeUpdate();
                    ps1.close();
                } else if (operatetype == OperateType.Update) {
                    System.out.println("Update");
                    System.out.println(depotinfo.oldstorecode);
                    System.out.println(depotinfo.olddepotcode);
                    sql = "select ID from 库区信息  where 库区编码 = ? and 库区组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, depotinfo.oldstorecode);
                    ps.setString(2, depotinfo.oldstoreorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        oldstoreID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    sql = "select ID from 仓房信息  where 仓房编码 = ? and 仓房组织机构代码 = ? and 库区ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, depotinfo.olddepotcode);
                    ps.setString(2, depotinfo.olddepotorgancode);
                    ps.setInt(3, oldstoreID);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        olddepotID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    sql = "select ID from 库区信息  where 库区编码 = ? and 库区组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, depotinfo.storecode);
                    ps.setString(2, depotinfo.storeorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        storeID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    if (oldstoreID == 0 || olddepotID == 0 || storeID == 0) {
                        conn.close();
                        return errorCode.StoreInfoNoExit.ordinal();
                    }

                    sql = "update 仓房信息 set 库区ID = ?, 仓房名称 = ?, 仓房编码 = ?, 仓房类型 = ?, 仓房组织机构代码 = ? where ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, storeID);
                    ps.setString(2, depotinfo.depotname);
                    ps.setString(3, depotinfo.depotcode);
                    ps.setString(4, depotinfo.depottype);
                    ps.setString(5, depotinfo.depotorgancode);
                    ps.setInt(6, olddepotID);
                    ps.executeUpdate();
                    ps.close();
                } else if (operatetype == OperateType.Delete) {
                    System.out.println("Delete");
                    System.out.println(depotinfo.oldstorecode);
                    System.out.println(depotinfo.olddepotcode);
                    sql = "select ID from 库区信息  where 库区编码 = ? and 库区组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, depotinfo.oldstorecode);
                    ps.setString(2, depotinfo.oldstoreorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        oldstoreID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    sql = "select ID from 仓房信息  where 仓房编码 = ? and 仓房组织机构代码 = ? and 库区ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, depotinfo.olddepotcode);
                    ps.setString(2, depotinfo.olddepotorgancode);
                    ps.setInt(3, oldstoreID);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        olddepotID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    if (olddepotID == 0) {
                        conn.close();
                        return errorCode.DepotInfoNoExit.ordinal();
                    }

                    List<Integer> warehouseID = new ArrayList();
                    sql = "select ID from 廒间信息  where 仓房ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, olddepotID);
                    rs = ps.executeQuery();

                    while(rs.next()) {
                        warehouseID.add(rs.getInt(1));
                    }

                    rs.close();
                    ps.close();
                    int j = 0;

                    while(true) {
                        if (j >= warehouseID.size()) {
                            sql = "delete from 廒间信息  where 仓房ID = ?";
                            ps = conn.prepareStatement(sql);
                            ps.setInt(1, olddepotID);
                            ps.executeUpdate();
                            ps.close();
                            sql = "delete from 仓房信息  where ID = ?";
                            ps = conn.prepareStatement(sql);
                            ps.setInt(1, olddepotID);
                            ps.executeUpdate();
                            ps.close();
                            break;
                        }

                        System.out.println((Integer)warehouseID.get(j));
                        sql = "delete from 平方仓信息 where 廒间ID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, (Integer)warehouseID.get(j));
                        ps.executeUpdate();
                        ps.close();
                        sql = "delete from 浅圆仓筒仓信息 where 廒间ID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, (Integer)warehouseID.get(j));
                        ps.executeUpdate();
                        ps.close();
                        ++j;
                    }
                }

                conn.close();
            } catch (Exception var12) {
                System.out.println(var12);
                return errorCode.ExecuteSQLError.ordinal();
            }

            return errorCode.OK.ordinal();
        }
    }

    private int OperateWarehouseinfo(Warehouseinfo warehouseinfo, OperateType operatetype) {
        int depotID = 0;
        int olddepotID = 0;
        int oldwarehouseID = 0;
        Connection conn = this.getConn();
        if (conn == null) {
            return errorCode.ConnDBError.ordinal();
        } else {
            try {
                String sql;
                PreparedStatement ps;
                ResultSet rs;
                if (operatetype == OperateType.Insert) {
                    System.out.println("Insert");
                    System.out.println(warehouseinfo.depotcode);
                    System.out.println(0);
                    sql = "select ID from 仓房信息  where 仓房编码 = ? and 仓房组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, warehouseinfo.depotcode);
                    ps.setString(2, warehouseinfo.depotorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        depotID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    if (depotID == 0) {
                        conn.close();
                        return errorCode.DepotInfoNoExit.ordinal();
                    }

                    sql = "insert into 廒间信息(仓房ID, 廒间名称, 廒间编码, 廒间类型, 廒间组织机构代码) values(?, ?, ?, ?, ?)";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, depotID);
                    ps.setString(2, warehouseinfo.warehousename);
                    ps.setString(3, warehouseinfo.warehousecode);
                    ps.setString(4, warehouseinfo.warehousetype);
                    ps.setString(5, warehouseinfo.warehouseorgancode);
                    ps.executeUpdate();
                    ps.close();
                } else if (operatetype == OperateType.Update) {
                    System.out.println("Update");
                    System.out.println(warehouseinfo.olddepotcode);
                    System.out.println(warehouseinfo.oldwarehousecode);
                    sql = "select ID from 仓房信息  where 仓房编码 = ? and 仓房组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, warehouseinfo.olddepotcode);
                    ps.setString(2, warehouseinfo.olddepotorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        olddepotID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    sql = "select ID from 廒间信息  where 廒间编码 = ? and 廒间组织机构代码 = ? and 仓房ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, warehouseinfo.oldwarehousecode);
                    ps.setString(2, warehouseinfo.oldwarehouseorgancode);
                    ps.setInt(3, olddepotID);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        oldwarehouseID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    sql = "select ID from 仓房信息  where 仓房编码 = ? and 仓房组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, warehouseinfo.depotcode);
                    ps.setString(2, warehouseinfo.depotorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        depotID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    if (olddepotID == 0 || oldwarehouseID == 0 || depotID == 0) {
                        conn.close();
                        return errorCode.DepotInfoNoExit.ordinal();
                    }

                    sql = "update 廒间信息 set 仓房ID = ?, 廒间名称 = ?, 廒间编码 = ?, 廒间类型 = ?, 廒间组织机构代码 = ? where ID = ?";
                    PreparedStatement ps1 = conn.prepareStatement(sql);
                    ps1.setInt(1, depotID);
                    ps1.setString(2, warehouseinfo.warehousename);
                    ps1.setString(3, warehouseinfo.warehousecode);
                    ps1.setString(4, warehouseinfo.warehousetype);
                    ps1.setString(5, warehouseinfo.warehouseorgancode);
                    ps1.setInt(6, oldwarehouseID);
                    ps1.executeUpdate();
                    ps1.close();
                } else if (operatetype == OperateType.Delete) {
                    System.out.println("Delete");
                    System.out.println(warehouseinfo.olddepotcode);
                    System.out.println(warehouseinfo.oldwarehousecode);
                    sql = "select ID from 仓房信息  where 仓房编码 = ? and 仓房组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, warehouseinfo.olddepotcode);
                    ps.setString(2, warehouseinfo.olddepotorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        olddepotID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    sql = "select ID from 廒间信息  where 廒间编码 = ? and 廒间组织机构代码 = ? and 仓房ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, warehouseinfo.oldwarehousecode);
                    ps.setString(2, warehouseinfo.oldwarehouseorgancode);
                    ps.setInt(3, olddepotID);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        oldwarehouseID = rs.getInt(1);
                    }

                    rs.close();
                    ps.close();
                    if (oldwarehouseID == 0) {
                        conn.close();
                        return errorCode.WareHouseInfoNoExit.ordinal();
                    }

                    sql = "delete from 平方仓信息  where 廒间ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, oldwarehouseID);
                    ps.executeUpdate();
                    ps.close();
                    sql = "delete from 浅圆仓筒仓信息  where 廒间ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, oldwarehouseID);
                    ps.executeUpdate();
                    ps.close();
                    sql = "delete from 廒间信息  where ID = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, oldwarehouseID);
                    ps.executeUpdate();
                    ps.close();
                }

                conn.close();
            } catch (Exception var11) {
                System.out.println(var11);
                return errorCode.ExecuteSQLError.ordinal();
            }

            return errorCode.OK.ordinal();
        }
    }

    private int OperateConfiginfo(Configinfo configinfo, OperateType operatetype) {
        int warehouseID = 0;
        int oldwarehouseID = 0;
        String warehouseType = "";
        String oldwarehouseType = "";
        Connection conn = this.getConn();
        if (conn == null) {
            return errorCode.ConnDBError.ordinal();
        } else {
            try {
                String sql;
                PreparedStatement ps;
                ResultSet rs;
                if (operatetype == OperateType.Insert) {
                    System.out.println("Insert");
                    System.out.println(configinfo.warehousecode);
                    sql = "select ID, 廒间类型 from 廒间信息  where 廒间编码 = ? and 廒间组织机构代码 = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, configinfo.warehousecode);
                    ps.setString(2, configinfo.warehouseorgancode);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        warehouseID = rs.getInt(1);
                        warehouseType = rs.getString(2);
                    }

                    rs.close();
                    ps.close();
                    if (warehouseID == 0) {
                        conn.close();
                        return errorCode.WareHouseInfoNoExit.ordinal();
                    }

                    if (warehouseType.equals("平方仓")) {
                        sql = "insert into 平方仓信息(廒间ID, 长向电缆根数, 长向电缆间距, 宽向电缆根数, 宽向电缆间距, 测温点数, 测温点间距, 布局方式, 起始电缆号) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    } else {
                        sql = "insert into 浅圆仓筒仓信息(廒间ID, 圈号, 半径, 起始角, 电缆数, 测温点数, 测温点间距, 纵向坐标, 起始电缆号) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    }

                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, warehouseID);
                    ps.setString(2, configinfo.f1);
                    ps.setString(3, configinfo.f2);
                    ps.setString(4, configinfo.f3);
                    ps.setString(5, configinfo.f4);
                    ps.setString(6, configinfo.f5);
                    ps.setString(7, configinfo.f6);
                    ps.setString(8, configinfo.f7);
                    ps.setString(9, configinfo.f8);
                    ps.executeUpdate();
                    ps.close();
                } else {
                    PreparedStatement ps1;
                    if (operatetype == OperateType.Update) {
                        System.out.println("Update");
                        System.out.println(configinfo.oldwarehousecode);
                        System.out.println(configinfo.warehousecode);
                        sql = "select ID, 廒间类型 from 廒间信息  where 廒间编码 = ? and 廒间组织机构代码 = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, configinfo.oldwarehousecode);
                        ps.setString(2, configinfo.oldwarehouseorgancode);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            oldwarehouseID = rs.getInt(1);
                            oldwarehouseType = rs.getString(2);
                        }

                        rs.close();
                        ps.close();
                        sql = "select ID, 廒间类型 from 廒间信息  where 廒间编码 = ? and 廒间组织机构代码 = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, configinfo.warehousecode);
                        ps.setString(2, configinfo.warehouseorgancode);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            warehouseID = rs.getInt(1);
                            warehouseType = rs.getString(2);
                        }

                        rs.close();
                        ps.close();
                        if (oldwarehouseID == 0 || warehouseID == 0 || !warehouseType.equals(oldwarehouseType)) {
                            conn.close();
                            System.out.println(oldwarehouseID);
                            System.out.println(warehouseID);
                            return errorCode.WareHouseInfoNoExit.ordinal();
                        }

                        if (warehouseType.equals("平方仓")) {
                            sql = "update 平方仓信息 set 廒间ID = ?, 长向电缆根数 = ?, 长向电缆间距 = ?, 宽向电缆根数 = ?, 宽向电缆间距 = ?, 测温点数 = ?, 测温点间距 = ?, 布局方式 = ?, 起始电缆号 = ? where 廒间ID = ?";
                            ps1 = conn.prepareStatement(sql);
                            ps1.setInt(1, warehouseID);
                            ps1.setString(2, configinfo.f1);
                            ps1.setString(3, configinfo.f2);
                            ps1.setString(4, configinfo.f3);
                            ps1.setString(5, configinfo.f4);
                            ps1.setString(6, configinfo.f5);
                            ps1.setString(7, configinfo.f6);
                            ps1.setString(8, configinfo.f7);
                            ps1.setString(9, configinfo.f8);
                            ps1.setInt(10, oldwarehouseID);
                            ps1.executeUpdate();
                            ps1.close();
                        } else {
                            sql = "update 浅圆仓筒仓信息 set 廒间ID = ?, 圈号 = ?, 半径 = ?, 起始角 = ?, 电缆数 = ?, 测温点数 = ?, 测温点间距 = ?, 纵向坐标 = ?, 起始电缆号 = ? where 廒间ID = ? and 圈号 = ?";
                            ps1 = conn.prepareStatement(sql);
                            ps1.setInt(1, warehouseID);
                            ps1.setString(2, configinfo.f1);
                            ps1.setString(3, configinfo.f2);
                            ps1.setString(4, configinfo.f3);
                            ps1.setString(5, configinfo.f4);
                            ps1.setString(6, configinfo.f5);
                            ps1.setString(7, configinfo.f6);
                            ps1.setString(8, configinfo.f7);
                            ps1.setString(9, configinfo.f8);
                            ps1.setInt(10, oldwarehouseID);
                            ps1.setString(11, configinfo.ringnum);
                            ps1.executeUpdate();
                            ps1.close();
                        }
                    } else if (operatetype == OperateType.Delete) {
                        System.out.println("Delete");
                        System.out.println(configinfo.oldwarehousecode);
                        sql = "select ID, 廒间类型 from 廒间信息  where 廒间编码 = ? and 廒间组织机构代码 = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, configinfo.oldwarehousecode);
                        ps.setString(2, configinfo.oldwarehouseorgancode);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            oldwarehouseID = rs.getInt(1);
                            oldwarehouseType = rs.getString(2);
                        }

                        rs.close();
                        ps.close();
                        if (oldwarehouseID == 0) {
                            conn.close();
                            return errorCode.WareHouseInfoNoExit.ordinal();
                        }

                        if (oldwarehouseType.equals("平方仓")) {
                            sql = "delete from 平方仓信息 where 廒间ID = ?";
                            ps1 = conn.prepareStatement(sql);
                            ps1.setInt(1, oldwarehouseID);
                            ps1.executeUpdate();
                            ps1.close();
                        } else {
                            sql = "delete from 浅圆仓筒仓信息 where 廒间ID = ? and 圈号 = ?";
                            ps1 = conn.prepareStatement(sql);
                            ps1.setInt(1, oldwarehouseID);
                            ps1.setString(2, configinfo.ringnum);
                            ps1.executeUpdate();
                            ps1.close();
                        }
                    }
                }

                conn.close();
            } catch (Exception var12) {
                System.out.println(var12);
                return errorCode.ExecuteSQLError.ordinal();
            }

            return errorCode.OK.ordinal();
        }
    }

    public int Update(String json_data) {
        if (!this.isinit) {
            return errorCode.UnInit.ordinal();
        } else {
            JSONObject jsonObject = JSONObject.fromObject(json_data);
            if (jsonObject != null && !jsonObject.isNullObject()) {
                String[] StoreInfoKey = new String[]{"库区名称", "库区编码", "库区组织机构代码", "old_values"};
                String[] DepotInfoKey = new String[]{"仓房名称", "仓房编码", "仓房类型", "仓房组织机构代码", "库区编码", "库区组织机构代码", "old_values"};
                String[] WareHouseInfoKey = new String[]{"廒间名称", "廒间编码", "廒间类型", "廒间组织机构代码", "仓房编码", "仓房组织机构代码", "old_values"};
                String[] ConfigInfoKey = new String[]{"廒间编码", "廒间组织机构代码", "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "old_values"};
                List<String> Key = new ArrayList();
                Iterator it = jsonObject.keys();

                while(it.hasNext()) {
                    Key.add((String)it.next());
                }

                if (Key.size() < 3 && !((String)Key.get(0)).equals("操作类型") && ((String)Key.get(1)).equals("信息类型")) {
                    return errorCode.JsonDataError.ordinal();
                } else {
                    String StrOperateType = jsonObject.getString((String)Key.get(0));
                    String InfoType = jsonObject.getString((String)Key.get(1));
                    int i;
                    if (InfoType.equals("库区信息") && Key.size() == 6) {
                        for(i = 2; i < 6; ++i) {
                            if (!((String)Key.get(i)).equals(StoreInfoKey[i - 2])) {
                                return errorCode.JsonDataError.ordinal();
                            }
                        }
                    } else if (InfoType.equals("仓房信息") && Key.size() == 9) {
                        for(i = 2; i < 9; ++i) {
                            if (!((String)Key.get(i)).equals(DepotInfoKey[i - 2])) {
                                return errorCode.JsonDataError.ordinal();
                            }
                        }
                    } else if (InfoType.equals("廒间信息") && Key.size() == 9) {
                        for(i = 2; i < 9; ++i) {
                            if (!((String)Key.get(i)).equals(WareHouseInfoKey[i - 2])) {
                                return errorCode.JsonDataError.ordinal();
                            }
                        }
                    } else {
                        if (!InfoType.equals("配置信息") || Key.size() != 13) {
                            return errorCode.JsonDataError.ordinal();
                        }

                        for(i = 2; i < 13; ++i) {
                            if (!((String)Key.get(i)).equals(ConfigInfoKey[i - 2])) {
                                return errorCode.JsonDataError.ordinal();
                            }
                        }
                    }

                    OperateType operatetype;
                    if (StrOperateType.equals("insert")) {
                        operatetype = OperateType.Insert;
                    } else if (StrOperateType.equals("update")) {
                        operatetype = OperateType.Update;
                    } else {
                        if (!StrOperateType.equals("delete")) {
                            return errorCode.JsonDataError.ordinal();
                        }

                        operatetype = OperateType.Delete;
                    }

                    JSONObject jsonObject1;
                    if (InfoType.equals("库区信息")) {
                        Storeinfo storeinfo = new Storeinfo();
                        storeinfo.storename = jsonObject.getString((String)Key.get(2));
                        storeinfo.storecode = jsonObject.getString((String)Key.get(3));
                        storeinfo.storeorgancode = jsonObject.getString((String)Key.get(4));
                        jsonObject1 = jsonObject.getJSONObject((String)Key.get(5));
                        if (jsonObject1 != null && !jsonObject1.isNullObject()) {
                            storeinfo.oldstorecode = jsonObject1.getString("库区编码");
                            storeinfo.oldstoreorgancode = jsonObject1.getString("库区组织机构代码");
                            return this.OperateStoreinfo(storeinfo, operatetype);
                        } else {
                            return errorCode.JsonDataError.ordinal();
                        }
                    } else if (InfoType.equals("仓房信息")) {
                        Depotinfo depotinfo = new Depotinfo();
                        depotinfo.depotname = jsonObject.getString((String)Key.get(2));
                        depotinfo.depotcode = jsonObject.getString((String)Key.get(3));
                        depotinfo.depottype = jsonObject.getString((String)Key.get(4));
                        depotinfo.depotorgancode = jsonObject.getString((String)Key.get(5));
                        depotinfo.storecode = jsonObject.getString((String)Key.get(6));
                        depotinfo.storeorgancode = jsonObject.getString((String)Key.get(7));
                        jsonObject1 = jsonObject.getJSONObject((String)Key.get(8));
                        if (jsonObject1 != null && !jsonObject1.isNullObject()) {
                            depotinfo.olddepotcode = jsonObject1.getString("仓房编码");
                            depotinfo.olddepotorgancode = jsonObject1.getString("仓房组织机构代码");
                            depotinfo.oldstorecode = jsonObject1.getString("库区编码");
                            depotinfo.oldstoreorgancode = jsonObject1.getString("库区组织机构代码");
                            return this.OperateDeportinfo(depotinfo, operatetype);
                        } else {
                            return errorCode.JsonDataError.ordinal();
                        }
                    } else if (InfoType.equals("廒间信息")) {
                        Warehouseinfo warehouseinfo = new Warehouseinfo();
                        warehouseinfo.warehousename = jsonObject.getString((String)Key.get(2));
                        warehouseinfo.warehousecode = jsonObject.getString((String)Key.get(3));
                        warehouseinfo.warehousetype = jsonObject.getString((String)Key.get(4));
                        warehouseinfo.warehouseorgancode = jsonObject.getString((String)Key.get(5));
                        warehouseinfo.depotcode = jsonObject.getString((String)Key.get(6));
                        warehouseinfo.depotorgancode = jsonObject.getString((String)Key.get(7));
                        jsonObject1 = jsonObject.getJSONObject((String)Key.get(8));
                        if (jsonObject1 != null && !jsonObject1.isNullObject()) {
                            warehouseinfo.oldwarehousecode = jsonObject1.getString("廒间编码");
                            warehouseinfo.oldwarehouseorgancode = jsonObject1.getString("廒间组织机构代码");
                            warehouseinfo.olddepotcode = jsonObject1.getString("仓房编码");
                            warehouseinfo.olddepotorgancode = jsonObject1.getString("仓房组织机构代码");
                            return this.OperateWarehouseinfo(warehouseinfo, operatetype);
                        } else {
                            return errorCode.JsonDataError.ordinal();
                        }
                    } else if (InfoType.equals("配置信息")) {
                        Configinfo configinfo = new Configinfo();
                        configinfo.warehousecode = jsonObject.getString((String)Key.get(2));
                        configinfo.warehouseorgancode = jsonObject.getString((String)Key.get(3));
                        configinfo.f1 = jsonObject.getString((String)Key.get(4));
                        configinfo.f2 = jsonObject.getString((String)Key.get(5));
                        configinfo.f3 = jsonObject.getString((String)Key.get(6));
                        configinfo.f4 = jsonObject.getString((String)Key.get(7));
                        configinfo.f5 = jsonObject.getString((String)Key.get(8));
                        configinfo.f6 = jsonObject.getString((String)Key.get(9));
                        configinfo.f7 = jsonObject.getString((String)Key.get(10));
                        configinfo.f8 = jsonObject.getString((String)Key.get(11));
                        jsonObject1 = jsonObject.getJSONObject((String)Key.get(12));
                        if (jsonObject1 != null && !jsonObject1.isNullObject()) {
                            configinfo.oldwarehousecode = jsonObject1.getString("廒间编码");
                            configinfo.oldwarehouseorgancode = jsonObject1.getString("廒间组织机构代码");
                            configinfo.ringnum = jsonObject1.getString("圈号");
                            return this.OperateConfiginfo(configinfo, operatetype);
                        } else {
                            return errorCode.JsonDataError.ordinal();
                        }
                    } else {
                        return errorCode.OK.ordinal();
                    }
                }
            } else {
                return errorCode.JsonDataError.ordinal();
            }
        }
    }

    private class Configinfo {
        public String warehousecode;
        public String warehouseorgancode;
        public String f1;
        public String f2;
        public String f3;
        public String f4;
        public String f5;
        public String f6;
        public String f7;
        public String f8;
        public String oldwarehousecode;
        public String oldwarehouseorgancode;
        public String ringnum;

        private Configinfo() {
        }
    }

    private class Depotinfo {
        public String depotname;
        public String depotcode;
        public String depottype;
        public String depotorgancode;
        public String storecode;
        public String storeorgancode;
        public String olddepotcode;
        public String olddepotorgancode;
        public String oldstorecode;
        public String oldstoreorgancode;

        private Depotinfo() {
        }
    }

    private static enum OperateType {
        Insert,
        Update,
        Delete;

        private OperateType() {
        }
    }

    private class Storeinfo {
        public String storename;
        public String storecode;
        public String storeorgancode;
        public String oldstorecode;
        public String oldstoreorgancode;

        private Storeinfo() {
        }
    }

    private class Warehouseinfo {
        public String warehousename;
        public String warehousecode;
        public String warehousetype;
        public String warehouseorgancode;
        public String depotcode;
        public String depotorgancode;
        public String oldwarehousecode;
        public String oldwarehouseorgancode;
        public String olddepotcode;
        public String olddepotorgancode;

        private Warehouseinfo() {
        }
    }

    private static enum errorCode {
        OK,
        DriverError,
        FileNotFound,
        ReadConfigFileError,
        ConnDBError,
        UnInit,
        JsonDataError,
        ExecuteSQLError,
        StoreInfoNoExit,
        DepotInfoNoExit,
        WareHouseInfoNoExit;

        private errorCode() {
        }
    }
}

