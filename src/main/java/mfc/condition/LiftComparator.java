package mfc.condition;

import java.util.Comparator;

import org.seasar.framework.util.StringUtil;

public class LiftComparator implements Comparator<String> {

    @Override
    public int compare(String src1, String src2) {
        if(StringUtil.isBlank(src1)){
            src1 = "";
        }
        if(StringUtil.isBlank(src2)){
            src2 = "";
        }

        return src2.compareTo(src1);
    }

}
