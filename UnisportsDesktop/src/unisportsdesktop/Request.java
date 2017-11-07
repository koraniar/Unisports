/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisportsdesktop;

import com.unisports.cross.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javafx.util.Pair;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author koraniar
 */
public class Request {

    public Pair<Boolean, String> post(String content, String urlDest) {
        try {
            String url = String.format("%s/%s/%s", Constants.environmentHost, Constants.environmentRest, urlDest);

            boolean result = false;
            String message = "Unexpected error";
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpPost post = new HttpPost(url);
                post.setHeader("content-type", "application/json");
                StringEntity body = new StringEntity(content);
                post.setEntity(body);
                HttpResponse response = client.execute(post);
                ObjectMapper mapper = new ObjectMapper();
                JsonNode nodeResponse = mapper.readTree(EntityUtils.toString(response.getEntity()));

                switch (response.getStatusLine().getStatusCode()) {
                    case 200:
                        result = nodeResponse.get("result").asBoolean();
                        message = nodeResponse.get("message").asText();
                        break;
                    case 400:
                        message = "Error enviando los datos, por favor intenta de nuevo mas tarde";
                        break;
                    case 404:
                        message = "Error contactando a nuestros servidores, por favor intenta de nuevo mas tarde";
                        break;
                    case 500:
                        message = "Error, por favor intenta de nuevo mas tarde";
                        break;
                }
            }
            return new Pair<>(result, message);
        } catch (UnsupportedEncodingException ex) {
            return new Pair<>(false, "Error al intentar enviar los datos, por favor intenta de nuevo mas tarde");
        } catch (IOException ex) {
            return new Pair<>(false, "Error inesperado, por favor intenta de nuevo mas tarde");
        }
    }
}
