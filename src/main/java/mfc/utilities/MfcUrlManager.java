package mfc.utilities;

import mfc.consts.Defaults;

public final class MfcUrlManager {

    private MfcUrlManager() {

    }

    private static final String SAKURA_VPS_URL = "http://music-fan.club/mfc/";
    private static final String LOCAL_URL = "http://localhost:8080/mfc/";

    public static String getBaseUrl() {
        if (Defaults.isPublic()) {
            return SAKURA_VPS_URL;
        } else {
            return LOCAL_URL;
        }
    }

    public static String getBaseUrl(final boolean isPublic) {
        if (isPublic) {
            return SAKURA_VPS_URL;
        } else {
            return LOCAL_URL;
        }
    }

}
