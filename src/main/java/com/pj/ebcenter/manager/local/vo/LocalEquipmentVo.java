package com.pj.ebcenter.manager.local.vo;

import java.io.Serializable;

/**
 * 
 * <p>Description: {@link com.pj.ebcenter.entity.Equipment} 在本地服务中使用 </p>
 * @date 2014年1月15日
 * @author 王方威
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class LocalEquipmentVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4375600141831866598L;

	/**
	 * 设备ID
	 * **/
	private String equipmentId;

	/**
	 * 设备编号
	 * **/
	private String equipmentNumber;
	/**
	 * 设备类型
	 * **/
	private String equipmentType;
	/**
	 * 运营商
	 * **/
	private String carrieroperator;
	/**
	 * 设备备注
	 * **/
	private String equipmentRemarks;
	/**
	 * 设备状态：0已启用，1未启用
	 * **/
	private String equipmentStatus;
	/**
	 * 设备同步状态：0已同步，1未同步
	 * **/
	private String equipmentScnizationStatus;
	/**
	 * 商户ID
	 * **/
	private String merchantId;
	/**
	 * 商户名称
	 * **/
	private String merchantName;

	/**
	 * 设备签到状态：0已签到，1未签到
	 * **/
	private String isRegister;

	/**
	 * 连接类型
	 * **/
	private String conectType;
	/**
	 * 设备型号
	 * **/
	private String equipmentModel;
	/**
	 * 景区ID
	 * **/
	private String scenicSpotId;

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getCarrieroperator() {
		return carrieroperator;
	}

	public void setCarrieroperator(String carrieroperator) {
		this.carrieroperator = carrieroperator;
	}

	public String getEquipmentRemarks() {
		return equipmentRemarks;
	}

	public void setEquipmentRemarks(String equipmentRemarks) {
		this.equipmentRemarks = equipmentRemarks;
	}

	public String getEquipmentStatus() {
		return equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public String getEquipmentScnizationStatus() {
		return equipmentScnizationStatus;
	}

	public void setEquipmentScnizationStatus(String equipmentScnizationStatus) {
		this.equipmentScnizationStatus = equipmentScnizationStatus;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getConectType() {
		return conectType;
	}

	public void setConectType(String conectType) {
		this.conectType = conectType;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getScenicSpotId() {
		return scenicSpotId;
	}

	public void setScenicSpotId(String scenicSpotId) {
		this.scenicSpotId = scenicSpotId;
	}

	public String getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(String isRegister) {
		this.isRegister = isRegister;
	}

	@Override
	public String toString() {
		return "LocalEquipmentVo [equipmentId=" + equipmentId + ", equipmentNumber=" + equipmentNumber
				+ ", equipmentType=" + equipmentType + ", carrieroperator=" + carrieroperator + ", equipmentRemarks="
				+ equipmentRemarks + ", equipmentStatus=" + equipmentStatus + ", equipmentScnizationStatus="
				+ equipmentScnizationStatus + ", merchantId=" + merchantId + ", merchantName=" + merchantName
				+ ", isRegister=" + isRegister + ", conectType=" + conectType + ", equipmentModel=" + equipmentModel
				+ ", scenicSpotId=" + scenicSpotId + "]";
	}

}
