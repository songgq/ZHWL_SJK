package com.ustcsoft.jt;

import com.alibaba.fastjson.JSON;
import com.ustcsoft.jt.util.HttpUtil;
import com.ustcsoft.jt.util.JsonUtil;
import sun.net.www.http.HttpClient;

import java.util.*;

/**
 * 测试
 * Created by Administrator on 2018/6/24.
 */
public class Jkcs {
    //http://106.3.145.72:49871/dxp/service/API/
//XYGLXX FXLYDXX
    public static void main(String[] args) {

        //String url = "http://106.3.145.72:49871/dxp/service/API/";
        //System.out.println(getMapJson(XYGLXX));
        System.out.println("result:"+doUp(XYGLXX));

    }

    public static String doUp(String xx) {
        String url = "http://106.3.145.72:49871/dxp/service/API/GDDAXX";
        System.out.println("url:"+url);
        String data = getMapJson(xx);
        String orderid = "ff808081642730c4016428703ab30fd9";
        //String orderid = "40281f81642fa26b01642fad365e0076";
        Map map = new HashMap();
        map.put("id", UUID.randomUUID().toString().replace("-", ""));
        map.put("uid", "340000");
        map.put("orderid", orderid);
        map.put("access_token", "");
        map.put("datalength", 1);
        //map.put("data", data);
       /* map.put("data", "[{" +
                "\"xxdz\": \"\"," +
                "\"tssj\": \"2018-06-01 12:00:00\"," +
                "\"sblxr\": \"\"," +
                "\"qymc\": \"dsa\"," +
                "\"xydjpd\": \"A\"," +
                "\"yxsx\": \"\"," +
                "\"bt\": \"\"," +
                "\"lxdh\": \"00000000000000000000000000000000\"," +
                "\"sfts\": \"1\"," +
                "\"sfsc\": \"0\"," +
                "\"bm\": \"328006450000000000001001\"," +
                "\"qydm\": \"328006450000000000001001\"," +
                "\"lrrq\": \"2018-06-01\"" +
                "}]");*/
        map.put("data", "[{\"jh\":\"00000000000000000000000000000000\",\"ys\":0,\"wjzt\":\"0\",\"dqsj\":\"2018-06-01 12:00:00\",\"gdmlmc\":\"00000000000000000000000000000000\",\"sqrq\":\"\",\"wjbh\":\"00000000000000000000000000000000\",\"fwcs\":\"\",\"zzjgbh\":\"\",\"sfsdcl\":\"0\",\"sfsc\":\"0\",\"gdr\":\"00000000000000000000000000000000\",\"shzt\":\"0\",\"bz\":\"\",\"wjfj\":\"\",\"xhsqr\":\"\",\"zrz\":\"\",\"gdsj\":\"2018-06-01 12:00:00\",\"clfs\":\"0\",\"xhrq\":\"\",\"wjsl\":0,\"swlx\":\"0\",\"clfscdnf\":\"0\",\"fjlj\":\"\",\"dajmcd\":\"\",\"bcnf\":\"00000000000000000000000000000000\",\"gdxxfj\":\"\",\"lsdadh\":\"0\",\"wjmc\":\"00000000000000000000000000000000\"}]\n");
        map.put("digst", "");
        String mapStr = JsonUtil.objectToJson(map);
        System.out.println("mapStr:"+map.get("data"));
        String result = "";
        try {// TODO
           result = HttpUtil.doPost(url, mapStr);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    public static String getMapJson(String data) {
        String[] astr = data.split("@");
        List<Map> dataList=new ArrayList<>();
        Map<String, Object> dataMap = new HashMap<>();
        for (int i = 0; i < astr.length; i++) {
            // System.out.println(astr[i]);
            String[] mapstrs = astr[i].split(";");
            if (!"".equals(mapstrs[0].trim()) && !"sfsc".equalsIgnoreCase(mapstrs[0].trim())) {
                if("qydm".equals(mapstrs[0].trim())){
                    dataMap.put(mapstrs[0],(int)((Math.random()*9+1)*100000000)+"000000000001001");
                    continue;
                }
                if(mapstrs.length>2&&mapstrs[2].contains("yyyy-MM-dd")){
                    if(mapstrs[1].contains("10")){
                        dataMap.put(mapstrs[0],"2018-06-01");
                        continue;
                    }else {
                        dataMap.put(mapstrs[0],"2018-06-01 12:00:00");
                        continue;
                    }
                }
                if(mapstrs.length>2&&mapstrs[2].contains("yyyyMMdd")){
                        dataMap.put(mapstrs[0],"20180601");
                        continue;
                }

                    dataMap.put(mapstrs[0], mapstrs[1].contains("String") ? getMapValue(astr[i]) : 0);
              //  System.out.println(mapstrs[0]);

                //System.out.println(mapstrs[0]+":"+(mapstrs[1].contains("String")?getMapValue(astr[i]):0));
            }

        }
        dataMap.put("SFSC", "0");
        dataList.add(dataMap);
        System.out.println(JSON.toJSON(dataList));
        return JsonUtil.objectToJson(dataList);
    }

    public static String getMapValue(String pa) {
        // System.out.println(pa);
        int length = Integer.parseInt(pa.substring(pa.indexOf("(") + 1, pa.indexOf(")")));
        if (pa.contains("可空")&&!pa.contains("不可空")) {
            return "";
        }
        String result = "";
        while (result.length() < length) {
            result += "0";
        }
        return result;
    }
//43
    static String XYGLXX = "bm;String(32);企业代码(18位)+顺序号(6位)@" +
            "qymc;String(64);(不可空)@" +
            "qydm;String(32);(不可空)@" +
            "xxdz;String(128);(可空)@" +
            "sblxr;String(32);(可空)@" +
            "lxdh;String(32);(不可空)@" +
            "xydjpd;String(3);A;@" +
            ";;AA;@" +
            ";;AAA;@" +
            ";;B;@" +
            ";;BB;@" +
            ";;BBB;@" +
            ";;C;@" +
            ";;CC;@" +
            ";;CCC。@" +
            ";;(不可空)@" +
            "yxsx;String(32);(可空)@" +
            "lrrq;String(10);yyyy-MM-dd@" +
            ";;(可空)@" +
            "sfts;String(32);1：是；@" +
            ";;0：否@" +
            ";;(可空)@" +
            "tssj;String(19);yyyy-MM-ddHH:mm:ss@" +
            ";;(可空)@" +
            "bt;String(32);(可空)@" +
            "sfsc;String(1);1：删除@" +
            ";;0：不删除(可空)";

//44
    static String FXLYDXX = "bh;String(32);企业代码(18位)+顺序号(6位)@" +
            "fxlydmc;String(200);(不可空)@" +
            "hylx;String(32);(可空)@" +
            "lxr;String(32);(可空)@" +
            "dh;String(32);(可空)@" +
            "cz;String(32);(可空)@" +
            "sfsfgc;String(32);0：否@" +
            ";;1：是@" +
            ";;(不可空)@" +
            "zgrdbm;String(32);(可空)@" +
            "zgrdzt;String(32);(可空)@" +
            "zgrdsj;String(32);yyyy-MM-ss@" +
            ";;(可空)@" +
            "zdmj;decimal(10,4);单位：平方米@" +
            ";;默认0@" +
            ";;(不可空)@" +
            "cyry;Int;默认0@" +
            ";;(可空)@" +
            "tzgm;Decimal(10,4);单位：万元@" +
            ";;默认0@" +
            ";;(可空)@" +
            "zffc;Decimal(10,4);单位：万元@" +
            ";;默认0@" +
            ";;(可空)@" +
            "lysgl;Decimal(10,3);单位：吨@" +
            ";;默认0@" +
            ";;(可空)@" +
            "lyxsl;Decimal(10,3);单位：吨@" +
            ";;默认0@" +
            ";;(可空)@" +
            "jysr;Decimal(10,4);单位：万元@" +
            ";;默认0@" +
            ";;(可空)@" +
            "ls;Decimal(10,4);单位：万元@" +
            ";;默认0@" +
            ";;(可空)@" +
            "lr;Decimal(10,4);单位：万元@" +
            ";;默认0@" +
            ";;(可空)@" +
            "pscl;int;默认0@" +
            ";;(可空)@" +
            "psnl;Decimal(10,3);单位：吨@" +
            ";;默认0@" +
            ";;(可空)@" +
            "jd;Decimal(10,4);默认0@" +
            ";;(可空)@" +
            "wd;Decimal(10,4);默认0@" +
            ";;(可空)@" +
            "cjsj;String(10);yyyy-MM-dd@" +
            ";;(可空)@" +
            "cjzbm;String(32);(可空)@" +
            "shzt;String(32);(可空)@" +
            "sfsc;String(1);1：删除@" +
            ";;0：不删除(可空)@";



//45
   static  String  CYFZXX="xmbh;String(32);企业代码(18位)+顺序号(6位)@" +
           "xmmc;String(32);(不可空)@" +
           "xmfzr;String(32);(不可空)@" +
           "xmkssj;String(19);yyyy-MM-dd HH:mm:ss@" +
           ";;(不可空)@" +
           "xmjssj;String(19);yyyy-MM-dd HH:mm:ss@" +
           ";;(不可空)@" +
           "gyzcz;Decimal(10,4);单位：万元@" +
           ";;默认0@" +
           ";;(不可空)@" +
           "cpxssr;Decimal(10,4);单位：万元@" +
           ";;默认0@" +
           ";;(不可空)@" +
           "lrze;Decimal(10,4);单位：万元@" +
           ";;默认0@" +
           ";;(不可空)@" +
           "dngdzctz;Decimal(10,4);单位：万元@" +
           ";;默认0@" +
           ";;(不可空)@" +
           "sfsc;String(1);1：删除@" +
           ";;0：不删除(可空)@";

//46LSCHFWXX
static  String  LSCHFWXX="chfwzxs;String(32);行政区划(6位)+顺序号(6位)(不可空)@" +
        "sbssjjpm;String(32);(不可空)@" +
        "sl;int;(不可空)@" +
        "xh;String(32);(不可空)@" +
        "fdmc;String(32);(可空)@" +
        "cpxz;String(32);(不可空)@" +
        "jjxh;String(32);(不可空)@" +
        "sxnjbte;Decimal(10,4);单位：万元@" +
        ";;默认0@" +
        ";;(可空)@" +
        "ztze;Decimal(10,4);单位：万元@" +
        ";;默认0@" +
        ";;(可空)@" +
        "rhgnl;Decimal(10,4);@" +
        "rcll;Decimal(10,4);@" +
        "nhgl;Decimal(10,4);@" +
        "jyccssqk;String(128);@" +
        "sfsc;String(1);1：删除@" +
        ";;0：不删除(可空)@";

    static  String  FGWJYWXX="";



}


/*








 */


