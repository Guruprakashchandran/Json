package java_program;


import java.io.FileReader;

import java.util.*;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;

class Datas{
	
	private String middle_Name;
	private String nick_Name;
	private String id;
	private String[] phoneNo;
	private String last_Name;
	private String first_Name;
	private long created_Time;
	private long last_Modified_Time;
	public Datas(String middle_Name, String nick_Name, String id, String[] phoneNo, String first_Name, long created_Time,
			long last_Modified_Time,String last_Name) {
		this.middle_Name = middle_Name;
		this.nick_Name = nick_Name;
		this.id = id;
		this.phoneNo = phoneNo;
		this.first_Name = first_Name;
		this.created_Time = created_Time;
		this.last_Modified_Time = last_Modified_Time;
		this.last_Name = last_Name;
	} 
	public String getLast_Name() {
		return last_Name;
	}
	public String getMiddle_Name() {
		return middle_Name;
	}
	
	public long getLast_Modified_Time() {
		return last_Modified_Time;
	}
	
	public String getNick_Name() {
		return nick_Name;
	}
	
	public String getId() {
		return id;
	}
	
	public String[] getPhoneNo() {
		return phoneNo;
	}
	
	public String getFirst_Name() {
		return first_Name;
	}
	
	public long getCreated_Time() {
		return created_Time;
	}
	@Override
	public String toString() {
		return "Datas [middle_Name=" + middle_Name + ", nick_Name=" + nick_Name + ", id=" + id + ", phoneNo="
				+ Arrays.toString(phoneNo) + ", last_Name=" + last_Name + ", first_Name=" + first_Name
				+ ", created_Time=" + created_Time + ", last_Modified_Time=" + last_Modified_Time + "]";
	}
}
public class UserData {

	public static void main(String[] args) throws Exception{
		
		List<Datas> list = new ArrayList<>();
		String id,middleName,nickName,lastName,firstName,zuid,phoneNo[];
		long ctime,lmtime;
	    JSONParser parser = new JSONParser();
	    FileReader reader = new FileReader(".\\JsonFiles\\Arattai.json");
	
	    JSONObject object = (JSONObject)parser.parse(reader);
	    JSONArray array = new JSONArray();
	    array = (JSONArray)object.get("list");
	    for(int i =0 ;i<array.size();++i) {
	    	
	    	JSONObject on = (JSONObject)array.get(i);
	    	middleName = (String)on.get("middle_name");
	    	id = (String)on.get("id");
	    	lastName = (String)on.get("last_name");
	    	nickName = (String)on.get("nickname");
	    	firstName = (String)on.get("first_name");
	    	ctime = (long) on.get("ctime");
	    	lmtime = (long) on.get("lmtime");
	    	JSONArray a = (JSONArray)on.get("phone_nos");
	    	String str[] = new String[a.size()];
	    	for(int j = 0;j<a.size();++j) {
	    		
	    		str[j] = (String)a.get(j); 
	    	}
	    	list.add(new Datas(middleName,nickName,id,str,firstName,ctime,lmtime,lastName)); 
	    }	   
	    for(Datas a : list) {
	    	
	    	System.out.println(a.toString());
	    }
	}
}