package com.fksrd.library;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class FileGet {
    
    /**
     * @throws IOException
     * 
     */
    public static String getJsonData(String url) {

        String result = "";

        CloseableHttpClient  closeableHttpClient = HttpClients.createDefault();

        try {

            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader(HttpHeaders.USER_AGENT, "ToolInstaller");

            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                result = httpEntity.toString();
            }

            closeableHttpResponse.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {

            closeableHttpClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;

    }
    

}
