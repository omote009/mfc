package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 曲データ<br/>
 * 曲ごとの感情パラメータデータ<br/>
 * 感情パラムごとに<br/>
 * 雰囲気、サウンド、メロディ、歌詞、ボーカル、演奏、演出、MC,予備、予備の合計１０を文字列で連結
 *
 * @author 正
 *
 */
@Entity
@Table(name="sense_and_song")
public class SenseAndSong extends AbstractEntity {

    @Id
    @Column(name = "song_key")
    private String songKey;

    // わくわく・期待
    @Column(name = "param_str_01")
    private String paramStr01;

    // おもしろい・楽しい
    @Column(name = "param_str_02")
    private String paramStr02;

    // 軽快さ
    @Column(name = "param_str_03")
    private String paramStr03;

    // 心地よい・リラックス
    @Column(name = "param_str_04")
    private String paramStr04;

    // しっとり・落ち着き
    @Column(name = "param_str_05")
    private String paramStr05;

    // 非日常・不思議
    @Column(name = "param_str_06")
    private String paramStr06;

    // かっこいい・美しい
    @Column(name = "param_str_07")
    private String paramStr07;

    // かわいい・愛らしい
    @Column(name = "param_str_08")
    private String paramStr08;

    // おしゃれ・ハイセンス
    @Column(name = "param_str_09")
    private String paramStr09;

    // せつなさ・胸の痛み
    @Column(name = "param_str_10")
    private String paramStr10;

    // 渋い・哀愁
    @Column(name = "param_str_11")
    private String paramStr11;

    // 重厚さ
    @Column(name = "param_str_12")
    private String paramStr12;

    // 不快・不安感
    @Column(name = "param_str_13")
    private String paramStr13;

    // 乾き・イライラ
    @Column(name = "param_str_14")
    private String paramStr14;

    // 日常・等身大
    @Column(name = "param_str_15")
    private String paramStr15;

    @Column(name = "wait")
    private Long wait;

    public String getSongKey() {
        return songKey;
    }

    public void setSongKey(String songKey) {
        this.songKey = songKey;
    }

    public String getParamStr01() {
        return paramStr01;
    }

    public void setParamStr01(String paramStr01) {
        this.paramStr01 = paramStr01;
    }

    public String getParamStr02() {
        return paramStr02;
    }

    public void setParamStr02(String paramStr02) {
        this.paramStr02 = paramStr02;
    }

    public String getParamStr03() {
        return paramStr03;
    }

    public void setParamStr03(String paramStr03) {
        this.paramStr03 = paramStr03;
    }

    public String getParamStr04() {
        return paramStr04;
    }

    public void setParamStr04(String paramStr04) {
        this.paramStr04 = paramStr04;
    }

    public String getParamStr05() {
        return paramStr05;
    }

    public void setParamStr05(String paramStr05) {
        this.paramStr05 = paramStr05;
    }

    public String getParamStr06() {
        return paramStr06;
    }

    public void setParamStr06(String paramStr06) {
        this.paramStr06 = paramStr06;
    }

    public String getParamStr07() {
        return paramStr07;
    }

    public void setParamStr07(String paramStr07) {
        this.paramStr07 = paramStr07;
    }

    public String getParamStr08() {
        return paramStr08;
    }

    public void setParamStr08(String paramStr08) {
        this.paramStr08 = paramStr08;
    }

    public String getParamStr09() {
        return paramStr09;
    }

    public void setParamStr09(String paramStr09) {
        this.paramStr09 = paramStr09;
    }

    public String getParamStr10() {
        return paramStr10;
    }

    public void setParamStr10(String paramStr10) {
        this.paramStr10 = paramStr10;
    }

    public String getParamStr11() {
        return paramStr11;
    }

    public void setParamStr11(String paramStr11) {
        this.paramStr11 = paramStr11;
    }

    public String getParamStr12() {
        return paramStr12;
    }

    public void setParamStr12(String paramStr12) {
        this.paramStr12 = paramStr12;
    }

    public String getParamStr13() {
        return paramStr13;
    }

    public void setParamStr13(String paramStr13) {
        this.paramStr13 = paramStr13;
    }

    public String getParamStr14() {
        return paramStr14;
    }

    public void setParamStr14(String paramStr14) {
        this.paramStr14 = paramStr14;
    }

    public String getParamStr15() {
        return paramStr15;
    }

    public void setParamStr15(String paramStr15) {
        this.paramStr15 = paramStr15;
    }

    public Long getWait() {
        return wait;
    }

    public void setWait(Long wait) {
        this.wait = wait;
    }

}
