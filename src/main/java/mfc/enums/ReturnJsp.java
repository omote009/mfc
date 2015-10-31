package mfc.enums;

public enum ReturnJsp {

    ARTIST_MR_ENTRY{String get(){return "artistMrEntry.jsp";}},
    ARTIST_RANK_LIST{String get(){return "artistRankList.jsp";}};
    abstract String get();

}
