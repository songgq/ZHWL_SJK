package com.ustcsoft.jt;

import com.ustcsoft.jt.util.HttpUtil;
import com.ustcsoft.jt.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Songgq on 2018/6/21.
 */
public class SjkTest1 {
    public static void main(String[] args) {
        /*String url="http://106.3.145.72:49870/dxp/service/API/QYXX";
        Map map = new HashMap();
        map.put("qydm", "1test ");
        map.put("qymc", "2 ");
        map.put("qylx", "3 ");
        map.put("qyxz", "4 ");
        map.put("yydz", "5 ");
        map.put("lsgx", "6 ");
        map.put("zcsj", "7 ");
        map.put("zczb", "8 ");
        map.put("zcze", "9 ");
        map.put("yzbm", "10 ");
        map.put("fddbr", "11 ");
        map.put("sfzh", "12 ");
        map.put("frsjh", "13 ");
        map.put("qylxr", "14 ");
        map.put("bgdh", "15 ");
        map.put("qylxrdh", "16 ");
        map.put("njgl", "17 ");
        map.put("zyjgpz", "18 ");
        map.put("njyl", "19 ");
        map.put("zyjypz", "20 ");
        map.put("nsgl", "21 ");
        map.put("zysgpz", "22 ");
        map.put("sgxkz", "23 ");
        map.put("sflryjtx", "24 ");
        map.put("zyzj", "25 ");
        map.put("ccrl", "26 ");
        map.put("bgrymd", "27 ");
        map.put("yzrymd", "28 ");
        map.put("jysbmc", "29 ");
        map.put("jlsbmc", "30 ");
        map.put("babh", "31 ");
        map.put("barq", "32 ");
        map.put("jd", "33 ");
        map.put("wd", "34 ");
        map.put("sfsc", "35 ");
        //String url2 = "http://106.3.145.72:49870/dxp/service/DECRYPT";
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id","2n5asdfnaiugb20482g8e9rhf938gh39");
        map2.put("uid","460013");
        map2.put("orderid","adjgkd86ndksngkse9hf9urbvao2rs23");
        map2.put("access_token","");
        map2.put("datalength",JsonUtil.objectToJson(map).length());
        map2.put("data","["+JsonUtil.objectToJson(map)+"]");
        map2.put("digst","001");
        System.out.println(JsonUtil.objectToJson(map2));



        try {
           String a= HttpUtil.doPost(url,JsonUtil.objectToJson(map2));
            System.out.println("a="+a);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        String url="http://36.7.135.172:40015/zhwl-sjk/private/heartBeat";
        String url2="http://127.0.0.7:8080/sjk/private/heartBeat";
        String orderid="ff8080816434c264016434d3285901dc";
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("orderid","adjgkd86ndksngkse9hf9urbvao2rs23");
        map2.put("type","1");
        map2.put("data","21");
        try {
            String a= HttpUtil.doPost(url2,"{\n" +
                    "    \"orderid\": \""+orderid+"\",\n" +
                    "    \"type\": \"1\",\n" +
                    "    \"data\": {\n" +
                    "        \"content\": \"LSCRKXX;LQJCXX\",\n" +
                    "        \"starttime\": \"2015-06-01 00:00:00\",\n" +
                    "        \"endtime\": \"2018-06-26 23:59:59\",\n" +
                    "        \"remark\": \"2018年5月5日定时上传\"\n" +
                    "    }\n" +
                    "}");
            //String b=HttpUtil.doPost(url2,"{\"orderId\":\"8a48c09264347d0201643489d41d002b\",\"type\":\"0\",\"data\":{}}");
            System.out.println("a="+a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
