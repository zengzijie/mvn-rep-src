package com.skyinfo.taishantimer.test.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Component
public class Httpsget {

    public static String doGet(String url, JSONObject params) {
        HttpClient httpclient = null;
        String result = null;
        HttpResponse response = null;
        try {
            // 创建httpget.
            httpclient = new SSLClient();
            URIBuilder uriBuilder = new URIBuilder(url);
            List<NameValuePair> pairs = new ArrayList<>();
            for(String key : params.keySet()){
                String value = params.getString(key);
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key
                        , value);
                pairs.add(basicNameValuePair);
            }
            uriBuilder.setParameters(pairs);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            response = httpclient.execute(httpGet);
            // 解析response封装返回对象httpResult
            // 获取响应实体
            HttpEntity entitys = response.getEntity();
            //System.out.println("--------------------------------------");
            // 打印响应状态
            //System.out.println(response.getStatusLine());
            if (entitys != null) {
                result = EntityUtils.toString(entitys, Charset.forName("UTF-8"));
                return  result;
            }else {
                return  result;
            }
            //System.out.println("------------------------------------");

        }catch (Exception e){
            e.printStackTrace();
            result = "本地调用接口异常";
            return result;
        }
    }
}

