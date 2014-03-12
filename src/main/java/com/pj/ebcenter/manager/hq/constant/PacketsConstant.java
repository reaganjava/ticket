package com.pj.ebcenter.manager.hq.constant;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author 王方威
 * @version 1.0
 */
public class PacketsConstant {
	/**
	 * WSDL完整的报文消息
	 */
	public static String REQUEST_PACKETS ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
										+"<Trade>"
										+"<Head>"
										+"<Version${Version}</Version>"
										+"<SequenceId>${SequenceId}</SequenceId>"
										+"<OfflineAccount>${OfflineAccount}</OfflineAccount>"
										+"<TimeStamp>${TimeStamp}</TimeStamp>"
										+"<Signed>${Signed}</Signed>"
										+"</Head>"
										+"<Body>${Body}</Body>"
										+"</Trade>";
	
	/**
	 * WSDL完整的返回报文消息
	 */
	public static String RESPONSE_PACKETS="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
										+"<Trade>"
										+"<Head>"
										+"<Version>${Version}</Version>"
										+"<TimeStamp>${TimeStamp}</TimeStamp>"
										+"<StatusCode>${StatusCode}</StatusCode>"
										+"<SequenceId>${SequenceId}</SequenceId>"
										+"<Signed>${Signed}</Signed>"
										+"</Head>"
										+"<Body>${Body}</Body>"
										+"</Trade>";
	public static String RESPONSE_CKECKET_BODY="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
										+"<Body>"
										+"<OrderId>${OrderId}</OrderId>"
										+"<VoucherValue>${VoucherValue}</VoucherValue>"
										+"<Status>${Status}</Status>"
										+"<StatusDec>${StatusDec}</StatusDec>"
										+"<OfflineGoodsId>${OfflineGoodsId}</OfflineGoodsId>"
										+"<SalePrice>${SalePrice}</SalePrice>"
										+"<UseStartTime>${UseStartTime}</UseStartTime>"
										+"<UseEndTime>${UseEndTime}</UseEndTime>"
										+"<Message>${Message}</Message>"
										+"</Body>";										
	public static String RESPONSE_PACKETS_BODY="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
												+"<Body>"
												+"<Message>${Message}</Message>"
												+"</Body>";
	
	
	public static String REQUEST_PRODUCT_BODY="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
												+"<Body>"
												+"<GoodsId>${GoodsId}</GoodsId>"
												+"<GoodsName>${GoodsName}</GoodsName>"
												+"<LimitCount>${LimitCount}<LimitCount>"
												+"<ValidityBuyStart>${ValidityBuyStart}</ValidityBuyStart>"
												+"<ValidityBuyEnd>${ValidityBuyEnd}</ValidityBuyEnd>"
												+"<ValidityStart>${ValidityStart}</ValidityStart>"
												+"<ValidityEnd>${ValidityEnd}</ValidityEnd>"
												+"<ValidityDesc>${ValidityDesc}</ValidityDesc>"
												+"<Description>${Description}</Description>"
												+"<GuestPrompt>${GuestPrompt}</GuestPrompt>"
												+"<ListPrice>${ListPrice}</ListPrice>"
												+"<SalesPrice>${SalesPrice}</SalesPrice>"
												+"<ConsumeArea>${ConsumeArea}</ ConsumeArea>"
												+"</Body>";
	
	
	public static String REQUEST_OUTTICKET_NOTICE="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
												+"<Body>"
												+"<VoucherValue>${VoucherValue}</VoucherValue>"
												+"</Body>";
}
