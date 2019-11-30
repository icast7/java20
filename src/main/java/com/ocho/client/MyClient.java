package com.ocho.client;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MyClient {
    public static void main(String[] args) throws IOException {
        HttpGet request = new HttpGet("http://httpstat.us/500");
        System.out.println("--- Before...");
        try (CloseableHttpClient httpclient = HttpClients.createDefault();
             CloseableHttpResponse response = httpclient.execute(request);
        ) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");

            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.getStatusLine().getReasonPhrase());
            System.out.println(response.getStatusLine().getProtocolVersion());

            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
            for (Header allHeader : response.getAllHeaders()) {
                System.out.println(allHeader);
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String result = EntityUtils.toString(httpEntity);
                System.out.println(result);
            }
        } finally {
            System.out.println("--- After...");
        }
    }
}
