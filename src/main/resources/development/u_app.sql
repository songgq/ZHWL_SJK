/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : u_app

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-05-11 17:37:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_activity
-- ----------------------------
DROP TABLE IF EXISTS `app_activity`;
CREATE TABLE `app_activity` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `title` varchar(100) DEFAULT NULL COMMENT '活动名称',
  `picture_url` varchar(200) DEFAULT NULL COMMENT '活动图片链接',
  `status` char(2) DEFAULT NULL COMMENT '活动状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `active_info` varchar(500) DEFAULT NULL COMMENT '活动详情',
  `address` varchar(200) DEFAULT NULL COMMENT '活动地址',
  `time` varchar(100) DEFAULT NULL COMMENT '活动时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_actual_stock
-- ----------------------------
DROP TABLE IF EXISTS `b_actual_stock`;
CREATE TABLE `b_actual_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse` varchar(255) NOT NULL COMMENT '仓房国标编码',
  `house` varchar(255) NOT NULL COMMENT '仓厫编码',
  `allocation` varchar(255) DEFAULT NULL COMMENT '货位编码',
  `status` int(11) NOT NULL COMMENT '仓库状态',
  `house_store_id` int(11) NOT NULL COMMENT '保管账ID',
  `grain_kind` varchar(255) DEFAULT NULL COMMENT '粮食品种',
  `quantity` int(11) DEFAULT NULL COMMENT '库存数量',
  `grain_attribute` varchar(255) DEFAULT NULL COMMENT '粮食性质',
  `grade` int(11) DEFAULT NULL COMMENT '粮食等级 ',
  `owner` varchar(255) DEFAULT NULL COMMENT '粮权所属',
  `year` int(4) DEFAULT NULL COMMENT '收获年度',
  `dbar_code` varchar(255) DEFAULT NULL COMMENT '库存识别码',
  `house_code` varchar(255) DEFAULT NULL COMMENT '厫间原始编',
  `in_begin_time` datetime DEFAULT NULL COMMENT '入库开始时间',
  `store_begin_time` datetime DEFAULT NULL COMMENT '仓储开始时间',
  `keeper` varchar(255) DEFAULT NULL COMMENT '保管员',
  `origin_place` varchar(255) DEFAULT NULL COMMENT '产地',
  `org_code` varchar(255) NOT NULL COMMENT '库点国标编码',
  `ent_code` varchar(255) NOT NULL COMMENT '企业组织机构代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_aeration
-- ----------------------------
DROP TABLE IF EXISTS `b_aeration`;
CREATE TABLE `b_aeration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse` varchar(50) DEFAULT NULL COMMENT '仓房国标编码',
  `house` varchar(50) DEFAULT NULL COMMENT '仓厫编码',
  `allocation` varchar(50) DEFAULT NULL COMMENT '货位编码',
  `liable_man` varchar(50) DEFAULT NULL COMMENT '负责人',
  `aeration_type_code` varchar(50) DEFAULT NULL COMMENT '通风类型编码',
  `aeration_mode_code` varchar(50) DEFAULT NULL COMMENT '通风方式编码',
  `aeration_machine_code` varchar(50) DEFAULT NULL COMMENT '通风机械编码',
  `aeration_machine` varchar(50) DEFAULT NULL COMMENT '通风机械',
  `aerationgoal_code` varchar(50) DEFAULT NULL COMMENT '通风目的编码',
  `goods_kinds` varchar(50) DEFAULT NULL COMMENT '粮食品种',
  `goods_height` varchar(50) DEFAULT NULL COMMENT '粮层厚度',
  `blowing_intype` varchar(50) DEFAULT NULL COMMENT '送风方式位',
  `sum_electricity` varchar(50) DEFAULT NULL COMMENT '总电耗',
  `sum_blowing_rate` varchar(50) DEFAULT NULL COMMENT '累计总风量',
  `blowernet_drag` varchar(50) DEFAULT NULL COMMENT '风网总阻力',
  `unit_blowing_rate` varchar(50) DEFAULT NULL COMMENT '单位通风量',
  `max_grAdient_degree_begin` varchar(50) DEFAULT NULL COMMENT '最大梯度值开始前温度',
  `max_grAdient_degree_end` varchar(50) DEFAULT NULL COMMENT '最大梯度值开始后温度',
  `max_grAdient_water_begin` varchar(50) DEFAULT NULL COMMENT '最大梯度值开始前水分',
  `max_grAdient_water_end` varchar(50) DEFAULT NULL COMMENT '最大梯度值开始后水分',
  `degree` varchar(50) DEFAULT NULL COMMENT '大气温度',
  `humidity` varchar(50) DEFAULT NULL COMMENT '大气湿度',
  `executive_date` varchar(50) DEFAULT NULL COMMENT '通风执行日期',
  `rdate_regdate` varchar(50) DEFAULT NULL COMMENT '登记日期',
  `blowing_begintime` varchar(50) DEFAULT NULL COMMENT '通风开始时间',
  `blowing_endtime` varchar(50) DEFAULT NULL COMMENT '通风结束时间',
  `original_id` varchar(50) DEFAULT NULL COMMENT '原始记录id',
  `remarks` varchar(50) DEFAULT NULL COMMENT '备注',
  `org_code` varchar(50) NOT NULL,
  `ent_code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ooe` (`original_id`,`org_code`,`ent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='机械通风信息';

-- ----------------------------
-- Table structure for b_aeration_job
-- ----------------------------
DROP TABLE IF EXISTS `b_aeration_job`;
CREATE TABLE `b_aeration_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `outside_degree` varchar(50) DEFAULT NULL COMMENT '大气温度°C',
  `outside_humidity` varchar(50) DEFAULT NULL COMMENT '大气湿度%',
  `begin_goods_degree` varchar(50) DEFAULT NULL COMMENT '通风前粮食温度°C',
  `end_goods_degree` varchar(50) DEFAULT NULL COMMENT '通风后粮食温度°C',
  `begin_goods_water` varchar(50) DEFAULT NULL COMMENT '通风前粮食水分',
  `end_goods_water` varchar(50) DEFAULT NULL COMMENT '通风后粮食水分',
  `aeration_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='通风作业';

-- ----------------------------
-- Table structure for b_drug_manage
-- ----------------------------
DROP TABLE IF EXISTS `b_drug_manage`;
CREATE TABLE `b_drug_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_code` varchar(50) DEFAULT NULL COMMENT '药品编码',
  `drug_name` varchar(50) DEFAULT NULL COMMENT '药品名称',
  `drug_type` varchar(50) DEFAULT NULL COMMENT '药品剂型',
  `units` varchar(50) DEFAULT NULL COMMENT '单位',
  `specifications` varchar(120) DEFAULT NULL COMMENT '规格描述',
  `buy_count` decimal(10,2) DEFAULT NULL COMMENT '购入数量',
  `receive_count` decimal(10,2) DEFAULT NULL COMMENT '领取数量',
  `surplus_count` decimal(10,2) DEFAULT NULL COMMENT '剩余数量',
  `production_date` varchar(50) DEFAULT NULL COMMENT '生产日期',
  `expire_date` varchar(50) DEFAULT NULL COMMENT '过期日期',
  `control_man` varchar(20) DEFAULT NULL COMMENT '监管责任人',
  `original_id` varchar(50) DEFAULT NULL COMMENT '原始记录id',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `org_code` varchar(50) DEFAULT NULL COMMENT '库点国标编码',
  `ent_code` varchar(50) DEFAULT NULL COMMENT '企业组织机构代码',
  `batch_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ooe` (`original_id`,`org_code`,`ent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='药品信息';

-- ----------------------------
-- Table structure for b_drug_manage_detail
-- ----------------------------
DROP TABLE IF EXISTS `b_drug_manage_detail`;
CREATE TABLE `b_drug_manage_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_type` int(4) DEFAULT NULL COMMENT '业务类型',
  `business_typename` varchar(50) DEFAULT NULL COMMENT '业务类型名称',
  `business_count` decimal(10,2) DEFAULT NULL COMMENT '业务数量',
  `balance_count` decimal(10,2) DEFAULT NULL COMMENT '结存数量',
  `emptyhanding_count` decimal(10,2) DEFAULT NULL COMMENT '空瓶处理数量',
  `business_man` varchar(50) DEFAULT NULL COMMENT '领购人',
  `business_time` varchar(50) DEFAULT NULL COMMENT '业务时间',
  `business_cause` varchar(255) DEFAULT NULL COMMENT '业务原因',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `production_date` varchar(50) DEFAULT NULL,
  `expire_date` varchar(50) DEFAULT NULL,
  `drug_id` varchar(50) DEFAULT NULL,
  `control_man` varchar(50) DEFAULT NULL,
  `use_man` varchar(50) DEFAULT NULL,
  `drug_manage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='药品管理详情';

-- ----------------------------
-- Table structure for b_equipment
-- ----------------------------
DROP TABLE IF EXISTS `b_equipment`;
CREATE TABLE `b_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_group_id` varchar(50) NOT NULL COMMENT '设备类型大分类',
  `type_name` varchar(50) NOT NULL COMMENT '设备类型名称',
  `type_des` varchar(100) DEFAULT NULL COMMENT '设备规格描述',
  `measuring_unit_code` varchar(50) NOT NULL COMMENT '计量单位编码',
  `original_id` varchar(50) DEFAULT NULL COMMENT '原始记录ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `etm` (`equipment_group_id`,`type_name`,`measuring_unit_code`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_equipment_manage
-- ----------------------------
DROP TABLE IF EXISTS `b_equipment_manage`;
CREATE TABLE `b_equipment_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_name` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `measuring_unit_code` varchar(50) DEFAULT NULL COMMENT '计量单位编码',
  `equipment_group_id` varchar(50) DEFAULT NULL COMMENT '设备类型大分类',
  `equipment_model` varchar(50) DEFAULT NULL COMMENT '设备型号',
  `equipment_spec` varchar(50) DEFAULT NULL COMMENT '设备规格',
  `equipment_state` varchar(50) DEFAULT NULL COMMENT '设备状态',
  `manufacturer` varchar(50) DEFAULT NULL COMMENT '生产厂家',
  `procurement_price` varchar(50) DEFAULT NULL COMMENT '采购价格',
  `equipment_des` varchar(50) DEFAULT NULL COMMENT '设备描述',
  `euipment_user` varchar(50) DEFAULT NULL COMMENT '设备管理者',
  `work_time_rated` varchar(50) DEFAULT NULL COMMENT '额定工作时间',
  `work_time_single` varchar(50) DEFAULT NULL COMMENT '单次工作时间',
  `purchase_time` varchar(50) DEFAULT NULL COMMENT '采购时间',
  `maintenance_period_day` varchar(50) DEFAULT NULL COMMENT '检定周期(日)',
  `current_period_work_hour` varchar(50) DEFAULT NULL COMMENT '当前周期工作时间(小时)',
  `next_maintenance_date` varchar(50) DEFAULT NULL COMMENT '预计检定日期',
  `maintenance_alarm_date` varchar(50) DEFAULT NULL COMMENT '检定提醒日期',
  `end_mainttenace_date` varchar(50) DEFAULT NULL COMMENT '最后一次维护日期',
  `work_time_total` varchar(50) DEFAULT NULL COMMENT '累计工作时间',
  `life_length_hour` varchar(50) DEFAULT NULL COMMENT '使用寿命(小时)',
  `schedule_abandon_date` varchar(50) DEFAULT NULL COMMENT '预定报废日',
  `abandon_period_use_hour` varchar(50) DEFAULT NULL COMMENT '报废周期(时)',
  `pre_maintenance_alarm_date` varchar(50) DEFAULT NULL COMMENT '报废报警日',
  `equipment_picture` varchar(50) DEFAULT NULL COMMENT '照片',
  `remarks` varchar(50) DEFAULT NULL COMMENT '备注',
  `registrant_time` varchar(50) DEFAULT NULL COMMENT '更新时间',
  `original_id` varchar(50) NOT NULL COMMENT '原始记录id',
  `registrant` varchar(50) DEFAULT NULL COMMENT '登记人',
  `org_code` varchar(50) NOT NULL,
  `ent_code` varchar(50) NOT NULL,
  `equipment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ooe` (`original_id`,`org_code`,`ent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_equipment_manage_maint
-- ----------------------------
DROP TABLE IF EXISTS `b_equipment_manage_maint`;
CREATE TABLE `b_equipment_manage_maint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maint_reason` varchar(255) DEFAULT NULL COMMENT '维护原因',
  `maint_part` varchar(50) DEFAULT NULL COMMENT '维护部位',
  `exe_start_date` varchar(50) DEFAULT NULL COMMENT '实施开始时间',
  `exe_end_date` varchar(50) DEFAULT NULL COMMENT '实施结束时间',
  `registrant` varchar(50) DEFAULT NULL COMMENT '登记人',
  `register_time` varchar(50) DEFAULT NULL COMMENT '登记时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `equipment_manage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='设备维护记录';

-- ----------------------------
-- Table structure for b_fumigating
-- ----------------------------
DROP TABLE IF EXISTS `b_fumigating`;
CREATE TABLE `b_fumigating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_date` varchar(50) DEFAULT NULL COMMENT '申请日期',
  `liable_man` varchar(50) DEFAULT NULL COMMENT '负责人',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `drug_name` varchar(50) DEFAULT NULL COMMENT '药剂名称',
  `drug_kind` varchar(50) DEFAULT NULL COMMENT '药剂类型',
  `expiry_date` varchar(50) DEFAULT NULL COMMENT '有效期',
  `receive_count` decimal(10,2) DEFAULT NULL COMMENT '领取数量',
  `receive_units` varchar(20) DEFAULT NULL COMMENT '药品单位',
  `use_count` decimal(10,2) DEFAULT NULL COMMENT '施药量',
  `use_units` varchar(20) DEFAULT NULL COMMENT '施药量单位',
  `store_place` varchar(50) DEFAULT NULL COMMENT '暂存地点',
  `receive_man` varchar(50) DEFAULT NULL COMMENT '领取人',
  `receive_time` varchar(50) DEFAULT NULL COMMENT '领取时间',
  `fumigate_type` varchar(50) DEFAULT NULL COMMENT '熏蒸方式',
  `type_name` varchar(50) DEFAULT NULL COMMENT '熏蒸方式名称',
  `residues_treated` varchar(200) DEFAULT NULL COMMENT '残渣处理',
  `warn_distance` varchar(50) DEFAULT NULL COMMENT '警戒距离',
  `conserve_advice` text COMMENT '备案机关意见',
  `conserve_time` varchar(50) DEFAULT NULL COMMENT '备案时间',
  `conserver` varchar(50) DEFAULT NULL COMMENT '备案人',
  `write_man` varchar(50) DEFAULT NULL COMMENT '填报人',
  `write_tel` varchar(50) DEFAULT NULL COMMENT '填报人电话',
  `write_email` varchar(50) DEFAULT NULL COMMENT '填报人邮箱',
  `original_id` varchar(50) NOT NULL COMMENT '原始记录id',
  `remarks` text COMMENT '备注',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `org_code` varchar(50) NOT NULL COMMENT '库点国标编码',
  `ent_code` varchar(50) NOT NULL COMMENT '企业组织机构代码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ooe` (`original_id`,`org_code`,`ent_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_fumigating_fumigateman
-- ----------------------------
DROP TABLE IF EXISTS `b_fumigating_fumigateman`;
CREATE TABLE `b_fumigating_fumigateman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `job` varchar(50) DEFAULT NULL COMMENT '职务',
  `credentials` varchar(50) DEFAULT NULL COMMENT '职业资质',
  `bodystatus` varchar(50) DEFAULT NULL COMMENT '身体状态',
  `division` varchar(50) DEFAULT NULL COMMENT '任务分工',
  `isoutworker` varchar(50) DEFAULT NULL COMMENT '是否外请人员',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `fumigating_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_fumigating_fumigateobj
-- ----------------------------
DROP TABLE IF EXISTS `b_fumigating_fumigateobj`;
CREATE TABLE `b_fumigating_fumigateobj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse_gb_code` varchar(50) DEFAULT NULL COMMENT '仓房国际编码',
  `warehouse_gb_code` varchar(50) DEFAULT NULL COMMENT '厫间国际编码',
  `grain_kind` varchar(50) DEFAULT NULL COMMENT '粮食品种',
  `kind_name` varchar(50) DEFAULT NULL COMMENT '粮食品种名称',
  `grain_count` decimal(10,2) DEFAULT NULL COMMENT '粮食数量',
  `packingmode_code` varchar(50) DEFAULT NULL COMMENT '堆装方式编码',
  `pest` varchar(50) DEFAULT NULL COMMENT '当前害虫',
  `pest_density` varchar(50) DEFAULT NULL COMMENT '害虫密度',
  `putin_time` varchar(50) DEFAULT NULL COMMENT '入仓时间',
  `fumigate_lasttiime` varchar(255) DEFAULT NULL COMMENT '上次熏蒸时间',
  `fumigate_plantime` varchar(50) DEFAULT NULL COMMENT '计划熏蒸时间',
  `plandrug_count` varchar(255) DEFAULT NULL COMMENT '计划用药量',
  `plandrug_count_unit` varchar(50) DEFAULT NULL COMMENT '用药单位',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `fumigating_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='熏蒸对象';

-- ----------------------------
-- Table structure for b_gas_concentration
-- ----------------------------
DROP TABLE IF EXISTS `b_gas_concentration`;
CREATE TABLE `b_gas_concentration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse` varchar(50) DEFAULT NULL COMMENT '仓房国标编码',
  `house` varchar(50) DEFAULT NULL COMMENT '仓厫编码',
  `allocation` varchar(50) DEFAULT NULL COMMENT '货位编码',
  `house_store_id` varchar(50) DEFAULT NULL COMMENT '对应保管账id',
  `time` varchar(50) DEFAULT NULL COMMENT '采集时间',
  `points` text COMMENT '个点气体浓度json',
  `org_code` varchar(50) DEFAULT NULL COMMENT '库点国标编码',
  `ent_code` varchar(50) DEFAULT NULL COMMENT '企业组织机构代码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shoe` (`storehouse`,`house`,`org_code`,`ent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_grain_situation
-- ----------------------------
DROP TABLE IF EXISTS `b_grain_situation`;
CREATE TABLE `b_grain_situation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse` varchar(50) NOT NULL COMMENT '仓房国标编码',
  `house` varchar(50) NOT NULL COMMENT '仓厫编码',
  `allocation` varchar(50) DEFAULT NULL COMMENT '货位编码',
  `house_store_id` varchar(50) DEFAULT NULL COMMENT '对应保管账ID ',
  `time` varchar(50) DEFAULT NULL COMMENT '采集时间',
  `in_temp` decimal(10,1) DEFAULT NULL COMMENT '仓内温',
  `in_h` decimal(10,1) DEFAULT NULL COMMENT '仓内湿',
  `out_temp` decimal(10,1) DEFAULT NULL,
  `out_h` decimal(10,1) DEFAULT NULL COMMENT '仓外湿',
  `max_temp` decimal(10,1) DEFAULT NULL COMMENT '最高温',
  `min_temp` decimal(10,1) DEFAULT NULL COMMENT '最低温 ',
  `average_temp` decimal(10,1) DEFAULT NULL COMMENT '平均温',
  `org_code` varchar(50) NOT NULL COMMENT '库点国标编码 ',
  `ent_code` varchar(50) NOT NULL COMMENT '企业组织机构代码',
  `date` varchar(50) DEFAULT NULL COMMENT '记录日期yyyyMMdd',
  `points` text COMMENT '各点粮温数据json',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `shoe` (`storehouse`,`house`,`org_code`,`ent_code`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_grain_temp_point
-- ----------------------------
DROP TABLE IF EXISTS `b_grain_temp_point`;
CREATE TABLE `b_grain_temp_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `temp` decimal(10,1) NOT NULL COMMENT '温度值',
  `x` double NOT NULL COMMENT 'X坐标值',
  `y` double NOT NULL COMMENT 'Y坐标值',
  `z` double NOT NULL COMMENT 'Z坐标值',
  `rod` varchar(255) NOT NULL COMMENT '测温杆编号',
  `point` varchar(255) NOT NULL COMMENT '测温点编号',
  `grain_situation_id` int(11) NOT NULL COMMENT '所属粮情ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_insect_pest
-- ----------------------------
DROP TABLE IF EXISTS `b_insect_pest`;
CREATE TABLE `b_insect_pest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse` varchar(50) DEFAULT NULL COMMENT '仓房国标编码',
  `house` varchar(50) DEFAULT NULL COMMENT '仓厫编码',
  `allocation` varchar(50) DEFAULT NULL COMMENT '货位编码',
  `house_store_id` varchar(50) DEFAULT NULL COMMENT '对应保管账id',
  `time` varchar(50) DEFAULT NULL COMMENT '采集时间',
  `register` varchar(50) DEFAULT NULL COMMENT '记录人',
  `mouldy` double DEFAULT NULL COMMENT '霉变',
  `mouse_sparrow` varchar(50) DEFAULT NULL COMMENT '鼠雀',
  `accident` varchar(50) DEFAULT NULL COMMENT '事故',
  `warehouse_mome` varchar(200) DEFAULT NULL COMMENT '仓库情况',
  `grain_situation` varchar(200) DEFAULT NULL COMMENT '粮情分析',
  `grain_status` varchar(50) DEFAULT NULL COMMENT '粮情状态',
  `points` text COMMENT '各点虫情数据json',
  `insects` text COMMENT '害虫详情',
  `org_code` varchar(50) DEFAULT NULL COMMENT '库点国标编码',
  `ent_code` varchar(50) DEFAULT NULL COMMENT '企业组织机构代码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shoe` (`storehouse`,`house`,`org_code`,`ent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_in_out_flow
-- ----------------------------
DROP TABLE IF EXISTS `b_in_out_flow`;
CREATE TABLE `b_in_out_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse` varchar(100) NOT NULL COMMENT '仓房国标编码',
  `house` varchar(100) NOT NULL COMMENT '仓厫编码',
  `allocation` varchar(255) DEFAULT NULL COMMENT '货位编码',
  `in_out_id` varchar(255) NOT NULL COMMENT '出入库流水单号',
  `in_out_type` varchar(255) NOT NULL COMMENT '出入库类型',
  `date` varchar(50) NOT NULL COMMENT '日期',
  `grain_kind` varchar(255) NOT NULL COMMENT '粮食品种',
  `grain_attribute` varchar(255) DEFAULT NULL COMMENT '粮食性质',
  `grade` varchar(255) DEFAULT NULL COMMENT '粮食等级',
  `unit_price` double DEFAULT NULL COMMENT '单价',
  `gross_weight` int(11) DEFAULT NULL COMMENT '毛重',
  `tare_weight` int(11) DEFAULT NULL COMMENT '皮重',
  `net_weight` int(11) NOT NULL COMMENT '净重 ',
  `deduct_weight` int(11) DEFAULT NULL COMMENT '扣量总计',
  `settle_weight` int(11) NOT NULL COMMENT '结算重量',
  `settle_money` decimal(10,2) DEFAULT NULL COMMENT '结算金额 ',
  `dbar_code` varchar(255) DEFAULT NULL COMMENT '库存识别码',
  `url` varchar(255) DEFAULT NULL COMMENT '视频追溯地址',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `idcard_no` varchar(255) DEFAULT NULL COMMENT '身份证号 ',
  `plate_number` varchar(255) DEFAULT NULL COMMENT '车船号 ',
  `plan_number` varchar(255) DEFAULT NULL,
  `org_code` varchar(255) NOT NULL COMMENT '库点国标编码',
  `ent_code` varchar(255) NOT NULL COMMENT '企业组织机构代码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `ioe` (`in_out_id`,`org_code`,`ent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for b_item
-- ----------------------------
DROP TABLE IF EXISTS `b_item`;
CREATE TABLE `b_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` decimal(10,1) DEFAULT NULL COMMENT '化验项',
  `value` varchar(255) DEFAULT NULL COMMENT '结果值 ',
  `property_id` varchar(36) DEFAULT NULL COMMENT '所属信息ID',
  `type` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ip` (`item`,`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_purchase_documents
-- ----------------------------
DROP TABLE IF EXISTS `b_purchase_documents`;
CREATE TABLE `b_purchase_documents` (
  `uuid` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `djczlx` char(2) DEFAULT NULL COMMENT '单据操作类型',
  `djbh` varchar(32) DEFAULT NULL COMMENT '单据编号',
  `kdmc` varchar(32) DEFAULT NULL COMMENT '库点名称',
  `pinzhong` varchar(32) DEFAULT NULL COMMENT '品种',
  `dj` varchar(32) DEFAULT NULL COMMENT '等级',
  `khmc` varchar(32) DEFAULT NULL COMMENT '客户名称',
  `khsfzh` varchar(32) DEFAULT NULL COMMENT '客户身份证号',
  `khdz` varchar(200) DEFAULT NULL COMMENT '客户地址',
  `cyrxm` varchar(32) DEFAULT NULL COMMENT '承运人姓名',
  `cyrsfzh` varchar(32) DEFAULT NULL COMMENT '承运人身份证号',
  `khlxdh` varchar(32) DEFAULT NULL COMMENT '客户联系电话',
  `rlcfbh` varchar(32) DEFAULT NULL COMMENT '入粮仓房编号',
  `rlhwbh` varchar(32) DEFAULT NULL COMMENT '入粮货位编号',
  `shnd` varchar(32) DEFAULT NULL COMMENT '收获年度',
  `kcxz` varchar(32) DEFAULT NULL COMMENT '库存性质',
  `ywrq` varchar(32) DEFAULT NULL COMMENT '业务日期',
  `xzsj` varchar(32) DEFAULT NULL COMMENT '新增时间',
  `bgsj` varchar(32) DEFAULT NULL COMMENT '变更时间',
  `gb` varchar(32) DEFAULT NULL COMMENT '国别',
  `cd` varchar(32) DEFAULT NULL COMMENT '产地',
  `cch` varchar(32) DEFAULT NULL COMMENT '车船号',
  `mz` decimal(18,2) DEFAULT NULL COMMENT '毛重',
  `pz` decimal(18,2) DEFAULT NULL COMMENT '皮重',
  `qtkl` decimal(18,2) DEFAULT NULL COMMENT '其它扣量',
  `jssl` decimal(18,2) DEFAULT NULL COMMENT '结算数量',
  `rmdjy` varchar(32) DEFAULT NULL COMMENT '入门登记员',
  `cmdjy` varchar(32) DEFAULT NULL COMMENT '出门登记员',
  `mzjjy` varchar(32) DEFAULT NULL COMMENT '毛重检斤员',
  `pzjjy` varchar(32) DEFAULT NULL COMMENT '皮重检斤员',
  `bgy` varchar(32) DEFAULT NULL COMMENT '保管员',
  `qyy` varchar(32) DEFAULT NULL COMMENT '扦样员',
  `jyy` varchar(32) DEFAULT NULL COMMENT '检验员',
  `sf` decimal(18,2) DEFAULT NULL COMMENT '水分',
  `ksfbl` decimal(18,2) DEFAULT NULL COMMENT '扣水分比例',
  `ksfsl` decimal(18,2) DEFAULT NULL COMMENT '扣水分数量',
  `zz` decimal(18,2) DEFAULT NULL COMMENT '杂质',
  `kzzbl` decimal(18,2) DEFAULT NULL COMMENT '扣杂质比例',
  `kzzsl` decimal(18,2) DEFAULT NULL COMMENT '扣杂质数量',
  `bwsl` decimal(18,2) DEFAULT NULL COMMENT '不完善粒',
  `kbwslbl` decimal(18,2) DEFAULT NULL COMMENT '扣不完善粒比例',
  `kbwslsl` decimal(18,2) DEFAULT NULL COMMENT '扣不完善粒数量',
  `rz` decimal(18,2) DEFAULT NULL COMMENT '容重',
  `ccl` decimal(18,2) DEFAULT NULL COMMENT '出糙率',
  `zjml` decimal(18,2) DEFAULT NULL COMMENT '整精米率',
  `kzjmlbl` decimal(18,2) DEFAULT NULL COMMENT '扣整精米率比例',
  `kzjmlsl` decimal(18,2) DEFAULT NULL COMMENT '扣整精米率数量',
  `hlm` decimal(18,2) DEFAULT NULL COMMENT '黄粒米',
  `hlmklbl` decimal(18,2) DEFAULT NULL COMMENT '黄粒米扣量比例',
  `khlmsl` decimal(18,2) DEFAULT NULL COMMENT '扣黄粒米数量',
  `gwcm` decimal(18,2) DEFAULT NULL COMMENT '谷外糙米',
  `gwcmklbl` decimal(18,2) DEFAULT NULL COMMENT '谷外糙米扣量比例',
  `kgwcmsl` decimal(18,2) DEFAULT NULL COMMENT '扣谷外糙米数量',
  `qzkwz` decimal(18,2) DEFAULT NULL COMMENT '其中矿物质',
  `qzkwzklbl` decimal(18,2) DEFAULT NULL COMMENT '其中矿物质扣量比例',
  `kqzkwzsl` decimal(18,2) DEFAULT NULL COMMENT '扣其中矿物质数量',
  `yd` decimal(18,2) DEFAULT NULL COMMENT '硬度',
  `hhl` decimal(18,2) DEFAULT NULL COMMENT '互混率',
  `hhlklbl` decimal(18,2) DEFAULT NULL COMMENT '互混率扣量比例',
  `khhlsl` decimal(18,2) DEFAULT NULL COMMENT '扣互混率数量',
  `sml` decimal(18,2) DEFAULT NULL COMMENT '生霉粒',
  `smlklbl` decimal(18,2) DEFAULT NULL COMMENT '生霉粒扣量比例',
  `ksmlsl` decimal(18,2) DEFAULT NULL COMMENT '扣生霉粒数量',
  `szqw` varchar(16) DEFAULT NULL COMMENT '色泽气味',
  `djzt` char(2) DEFAULT NULL COMMENT '单据状态',
  `bz` varchar(2000) DEFAULT NULL COMMENT '备注',
  `bgyks` decimal(18,2) DEFAULT NULL COMMENT '保管员扣水',
  `bgykz` decimal(18,2) DEFAULT NULL COMMENT '保管员扣杂',
  `xym` varchar(200) DEFAULT NULL COMMENT '校验码',
  `ywlx` varchar(10) DEFAULT NULL,
  `createTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_purchase_sell_zip
-- ----------------------------
DROP TABLE IF EXISTS `b_purchase_sell_zip`;
CREATE TABLE `b_purchase_sell_zip` (
  `uuid` varchar(36) NOT NULL,
  `kdmc` varchar(60) DEFAULT NULL COMMENT '库点名称',
  `bfrq` varchar(30) DEFAULT NULL COMMENT '备份日期',
  `ywlx` varchar(30) DEFAULT NULL COMMENT '业务类型',
  `ysbdz` varchar(200) DEFAULT NULL COMMENT '压缩包地址',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_quality_test
-- ----------------------------
DROP TABLE IF EXISTS `b_quality_test`;
CREATE TABLE `b_quality_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storehouse` varchar(120) NOT NULL COMMENT '仓房国标编码',
  `house` varchar(120) NOT NULL COMMENT '仓厫编码',
  `allocation` varchar(120) DEFAULT NULL COMMENT '货位编码',
  `house_store_id` int(11) NOT NULL COMMENT '对应保管账ID',
  `bill_id` int(11) NOT NULL COMMENT '化验单ID ',
  `date` varchar(50) NOT NULL,
  `grain_kind` varchar(50) NOT NULL COMMENT '粮食品种  ',
  `grade` varchar(50) NOT NULL COMMENT '粮食等级 ',
  `assay_type` int(11) NOT NULL COMMENT '化验类型',
  `org_code` varchar(120) NOT NULL COMMENT '库点国标编码',
  `ent_code` varchar(120) NOT NULL COMMENT '企业组织机构代码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `billId` (`bill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_settlement_documents
-- ----------------------------
DROP TABLE IF EXISTS `b_settlement_documents`;
CREATE TABLE `b_settlement_documents` (
  `uuid` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `djbh` varchar(32) DEFAULT NULL COMMENT '单据编号',
  `pinzhong` varchar(32) DEFAULT NULL COMMENT '品种',
  `dj` varchar(32) DEFAULT NULL COMMENT '等级',
  `jssl` decimal(18,2) DEFAULT NULL COMMENT '结算数量',
  `jsdj` decimal(18,5) DEFAULT NULL COMMENT '结算单价',
  `jsjk` decimal(18,2) DEFAULT NULL COMMENT '结算价款',
  `jsyxm` varchar(32) DEFAULT NULL COMMENT '结算员姓名',
  `jssj` varchar(32) DEFAULT NULL COMMENT '结算时间',
  `khmc` varchar(32) DEFAULT NULL COMMENT '客户名称',
  `dyrkdbh` varchar(100) DEFAULT NULL COMMENT '对应入库单编号',
  `xym` varchar(200) DEFAULT NULL COMMENT '校验码',
  `createTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_storehouse
-- ----------------------------
DROP TABLE IF EXISTS `b_storehouse`;
CREATE TABLE `b_storehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `org_code` varchar(255) DEFAULT NULL COMMENT '库点国标编码',
  `ent_code` varchar(255) DEFAULT NULL COMMENT '企业组织机构代码',
  `house` varchar(255) DEFAULT NULL COMMENT '仓厫编码',
  `allocation` varchar(255) DEFAULT NULL COMMENT '货位编码',
  `name` varchar(120) DEFAULT NULL COMMENT '厫间/货位名称',
  `structure` varchar(60) DEFAULT NULL COMMENT '仓房结构',
  `state` varchar(60) DEFAULT NULL COMMENT '仓房状态',
  `type` varchar(60) DEFAULT NULL COMMENT '仓房类型',
  `length` double DEFAULT NULL COMMENT '仓房长度',
  `width` double DEFAULT NULL COMMENT '仓房宽度',
  `height` double DEFAULT NULL COMMENT '仓房高度',
  `design_capacity` double DEFAULT NULL COMMENT '仓房设计仓容',
  `actual_capacity` double DEFAULT NULL COMMENT '实际仓容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_system_use
-- ----------------------------
DROP TABLE IF EXISTS `b_system_use`;
CREATE TABLE `b_system_use` (
  `uuid` varchar(36) NOT NULL,
  `type` varchar(50) DEFAULT NULL COMMENT '时间类型',
  `time` varchar(50) DEFAULT NULL COMMENT '上报时间',
  `times` int(11) DEFAULT NULL COMMENT '登陆次数',
  `days` int(11) DEFAULT NULL COMMENT '登陆天数',
  `hours` varchar(50) DEFAULT NULL COMMENT '登录时长',
  `org_code` varchar(50) DEFAULT NULL,
  `ent_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库点信息系统使用记录';

-- ----------------------------
-- Table structure for b_system_use_detail
-- ----------------------------
DROP TABLE IF EXISTS `b_system_use_detail`;
CREATE TABLE `b_system_use_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `add` int(11) DEFAULT NULL COMMENT '新增业务',
  `update` int(11) DEFAULT NULL COMMENT '修改业务',
  `delete` int(11) DEFAULT NULL COMMENT '删除业务',
  `type` int(11) DEFAULT NULL COMMENT '业务类型',
  `system_use_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_video_retrieval
-- ----------------------------
DROP TABLE IF EXISTS `b_video_retrieval`;
CREATE TABLE `b_video_retrieval` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskbatch_no` varchar(50) DEFAULT NULL COMMENT '流水单号',
  `call_time` varchar(50) DEFAULT NULL COMMENT '最后一次截取时间',
  `called_times` int(11) DEFAULT NULL COMMENT '截取次数',
  `status` int(4) DEFAULT NULL COMMENT '是否成功',
  `xml` text COMMENT '视频节点xml',
  `lan_url` varchar(50) DEFAULT NULL COMMENT 'vpn链接地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `org_code` varchar(50) DEFAULT NULL,
  `ent_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `toe` (`taskbatch_no`,`org_code`,`ent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_yuyue
-- ----------------------------
DROP TABLE IF EXISTS `b_yuyue`;
CREATE TABLE `b_yuyue` (
  `id` varchar(36) NOT NULL,
  `gxId` varchar(36) DEFAULT NULL COMMENT '购销计划Id',
  `lspz` varchar(20) DEFAULT NULL COMMENT '粮食品种',
  `yysj` datetime DEFAULT NULL COMMENT '预约时间',
  `yysl` varchar(20) DEFAULT NULL COMMENT '预约数量',
  `sjrkl` varchar(20) DEFAULT NULL COMMENT '实际入库量',
  `status` char(2) DEFAULT NULL COMMENT '预约受理状态 0： 未入库 1：已入库',
  `mlrxm` varchar(20) DEFAULT NULL COMMENT '卖粮人姓名',
  `mlrsjh` varchar(20) DEFAULT NULL COMMENT '卖粮人手机号',
  `cyrxm` varchar(20) DEFAULT NULL COMMENT '承运人姓名',
  `cyrsjh` varchar(20) DEFAULT NULL COMMENT '承运人手机号',
  `cyrsfz` varchar(50) DEFAULT NULL COMMENT '承运人身份证号码',
  `ylcph` varchar(20) DEFAULT NULL COMMENT '运粮车牌号',
  `creater` varchar(36) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `updater` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updateTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` varchar(36) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  `phonenum` varchar(20) DEFAULT NULL,
  `dizhi` varchar(50) DEFAULT NULL,
  `idcard` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='app用户表';
/*=================宋国庆 2018-5-13 start==========================*/
-- ----------------------------
-- Table structure for b_interface_data
-- ----------------------------
DROP TABLE IF EXISTS `b_interface_data`;
CREATE TABLE `b_interface_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `org_code` varchar(50) DEFAULT NULL COMMENT '库点国标编码',
  `ent_code` varchar(50) DEFAULT NULL COMMENT '企业组织机构代码',
  `data_type` int(3) DEFAULT NULL COMMENT '数据类型',
  `return_num` int(3) DEFAULT NULL,
  `check_data` varchar(50) DEFAULT NULL COMMENT 'json大小',
  `create_date` varchar(50) DEFAULT NULL COMMENT '上传时间',
  `json_data_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_interface_data_json
-- ----------------------------
DROP TABLE IF EXISTS `b_interface_data_json`;
CREATE TABLE `b_interface_data_json` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `json_data` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*================宋国庆 2018-5-13 end===========================*/

/*=================宋国庆 2018-5-18 start==========================*/

DROP TABLE IF EXISTS `td_warehousestore`;
CREATE TABLE `td_warehousestore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(100) DEFAULT NULL COMMENT '企业ID',
  `enterprise_code` varchar(100) DEFAULT NULL COMMENT '企业编码',
  `administrative_area` varchar(100) DEFAULT NULL COMMENT '行政区划编码',
  `graindepot_id` varchar(100) DEFAULT NULL COMMENT '库点ID',
  `graindepot_gb_code` varchar(100) DEFAULT NULL COMMENT '库点国标编码',
  `storehouse_id` varchar(100) DEFAULT NULL COMMENT '仓房ID',
  `storehouse_gb_code` varchar(100) DEFAULT NULL COMMENT '仓房国标编码',
  `warehouse_code` varchar(100) DEFAULT NULL COMMENT '厫间编号',
  `warehouse_gb_code` varchar(100) DEFAULT NULL COMMENT '廒间国标编号',
  `grainallocation_code` varchar(100) DEFAULT NULL COMMENT '货位编号',
  `warehouse_store_id` varchar(100) DEFAULT NULL COMMENT '库点保管账ID',
  `grain_kind` varchar(100) DEFAULT NULL COMMENT '粮食品种',
  `grain_attribute` varchar(100) DEFAULT NULL COMMENT '粮食性质',
  `grain_grade` varchar(100) DEFAULT NULL COMMENT '粮食等级',
  `grain_count` int(11) DEFAULT NULL COMMENT '粮食数量',
  `grain_owner` varchar(100) DEFAULT NULL COMMENT '粮权所属',
  `origin_place` varchar(100) DEFAULT NULL COMMENT '粮食产地',
  `grain_year` varchar(100) DEFAULT NULL COMMENT '收货年度',
  `status` varchar(100) DEFAULT NULL COMMENT '状态',
  `in_begin_time` varchar(100) DEFAULT NULL COMMENT '入库开始时间',
  `store_begin_time` varchar(100) DEFAULT NULL COMMENT '仓储开始时间',
  `dbar_code` varchar(100) DEFAULT NULL COMMENT '库存识别码',
  `plan_id` varchar(100) DEFAULT NULL COMMENT '计划ID',
  `record_person` varchar(100) DEFAULT NULL COMMENT '填报人',
  `record_date` varchar(100) DEFAULT NULL COMMENT '填报日期',
  `batch_id` varchar(100) DEFAULT NULL COMMENT '批次号',
  `belong_id` varchar(100) DEFAULT NULL COMMENT '上级机构id',
  `belong_code` varchar(100) DEFAULT NULL COMMENT '上级机构编码',
  `signed_code` varchar(100) DEFAULT NULL COMMENT '代码标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='保管账';

DROP TABLE IF EXISTS `td_warehousestoreassay`;
CREATE TABLE `td_warehousestoreassay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_gb_code` varchar(100) DEFAULT NULL COMMENT '仓厫编码',
  `grainallocation_code` varchar(100) DEFAULT NULL COMMENT '货位编码',
  `warehouse_store_id` varchar(100) DEFAULT NULL COMMENT '库点保管账ID',
  `enterprise_code` varchar(100) DEFAULT NULL COMMENT '企业编码',
  `graindepot_gb_code` varchar(100) DEFAULT NULL COMMENT '库点国标编码',
  `assay_id` varchar(100) DEFAULT NULL COMMENT '化验单号',
  `assay_date` varchar(100) DEFAULT NULL COMMENT '化验时间',
  `grain_kind` varchar(100) DEFAULT NULL COMMENT '粮食品种',
  `grain_grade` varchar(100) DEFAULT NULL COMMENT '粮食等级',
  `assay_type` varchar(100) DEFAULT NULL COMMENT '化验类型',
  `record_person` varchar(100) DEFAULT NULL COMMENT '填报人',
  `record_date` varchar(100) DEFAULT NULL COMMENT '填报日期',
  `batch_id` varchar(100) DEFAULT NULL COMMENT '批次号',
  `belong_id` varchar(100) DEFAULT NULL COMMENT '上级机构id',
  `belong_code` varchar(100) DEFAULT NULL COMMENT '上级机构编码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `assay_id` (`assay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='保管账化验单';

DROP TABLE IF EXISTS `td_warehousestoreassayresult`;
CREATE TABLE `td_warehousestoreassayresult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_store_assay_id` int(11) DEFAULT NULL COMMENT '保管账化验单ID',
  `assay_item_id` varchar(100) DEFAULT NULL COMMENT '化验项目ID',
  `assay_item_name` varchar(100) DEFAULT NULL COMMENT '化验项目名称',
  `assay_item_value` varchar(100) DEFAULT NULL COMMENT '化验项目值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='保管账化验结果';


DROP TABLE IF EXISTS `td_warehousestoredetail`;
CREATE TABLE `td_warehousestoredetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `territory_ID` varchar(100) DEFAULT NULL COMMENT '行政区划ID',
  `territory_code` varchar(100) DEFAULT NULL COMMENT '行政区划编码',
  `enterprise_id` varchar(100) DEFAULT NULL COMMENT '企业ID',
  `enterprise_code` varchar(100) DEFAULT NULL COMMENT '企业编码',
  `graindepot_id` varchar(100) DEFAULT NULL COMMENT '库点ID',
  `graindepot_gb_code` varchar(100) DEFAULT NULL COMMENT '库点国标编码',
  `storehouse_id` varchar(100) DEFAULT NULL COMMENT '仓房ID',
  `storehouse_gb_code` varchar(100) DEFAULT NULL COMMENT '仓房国标编码',
  `warehouse_id` varchar(100) DEFAULT NULL COMMENT '厫间ID',
  `warehouse_gb_code` varchar(100) DEFAULT NULL COMMENT '廒间国标编号',
  `grainallocation_id` varchar(100) DEFAULT NULL COMMENT '货位ID',
  `grainallocation_code` varchar(100) DEFAULT NULL COMMENT '货位编号',
  `warehouse_store_id` varchar(100) DEFAULT NULL COMMENT '库点保管账ID',
  `in_out_id` varchar(100) DEFAULT NULL COMMENT '库点流水单号',
  `in_out_type` varchar(100) DEFAULT NULL COMMENT '业务类型',
  `busyness_date` varchar(100) DEFAULT NULL COMMENT '业务日期',
  `grain_kind` varchar(100) DEFAULT NULL COMMENT '粮食品种',
  `grain_attribute` varchar(100) DEFAULT NULL COMMENT '粮食性质',
  `grain_grade` varchar(100) DEFAULT NULL COMMENT '粮食等级',
  `year` varchar(100) DEFAULT NULL COMMENT '收获年度',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `gross_weight` int(11) DEFAULT NULL COMMENT '毛重',
  `tare_weight` int(11) DEFAULT NULL COMMENT '皮重',
  `count_weight` int(11) DEFAULT NULL COMMENT '净重',
  `deduct_weight` int(11) DEFAULT NULL COMMENT '扣量总计',
  `settle_weight` int(11) DEFAULT NULL COMMENT '结算重量',
  `settle_money` decimal(10,2) DEFAULT NULL COMMENT '结算金额',
  `dbar_code` varchar(100) DEFAULT NULL COMMENT '库存识别码',
  `url` varchar(255) DEFAULT NULL COMMENT '视频追溯地址',
  `customerName` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `IDcardNo` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `plateNumber` varchar(100) DEFAULT NULL COMMENT '车船号',
  `record_person` varchar(100) DEFAULT NULL COMMENT '填报人',
  `record_date` varchar(100) DEFAULT NULL COMMENT '填报日期',
  `batch_id` varchar(100) DEFAULT NULL COMMENT '批次号',
  `belong_id` varchar(100) DEFAULT NULL COMMENT '上级机构id',
  `belong_code` varchar(100) DEFAULT NULL COMMENT '上级机构编码',
  `plan_number` varchar(100) DEFAULT NULL COMMENT '计划号',
  `packingmode_code` varchar(100) DEFAULT NULL COMMENT '堆装方式编码',
  `packingmode` varchar(100) DEFAULT NULL COMMENT '堆装方式',
  `production_place` varchar(100) DEFAULT NULL COMMENT '产地',
  `pound_code` varchar(100) DEFAULT NULL COMMENT '磅单号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `egi` (`enterprise_code`,`graindepot_gb_code`,`in_out_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='出入库流水';


DROP TABLE IF EXISTS `td_warehousestoredetailassay`;
CREATE TABLE `td_warehousestoredetailassay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_storeinfo_detail_id` int(11) DEFAULT NULL COMMENT '出入库流水ID',
  `assay_item_id` varchar(100) DEFAULT NULL COMMENT '化验项目ID',
  `assay_item_name` varchar(100) DEFAULT NULL COMMENT '化验项目名称',
  `assay_item_value` varchar(100) DEFAULT NULL COMMENT '化验项目值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='出入库化验';
/*================宋国庆 2018-5-18 end===========================*/