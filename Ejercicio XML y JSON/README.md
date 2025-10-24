# Ejercicio XML y JSON

Este programa demuestra la creación, lectura y eliminación de archivos XML y JSON en Python.

## Características

### Ejercicio Principal
- ✅ Crea archivos XML y JSON con datos personales
- ✅ Muestra el contenido de los archivos generados
- ✅ Elimina los archivos después de mostrarlos

### Dificultad Extra
- ✅ Implementa una clase personalizada `PersonaData` para manejar los datos
- ✅ Lee y transforma datos desde archivos XML y JSON a objetos de la clase personalizada
- ✅ Compara los objetos creados desde ambos formatos
- ✅ Limpia todos los archivos al final

## Datos Procesados

El programa maneja los siguientes datos:
- **Nombre**: Juan Pérez
- **Edad**: 28 años
- **Fecha de nacimiento**: 1995-03-15
- **Lenguajes de programación**: Python, JavaScript, Java, C++

## Estructura de Archivos

### XML
```xml
<?xml version='1.0' encoding='utf-8'?>
<persona>
  <nombre>Juan Pérez</nombre>
  <edad>28</edad>
  <fecha_nacimiento>1995-03-15</fecha_nacimiento>
  <lenguajes>
    <lenguaje>Python</lenguaje>
    <lenguaje>JavaScript</lenguaje>
    <lenguaje>Java</lenguaje>
    <lenguaje>C++</lenguaje>
  </lenguajes>
</persona>
```

### JSON
```json
{
  "nombre": "Juan Pérez",
  "edad": 28,
  "fecha_nacimiento": "1995-03-15",
  "lenguajes": [
    "Python",
    "JavaScript",
    "Java",
    "C++"
  ]
}
```

## Uso

```bash
python ejercicio_xml_json.py
```

## Requisitos

- Python 3.6+
- Módulos estándar: `json`, `xml.etree.ElementTree`, `datetime`, `os`

## Funcionalidades de la Clase PersonaData

- `__init__()`: Constructor para inicializar los datos
- `__str__()`: Representación en string del objeto
- `to_dict()`: Convierte el objeto a diccionario para JSON
- `from_dict()`: Crea instancia desde diccionario (método de clase)
