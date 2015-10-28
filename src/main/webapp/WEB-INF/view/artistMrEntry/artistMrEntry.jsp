<!DOCTYPE html>
<html lang="ja">

<head>
<c:import url="/WEB-INF/view/common/commonSetting.jsp"
    charEncoding="utf-8" />
<script type="text/javascript" src="/mfc/js/mfc/index.js"></script>

<script>
    $(function() {
        $(document).EnterTab({
            Enter : true,
            Tab : true
        });
    });
</script>
</head>

<body>
    <c:if test="${isMobile == false}">
        <div id="body_box">

            <div id="top_ad_box">
                <c:import url="/WEB-INF/view/common/topAdDisplay.jsp"
                    charEncoding="utf-8" />
            </div>

            <div id="menu_box">
                <c:import url="/WEB-INF/view/artistMrEntry/artistMrEntryMenuForPc.jsp"
                    charEncoding="utf-8" />
            </div>

            <div id="main_contents_box">
                <c:import url="/WEB-INF/view/artistMrEntry/artistMrEntryMainForPc.jsp"
                        charEncoding="utf-8" />
            </div>

            <div id="jump_to_pagetop_box">
                <a href="#body_box" tabindex="-1"><bean:message
                        key="mfc.common.to_pagetop" /></a>
            </div>

            <div id="bottom_ad_box">
                <hr />
                <c:import url="/WEB-INF/view/common/bottomAdDisplay.jsp"
                    charEncoding="utf-8" />
            </div>
        </div>
        <!-- top end -->
    </c:if>
    <c:if test="${isMobile == true}">
        <div id="body_mobile_box">
            <div id="top_ad_mobile_box">
                <c:import url="/WEB-INF/view/common/topAdMobileDisplay.jsp"
                    charEncoding="utf-8" />
            </div>

            <div id="main_contents_mobile_box">
                  <c:import
                      url="/WEB-INF/view/artistMrEntry/artistMrEntryMainForMobile.jsp"
                      charEncoding="utf-8" />
            </div>

            <div id="bottom_ad_mobile_box">
                <hr />
                <c:import url="/WEB-INF/view/common/bottomAdMobileDisplay.jsp"
                    charEncoding="utf-8" />
            </div>
        </div>
    </c:if>

</body>
</html>