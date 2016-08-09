package mfc.tools;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import mfc.condition.ReverseStringComparator;
import mfc.entity.RelevantData;
import mfc.entity.SenseAndSong;
import mfc.service.RelevantDataService;
import mfc.service.SenseAndSongService;
import mfc.service.SongMrService;
import mfc.utilities.InstanceManager;

public final class SearchMusicInEmotion {

    @Resource
    protected SenseAndSongService senseAndSongService;

    @Resource
    protected RelevantDataService relevantDataService;

    @Resource
    protected SongMrService songMrService;

    public SearchMusicInEmotion() {

    }

    private final int LIST_DEFAULT_SIZE = 10;
    private final int LIST_MAX_SIZE = 100;
    private final long WAIT_DELTA_01 = 10L;
    private final long WAIT_DELTA_02 = 20L;
    private final long WAIT_DELTA_03 = 30L;
    private final double THRESHOLD_VALUE = 0.7;

    /**
     * 条件パラメータを受けて、、相関係数が高い順に曲のリストを返す
     *
     * @param emotionParam
     * @param limitReturnListsize
     * @return
     */
    public List<String> getSongKeyListFromEmotion(
            final RelevantData emotionParam, final int limitReturnListSize) {
        return getSongKeyListFromEmotion(emotionParam,limitReturnListSize,false);
    }

    /**
     * 条件パラメータを受けて、、相関係数が高い順に曲のリストを返す
     *
     * @param emotionParam
     * @param limitReturnListsize
     * @return
     */
    public List<String> getSongKeyListFromEmotion(
            final RelevantData emotionParam, final int limitReturnListSize,final boolean isTestMode) {

        // リストの初期化を行い、条件データオブジェクトがNULLなら、空のリストを返す。
        List<String> returnSongKeyList = InstanceManager.newNotAtomicList();
        List<String> workSongKeyList = InstanceManager.newNotAtomicList();

        if (emotionParam == null) {
            return returnSongKeyList;
        }

        // リミットサイズ変数を初期化する。規定の範囲外なら、デフォルトにする
        int maxSize = LIST_DEFAULT_SIZE;
        if (limitReturnListSize > 0 || limitReturnListSize <= LIST_MAX_SIZE) {
            maxSize = limitReturnListSize;
        }

        // 条件パラメータからウエイトを取得し、有効範囲を決めるdeltaを求める
        Long waitParam = emotionParam.getWait();
        Long waitDelta = 0L;
        if (waitParam.longValue() > 0L) {
            if (waitParam.longValue() <= 50L) {
                waitDelta = Long.valueOf(WAIT_DELTA_01);
            } else {
                if (waitParam.longValue() <= 100L) {
                    waitDelta = Long.valueOf(WAIT_DELTA_02);
                } else {
                    waitDelta = Long.valueOf(WAIT_DELTA_03);
                }
            }
        } else {
            waitParam = Long.valueOf(0L);
        }

        List<SenseAndSong> songList = InstanceManager.newNotAtomicList();

        // 　ウエイトとデルタを使って、曲データのリストを取得する
        if(isTestMode){
             songList = getTestData();
        }else{
             songList = senseAndSongService.fetchListFromWait(
                    waitParam.longValue(), waitDelta.longValue());
        }

        if (songList == null || songList.isEmpty()) {
            return returnSongKeyList;
        }

        // 条件データのdouble配列を取得する。
        double[] emotionArray = StatisticsUtilToUseInMfc
                .getDoubleArrayFromStr(getConcatenationStringFromRelevant(emotionParam));

        // 曲のリストから取得したdouble配列」と条件データの配列で相関係数を求める

        for (SenseAndSong s : songList) {
            double[] songArray = StatisticsUtilToUseInMfc
                    .getDoubleArrayFromStr(getConcatenationStringFromSense(s));
            double workCoCo = StatisticsUtilToUseInMfc
                    .getCorrelationCoefficient(emotionArray, songArray);
            // しきい値を超えた曲だけワークリストにセットする
            if (workCoCo >= THRESHOLD_VALUE) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(workCoCo));
                sb.append("@");
                sb.append(s.getSongKey());
                workSongKeyList.add(sb.toString());
            }
        }
        // 降順にソートする
        Collections.sort(workSongKeyList,new ReverseStringComparator());

        // 返却用のリストにセットする
        int counter = 0;
        for(String songStr:workSongKeyList){
            if(counter < maxSize){
                String[] tmpStr = songStr.split("@");
                returnSongKeyList.add(tmpStr[1]);
            }
            counter++;
        }

        return returnSongKeyList;
    }

    /**
     * SenseAndSongクラスから感覚パラメータ部分をすべて連結した文字列を返す。
     *
     * @param relevant
     * @return
     */
    public final String getConcatenationStringFromRelevant(final RelevantData relevant) {
        if (relevant == null) {
            return "";
        }
        StringBuilder tmpParam = new StringBuilder();
        tmpParam.append(relevant.getParamStr01());
        tmpParam.append(relevant.getParamStr02());
        tmpParam.append(relevant.getParamStr03());
        tmpParam.append(relevant.getParamStr04());
        tmpParam.append(relevant.getParamStr05());
        tmpParam.append(relevant.getParamStr06());
        tmpParam.append(relevant.getParamStr07());
        tmpParam.append(relevant.getParamStr08());
        tmpParam.append(relevant.getParamStr09());
        tmpParam.append(relevant.getParamStr10());
        tmpParam.append(relevant.getParamStr11());
        tmpParam.append(relevant.getParamStr12());
        tmpParam.append(relevant.getParamStr13());
        tmpParam.append(relevant.getParamStr14());
        tmpParam.append(relevant.getParamStr15());
        return tmpParam.toString();
    }

    /**
     * SenseAndSongクラスから感覚パラメータ部分をすべて連結した文字列を返す。
     *
     * @param song
     * @return
     */
    public final String getConcatenationStringFromSense(final SenseAndSong song) {
        if (song == null) {
            return "";
        }
        StringBuilder tmpParam = new StringBuilder();
        tmpParam.append(song.getParamStr01());
        tmpParam.append(song.getParamStr02());
        tmpParam.append(song.getParamStr03());
        tmpParam.append(song.getParamStr04());
        tmpParam.append(song.getParamStr05());
        tmpParam.append(song.getParamStr06());
        tmpParam.append(song.getParamStr07());
        tmpParam.append(song.getParamStr08());
        tmpParam.append(song.getParamStr09());
        tmpParam.append(song.getParamStr10());
        tmpParam.append(song.getParamStr11());
        tmpParam.append(song.getParamStr12());
        tmpParam.append(song.getParamStr13());
        tmpParam.append(song.getParamStr14());
        tmpParam.append(song.getParamStr15());
        return tmpParam.toString();
    }



    private List<SenseAndSong> getTestData(){
        List<SenseAndSong> ret = InstanceManager.newNotAtomicList();

         SenseAndSong sg = new SenseAndSong(); sg.setSongKey("xxxxxxxxx003");
         sg.setParamStr01("1111110000"); sg.setParamStr02("1111110000");
         sg.setParamStr03("1111111100"); sg.setParamStr04("0000000000");
         sg.setParamStr05("0000000000"); sg.setParamStr06("0000000000");
         sg.setParamStr07("0000000000"); sg.setParamStr08("0000000000");
         sg.setParamStr09("0000000000"); sg.setParamStr10("0000000000");
         sg.setParamStr11("0000000000"); sg.setParamStr12("0000000000");
         sg.setParamStr13("0000000000"); sg.setParamStr14("0000000000");
         sg.setParamStr15("0000000000"); sg.setWait(20L);
         ret.add(sg);

         SenseAndSong sg1 = new SenseAndSong(); sg1.setSongKey("xxxxxxxxx002");
         sg1.setParamStr01("1111110000"); sg1.setParamStr02("1111100000");
         sg1.setParamStr03("1111111100"); sg1.setParamStr04("1111110000");
         sg1.setParamStr05("0000000000"); sg1.setParamStr06("0000000000");
         sg1.setParamStr07("0000000000"); sg1.setParamStr08("0000000000");
         sg1.setParamStr09("0000000000"); sg1.setParamStr10("0000000000");
         sg1.setParamStr11("0000000000"); sg1.setParamStr12("0000000000");
         sg1.setParamStr13("0000000000"); sg1.setParamStr14("0000000000");
         sg1.setParamStr15("0000000000"); sg1.setWait(25L);
         ret.add(sg1);

         SenseAndSong sg2 = new SenseAndSong(); sg2.setSongKey("xxxxxxxxx001");
         sg2.setParamStr01("1111110000"); sg2.setParamStr02("1111110000");
         sg2.setParamStr03("1111111100"); sg2.setParamStr04("1111110000");
         sg2.setParamStr05("1111110000"); sg2.setParamStr06("0000000000");
         sg2.setParamStr07("0000000000"); sg2.setParamStr08("0000000000");
         sg2.setParamStr09("0000000000"); sg2.setParamStr10("0000000000");
         sg2.setParamStr11("0000000000"); sg2.setParamStr12("0000000000");
         sg2.setParamStr13("0000000000"); sg2.setParamStr14("0000000000");
         sg2.setParamStr15("0000000000"); sg2.setWait(32L);
         ret.add(sg2);

        return ret;
    }


}
