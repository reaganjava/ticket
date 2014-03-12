package com.pj.ebcenter.ticket.util;

import org.apache.commons.lang.StringUtils;

/**
 * <p>Description:编号生成器 </p>
 * @date 2013年10月17日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class JournalSeq {

	/**
	 * 
	 * 功能：商品表、获得指定长度的序列
	 * @param seq 序列
	 * @param length 要生成的序列的长度
	 * @return
	 */
   public static String getSpecifiedLengthSeq(String goodsSeq){
	   int length = 6;//生成8位长度的序号
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length-goodsSeq.length();i++){
			sb.append("0");
		}
		sb.append(goodsSeq);
		return sb.toString();
	}
   	/**
   	 * 
   	 * 方法用途: 获取数据库表业务主键<br>
   	 * 实现步骤: <br>
   	 * @param prefix 业务前缀
   	 * @param valueLength 数字位长度
   	 * @param NextVal 数据库自增生成数
   	 * @return
   	 */
   	public static String getTableBusinessId(String prefix,int valueLength, String NextVal){
		StringBuffer sb = new StringBuffer();
		if(!StringUtils.isEmpty(prefix)){
			sb.append(prefix);
		}
		for(int i=0;i<valueLength-NextVal.length();i++){
			sb.append("0");
		}
		sb.append(NextVal);
		return sb.toString();
	}
   	public static void main(String args[]){
   		System.err.println(JournalSeq.getSpecifiedLengthSeq("1000"));
   	}
}
