package com.entity.model;

import com.entity.JiankangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健康信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 唯一编号
     */
    private String jiankangxinxiUuidNumber;


    /**
     * 身高
     */
    private String shengao;


    /**
     * 体重
     */
    private String tizhong;


    /**
     * 健康情况
     */
    private Integer jiankangTypes;


    /**
     * 体温状况
     */
    private Integer tiwenTypes;


    /**
     * 今日体温
     */
    private Double jinritiwen;


    /**
     * 饮食习惯
     */
    private String jiankangxinxiYinshixiguan;


    /**
     * 异常症状
     */
    private String jiankangxinxiYichang;


    /**
     * 其他信息
     */
    private String jiankangxinxiContent;


    /**
     * 录入日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：唯一编号
	 */
    public String getJiankangxinxiUuidNumber() {
        return jiankangxinxiUuidNumber;
    }


    /**
	 * 设置：唯一编号
	 */
    public void setJiankangxinxiUuidNumber(String jiankangxinxiUuidNumber) {
        this.jiankangxinxiUuidNumber = jiankangxinxiUuidNumber;
    }
    /**
	 * 获取：身高
	 */
    public String getShengao() {
        return shengao;
    }


    /**
	 * 设置：身高
	 */
    public void setShengao(String shengao) {
        this.shengao = shengao;
    }
    /**
	 * 获取：体重
	 */
    public String getTizhong() {
        return tizhong;
    }


    /**
	 * 设置：体重
	 */
    public void setTizhong(String tizhong) {
        this.tizhong = tizhong;
    }
    /**
	 * 获取：健康情况
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }


    /**
	 * 设置：健康情况
	 */
    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 获取：体温状况
	 */
    public Integer getTiwenTypes() {
        return tiwenTypes;
    }


    /**
	 * 设置：体温状况
	 */
    public void setTiwenTypes(Integer tiwenTypes) {
        this.tiwenTypes = tiwenTypes;
    }
    /**
	 * 获取：今日体温
	 */
    public Double getJinritiwen() {
        return jinritiwen;
    }


    /**
	 * 设置：今日体温
	 */
    public void setJinritiwen(Double jinritiwen) {
        this.jinritiwen = jinritiwen;
    }
    /**
	 * 获取：饮食习惯
	 */
    public String getJiankangxinxiYinshixiguan() {
        return jiankangxinxiYinshixiguan;
    }


    /**
	 * 设置：饮食习惯
	 */
    public void setJiankangxinxiYinshixiguan(String jiankangxinxiYinshixiguan) {
        this.jiankangxinxiYinshixiguan = jiankangxinxiYinshixiguan;
    }
    /**
	 * 获取：异常症状
	 */
    public String getJiankangxinxiYichang() {
        return jiankangxinxiYichang;
    }


    /**
	 * 设置：异常症状
	 */
    public void setJiankangxinxiYichang(String jiankangxinxiYichang) {
        this.jiankangxinxiYichang = jiankangxinxiYichang;
    }
    /**
	 * 获取：其他信息
	 */
    public String getJiankangxinxiContent() {
        return jiankangxinxiContent;
    }


    /**
	 * 设置：其他信息
	 */
    public void setJiankangxinxiContent(String jiankangxinxiContent) {
        this.jiankangxinxiContent = jiankangxinxiContent;
    }
    /**
	 * 获取：录入日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
