package com.ustcsoft.jt.util;


/**
 * 枚举类
 * @author wang.zhi
 *
 */
public interface BasicEnums {

	// 数据源key
	public static final String DataSource_One = "dataSource1";
	public static final String DataSource_Two = "dataSource2";

	/**
	 * 申请流程
	 * @author wang.zhi
	 *
	 */
	public enum StageEnum {
		Apply(0, "申请"), Verifying(1, "审批中"), Verified(2, "审批通过");

		private Integer value;
		private String name;

		private StageEnum(Integer value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String getNameByValue(Integer value) {
			for (StageEnum s : StageEnum.values()) {
				if (s.value == value) {
					return s.name;
				}
			}
			return "";
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
	
	
	/**
	 * 质检类别
	 * @author wang.zhi
	 *
	 */
	public enum QualityInspectionsEnum {
		
		Initial("初检",0),Inspection("质检",1),Other("其他",2);
		
		private String name;
		private Integer value;
		
		public static String getNameByValue(Integer value){
			for(QualityInspectionsEnum e : QualityInspectionsEnum.values()){
				if(e.value == value){
					return e.name;
				}
			}
			return "";
		}
		
		private QualityInspectionsEnum(String name, Integer value) {
			this.name = name;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		
		
	}

}
