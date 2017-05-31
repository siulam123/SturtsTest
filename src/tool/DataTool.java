package tool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Item;

public class DataTool {
	//����0-max�������������������
	public static int getRandom(int max){
		return new Random().nextInt(max);
	} 
	
	//����items�ַ�����ȡ�и���itemid����
	public static String[] getItems(String items){
		String[] strs; 	 //����һ���� 
		strs=items.split("->");    //�ַ��ָ� 
    	return strs;
	}
	
	//��List<Object>ת��ΪjsonStr
	public static String getJsonStr(Object object){
		JSONArray jsonStr = JSONArray.fromObject(object);

		String result = jsonStr.toString();
		
		return result;
	}
	
	public static JSONArray getJson(Object object){
		return JSONArray.fromObject(object);	
	}
	
	public static List<Item> getJsonItem(JSONArray jsonArray){
		return (List<Item>) JSONArray.toCollection(jsonArray, Item.class);
	}
	
	public static Map<String,Object> getMap(JSONArray jsonArray){
		HashMap<String, Object> map = new HashMap<String, Object>();
        
        for(int i=0;i<jsonArray.size();i++){
            JSONObject obj = JSONObject.fromObject(jsonArray.get(i));
            Iterator it = obj.keys();
            while (it.hasNext()){
                String key = String.valueOf(it.next());
                Object value = (Object) obj.get(key);
                map.put(key, value);
            }
        }
        return map;
	}
	
	public static String getNowTime(){
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		String timestamp = null;
		timestamp = sdf.format(new Date());
		
		return timestamp;
	}
}
