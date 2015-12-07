package mfc.webtools;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * appatche Http Client wrapper
 *
 * @author oote
 *
 */
public class WrapperHttpClient {

    public WrapperHttpClient() {

    }

    private Logger log = Logger.getLogger(WrapperHttpClient.class);
    /*
     * 接続が確立するまでの待ち時間（ミリ秒）。
     */
    private final int connectionTimeoutValueInMillisecond = 10000; // 10秒

    /*
     * 接続後、データを取得してレスポンスを得るまでの待ち時間（ミリ秒）。
     */
    private final int responseTimeoutValueInMillisecond = 90000; // 90秒

    /**
     * 汎用：HttpClientオブジェクト初期化
     *
     * @return
     */
    private HttpClient instanceBuild() {
        // configurations
        int socketTimeout = responseTimeoutValueInMillisecond;
        int connectionTimeout = connectionTimeoutValueInMillisecond;

        String userAgent = "httpClient. to internal operation";
        // request configuration
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout)
                .build();

        // headers
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept-Charset", "utf-8"));
        headers.add(new BasicHeader("Accept-Language", "ja, en;q=0.8"));
        headers.add(new BasicHeader("User-Agent", userAgent));

        // create client
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(headers).build();

    }

    /**
     * 汎用POST検索ラッパー
     *
     * @param url
     * @return
     */
    public final String responsePost(final String url) {
        int responseStatus = 0;
        try {
            HttpClient httpClient = instanceBuild();
            HttpPost method = new HttpPost(url);
            HttpResponse response;
            response = httpClient.execute(method);
            responseStatus = response.getStatusLine().getStatusCode();
            return EntityUtils.toString(response.getEntity(), "UTF-8");

        } catch (Exception e) {
            log.error(Integer.valueOf(responseStatus).toString(), e);
            return "";

        }

    }

    /**
     * 汎用GET検索ラッパー
     *
     * @param url
     * @return
     */
    public final String responseGet(final String url) {
        int responseStatus = 0;
        try {
            HttpClient httpClient = instanceBuild();
            HttpGet method = new HttpGet(url);
            HttpResponse response = httpClient.execute(method);
            responseStatus = response.getStatusLine().getStatusCode();
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            log.error(Integer.valueOf(responseStatus).toString(), e);
            return "";
        }
    }

}
