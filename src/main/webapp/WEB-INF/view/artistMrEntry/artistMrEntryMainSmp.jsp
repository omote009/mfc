<div id="eventDetailArea">
	<s:form method="POST">
		<table>
			<tr>
				<th >
					<c:if test="${isExist == true }">
						<c:if test="${isReadOnlyMode == true }">
    						<s:submit property="toTop" tabindex="-1"><bean:message key="mfc.common.to_top" /></s:submit>
    					</c:if>
    				</c:if>
					<c:if test="${isCommentMode == false }">
<%-- 						<c:if test="${isReadOnlyMode == true }"> --%>
<%-- 						<c:if test="${isReadOnlyMode == false }"> --%>
<%-- 	    					<s:submit property="goBack" tabindex="-1"><bean:message key="mfc.common.back02" /></s:submit> --%>
							<s:submit property="goBack" tabindex="-1"><bean:message key="mfc.common.back02.smp" /></s:submit>
<%-- 						</c:if> --%>
					</c:if>
					<c:if test="${isCommentMode == true }">
	    				<s:submit property="commentCancel" tabindex="-1"><bean:message key="mfc.common.back01" /></s:submit>
					</c:if>
					<c:if test="${isReadOnlyMode == false }">
						<c:if test="${isReInputMode == true }">
		    				<s:submit property="reInputCancel" tabindex="-1"><bean:message key="mfc.common.back03" /></s:submit>
						</c:if>
					</c:if>
				</th>
			</tr>
		</table>
		<h4>${f:h(infoMessage)}</h4>
		<table>
			<tr>
				<th>
					<!--
					<bean:message key="mfc.artist_mr_entry.title00" />
				  	-->
				  	<c:if test="${isLogined == true }">
	   					<c:if test="${isExist == true }">
							<s:submit property="addMyArtist" tabindex="-1"  style="background:url('/mfc/images/BoxIn.png');width:124px;height:35px;border:0px solid;cursor:pointer; font-size:0px;">
								<bean:message key="mfc.event.add_artist" />
							</s:submit>
						</c:if>
						<c:if test="${isExist == false }">
						<c:if test="${isReadOnlyMode == false }">
							<bean:message key="mfc.artist_mr_entry.title00_02" />
						</c:if>
					</c:if>
					</c:if>
					<c:if test="${isLogined == false }">
	   					<c:if test="${isExist == true }">

						</c:if>
					</c:if>

    			</th>
   			</tr>
   		</table>
		<table>





		<tr>
				<td align="left">
	    			<c:if test="${isReadOnlyMode == false }">
						<strong><bean:message key="mfc.artist_mr_entry.name.smp" /></strong><img src="/mfc/images/req.png" align="right" /><br/>
        				<html:text property="artistName" value="${artistName}" style="width:90%" tabindex="1" />
        			</c:if>
	    			<c:if test="${isReadOnlyMode == true }">
	    			<font size="2">${artistKanaName}</font><br>
	    			<b><font size="4">${artistName}</font></b>
        			</c:if>
        			<html:hidden property="artistCode" value="${artistCode}" />
        			<c:if test="${artistNameError != '' }">
        				<br/>${artistNameError}
        			</c:if>
         		</td>
        </tr>
   			<c:if test="${isReadOnlyMode == false }">
		       	<tr>
        	 		<td>
 	    				<strong><bean:message key="mfc.artist_mr_entry.kana_name.smp" /></strong><img src="/mfc/images/req.png" align="right" /><br/>
 	    				<html:text property="artistKanaName" value="${artistKanaName}" style="width:90%" tabindex="2" />
	    			</td>
	    		</tr>
	    	</c:if>
	 	<tr>
			<c:if test="${isReadOnlyMode == true }">
				<input type="hidden" name="input_test" value="${movieUrl}" />
				<td width="120px">
					<div align="center"><div id="player"></div></div>
					<a href="#movieList">他の動画も見る➡</a>
<%-- 					<img src="${artistLinkUrl}" /> --%>
				</td>
			</c:if>
		</tr>




<!-- 			<tr> -->
<!-- 				<td align="left"> -->
<%-- 	    			<c:if test="${isReadOnlyMode == false }"> --%>
<%-- 						<strong><bean:message key="mfc.artist_mr_entry.name.smp" /></strong><img src="/mfc/images/req.png" align="right" /><br/> --%>
<%--         				<html:text property="artistName" value="${artistName}" style="width:90%" tabindex="1" /> --%>
<%--         			</c:if> --%>
<%-- 	    			<c:if test="${isReadOnlyMode == true }"> --%>
<%-- 	    			<b><font size="5">${artistName}</font></b> --%>
<%--         			</c:if> --%>
<%--         			<html:hidden property="artistCode" value="${artistCode}" /> --%>
<%--         			<c:if test="${artistNameError != '' }"> --%>
<%--         				<br/>${artistNameError} --%>
<%--         			</c:if> --%>
<!--          		</td> -->
<!--         	</tr> -->
<%--    			<c:if test="${isReadOnlyMode == false }"> --%>
<!-- 		       	<tr> -->
<!--         	 		<td> -->
<%--  	    				<strong><bean:message key="mfc.artist_mr_entry.kana_name.smp" /></strong><img src="/mfc/images/req.png" align="right" /><br/> --%>
<%--  	    				<html:text property="artistKanaName" value="${artistKanaName}" style="width:90%" tabindex="2" /> --%>
<!-- 	    			</td> -->
<!-- 	    		</tr> -->
<%--  	        </c:if> --%>



<%-- 	      	<c:if test="${isReadOnlyMode == true }"> --%>
<!-- 		       	<tr> -->
<!--         	 		<td colspan= "2"> -->
<%-- 	      				<c:if test="${artistKanaName != ''}"> --%>
<%-- 		    				<strong><bean:message key="mfc.artist_mr_entry.kana_name.smp" /></strong><br/> --%>
<%-- 	      				</c:if> --%>
<%-- 	      				<c:if test="${artistKanaName == ''}"> --%>
<%-- 		    				<span class="weak"><bean:message key="mfc.artist_mr_entry.kana_name.smp" /></span><br/> --%>
<%-- 	      				</c:if> --%>
<%-- 	      				${artistKanaName} --%>
<%--             			${artistKanaNameError} --%>
<!--            		</td> -->
<!--          	</tr> -->
<%--     		</c:if> --%>



    		<c:if test="${isReadOnlyMode == false }">
   				<c:if test="${isExist == true }">
    		    <tr>
     				<td>
						<strong><bean:message key="mfc.artist_mr_entry.one_line_comment.smp" /></strong><br/>
						<html:textarea property="artistAppeal" value="${artistAppeal}" style="width:90%;height:100px" tabindex="4"/>
					</td>
				</tr>
  				</c:if>
  			</c:if>
<%-- 			<c:if test="${isReadOnlyMode == true }"> --%>
<!-- 	 		    <tr> -->
<!--      				<td colspan= "2"> -->
<%-- 						<c:if test="${artistAppeal != ''}"> --%>
<%-- 							<strong><bean:message key="mfc.artist_mr_entry.one_line_comment.smp" /></strong><br/> --%>
<%-- 						</c:if> --%>
<%-- 						<c:if test="${artistAppeal == ''}"> --%>
<%-- 							<span class="weak"><bean:message key="mfc.artist_mr_entry.one_line_comment.smp" /></span><br/> --%>
<%-- 						</c:if> --%>
<%-- 						${artistAppeal} --%>
<!-- 		        	</td> -->
<!--         		</tr> -->
<%-- 			</c:if> --%>
			<c:if test="${isReadOnlyMode == false }">
				<c:if test="${isExist == true }">
			   	<tr>
         			<td>
	         			<strong><bean:message key="mfc.artist_mr_entry.profile.smp" /></strong>
	        			<html:textarea property="artistProfile" value="${artistProfile}" style="width:90%;height:130px" tabindex="3" />
          				<c:if test="${artistProfile == '' }">
						</c:if>
					</td>
				</tr>
				</c:if>
         	</c:if>
      		<c:if test="${isReadOnlyMode == true }">
      			<tr>
      				<td colspan= "2">
      					<c:if test="${artistProfile == '' }">
         				<strong><bean:message key="mfc.artist_mr_entry.profile.smp" /></strong>
<%--          				<c:if test="${isCommentMode == false}"> --%>
<%--          					<s:submit property="toAddComment" tabindex="-1" style="background:url('/mfc/images/plus.png');width:27px;height:27px;border:0px solid;cursor:pointer; font-size:0px;"> --%>
<%-- 								<bean:message key="mfc.artist_mr_entry.add_comment_dummy" /> --%>
<%-- 							</s:submit> --%>
							<br>
<%--          				</c:if> --%>
						</c:if>
						<c:if test="${isCommentMode == true }">
   							<html:textarea property="artistProfile" value="${artistProfile}" style="width:90%;height:130px" tabindex="3" />
							<s:submit property="updateComment" tabindex="-1"><bean:message key="mfc.artist_mr_entry.update_comment" /></s:submit>
						</c:if>
						<c:if test="${isCommentMode == false}">
							${artistProfile}
							<br/>
							<c:if test="${artistProfile != '' }">
 								<s:submit property="toArtistCommentList" tabindex="-1" style="background:url('/mfc/images/moreLook.png');width:103px;height:35px;border:0px solid;cursor:pointer; font-size:0px;">
									<bean:message key="mfc.artist_mr_entry.more_comment" />
								</s:submit>
							</c:if>
						</c:if>
						<c:if test="${isCommentMode == false}">
						&nbsp;&nbsp;&nbsp;
         					<s:submit property="toAddComment" tabindex="-1" style="background:url('/mfc/images/plus.png');width:27px;height:27px;border:0px solid;cursor:pointer; font-size:0px;">
								<bean:message key="mfc.artist_mr_entry.add_comment_dummy" />
							</s:submit>
							<br>
         				</c:if>
					</td>
    			</tr>
			</c:if>
 			<c:if test="${isReadOnlyMode == false }">
				<c:if test="${isExist == true }">
  				<tr>
					<td>
						<strong><bean:message key="mfc.artist_mr_entry.url_01.smp" /></strong><br/>
   						<html:text property="artistUrl01" value="${artistUrl01}" style="width:90%" maxlength="300" tabindex="5" /><br/>
    					<strong><bean:message key="mfc.artist_mr_entry.url_message01_title" /></strong><br/>
						<html:text property="artistUrl03" value="${f:h(artistUrl03)}" style="width:80px" tabindex="6" />
  	 				</td>
				</tr>
				</c:if>
   			</c:if>
			<html:hidden property="artistUrl01" value="${artistUrl01}" />
			<html:hidden property="artistUrl02" value="${artistUrl02}" />
			<c:if test="${isReadOnlyMode == true }">
         	<tr>
          		<td colspan= "2">
          			<c:if test="${artistUrl01 != null}">
         				<bean:message key="mfc.artist_mr_entry.url_01" /><br/>
         			</c:if>
       				<c:if test="${artistUrl01 != null }">
      					<c:if test="${urlOk != ''}">
      						<a href="${artistUrl01}" target="_blank">${artistUrl03}</a>
      					</c:if>
      					<c:if test="${urlOk == ''}">
      						<bean:message key="mfc.artist_mr_entry.url_ok_waitting" />
      					</c:if>
					</c:if>
					<c:if test="${artistUrl01 == ''}">
							<span class="weak"><bean:message key="mfc.artist_mr_entry.one_line_comment.smp" /></span><br/>
					</c:if>
				</td>
			</tr>
   			</c:if>
			<c:if test="${isReadOnlyMode == false }">
				<c:if test="${isExist == true }">
				<tr>
					<td>
						<strong><bean:message key="mfc.artist_mr_entry.url_02.smp" /></strong><br/>
						<html:text property="artistUrl02" value="${artistUrl02}" style="width:90%" tabindex="7" /><br/>
						<span class="exp"><bean:message key="mfc.artist_mr_entry.title03_02_smp" /></span>
					</td>
				</tr>
				</c:if>
			</c:if>
			<c:if test="${isReadOnlyMode == true }">
				<c:if test="${artistUrl02 != null}">
				<tr>
					<td colspan= "2">
						<bean:message key="mfc.artist_mr_entry.url_02" /><br/>
						<a href="${artistUrl02}" target="_blank">${artistUrl04}</a>
					</td>
				</tr>
				</c:if>
   			</c:if>

			<c:if test="${isReadOnlyMode == true }">
				<c:if test="${isExist == true }">
					<tr>
						<td colspan= "2">
							<strong><bean:message key="mfc.artist_mr_url_for_paste" /></strong><br/>
							<span class="exp">${artistUrl06}</span>
						</td>
					</tr>
				</c:if>
			</c:if>

			<c:if test="${isReadOnlyMode == false }">
				<c:if test="${isUrlUpdateOk == true }">
					<c:if test="${isExist == true }">
						<tr>
							<td colspan= "2">
								<strong><bean:message key="mfc.artist_mr_entry.url_01_ok" /></strong><br/>
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
   		<tr>
   			<td colspan= "2">
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


<%--    					<c:if test="${isCommentMode == true }"> --%>
<%-- 						<s:submit property="updateComment" tabindex="-1"><bean:message key="mfc.artist_mr_entry.update_comment" /></s:submit> --%>
<%-- 					</c:if> --%>


				</c:if>
<%--    				<c:if test="${isReadOnlyMode == false }"> --%>
 <%-- 					<c:if test="${isExist == true }"> --%>
 <%-- 						<c:if test="${isDeleteOK == true }"> --%>
<%--  							<s:submit property="deleteArtist" tabindex="-1" onclick="return confirm('æ¬å½ã«åé¤ãã¾ããï¼');"><bean:message key="mfc.artist_mr_entry.delete_event" /></s:submit> --%>
<%--  						</c:if> --%>
<%-- 					</c:if> --%>
<%-- 					<c:if test="${isExist == false }"> --%>
<%--  						</c:if> --%>
<%--     					</c:if> --%>
<%--    				<c:if test="${isReadOnlyMode == true }"> --%>
<%-- 					</c:if> --%>
   			</td>
   		</tr>
   	</table>
   	<table id=movieList>
		<tr>
    		<th>
      			<c:if test="${isReadOnlyMode == true }">
	    				<c:if test="${isExist == true }">
	    					<bean:message key="mfc.artist_mr_entry.title04.exit" />
	    					<s:submit property="addArtistLinkTrue" tabindex="-1" style="background:url('/mfc/images/plus.png');width:27px;height:27px;border:0px solid;cursor:pointer; font-size:0px;">
								<bean:message key="mfc.artist_mr_entry.button.title05" />
							</s:submit>
							<!--
							<s:submit property="doSelectEvent" tabindex="-1">
								<bean:message key="mfc.artist_name.button" />
							</s:submit>
							-->
						</c:if>
						<c:if test="${isExist == false }">
							<bean:message key="mfc.artist_mr_entry.title04" /><br/>
						</c:if>
					</c:if>
	    			<c:if test="${isReadOnlyMode == false }">
	    				<c:if test="${isExist == true }">
	    					<bean:message key="mfc.artist_mr_entry.title04.exit" />
	    					<s:submit property="addArtistLink" tabindex="-1" style="background:url('/mfc/images/plus.png');width:27px;height:27px;border:0px solid;cursor:pointer; font-size:0px;">
								<bean:message key="mfc.artist_mr_entry.button.title05" />
							</s:submit>
							<!--
							<s:submit property="doSelectEvent" tabindex="-1">
								<bean:message key="mfc.artist_name.button" />
							</s:submit>
							-->
						</c:if>
						<c:if test="${isExist == false }">
							<bean:message key="mfc.artist_mr_entry.title04" /><br/>
						</c:if>
					</c:if>
    		</th>
      	</tr>
   	</table>

	<table>
		<c:forEach items="${artistLinkList}" var="artistLinkList">
			<s:form method="POST">
				<tr id="${artistLinkList.artistCode}">
					<td width="120px">
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
					<td align="left">
						<c:if test="${artistLinkList.isMpStr == 'YES'}">
							<a href="${artistLinkList.linkUrl}"><strong>${artistLinkList.dispName}</strong></a>
						</c:if>
						<c:if test="${artistLinkList.isMpStr != 'YES'}">
							<a href="${artistLinkList.linkUrl}" target="_blank"><strong>${artistLinkList.dispName}</strong></a>
						</c:if>

						<html:hidden property="artistCodeForLink" value="${artistLinkList.artistCode}" />
						<html:hidden property="dispNameForLink" value="${artistLinkList.dispName}" />
						<html:hidden property="linkUrl" value="${artistLinkList.linkUrl}" />
						<html:hidden property="artistName" value="${artistName}" />
						<html:hidden property="artistKanaName" value="${artistKanaName}" />
						<html:hidden property="artistProfile" value="${artistProfile}" />
						<html:hidden property="artistAppeal" value="${artistAppeal}" />
						&nbsp;
						<c:if test="${isReadOnlyMode == false }">
							<br/>
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
							<bean:message key="mfc.artist_mr_entry.delete_message" />
							<s:submit property="deleteArtist" tabindex="-1" onclick="return confirm('æ¬å½ã«åé¤ãã¾ããï¼');">
								<bean:message key="mfc.artist_mr_entry.delete_event" />
							</s:submit>
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
		var movies = document.forms[0].input_test.value;
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
			//event.target.playVideo();
		}

		function onPlayerStateChange(event) {
			if (event.data == YT.PlayerState.ENDED) {
				//window.alert('ENDED');
				//player.loadVideoById({videoId:'eGHDrlvypWg'});
			}
		}
		</script>
<!-- 	    ここまでyoutube動画の貼り付け制御だよ。 **************************************************-->


