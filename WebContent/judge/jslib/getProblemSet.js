var xmlhttp;
var jsonArray;

function getProblemSet() {
	var page = document.getElementById("page").value;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
		if (xmlhttp.overrideMimeType) {
			xmlhttp.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) {
		var activexName = [ "MSXML2.XMLHTTP", "Microsoft.XMLHTTP" ];
		for (var i = 0; i < activexName.length; i++) {
			try {
				xmlhttp = new ActiveXObject(activexName[i]);
				break;
			} catch (e) {
			}
		}
	}

	xmlhttp.onreadystatechange = callback;
	xmlhttp.open("POST", "GetProblem", true);
	xmlhttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlhttp.send("page=" + page);

}
/*
function callback() {
	if (xmlhttp.readyState == 4) {
		if (xmlhttp.status == 200) {

			jsonArray = JSON.parse(xmlhttp.responseText);
			var jsArray = eval(jsonArray.result);
			var divNode = document.getElementById("result");
			divNode.innerHTML = "获取题目中。。。";
			if (result) {
				var inputText = "";
				for ( var json in jsArray) {
					for ( var key in jsonArray[json]) {
						inputText += jsonArray[json][key] + ";"
					}
				}
				divNode.innerText = inputText;
				return false;
			}
		} else {
			alert("出错了！！！");
		}
	}
}
*/
function callback() {
	if (xmlhttp.readyState == 4) {
		if (xmlhttp.status == 200) {

			jsonArray = JSON.parse(xmlhttp.responseText);
			var jsArray = eval(jsonArray.result);
			var divNode = document.getElementById("result");
			divNode.innerHTML = "获取题目中。。。";
			if (result) {
				var Text = "";

				$.each(jsArray, function(index,value){
					Text += jsArray[index].problem_id;
					Text += jsArray[index].title;
					Text += jsArray[index].accepted;
					Text += jsArray[index].submit;
				});
				divNode.innerText = Text;
				return false;
			}
		} else {
			alert("出错了！！！");
		}
	}
}


