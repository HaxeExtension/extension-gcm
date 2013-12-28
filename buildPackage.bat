@echo off
SET dir=%~dp0
cd %dir%
if exist openfl-gcm.zip del /F openfl-gcm.zip
winrar a -afzip openfl-gcm.zip gcmex haxelib.json include.xml dependencies
pause
REM rm -f openfl-gcm.zip
REM zip -0r openfl-gcm.zip gcmex haxelib.json include.xml dependencies 
