package calendar.connector;

import calendar.type.Visit;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class Connector {

    private static final String URI = "http://localhost:8080/calendar/get";

    public List<Visit> connect() {
        try {
            URL url = new URL(URI);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder builder = new StringBuilder();
            String output;
            //System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                builder.append(output);
            }

            //System.out.println(builder.toString());
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                @Override
                public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    System.out.println(json.getAsJsonPrimitive());
                    Instant instant = Instant.ofEpochMilli(json.getAsJsonPrimitive().getAsLong());
                    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).withNano(0);
                }
            }).create();
            Visit[] visits = gson.fromJson(builder.toString(), Visit[].class);
            //System.out.println(visits);

            conn.disconnect();
            return Arrays.asList(visits);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
