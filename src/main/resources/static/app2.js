var ws;
function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
}

function connect() {
	ws = new WebSocket('ws://localhost:8080/user');
	ws.onopen=function(data){
		
		
	}
	ws.onmessage = function(data) {
		
		helloWorld(data.data);
	}
	setConnected(true);
	
}

function disconnect() {
	if (ws != null) {
		ws.close();
	}
	setConnected(false);
	
}

function sendData(name) {
	var data = JSON.stringify({
		'user' :name
	})
	ws.send(data);
}

i =1,tmp=0;
function helloWorld(message) {

	
	if(message.indexOf('google=')==0)
	{
		alert('google');
	}
		console.log(message.indexOf(':')+'t');
		if(message.indexOf('google:')==0)
			{
			
			 work('#price',message.replace('google:',''));
			
			
			}
		if(message.indexOf('hotmail:')==0)
		{
		
		 work('#price1',message.replace('hotmail:',''));
		
		
		}
		if(message.indexOf('yahoo:')==0)
		{
	
		 work('#price2',message.replace('yahoo:',''));
		
		
		}
		if(message.indexOf('netflix:')==0)
		{
		
		 work('#price3',message.replace('netflix:',''));
		
		
		}
		if(message.indexOf('oracle:')==0)
		{
		
		 work('#price4',message.replace('oracle:',''));
		
		
		}
		
		
		


	
}
txt='';
function combinator(str,i){
	
	return txt;
	
}
function work(id,message){
	b = parseFloat($(id).val());
	$(id).val(message);
	a =message;
	if(a>b){
		
		$(id).css('color','green');
	}
	else{
		
		$(id).css('color','red');
	}
	
	console.log(tmp);
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendData();
	});
});
$( document ).ready(function() {
	  // Handler for .ready() called.
	connect("hello");
	});
