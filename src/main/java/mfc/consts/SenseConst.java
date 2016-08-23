package mfc.consts;

public class SenseConst {

    /*
     * 感情パラメータを感じた曲の要素をパラメータ化したもの。配列の添字を返す。
     */
    public static int getSubParamsArraySize(){
        return 10;
    }

    // 雰囲気
    public static int getSubMood(){
        return 0;
    }
    //　サウンド
    public static int getSubSound(){
        return 1;
    }
    //　メロディ
    public static int getSubMelody(){
        return 2;
    }
    //歌詞
    public static int getSubLyric(){
        return 3;
    }
    //　ボーカル
    public static int getSubVocal(){
        return 4;
    }
    //　演奏
    public static int getSubPlay(){
        return 5;
    }
    //　演出
    public static int getSubStaging(){
        return 6;
    }
    //　MC　しゃべり
    public static int getSubMc(){
        return 7;
    }
    //　その他要素０１
    public static int getSubOther01(){
        return 8;
    }
    //　その他要素０２
    public static int getSubOther02(){
        return 9;
    }

    /*
     * 感情パラメータも画面から受け取って配列化する。その添字を返す。
     */
    public static int getMainArraySize(){
        return 15;
    }

    // わくわく・期待
    public static int getMainThrilledAndHope(){
        return 0;
    }

    // おもしろい・楽しい
    public static int getMainHappyAndAmusing(){
        return 1;
    }

    // 軽快さ
    public static int getMainLight(){
        return 2;
    }

    // 心地よい・リラックス
    public static int getMainPleasantAndRelax(){
        return 3;
    }

    // しっとり・落ち着き
    public static int getMainMoistAndCalm(){
        return 4;
    }

    // 非日常・不思議
    public static int getMainFantasticAndMystery(){
        return 5;
    }

    // かっこいい・美しい
    public static int getMainCool(){
        return 6;
    }

    // かわいい・愛らしい
    public static int getMainCuteAndLovely(){
        return 7;
    }

    // おしゃれ・ハイセンス
    public static int getMainStylish(){
        return 8;
    }

    // せつなさ・胸の痛み
    public static int getMainSad(){
        return 9;
    }

      // 渋い・哀愁
    public static int getMainAdult(){
        return 10;
    }

    // 重厚さ
    public static int getMainHeavy(){
        return 11;
    }

    // 不快・不安感
    public static int getMainAnxiety(){
        return 12;
    }

    // 乾き・イライラ
    public static int getMainDryAndFrustrating(){
        return 13;
    }

    // 日常・等身大
    public static int getMainUsual(){
        return 14;
    }

}
