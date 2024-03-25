function validateForm()
{
	//Read the form Data
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var proMadeIn=document.getElementById("proMadeIn").value;
	
	
	if(proId.trim() === "" || proName.trim() === "" ||
	proPrice.trim() === "" || proBrand.trim() === ""||
	proMadeIn.trim() === "")
	{
		alert("All fields must be filled out");
		return false;
	}
	
	
	if(parseFloat(proPrice) < 0)
	{
		alert("Product Price must be a non-negative value");	
		return false;
	}
	
	
	if(proName.length > 50 || proBrand.length > 50)
	{
		alert("Product name and brand must be less than 50 Characters");
		return false;
	}
	
	//get the mfg & exp dates
	var proMfgDate=document.getElementById("proMfgDate").value;
	var proExpDate=document.getElementById("proExpDate").value;
	
	//convert into data format
	var manufacturingDataObj = new Date(proMfgDate);
	var expiryDateObj = new Date(proExpDate);
	
	//Check the validation of dates
	if(manufacturingDataObj > expiryDateObj)
	{
		alert("manufacturing date cannot be grater than expiry date.");
		return false;
	}
	return true;
}