<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">

<head>
<link rel="canonical" href="${canonicalUrl}" />
<c:import url="/WEB-INF/view/common/commonMfcArtist.jsp" charEncoding="utf-8" />
<script type="text/javascript" src="/mfc/js/mfc/index.js"></script>

<script>
 $(function() {
	   $(document).EnterTab({Enter:true,Tab:true});
 } );
</script>
</head>

<body>
<c:if test="${isSmp == false}">
	<div id="top">
		<!-- header start -->
		<div id="header">
			<c:import url="/WEB-INF/view/common/header.jsp" charEncoding="utf-8" />
		</div>
		<!-- header end -->

		<!-- menu start -->
		<div id="dmenu">
			<c:import url="/WEB-INF/view/artistMrEntry/artistMrEntryMenu.jsp" charEncoding="utf-8" />
		</div>
		<!-- menu end -->

   		<div id="contents">
      		<div id="mainWideDetail">

      			<!-- eventDetailArea start -->
      				<c:import url="/WEB-INF/view/artistMrEntry/artistMrEntryMain.jsp" charEncoding="utf-8" />
    	 	</div><!-- main end-->
   		</div><!-- contents end -->
		<div id="pageTop">
			<a href="#top" tabindex="-1"><bean:message key="mfc.common.to_pagetop" /></a>
		</div><!-- pageTop end -->

		<div id="footer">
			<hr />
			<c:import url="/WEB-INF/view/common/copyrightFooter.jsp" charEncoding="utf-8" />
		</div><!-- footer end -->
	</div><!-- top end -->
</c:if>
<c:if test="${isSmp == true}">
	<div id="topSmp">
		<!-- header start -->
		<div id="headerSmp">
			<c:import url="/WEB-INF/view/common/headerSmp.jsp" charEncoding="utf-8" />
		</div>
		<!-- header end -->

		<!-- menu start
		<div id="dmenuSmp">
			<h3><c:import url="/WEB-INF/view/artistMrEntry/artistMrEntryMenuSmp.jsp" charEncoding="utf-8" /></h3>
		</div>
		-->
		<!-- menu end -->

   		<div id="contentsSmp">
      		<div id="mainWideSmp">

      			<!-- eventDetailArea start -->
      				<c:import url="/WEB-INF/view/artistMrEntry/artistMrEntryMainSmp.jsp" charEncoding="utf-8" />
    	 	</div><!-- main end-->
   		</div><!-- contents end -->
		<div id="footerSmp">
			<hr />
			<c:import url="/WEB-INF/view/common/copyrightFooterSmp.jsp" charEncoding="utf-8" />
		</div><!-- footer end -->
	</div><!-- top end -->
</c:if>

</body>
</html>