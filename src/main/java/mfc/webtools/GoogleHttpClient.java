package mfc.webtools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import mfc.beans.GoogleSearchResult;
import mfc.utilities.InstanceManager;

import org.apache.log4j.Logger;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.seasar.framework.util.StringUtil;

public class GoogleHttpClient {

    Logger log = Logger.getLogger(GoogleHttpClient.class);

    /**
     * グーグル検索を行い、検索結果を解析し、GoogleSearchResultのリストを返す。
     *
     * @param parameter
     * @return
     */
    public List<GoogleSearchResult> responseFromGoogle(final String parameter) {

        String body;
        String url = "https://www.google.co.jp/search?num=100&q=";

        if (StringUtil.isBlank(parameter)) {
            log.debug(url + "no parameter");
            return null;

        } else {

            WrapperHttpClient httpClient = new WrapperHttpClient();
            try {
                body = httpClient.responseGet(url
                        + URLEncoder.encode(parameter, "UTF-8"));
                HtmlCleaner htmlCleaner = new HtmlCleaner();
                TagNode tagNodefromBody = htmlCleaner.clean(body);
                return parseTagNodeForGoogle(tagNodefromBody);

            } catch (UnsupportedEncodingException e) {
                log.error(url, e);
                return null;
            }
        }
    }

    /**
     * TagNodeを解析し、検索結果のみを取り出してリストにする。
     *
     * @param tagNodeFromGoogle
     * @return
     */
    private List<GoogleSearchResult> parseTagNodeForGoogle(
            final TagNode tagNodeFromGoogle) {

        List<GoogleSearchResult> googleSearchResultList = InstanceManager
                .newAtomicList();

        /*
         * Google検索結果のタイトル部のリンクは以下のように格納されている <h3 class="r"> <a
         * href="/url?q=http://www.youtube.com/watch%3Fv%3Dy_ThicJX1Ck">
         * 【<b>XXXXX</b>】「Are you ready？」BOMBER-E LIVE - YouTube </a> </h3>
         */
        TagNode[] h3Nodes = tagNodeFromGoogle.getElementsByName("h3", true);
        for (TagNode h3Node : h3Nodes) {
            if ("r".equals(h3Node.getAttributeByName("class"))) {
                TagNode aNode = h3Node.findElementByName("a", false);
                if (aNode != null) {
                    GoogleSearchResult model = new GoogleSearchResult();
                    model.setUrl(aNode.getAttributeByName("href"));
                    model.setTitle(aNode.getText().toString());
                    // Descriptionは使わないので取得していない。
                    model.setDescription("");
                    googleSearchResultList.add(model);
                }
            }

        }

        return googleSearchResultList;

    }

}
