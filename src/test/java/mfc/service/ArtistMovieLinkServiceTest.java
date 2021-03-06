package mfc.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class ArtistMovieLinkServiceTest {

    @Resource
    private ArtistVideoLinkService artistVideoLinkService;

    @Test
    public void testFetcheSingle() {

        /*
         * ArtistLink link = artistVideoLinkService.fetcheSingle("0FqJ0aYxgM",
         * "GOODLUCK"); assertTrue(link.getLinkUrl().equals(
         * "https://www.youtube.com/watch?v=Y4iZWWGqjsc"));
         */
    }

    @Test
    public void testUpdate() {
        int status = artistVideoLinkService.updateWithJudgement("0FqJ0aYxgM",
                "INSERTTEST", ("https://www.youtube.com/watch?v=Y4iZWWGqjsc"));
        assertTrue(status > 0);

    }

    @Test
    public void testToNormalUrl() {

    }

    @Test
    public void testIsOkLinkTitle() {
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "アンダーグラフ/、こころに響くと話題の新曲「こころ」MV公開", "アンダーグラフ"));
        assertFalse(artistVideoLinkService
                .isPvOrMvCheckOK(
                        "Alexandrosアレキサンドロス「Girl A」川上洋平おまけ映像の新曲MV公開！おまけ映像は川上洋平&松坂桃李・主演ドラマのオープニング曲！２０１５年１２月２日発売",
                        "Alexandros"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "片平里菜の新MV「誰にだってシンデレラストーリー」はドラマ仕立て、五島夕夏＆成田凌が出演", "片平里菜"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "【Rの法則】KANA-BOON　なんでもねだりMVの秘密　20150513【", "KANA-BOON"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "SEKAI NO OWARI シングル『ANTI-HERO』MV作成の詳細コメント！", "SEKAI NO OWARI"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "ZIP ANTI-HERO MV密着取材 SEKAI NO OWARI セカオワ", "SEKAI NO OWARI"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "西野カナ in〜《♪君は天然色 -めちゃ可愛い！》Special MV【HD】", "西野カナ"));
        assertFalse(artistVideoLinkService
                .isPvOrMvCheckOK(
                        "君って 西野カナ【カラオケ/歌詞付き/フル】ドラマ主題歌やpvのfullなどliveでも鉄板曲 ゴスペラーズのカバーやピアノや合唱などでも人気歌ってみたで人気 西野かなの新曲は歌ってみたや吹奏楽もいい",
                        "西野カナ"));
        assertFalse(artistVideoLinkService
                .isPvOrMvCheckOK(
                        "恋する気持ち 西野カナ【カラオケ/歌詞付き/フル】歌ってみたやpvのfullなどliveでも人気 ピアノや合唱や吹奏楽のほかカバーでも人気 西野かなのliveは常に新曲気分でいい",
                        "西野カナ"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "植田真梨恵、「わかんないのはいやだ」 MVを公開【音楽ニュース】", "植田真梨恵"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "ドローンで野鳥撮影　ＦＰＶ画像付　シギかチドリの集団飛翔", "シギ"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "“酸欠少女”さユり、YKBKによる「ミカヅキ」の2.5次元パラレルなMVが解禁", "酸欠少女”さユり"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "「talking」KANA-BOON　フル　pv", "KANA-BOON"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "NMB48 「Must be now」 pv mv フル full - YouTube", "NMB48 "));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "「OPV」私立恵比寿中学『PLAYBACK』 ", "私立恵比寿中学"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "手書きPV/じゃあ、何故/阿部真央/ver.アラビヨ ", "阿部真央"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "1080pHD UPLIFT SPICE オメガリズム MV ", "UPLIFT SPICE"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "[AMV] UPLIFT SPICE Omega Rythm ", "UPLIFT SPICE"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "SuddenAttack SACW Rualice. vs LE-LIEN PV 青　Cラッシュ止め 1/2 ",
                "Le-Lien"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK("9月28日Le lien PV ",
                "Le-Lien"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "東京倉庫物語【第61話】東京倉庫がチャットモンチーのMVを作った理由 ", "チャットモンチー"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK("黒木渚「革命」MV MAKING ",
                "黒木渚"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "[Alexandros] - Run Away (MV) - YouTube", "黒木渚"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "サンボマスターの名曲だけを集めた厳選PV動画特集！ | Live ...- YouTube", "サンボマスター"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "歌ってみた サンボマスターの名曲だけを集めた PV | Live ...- YouTube", "サンボマスター"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "弾いてみた サンボマスターの名曲だけを集めた PV | Live ...- YouTube", "サンボマスター"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "MV 西野カナ『トリセツ』ヒロイン失格主題歌 (太郎あげあげcover)", "西野カナ"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "【踊ってみた】チームしゃちほこ - じりじり夏活委員会 feat.しまじろう【MV Ver.】", "チームしゃちほこ"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "/ NEW SONG 「Place of Fire」 Music Video 7/11 ...(Auto)",
                "The BONEZ"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "KANABOON× 「tarking」 mv pv full フル  (Auto)", "KANABOON"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "藤原さくら「Walking on the clouds」MV！『a la carte』の中の名曲。", "藤原さくら"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "荒川ケンタウロス、新曲ミュージックビデオは漫画家・長尾謙一郎とコラボレーション", "荒川ケンタウロス"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "土ミツ　トレモノ　未完成.wmv", "トレモノ"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Red Velvet 레드벨벳_Ice Cream Cake_Music Video", "Cream"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Manila Luzon - Ice Cream ft Andre Xcellence [official music video]", "Cream"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Tujamo & Danny Avila - Cream (Official Music Video)", "Cream"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "【MV】さよならテツコちゃん SHAKABOOZ & 大阪ミュウミュウ", "テツコ"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Against All Enemies.wmv", "Against All Enemies"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "「IGNITE」AMV 藍井 エイル Cover と歌詞", "藍井 エイル"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Anti-Hero//Death Note AMV// Sekai No Owari", "Sekai No Owari"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Stereo Osaka 2015.08.08 HMV三宮VIVRE 2部 Edge Dub Monkeyz", "Stereo Osaka"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Stereo Osaka(ステレオ大阪)HMV三宮店　「Endelss Dokidoki Mode」", "Stereo Osaka"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Stereo Osaka in HMV Sannomiya", "Stereo Osaka"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Stereo Osaka(ステレオ大阪)HMV三宮店　「Osaka GEISHA Dancing」", "Stereo Osaka"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Stereo Osaka インストアライブ HMV三宮(一部) 2015.08.08", "Stereo Osaka"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Stereo Osaka(ステレオ大阪)HMV三宮店　「Electron」", "Stereo Osaka"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "SpecialThanks 【SpecialThanks】I MY ME MINEミュージックビデオ撮影 - 2012.11月吉日", "SpecialThanks"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "井手綾香 井手綾香 - 「235」「消えてなくなれ、夕暮れ」Music Videoスペシャル先行映像", "井手綾香"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "May J.『Rewind』MUSIC VIDEO / Back To Your Heart feat. Daniel Powter 先行試聴音", "May J"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "9月28日Le lien PV", "Le lien"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "Яeal ♥ яeal нorses #2 | ♫ music video ♫", "Яeal"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "I-RabBits [I-Rabbits MMV concert] Part", "I-RabBits"));
        assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "LALALA - THAITANIUM (Official Music video)", "LALALA"));
         assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                "SOLIDEMO / 「Girlfriend」MUSIC VIDEO", "GIRLFRIEND"));
         assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                 "LiSA Empty MERMAID MV 特殊メイク 黒い人魚", "LISA"));
         assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                 "Little Glee Monster 『好きだ。』MV SELF REVIEW", "Little Glee Monster"));
         assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                 "【MV】蜜恋(ハニー)ライアー！？　[しゅみしゅみ/仲谷明香]", "蜜"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                 "♥ яeal нorses #2 | ♫ music video ♫ Яeal†waR　PV", "яeal"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "モハメド・アヴドゥル ＆ マジシャンズレッド PV", "モハメド"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "【MAYU】Love Logic【オリジナル・MMD-PV】", "Mayu"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "天才バンド、ニューアルバムよりリードトラック「ロックジェネレーション」MVを公開", "天才バンド"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "AMV Gintama | Renho Arc. | Dilemma by Ecosystem", "Ecosystem"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "secret/ecosystem 自作MV", "ecosystem"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "【NANOSCALE TV vol.4】～PV撮影編～", "NANOSCALE"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "「AZUMI幕末編」イメージPV1", "AZUMI"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "AZUMI-あずみ-の小山ゆう最新作『雄飛 ゆうひ』PV", "AZUMI"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "LAMP IN TERREN - 緑閃光 |MV Reaction|", "LAMP IN TERREN"));
          assertFalse(artistVideoLinkService.isPvOrMvCheckOK(
                  "The BEG - PV撮影オフショット集 -", "The BEG"));

        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "SOLIDEMO / 「Girlfriend」MUSIC VIDEO", "SOLIDEMO"));

        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "Superfly『Beautiful』Music Video - YouTube", "Superfly"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "KANA-BOON 『フルドライブ』 MV- YouTube", "KANA-BOON"));
        //assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
        //        "UPLIFT SPICE Ramver Omega Rythm MV", "UPLIFT SPICE"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "私立恵比寿中学『PLAYBACK TOPVAR』 MV ", "私立恵比寿中学"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "TAKE COVER 「フィルム」Music Video ", "TAKE COVER"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "阿部芙蓉美(Fuyumi Abe)「A thousand days of love」/ music video",
                "阿部芙蓉美"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "[Alexandros] - Run Away (MV) - YouTube", "[Alexandros]"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "【MV】Riverside Creature『最少愛』", "Riverside Creature"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "\"Beautiful Flight\" / performed by H ZETTRIO 【Official MV】", "H ZETTRIO"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "\"Beautiful Flight\" / H ZETTRIO 【Official MV】", "H ZETTRIO"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "HEADLAMP 『ウチュウイチ』 (OFFICIAL VIDEO)", "HEADLAMP"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "SHE'S/ Leave Me (MV)", "SHE'S"));
        assertTrue(artistVideoLinkService.isPvOrMvCheckOK(
                "ONE OK ROCK - The Way Back - Japanese Ver. - [Official Music Video]", "ONE OK ROCK"));

    }

    @Test
    public void testAutomaticAddVideoLinkFromYoutube() {
     /*   int status = artistVideoLinkService
                .automaticAddVideoLinkFromYoutube("c3Ds0hdo5o");
        System.out.println(Integer.valueOf(status));
        assertTrue(status >= 0);*/
        /*
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube(
         * "0FqJ0aYxgM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0kDcUtjryG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0MYQJEzNy7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0O21xa66cN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0OKeOmBsMw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0R6ng58p4x")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0rVFZy4RaV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0TbKsfGRxS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0uu5puyCO7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0wys1JxoWp")>=0);
         *
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube(
         * "0YLEPOWgFv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("0zwL7iR8r7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("10DPueFeCc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("11NDyaesiM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("13rX3fDyt6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("14TZ7Ovnkf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("17wdMveHcq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("18Lqgy5ztF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("19knL789Dd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1DnSy0WtSL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1iM80vZhYT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1lStBjwUys")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1mhHtiXR6x")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1NPt9mcvmd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1Q7AcduQ3I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1R0rIgTfpN")>=0);
         *
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube(
         * "1rDAlVkDve")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1S9ktp5fBv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1so6shlBcJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1tnzHkftNh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("1xddiLdbgu")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("21oq2KbLyt")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("22qmV2cLHE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("28i5XEeKmu")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2Aiv6dSf4N")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2bJDdMfhEi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2bNp3l12er")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2BzEmrAUHX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2cna4OJbf7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2DmHSW71U9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2hdR68VHS1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2MFzzkeQxP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2P4ogKVPqi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2QHw20HSKS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2qKezcMGkz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2t1HovEGzE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2WjZoiCDtq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2wKKM37lWx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2yuW4E353B")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("2ZZHwExQ1N")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("36aTVj05tg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("36QlOX6AxC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("37uNkY8h8G")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("3cHMhi1lGp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("3gfTPS1IP4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("3IQEoHSqbw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("3ixOyBBv2b")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("3JVTlnkfFq")>=0);
         *
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube(
         * "3TX9EJR9iz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("3WDRDqRPbk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("41rTLS8fWd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4AtI5L8hHw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4DMS39ijZv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4DrdIzTBx0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4jiJwzohkp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4KGtBqp9Pp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4LZYNyW2tp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4M3fBvvJ17")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4m5PAhfwmn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4TtVCfId4U")>=0);
         *
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube(
         * "4w0WCmGIfV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("4ZhZuyoJsW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5A0NeHkOyi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5AcCApBkd0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5AJEW2EM21")>=0);
         */
        /*
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube(
         * "5BuVgvQpDj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5DJwlOwdb8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5DTflXiUMK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5eEtJsfUPk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5IHgKLkEy1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5jMZxKLasp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("5PJMoa6NTG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("640feb82NN")>=0);
         *
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube(
         * "68hGIQdUA1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("69E7BV3YLj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6ato00jIiT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6cAWiIPa8e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6FqCTuKJnv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6gnwTu1FYJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6nChbxLkfU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6qSTtnf1H4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6QW9ro0Z8H")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6umO5RsFuh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("6VYyG3c4iE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7558t52Roc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("759hxMsqT1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("768RCqxkXO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7Bf5yNFmSh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7bgTQF5NDp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7C4t3yYCak")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7daNIh18Rp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7EPDWh4UHX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7F8P1jKOND")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7f9pcvESAR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7fK2R6GdmQ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7k638CuiYS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7NDmDSGN4u")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7nf8LgAI2e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7oyS7RmIZL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7OzaX1UByr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7qLUZfX2EJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7TNfrio9cC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7tuE9VbROM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7XHzl5CoXo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("7xqgqeNheY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("80TCt9RhmM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("85UN7hBde9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8CUOufyqNP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8DLmlu8wZ5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8DV72euBd4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8g5ZoMTaH0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8hZswMZLCv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8iECC3L2gd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8iQcwyiRcg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8j0AKxoX1V")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8kN8DvHdkw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8lalmFb268")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8lsJ5Pw4FC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8P4mwwY95I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("8WgPJ0nm7z")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("935aqRRA0A")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("98OhJ6qiwv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9grnc854zu")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9ii4jAWmfr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9jxMqXe6kl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9LvYq4ohBJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9mhAKqUVEZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9N8Bh9SZtM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9NBG3ptdrU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9nO1Pcl3fk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9Ny6EjwCRA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9oOKGOT7RL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9Q0aukJom1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9WQrbYubWS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9wSHrp2tH7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9y3cISI8Ag")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("9zX7SQXVXg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("A0W5aySpbz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("A10kmnudtz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("A7wJXWuTLz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("a9GxpxKKRH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AaClJ2MsgT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ack9F2ETUt")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ADPUDbLLbe")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("aDTj4ZxN9D")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AgjntUgMOy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ajcccUrSlL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ajyXt0TJ6a")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AlfKb3gYmx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AnJkqA0sBG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("aNo0Ff1WwX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AoAqPUuBm6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("aOdXYkUKzL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ap8dchr4x4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("APvwsCSIca")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AQ5OCpTNKb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AQqj03Twph")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ARMc6LfqSS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("aUUIoqbwsf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("aWgrKjERQ3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("axQeNc9Ln6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("axtQVM6chN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("axu6oOmnrx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ayJOPthuuE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AYp0GP0wsb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("AyQHKNCadK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("b3lbM6fC2s")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("B43PBKetAT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("b4QUqbj5bE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("b9jCKuZtCW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bbRMZkjQ5k")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("BCNkSz4ybI")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("BCZJbqXoh7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bDx8rGiwIG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bGfRYXpKcf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Bhinzrdqb2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bhx7tY96U3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bIxx7OPcFj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bKwlsi4DRX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bnz4QP59RR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bOFIHyTcdj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bqiXEmYlAj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("bRWREtEDbe")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("BTRU5J7Z58")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("buQyOjwKZn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Bv4DeYq7uh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("BWa00EEPzo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("c3Ds0hdo5o")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("C3qdTECqh8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("c3WG8vpy5i")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("c8flseza0F")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CBE38ZOXrB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cC4quWUmUD")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CC5RrwFwFB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ccHSUt7smP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CdMXnojvtw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cE770AEyXv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cec03UzvuU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cEcVomuhoW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cF6NAGQCbK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cghFHkmeni")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CgviMBZnGK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cgXfjL0ssR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ChJHYIrVux")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("chZAO91Yys")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cJOA9la3bR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CKOMQNpDX7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cn3enigMjw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("COeYAu2C5H")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CojZkxuloC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CoO6FjWNMw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CPQDU4qYZn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Cqe3Q9fIP7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cRw2kgtLhi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CSpAgrnmJr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cstahXDb4Q")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CsUhcJWZ55")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cUnrZHB2EY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CutDhwc28P")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CWasBOC2B4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("cy45Ip1Lcm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("CyJy0M0KVv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("d0RlqoIZUi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("d1C1nZHfrO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("D3IuggxmeU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("D6SseJcOPi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("d7ls6wWcM4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("d86wQXmmhg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("D8eB7FdsYX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("d9FBhZMXDv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DaYtvwYm5e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DbGheSRCoh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Dbxlu0d8a5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dDamzAbHfK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dexQZvYJS6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DFrcym69JK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DGmDaxpVit")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DGzIFzVN71")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dhCgb62EZe")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DHlUEtrPLw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DiNi39vTTl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DJf0OnCHXv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Dk2UanQNa2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DKhuU9D1TD")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dKU5nkx6jW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Dl1iV6M5sO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dLvr06UNiF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DlwNsTT445")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dmfSCNxKG2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dNLTojEDi6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DnScB7cigH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DO3LEMrpS9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dpQ9YpiJ5g")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("drdB5IbrpI")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dS3yPqDzfy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dSFIonFXOp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dT4fDV1F5p")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Dt4uK1Hv36")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DTc4fG7jHx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dtvO3PaFvK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dUUG6A9b9V")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DVeOwrMGGa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("DXEvskqRKO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dyTPP5onDI")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dyy872E6U1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("dzwaPYmWMr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("e01aNSHY9Y")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("E2s3wGLQir")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("E3PFgBaKYy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ECNxxgdOgR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ed9BaTVfY2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EfXXIA1ZK4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("eH7ROV4t8p")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("eIbvwHBss3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("eIOAYjlbLU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("eizSzgbE5v")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ElJOk1iKCC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Eo1Jiid1jm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EOLBDf3x0i")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EozTm8cHkJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EPOiHuFJQp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("eQJHbPoSED")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EQzarmjROY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("eR1GzQtlBj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("etqmX90oSs")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EttbbFBsvH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ETXfecz3xg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("evhB0as45h")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EvoxQ9mZo6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EWd0MBATwP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("eXxDU86GGN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ey7QMvZA47")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("EYiwcEvdwv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ezypINKARb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("f1t7jlJrHV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("f2EDFFa6y0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("f4NLFkIRmL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("f9wcG4vACR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FD5J5Lj5ci")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fdWLEYGEpm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fF1Jvco2t8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ffcb9JeFww")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ffd3jlu87e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ffpLmaNfsp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FgdlEJh4Hr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fGYsQp6BmP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fhKoWqyPyz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FHwvDPVg89")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FiDOR93SI5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fIlEkETxkd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FKEwqrZs6B")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Fl1FqAeUCh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FM8oV0dEP7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FMxDKzbqgy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FnZmVpkKjl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FoFYHc6SQv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fOSWhZFOoK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FpcB2Awxa6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fPv60fY6wZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fQyqSK60Dw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fRh1qRFxT5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FtIgh1r7KN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FtkadcW1yi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FU5xPqbs1p")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FuIsLu2V7G")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FUXODXFskr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Fw6V3Fvft8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FXihc10vCK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FxJGQ0tri6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fYdKdeNsh0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fYi01LA1yJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("fYMU8iwSTq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("FyYYiq6ADQ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("g3eDbd2fHa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("G5aptaq3Yp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("g9rnqPD227")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gaLXNQ6rsp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gAtrGliIcO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GbHIt5y0Vv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gdYAdLK0Pb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gf6OWg61zF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GI2WtZp4zM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GKKnfsE8R0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GMKCBWviE8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GmZGksj3x4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GnGJfIlqCa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GOHd1XWXSW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GOmgnOnm1p")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GpRxxKs6nn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gqLhG13V28")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gQnIc9lbdO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gTAKqsrSBO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gV0L0wPpqO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gVDbs6G3ks")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GwXZzbaU1I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("gZML0xExOD")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("GzUDmefMdG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("H041WjSuvM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("H2A01q0Iem")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("h4TyrOIC9F")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("h5c8WLfesw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("h6xU50hCR5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("h70tl6iMfC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("h9Ujk3cqpU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ha7DwiAqDb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HAN443LfFP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hBot5n4fc0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HCPuYuuS0l")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hFY0CHJQxU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hhJ8Ia3JF4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hHKqrxokHK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HhOVIHDGmd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hiAhktlo51")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hIPLVJmIPC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HitlvR3Bw4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hJBN3JREPX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HJwyqYMW9l")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HLFAzDy9YO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HlxChxQEHz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HMbnWSbgHj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HNS40vKjTd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HpGEAKAPpJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HqSBiAnHCl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HtaoTfDfhA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hu4qXPWHP5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HuJZvCFU16")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hUUuB9Q7mU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("hXqHUZV5pF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("HZxyExaOns")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("i24SSxtFOJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("i4bWEmla2B")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("i7bOxNzOq0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("i7oa7Zt1IN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("IBhsxxIzGJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("icjEDMgTv8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ICvbSXfqC0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("icXI4g68L3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("idbLwtrC95")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iECW1IeykG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ig4v3D920z")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iHZljUN3Wa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("IIEtvvd51I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ildOfdQyNK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("IlF1ljBOZ7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("imSl3fGU31")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("INAOL524Il")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iQ13vKHCgr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iQ1c0ONekY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Iq5zUw6Dek")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Iq98JyBEcO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("IR9JJY3imp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("IS3xYx6OYU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iSrTS9FsN1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ItkYkc3Gdy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iTmLyX6bbH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iU3ZfXaWkv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iUiVY6ph3s")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("IVDzXHXf4S")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iW1ElFujzx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iwpDA1OYZj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ix6iBUN7ZK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("IX8oZ9FSyB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iXm0owDjNC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("iZEZy0LcPx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("J3hY0QVX1n")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("J3XBcs3vcS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("j4ULt9ZPXL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("J6K1ikHHUc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("j6XHUe4Ja8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jAJv0lX7bp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JDilsH5b3n")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JdpxNLQy5C")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JeNrpY0Ut9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JFHD16MwQq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jFsATjEFXL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jgara1zLz3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JgItiOqxEB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JGQuY49Mg3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jKE940Euos")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JKrIUMIHU5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JlIy18QUio")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Jm66UI802g")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jng3D3X8D5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JO8uG5ztv6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jOKRcu048d")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JPDgrjYfP1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JPuFonTdMB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JPVuHxAFEU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Jtgm756HNR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jtHCEeGcQ9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("juaL8ujM7e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("juGXPHo7lF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JuZmwLQy5p")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("JWFnGBYYds")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("jxvuwEsyxK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("K0CIPKH3KP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("K2SW2vzQKw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("k4B2ZfVXd6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("k8sp72Xg5v")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kADb35Hw1V")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KfIzDXn4hx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KfwMTuB1f3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kh7UzJsS7O")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Kh8QLd5rD5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kKpWtWpXy0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KLEXbe5Hue")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KNmTAgPebK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KOAbxk6mlE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("koRhv4YiEa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kPU9ePBZPu")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KQ6MisLR4X")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kqkzHbCEZ6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("krts8RlAyu")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KSkzSGZMuV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KSt3RuN2px")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KU7r8JGcKY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kUkGA4mEoP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kVc0DbaO8Y")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kVy4vXiSnT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kwO6YRBl1r")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kWsm8WFLYc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kWxdGJ6vMA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kX15MKVFa2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kxoYUfYFx8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KynrGh6bP5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("kywUlZzcWr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KyYgvNfPAo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KZfSE7NrFK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("KzRgGAKdiR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("L24XrTNsRO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("l4Cl5Wjsur")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("l4IZmC1R3F")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("l4rl1WJOEN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("l5P2yE0itu")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("l99VZREISB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("laB6au7Vfq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("LArhjoS7k2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lcSQ3W7Wdh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lD5m3dkGG3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lDn4FHd3xT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lFGsHA9Qgz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lGr3bY8Sv6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lGxmtTzbHI")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lHygL2IlUS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ljF7vt5vRj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("LKZrFe7HV0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("LN6LPwlj7D")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("LpQdp1WP8f")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lPwco50Ivm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("LR8OLrDiTK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lRbUm6KsCX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("lrYIVNvk2D")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ltCc1l81Pj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("LvD9Laq78B")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("M0gidJqNz7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("m7kANqOxhY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("m8FH2XgzPc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("m8OLW6OKAV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("m8ovVvD5Yz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("m8rnnGkSAl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("M92bkfq1vZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("M9L1ijXxnX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("McoDmcyTR2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MCUnL7Doer")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MDq9DcrAbp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MEk8OvsOwZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MeMwWWxhEX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mgPDide1NW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mjrT2sbdbl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mJwBKGf3DA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mk4r4OKyPT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MLUbyAF59e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mM4D5xzlHT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mMzfCMSvb9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mnknFzJRhC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("moLVCnVSMg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MpP07OAKBq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mPTZYJ0l4I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Mq2wYE4Hgx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mrB1kQz8Yv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MT3eJMdiXM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MtuRFjmDkk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mTvNMs5HuO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MuNx3iMC3E")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MUzmd0hc5r")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mvAso76KrK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MwBd9hrkDj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MwJI1g4dY2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mWOkSg7dWb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("MwRzzomPPX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mWTbkDesLF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mXfQwWZXds")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("mzvP3HomGy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("n3jTO8rKsQ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("n42KsVrV0o")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("N6p4YxuF9I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("N6tRkaxYPR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("N78a1ebM23")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("n7htMsrZXs")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("N7vwcJHC2h")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("n8bztiGLaw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("N8VmR6Aepd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("N9A9hVwEZS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("na4AZvZQ7G")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("naOB7j417N")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Nc1vERAxob")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NcBGekOvBd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ndAKac4poR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ndkRX7SbXt")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nE3iTNEPet")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nFj1UBKzEp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NGhgcvwByr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NgHuhFPVGE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nheju8CPw9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nHRr1l9VlU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NI6FYYOKB3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NIWPh6YCQo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("njF66zCDNg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nJmzu4osap")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NKfuXpkYjk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NlV0MZcA2E")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nMXNDjCg3o")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nOsEDloI5w")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nPVG8hWmou")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nqpbnL6llo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NR1nb7OA8L")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NrU2jgU0i4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NUza5Eivnq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nxDawzLacN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NxsV0K8y2I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nYbeeCbIfy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("nYi1zFAk0m")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("NYUynJgiEa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("O4UYcGTFVn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("O7TSZ6hsNm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("O8AD7QO0LA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("O8Uwgf1MBx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oA5rUISSyV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oaAyvnGZJH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oABHKXd9CH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OaEl3zVI6u")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oaHPwFn0ny")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OAM4vmvMfB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oDZ1jvGOdk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oEfinJsEHi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ofrPKh0ALw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OHNYuWgQB8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oHS0B2pH67")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OK1lOtFgiU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OpesoWMFgU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OPlEwQRYkO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oPu9Y9kfLn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OpZCQvPZFO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OSCWGZArAl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OSUhGMTVNm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ot099R8XZX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oTrdLPcb2k")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OURBq7I2vG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oUVAz413qJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("oxMFQMEPHQ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("OYs6KP10u5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("P0o2nTJdGK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("p66gOSKxmL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("p6HY34W3lT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("P7FfOpLFRh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("p7m4YVytF0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("p7qxl8BvSY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pBhU3RA55Q")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PCxRuQXniH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pd5vR70van")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pDKBKe6Ibk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pehhiDXGKo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Pf1tSVH4Dz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pGGMDfaM5U")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pGQrjNZdfD")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PHpiHniGvY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pHwyOpq4AX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pIUskNY3RW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pkgG4EMnbb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PlNfHnKKuH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pmazPPHM4J")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PmG49ZEBhs")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PNllOwf8Qo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pONJVgGuHO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PPEpI7rg8k")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pq5r1DaCt5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PqbgRRmC58")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PTBl4gygx5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("PtJ0if7SvZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("puhcuQCt4D")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Pw0qr5a8tq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pwZGEh6QmK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("pXGYZ7AhrS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Q1V6yt7N91")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("q2mOVLmDBQ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qamoljGWlT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("QB2zFwhZS4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qBL0yGIFnC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qDCEjrWWSf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qDJUeRt5jE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("QdqtOHVdpM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qfq1S1gCSw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qFXI6dy4LV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("QGpciyHYYJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("QgSp533NbF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qJFTVS2t0H")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ql1YwE1wAo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qL3aG4mdCT")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qMumVzDesr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qnBnYgm1XV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qOJnJ0pbn8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qP2e8YcwFa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qP9LO8DPPt")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qQzVvI19P0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qRiSNK4KZe")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qRU6AjXx9f")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qtozGARNql")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("QVL8fguvtM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qWpzVq1ic5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("QxfLdK99fj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qyjrIOOmZN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qyTjh0hOnn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("qYZqle1SOY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Qzdw0uDC3t")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("R25xyMFGxM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("r3hwLvddbJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("R3KQkSevTU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("R4DohFP2gK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("r7oCoDzV5D")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("r8LdO0XkMR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("r8WqR7fOcD")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RbuepZimA9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rdtS43yo35")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rfGBTerh1e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rgusqFE59X")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RHYD3lloSx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RILzZjaS0y")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RIQN4NwKqB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RLge5kRVLK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Rli6gBW5Rf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rMPB7h7njt")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rmuIdQ3m9X")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ROGqs8hXtn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RpGCULF7Oo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Rpj0wpN2UP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rS5wTLGOAP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rsXDGPnjA6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RUAl1EmILv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ruLiBHxk6N")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rVmEeELZMN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RW1Oi7tasc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rwjnQBto0X")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("rWY546ZyA5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RYgdHW2dc9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("RYp4JE4Mzf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("s06oxU6QWi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("S145e3jH8I")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("s47TVTEyHc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("S4FBwMRW8V")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("S7wTJoihgA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("s7XMwtkHGo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("s9AKZiqNhU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SAzgTO12gC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SbLNL85lpx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SBYuCprCHe")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SdCENQQsec")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("sepWwth8Up")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("sf6ZpoppQA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SfwLQ0bprW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Siju0ChEOi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("sIxuDHxGGL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SKcY1miLPc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SKfavijGBa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("skiuOeflcV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("sLmkeNbad3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SM0HvJeHnK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Smm9mLrEgr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("smVTZHgWE5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ssA4Kr9q8F")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("stPZI5cJ0Z")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("StyclkBNGa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SU0cQDXDg1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("su7CCy73VB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("sw8qrE5GM9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("sx0QSUq2ME")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("sYCCycWDqZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("SYMoDOyu8e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("syxv5dAXTY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("t3SHh2idf8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("T4cAArKN7u")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("T5tzP44yLZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("t9KMJziOVe")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("TaIepIo5dM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("TBpvWOtJT5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("TdaTYjkoPK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("te2DRENlmR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("TiQxfr9jIN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("tKZZj3vozg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("tMXpASScZ7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("tnTgEuA8eU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("too7kgqRCn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("toSfOL3f8x")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("TPTcp5SiWb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Tq7tFcUfsE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("TQhwZ2nbvn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("tVMq1FWQ23")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("twCxyxm2c4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("tYehvrahNN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("u33hphpVXi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("U4MpzqjhkP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("U53FMNCE6f")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("U5klW2Waec")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ucB6LIKSBn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ud8zV2mYcY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ue7Sb7LnFr")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uEjgDcn5Tj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UERTJsbuhS")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uGMtkmhcuA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ugz2GRE5e0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uhR3p4wg8o")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UJhhiFhRrq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uKS3TavZLy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ul3hcrcWwm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uLgAhgLyu0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ULs24C6AJH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uMmTILKjZ1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UN8U7YHo7y")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uNGGrdSXGv")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("upEpNcBCpG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UPQWHVxO7S")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UQYPl0XREK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ur90V02uQ9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UsQniixdJ6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UsvWApMiZZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uTh6FYyLw3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Uw8BiXzct2")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uwOPVr4Woy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UWzvOBMXQy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uxDAGh7buq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Uy7PzgAqbL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("uZvmFWiVQJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("UzXBxbJqyO")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("v0xKRTRkcx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("V41fLnzW97")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Va6fuIvF9T")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vBMhEQYagi")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vcdDCeNr9w")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vG57wHP5o5")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vgRldsYMaB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("VIJ0rkp2Op")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ViPp2KvYHb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("VKTtiiCAJs")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("VMA1sEwFHg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("VnnHqt6hN8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vnSRwE8UBL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vo1DlZxMEc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vOV1GqFphA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vPNfjhLF7V")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("VQYNV2fR7K")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vTazeNyjcQ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("VURKLyuGkV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("VVEjvwBoeb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("vYtwFSglt0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("W1ooUgguZM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("W3pt3EMlA4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("w3Xc0wH5sH")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("W5z6DbIgJ8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("w94GY2lYcJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WC8NtId72A")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wDYo0CZwns")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wFNHqowjKw")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wFTgcTJWza")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Wg8wm1z3nU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WjIcXwYr6g")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wK2aFWetwL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wMek0dTnL6")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WMGdQ7YE3g")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Wmsoa87C90")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wMxf9TQfAG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wnkLshYy3y")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wo6QIBrYsg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WomN5zYRbD")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("woWaSlKFUQ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WpbEhNtlm8")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wqHDCFxyYG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WTGheMEEpZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wU1HOhwhb3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wuqPwAo6y3")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wvDfMyB0eW")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WwPbOFHxOz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("WxC3BlOgSb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wxMPh3116C")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("wzFCbdLAGP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("X1sQjmnYQa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("x2cXgweQdJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("X4lHYxcVXU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("X5haUmzi0A")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("x7GgGYJMqy")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("x7xP840Mld")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("x96HzLkrnL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("X9HKnqhH2e")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("x9KFiLSEHh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("X9y3yeME3J")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xaVyuZtLEt")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XaxZjqKUtg")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XaYlq74OLe")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XB1OLh8AAE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xb26uXMW9D")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Xd2O9kSzl9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xdOPItVHqB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XDp2HVdmrA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xeTv23hvV0")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XF9J5NvYmN")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xFTFiiW4LA")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XHe6hqiqml")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XHKp5etH1P")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XI5WkGs2iL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xkSgMA0QYs")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xLUti139pL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xNB0vrW5KY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xp7G32goFp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Xruz4Dcp6n")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xSunujTMrn")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Xt0lQG59Lj")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XTC8R5eByk")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xTpAZEIPtI")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XuEnDyJ3Ck")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("xVKe44sHks")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Xvwp7n29rf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("XXhuTumEJc")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("y0g6fOWL3t")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Y1wlGGAdi1")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Y2bulsE3Ss")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("y48AEW5aBz")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("y6IxwC8Q6u")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Y9bRXfVgWF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YbIhzUdhfl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ycMqaBBVbx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ydr71yikLa")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YegaKVX1ND")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YGMZcnxBWB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YiT1qIskIX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YjAifsuT9M")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YJTyuW9K4j")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yjxHxjwqJZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yjySo0Vtp9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Yk3jAxU28C")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YK7YV0scg9")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yKeThwFNWJ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yLTfcoLTEF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YMgIVuikM7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yn4bKWYRgC")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YnLpOerRCt")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YOt6koLrvq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ypeUt5MPvX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Yq01fvLEVY")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("YQLeFicCeM")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ytg4MkuIOP")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yw0wPPWU91")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yWYntoAguZ")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("yXOilWzHHs")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("z240uxQtLR")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("z49ieBJRSo")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Z5m64msZTU")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Z6zZ2mPnFl")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("z858IUcVOx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zAHOOXYnQm")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZBliiPFhW4")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zBPqg61Twp")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Zbs2MGxAie")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZCLMIbKSfd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZdupwpCzQL")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZKeTENFdUG")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zkPvand2oF")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zLljhOyq5V")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZnjBbsSnGK")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("znNDuRIWKu")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZOjbpoGD1M")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZOVV8qEKBd")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZP2zRrSYdV")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zPgU5Cg57z")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZpPOPpPfet")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zQoMCNuPSs")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Zqp6MHISad")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zS8KeXdaC7")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zsdCu15okh")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZsEIC6VQvX")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZSJI7oNW1x")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zsWx4d4kZB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("Ztbv1bGKLq")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZUoDbTYIKf")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZuU79vH1wB")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zVR537y8WE")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZxE70oZOHx")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("zY5qz6ALIb")>=0);
         * assertTrue(artistVideoLinkService.automaticAddVideoLinkFromYoutube
         * ("ZyL1urJHmb")>=0);
         */

    }

}
