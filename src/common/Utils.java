package common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by hhy on 2017/6/2.
 */
public class Utils {
    public static String get_JSON() {
        JSONObject list = new JSONObject();
        JSONArray item = new JSONArray();
        list.put("title", "thoughtworks");
        list.put("title1", "thoughtworks1");
        list.put("title2", "thoughtworks2");
        item.add(list);
        return item.toString();
    }
    public static void main(String[] arg){
        System.out.println(get_JSON());
    }
}
