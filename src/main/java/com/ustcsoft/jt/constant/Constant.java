package com.ustcsoft.jt.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @author mapp
 * @des 系统常量类
 * @date 2018/3/21.
 */
public final class Constant {


    /**
     * 服务器异常
     */
    public static final String SERVER_ERROR = "500";
    /**
     * 认证失败code
     */
    public static final String SECURITY_ERROR = "403";
    /**
     * 缓存cache名称
     */
    public static final String USERTOKENCACH = "userTokenCach";
    /**
     * 购销数据zip获取路径
     */
    public static final String ZIP_FILE_PATH = "D:\\szlkjk\\lkxtSend";
    /**
     * 购销数据zip备份路径
     */
    public static final String ZIP_BACKUP_FILE_PATH = "D:\\szlkjk\\backup\\lkxtSend";
    /**
     * 购销数据zip解析图片保存路径
     */
    public static final String IMAGES_FILE_PATH = "D:\\zhwl\\api\\images";
    /**
     * 购销数据zip解析密码
     */
    public static final String ZIP_FILE_PASSWORD = "12345678";

    /**
     * 购销数据zip解析图片路径类别Map
     */
    public static final Map<String, String> ZIP_IMAGES_TYPE = new HashMap<String, String>() {
        private static final long serialVersionUID = 4319890990632094809L;
        {
            put("1", "CYRSFZTX");
            put("2", "KHSFZTX");
            put("3", "JS_1");
            put("4", "CM_1");
            put("5", "CM_2");
            put("6", "CP_1");
            put("7", "CP_2");
        }
    };

    private Constant() {
    }
}
