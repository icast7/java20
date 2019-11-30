package com.ocho.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.protocol.HttpContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public class MyAsyncMultithreadedClient {
    public static void main(String[] args) {
        try {
            ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
            PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(ioReactor);
            CloseableHttpAsyncClient client = HttpAsyncClients.custom().setConnectionManager(cm).build();
            client.start();
            List<String> urls = Arrays.asList(
                    "http://httpstat.us/200",
                    "http://httpstat.us/201",
                    "http://httpstat.us/418");
            List<GetThread> threads = new ArrayList();

            urls.forEach(url -> {
                HttpGet request = new HttpGet(url);
                threads.add(new GetThread(client, request));
            });

            threads.forEach(Thread::start);

            for (Thread t : threads) {
                t.join();
            };

            client.close();
        } catch (Exception e) {

        }
    }

    static class GetThread extends Thread {
        private CloseableHttpAsyncClient client;
        private HttpContext context;
        private HttpGet request;

        public GetThread(CloseableHttpAsyncClient client, HttpGet req) {
            this.client = client;
            this.request = req;
            context = HttpClientContext.create();
        }

        @Override
        public void run() {
            try {
                Future<HttpResponse> future = client.execute(request, context, null);
                HttpResponse response = future.get();
                StringBuilder sb = new StringBuilder();
                sb.append("- - - - - - - - - - - - - - - - - - - - -\n");
                sb.append(response.getStatusLine().getStatusCode() + " ");
                sb.append(response.getStatusLine().getReasonPhrase() + " ");
                sb.append(response.getStatusLine().getProtocolVersion()+ " ");
                sb.append("\n");
                sb.append("- - - - - - - - - - - - - - - - - - - - -\n");
                System.out.println(sb.toString());
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
