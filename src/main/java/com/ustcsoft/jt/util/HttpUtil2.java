package com.ustcsoft.jt.util;


import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class HttpUtil2 {

    /**
     * post for json data
     * @param url
     * @param map
     *
     * @return
     */
    public static String sendPostForJsonData(Map<String, Object> map, String url) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        HttpEntity resultHttpEntity = null;
        CloseableHttpResponse res = null;
        try {
            final String data = JSONObject.fromObject(map).toString();
            if (map == null || map.size() == 0) {
                return ALERT_INCOMING_DATA_NULL;
            }
            httpClient = getHttpClient();
            httpPost = new HttpPost(url);
            StringEntity stringEntity = new StringEntity(data);
            stringEntity.setContentEncoding(CHARSET);
            stringEntity.setContentType(contentTypeJson);// 发送json数据需要设置contentType
            httpPost.setEntity(stringEntity);
            res = httpClient.execute(httpPost);
            return getResult(res, httpClient, httpPost, resultHttpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(resultHttpEntity, res, httpPost, httpClient);;
        }
        return ALERT_UNKNOWN_ERROR;
    }
    public static final String CHARSET = "UTF-8";
    public static final String ALERT_UNKNOWN_ERROR = "unknown error";
    public static final String contentTypeJson = "application/json";
    public static final String ALERT_INCOMING_DATA_NULL = "incoming data is null";

    /**
     *
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(3000).build();
        CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        return httpclient;
    }

    /**
     * close all
     *
     * @param httpClient
     * @param httpPost
     */
    public static void closeAll(HttpEntity resultHttpEntity, CloseableHttpResponse res, HttpPost httpPost,
                                CloseableHttpClient httpClient) {
        if (resultHttpEntity != null) {
            try {
                EntityUtils.consume(resultHttpEntity);
            } catch (IOException e) {
                System.out.println("关闭httpEntiry失败" + e.getMessage());
                e.printStackTrace();
            }
        }
        resultHttpEntity = null;
        if (res != null) {
            try {
                res.close();
            } catch (IOException e) {
                System.out.println("关闭CloseableHttpResponse失败" + e.getMessage());
                e.printStackTrace();
            }
        }
        res = null;
        if (httpPost != null && httpPost.isAborted()) {
            httpPost.abort();
        }
        httpPost = null;
        if (httpClient != null) {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("关闭httpClient失败" + e.getMessage());
                e.printStackTrace();
            }
        }
        httpClient = null;
    }

    /**
     * 返回结果
     *
     * @param res
     * @param httpClient
     * @param httpPost
     * @param resultHttpEntity
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String getResult(CloseableHttpResponse res, CloseableHttpClient httpClient, HttpPost httpPost,
                                   HttpEntity resultHttpEntity) throws ClientProtocolException, IOException {
        res = httpClient.execute(httpPost);
        int statusCode = res.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            resultHttpEntity = res.getEntity();
            return resultHttpEntity == null ? "entity is null" : EntityUtils.toString(resultHttpEntity, CHARSET);
        } else {
            return "HttpClient,error status code :" + statusCode;
        }
    }

}
