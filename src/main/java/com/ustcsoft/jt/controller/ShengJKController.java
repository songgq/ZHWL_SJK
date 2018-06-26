package com.ustcsoft.jt.controller;

import com.alibaba.fastjson.JSON;
import com.ustcsoft.jt.service.ShengJKListService;
import com.ustcsoft.jt.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 省接口测试
 */
@Api(value = "private", description = "省测试接口")
@Controller
@RequestMapping("/private")
public class ShengJKController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ShengJKListService shengJKListService;


    @ApiOperation(value = "省接口POST", notes = "省接口POST", httpMethod = "POST", response = Object.class)
    @RequestMapping(value = "/shengJK", method = RequestMethod.POST)
    @ResponseBody
    public String shengJK(
            @ApiParam(name = "orderid", value = "orderid", required = true) @RequestParam String orderid,
            @ApiParam(name = "startTime", value = "startTime", required = true) @RequestParam String startTime,
            @ApiParam(name = "endTime", value = "endTime", required = true) @RequestParam String endTime
    ) throws Exception {
        List<Map> datas = shengJKListService.getUpQyxx(startTime, endTime);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", UUID.randomUUID().toString().replace("-", ""));
        map.put("uid", "340000");
        map.put("orderid", orderid);
        map.put("access_token", "");
        map.put("datalength", 1);
        //map.put("data", JsonUtil.objectToJson(datas));
        map.put("digst", "");
        System.out.println(JsonUtil.objectToJson(map));
        String a = "";
        String url = "http://106.3.145.72:49871/dxp/service/API/QYXX";
        try {
           /* int sum=0;
            if(datas.size()>100){
                int num=datas.size()/100+1;
                System.out.println(num);

                for (int i = 1; i <num+1 ; i++) {

                    List<Map> lists=datas.subList((i-1)*100,i*100);
                    map.put("data", JsonUtil.objectToJson(lists));
                    System.out.println(sum++);
                   // a = HttpUtil.doPost(url, JsonUtil.objectToJson(map));
                }
            }*/
            System.out.println("a=" + a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * @param st
     * @return
     */
    @RequestMapping(value = "/heartBeat")
    @ResponseBody
    public Map<String, Object> heartBeat(@RequestBody String st) {
        logger.info(st);

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Map pa = (Map) JSON.parse(st);
           String orderid = "";
            if(pa.get("orderid")!=null){
                orderid=pa.get("orderid").toString();
            }
            if(pa.get("orderId")!=null){
                orderid=pa.get("orderId").toString();
            }
            String type = pa.get("type").toString();
            Map<String, String> data = (Map) pa.get("data");
            if (StringUtils.isBlank(orderid)) {
                map.put("code", 500);
                //map.put("msg", "bad data");
            } else {
                if ("1".equals(type)) {
                    // 数据指令
                    logger.info("数据上传结果："+this.set(orderid, data));
                    map.put("code", 200);

                } else if ("0".equals(type)) {
                    // 心跳指令
                    map.put("code", 200);
                }
            }
            logger.info("省结束接口POST:" + "orderid=" + orderid + ";type=" + type + ";data=" + data + "result=" + JsonUtil.objectToJson(map));
        } catch (Exception e) {
            map.put("code", 500);
            e.printStackTrace();
        }
        return map;
    }

    public String set(String orderid, Map<String, String> data) throws Exception {
        //String url = "http://106.3.145.72:49871/dxp/service/API/QYXX";
        //String url = "http://106.3.145.72:49871/dxp/service/API/AJXX";
        //String url = "http://106.3.145.72:49871/dxp/service/API/CFXX";
        //String url = "http://106.3.145.72:49871/dxp/service/API/HWXX";
        String url = "http://106.3.145.72:49871/dxp/service/API/LQJCXX";

        //List<Map> dataList = shengJKListService.getUpQyxx(data.get("starttime"), data.get("endtime"));
        //List<Map> dataList = shengJKListService.getUpAjxx(data.get("starttime"), data.get("endtime"));
        //List<Map> dataList = shengJKListService.getUpCfxx(data.get("starttime"), data.get("endtime"));
       // List<Map> dataList = shengJKListService.getUpHwxx(data.get("starttime"), data.get("endtime"));
       // DataSourceHolder.setDataSource(BasicEnums.DataSource_Two);
        List<Map> dataList = shengJKListService.getUpLqjcxxH(data.get("starttime"), data.get("endtime"));

       // DataSourceHolder.clearDateSource();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", UUID.randomUUID().toString().replace("-", ""));
        map2.put("uid", "340000");
        map2.put("orderid", orderid);
        map2.put("access_token", "");
        map2.put("datalength", dataList.size());
        map2.put("data",  JsonUtil.objectToJson(dataList));
        map2.put("digst", "");
        System.out.println(JsonUtil.objectToJson(map2));
        String a = "";
            int sum=0;
            //a = HttpUtil.doPost(url, JsonUtil.objectToJson(map2));

                int num=dataList.size()/100+1;
                System.out.println(num);

                for (int i = 1; i <num+1 ; i++) {
                    List<Map> lists=dataList.subList((i-1)*100,i*100>dataList.size()?dataList.size():i*100);
                    System.out.println("size:"+(i*100>dataList.size()?dataList.size():i*100));
                    // TODO 粮情详细

                    for (int k = 0; k <lists.size() ; k++) {
                        //System.out.println(lists.get(k).get("lswdzjh").toString());
                        if(lists.get(k).get("lswdzjh")==null){
                            continue;
                        }
                        List<Map> dataList2 = shengJKListService.getUpLqjcxxPointH(lists.get(k).get("lswdzjh").toString());
                        StringBuilder val=new StringBuilder("");
                        for (int j = 0; j <dataList2.size() ; j++) {
                            val.append(dataList2.get(j).get("val"))
                                    .append(","+dataList2.get(j).get("z"))
                                    .append(","+dataList2.get(j).get("x"))
                                    .append(","+dataList2.get(j).get("y")+"|");

                        }
                        if(val.length()>1){

                            val.deleteCharAt(val.length()-1);
                        }
                        //System.out.println("val="+val.toString());
                        lists.get(k).put("lswdzjh",val.toString());
                    }
                    map2.put("data", JsonUtil.objectToJson(lists));
                    sum+=lists.size();
                    System.out.println(sum);
                    a = HttpUtil.doPost(url, JsonUtil.objectToJson(map2));
                    System.out.println("数据上传结果=" + a);
                }
        return a;
    }
}
