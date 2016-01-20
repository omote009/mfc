package mfc.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.seasar.framework.util.ResourceUtil;

public final class SimilarKeyOperateManager {

    private SimilarKeyOperateManager(){

    }

    /**
     * ファイルを読み、登録されているテキストを連結したテキストを返す。<br/>
     * テキストは、正規表現で利用できる形式で、かつリストにする。
     */
    public static List<String> getRegexpPatternList(){
        String fileName = "similar_key.txt";
        List<String> returnList = InstanceManager.newAtomicList();

        if(ResourceUtil.isExist(fileName)){
            File file = ResourceUtil.getResourceAsFile(fileName);
            if(file != null){
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    try {
                        String line;
                        while((line = br.readLine()) != null){
                            StringBuilder sb = new StringBuilder();
                            String[] ar = line.split(",");
                            for(int i = 0;i < ar.length;i++){

                                if(i == 0){
                                    sb.append("^.*(");
                                    sb.append(StringPrescribedManager.convertForMatch(ar[i]));
                                }else{
                                    sb.append("|");
                                    sb.append(StringPrescribedManager.convertForMatch(ar[i]));
                                }
                            }
                            sb.append(").*$");
                            returnList.add(sb.toString());
                        }
                    } catch (IOException e) {
                        System.out.println("IOException");
                    }
                } catch (FileNotFoundException e) {
                    return returnList;
                }
            }
        }
        return returnList;
    }

}
