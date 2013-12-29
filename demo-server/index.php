<?php

/**
 * The following function will send a GCM notification using curl.
 * 
 * @param $apiKey		[string] The Browser API key string for your GCM account
 * @param $registrationIdsArray [array]  An array of registration ids to send this notification to
 * @param $messageData		[array]	 An named array of data to send as the notification payload
 */
function sendNotification( $apiKey, $registrationIdsArray, $messageData )
{   
    $headers = array("Content-Type:" . "application/json", "Authorization:" . "key=" . $apiKey);
    $data = array(
        'data' => $messageData,
        'registration_ids' => $registrationIdsArray
    );
 
    $ch = curl_init();
 
    curl_setopt( $ch, CURLOPT_HTTPHEADER, $headers ); 
    curl_setopt( $ch, CURLOPT_URL, "https://android.googleapis.com/gcm/send" );
    curl_setopt( $ch, CURLOPT_SSL_VERIFYHOST, 0 );
    curl_setopt( $ch, CURLOPT_SSL_VERIFYPEER, 0 );
    curl_setopt( $ch, CURLOPT_RETURNTRANSFER, true );
    curl_setopt( $ch, CURLOPT_POSTFIELDS, json_encode($data) );
 
    $response = curl_exec($ch);
    curl_close($ch);
 
    return $response;
}

$message      = "ESTO ES UNA PRUEBA";
$tickerText   = "ESTO ES EL TEXTO DEL TICKER??";
$contentTitle = "TITULO, POR SUPUESTO";
$contentText  = "TEXTO DEL CONTENIDO...";
 
$registrationId = 'APA91bHI8RJktWJRVJ8x-LDdQtGfLj-M0tQrlVJU9s2mvGXIFT8xyhWqkQlFaGsluzzV3xuFjk1Agy3uQdpjxe-Lydp8ZfqfhzQqJPXfGpz7-JcVsOOUbnKRDsutSI8lUEVuzMWA_MXybCZwPZybwhIleWcrXu6iJQ';
$apiKey = "AIzaSyAJPWpPyzOVMVHdc7ZfYtJL1NOa0R8kceI";
 
$response = sendNotification( 
                $apiKey, 
                array($registrationId), 
                array('field1' => $message, 'field2' => $tickerText, 'contentTitle' => $contentTitle, "contentText" => $contentText) );
 
echo $response;