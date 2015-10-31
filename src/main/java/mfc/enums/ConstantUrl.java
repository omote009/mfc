package mfc.enums;

import mfc.consts.Defaults;

public enum ConstantUrl {

    ROOTURL{
        String get(){
            if(Defaults.isPublic() == true){
                return "http://music-fan.club/mfc/";
            }else{
                return "http://localhost:8080/mfc/";

            }
        }
    };
    abstract String get();
}
