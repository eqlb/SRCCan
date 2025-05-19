package Question2;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ColorService provides an external API integration for retrieving random RGB colors.
 */
public class ColorService {
    private static final String API_URL = "http://localhost:3000/randomColor"; //This Url would be changed depending on the API
    //For testing I used Mockoon


    /**
     * Fetches a random color from a RESTful API endpoint.
     * @return ColorPickerComponent with values from the API.
     * @throws Exception on request failure or invalid response.
     */
    public static ColorPickerComponent fetchRandomColor() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);

        int status = connection.getResponseCode();
        if (status != 200) {
            throw new Exception("API responded with status code: " + status);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        JSONObject json = new JSONObject(response.toString());
        int r = json.getInt("red");
        int g = json.getInt("green");
        int b = json.getInt("blue");

        ColorPickerComponent component = new ColorPickerComponent();
        component.setRedDecimal(r);
        component.setGreenDecimal(g);
        component.setBlueDecimal(b);
        return component;
    }
}

