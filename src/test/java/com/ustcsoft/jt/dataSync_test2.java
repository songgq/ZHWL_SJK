package com.ustcsoft.jt;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataSync_test2 {

	public static int Initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	private static Connection getConn() {
		String url="jdbc:mysql://127.0.0.1:3306/u_com00";
		String user="root";
		String password="123456";
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception var3) {
			System.out.println(var3);
			return null;
		}
	}

	public static List getSql(String sql){
		Connection conn=getConn();
		//String sql="select * from m_cc w where w.id=?";
		List rsall = new ArrayList();
		Map rsTree;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			//ps.setString(1, "3");
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			while(rs.next())
			{
				rsTree = new HashMap(numberOfColumns);
				for(int r=1;r<numberOfColumns+1;r++)
				{
					rsTree.put(rsmd.getColumnName(r),rs.getObject(r));
				}
				rsall.add(rsTree);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}



		return rsall;
	}
	public static void main(String[] args) {
		List<Map> ls=getSql("SELECT\n" +
				"idx,qydm\n" +
				"from u_com00.m_cc_qyxx t where qydm like '%x%' ");
		String up="";
		for (int i = 0; i <ls.size() ; i++) {
			String aa=ls.get(i).get("qydm").toString();
			/*while(aa.length()<18){
				aa+="0";
			}*/
			aa.toUpperCase();
			up+="update u_com00.m_cc_qyxx  set qydm= '"+aa +"' where idx='"+ls.get(i).get("idx").toString()+"';";
			System.out.println(ls.get(i));
		}
		System.out.println(up);
		Connection conn=getConn();
		PreparedStatement ps= null;
		try {
			ps = conn.prepareStatement(up);
			int i=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	/*	*//*System.out.println(JsonUtil.objectToJson(ls));
		for (int i = 0; i <ls.size() ; i++) {
			if(((Map)ls.get(i)).get("img_url")==null){
				continue;
			}
			String imgurl=((Map)ls.get(i)).get("img_url").toString();
			String lsi=imgurl;
			lsi="D:"+lsi.substring(0,lsi.lastIndexOf("/"));
			System.out.println(lsi);
			File f=new File(lsi);
			if(!f.exists()){
				f.mkdir();
			}
			String url="http://zjtosj.com"+imgurl;
			String path="D:"+imgurl;
			System.out.println( url +"\n"+path);
			test4.downFile(url,path);
		}

*//*
		dataSync_test2 d2=new dataSync_test2();
		Connection conn=d2.getConn();
		String sql="select * from u_com00. w where w.id=?";
		List rsall = new ArrayList();
		Map rsTree;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "3");
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			while(rs.next())
			{
				rsTree = new HashMap(numberOfColumns);
				for(int r=1;r<numberOfColumns+1;r++)
				{
					rsTree.put(rsmd.getColumnName(r),rs.getObject(r));
				}
				rsall.add(rsTree);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}







*/

		/*DataSync datasync = new DataSync();
		int rec = 0;
		rec = datasync.Initialize();//初始化
		System.out.println(DataSync.errorMsg[rec]);
		rec = datasync.Update("");

		System.out.println(DataSync.errorMsg[rec]);*/

	}

}
