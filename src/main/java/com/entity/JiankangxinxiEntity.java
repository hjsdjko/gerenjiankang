package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 健康信息
 *
 * @author 
 * @email
 */
@TableName("jiankangxinxi")
public class JiankangxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangxinxiEntity() {

	}

	public JiankangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 唯一编号
     */
    @TableField(value = "jiankangxinxi_uuid_number")

    private String jiankangxinxiUuidNumber;


    /**
     * 身高
     */
    @TableField(value = "shengao")

    private String shengao;


    /**
     * 体重
     */
    @TableField(value = "tizhong")

    private String tizhong;


    /**
     * 健康情况
     */
    @TableField(value = "jiankang_types")

    private Integer jiankangTypes;


    /**
     * 体温状况
     */
    @TableField(value = "tiwen_types")

    private Integer tiwenTypes;


    /**
     * 今日体温
     */
    @TableField(value = "jinritiwen")

    private Double jinritiwen;


    /**
     * 饮食习惯
     */
    @TableField(value = "jiankangxinxi_yinshixiguan")

    private String jiankangxinxiYinshixiguan;


    /**
     * 异常症状
     */
    @TableField(value = "jiankangxinxi_yichang")

    private String jiankangxinxiYichang;


    /**
     * 其他信息
     */
    @TableField(value = "jiankangxinxi_content")

    private String jiankangxinxiContent;


    /**
     * 录入日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：唯一编号
	 */
    public String getJiankangxinxiUuidNumber() {
        return jiankangxinxiUuidNumber;
    }
    /**
	 * 获取：唯一编号
	 */

    public void setJiankangxinxiUuidNumber(String jiankangxinxiUuidNumber) {
        this.jiankangxinxiUuidNumber = jiankangxinxiUuidNumber;
    }
    /**
	 * 设置：身高
	 */
    public String getShengao() {
        return shengao;
    }
    /**
	 * 获取：身高
	 */

    public void setShengao(String shengao) {
        this.shengao = shengao;
    }
    /**
	 * 设置：体重
	 */
    public String getTizhong() {
        return tizhong;
    }
    /**
	 * 获取：体重
	 */

    public void setTizhong(String tizhong) {
        this.tizhong = tizhong;
    }
    /**
	 * 设置：健康情况
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }
    /**
	 * 获取：健康情况
	 */

    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 设置：体温状况
	 */
    public Integer getTiwenTypes() {
        return tiwenTypes;
    }
    /**
	 * 获取：体温状况
	 */

    public void setTiwenTypes(Integer tiwenTypes) {
        this.tiwenTypes = tiwenTypes;
    }
    /**
	 * 设置：今日体温
	 */
    public Double getJinritiwen() {
        return jinritiwen;
    }
    /**
	 * 获取：今日体温
	 */

    public void setJinritiwen(Double jinritiwen) {
        this.jinritiwen = jinritiwen;
    }
    /**
	 * 设置：饮食习惯
	 */
    public String getJiankangxinxiYinshixiguan() {
        return jiankangxinxiYinshixiguan;
    }
    /**
	 * 获取：饮食习惯
	 */

    public void setJiankangxinxiYinshixiguan(String jiankangxinxiYinshixiguan) {
        this.jiankangxinxiYinshixiguan = jiankangxinxiYinshixiguan;
    }
    /**
	 * 设置：异常症状
	 */
    public String getJiankangxinxiYichang() {
        return jiankangxinxiYichang;
    }
    /**
	 * 获取：异常症状
	 */

    public void setJiankangxinxiYichang(String jiankangxinxiYichang) {
        this.jiankangxinxiYichang = jiankangxinxiYichang;
    }
    /**
	 * 设置：其他信息
	 */
    public String getJiankangxinxiContent() {
        return jiankangxinxiContent;
    }
    /**
	 * 获取：其他信息
	 */

    public void setJiankangxinxiContent(String jiankangxinxiContent) {
        this.jiankangxinxiContent = jiankangxinxiContent;
    }
    /**
	 * 设置：录入日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiankangxinxi{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", jiankangxinxiUuidNumber=" + jiankangxinxiUuidNumber +
            ", shengao=" + shengao +
            ", tizhong=" + tizhong +
            ", jiankangTypes=" + jiankangTypes +
            ", tiwenTypes=" + tiwenTypes +
            ", jinritiwen=" + jinritiwen +
            ", jiankangxinxiYinshixiguan=" + jiankangxinxiYinshixiguan +
            ", jiankangxinxiYichang=" + jiankangxinxiYichang +
            ", jiankangxinxiContent=" + jiankangxinxiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
