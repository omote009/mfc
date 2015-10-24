<div id="artistMrEntry">

	<s:form method="POST">
	<html:hidden property="artistCode" value="${artistCode}" />
		<c:if test="${isReadOnlyMode == false }">
			<div id="contents">
				<p><bean:message key="mfc.artist_entry.msg01" /></P>
				<p><bean:message key="mfc.artist_entry.msg02" /></P>
			</div>
		</c:if>
		<table>
			<tr>
				<th width="73%">
					<h1><bean:message key="mfc.artist_mr.pre_title" />${artistName}<bean:message key="mfc.artist_mr.suf_title" /></h1>
    			</th>
    			<th  width="13%">
    			<c:if test="${isReadOnlyMode == true }">
    				<c:if test="${isLogined == true }">
	    				<c:if test="${isExist == true }">
							<s:submit property="addMyArtist" tabindex="-1">
								<bean:message key="mfc.event.add_artist" />
							</s:submit>
						</c:if>
					</c:if>
				</c:if>
    			</th>
    			<th width="13%">
    				<c:if test="${isReadOnlyMode == false }">
						<c:if test="${isExist == true }">
							<s:submit property="updateArtist" tabindex="-1">
								<bean:message key="mfc.artist_mr_entry.update_entry" />
							</s:submit>
						</c:if>
  						<c:if test="${isExist == false }">
							<s:submit property="updateArtist2" tabindex="-1"><bean:message key="mfc.artist_mr_entry.entry" /></s:submit>
						</c:if>
    				</c:if>
    				<c:if test="${isReadOnlyMode == true }">
    					<c:if test="${isCommentMode == false }">
							<s:submit property="reInput" tabindex="-1"><bean:message key="mfc.artist_mr_entry.re_input" /></s:submit>
						</c:if>
    					<c:if test="${isCommentMode == true }">
							<s:submit property="updateComment" tabindex="-1"><bean:message key="mfc.artist_mr_entry.update_comment" /></s:submit>
						</c:if>
					</c:if>
    			</th>
   			</tr>
   		</table>
		<h4>${f:h(infoMessage)}</h4>
		<c:if test="${isReadOnlyMode == true }">
			<input type="hidden" name="input_test" value="${movieUrl}" /><%-- Actionにある動画ID情報を${movieUrl}に持ってくる --%>
		<table>
	    	<tr>
				<td width="120px">
 					<div align="left"><div id="player"></div></div><!--youtube動画のiflame置き場所 -->
				</td>
				<td align="center">
					<font size="4">${artistKanaName}</font><br>
	    			<b><font size="6">${artistName}</font></b>
         		</td>
        	</tr>
		</table>
		 </c:if>
		<table>
		<c:if test="${isReadOnlyMode == false }">
			<tr>
				<th width="15%">
					<bean:message key="mfc.artist_mr_entry.name" />
						<img src="/mfc/images/req.png" align="right" />
				</th>
				<td width="85%" align="left">
        				<html:text property="artistName" value="${artistName}" style="width:90%" tabindex="1" />
        				<c:if test="${artistName == '' }">
        					<br /><span class="exp"><bean:message key="mfc.artist_mr_entry.name.info" /></span>
        				</c:if>

				</td>
			</tr>
        </c:if>
      	<c:if test="${isReadOnlyMode == false }">
        	<tr>
        		<th width="15%">
        			<bean:message key="mfc.artist_mr_entry.kana_name" />
					<c:if test="${isReadOnlyMode == false }">
						<img src="/mfc/images/req.png" align="right" />
					</c:if>
        		</th>
        		<td width="85%">
    				<html:text property="artistKanaName" value="${artistKanaName}" style="width:90%" tabindex="2" />
       				<c:if test="${artistKanaName == '' }">
						<br /><span class="exp"><bean:message key="mfc.artist_mr_entry.kana_name.info" /></span>
					</c:if>
					<c:if test="${artistKanaNameError != '' }">
        			<br/>${artistKanaNameError}
        			</c:if>
				</td>
			</tr>
       	</c:if>
        <c:if test="${isReadOnlyMode == false }">
			<c:if test="${isExist == true }">
     		<tr>
    			<th width="15%">
    				<bean:message key="mfc.artist_mr_entry.one_line_comment" />
    			</th>
    			<td width="85%">
					<html:textarea property="artistAppeal" value="${artistAppeal}" style="width:90%;height:40px" tabindex="4"/>
    				<c:if test="${artistAppeal == '' }">
						<br /><span class="exp"><bean:message key="mfc.artist_mr_entry.artist_appeal.info" /></span>
					</c:if>
				</td>
			</tr>
			</c:if>
		</c:if>
		<c:if test="${isReadOnlyMode == true }">
			<tr>
    			<th width="15%">
    				<bean:message key="mfc.artist_mr_entry.one_line_comment" />
    			</th>
    			<td width="85%">
					${artistAppeal}
		       	</td>
        	</tr>
		</c:if>
		<c:if test="${isReadOnlyMode == false }">
   			<c:if test="${isExist == true }">
		    <tr>
         		<th width="15%">
         			<bean:message key="mfc.artist_mr_entry.profile" />
         		</th>
         		<td width="85%">
	       			<html:textarea property="artistProfile" value="${artistProfile}" style="width:90%;height:130px" tabindex="3" />
         			<br /><span class="exp"><bean:message key="mfc.artist_mr_entry.artist_profile.info" /></span>
         			<c:if test="${artistProfile == '' }">
					</c:if>
				</td>
			</tr>
			</c:if>
	     </c:if>
	     <c:if test="${isReadOnlyMode == true }">
			<tr>
    	     	<th width="15%">
        	 		<bean:message key="mfc.artist_mr_entry.profile" />
         		</th>
         		<td width="85%">
					<c:if test="${isCommentMode == true }">
   						<html:textarea property="artistProfile" value="${artistProfile}" style="width:90%;height:130px" tabindex="3" />
						<br /><span class="exp"><bean:message key="mfc.artist_mr_entry.artist_profile.info" /></span>
					</c:if>
					<c:if test="${isCommentMode == false}">
						<c:if test="${artistProfile == '' }">
         					<strong><bean:message key="mfc.artist_mr_entry.profile.smp" /></strong>
         				</c:if>
						${artistProfile}
						<br/>
						<c:if test="${artistProfile != '' }">
 							<s:submit property="toArtistCommentList" tabindex="-1">
								<bean:message key="mfc.artist_mr_entry.more_comment" />
							</s:submit>
						</c:if>
						<s:submit property="toAddComment" tabindex="-1">
							<bean:message key="mfc.artist_mr_entry.add_comment" />
						</s:submit>
					</c:if>
		  		</td>
    		</tr>
		</c:if>
 		<c:if test="${isReadOnlyMode == false }">
			<c:if test="${isExist == true }">
			<tr>
				<th width="15%" rowspan="2">
					<bean:message key="mfc.artist_mr_entry.url_01" />
				</th>
				<td width="85%">
   					<html:text property="artistUrl01" style="width:90%" tabindex="5" /><br/>
  		    			<span class="exp"><bean:message key="mfc.artist_mr_entry.title03" /></span>
				</td>
			</tr>
			<tr>
				<td width="100%">
    				<bean:message key="mfc.artist_mr_entry.url_message01_title" />
					<html:text property="artistUrl03" style="width:80px" tabindex="6" />
    				<c:if test="${artistUrl01 != null }">
      					<c:if test="${urlOk != ''}">
      						<bean:message key="mfc.artist_mr_entry.url_sample" />
      						<a href="${artistUrl01}" target="_blank">${artistUrl03}</a>
      					</c:if>
					</c:if>
	    		</td>
        	</tr>
        	</c:if>
   		</c:if>
			<html:hidden property="artistUrl01" value="${artistUrl01}" />
			<c:if test="${isReadOnlyMode == true }">
         	<tr>
         		<th width="15%">
         			<bean:message key="mfc.artist_mr_entry.url_01" />
         		</th>
         		<td width="85%">
       				<c:if test="${artistUrl01 != null }">
      					<c:if test="${urlOk != ''}">
      						<a href="${artistUrl01}" target="_blank">${artistUrl03}(${artistUrl01})</a>
      					</c:if>
      					<c:if test="${urlOk == ''}">
      						<bean:message key="mfc.artist_mr_entry.url_ok_waitting" />
      					</c:if>
					</c:if>
				</td>
			</tr>
   			</c:if>
			<c:if test="${isReadOnlyMode == false }">
				<c:if test="${isExist == true }">
				<tr>
					<th width="15%">
						<bean:message key="mfc.artist_mr_entry.url_02" />
					</th>
					<td width="85%">
						<html:text property="artistUrl02" style="width:90%" tabindex="7" /><br/>
		    			<span class="exp"><bean:message key="mfc.artist_mr_entry.title03_02" /></span>
					</td>
				</tr>
				</c:if>
			</c:if>
			<html:hidden property="artistUrl02" value="${artistUrl02}" />
			<c:if test="${isReadOnlyMode == true }">
				<c:if test="${artistUrl02 != null}">
				<tr>
					<th width="15%">
						<bean:message key="mfc.artist_mr_entry.url_02" />
					</th>
					<td width="85%">
   						<a href="${artistUrl02}" target="_blank">${artistUrl04}</a>
   					</td>
				</tr>
				</c:if>
   			</c:if>


			<c:if test="${isExist == true }">
  			<tr>
				<th width="15%">
					<bean:message key="mfc.artist_mr_url_for_paste" />
				</th>
				<td width="85%">
					<span class="exp">${artistUrl06}</span>
				</td>
			</tr>
			</c:if>
			<c:if test="${isUrlUpdateOk == true }">
				<c:if test="${isReadOnlyMode == false }">
					<c:if test="${isExist == true }">
			<tr>
				<th width="15%">
					<bean:message key="mfc.artist_mr_entry.url_01_ok" />
				</th>
				<td width="85%">
					<html:checkbox property="urlOkCheck"><bean:message key="mfc.artist_mr_entry.url_message03" /></html:checkbox>
					<html:hidden property="urlOk" value="${urlOk}" />
					<bean:message key="mfc.common.space" />
					<a href="${artistUrl01}" target="_blank">${artistUrl03}</a>
					<bean:message key="mfc.common.space" />
					<a href="${artistUrl02}" target="_blank">${artistUrl04}</a>
				</td>
			</tr>
					</c:if>
				</c:if>
			</c:if>
     </table>
    <table>
			<tr>
				<th width="76%">
					<bean:message key="mfc.artist_mr.pre_title" />${artistName}<bean:message key="mfc.artist_mr.suf_title" />
    			</th>
    			<th  width="13%">
    			<c:if test="${isReadOnlyMode == true }">
    				<c:if test="${isLogined == true }">
	    				<c:if test="${isExist == true }">
							<s:submit property="addMyArtist" tabindex="-1">
								<bean:message key="mfc.event.add_artist" />
							</s:submit>
						</c:if>
					</c:if>
				</c:if>
    			</th>
    			<th width="13%">
    			<c:if test="${isReadOnlyMode == false }">
					<c:if test="${isExist == true }">
							<s:submit property="updateArtist" tabindex="-1">
								<bean:message key="mfc.artist_mr_entry.update_entry" />
							</s:submit>
					</c:if>
					</c:if>
					<c:if test="${isReadOnlyMode == true }">
  						<c:if test="${isExist == false }">
							<s:submit property="updateArtist" tabindex="-1"><bean:message key="mfc.artist_mr_entry.entry" /></s:submit>
						</c:if>
    				</c:if>
    				<c:if test="${isReadOnlyMode == true }">
    					<c:if test="${isCommentMode == false }">
							<s:submit property="reInput" tabindex="-1"><bean:message key="mfc.artist_mr_entry.re_input" /></s:submit>
						</c:if>
    					<c:if test="${isCommentMode == true }">
							<s:submit property="updateComment" tabindex="-1"><bean:message key="mfc.artist_mr_entry.update_comment" /></s:submit>
						</c:if>
					</c:if>
    			</th>
<!--     			<th width="13%"> -->
<%--     				<c:if test="${isReadOnlyMode == false }"> --%>
<%-- 						<c:if test="${isExist == true }"> --%>
<%-- 							<c:if test="${isDeleteOK == true }"> --%>
<%-- 								<s:submit property="deleteArtist" tabindex="-1" onclick="return confirm('本当に削除しますか？');"><bean:message key="mfc.artist_mr_entry.delete_event" /></s:submit> --%>
<%-- 							</c:if> --%>
<%-- 						</c:if> --%>
<%--    						<c:if test="${isExist == false }"> --%>
<%-- 						</c:if> --%>
<%--     				</c:if> --%>
<%--     				<c:if test="${isReadOnlyMode == true }"> --%>
<%-- 					</c:if> --%>
<!--     			</th> -->
   			</tr>
   		</table>
   		<table>
			<tr>
    			<td width="100%">
    			<h4>
	    			<c:if test="${isReadOnlyMode == true }">
	    				<c:if test="${isExist == true }">
	    					<bean:message key="mfc.artist_mr_entry.title04.exit" />
	    					<s:submit property="addArtistLinkTrue" tabindex="-1">
								<bean:message key="mfc.artist_mr_entry.button.title05" />
							</s:submit>
							<!--
							<s:submit property="doSelectEvent" tabindex="-1">
								<bean:message key="mfc.artist_name.button" />
							</s:submit>
							-->
						</c:if>
						<c:if test="${isExist == false }">
							<bean:message key="mfc.artist_mr_entry.title04" />
						</c:if>
					</c:if>
	    			<c:if test="${isReadOnlyMode == false }">
	    				<c:if test="${isExist == true }">
	    					<bean:message key="mfc.artist_mr_entry.title04.exit" />
	    					<s:submit property="addArtistLink" tabindex="-1">
								<bean:message key="mfc.artist_mr_entry.button.title05" />
							</s:submit>
							<!--
							<s:submit property="doSelectEvent" tabindex="-1">
								<bean:message key="mfc.artist_name.button" />
							</s:submit>
							-->
						</c:if>
						<c:if test="${isExist == false }">
							<bean:message key="mfc.artist_mr_entry.title04" />
						</c:if>
					</c:if>
				</h4>
    			</td>
       		</tr>
   		</table>

	<table>
		<c:forEach items="${artistLinkList}" var="artistLinkList">
			<s:form method="POST">
				<tr id="${artistLinkList.artistCode}">
					<td width="13%" align="center">
						<c:if test="${artistLinkList.isMpStr == 'YES'}">
						<a href="${artistLinkList.linkUrl}">
							<img src="${artistLinkList.imgLinkUrl}" />
						</a>
						</c:if>
						<c:if test="${artistLinkList.isMpStr != 'YES'}">
						<a href="${artistLinkList.linkUrl}" target="_blank">
							<img src="${artistLinkList.imgLinkUrl}" />
						</a>
						</c:if>
					</td>
					<td width="74%" align="left">
						<span id="types" class="vertical_middle">
							<c:if test="${artistLinkList.isMpStr == 'YES'}">
								<a href="${artistLinkList.linkUrl}">${artistLinkList.dispName}</a>
							</c:if>
							<c:if test="${artistLinkList.isMpStr != 'YES'}">
								<a href="${artistLinkList.linkUrl}" target="_blank">${artistLinkList.dispName}</a>
							</c:if>
						</span>
						<html:hidden property="artistCodeForLink" value="${artistLinkList.artistCode}" />
						<html:hidden property="dispNameForLink" value="${artistLinkList.dispName}" />
						<html:hidden property="linkUrl" value="${artistLinkList.linkUrl}" />
						<html:hidden property="artistName" value="${artistName}" />
						<html:hidden property="artistKanaName" value="${artistKanaName}" />
						<html:hidden property="artistProfile" value="${artistProfile}" />
						<html:hidden property="artistAppeal" value="${artistAppeal}" />
					</td>
					<td width="13%px">
						<c:if test="${isReadOnlyMode == false }">
							<s:submit property="updateArtistLink" tabindex="-1">
								<bean:message key="mfc.artist_mr_entry.button.artistLink" />
							</s:submit>
						</c:if>
						<c:if test="${isReadOnlyMode == true }">

						</c:if>
					</td>
				</tr>
			</s:form>
		</c:forEach>
	</table>
	<c:if test="${isReadOnlyMode == false }">
		<c:if test="${isExist == true }">
			<c:if test="${isDeleteOK == true }">
				<br><br>
				<p align="right">
					<bean:message key="mfc.artist_mr_entry.delete_message" />
					<s:submit property="deleteArtist" tabindex="-1" onclick="return confirm('本当に削除しますか？');"><bean:message key="mfc.artist_mr_entry.delete_event" /></s:submit>
				</p>
			</c:if>
		</c:if>
   		<c:if test="${isExist == false }">
		</c:if>
    </c:if>
    <c:if test="${isReadOnlyMode == true }">
	</c:if>
	</s:form>
 </div>
 <!-- 	    ここからyoutube動画の貼り付け制御だよ。 **************************************************-->
 	<script type="text/javascript">
		var movies = document.forms[1].input_test.value;
		//view();
		makeYoutube();

		function view() {
			//window.alert("view");
			document.write('<div align="left"><div id="player"></div></div>');
		}

		function makeYoutube() {
			//window.alert("makeYoutube");
			var tag = document.createElement('script');
			tag.src = "https://www.youtube.com/iframe_api";
			var firstScriptTag = document.getElementsByTagName('script')[0];
			firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
		}
		function onYouTubeIframeAPIReady() {
			//window.alert("onYouTubeIframeAPIReady");
			player = new YT.Player('player',{
				height: '178',
				width: '315',
				videoId: movies,
				events: {
					'onReady': onPlayerReady,
					'onStateChange': onPlayerStateChange
				}
			}
			);
			//var currentVol = ytPlayer.getVolume();
    		//ytPlayer.setVolume(currentVol - 100);
		}
		function onPlayerReady(event) {
			//window.alert("onPlayerReady");
			//player.loadPlaylist({playlist:movie});
		}

		function onPlayerStateChange(event) {
			if (event.data == YT.PlayerState.ENDED) {
				//window.alert('ENDED');
				//player.loadVideoById({videoId:'eGHDrlvypWg'});
			}
		}
		</script>
<!-- 	    ここまでyoutube動画の貼り付け制御だよ。 **************************************************-->

