package com.ustcsoft.jt;

import com.ustcsoft.jt.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Songgq on 2018/6/22.
 */
public class UtilTest {

    public static void main(String[] args) {
        /*Map map=new HashMap<>();
        map.put("a","1");
        Map map2=new HashMap();
        map2.put("a","2");
        map2.put("b","3");
        map.putAll(map2);
        System.out.println(JsonUtil.objectToJson(map));*/
        String ss="`idx` char(36) NOT NULL COMMENT 'id企业信息',\n" +
                "  `qymc` varchar(200) DEFAULT NULL COMMENT '企业名称',\n" +
                "  `qydm` varchar(200) DEFAULT NULL COMMENT '企业组织机构代码',\n" +
                "  `lsxz` varchar(36) DEFAULT NULL COMMENT '隶属性质',\n" +
                "  `shang_ji_qu_hua` varchar(36) DEFAULT '' COMMENT '企业所属上级区划代码',\n" +
                "  `shang_ji_qu_hua_name` varchar(50) DEFAULT '' COMMENT '企业所属上级区划名称',\n" +
                "  `qi_ye_suo_shu` char(1) DEFAULT '' COMMENT '企业所属',\n" +
                "  `frdb` varchar(200) DEFAULT NULL COMMENT '法定代表人',\n" +
                "  `tel` varchar(200) DEFAULT NULL COMMENT '联系电话',\n" +
                "  `phoneno` varchar(200) DEFAULT NULL COMMENT '手机号码',\n" +
                "  `emaile` varchar(200) DEFAULT NULL COMMENT '邮箱',\n" +
                "  `czhm` varchar(200) DEFAULT NULL COMMENT '传真号码',\n" +
                "  `address` varchar(200) DEFAULT NULL COMMENT '详细地址',\n" +
                "  `longitude` varchar(255) DEFAULT '' COMMENT '经度',\n" +
                "  `latitude` varchar(255) DEFAULT '' COMMENT '纬度',\n" +
                "  `yzbm` varchar(200) DEFAULT NULL COMMENT '邮政编码',\n" +
                "  `qyxz` varchar(200) DEFAULT NULL COMMENT '',\n" +
                "  `lsgx` varchar(36) DEFAULT NULL COMMENT '隶属关系 行政区划',\n" +
                "  `jyfw` varchar(1000) DEFAULT NULL COMMENT '经营范围',\n" +
                "  `zyyw` varchar(800) DEFAULT NULL COMMENT '主营业务：',\n" +
                "  `zcsj` datetime DEFAULT NULL COMMENT '注册时间：',\n" +
                "  `zczb` float DEFAULT NULL COMMENT '注册资本',\n" +
                "  `zrs` int(200) DEFAULT NULL COMMENT '企业总人数',\n" +
                "  `tbr` varchar(200) DEFAULT NULL COMMENT '填表人',\n" +
                "  `qyfzr` varchar(200) DEFAULT NULL COMMENT '企业负责人',\n" +
                "  `tbrq` datetime DEFAULT NULL COMMENT '填表日期',\n" +
                "  `qybh` varchar(200) DEFAULT NULL COMMENT '企业编号',\n" +
                "  `qylb` char(3) DEFAULT NULL COMMENT '企业类别',\n" +
                "  `zhjs` varchar(2000) DEFAULT NULL COMMENT '综合介绍',\n" +
                "  `qyfw` varchar(2000) DEFAULT NULL COMMENT '区域范围',\n" +
                "  `shzt` int(200) DEFAULT NULL COMMENT '',\n" +
                "  `hjslsc` datetime DEFAULT NULL COMMENT '环节受理时长',\n" +
                "  `sheng` varchar(255) DEFAULT NULL COMMENT '省',\n" +
                "  `syslsc` datetime DEFAULT NULL COMMENT '剩余受理时长',\n" +
                "  `shi` varchar(255) DEFAULT '' COMMENT '市',\n" +
                "  `xian` varchar(255) DEFAULT NULL COMMENT '县',\n" +
                "  `qyxzbh` varchar(255) DEFAULT NULL COMMENT '单位性质编号',\n" +
                "  `qyxzmc` varchar(255) DEFAULT NULL COMMENT '单位性质名称',\n" +
                "  `jyywlxbh` varchar(255) DEFAULT NULL COMMENT '经营业务类型编号',\n" +
                "  `jyywlxmc` varchar(255) DEFAULT NULL COMMENT '经营业务类型名称',\n" +
                "  `yqmc` varchar(255) DEFAULT NULL COMMENT '央企名称',\n" +
                "  `fgs` varchar(255) DEFAULT NULL COMMENT '分公司',\n" +
                "  `shr` varchar(255) DEFAULT NULL COMMENT '审核人',\n" +
                "  `tbsj` datetime DEFAULT NULL COMMENT '填报时间',\n" +
                "  `xgsj` datetime DEFAULT NULL COMMENT '修改时间',\n" +
                "  `remark` varchar(255) DEFAULT NULL COMMENT '备注',\n" +
                "  `del_flag` char(1) DEFAULT '0' COMMENT '',\n" +
                "  `sbbs` varchar(255) DEFAULT NULL COMMENT '上报标识',\n" +
                "  `orgId` varchar(36) DEFAULT NULL,\n" +
                "  `province_id` varchar(20) DEFAULT NULL COMMENT '省编码',\n" +
                "  `city_id` varchar(20) DEFAULT NULL COMMENT '市编码',\n" +
                "  `country_id` varchar(20) DEFAULT NULL COMMENT '县编码',\n" +
                "  `is_storage` varchar(20) DEFAULT NULL COMMENT '是否仓储企业',\n" +
                "  `is_emergency` varchar(20) DEFAULT NULL COMMENT 'is_emergency',\n" +
                "  `is_administrative` varchar(20) DEFAULT NULL COMMENT '是否放心粮油',\n" +
                "  `is_valid` varchar(11) DEFAULT NULL COMMENT '是否有效',\n" +
                "  `audit_date` datetime DEFAULT NULL COMMENT '审核日期',\n" +
                "  `business_type` varchar(10) DEFAULT NULL COMMENT '业务类型',\n" +
                "  `relate_type` varchar(10) DEFAULT NULL COMMENT '隶属关系',\n" +
                "  `is_pricemonitoring` varchar(10) DEFAULT NULL COMMENT '是否价格监测点',\n" +
                "  `threeCertificates` varchar(100) DEFAULT NULL COMMENT '三证合一',\n" +
                "  `fun_orientation` varchar(100) DEFAULT NULL COMMENT '功能定位',\n" +
                "  `grant_funds` varchar(100) DEFAULT NULL COMMENT '是否使用政府性补助资金',\n" +
                "  `enterprise_short_name` varchar(100) DEFAULT NULL COMMENT '企业名称简称',\n" +
                "  `create_name` varchar(100) DEFAULT NULL,\n" +
                "  `create_by` varchar(36) DEFAULT NULL,\n" +
                "  `create_date` datetime DEFAULT NULL,\n" +
                "  `update_name` varchar(100) DEFAULT NULL,\n" +
                "  `update_by` varchar(36) DEFAULT NULL,\n" +
                "  `update_date` datetime DEFAULT NULL,\n" +
                "  `organization_code` varchar(20) DEFAULT NULL COMMENT '企业组织机构代码证',\n" +
                "  `org_name` varchar(255) DEFAULT NULL COMMENT '上级机构名称'\n";


            String []sa=ss.split(",");
        for (int i = 0; i <sa.length ; i++) {
          String asa=  sa[i].substring(sa[i].indexOf("`")+1,sa[i].lastIndexOf("`"));
            System.out.println(asa);
        }



String sa2="[{\"lsgx\":\"341323\",\"yzbm\":\"234223\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0557-6847500\",\"fddbr\":\"冯长标\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省宿州市灵璧县大路乡大路街\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"灵璧县新灵粮大路粮食购销有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"587215667\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341802\",\"yzbm\":\"242000\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0563-2061501\",\"fddbr\":\"王忠发\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省宣城市宣州区北郊巷口桥\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"中央储备粮宣城直属库\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"153263370\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341282\",\"yzbm\":\"236500\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0558-4902966\",\"fddbr\":\"胡贯伟\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省阜阳市界首市j靳寨乡\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"界首市靳寨粮站\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"672627631\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340124\",\"yzbm\":\"230031\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"13605513527\",\"fddbr\":\"朱昌保\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省合肥市庐江县同大镇台湾农民创业园\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽省粮油科学研究所\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"595723354\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341004\",\"yzbm\":\"245999\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0559-3582892\",\"fddbr\":\"洪千里\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省黄山市徽州区\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"黄山市徽州粮食购销有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"704955171\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341524\",\"yzbm\":\"237321\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"05642701661\",\"fddbr\":\"姚文祥\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省六安市金寨县江梅路298号\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽金寨国家粮食储备库\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"486268153\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341524\",\"yzbm\":\"237300\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0564-2701660\",\"fddbr\":\"姚文祥\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省六安市金寨县\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"金寨县金丰粮油购销有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"691088928\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341526\",\"yzbm\":\"237431\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0564-6490958\",\"fddbr\":\"胡应生\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省六安市霍邱县\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"叶集试验区建丰粮食储备库有限责任公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"781058343\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341523\",\"yzbm\":\"231300\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"05648025996\",\"fddbr\":\"葛亮\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省六安市舒城县\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽现代粮食物流中心库\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"684956942\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341502\",\"yzbm\":\"237000\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0564-3282499\",\"fddbr\":\"王胜方\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省六安市金安区中储粮大道2号\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽六安红土地粮食产业发展有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"343778607\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340504\",\"yzbm\":\"243000\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0555-2617181\",\"fddbr\":\"潘德满\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省马鞍山市雨山区湖西南路953号\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"马鞍山市粮食集团有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"150506605\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246702\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2811961\",\"fddbr\":\"何宗汉\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县枞阳镇\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"枞阳县粮食收储有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"691096450\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246738\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2511588\",\"fddbr\":\"张旭杰\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县官埠桥镇\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽旭阳米业有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"748915825\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246724\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2933333\",\"fddbr\":\"汪朝龙\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县陈瑶湖镇开发区\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽省朝龙粮油有限责任公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"704941343\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246720\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"13955634797\",\"fddbr\":\"徐刚海\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"枞阳县江海粮油工贸有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"779088519\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246738\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2513456\",\"fddbr\":\"李贤根\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"枞阳县贤民粮油贸易有限责任公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"750978323\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246720\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2993003\",\"fddbr\":\"王孰九\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县老洲镇\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"枞阳县老洲粮油工贸有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"777395160\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246724\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2931368\",\"fddbr\":\"严书生\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县陈瑶湖镇\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"枞阳县金言米业有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"664233085\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246724\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2937333\",\"fddbr\":\"周著红\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省安铜陵枞阳县陈瑶湖工业区\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽省创源粮油有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"684957814\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246724\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2937289\",\"fddbr\":\"黄晔\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县陈瑶湖镇\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽陈瑶湖黄酒有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"796405918\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246723\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-2811961\",\"fddbr\":\"何宗汉\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县陈瑶湖镇\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"枞阳县枞东米业有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"581512273\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"340723\",\"yzbm\":\"246702\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0556-5731007\",\"fddbr\":\"左腾\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省铜陵市枞阳县综合工业园\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽省大地食品有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"2\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"677566276\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341621\",\"yzbm\":\"233600\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0558-7320066\",\"fddbr\":\"李涛\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省亳州市涡阳县涡北涡曹路北侧\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽涡阳省级粮食储备库\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"152100465\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341622\",\"yzbm\":\"233500\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0558-7879888\",\"fddbr\":\"邵玉锋\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省亳州市蒙城县乐土镇葛桥\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽省蒙城县葛桥国家粮食储备库\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"737325467\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341701\",\"yzbm\":\"247000\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"13705668850\",\"fddbr\":\"李繁林\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省池州市长江南路398号\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"池州市生态粮油购销有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"743093068\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341701\",\"yzbm\":\"247210\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0566-5291089\",\"fddbr\":\"张世平\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省池州市东至县大渡口经济开发区\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"池州市天泰粮油储备有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"689778938\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341702\",\"yzbm\":\"247000\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0566-2023686\",\"fddbr\":\"陈玉峰\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省池州市贵池区池阳路139号\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"池州市贵池区平天湖粮食购销有限公司\",\"njyl\":0,\"frsjh\":\"\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"698970550\",\"zyzj\":0,\"wd\":0},{\"lsgx\":\"341501\",\"yzbm\":\"231100\",\"zysgpz\":\"\",\"sgxkz\":\"\",\"sfzh\":\"\",\"nsgl\":0,\"bgdh\":\"0551-66374328\",\"fddbr\":\"邵善胜\",\"zczb\":\"\",\"zcze\":0,\"sfsc\":\"0\",\"qylxrdh\":\"\",\"yydz\":\"安徽省合肥市长丰县双墩镇陈岗\",\"zyjgpz\":\"\",\"njgl\":0,\"qymc\":\"安徽省六安双墩国家粮食储备库\",\"njyl\":0,\"frsjh\":\"13012341234\",\"zyjypz\":\"\",\"zcsj\":\"\",\"qylxr\":\"\",\"qylx\":10,\"qyxzbh\":\"1\",\"jd\":0,\"sflryjtx\":0,\"ccrl\":0,\"qydm\":\"610592963\",\"zyzj\":0,\"wd\":0}]";
        System.out.println(sa2);
    }
}
