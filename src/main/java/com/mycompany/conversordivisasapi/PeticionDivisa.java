
package com.mycompany.conversordivisasapi;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Brandon Alv
 */
public class PeticionDivisa {
        public Divisa peticionCambio(String divisaBase, String divisaCambio, String cantidad) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/566db46c9f72d6c3261bf83c"
                +"/pair/"+divisaBase+"/"+divisaCambio+"/"+cantidad)).build();
    
        try{
           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Divisa.class);
        }catch(IOException | InterruptedException e){
            throw  new RuntimeException("No fue posible hacer la conversion");
        }
       
    }
}
