package mfc.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class InstanceManager {

    /**
     * AtomicなMapオブジェクトを返す<br />
     * @param <T>
     * @param <K>
     *
     * @return
     */
    public static <T, K> Map<T,K> newAtomicMap() {
        return new ConcurrentHashMap<T,K>();
    }

    /**
     * AtomicではないMapオブジェクトを返す<br />
     *
     * @return
     */
    public static  <T, K> Map<T,K> newNotAtomicMap() {
        return new HashMap<T,K>();
    }

    /**
     * パフォーマンスを考慮し、こちらでは標準をAtomicでない方にする。<br/>
     *
     * @return
     */
    public static <T, K> Map<T,K> newMap() {
        return newNotAtomicMap();
    }

     /**
     *
     * Listのインスタンス生成。<br>
     * <br>
     * スレッドセーフ版。<br>
     * 利用方法：<br>
     * List<String> a = ListFactory.newInstance();<br>
     * ジェネリックの型は左辺から自動判別を行う。<br />
     *
     * @param <K>
     *            型
     * @return Listのインスタンス
     */
    public static <K> List<K> newAtomicList() {
        return new CopyOnWriteArrayList<K>();
    }

     /**
     *
     * Listのインスタンス生成。<br>
     * <br>
     * スレッドセーフではない版。<br>
     * 利用方法：<br>
     * List<String> a = ListFactory.newInstance();<br>
     * ジェネリックの型は左辺から自動判別を行う。<br />
     *
     * @param <K>
     *            型
     * @return Listのインスタンス
     */
    public static <K> List<K> newNotAtomicList() {
        return new ArrayList<K>();
    }

    /**
     * パフォーマンスを考慮し、こちらでは標準をAtomicでない方にする。<br/>
     *
     * @return
     */
    public static <K> List<K> newList() {
        return new ArrayList<K>();
    }


}
