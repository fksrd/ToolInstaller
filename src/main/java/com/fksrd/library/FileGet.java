package com.fksrd.library;

import java.io.*;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FileGet {
    
    /**
     * @throws IOException
     * 
     */
    public static String getData(String url) {

        String result = "";

        CloseableHttpClient  closeableHttpClient = HttpClients.createDefault();

        try {

            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader(HttpHeaders.USER_AGENT, "ToolInstaller");

            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                result = EntityUtils.toString(httpEntity);
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


    public static void fileSave(String url, String FileName) {

        String result = "";

        CloseableHttpClient  closeableHttpClient = HttpClients.createDefault();

        try {

            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader(HttpHeaders.USER_AGENT, "ToolInstaller");

            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            InputStream inputStream = httpEntity.getContent();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[1024]);



            closeableHttpResponse.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {

            closeableHttpClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
