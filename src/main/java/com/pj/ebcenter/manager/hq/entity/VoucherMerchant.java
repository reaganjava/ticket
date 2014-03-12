package com.pj.ebcenter.manager.hq.entity;


/**
 * 
 * <p>Description: 凭证商户表实体类</p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class VoucherMerchant {

	/**
	 * 凭证商品表ID 
	 */
	private Long voucherMerchantId;
	
	/**
	 * 凭证序号  
	 */
	private String voucherId;
	
	/**
	 * 商家ID
	 */
	private String merchantId;
	
	/**
	 * 商家名称
	 */
	private String merchantName;
	
	/**
	 * 在该商户里最大使用的次数  
	 */
	private Integer canUseTimes;
	
	/**
	 * 在该商户里已经使用的次数
	 */
	private Integer useTimes;
	
	/**
	 * 景区ID
	 */
	private String scenicSpotId;
	
	/**
	 * 景区名称
	 */
	private String scenicSpotName;
	
	private Integer isSync;
	
	
	public Long getVoucherMerchantId() {
		return voucherMerchantId;
	}

	public void setVoucherMerchantId(Long voucherMerchantId) {
		this.voucherMerchantId = voucherMerchantId;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
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

	public Integer getCanUseTimes() {
		return canUseTimes;
	}

	public void setCanUseTimes(Integer canUseTimes) {
		this.canUseTimes = canUseTimes;
	}

	public Integer getUseTimes() {
		return useTimes;
	}

	public void setUseTimes(Integer useTimes) {
		this.useTimes = useTimes;
	}

	public String getScenicSpotId() {
		return scenicSpotId;
	}

	public void setScenicSpotId(String scenicSpotId) {
		this.scenicSpotId = scenicSpotId;
	}

	public String getScenicSpotName() {
		return scenicSpotName;
	}

	public void setScenicSpotName(String scenicSpotName) {
		this.scenicSpotName = scenicSpotName;
	}

	public Integer getIsSync() {
		return isSync;
	}

	public void setIsSync(Integer isSync) {
		this.isSync = isSync;
	}
	
	

}
