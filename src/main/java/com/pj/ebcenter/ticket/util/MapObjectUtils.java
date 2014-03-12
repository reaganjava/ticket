package com.pj.ebcenter.ticket.util;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Description: Map对象帮组类</p>
 * @date 2013年10月21日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class MapObjectUtils {
	/**
	 * 对象转map
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
    public static <T> Map<String, Object> objectToMap(T bean)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Class<? extends Object> classType = bean.getClass();
        Field[] fields = classType.getDeclaredFields();
        for (Field f : fields) {
            String fieldName = f.getName();
            if (!"serialVersionUID".equals(fieldName)) {
                String strLetter = fieldName.substring(0, 1).toUpperCase();
                String getName = "get" + strLetter + fieldName.substring(1);
                Method getMethod = classType.getMethod(getName, new Class[] {});
                Object methodReturn = getMethod.invoke(bean, new Object[] {});
                String value = methodReturn == null ? "" : methodReturn
                        .toString();
                map.put(fieldName, value);
            }
        }
        return map;
    }
}
