@echo off
title Java JAR Launcher

cd /d "%~dp0"

echo ==========================================
echo        Generic Java JAR Launcher
echo ==========================================
echo.

REM If user passes jar name as argument, use it
if not "%~1"=="" (
    set "JAR_FILE=%~1"
    goto CHECK_JAR
)

REM Auto-detect JAR in current folder
set "JAR_COUNT=0"
set "JAR_FILE="

for %%F in (*.jar) do (
    set /a JAR_COUNT+=1
    set "JAR_FILE=%%F"
)

if "%JAR_COUNT%"=="0" (
    echo ERROR: No .jar file found in this folder.
    echo Put this BAT file in the same folder as your JAR.
    echo.
    pause
    exit /b 1
)

if not "%JAR_COUNT%"=="1" (
    echo ERROR: Multiple .jar files found in this folder.
    echo Please run like this:
    echo.
    echo run-windows.bat "Your Game.jar"
    echo.
    echo JAR files found:
    dir /b *.jar
    echo.
    pause
    exit /b 1
)

:CHECK_JAR
if not exist "%JAR_FILE%" (
    echo ERROR: "%JAR_FILE%" not found.
    echo.
    pause
    exit /b 1
)

echo JAR selected:
echo "%JAR_FILE%"
echo.

REM Preferred Java 8 locations
set "JAVA8_JDK=C:\Program Files\Java\jdk1.8.0_271\bin\java.exe"
set "JAVA8_JRE=C:\Program Files\Java\jre1.8.0_271\bin\java.exe"

if exist "%JAVA8_JDK%" (
    echo Using Java 8 JDK:
    echo "%JAVA8_JDK%"
    echo.
    "%JAVA8_JDK%" -jar "%JAR_FILE%"
    goto END
)

if exist "%JAVA8_JRE%" (
    echo Using Java 8 JRE:
    echo "%JAVA8_JRE%"
    echo.
    "%JAVA8_JRE%" -jar "%JAR_FILE%"
    goto END
)

echo Java 8 not found at expected locations.
echo Trying default Java from PATH...
echo.

java -version
echo.

java -jar "%JAR_FILE%"

:END
echo.
echo Program closed.
pause