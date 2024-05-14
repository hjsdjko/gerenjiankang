package com.dao;

import com.entity.JiankangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangxinxiView;

/**
 * 健康信息 Dao 接口
 *
 * @author 
 */
public interface JiankangxinxiDao extends BaseMapper<JiankangxinxiEntity> {

   List<JiankangxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
