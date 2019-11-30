package com.ocho.client;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class MyAsyncClient {
    static String url = "http://httpstat.us/500";

    static FutureCallback callback = new FutureCallback<HttpResponse>() {
        @Override
        public void completed(HttpResponse result) {
            System.out.println(url);
            System.out.println("Callback::result" + result);
        }

        @Override
        public void failed(Exception ex) {
            System.out.println("Callback::failure:" + ex);
        }

        @Override
        public void cancelled() {
            System.out.println("Callback::canceled");
        }
    };

    public static void main(String[] args) {
        HttpGet request = new HttpGet(url);
        System.out.println("--- Before...");

        try (CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();) {
            client.start();
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get();
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");

            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.getStatusLine().getReasonPhrase());
            System.out.println(response.getStatusLine().getProtocolVersion());

            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
            Stream<Header> stream = Arrays.stream(response.getAllHeaders());
            stream.forEach(h -> System.out.println(h));
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
            HttpEntity httpEntity = response.getEntity();
            if (null != httpEntity) {
                String result = EntityUtils.toString(httpEntity);
                System.out.println(result);
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            System.out.println("--- After...");
        }

        try (CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();) {
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
