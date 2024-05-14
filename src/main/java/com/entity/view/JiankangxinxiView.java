package com.entity.view;

import com.entity.JiankangxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 健康信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiankangxinxi")
public class JiankangxinxiView extends JiankangxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 健康情况的值
		*/
		private String jiankangValue;
		/**
		* 体温状况的值
		*/
		private String tiwenValue;



		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 所属单位
			*/
			private String yonghuDanaawei;
			/**
			* 现住址
			*/
			private String yonghuAddress;
			/**
			* 年龄
			*/
			private Integer age;
			/**
			* 所在地区
			*/
			private Integer diquTypes;
				/**
				* 所在地区的值
				*/
				private String diquValue;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public JiankangxinxiView() {

	}

	public JiankangxinxiView(JiankangxinxiEntity jiankangxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 健康情况的值
			*/
			public String getJiankangValue() {
				return jiankangValue;
			}
			/**
			* 设置： 健康情况的值
			*/
			public void setJiankangValue(String jiankangValue) {
				this.jiankangValue = jiankangValue;
			}
			/**
			* 获取： 体温状况的值
			*/
			public String getTiwenValue() {
				return tiwenValue;
			}
			/**
			* 设置： 体温状况的值
			*/
			public void setTiwenValue(String tiwenValue) {
				this.tiwenValue = tiwenValue;
			}












				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 所属单位
					*/
					public String getYonghuDanaawei() {
						return yonghuDanaawei;
					}
					/**
					* 设置： 所属单位
					*/
					public void setYonghuDanaawei(String yonghuDanaawei) {
						this.yonghuDanaawei = yonghuDanaawei;
					}

					/**
					* 获取： 现住址
					*/
					public String getYonghuAddress() {
						return yonghuAddress;
					}
					/**
					* 设置： 现住址
					*/
					public void setYonghuAddress(String yonghuAddress) {
						this.yonghuAddress = yonghuAddress;
					}

					/**
					* 获取： 年龄
					*/
					public Integer getAge() {
						return age;
					}
					/**
					* 设置： 年龄
					*/
					public void setAge(Integer age) {
						this.age = age;
					}

					/**
					* 获取： 所在地区
					*/
					public Integer getDiquTypes() {
						return diquTypes;
					}
					/**
					* 设置： 所在地区
					*/
					public void setDiquTypes(Integer diquTypes) {
						this.diquTypes = diquTypes;
					}


						/**
						* 获取： 所在地区的值
						*/
						public String getDiquValue() {
							return diquValue;
						}
						/**
						* 设置： 所在地区的值
						*/
						public void setDiquValue(String diquValue) {
							this.diquValue = diquValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}


}
