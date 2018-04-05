
function testeGet(){
	$.ajax({
		type:"GET",
		url:"/todolist/REQUISITAR",
		dataType: 'text',
		beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success:function(resultado){
        	console.log(resultado);
        	$("#get").val(resultado);
        },
        error:function(err){
        	console.log(err);
        }
	});
	
	
}

function testePost(){
	
	$.ajax({
		type:"POST",
		url:"/todolist/POSTAR",
		data:"POSTEI ISSO",
		dataType: 'text',
		beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success:function(resultado){
        	console.log(resultado);
        	$("#post").val(resultado);
        	
        },
        error:function(err){
        	console.log(err);
        }
	});
	
}


