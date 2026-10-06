@echo off
cd /d "%~dp0"
if not exist out mkdir out
javac -encoding UTF-8 -d out src\main\java\mx\unam\aragon\ico\edd\listas\*.java
if errorlevel 1 (pause & exit /b 1)
java -cp out mx.unam.aragon.ico.edd.listas.DemoListaLigada
pause
