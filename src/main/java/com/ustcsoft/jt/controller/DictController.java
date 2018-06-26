//package com.ustcsoft.jt.controller;
//
//import com.ustcsoft.framework.vo.BaseResult;
//import com.ustcsoft.jt.constant.Constant;
//import com.ustcsoft.jt.service.base.api.CacheService;
//import com.ustcsoft.jt.vo.Dict;
//import com.ustcsoft.jt.vo.YuYueJGVO;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author mapp
// * @des
// * @date 2018/4/8
// */
//@RestController
//@RequestMapping(value = "/dict", produces = "application/json;charset=utf-8")
//@Api(value = "login", description = "数据字典接口")
//public class DictController {
//
//    @Resource
//    private CacheService cacheService;
//
////    /**
////     * 获取粮食品种字典
////     */
////    @ApiOperation(value = "粮食品种字典", notes = "粮食品种字典", httpMethod = "POST", response = Object.class)
////    @RequestMapping(value = "/queryApointResult", method = RequestMethod.POST)
////    public Map<String, Object> queryApointResult(@ApiParam(name = "tokenId", value = "用户token", required = true) @RequestParam String tokenId) {
////
////        Map<String, Object> result = BaseResult.successResult();
////        Map<String, String> lspz = Constant.lsPz();
////        Map<String, String> lsjg = Constant.lsJg();
////
////        List<Dict> lspzList = new ArrayList<>();
////
////        for (String key : lspz.keySet()) {
////            Dict dict = new Dict();
////            dict.setValue(key);
////            dict.setName(lspz.get(key));
////            dict.setLsjg(lsjg.get(key));
////            lspzList.add(dict);
////        }
////
////        result.put("lspzList", lspzList);
////
////        return result;
////    }
//
//    /**
//     * 获取粮食品种字典
//     */
//    @ApiOperation(value = "获取字典", notes = "根据字典类型获取字典集合", httpMethod = "POST", response = Object.class)
//    @RequestMapping(value = "/queryDict", method = RequestMethod.POST)
//    public Map<String, Object> queryDict(@ApiParam(name = "code", value = "字典类型编码", required = true) @RequestParam String code) {
//
//        Map<String, Object> result = BaseResult.successResult();
//
//        List<com.ustcsoft.system.model.Dict> dictList = cacheService.getDictList(code);
//        result.put("lspzList", dictList);
//
//        return result;
//    }
//}
