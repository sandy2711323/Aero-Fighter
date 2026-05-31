@echo off
title Aero Fighter - Greenfoot Game Launcher

cd /d "%~dp0"

set "JAR_FILE=Aero Fighter.jar"
set "JAVA8_PATH_1=C:\Program Files\Java\jdk1.8.0_271\bin\java.exe"
set "JAVA8_PATH_2=C:\Program Files\Java\jre1.8.0_271\bin\java.exe"

echo Starting Aero Fighter...
echo.

if not exist "%JAR_FILE%" (
    echo ERROR: "%JAR_FILE%" not found.
    echo Make sure this BAT file is in the same folder as "%JAR_FILE%".
    echo.
    pause
    exit /b 1
)

if exist "%JAVA8_PATH_1%" (
    echo Using Java 8 JDK:
    echo %JAVA8_PATH_1%
    echo.
    "%JAVA8_PATH_1%" -jar "%JAR_FILE%"
    goto END
)

if exist "%JAVA8_PATH_2%" (
    echo Using Java 8 JRE:
    echo %JAVA8_PATH_2%
    echo.
    "%JAVA8_PATH_2%" -jar "%JAR_FILE%"
    goto END
)

echo Java 8 was not found at the expected locations.
echo.
echo This Greenfoot game needs Java 8 because newer Java versions may not include JavaFX.
echo.
echo Please install Java 8, then run this file again.
echo.
echo Expected locations:
echo %JAVA8_PATH_1%
echo %JAVA8_PATH_2%
echo.

:END
echo.
echo Aero Fighter closed.
pause