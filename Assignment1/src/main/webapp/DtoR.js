function ConvertToR()
{
	//read the fahrenheitInput store in variable
	const dollar =document.getElementById('dollar').value;
	
	//convert the fahrenheitInput to celsius
	const Rupees=parseFloat(dollar*82.91);
	
	//set  the output to celsius output 
	document.getElementById('rupees').value=Rupees.toFixed(2);
}