/**
 * 
 */
 
function sendDmModal() {
	$.ajax({
		url: "/selectAllMemberId.do",
		success: function(list){
			$("[name=receiver]").empty();
			for(let i=0; i<list.length; i++){
				const option = $("<option>");
				option.val(list[i]);
				option.text(list[i]);
				$("[name=receiver]").append(option);			
			}
	$("#sendDm-modal").css("display","flex");
		}
	});
}

function closeModal(){
	$("#sendDm-modal").hide();
	$("textarea[name=dmContent]").val("");
}

function dmSend(){
	const receiver = $("[name=receiver]").val();
	const dmContent = $("[name=dmContent]").val();
	const sender = $("#memberId").val();
	
	$.ajax({
		url : "/insertDm2.do",
		data: {receiver: receiver, dmContent: dmContent,sender:sender},
		success : function(data){
			if(data == "1"){
				closeModal();
			}else{
			alert("쪽지 보내기 실패");
			}
		}
	});
}

function getSendDm(){
	const sender = $("#sender").val();
	$.ajax({
		url: "/myDmList.do",
		data: {sender:sender},
		success: function(list){
			
			console.log(list);
		}
	});
}
function getReceiveDm(){
	const receiver = $("#sender").val();
	$.ajax({
		url: "/myDmList.do",
		data: {receiver:receiver},
		success: function(list){
		
			console.log(list);
		}
	});
}