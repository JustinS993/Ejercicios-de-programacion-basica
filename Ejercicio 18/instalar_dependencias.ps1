# Script de instalación automática para Java JDK y JavaFX
# Ejecutar como administrador en PowerShell

Write-Host "====================================================" -ForegroundColor Green
Write-Host "    INSTALADOR AUTOMÁTICO DE JAVA JDK Y JAVAFX    " -ForegroundColor Green
Write-Host "====================================================" -ForegroundColor Green
Write-Host ""

# Verificar si se ejecuta como administrador
if (-NOT ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator")) {
    Write-Host "ERROR: Este script debe ejecutarse como administrador." -ForegroundColor Red
    Write-Host "Haga clic derecho en PowerShell y seleccione 'Ejecutar como administrador'" -ForegroundColor Yellow
    Read-Host "Presione Enter para salir"
    exit 1
}

# Función para descargar archivos
function Download-File {
    param(
        [string]$Url,
        [string]$OutputPath
    )
    
    try {
        Write-Host "Descargando desde: $Url" -ForegroundColor Cyan
        Invoke-WebRequest -Uri $Url -OutFile $OutputPath -UseBasicParsing
        Write-Host "Descarga completada: $OutputPath" -ForegroundColor Green
        return $true
    }
    catch {
        Write-Host "Error al descargar: $($_.Exception.Message)" -ForegroundColor Red
        return $false
    }
}

# Crear directorio temporal
$tempDir = "$env:TEMP\JavaFX_Install"
if (!(Test-Path $tempDir)) {
    New-Item -ItemType Directory -Path $tempDir -Force | Out-Null
}

Write-Host "Directorio temporal: $tempDir" -ForegroundColor Yellow
Write-Host ""

# Verificar si Java ya está instalado
Write-Host "Verificando instalación de Java..." -ForegroundColor Cyan
try {
    $javaVersion = java -version 2>&1
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Java ya está instalado:" -ForegroundColor Green
        Write-Host $javaVersion -ForegroundColor White
        $installJava = Read-Host "¿Desea reinstalar Java? (s/n)"
        if ($installJava -ne 's' -and $installJava -ne 'S') {
            $installJava = $false
        } else {
            $installJava = $true
        }
    } else {
        $installJava = $true
    }
}
catch {
    $installJava = $true
}

if ($installJava) {
    Write-Host ""
    Write-Host "=== INSTALANDO JAVA JDK ===" -ForegroundColor Yellow
    
    # URLs de descarga (estas pueden cambiar, verificar en oracle.com)
    $jdkUrl = "https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe"
    $jdkInstaller = "$tempDir\jdk-installer.exe"
    
    Write-Host "Descargando Java JDK 21..." -ForegroundColor Cyan
    
    # Intentar descargar JDK
    if (Download-File -Url $jdkUrl -OutputPath $jdkInstaller) {
        Write-Host "Ejecutando instalador de Java JDK..." -ForegroundColor Cyan
        Write-Host "IMPORTANTE: Siga las instrucciones del instalador" -ForegroundColor Yellow
        
        try {
            Start-Process -FilePath $jdkInstaller -Wait
            Write-Host "Instalación de Java JDK completada" -ForegroundColor Green
        }
        catch {
            Write-Host "Error durante la instalación de Java JDK: $($_.Exception.Message)" -ForegroundColor Red
        }
    } else {
        Write-Host "No se pudo descargar Java JDK automáticamente." -ForegroundColor Red
        Write-Host "Por favor, descargue manualmente desde: https://www.oracle.com/java/technologies/downloads/" -ForegroundColor Yellow
    }
}

Write-Host ""
Write-Host "=== DESCARGANDO JAVAFX ===" -ForegroundColor Yellow

# Descargar JavaFX SDK
$javafxUrl = "https://download2.gluonhq.com/openjfx/21.0.2/openjfx-21.0.2_windows-x64_bin-sdk.zip"
$javafxZip = "$tempDir\javafx-sdk.zip"
$javafxDir = "C:\javafx-sdk"

Write-Host "Descargando JavaFX SDK..." -ForegroundColor Cyan

if (Download-File -Url $javafxUrl -OutputPath $javafxZip) {
    Write-Host "Extrayendo JavaFX SDK..." -ForegroundColor Cyan
    
    try {
        # Crear directorio de destino
        if (Test-Path $javafxDir) {
            Remove-Item $javafxDir -Recurse -Force
        }
        New-Item -ItemType Directory -Path $javafxDir -Force | Out-Null
        
        # Extraer archivo ZIP
        Expand-Archive -Path $javafxZip -DestinationPath $javafxDir -Force
        
        # Mover contenido del subdirectorio al directorio principal
        $extractedDir = Get-ChildItem $javafxDir -Directory | Select-Object -First 1
        if ($extractedDir) {
            $items = Get-ChildItem $extractedDir.FullName
            foreach ($item in $items) {
                Move-Item $item.FullName $javafxDir
            }
            Remove-Item $extractedDir.FullName -Force
        }
        
        Write-Host "JavaFX SDK extraído en: $javafxDir" -ForegroundColor Green
    }
    catch {
        Write-Host "Error al extraer JavaFX: $($_.Exception.Message)" -ForegroundColor Red
    }
} else {
    Write-Host "No se pudo descargar JavaFX automáticamente." -ForegroundColor Red
    Write-Host "Por favor, descargue manualmente desde: https://openjfx.io/" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "=== CONFIGURANDO VARIABLES DE ENTORNO ===" -ForegroundColor Yellow

# Actualizar PATH para incluir Java (si se instaló)
if ($installJava) {
    Write-Host "Actualizando variables de entorno..." -ForegroundColor Cyan
    
    # Buscar instalación de Java
    $javaPaths = @(
        "C:\Program Files\Java\jdk-21\bin",
        "C:\Program Files\Java\jdk*\bin",
        "C:\Program Files (x86)\Java\jdk*\bin"
    )
    
    $javaPath = $null
    foreach ($path in $javaPaths) {
        $resolved = Resolve-Path $path -ErrorAction SilentlyContinue
        if ($resolved) {
            $javaPath = $resolved.Path
            break
        }
    }
    
    if ($javaPath) {
        $currentPath = [Environment]::GetEnvironmentVariable("PATH", "Machine")
        if ($currentPath -notlike "*$javaPath*") {
            $newPath = "$currentPath;$javaPath"
            [Environment]::SetEnvironmentVariable("PATH", $newPath, "Machine")
            Write-Host "Java agregado al PATH: $javaPath" -ForegroundColor Green
        }
    }
}

# Crear script de ejecución mejorado
Write-Host ""
Write-Host "=== CREANDO SCRIPT DE EJECUCIÓN MEJORADO ===" -ForegroundColor Yellow

$ejecutarScript = @"
@echo off
echo ====================================
echo    Agenda de Contactos - JavaFX
echo ====================================
echo.

REM Verificar si Java está instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java no está instalado o no está en el PATH
    echo Ejecute instalar_dependencias.ps1 como administrador
    pause
    exit /b 1
)

echo Compilando la aplicación...
echo.

REM Compilar con JavaFX
if exist "C:\javafx-sdk\lib" (
    echo Usando JavaFX desde C:\javafx-sdk\lib
    javac --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml *.java
) else (
    echo Compilando sin JavaFX específico (usando JDK incluido)
    javac *.java
)

if %errorlevel% neq 0 (
    echo ERROR: Error en la compilación
    echo Verifique que JavaFX esté correctamente instalado
    pause
    exit /b 1
)

echo Compilación exitosa!
echo.
echo Ejecutando la aplicación...
echo.

REM Ejecutar la aplicación
if exist "C:\javafx-sdk\lib" (
    java --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml ContactosApp
) else (
    java ContactosApp
)

echo.
echo Aplicación finalizada.
pause
"@

$ejecutarPath = "$PWD\Ejercicio 18\ejecutar_mejorado.bat"
Set-Content -Path $ejecutarPath -Value $ejecutarScript -Encoding ASCII
Write-Host "Script de ejecución creado: ejecutar_mejorado.bat" -ForegroundColor Green

# Limpiar archivos temporales
Write-Host ""
Write-Host "=== LIMPIANDO ARCHIVOS TEMPORALES ===" -ForegroundColor Yellow
try {
    Remove-Item $tempDir -Recurse -Force -ErrorAction SilentlyContinue
    Write-Host "Archivos temporales eliminados" -ForegroundColor Green
}
catch {
    Write-Host "No se pudieron eliminar algunos archivos temporales" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "====================================================" -ForegroundColor Green
Write-Host "              INSTALACIÓN COMPLETADA               " -ForegroundColor Green
Write-Host "====================================================" -ForegroundColor Green
Write-Host ""
Write-Host "PRÓXIMOS PASOS:" -ForegroundColor Yellow
Write-Host "1. Reinicie PowerShell o abra una nueva ventana" -ForegroundColor White
Write-Host "2. Navegue a la carpeta Ejercicio 18" -ForegroundColor White
Write-Host "3. Ejecute: .\ejecutar_mejorado.bat" -ForegroundColor White
Write-Host ""
Write-Host "Si hay problemas, ejecute: java -version" -ForegroundColor White
Write-Host "Para verificar que Java esté correctamente instalado" -ForegroundColor White
Write-Host ""

Read-Host "Presione Enter para salir"