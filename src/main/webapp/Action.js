
/*----------------------------------------------------------------------NAV_BAR---------------------------------------------------------------------*/

function showSidebar() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.classList.add('show');
}

function hideSidebar() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.classList.remove('show'); 
}


/*----------------------------------------------------------------REGISTER_PAGE_VALIDATION-----------------------------------------------------------*/

function validation(){
	
	var name=document.getElementById("name").value
	var namePattern=/^[A-Za-z]+$/;
	var email=document.getElementById("email").value
	var emailPattern=/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	var phonenumber=document.getElementById("phonenumber").value
	var numberPattern=/[6-9]{1}[0-9]{9}/
	var password=document.getElementById("password").value
	var passwordPattern= /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{4,}$/;
	var confirmpassword=document.getElementById("confirmpassword").value
	var address=document.getElementById("address").value
	
	
	if(name==""){
		document.getElementById("nm").innerHTML="* required"
		return false
	}		
	if(name.match(namePattern))
	true;
	else{
		document.getElementById("nm").innerHTML="* Characters Only [a-z | A-Z]"
		return false
		
	}
	if(name.length<3){
		document.getElementById("nm").innerHTML="* Should contains min 3 Characters"
		return false
		
	}
	document.getElementById("nm").innerHTML="."
	
	if(email==""){
		document.getElementById("em").innerHTML="* required"
		return false
	}
	
	if(email.match(emailPattern))
		true;
	else{
		document.getElementById("em").innerHTML="* Invalid Email"
				return false
		
	}
	document.getElementById("em").innerHTML="."
	
	if(phonenumber==""){
		document.getElementById("pnm").innerHTML="* required"
		return false
	}		
	if(phonenumber.match(numberPattern))
	true;
	else{
		document.getElementById("pnm").innerHTML="* Invalid Number"
		return false
			
	}
	document.getElementById("pnm").innerHTML="."
	
	if(password==""){
		document.getElementById("pm").innerHTML="* required"
		return false
	}		
	if(password.match(passwordPattern))
	true;
	else{
		document.getElementById("pm").innerHTML="* contains [a-z] [A-Z] [0-9][special Characters]"
		return false
			
	}
	document.getElementById("pm").innerHTML="."
	if(confirmpassword==""){
		document.getElementById("cpm").innerHTML="* required"
		return false
	}		
	if(confirmpassword.match(password))
	true;
	else{
		document.getElementById("cpm").innerHTML="* Password should match "
		return false
					
	}
	document.getElementById("cpm").innerHTML="."
	
	if(address==""){
		document.getElementById("am").innerHTML="* required"
		return false
	}		
	if(address.match(addressPattern))
	true;
	else{
		document.getElementById("am").innerHTML="* Invalid address"
		return false
			
	}
	document.getElementById("am").innerHTML="."
		
}

/*---------------------------------------------------------------QUANTITY_VALIDATION----------------------------------------------------------------*/


function changeQuantity(button, amount) {
    var itemId = button.getAttribute('data-item-id');
    var quantityField = document.getElementById('quantity_' + itemId);
    var currentQuantity = parseInt(quantityField.value, 10);
    var newQuantity = currentQuantity + amount;

    if (newQuantity < 1) {
        newQuantity = 1;
    }

    quantityField.value = newQuantity;
}

function validateQuantity(event) {
    var quantityField = event.target;
    var currentQuantity = parseInt(quantityField.value, 10);

    if (currentQuantity < 1 || isNaN(currentQuantity)) {
        quantityField.value = 1;
    }
}

document.addEventListener('DOMContentLoaded', function() {
    var quantityFields = document.querySelectorAll('.quantity-display');
    quantityFields.forEach(function(field) {
        field.addEventListener('input', validateQuantity);
    });
});

function changeQuantity(button, change) {
    var input = document.getElementById('quantity_' + button.getAttribute('data-item-id'));
    var currentValue = parseInt(input.value);
    if (!isNaN(currentValue) && currentValue + change > 0) {
        input.value = currentValue + change;
    }
}


/**--------------------------------------------------------------------*****----------------------------------------------------------------------- */
