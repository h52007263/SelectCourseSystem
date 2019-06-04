//初始化
$(document).ready(function(){
	test();
});

function test(){
	
			$.ajax({
			type:"get",
			url:"http://localhost:8080/userAction_getUserByAll",
			success:function(result){
				console.log(result);
				console.log("yes");
			},
			error:function(a,b,c){
				alert("获取json出现异常--查询全部"+a+" "+b+" "+c);
			}
		});
}
