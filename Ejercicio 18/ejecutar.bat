@echo off
echo ====================================
echo    Agenda de Contactos - JavaFX
echo ====================================
echo.

REM Verificar si Java está instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java no está instalado o no está en el PATH
    echo Por favor instale Java 8 o superior
    pause
    exit /b 1
)

echo Compilando la aplicación...
echo.

REM Compilar sin módulos (más simple)
javac *.java
if %errorlevel% neq 0 (
    echo ERROR: Error en la compilación
    echo Verifique que JavaFX esté correctamente configurado
    pause
    exit /b 1
)

echo Compilación exitosa!
echo.
echo Ejecutando la aplicación...
echo.

REM Ejecutar la aplicación
java ContactosApp

echo.
echo Aplicación finalizada.
pause