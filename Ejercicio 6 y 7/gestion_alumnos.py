class Alumno:
    """
    Clase que representa a un alumno con sus datos básicos
    """
    def __init__(self, nombre, apellidos, dni, nota):
        self.nombre = nombre
        self.apellidos = apellidos
        self.dni = dni
        self.nota = nota
    
    def __str__(self):
        return f"{self.nombre} {self.apellidos} (DNI: {self.dni}) - Nota: {self.nota}"
    
    def get_calificacion(self):
        """
        Retorna la calificación textual basada en la nota numérica
        """
        if self.nota >= 9.0:
            return "Sobresaliente"
        elif self.nota >= 7.0:
            return "Notable"
        elif self.nota >= 5.0:
            return "Aprobado"
        else:
            return "Suspenso"

class GestionAlumnos:
    """
    Clase para gestionar la lista de alumnos
    """
    def __init__(self):
        self.alumnos = []
    
    def agregar_alumno(self, alumno):
        """Agrega un alumno a la lista"""
        self.alumnos.append(alumno)
        print(f"Alumno {alumno.nombre} {alumno.apellidos} agregado correctamente.")
    
    def calcular_nota_media(self):
        """Calcula la nota media de todos los alumnos"""
        if not self.alumnos:
            return 0
        return sum(alumno.nota for alumno in self.alumnos) / len(self.alumnos)
    
    def listar_por_calificacion(self, calificacion):
        """Lista alumnos por calificación específica"""
        alumnos_filtrados = []
        for alumno in self.alumnos:
            if alumno.get_calificacion() == calificacion:
                alumnos_filtrados.append(alumno)
        return alumnos_filtrados
    
    def mostrar_todos_alumnos(self):
        """Muestra todos los alumnos"""
        if not self.alumnos:
            print("No hay alumnos registrados.")
            return
        
        print("\n=== LISTA COMPLETA DE ALUMNOS ===")
        for i, alumno in enumerate(self.alumnos, 1):
            print(f"{i}. {alumno} - {alumno.get_calificacion()}")
    
    def mostrar_estadisticas(self):
        """Muestra estadísticas de calificaciones"""
        if not self.alumnos:
            print("No hay alumnos para mostrar estadísticas.")
            return
        
        print("\n=== ESTADÍSTICAS ===")
        print(f"Nota media: {self.calcular_nota_media():.2f}")
        print(f"Total de alumnos: {len(self.alumnos)}")
        
        # Contar por calificación
        calificaciones = ["Sobresaliente", "Notable", "Aprobado", "Suspenso"]
        for cal in calificaciones:
            count = len(self.listar_por_calificacion(cal))
            print(f"Alumnos con {cal}: {count}")

def crear_alumno_interactivo():
    """Función para crear un alumno pidiendo datos al usuario"""
    print("\n--- Crear nuevo alumno ---")
    
    nombre = input("Nombre: ").strip()
    while not nombre:
        print("El nombre no puede estar vacío.")
        nombre = input("Nombre: ").strip()
    
    apellidos = input("Apellidos: ").strip()
    while not apellidos:
        print("Los apellidos no pueden estar vacíos.")
        apellidos = input("Apellidos: ").strip()
    
    dni = input("DNI: ").strip()
    while not dni:
        print("El DNI no puede estar vacío.")
        dni = input("DNI: ").strip()
    
    while True:
        try:
            nota = float(input("Nota (0-10): "))
            if 0 <= nota <= 10:
                break
            else:
                print("La nota debe estar entre 0 y 10.")
        except ValueError:
            print("Por favor introduce un número válido.")
    
    return Alumno(nombre, apellidos, dni, nota)

def main():
    print("=== GESTIÓN DE ALUMNOS ===")
    print("Sistema para gestionar alumnos y sus calificaciones")
    
    gestion = GestionAlumnos()
    
    while True:
        print("\n" + "="*50)
        print("MENÚ PRINCIPAL:")
        print("1. Agregar alumno")
        print("2. Ver todos los alumnos")
        print("3. Ver alumnos con Sobresaliente")
        print("4. Ver alumnos con Notable")
        print("5. Ver alumnos con Aprobado")
        print("6. Ver alumnos con Suspenso")
        print("7. Ver estadísticas")
        print("8. Salir")
        print("="*50)
        
        opcion = input("Selecciona una opción (1-8): ").strip()
        
        if opcion == "1":
            alumno = crear_alumno_interactivo()
            gestion.agregar_alumno(alumno)
            
        elif opcion == "2":
            gestion.mostrar_todos_alumnos()
            
        elif opcion == "3":
            sobresalientes = gestion.listar_por_calificacion("Sobresaliente")
            print("\n=== ALUMNOS CON SOBRESALIENTE ===")
            if sobresalientes:
                for i, alumno in enumerate(sobresalientes, 1):
                    print(f"{i}. {alumno}")
            else:
                print("No hay alumnos con sobresaliente.")
                
        elif opcion == "4":
            notables = gestion.listar_por_calificacion("Notable")
            print("\n=== ALUMNOS CON NOTABLE ===")
            if notables:
                for i, alumno in enumerate(notables, 1):
                    print(f"{i}. {alumno}")
            else:
                print("No hay alumnos con notable.")
                
        elif opcion == "5":
            aprobados = gestion.listar_por_calificacion("Aprobado")
            print("\n=== ALUMNOS CON APROBADO ===")
            if aprobados:
                for i, alumno in enumerate(aprobados, 1):
                    print(f"{i}. {alumno}")
            else:
                print("No hay alumnos con aprobado.")
                
        elif opcion == "6":
            suspensos = gestion.listar_por_calificacion("Suspenso")
            print("\n=== ALUMNOS CON SUSPENSO ===")
            if suspensos:
                for i, alumno in enumerate(suspensos, 1):
                    print(f"{i}. {alumno}")
            else:
                print("No hay alumnos con suspenso.")
                
        elif opcion == "7":
            gestion.mostrar_estadisticas()
            
        elif opcion == "8":
            print("¡Hasta luego!")
            break
            
        else:
            print("Opción no válida. Por favor selecciona una opción del 1 al 8.")

if __name__ == "__main__":
    main() 