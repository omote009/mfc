<s:form method="POST">
	<ul>
	<li>
		<c:if test="${isExist == true }">
    		<bean:message key="mfc.common.menu00" /><s:submit property="toTop" tabindex="-1"><bean:message key="mfc.common.to_top" /></s:submit>
    	</c:if>
	</li>
	<li>
	<c:if test="${isCommentMode == false }">
	    <bean:message key="mfc.common.menu00" /><s:submit property="goBack" tabindex="-1"><bean:message key="mfc.common.back02" /></s:submit>
	</c:if>
	<c:if test="${isCommentMode == true }">
	    <bean:message key="mfc.common.menu00" /><s:submit property="commentCancel" tabindex="-1"><bean:message key="mfc.common.back01" /></s:submit>
	</c:if>
	</li>
	<li>
	<c:if test="${isReadOnlyMode == false }">
		<c:if test="${isReInputMode == true }">
		    <bean:message key="mfc.common.menu00" /><s:submit property="reInputCancel" tabindex="-1"><bean:message key="mfc.common.back03" /></s:submit>
		</c:if>
	</c:if>
	</li>
	<li>&nbsp;&nbsp;</li>
	<li></li>
	</ul>
</s:form>
