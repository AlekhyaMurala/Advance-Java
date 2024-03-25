function reversed() 
{
	const string = document.getElementById("stringValue").value;
	var re = "";
	for (i = string.length - 1; i >= 0; i--) 
	{
		re = re + string.charAt(i);
	}                     
	document.getElementById("reversest").value = re;
}