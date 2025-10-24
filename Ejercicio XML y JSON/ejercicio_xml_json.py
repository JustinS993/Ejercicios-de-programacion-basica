#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Ejercicio XML y JSON
Programa que crea, lee y elimina archivos XML y JSON con datos personales.
"""

import json
import xml.etree.ElementTree as ET
from datetime import datetime
import os


class PersonaData:
    """Clase personalizada para manejar datos de persona"""
    
    def __init__(self, nombre, edad, fecha_nacimiento, lenguajes):
        self.nombre = nombre
        self.edad = edad
        self.fecha_nacimiento = fecha_nacimiento
        self.lenguajes = lenguajes
    
    def __str__(self):
        return f"Persona: {self.nombre}, Edad: {self.edad}, Fecha: {self.fecha_nacimiento}, Lenguajes: {', '.join(self.lenguajes)}"
    
    def to_dict(self):
        """Convierte la instancia a diccionario para JSON"""
        return {
            "nombre": self.nombre,
            "edad": self.edad,
            "fecha_nacimiento": self.fecha_nacimiento,
            "lenguajes": self.lenguajes
        }
    
    @classmethod
    def from_dict(cls, data):
        """Crea instancia desde diccionario"""
        return cls(
            data["nombre"],
            data["edad"],
            data["fecha_nacimiento"],
            data["lenguajes"]
        )


def crear_archivo_xml(persona_data, archivo="datos_persona.xml"):
    """Crea un archivo XML con los datos de la persona"""
    root = ET.Element("persona")
    
    # Crear elementos
    nombre_elem = ET.SubElement(root, "nombre")
    nombre_elem.text = persona_data.nombre
    
    edad_elem = ET.SubElement(root, "edad")
    edad_elem.text = str(persona_data.edad)
    
    fecha_elem = ET.SubElement(root, "fecha_nacimiento")
    fecha_elem.text = persona_data.fecha_nacimiento
    
    lenguajes_elem = ET.SubElement(root, "lenguajes")
    for lenguaje in persona_data.lenguajes:
        lang_elem = ET.SubElement(lenguajes_elem, "lenguaje")
        lang_elem.text = lenguaje
    
    # Crear el árbol y escribir al archivo
    tree = ET.ElementTree(root)
    ET.indent(tree, space="  ", level=0)  # Formatear con indentación
    tree.write(archivo, encoding="utf-8", xml_declaration=True)
    
    print(f"[OK] Archivo XML creado: {archivo}")
    return archivo


def crear_archivo_json(persona_data, archivo="datos_persona.json"):
    """Crea un archivo JSON con los datos de la persona"""
    data = persona_data.to_dict()
    
    with open(archivo, 'w', encoding='utf-8') as f:
        json.dump(data, f, indent=2, ensure_ascii=False)
    
    print(f"[OK] Archivo JSON creado: {archivo}")
    return archivo


def mostrar_contenido_archivo(archivo):
    """Muestra el contenido de un archivo"""
    print(f"\n--- Contenido de {archivo} ---")
    try:
        with open(archivo, 'r', encoding='utf-8') as f:
            contenido = f.read()
            print(contenido)
    except FileNotFoundError:
        print(f"Error: No se encontró el archivo {archivo}")
    except Exception as e:
        print(f"Error al leer el archivo: {e}")


def leer_xml_y_transformar(archivo):
    """Lee un archivo XML y lo transforma en objeto PersonaData"""
    try:
        tree = ET.parse(archivo)
        root = tree.getroot()
        
        nombre = root.find("nombre").text
        edad = int(root.find("edad").text)
        fecha_nacimiento = root.find("fecha_nacimiento").text
        
        lenguajes = []
        for lang_elem in root.find("lenguajes"):
            lenguajes.append(lang_elem.text)
        
        return PersonaData(nombre, edad, fecha_nacimiento, lenguajes)
    except Exception as e:
        print(f"Error al leer XML: {e}")
        return None


def leer_json_y_transformar(archivo):
    """Lee un archivo JSON y lo transforma en objeto PersonaData"""
    try:
        with open(archivo, 'r', encoding='utf-8') as f:
            data = json.load(f)
            return PersonaData.from_dict(data)
    except Exception as e:
        print(f"Error al leer JSON: {e}")
        return None


def eliminar_archivo(archivo):
    """Elimina un archivo si existe"""
    try:
        if os.path.exists(archivo):
            os.remove(archivo)
            print(f"[OK] Archivo eliminado: {archivo}")
        else:
            print(f"El archivo {archivo} no existe")
    except Exception as e:
        print(f"Error al eliminar {archivo}: {e}")


def main():
    """Función principal del programa"""
    print("=== EJERCICIO XML Y JSON ===\n")
    
    # Datos de ejemplo
    datos_persona = PersonaData(
        nombre="Juan Pérez",
        edad=28,
        fecha_nacimiento="1995-03-15",
        lenguajes=["Python", "JavaScript", "Java", "C++"]
    )
    
    print("Datos a procesar:")
    print(datos_persona)
    print()
    
    # PARTE PRINCIPAL DEL EJERCICIO
    print("1. Creando archivos XML y JSON...")
    archivo_xml = crear_archivo_xml(datos_persona)
    archivo_json = crear_archivo_json(datos_persona)
    
    print("\n2. Mostrando contenido de los archivos...")
    mostrar_contenido_archivo(archivo_xml)
    mostrar_contenido_archivo(archivo_json)
    
    print("\n3. Eliminando archivos...")
    eliminar_archivo(archivo_xml)
    eliminar_archivo(archivo_json)
    
    # DIFICULTAD EXTRA
    print("\n" + "="*50)
    print("DIFICULTAD EXTRA: Lectura y transformación")
    print("="*50)
    
    # Recrear archivos para la parte extra
    print("\n1. Recreando archivos para la demostración...")
    archivo_xml = crear_archivo_xml(datos_persona)
    archivo_json = crear_archivo_json(datos_persona)
    
    print("\n2. Leyendo y transformando datos desde XML...")
    persona_desde_xml = leer_xml_y_transformar(archivo_xml)
    if persona_desde_xml:
        print(f"Objeto creado desde XML: {persona_desde_xml}")
    
    print("\n3. Leyendo y transformando datos desde JSON...")
    persona_desde_json = leer_json_y_transformar(archivo_json)
    if persona_desde_json:
        print(f"Objeto creado desde JSON: {persona_desde_json}")
    
    print("\n4. Comparando objetos...")
    if persona_desde_xml and persona_desde_json:
        print(f"¿Son iguales los objetos? {persona_desde_xml.nombre == persona_desde_json.nombre and persona_desde_xml.edad == persona_desde_json.edad}")
    
    print("\n5. Limpiando archivos finales...")
    eliminar_archivo(archivo_xml)
    eliminar_archivo(archivo_json)
    
    print("\n[OK] Ejercicio completado exitosamente!")


if __name__ == "__main__":
    main()
