<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Form</title>
    <!-- BootStrap CDN link to get the support of BootStrap -->
    <link rel="stylesheet"
     href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
        
         <!-- This is  java Script validation  code location -->
         <script src="Product.js"></script>
</head>
<body>
	<div class="container mt-5 text-center">
        <h2 class="text-center font-italic mb-1">Save Product Data  </h2>
        <br>
        <form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
          
              <div class="form-group">
                  <label class="font-italic font-weight-bold" for="proId">Product ID: </label>
                  <input type="text" class="form-control-sm" id="proId" name="proId" value="${existingproduct.proId}" required/>
               </div>
          
          
              <div class="form-group">
                  <label class="font-italic font-weight-bold" for="proName">Product Name: </label>
                  <input type="text" class="form-control-sm" id="proName" name="proName" value="${existingproduct.proName}" required/>
               </div>
          
          
                <div class="form-group">
                  <label class="font-italic font-weight-bold" for="proPrice">Product Price: </label>
                  <input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingproduct.proPrice}" required/>
               </div>
               
               <div class="form-group">
                  <label class="font-italic font-weight-bold" for="proBrand">Product Brand: </label>
                  <input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingproduct.proBrand}" required/>
               </div>
          
          
              <div class="form-group">
                  <label class="font-italic font-weight-bold" for="proMadeIn">Product Made In: </label>
                  <input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingproduct.proMadeIn}" required/>
               </div>
          		
          		<div class="form-group">
                  <label class="font-italic font-weight-bold" for="proMfgdate">Product MFG date: </label>
                  <input type="date" class="form-control-sm" id="proMfgdate" name="proMfgdate" value="${existingproduct.proMfgDate}" required/>
               </div>
               
        	  <div class="form-group">
                  <label class="font-italic font-weight-bold" for="proExpdate">Product EXP date: </label>
                  <input type="date" class="form-control-sm" id="proExpdate" name="proExpdate" value="${existingproduct.proExpDate}" required/>
               </div>
                
                

				<!-- Display the current product image -->
                <div class="form-group">
                  <label class="font-italic font-weight-bold" for="proImage">Current Product Image: </label>
                  <img id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingproduct.proImage)}" alt="Current Product Image">
                  <input type="hidden"  id="exsistingImage" name="exsistingImage"   value="${Base64.getEncoder().encodeToString(existingproduct.proImage)}"/>
               	</div>
               
               
               
                <!--  Allow the user to upload a new  image -->
                <div class="form-group">
                  <label class="font-italic font-weight-bold" for="newproImage">New Product Image: </label>
                  <input type="file"  class="form-control-sm"  id="newProImage" name="newProImage" accept="image/*"  required/>
               </div>
               
               <div class="form-group">
				<label class="font-italic font-weight-bold" for="proAudio">Current Product Audio:</label>
				<audio controls>
                        <source src="data:audio/mp3;base64,${Base64.getEncoder().encodeToString(existingproduct.proAudio)}" type="audio/mp3">
                </audio>
				<input type="hidden" id="existingAudio" name="existingAudio" value="${Base64.getEncoder().encodeToString(existingproduct.proAudio)}">
				
			   </div>
			
			   <div class="form-group">
				<label class="font-italic font-weight-bold" for="newProAudio">New Product Audio:</label>
				<input type="file" id="newProAudio" name="newProAudio" accept="audio/*">
			   </div>
			
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proAudio">Current Product Video:</label>
				<video controls width="320" height="240">
                        <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(existingproduct.proVideo)}" type="video/mp4">
                  </video>
				<input type="hidden" id="existingVideo" name="existingVideo" value="${Base64.getEncoder().encodeToString(existingproduct.proVideo)}">
				
			</div>
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="newProVideo">New Product Video:</label>
				<input type="file" id="newProVideo" name="newProVideo" accept="video/*">
				
			</div>
               

               
      	  <div>
             <input type="submit" class="btn btn-success" value="save product"/>
             <a href="Product.jsp" class="btn btn-primary">List of Products</a>
          </div>
      </form>
      </div>
</body>
</html>