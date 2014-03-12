package com.pj.ebcenter.manager.hq.entity;
/**
 * 
 * <p>Description: 商品扩展表</p>
 * @date 2013-11-22
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class GoodsExt {
	/**
	 * 主键Id
	 */
	private Long goodsExtNo;
	
	/**
	 * 商品ID
	 */
	private String goodsId;
	
	/**
	 * 最小参团人数
	 */
	private Integer groupMinNumber;
	
	/**
	 * 参团人数少于该属性则无需复核
	 */
	private Integer groupLessNumber;
	
	/**
	 * 资料审核内容类型
	 */
	private Integer groupCheckDataType;
	
	/**
	 * 床型
	 */
	private String hotelRoomBedType;
	
	/**
	 * 床宽
	 */
	private Double hotelRoomBedWidth;
	
	/**
	 * 房间属性，json格式存储。{filed:1,filed2:0,filed3:1......}
	 */
	private String hotelRoomAttribute;
	
	/**
	 * hotelRoomAttribute 的数字、数组 ,由“，”转换
	 */
	private String[] hotelRoomAttributeArr;
	
	/**
	 * 入住人数
	 */
	private Integer hotelRoomStayNumber;
	
	/**
	 * 房型
	 */
	private String hotelRoomType;
	
	/**
	 * 高尔夫球洞
	 */
	private Integer golfHole;
	
	/**
	 * 高尔夫球场类型
	 */
	private Integer golfMuseumType;
	
	/**
	 * 包含的服务，json格式存储。{filed:1,filed2:0,filed3:1......}
	 */
	private String golfContainService;
	
	/**
	 * 特殊票种：0否，1老人票，2儿童票
	 */
	private Integer specialType;
	
	/**
	 * 重要提示
	 */
	private String goodsTip;
	
	/**
	 * 商品介绍
	 */
	private String goodsIntro;
	
	/**
	 * 交通信息
	 */
	private String transInfo;
	
	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 早餐类型
	 */
	private Integer hotelRoomBrkType;
	
	public GoodsExt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the goodsExtNo
	 */
	public Long getGoodsExtNo() {
		return goodsExtNo;
	}

	/**
	 * @param goodsExtNo the goodsExtNo to set
	 */
	public void setGoodsExtNo(Long goodsExtNo) {
		this.goodsExtNo = goodsExtNo;
	}

	/**
	 * @return the goodsId
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId the goodsId to set
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * @return the groupMinNumber
	 */
	public Integer getGroupMinNumber() {
		return groupMinNumber;
	}

	/**
	 * @param groupMinNumber the groupMinNumber to set
	 */
	public void setGroupMinNumber(Integer groupMinNumber) {
		this.groupMinNumber = groupMinNumber;
	}

	/**
	 * @return the groupLessNumber
	 */
	public Integer getGroupLessNumber() {
		return groupLessNumber;
	}

	/**
	 * @param groupLessNumber the groupLessNumber to set
	 */
	public void setGroupLessNumber(Integer groupLessNumber) {
		this.groupLessNumber = groupLessNumber;
	}

	/**
	 * @return the groupCheckDataType
	 */
	public Integer getGroupCheckDataType() {
		return groupCheckDataType;
	}

	/**
	 * @param groupCheckDataType the groupCheckDataType to set
	 */
	public void setGroupCheckDataType(Integer groupCheckDataType) {
		this.groupCheckDataType = groupCheckDataType;
	}

	/**
	 * @return the hotelRoomBedType
	 */
	public String getHotelRoomBedType() {
		return hotelRoomBedType;
	}

	/**
	 * @param hotelRoomBedType the hotelRoomBedType to set
	 */
	public void setHotelRoomBedType(String hotelRoomBedType) {
		this.hotelRoomBedType = hotelRoomBedType;
	}

	/**
	 * @return the hotelRoomBedWidth
	 */
	public Double getHotelRoomBedWidth() {
		return hotelRoomBedWidth;
	}

	/**
	 * @param hotelRoomBedWidth the hotelRoomBedWidth to set
	 */
	public void setHotelRoomBedWidth(Double hotelRoomBedWidth) {
		this.hotelRoomBedWidth = hotelRoomBedWidth;
	}

	/**
	 * @return the hotelRoomAttribute
	 */
	public String getHotelRoomAttribute() {
		return hotelRoomAttribute;
	}

	/**
	 * @param hotelRoomAttribute the hotelRoomAttribute to set
	 */
	public void setHotelRoomAttribute(String hotelRoomAttribute) {
		if(hotelRoomAttribute!=null){
			this.hotelRoomAttributeArr = hotelRoomAttribute.split(",");
		}
		this.hotelRoomAttribute = hotelRoomAttribute;
	}

	/**
	 * @return the hotelRoomStayNumber
	 */
	public Integer getHotelRoomStayNumber() {
		return hotelRoomStayNumber;
	}

	/**
	 * @param hotelRoomStayNumber the hotelRoomStayNumber to set
	 */
	public void setHotelRoomStayNumber(Integer hotelRoomStayNumber) {
		this.hotelRoomStayNumber = hotelRoomStayNumber;
	}

	/**
	 * @return the hotelRoomType
	 */
	public String getHotelRoomType() {
		return hotelRoomType;
	}

	/**
	 * @param hotelRoomType the hotelRoomType to set
	 */
	public void setHotelRoomType(String hotelRoomType) {
		this.hotelRoomType = hotelRoomType;
	}

	/**
	 * @return the golfHole
	 */
	public Integer getGolfHole() {
		return golfHole;
	}

	/**
	 * @param golfHole the golfHole to set
	 */
	public void setGolfHole(Integer golfHole) {
		this.golfHole = golfHole;
	}

	/**
	 * @return the golfMuseumType
	 */
	public Integer getGolfMuseumType() {
		return golfMuseumType;
	}

	/**
	 * @param golfMuseumType the golfMuseumType to set
	 */
	public void setGolfMuseumType(Integer golfMuseumType) {
		this.golfMuseumType = golfMuseumType;
	}

	/**
	 * @return the golfContainService
	 */
	public String getGolfContainService() {
		return golfContainService;
	}

	/**
	 * @param golfContainService the golfContainService to set
	 */
	public void setGolfContainService(String golfContainService) {
		this.golfContainService = golfContainService;
	}

	/**
	 * @return the specialType
	 */
	public Integer getSpecialType() {
		return specialType;
	}

	/**
	 * @param specialType the specialType to set
	 */
	public void setSpecialType(Integer specialType) {
		this.specialType = specialType;
	}

	/**
	 * @return the goodsTip
	 */
	public String getGoodsTip() {
		return goodsTip;
	}

	/**
	 * @param goodsTip the goodsTip to set
	 */
	public void setGoodsTip(String goodsTip) {
		this.goodsTip = goodsTip;
	}

	/**
	 * @return the goodsIntro
	 */
	public String getGoodsIntro() {
		return goodsIntro;
	}

	/**
	 * @param goodsIntro the goodsIntro to set
	 */
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}

	/**
	 * @return the transInfo
	 */
	public String getTransInfo() {
		return transInfo;
	}

	/**
	 * @param transInfo the transInfo to set
	 */
	public void setTransInfo(String transInfo) {
		this.transInfo = transInfo;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the hotelRoomBrkType
	 */
	public Integer getHotelRoomBrkType() {
		return hotelRoomBrkType;
	}

	/**
	 * @param hotelRoomBrkType the hotelRoomBrkType to set
	 */
	public void setHotelRoomBrkType(Integer hotelRoomBrkType) {
		this.hotelRoomBrkType = hotelRoomBrkType;
	}

	/**
	 * @return the hotelRoomAttributeArr
	 */
	public String[] getHotelRoomAttributeArr() {
		return hotelRoomAttributeArr;
	}

	/**
	 * @param hotelRoomAttributeArr the hotelRoomAttributeArr to set
	 */
	public void setHotelRoomAttributeArr(String[] hotelRoomAttributeArr) {
		this.hotelRoomAttributeArr = hotelRoomAttributeArr;
	}
}
