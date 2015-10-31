package mfc.utilities;

public class SaftyString {

    private static String STRING_FOR_ERROR = "";
    public static String sqlFilter(final String keyString){

        if( keyString == null){
            return STRING_FOR_ERROR;
        }
        if( keyString.length() == 0){
            return STRING_FOR_ERROR;
        }
        if( keyString.isEmpty()){
            return STRING_FOR_ERROR;
        }

        return keyString;
    }

}
