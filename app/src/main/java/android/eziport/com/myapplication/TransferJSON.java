package android.eziport.com.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by abenagood on 8.02.18.
 */

public class TransferJSON {

    public static String toJSon(SendTransfer data) {
        try {
            // Here we convert Java Object to JSON
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", data.getName()); // Set the first name/pair
            jsonObj.put("weight", data.getWeight());
            jsonObj.put("weight", data.getDate());
            jsonObj.put("weight", data.getTime());

            return jsonObj.toString();

        }
        catch(JSONException ex) {
            ex.printStackTrace();
        }

        return null;

    }}