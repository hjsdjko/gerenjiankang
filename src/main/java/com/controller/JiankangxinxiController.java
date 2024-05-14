
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 健康信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiankangxinxi")
public class JiankangxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(JiankangxinxiController.class);

    @Autowired
    private JiankangxinxiService jiankangxinxiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiankangxinxiService.queryPage(params);

        //字典表数据转换
        List<JiankangxinxiView> list =(List<JiankangxinxiView>)page.getList();
        for(JiankangxinxiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankangxinxiEntity jiankangxinxi = jiankangxinxiService.selectById(id);
        if(jiankangxinxi !=null){
            //entity转view
            JiankangxinxiView view = new JiankangxinxiView();
            BeanUtils.copyProperties( jiankangxinxi , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(jiankangxinxi.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangxinxiEntity jiankangxinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiankangxinxi:{}",this.getClass().getName(),jiankangxinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiankangxinxi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiankangxinxiEntity> queryWrapper = new EntityWrapper<JiankangxinxiEntity>()
            .eq("yonghu_id", jiankangxinxi.getYonghuId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangxinxiEntity jiankangxinxiEntity = jiankangxinxiService.selectOne(queryWrapper);
        if(jiankangxinxiEntity==null){

            if(jiankangxinxi.getJinritiwen()>=36 && jiankangxinxi.getJinritiwen()<=37.2){
                jiankangxinxi.setTiwenTypes(1);
            }else{
                jiankangxinxi.setTiwenTypes(2);
            }

            jiankangxinxi.setInsertTime(new Date());
            jiankangxinxi.setCreateTime(new Date());
            jiankangxinxiService.insert(jiankangxinxi);
            return R.ok();
        }else {
            return R.error(511,"当天已有健康信息记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiankangxinxiEntity jiankangxinxi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiankangxinxi:{}",this.getClass().getName(),jiankangxinxi.toString());


            if(jiankangxinxi.getJinritiwen()>=36 && jiankangxinxi.getJinritiwen()<=37.2){
                jiankangxinxi.setTiwenTypes(1);
            }else{
                jiankangxinxi.setTiwenTypes(2);
            }

            jiankangxinxiService.updateById(jiankangxinxi);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiankangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiankangxinxiEntity> jiankangxinxiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiankangxinxiEntity jiankangxinxiEntity = new JiankangxinxiEntity();
//                            jiankangxinxiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiankangxinxiEntity.setJiankangxinxiUuidNumber(data.get(0));                    //唯一编号 要改的
//                            jiankangxinxiEntity.setShengao(data.get(0));                    //身高 要改的
//                            jiankangxinxiEntity.setTizhong(data.get(0));                    //体重 要改的
//                            jiankangxinxiEntity.setJiankangTypes(Integer.valueOf(data.get(0)));   //健康情况 要改的
//                            jiankangxinxiEntity.setTiwenTypes(Integer.valueOf(data.get(0)));   //体温状况 要改的
//                            jiankangxinxiEntity.setJinritiwen(data.get(0));                    //今日体温 要改的
//                            jiankangxinxiEntity.setJiankangxinxiYinshixiguan(data.get(0));                    //饮食习惯 要改的
//                            jiankangxinxiEntity.setJiankangxinxiYichang(data.get(0));                    //异常症状 要改的
//                            jiankangxinxiEntity.setJiankangxinxiContent("");//详情和图片
//                            jiankangxinxiEntity.setInsertTime(date);//时间
//                            jiankangxinxiEntity.setCreateTime(date);//时间
                            jiankangxinxiList.add(jiankangxinxiEntity);


                            //把要查询是否重复的字段放入map中
                                //唯一编号
                                if(seachFields.containsKey("jiankangxinxiUuidNumber")){
                                    List<String> jiankangxinxiUuidNumber = seachFields.get("jiankangxinxiUuidNumber");
                                    jiankangxinxiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiankangxinxiUuidNumber = new ArrayList<>();
                                    jiankangxinxiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiankangxinxiUuidNumber",jiankangxinxiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //唯一编号
                        List<JiankangxinxiEntity> jiankangxinxiEntities_jiankangxinxiUuidNumber = jiankangxinxiService.selectList(new EntityWrapper<JiankangxinxiEntity>().in("jiankangxinxi_uuid_number", seachFields.get("jiankangxinxiUuidNumber")));
                        if(jiankangxinxiEntities_jiankangxinxiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiankangxinxiEntity s:jiankangxinxiEntities_jiankangxinxiUuidNumber){
                                repeatFields.add(s.getJiankangxinxiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiankangxinxiService.insertBatch(jiankangxinxiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
