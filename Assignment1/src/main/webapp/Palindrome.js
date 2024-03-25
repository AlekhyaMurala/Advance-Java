function rev()
  {
	  var n=document.getElementById("Number").value
	  
	 
	   var tmp1=parseInt(n);
	   var rem,rev=0;
	   
	     while(parseInt(n)>0){
			 
			 rem =parseInt(n%10);
			   console.log(rem);
			   rev=rem+(rev*10);
			   n=parseInt(n/10);
		 }
		 
		   document.write(rev)
		   
		     if(rev===tmp1)
		      alert(tmp1+ " is Palindrome")
		      
		     else
		 		   alert(tmp1+ " is not Palindrome")


          
		  
		         /*console.log(tmp1+" : tmp1:  "+ typeof tmp1)
		 		 console.log(rev+":rev: "+typeof rev)
            	 console.log(rem+":rem: "+typeof rem)
		 		 console.log(n+" :n: "+ typeof n)
		         console.log(tmp+":tmp: "+typeof tmp)
                    
 */
 }