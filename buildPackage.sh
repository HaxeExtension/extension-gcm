#!/bin/bash
dir=`dirname "$0"`
cd "$dir"
rm -f openfl-gcm.zip
zip -0r openfl-gcm.zip gcmex haxelib.json include.xml dependencies 
