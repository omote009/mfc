package mfc.enums;

public enum ReturnTo {

    ARTIST_MR_ENTRY{String get(){return "/artistMrEntry/";}},
    ARTIST_RANK_LIST{String get(){return "/artistRankList/";}};
    abstract String get();

}
