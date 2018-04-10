package me.innjoy.pms;

import com.alibaba.fastjson.JSON;
import com.meituan.hotel.lock.client.params.OpenDoorParam;
import com.meituan.hotel.lock.client.utils.AuthUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InnjoypmsApplicationTests {
    @Value("${meituan.baseurl}")
    private String baseUrl;

    @Value("${meituan.appid}")
    private String appId;

    @Value("${meituan.appsecret}")
    private String appSecret;

    @Test
    public void hhh() throws IOException {
        System.out.println(" ");
        String url = baseUrl + "/lock/openDoor";
        System.out.println();

        // 生成请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        OpenDoorParam openDoorParam = new OpenDoorParam();
        openDoorParam.setTimestamp(System.currentTimeMillis());
        openDoorParam.setHotelId("001");
        openDoorParam.setRoomId("1001");

        StringEntity httpEntity = new StringEntity(JSON.toJSONString(openDoorParam), "utf-8");
        httpPost.setEntity(httpEntity);
        System.out.println("updateRoomListParam: ");
        System.out.println(JSON.toJSON(openDoorParam));

        // 生成头信息
        openDoorParam.setAppId(appId);
        Map<String, String> header = AuthUtils.getHeader(openDoorParam, appId, appSecret);
        String headerKey = "Authorization";
        String headerValue = header.get(headerKey);

        httpPost.setHeader(headerKey, headerValue);
        httpPost.setHeader("Content-type", "application/json; charset=utf-8");

        // 发送请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        // 分析结果
        int code = httpResponse.getStatusLine().getStatusCode();
        System.out.println(code);

        HttpEntity responseEntity = httpResponse.getEntity();
        String respJson = EntityUtils.toString(responseEntity);


        System.out.println(respJson);
    }

}
