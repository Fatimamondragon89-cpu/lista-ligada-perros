# Lista simplemente ligada con objetos Perro

**Autora:** García Mondragón Fátima Celeste  
**Materia:** Estructura de Datos

## Objetivo
Completar el ADT de las diapositivas con nodos propios y probarlo con `ListaLigadaADT<Perro>`. No utiliza ArrayList ni arreglos para almacenar los elementos.

## Archivos
- `Nodo.java`: dato genérico y enlace siguiente (base del profesor).
- `ListaLigadaADT.java`: todos los métodos de la diapositiva 7.
- `Perro.java`: clase del repaso; se agregaron equals y hashCode para comparar raza, edad y vacunación.
- `DemoListaLigada.java`: main con demostración y 18 comprobaciones automáticas.
- `Documentacion_ListaLigada_Fatima.pdf`: explicación y evidencia de ejecución.
- `salida_pruebas.txt`: salida real del programa.
- `ejecutar.bat`: compilar y ejecutar en Windows con un JDK en PATH.

## Métodos
| Método | Función | Tiempo |
|---|---|---|
| ListaLigadaADT() | Inicializa head en null. | O(1) |
| estaVacia() | Indica si no hay nodos. | O(1) |
| getTamanio() | Recorre y cuenta los nodos. | O(n) |
| agregar(valor) | Delega la inserción a agregarAlFinal. | O(n) |
| agregarAlFinal(valor) | Enlaza un nuevo nodo al final. | O(n) |
| agregarAlInicio(valor) | Coloca un nodo antes de head. | O(1) |
| agregarDespuesDe(ref, valor) | Inserta después de la primera coincidencia. | O(n) |
| eliminarElPrimero() | Mueve head al siguiente nodo. | O(1) |
| eliminarElFinal() | Desconecta el último nodo. | O(n) |
| buscar(valor) | Devuelve la primera posición o -1. | O(n) |
| actualizar(buscar, valor) | Reemplaza la primera coincidencia. | O(n) |
| transversal() | Imprime todos los datos en orden. | O(n) |

## Convenciones
Las posiciones empiezan en 0; buscar devuelve -1 si no encuentra el valor. Actualizar e insertar después de una referencia inexistente dejan la lista igual. Eliminar de una lista vacía no hace cambios. Se trabaja con la primera coincidencia. Objects.equals permite manejar null. El recorrido vacío imprime Vacia. El espacio total es O(n); cada operación usa espacio auxiliar O(1).

## Abrir en IntelliJ
1. Descomprime el ZIP.
2. En IntelliJ selecciona Open y abre la carpeta ListaLigada_Fatima (la que contiene pom.xml).
3. Configura el Project SDK como JDK 17 o 21.
4. Abre src/main/java/mx/unam/aragon/ico/edd/listas/DemoListaLigada.java.
5. Pulsa el botón verde junto a main y selecciona Run.
6. El final debe indicar: RESULTADO: 18 comprobaciones correctas.

## Ejecutar desde terminal
Desde la carpeta del proyecto, con JDK 17 o superior:
```sh
javac -encoding UTF-8 -d out src/main/java/mx/unam/aragon/ico/edd/listas/*.java
java -cp out mx.unam.aragon.ico.edd.listas.DemoListaLigada
```
En Windows también se puede abrir ejecutar.bat. Si javac no se reconoce, configura el JDK o ejecuta desde IntelliJ.

## Entrega en GitHub
1. Abre tu repositorio y selecciona Add file > Upload files.
2. Sube la carpeta src y los archivos pom.xml, README.md, ejecutar.bat, salida_pruebas.txt y el PDF. No subas out ni target.
3. Si ya contiene otras tareas, coloca todo dentro de una carpeta ListaLigada_Fatima para conservarlas.
4. Pulsa Commit changes y comprueba que aparezcan los cuatro archivos Java y el PDF.
5. Entrega el enlace de la carpeta o del repositorio según indique el profesor. Subir únicamente el ZIP dificulta revisar el código; sube los archivos descomprimidos.

## Validación
Compilado y ejecutado con Java 17. Las 18 comprobaciones pasaron. Se prueban: lista vacía, búsqueda ausente, agregar y agregarAlFinal, inicio, inserción intermedia, igualdad por atributos, actualización, referencia ausente, eliminación de primero y final, eliminación del único nodo, primera coincidencia entre duplicados, inserción después del primero y último, búsqueda y actualización de null.

## Material de referencia
Diapositivas proporcionadas: 4_1_ADT_Lista_simplemente_ligada(1).pdf, diapositiva 7. Código base: listas(1).zip. Clase Perro: RepasoEDD2027(1).zip. Los métodos existentes conservan sus nombres y firmas públicas; los nombres nuevos usan la misma convención Java.
