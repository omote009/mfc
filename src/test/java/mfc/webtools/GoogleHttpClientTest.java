package mfc.webtools;

import java.net.URLEncoder;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XmlSerializer;
import org.junit.Test;

public class GoogleHttpClientTest {

    @Test
    public void testResponseFromGoogle() {

        String url = "https://www.google.co.jp/search?num=10&q=";
        WrapperHttpClient httpClient = new WrapperHttpClient();
        try {
            String body = httpClient.responseGet(url +  URLEncoder.encode("ポタリ site:www.youtube.com", "UTF-8"));
            HtmlCleaner htmlCleaner = new HtmlCleaner();
            TagNode tagNodefromBody = htmlCleaner.clean(body);

            // XMLに変換してStringWriterに
            XmlSerializer serializer = new PrettyXmlSerializer(htmlCleaner.getProperties());
            System.out.println(serializer.getAsString(tagNodefromBody));


        }catch(Exception e){

        }

    }
}
