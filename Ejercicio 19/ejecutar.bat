@echo off
echo ========================================
echo    EJERCICIO 19 - JUEGO DE BANDERAS
echo    Ejercicio 9.2: Componentes graficos
echo ========================================
echo.

:: Verificar si Java esta instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java no esta instalado o no esta en el PATH
    echo Por favor instala Java JDK 11 o superior
    echo Puedes usar el script instalar_dependencias.ps1 del Ejercicio 18
    pause
    exit /b 1
)

echo [INFO] Java detectado correctamente
echo.

:: Mostrar version de Java
echo [INFO] Version de Java:
java -version
echo.

:: Intentar compilacion con JavaFX externo primero
echo [INFO] Intentando compilacion con JavaFX externo...
if exist "C:\javafx-sdk\lib" (
    echo [INFO] JavaFX SDK encontrado en C:\javafx-sdk\lib
    echo [INFO] Compilando con JavaFX externo...
    javac --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml *.java
    
    if %errorlevel% equ 0 (
        echo [SUCCESS] Compilacion exitosa con JavaFX externo
        echo [INFO] Ejecutando aplicacion...
        echo.
        java --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml BanderasApp
        goto :fin
    ) else (
        echo [WARNING] Error en compilacion con JavaFX externo
    )
) else (
    echo [INFO] JavaFX SDK no encontrado en C:\javafx-sdk\lib
)

echo.
echo [INFO] Intentando compilacion con JavaFX incluido en JDK...
javac *.java

if %errorlevel% equ 0 (
    echo [SUCCESS] Compilacion exitosa con JavaFX incluido
    echo [INFO] Ejecutando aplicacion...
    echo.
    java BanderasApp
) else (
    echo [ERROR] Error en la compilacion
    echo.
    echo POSIBLES SOLUCIONES:
    echo 1. Verificar que Java JDK este instalado (no solo JRE)
    echo 2. Instalar JavaFX SDK en C:\javafx-sdk
    echo 3. Usar un JDK que incluya JavaFX (como Oracle JDK 8)
    echo 4. Ejecutar el script instalar_dependencias.ps1 del Ejercicio 18
    echo.
    echo COMANDOS MANUALES:
    echo   Con JavaFX externo:
    echo   javac --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls *.java
    echo   java --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls BanderasApp
    echo.
    echo   Con JavaFX incluido:
    echo   javac *.java
    echo   java BanderasApp
)

:fin
echo.
echo ========================================
echo           EJECUCION COMPLETADA
echo ========================================
pause