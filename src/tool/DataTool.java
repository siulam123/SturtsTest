package tool;

import java.util.Random;

import net.sf.json.JSONArray;
import pojo.Exampaper;

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
}
