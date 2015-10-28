//YoutubeのJSファイルをロードします。
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// YoutubeのJSファイルがロードされ実行されると、
// onYouTubeIframeAPIReadyメソッドが呼ばれるので、
// 再生準備を行います。
var player;
function onYouTubeIframeAPIReady() {
  // "player"という文字列は、divのID属性の値を指定します。
  player = new YT.Player('player',{
   // height: '510',
   // width: '854',
   // videoId: 'M7lc1UVf-VE',
    events: {
      'onReady': onPlayerReady,
      'onStateChange': onPlayerStateChange
    }
  });
}

// 再生が可能になると呼び出されます。
function onPlayerReady(event) {
	//player.addEventListener('onStateChange','onPlayerStateChange');
  // iPhoneでもAndroidでも無い場合のみ
  if (navigator.userAgent.toLowerCase().indexOf('iphone') !== -1
      && navigator.userAgent.toLowerCase().indexOf('mobile') !== -1) {
     // 再生を開始します。
     event.target.playVideo();
  } else {
    // iPhoneの場合には、自動再生せず、
    // iframe上に(自動で出る）出る再生ボタンを押してもらって再生をします。
  }
}

// 再生した、停止したなどのプレーヤーのステータスが変わった場合に
// 呼び出されます。
function onPlayerStateChange(event) {

	//window.alert('oooo');
	if (event.data == YT.PlayerState.ENDED) {
	  //event.target.playVideo();
  }
}
