function ConvertToC()
{
	//read the fahrenheitInput store in variable
	const fahrenheitInput =document.getElementById('fahrenheitInput').value;
	
	//convert the fahrenheitInput to celsius
	const celsiusTemperature=(parseFloat(fahrenheitInput)-32)*5/9;
	
	//set  the output to celsius output 
	document.getElementById('celsiusOutput').value=celsiusTemperature.toFixed(2);
}