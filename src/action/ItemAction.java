package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Item;
import service.ItemManagerImpl;

import org.apache.struts2.interceptor.RequestAware;


@Controller
public class ItemAction implements Action  {
	private String contentType = "text/html;charset=utf-8";
	
	private String result;
	
	private String content;
	private String type;
	private String answer;
	
	private ItemManagerImpl ItemManager;
	
	private Item item;
	
	public String execute() throws Exception
    {
		ServletActionContext.getResponse().setContentType(contentType);
		item.setContent(getContent());
		item.setType(getType());
		item.setAnswer(getAnswer());
		if(ItemManager.Upload(item)){
        	return SUCCESS;
        }
		return ERROR;
    }
	
	public String getItems() throws Exception
	{
		ServletActionContext.getResponse().setContentType(contentType);
		
		Item i = new Item();
		List<Object> list = new ArrayList<Object>();
		i.setContent("hhhhh");
		i.setAnswer("aaaaaa");
		i.setType("hh");
		i.setItemId(0);
		list.add(i);
		Item d = new Item();
		d.setContent("yyyy");
		d.setAnswer("bbbbb");
		d.setType("hh");
		d.setItemId(0);
		list.add(d);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("root",list);
		
		JSONArray jsonStr = JSONArray.fromObject(ItemManager.getItems());	
		
//		JSONObject cty=	JSONObject.fromObject(map);
		
//		JSONArray jsonStr = JSONArray.fromObject(list);
		
		result = jsonStr.toString();
		System.out.println(jsonStr.toString());
//		InputStream inputStream = new ByteArrayInputStream(
//				 jsonStr.getBytes("UTF-8"));
	
//		InputStream inputStream = new StringBufferInputStream(transcoding("struts2 返回 哈哈"));
//		request.put("list", list);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		return "result";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

//	public ItemManagerImpl getItemManager() {
//		return ItemManager;
//	}

	public void setItemManager(ItemManagerImpl itemManager) {
		ItemManager = itemManager;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
