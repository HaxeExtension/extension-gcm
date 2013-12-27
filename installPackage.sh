#!/bin/bash
dir=`dirname "$0"`
cd "$dir"
haxelib remove openfl-gcm
haxelib local openfl-gcm.zip
