//js
var dotLi = document.querySelectorAll(".dotBox li");
var showLi = document.querySelectorAll(".showBox li");

//1、鼠标移到按钮切换对应图片
for (let x = 0; x < dotLi.length; x++) {
	var Li = dotLi[x];

	Li.onmouseenter = function () {
　　　//解决难点问题(当移动时，把i即被指定的按钮下标，赋值给index即可)
		Index = x;
		// 循环遍历所有的li按钮，并清空颜色类名
		for (let y = 0; y < dotLi.length; y++) {
			dotLi[y].className = "";
			showLi[y].className = "";
		}
		// 给点击的按钮，添加颜色类名
		dotLi[x].className = "active";
		showLi[x].className = "show";
	}
}

// 2、自动轮播，定时器
// 图片下标位置，默认为0
var Index = 0;
var Timer = null;
playTime();
function playTime() {
	// var timer = setInterval(function () {
	// timer要改为全局变量
	Timer = setInterval(function () {
		// 每过两秒，下标加一，跳到下一张
		Index++;
		// 当图片走完最后一张，也就是下标为3的时候，跳到第一张
		if (Index == 3) {
			Index = 0;
		}
		for (let j = 0; j < dotLi.length; j++) {
			dotLi[j].className = "";
			showLi[j].className = "";
		}
		// 给点击的按钮，添加颜色类名
		dotLi[Index].className = "active";
		showLi[Index].className = "show";
	}, 2000)
}

//jquery
//3.鼠标移入移除事件
$('.wrapBox').hover(function(){
	clearInterval(Timer);
},function(){
	playTime();
});