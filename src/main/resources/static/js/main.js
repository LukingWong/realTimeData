var connectButt = document.querySelector('#connect');
    $(document).ready(function() {

		$.get("http://localhost:8080/all", function(data, status) {
			var trHTML = '';
			$.each(data, function(i, item) {
				trHTML += '<tr><td>' + item.nameoftribe + '</td><td>' + item.chief + '</td></tr>';
			});

			$('#tribeTable').append(trHTML);
		});

		

	});
	
	function connect(event) {
	    
	        var socket = new SockJS('/ws');
	        stompClient = Stomp.over(socket);

	        stompClient.connect({}, onConnected, onError);
	    
	    
	}
	
	function onConnected() {
		// Subscribe to the Public Channel
        console.log("connection established");
		stompClient.subscribe('/channel/public', onMessageReceived);

		
	}
	
	function onError(error) {
	    alert("connection failed, retrying");
	    for (i = 0; i < 2; i++) { 
	    	connect();
	    }
	    
	}
    
    function onMessageReceived(payload) {
    	$("#tribeTable tr").remove();
    var message = JSON.parse(payload.body);
    var trHTML = '';
	$.each(message, function(i, item) {
		trHTML += '<tr><td>' + item.nameoftribe + '</td><td>' + item.chief + '</td></tr>';
	});

	$('#tribeTable').append(trHTML);
    
}