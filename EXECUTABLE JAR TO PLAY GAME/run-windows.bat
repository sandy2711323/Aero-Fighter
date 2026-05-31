@echo off

if exist "C:\Program Files\Java\jre1.8.0_271\bin\java.exe" (
    "C:\Program Files\Java\jdk1.8.0_271\bin\java.exe" -jar "Aero Fighter.jar"
) else if exist "C:\Program Files\Java\jdk1.8.0_271\bin\java.exe" (
    "C:\Program Files\Java\jdk1.8.0_271\bin\java.exe" -jar "Aero Fighter.jar"
) else (
    echo Java 8 not found.
    echo Please install Java 8, then run this file again.
)

pause