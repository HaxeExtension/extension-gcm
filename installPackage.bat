@echo off
SET dir=%~dp0
cd %dir%
haxelib remove openfl-gcm
haxelib local openfl-gcm.zip
