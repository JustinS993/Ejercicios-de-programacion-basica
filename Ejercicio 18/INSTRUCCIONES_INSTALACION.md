# 📋 Instrucciones de Instalación - Java JDK y JavaFX

## 🚀 Instalación Automática (Recomendada)

### Opción 1: Script PowerShell Automático

1. **Abrir PowerShell como Administrador**:
   - Presiona `Windows + X`
   - Selecciona "Windows PowerShell (Administrador)" o "Terminal (Administrador)"
   - Si aparece UAC, haz clic en "Sí"

2. **Navegar a la carpeta del proyecto**:
   ```powershell
   cd "C:\Users\user\OneDrive\Escritorio\Ejercicios de programacion Basica 1\Ejercicio 18"
   ```

3. **Ejecutar el script de instalación**:
   ```powershell
   Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
   .\instalar_dependencias.ps1
   ```

4. **Seguir las instrucciones en pantalla**

5. **Reiniciar PowerShell** y ejecutar:
   ```powershell
   .\ejecutar_mejorado.bat
   ```

---

## 🛠️ Instalación Manual

### Paso 1: Instalar Java JDK

#### Opción A: Oracle JDK (Recomendado)
1. **Ir a la página oficial de Oracle**: <mcreference link="https://www.oracle.com/java/technologies/downloads/" index="3">3</mcreference>
   - Visita: https://www.oracle.com/java/technologies/downloads/

2. **Descargar JDK 21 o superior**:
   - Selecciona "JDK 21" o la versión más reciente
   - Elige "Windows" → "x64 Installer"
   - Descarga el archivo `.exe`

3. **Instalar JDK**:
   - Ejecuta el archivo descargado como administrador
   - Sigue el asistente de instalación
   - Acepta la ubicación predeterminada: `C:\Program Files\Java\jdk-21`

#### Opción B: OpenJDK (Alternativa gratuita)
1. **Ir a Adoptium**: https://adoptium.net/
2. **Seleccionar**:
   - Version: 21 (LTS)
   - Operating System: Windows
   - Architecture: x64
3. **Descargar e instalar** el archivo `.msi`

### Paso 2: Configurar Variables de Entorno

1. **Abrir Configuración del Sistema**:
   - Presiona `Windows + R`
   - Escribe `sysdm.cpl` y presiona Enter
   - Ve a la pestaña "Opciones avanzadas"
   - Haz clic en "Variables de entorno"

2. **Configurar JAVA_HOME**:
   - En "Variables del sistema", haz clic en "Nueva"
   - Nombre: `JAVA_HOME`
   - Valor: `C:\Program Files\Java\jdk-21` (o la ruta donde se instaló)

3. **Actualizar PATH**:
   - Busca "Path" en "Variables del sistema"
   - Haz clic en "Editar"
   - Haz clic en "Nuevo"
   - Agrega: `%JAVA_HOME%\bin`

### Paso 3: Verificar Instalación de Java

1. **Abrir nueva ventana de PowerShell**
2. **Ejecutar**:
   ```powershell
   java -version
   javac -version
   ```
3. **Resultado esperado**:
   ```
   java version "21.0.x" 2024-xx-xx LTS
   Java(TM) SE Runtime Environment (build 21.0.x+xx-LTS-xxx)
   Java HotSpot(TM) 64-Bit Server VM (build 21.0.x+xx-LTS-xxx, mixed mode, sharing)
   ```

### Paso 4: Instalar JavaFX

1. **Descargar JavaFX SDK**: <mcreference link="https://openjfx.io/openjfx-docs/" index="2">2</mcreference>
   - Visita: https://openjfx.io/
   - Haz clic en "Download"
   - Selecciona la versión compatible con tu JDK (ej: JavaFX 21)
   - Descarga "SDK" para Windows (archivo .zip)

2. **Extraer JavaFX**:
   - Extrae el archivo ZIP en `C:\javafx-sdk`
   - La estructura debe ser:
     ```
     C:\javafx-sdk\
     ├── bin\
     ├── lib\
     └── legal\
     ```

### Paso 5: Configurar JavaFX

#### Opción A: Variables de Entorno
1. **Crear variable JAVAFX_HOME**:
   - Nombre: `JAVAFX_HOME`
   - Valor: `C:\javafx-sdk`

2. **Actualizar PATH**:
   - Agregar: `%JAVAFX_HOME%\bin`

#### Opción B: Usar argumentos en línea de comandos
No requiere configuración adicional, se especifica al ejecutar.

---

## 🧪 Probar la Instalación

### Método 1: Script Automático
```batch
.\ejecutar_mejorado.bat
```

### Método 2: Compilación Manual
```powershell
# Navegar a la carpeta del proyecto
cd "Ejercicio 18"

# Compilar con JavaFX
javac --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml *.java

# Ejecutar
java --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml ContactosApp
```

### Método 3: Sin JavaFX externo (si JDK incluye JavaFX)
```powershell
javac *.java
java ContactosApp
```

---

## 🔧 Solución de Problemas

### Error: "java no se reconoce como comando"
**Solución**:
1. Verificar que Java esté instalado
2. Revisar variables de entorno PATH
3. Reiniciar PowerShell
4. Reinstalar Java

### Error: "module javafx.controls not found"
**Solución**:
1. Verificar que JavaFX esté descargado en `C:\javafx-sdk`
2. Usar argumentos `--module-path` y `--add-modules`
3. Verificar compatibilidad de versiones JDK-JavaFX

### Error de compilación
**Solución**:
1. Verificar que todos los archivos .java estén en la misma carpeta
2. Verificar sintaxis del código
3. Usar JDK compatible (21 o superior)

### La aplicación no se ejecuta
**Solución**:
1. Verificar que la compilación fue exitosa
2. Verificar que no hay errores en el código
3. Ejecutar desde la carpeta correcta
4. Verificar permisos de archivos

---

## 📚 Recursos Adicionales

- **Documentación oficial de Java**: https://docs.oracle.com/en/java/
- **Documentación de JavaFX**: <mcreference link="https://openjfx.io/openjfx-docs/" index="2">2</mcreference>
- **Tutoriales de JavaFX**: <mcreference link="https://dev.java/learn/javafx/install/" index="3">3</mcreference>
- **Gluon JavaFX**: <mcreference link="https://gluonhq.com/products/javafx/" index="4">4</mcreference>

---

## 📞 Soporte

Si continúas teniendo problemas:

1. **Verificar versiones**:
   ```powershell
   java -version
   javac -version
   ```

2. **Verificar variables de entorno**:
   ```powershell
   echo $env:JAVA_HOME
   echo $env:PATH
   ```

3. **Ejecutar diagnóstico**:
   ```powershell
   where java
   where javac
   ```

4. **Revisar logs de error** en la consola para identificar el problema específico

---

*Última actualización: Diciembre 2024*