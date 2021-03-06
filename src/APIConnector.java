import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APIConnector {

    private JSONObject json;

    public JSONObject getJson() {
        return json;
    }

    //taken from https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    // end taken from stackoverflow


    //Searches for the meal in API
    public List getDish(String name){
        name = name.replace(" ", "%20");
        try {
            json = readJsonFromUrl("https://api.edamam.com/search?q="+ name + "&app_id=9c52e0f2&app_key=a66b3644b8ede82225d52bb142ef7daa");

            return (((JSONArray) json.get("hits"))).toList();
        } catch (IOException | JSONException e) {
            return null;
        }

    }
}
