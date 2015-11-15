package mfc.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import mfc.entity.ArtistLink;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class ArtistMovieLinkServiceTest {

    @Resource
    private ArtistVideoLinkService artistVideoLinkService;

    @Test
    public void testFetcheSingle() {

        ArtistLink link = artistVideoLinkService.fetcheSingle("0FqJ0aYxgM", "GOODLUCK");
        assertTrue(link.getLinkUrl().equals("https://www.youtube.com/watch?v=Y4iZWWGqjsc"));

    }

    @Test
    public void testUpdate(){
        int status = artistVideoLinkService.updateWithJudgement("0FqJ0aYxgM", "INSERTTEST", ("https://www.youtube.com/watch?v=Y4iZWWGqjsc"));
        assertTrue(status >0);

    }

    @Test
    public void testToNormalUrl(){

    }

    @Test
    public void testIsOkLinkTitle(){
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("アンダーグラフ/、こころに響くと話題の新曲「こころ」MV公開","アンダーグラフ"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("Alexandrosアレキサンドロス「Girl A」川上洋平おまけ映像の新曲MV公開！おまけ映像は川上洋平&松坂桃李・主演ドラマのオープニング曲！２０１５年１２月２日発売","Alexandros"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("片平里菜の新MV「誰にだってシンデレラストーリー」はドラマ仕立て、五島夕夏＆成田凌が出演","片平里菜"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("【Rの法則】KANA-BOON　なんでもねだりMVの秘密　20150513【","KANA-BOON"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("SEKAI NO OWARI シングル『ANTI-HERO』MV作成の詳細コメント！","SEKAI NO OWARI"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("ZIP ANTI-HERO MV密着取材 SEKAI NO OWARI セカオワ","SEKAI NO OWARI"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("西野カナ in〜《♪君は天然色 -めちゃ可愛い！》Special MV【HD】","西野カナ"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("君って 西野カナ【カラオケ/歌詞付き/フル】ドラマ主題歌やpvのfullなどliveでも鉄板曲 ゴスペラーズのカバーやピアノや合唱などでも人気歌ってみたで人気 西野かなの新曲は歌ってみたや吹奏楽もいい","西野カナ"));
    	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("恋する気持ち 西野カナ【カラオケ/歌詞付き/フル】歌ってみたやpvのfullなどliveでも人気 ピアノや合唱や吹奏楽のほかカバーでも人気 西野かなのliveは常に新曲気分でいい","西野カナ"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("植田真梨恵、「わかんないのはいやだ」 MVを公開【音楽ニュース】","植田真梨恵"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("ドローンで野鳥撮影　ＦＰＶ画像付　シギかチドリの集団飛翔","シギ"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("“酸欠少女”さユり、YKBKによる「ミカヅキ」の2.5次元パラレルなMVが解禁","酸欠少女”さユり"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("「talking」KANA-BOON　フル　pv","KANA-BOON"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("NMB48 「Must be now」 pv mv フル full - YouTube","NMB48 "));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("「OPV」私立恵比寿中学『PLAYBACK』 ","私立恵比寿中学"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("手書きPV/じゃあ、何故/阿部真央/ver.アラビヨ ","阿部真央"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("1080pHD UPLIFT SPICE オメガリズム MV ","UPLIFT SPICE"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("[AMV] UPLIFT SPICE Omega Rythm ","UPLIFT SPICE"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("SuddenAttack SACW Rualice. vs LE-LIEN PV 青　Cラッシュ止め 1/2 ","Le-Lien"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("9月28日Le lien PV ","Le-Lien"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("東京倉庫物語【第61話】東京倉庫がチャットモンチーのMVを作った理由 ","チャットモンチー"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("黒木渚「革命」MV MAKING ","黒木渚"));
       	assertFalse(artistVideoLinkService.isPvOrMvCheckOK("[Alexandros] - Run Away (MV) - YouTube","黒木渚"));
       	assertTrue(artistVideoLinkService.isPvOrMvCheckOK("[Alexandros] - Run Away (MV) - YouTube","Alexandros"));
       	assertTrue(artistVideoLinkService.isPvOrMvCheckOK("Superfly『Beautiful』Music Video - YouTube","Superfly"));
      	assertTrue(artistVideoLinkService.isPvOrMvCheckOK("KANA-BOON 『フルドライブ』 MV- YouTube","KANA-BOON"));
    }

    @Test
    public void testAutomaticAddVideoLinkFromYoutube(){
        int status = artistVideoLinkService.automaticAddVideoLinkFromYoutube("ndkRX7SbXt");
        System.out.println(Integer.valueOf(status));
        assertTrue(status >=0);
    }

}
