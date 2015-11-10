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

      Logger log = Logger.getLogger( GoogleHttpClient.class);

       /**
     * グーグル検索を行い、検索結果を解析し、GoogleSearchResultのリストを返す。
     *
     * @param parameter
     * @return
     */
    public List<GoogleSearchResult> responseFromGoogle(final String parameter){

            String body;
            String url = "https://www.google.co.jp/search?num=100&q=";


            if(StringUtil.isBlank(parameter)){
            log.debug( url + "no parameter");
            return null;

        }else{

            WrapperHttpClient httpClient = new WrapperHttpClient();
            try {
                body =httpClient.responseGet(url +  URLEncoder.encode(parameter, "UTF-8"));
                HtmlCleaner htmlCleaner = new HtmlCleaner();
                TagNode tagNodefromBody = htmlCleaner.clean(body);
                return parseTagNodeForGoogle(tagNodefromBody);

            } catch (UnsupportedEncodingException e) {
                log.error( url, e);
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
    private List<GoogleSearchResult> parseTagNodeForGoogle(final TagNode tagNodeFromGoogle){

        List<GoogleSearchResult> googleSearchResultList = InstanceManager.newAtomicList();

        TagNode[] h3Nodes = tagNodeFromGoogle.getElementsByName("h3", true);
        for(TagNode h3Node : h3Nodes){
            // URLの取得
            TagNode aNode = h3Node.findElementByName("a", false);
            if( aNode == null ){
                     continue;
            }
            GoogleSearchResult model = new GoogleSearchResult();
            model.setUrl( aNode.getAttributeByName("href"));
            model.setTitle( aNode.getText().toString());
            //System.out.println(aNode.getText().toString());
            model.setDescription("");
            googleSearchResultList.add( model );

        }

   /*     // liを対象にする
        TagNode[] liNodes = tagNodeFromGoogle.getElementsByName("li", true);
        for( TagNode liNode : liNodes ) {
          // クラスがgじゃなかったら、多分リンクじゃないので除外
            if( !"g".equals( liNode.getAttributeByName( "class" ) ) ){
                continue;
            }

            GoogleSearchResult model = new GoogleSearchResult();

            // タイトルの取得
            TagNode h3Node = liNode.findElementByName("h3", false);
            if( h3Node == null ){
                 continue;
            }
            //model.setTitle( h3Node.getText().toString() );

            // URLの取得
            TagNode aNode = h3Node.findElementByName("a", false);
            if( aNode == null ){
                     continue;
            }
            model.setUrl( aNode.getAttributeByName("href") );
            model.setTitle( aNode.getText().toString() );
            System.out.println(aNode.getText().toString());

            // 概要の取得
            TagNode divNode = liNode.findElementByName("div", false);
            if( divNode == null ){
                  continue;
            }

            model.setDescription( divNode.getText().toString() );

            googleSearchResultList.add( model );
        }*/

        return googleSearchResultList;

    }

}
