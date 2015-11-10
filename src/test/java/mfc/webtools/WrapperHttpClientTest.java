package mfc.webtools;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import mfc.beans.GoogleSearchResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class WrapperHttpClientTest {

    @Test
    public void testResponseFromGoogle() {

        GoogleHttpClient httpClient = new GoogleHttpClient();
        try {
            System.out.println(URLEncoder.encode("\"ポタリ\" site:www.youtube.com", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        List<GoogleSearchResult> list =httpClient.responseFromGoogle("\"ポタリ\" site:www.youtube.com");
        for(GoogleSearchResult s: list){
            System.out.println(s.getUrl());
            System.out.println(s.getTitle());
            System.out.println(s.getDescription());
        }
        assertTrue(list.size() > 0);

     }
 }
