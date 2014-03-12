package com.pj.ebcenter.manager.hq.entity;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Description:设备表 </p>
 * @date 2013年10月24日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@XmlRootElement
public class Equipment {
	/**
	 * 设备ID
	 * **/
	private String equipmentId;
	public Equipment() {
	}
	public Equipment(String equipmentId, String equipmentNumber, String equipmentType) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentNumber = equipmentNumber;
		this.equipmentType = equipmentType;
	}
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
	
	
	private Integer isRegister;
	/**
	 * 商户名称
	 * **/
	private String merchantName;
	/**
	 * 连接类型
	 * **/
	private String conectType;
	/**
	 * 设备型号
	 * **/
	private String equipmentModel;
	
	private Integer isSync;
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
	public Integer getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(Integer isRegister) {
		this.isRegister = isRegister;
	}
	public Integer getIsSync() {
		return isSync;
	}
	public void setIsSync(Integer isSync) {
		this.isSync = isSync;
	}
	
}
