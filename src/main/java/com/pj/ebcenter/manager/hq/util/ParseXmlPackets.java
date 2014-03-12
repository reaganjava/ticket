package com.pj.ebcenter.manager.hq.util;

import java.io.StringReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.pj.ebcenter.manager.hq.constant.PacketsTargetConstant;
import com.pj.ebcenter.manager.hq.exception.ParseXmlException;
import com.pj.ebcenter.manager.hq.exception.SignedErrorException;
import com.pj.ebcenter.manager.hq.exception.XmlContentFormatException;
import com.pj.ebcenter.manager.hq.packed.entity.ProductVo;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author あんど おか
 * @version 1.0
 */
public class ParseXmlPackets {

	protected static Logger logger = Logger.getLogger(ParseXmlPackets.class);

	protected static final SimpleDateFormat FORMAT_YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseXmlException, SignedErrorException, XmlContentFormatException {

		// String signed = "20131122012356" + "admin" + "201311221523123" + "P0001" + "北京鸭梨" + "25.6" + "33";
//		// String signed = "10019" + "hqcSource" + "20140212143710000" + "123" + "测试门票1" + "100" + "110";
//		String signed = "1001hqcSource20140212145329512123测试门票1110100";
//
		System.out.println(EncryptUtil.BASE64Encrypt(EncryptUtil.MD5("1001111hqcSource20140212144946432123测试门票1110100")));
		//YzcxOGM0YmQ3ZTU5YjFkZDcyMWYyYzg0NjRmOGI1NDc=
//
//		String a = "OTNQfbWT85zNPpGQLcs+eRyjihRtksCHEwYfFO6lvy4CnyXDE/sRE4hltI+kTbt621djvXhNWLvEPdeLbfYMAMMBCdy9e43+y2AxB1mjPccoMzlYmS7lV3/valsbBmBnLxG+2ILrBwN4gFCq16ZL2JlAWILWqI+XUzavgMoXUskl62Qo+l4+C5Sam6qtntQD0jcGXR8tSGtf8Z3a5tOy253lKaWUZqFksoxA96OzJs7KE32ljfV0IBYc2vkNULiHOBqhieQn+m8dIGoGlC2wH2+BLl+JS6NaT6wNz3K6/OwbsdyiqV5K5Gxe2e+2UW27hJi1OnLl80ibQ28h5srqmBvlFBpr9YQ0/AfcqL/XraF2/m8rII0C3Fb8AgCKR34d/AfcqL/XraEl62Qo+l4+C9T7jASEdIaIjIy0LoCSwCx1Q9Bd1OVtH3ZfUSPyFWXgPYR0yTepTa52ZuDFBjun+6bY8VhxJffgdUPQXdTlbR+Y2+xtyw3qQ425PgThCsEbI8L3quWGovTEJYaSr8FQQltrAGvs2UnYAmg4fvcDuDPwNHSLAeIgnYW8xfA/PQQ1Me1rRrk0Dd1khMlv9oNQstx1s5hjg0+UGRAkNncx0bA7Cr/8Ep6Ct1v0vyiYGvitQcbCXPlprU03n74d6MT8MN6eBXmt0ZaHCjvQj3NPHWKjON12rm21lgHaES7rJnqZ";
//
//		System.out.println(EncryptUtil.DES3Decrypt(EncryptUtil.BASE64Decrypt(a), "Y2Y0NTlkYzMtY2EzOC00OTQ2"));
		// System.out
		// .println(EncryptUtil.DES3Decrypt(
		// EncryptUtil
		// .BASE64Decrypt("OTNQfbWT85zNPpGQLcs+eRyjihRtksCHEwYfFO6lvy4CnyXDE/sRE0tGUBj3r/LdMwot1slM1xmv5h8/fpdU4m1vJyQie+rTyPXTBXOIIFuiAQv20mVzL7fkFSyWCtSBZSPLlsPvxsd7cK5quvoli7cdCA+bL3QvZtZCR9BpCa8Kpv7oWmZ1z3ZfUSPyFWXgSv4o6i+lC5NqZxp05Au9mlb8AgCKR34do3gbbCmjj1ldIVsZ8rO90J3lKaWUZqFkxm1esnI8DKtfXOQMsW3bOMAsuozFDW4dv/HWmZr0bnIl62Qo+l4+C9AcQmvFrX52RakSFc7SGOAdIGoGlC2wHxux3KKpXkrky+G+enyjD9MAtLsuvAU488SzZXY+0kPi+h9jg1i3aO7nnt3iqDX3MXZfUSPyFWXg8+EupstfDnXGCLqGAeO2EC5yETKIDI8bs/ZhtihGDIbqsT/x8RTtfVbELYDvfn1scZRECp/SeaWVS/SrEUDh+3Zm4MUGO6f7BulAqBD9HPKaz4F7uRvGgi4Dj3jgJAxaviGn0fSJ7onpu/lalXvT6etYszQv4wIqeOfxPansURXFqxXNd+mFEGp+uRR77pmwjkDaIzEoA4ztAJwAOuZ6e0DwQzKsYvJf7QCcADrmenvew3y6Y308A0BnoaaK0E3NjkWOU62IhxndJvMMM/FIx2c6zoxZWHJBZ+lkgZlCWRY="),
		// "Y2Y0NTlkYzMtY2EzOC00OTQ2"));

		// <?xml version="1.0"
		// encoding="UTF-8"?><Trade><Head><Version>1</Version><SequenceId>10019</SequenceId><OfflineAccount>hqcSource</OfflineAccount><TimeStamp>20140212143710000</TimeStamp><Signed>NjU5MUExNDZBMkEyRkZDODkyRjExNTNCMzE1NDUyRTY=</Signed></Head><Body>OTNQfbWT85zNPpGQLcs+eRyjihRtksCHEwYfFO6lvy4CnyXDE/sRE0tGUBj3r/LdMwot1slM1xmv5h8/fpdU4m1vJyQie+rTyPXTBXOIIFuiAQv20mVzL7fkFSyWCtSBZSPLlsPvxsd7cK5quvoli7cdCA+bL3QvZtZCR9BpCa8Kpv7oWmZ1z3ZfUSPyFWXgSv4o6i+lC5NqZxp05Au9mlb8AgCKR34do3gbbCmjj1ldIVsZ8rO90J3lKaWUZqFkxm1esnI8DKtfXOQMsW3bOMAsuozFDW4dv/HWmZr0bnIl62Qo+l4+C9AcQmvFrX52RakSFc7SGOAdIGoGlC2wHxux3KKpXkrky+G+enyjD9MAtLsuvAU488SzZXY+0kPi+h9jg1i3aO7nnt3iqDX3MXZfUSPyFWXg8+EupstfDnXGCLqGAeO2EC5yETKIDI8bs/ZhtihGDIbqsT/x8RTtfVbELYDvfn1scZRECp/SeaWVS/SrEUDh+3Zm4MUGO6f7BulAqBD9HPKaz4F7uRvGgi4Dj3jgJAxaviGn0fSJ7onpu/lalXvT6etYszQv4wIqeOfxPansURXFqxXNd+mFEGp+uRR77pmwjkDaIzEoA4ztAJwAOuZ6e0DwQzKsYvJf7QCcADrmenvew3y6Y308A0BnoaaK0E3NjkWOU62IhxndJvMMM/FIx2c6zoxZWHJBZ+lkgZlCWRY=</Body></Trade>

		// <?xml version="1.0"
		// encoding="UTF-8"?><Trade><Head><Version>1</Version><SequenceId>20131122012356</SequenceId><OfflineAccount>admin</OfflineAccount><TimeStamp>201311221523123</TimeStamp><Signed>NkUyQkFGRkI5MDAzOTVENjZDMDU5N0ZBMkFCRjRENDM</Signed></Head><Body>OTNQfbWT85zNPpGQLcs+eRyjihRtksCHEwYfFO6lvy4CnyXDE/sRE4hltI+kTbt621djvXhNWLvEPdeLbfYMAMMBCdy9e43+y2AxB1mjPccoMzlYmS7lV3/valsbBmBnLxG+2ILrBwN4gFCq16ZL2JlAWILWqI+XUzavgMoXUskl62Qo+l4+C5Sam6qtntQD0jcGXR8tSGtf8Z3a5tOy253lKaWUZqFksoxA96OzJs7KE32ljfV0IBYc2vkNULiHOBqhieQn+m8dIGoGlC2wH2+BLl+JS6NaT6wNz3K6/OwbsdyiqV5K5Gxe2e+2UW27hJi1OnLl80ibQ28h5srqmBvlFBpr9YQ0/AfcqL/XraF2/m8rII0C3Fb8AgCKR34d/AfcqL/XraEl62Qo+l4+C9T7jASEdIaIjIy0LoCSwCx1Q9Bd1OVtH3ZfUSPyFWXgPYR0yTepTa52ZuDFBjun+6bY8VhxJffgdUPQXdTlbR+Y2+xtyw3qQ425PgThCsEbI8L3quWGovTEJYaSr8FQQltrAGvs2UnYAmg4fvcDuDPwNHSLAeIgnYW8xfA/PQQ1Me1rRrk0Dd1khMlv9oNQstx1s5hjg0+UGRAkNncx0bA7Cr/8Ep6Ct1v0vyiYGvitQcbCXPlprU03n74d6MT8MJfWHlUJGCdqfva/InxoZLiyyO+qj74Jfb+NSgTrqSuL</Body></Trade>

		// <?xml version="1.0"
		// encoding="UTF-8"?><Trade><Head><Version>1</Version><SequenceId>20131122012356</SequenceId><OfflineAccount>admin</OfflineAccount><TimeStamp>201311221523123</TimeStamp><Signed>/cIAgkDMU5e6Ab0MhMr/GQ==</Signed></Head><Body>OTNQfbWT85zNPpGQLcs+eRyjihRtksCHEwYfFO6lvy4CnyXDE/sRE4hltI+kTbt6JuxDGJOJTJGHPUCGMWgy10f94bFptqahOCuYQknoHIjsYhih3BPnsya+4m73QoSn3IUzNppm2oyPnSnArthvhQOMLudstKgoUzavgMoXUskl62Qo+l4+C5Sam6qtntQDG1ArslajDfvgT/9+6pnRv53lKaWUZqFksoxA96OzJs7KE32ljfV0IBYc2vkNULiHzFMTxnw1Z9MdIGoGlC2wH2+BLl+JS6NaT6wNz3K6/OwbsdyiqV5K5NUu5bweaw4Yapx2bs7qOQ+bQ28h5srqmBvlFBpr9YQ0/AfcqL/XraGNQ28BIdMSN1b8AgCKR34d/AfcqL/XraEl62Qo+l4+CxnESIBgV3xP2VN4BtXe17b1jMzxET5aENIMu2vgUqEqJ7Bt3O+w5SxyBpJvvYP+XaG5fWmnTisTzcCmqG24CzRtY5ydsNUM/gaLQVJZdEPdx5Ci59vpRJTCNYq7JouavTQ8WhgFt7Jc6vwg/Yime+cKiHhp9dXnletYszQv4wIqeOfxPansURXFqxXNd+mFEPsIvCFtveIIxasVzXfphRCKFub5CEEFV+T6KLI3gVOf7QCcADrmenvew3y6Y308A0BnoaaK0E3NjkWOU62IhxndJvMMM/FIx2c6zoxZWHJBZ+lkgZlCWRY=</Body></Trade>

		// <?xml version="1.0"
		// encoding="UTF-8"?><Trade><Head><Version>1</Version><SequenceId>1002</SequenceId><OfflineAccount>hqcSource</OfflineAccount><TimeStamp>20140115144613482</TimeStamp><Signed>NkUyQkFGRkI5MDAzOTVENjZDMDU5N0ZBMkFCRjRENDM</Signed></Head><Body>OTNQfbWT85zNPpGQLcs+eRyjihRtksCHEwYfFO6lvy4CnyXDE/sRE4hltI+kTbt621djvXhNWLvEPdeLbfYMAMMBCdy9e43+y2AxB1mjPccoMzlYmS7lV3/valsbBmBnLxG+2ILrBwN4gFCq16ZL2JlAWILWqI+XUzavgMoXUskl62Qo+l4+C5Sam6qtntQD0jcGXR8tSGtf8Z3a5tOy253lKaWUZqFksoxA96OzJs7KE32ljfV0IBYc2vkNULiHOBqhieQn+m8dIGoGlC2wH2+BLl+JS6NaT6wNz3K6/OwbsdyiqV5K5Gxe2e+2UW27hJi1OnLl80ibQ28h5srqmBvlFBpr9YQ0/AfcqL/XraF2/m8rII0C3Fb8AgCKR34d/AfcqL/XraEl62Qo+l4+C9T7jASEdIaIjIy0LoCSwCx1Q9Bd1OVtH3ZfUSPyFWXgPYR0yTepTa52ZuDFBjun+6bY8VhxJffgdUPQXdTlbR+Y2+xtyw3qQ425PgThCsEbI8L3quWGovTEJYaSr8FQQltrAGvs2UnYAmg4fvcDuDPwNHSLAeIgnYW8xfA/PQQ1Me1rRrk0Dd1khMlv9oNQstx1s5hjg0+UGRAkNncx0bA7Cr/8Ep6Ct1v0vyiYGvitQcbCXPlprU03n74d6MT8MJfWHlUJGCdqfva/InxoZLiyyO+qj74Jfb+NSgTrqSuL</Body></Trade>
		// <?xml version="1.0"
		// encoding="UTF-8"?><Trade><Head><Version>1</Version><SequenceId>1002</SequenceId><OfflineAccount>hqcSource</OfflineAccount><TimeStamp>20140115144613482</TimeStamp>
		// <Signed>NkUyQkFGRkI5MDAzOTVENjZDMDU5N0ZBMkFCRjRENDM=</Signed></Head>
		// <Body>
		// Q/9jvOy6RAV60YD45aHbmXQt4uFh801Jw+w63AhQMeysKVwqIDzRhIvhttE8Lr2+oKDUpbevEgxvXtGvgKga1XEnuPaN+wzbmC9mxP0qYbe6CebjrLBfGaN4G2wpo49ZhoKyeUyh5CG/mq3ZNQLGF8AsuozFDW4dlJqbqq2e1AO699fUwNqwDW+BLl+JS6NaLKIE94Lq9pxf8Z3a5tOy253lKaWUZqFko8/ciT1dIAkimVOvPc6ebM3pXWuoE+xMGTOd2jwZAQ065f/VeGc6w3RCGwtOg1oadl9RI/IVZeBmnNyrDaVSAzWTmE9AE7/7dl9RI/IVZeDb8QrbIQLUV9IMu2vgUqEq0IQrEnX+K/ZyzRYX0uDKj9BNls0/+5tcPD9braOoPiYtHJlfhkjHDSmiaZfIR1oBf1DOFze61LpZn+BaLr1166aFbV6zZ2336PuI6VW0c1dxHxP0SRKOeE/t2G2TDteHpbXWyL7cF9WjPihBJgRhvdyUY5Hcd53m+sNXIRTaC2jb75zd9BDxEsBdpMSbHZD2YWXDyjXlMH4VKS1D1SWfzxWrSVrzbLkrFSktQ9Uln8/oO7sKo9uzFW2kX0w21Fha3SbzDDPxSMcPD8vLEh+yZg==
		// </Body></Trade>

		// System.out
		// .println(EncryptUtil.DES3Decrypt(
		// EncryptUtil
		// .BASE64Decrypt("OTNQfbWT85zNPpGQLcs+eRyjihRtksCHEwYfFO6lvy4CnyXDE/sRExbi4YqWrb3VdVDVkBa3HURNaJR0m/mMhV+/i9yTexlTMDZkHsewrh4="),
		// "Y2Y0NTlkYzMtY2EzOC00OTQ2"));
		// String xmlBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		// + "<Body>"
		// +
		// "<GoodsId>123</GoodsId><GoodsName>测试门票1</GoodsName><LimitCount>10</LimitCount><ValidityBuyStart>2014-01-01</ValidityBuyStart><ValidityBuyEnd>2016-01-01</ValidityBuyEnd><ValidityStart>2014-01-01</ValidityStart><ValidityEnd>2016-01-01</ValidityEnd><ValidityDesc>有效期说明</ValidityDesc><Description>没有说明</Description><GuestPrompt>请保管好随身物品</GuestPrompt><ListPrice>110</ListPrice><SalesPrice>100</SalesPrice><ConsumeArea>1</ConsumeArea>"
		// + "</Body>";
		// // 签名顺序SequenceId，OfflineAccount，TimeStamp， GoodsId， GoodsName，ListPrice，SalesPrice
		// <Version>1</Version><SequenceId>20131122012356</SequenceId><OfflineAccount>admin</OfflineAccount><TimeStamp>201311221523123</TimeStamp>

		// String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		// + ""
		// +
		// "<Trade><Head><Version>1</Version><SequenceId>20131122012356</SequenceId><OfflineAccount>admin</OfflineAccount><TimeStamp>201311221523123</TimeStamp>"
		// + "<Signed>NkUyQkFGRkI5MDAzOTVENjZDMDU5N0ZBMkFCRjRENDM</Signed>" + "</Head>" + "<Body>"
		// + EncryptUtil.BASE64Encrypt(EncryptUtil.DES3Encrypt("Y2Y0NTlkYzMtY2EzOC00OTQ2", xmlBody)) + "</Body>"
		// + "</Trade>";
		//
		// System.out.println("xmlContent: " + xmlContent);
		// Map<String, Object> map = parseDownProduct(xmlContent, "Y2Y0NTlkYzMtY2EzOC00OTQ2");
		//
		// for (String str : map.keySet()) {
		//
		// System.out.println(str + " --- " + map.get(str));
		// }

		String bodyXMl = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<Body>"
				+ "<VoucherValue>V12123</VoucherValue>" + "</Body>";

		String signed = "SEQ0001TTTT201311221523123V12123";

		String xmlBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<Trade>" + "<Head>" + "<Version>1</Version>"
				+ "<SequenceId>SEQ0001</SequenceId>" + "<OfflineAccount>TTTT</OfflineAccount>"
				+ "<TimeStamp>201311221523123</TimeStamp>" + "<Signed>"
				+ EncryptUtil.BASE64Encrypt(EncryptUtil.MD5(signed)) + "</Signed>" + "</Head>" + "<Body>"
				+ EncryptUtil.BASE64Encrypt(EncryptUtil.DES3Encrypt("Y2Y0NTlkYzMtY2EzOC00OTQ2", bodyXMl)) + "</Body>"
				+ "</Trade>";
		System.out.println("xmlBody=====" + xmlBody);
		// Map<String, Object> res = parseCheckETTicket(xmlBody, "Y2Y0NTlkYzMtY2EzOC00OTQ2");
		//
		// for (String str : res.keySet()) {
		//
		// System.out.println(str + " --- " + res.get(str));
		// }

	}

	public static Map<String, Object> parseOutTicketNotice(String xmlContent, String key) throws ParseXmlException,
			SignedErrorException {

		logger.debug(" process in ParseXmlPackets.parseOutTicketNotice method, parameter xmlContent: " + xmlContent);
		Map<String, Object> res = new HashMap<String, Object>();

		InputSource is = null;
		Document doc = null;

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			is = new InputSource();
			is.setCharacterStream(new StringReader(xmlContent));

			doc = db.parse(is);

			// 解析接受到美景天下的报文头XML报文将头信息放入MAP中
			formateRequestPackets(res, doc);

			// 解密XML报文的消息体
			String eccode = EncryptUtil.DES3Decrypt(EncryptUtil.BASE64Decrypt(getCharacterDataFromNodeList(doc
					.getElementsByTagName(PacketsTargetConstant.XML_BODY))), key);

			System.out.println(" parseOutTicketNotice packets body: " + eccode);

			is.setCharacterStream(new StringReader(eccode));
			doc = db.parse(is);

			// 将解析的XML文件封装成OrderInfo对象
			NodeList voucherValueNodes = doc.getElementsByTagName("VoucherValue");

			String voucherValue = getCharacterDataFromElement((Element) voucherValueNodes.item(0));

			// 签名顺序SequenceId，OfflineAccount，TimeStamp， GoodsId， GoodsName，ListPrice，SalesPrice
			String signed = (String) res.get("SequenceId") + (String) res.get("OfflineAccount")
					+ (String) res.get("TimeStamp") + voucherValue;

			// 验证签名
			validateSinged(res, signed);

			// 将解析的报文头放入Map中
			res.put(PacketsTargetConstant.XML_BODY, voucherValue);

			return res;

		} catch (SignedErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new ParseXmlException(e);
		} finally {
			is = null;
			doc = null;
		}

	}

	public static Map<String, Object> parseCheckETTicket(String xmlContent, String key) throws ParseXmlException,
			SignedErrorException {

		logger.debug(" process in ParseXmlPackets.parseCheckETTicket method, parameter xmlContent: " + xmlContent);
		Map<String, Object> res = new HashMap<String, Object>();

		InputSource is = null;
		Document doc = null;

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			is = new InputSource();
			is.setCharacterStream(new StringReader(xmlContent));

			doc = db.parse(is);

			// 解析接受到美景天下的报文头XML报文将头信息放入MAP中
			formateRequestPackets(res, doc);

			// 解密XML报文的消息体
			String eccode = EncryptUtil.DES3Decrypt(EncryptUtil.BASE64Decrypt(getCharacterDataFromNodeList(doc
					.getElementsByTagName(PacketsTargetConstant.XML_BODY))), key);

			System.out.println(" parseCheckETTicket packets body: " + eccode);

			is.setCharacterStream(new StringReader(eccode));
			doc = db.parse(is);

			// 将解析的XML文件封装成OrderInfo对象
			NodeList voucherValueNodes = doc.getElementsByTagName("VoucherValue");

			String voucherValue = getCharacterDataFromElement((Element) voucherValueNodes.item(0));

			// 签名顺序SequenceId，OfflineAccount，TimeStamp， GoodsId， GoodsName，ListPrice，SalesPrice
			String signed = (String) res.get("SequenceId") + (String) res.get("OfflineAccount")
					+ (String) res.get("TimeStamp") + voucherValue;

			// 验证签名
			validateSinged(res, signed);

			// 将解析的报文头放入Map中
			res.put(PacketsTargetConstant.XML_BODY, voucherValue);

			return res;

		} catch (SignedErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new ParseXmlException(e);
		} finally {
			is = null;
			doc = null;
		}

	}

	public static Map<String, Object> parseDownProduct(String xmlContent, String key) throws ParseXmlException,
			SignedErrorException, XmlContentFormatException {

		logger.debug("process in  ParseXmlPackets.parseDownProduct : " + xmlContent+", key: " + key);
		Map<String, Object> res = new HashMap<String, Object>();

		InputSource is = null;
		Document doc = null;

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			is = new InputSource();
			is.setCharacterStream(new StringReader(xmlContent));

			doc = db.parse(is);

			// 解析接受到美景天下的报文头XML报文将头信息放入MAP中
			formateRequestPackets(res, doc);

			// 解密XML报文的消息体
			String eccode = EncryptUtil.DES3Decrypt(EncryptUtil.BASE64Decrypt(getCharacterDataFromNodeList(doc
					.getElementsByTagName(PacketsTargetConstant.XML_BODY))), key);

			logger.debug(" parseDownProduct packets body: " + eccode);

			is.setCharacterStream(new StringReader(eccode));
			doc = db.parse(is);

			// 将解析的XML文件封装成OrderInfo对象
			NodeList goodsIdNodes = doc.getElementsByTagName("GoodsId");
			NodeList goodsNameNodes = doc.getElementsByTagName("GoodsName");

			NodeList refLimitCountNodes = doc.getElementsByTagName("LimitCount");
			NodeList refValidityBuyStartNodes = doc.getElementsByTagName("ValidityBuyStart");
			NodeList refValidityBuyEndNodes = doc.getElementsByTagName("ValidityBuyEnd");
			NodeList refValidityStartNodes = doc.getElementsByTagName("ValidityStart");
			NodeList refValidityEndNodes = doc.getElementsByTagName("ValidityEnd");

			NodeList refValidityDescNodes = doc.getElementsByTagName("ValidityDesc");
			NodeList refDescriptionNodes = doc.getElementsByTagName("Description");
			NodeList refGuestPromptNodes = doc.getElementsByTagName("GuestPrompt");
			NodeList refMarketPriceNodes = doc.getElementsByTagName("ListPrice");
			NodeList refSalesPriceNodes = doc.getElementsByTagName("SalesPrice");
			NodeList refConsumeAreaNodes = doc.getElementsByTagName("ConsumeArea");

			String goodsId = getCharacterDataFromElement((Element) goodsIdNodes.item(0));
			String goodsName = getCharacterDataFromElement((Element) goodsNameNodes.item(0));

			String refLimitCount = getCharacterDataFromElement((Element) refLimitCountNodes.item(0));
			String refValidityBuyStart = getCharacterDataFromElement((Element) refValidityBuyStartNodes.item(0));
			String refValidityBuyEnd = getCharacterDataFromElement((Element) refValidityBuyEndNodes.item(0));
			String refValidityStart = getCharacterDataFromElement((Element) refValidityStartNodes.item(0));
			String refValidityEnd = getCharacterDataFromElement((Element) refValidityEndNodes.item(0));

			String refValidityDesc = getCharacterDataFromElement((Element) refValidityDescNodes.item(0));
			String refGuestPrompt = getCharacterDataFromElement((Element) refGuestPromptNodes.item(0));
			String refDescription = getCharacterDataFromElement((Element) refDescriptionNodes.item(0));
			String refMarketPrice = getCharacterDataFromElement((Element) refMarketPriceNodes.item(0));
			String refSalesPrice = getCharacterDataFromElement((Element) refSalesPriceNodes.item(0));
			String refConsumeArea = getCharacterDataFromElement((Element) refConsumeAreaNodes.item(0));

			ProductVo bodyObj = new ProductVo();
			bodyObj.setRefProductId(goodsId);
			bodyObj.setRefProductName(goodsName);

			try {
				if (refValidityBuyStart != null || !"".equals(refValidityBuyStart)) {
					bodyObj.setRefValidityBuyStart(parse(refValidityBuyStart));
				}
				if (refValidityBuyEnd != null || !"".equals(refValidityBuyEnd)) {
					bodyObj.setRefValidityBuyEnd(parse(refValidityBuyEnd));
				}
				if (refValidityStart != null || !"".equals(refValidityStart)) {
					bodyObj.setRefValidityStart(parse(refValidityStart));
				}
				if (refValidityEnd != null || !"".equals(refValidityEnd)) {
					bodyObj.setRefValidityEnd(parse(refValidityEnd));
				}
				if (refLimitCount == null || "".equals(refLimitCount)) {
					bodyObj.setRefLimitCount(0);
				} else {
					bodyObj.setRefLimitCount(Integer.valueOf(refLimitCount));
				}
			} catch (Exception e) {
				logger.error(" format XML content happen Exception", e);
				throw new XmlContentFormatException();
			}

			bodyObj.setRefConsumeArea(refConsumeArea);
			bodyObj.setRefDescription(refDescription);
			bodyObj.setRefGuestPrompt(refGuestPrompt);
			bodyObj.setRefValidityDesc(refValidityDesc);
			bodyObj.setRefSalesPrice(refSalesPrice);
			bodyObj.setRefMarketPrice(refMarketPrice);
			// 签名顺序SequenceId，OfflineAccount，TimeStamp， GoodsId， GoodsName，ListPrice，SalesPrice
			String signed = (String) res.get("SequenceId") + (String) res.get("OfflineAccount")
					+ (String) res.get("TimeStamp") + bodyObj.getRefProductId() + bodyObj.getRefProductName()
					+ bodyObj.getRefMarketPrice() + bodyObj.getRefSalesPrice();

			// 验证签名
			validateSinged(res, signed);

			// 将解析的报文头放入Map中
			res.put(PacketsTargetConstant.XML_BODY, bodyObj);

			return res;

		} catch (SignedErrorException e) {
			throw e;
		} catch (XmlContentFormatException e) {
			throw e;
		} catch (Exception e) {
			throw new ParseXmlException(e);
		} finally {
			is = null;
			doc = null;
		}

	}

	private static Timestamp parse(String date) throws ParseException {
		return new Timestamp(FORMAT_YYYY_MM_DD.parse(date).getTime());
	}

	/** 
	 * 方法用途:验证报文返回的签名 <br>
	 * 实现步骤: <br>
	 * @param res
	 * @param signed
	 * @throws SignedErrorException   
	 */
	private static void validateSinged(Map<String, Object> res, String signed) throws SignedErrorException {
		// 获取返回签名
		String returnSigned = (String) res.get("Signed");

		logger.debug(" result signed: " + signed);
		if (!returnSigned.equals(EncryptUtil.encryptSigned(signed))) {
			throw new SignedErrorException(" validate Singed happen Exception : encrypt returnSigned: " + returnSigned);
		}
	}

	/**
	 * 
	 * 方法用途:提取XML节点的数据 <br>
	 * 实现步骤: <br>
	 * @param nodeList
	 * @return
	 */
	private static String getCharacterDataFromNodeList(NodeList nodeList) {
		Element line = (Element) nodeList.item(0);
		return getCharacterDataFromElement(line);
	}

	/**
	 * 
	 * 方法用途: 提取XML的节点数据<br>
	 * 实现步骤: <br>
	 * @param e
	 * @return
	 */
	private static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

	private static void formateRequestPackets(Map<String, Object> res, Document doc) {
		NodeList nodes = doc.getElementsByTagName(PacketsTargetConstant.XML_TRADE);
		Element element = (Element) nodes.item(0);

		res.put("Version",
				getCharacterDataFromNodeList(element.getElementsByTagName(PacketsTargetConstant.XML_HEAD_VERSION)));
		res.put("SequenceId",
				getCharacterDataFromNodeList(element.getElementsByTagName(PacketsTargetConstant.XML_HEAD_SEQUENCEID)));
		res.put("OfflineAccount", getCharacterDataFromNodeList(element
				.getElementsByTagName(PacketsTargetConstant.XML_HEAD_OFFLINEACCOUNT)));
		res.put("Signed",
				getCharacterDataFromNodeList(element.getElementsByTagName(PacketsTargetConstant.XML_HEAD_SIGNED)));
		res.put("TimeStamp",
				getCharacterDataFromNodeList(element.getElementsByTagName(PacketsTargetConstant.XML_HEAD_TIMESTAMP)));

		logger.debug(" formateRequestPackets formateHeadXmlToMap:" + res.get("Version") + ":"
				+ res.get("OfflineAccount") + ":" + res.get("SequenceId") + ":" + res.get("Signed") + " : "
				+ res.get("TimeStamp"));

	}
}
