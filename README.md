# 🎰 PROYECTO FINAL — THE LUCKY ARCADE

## 📌 Descripción del proyecto

The Lucky Arcade es un simulador de máquina tragamonedas desarrollado en Java como proyecto final del curso. El sistema permite administrar jugadores, guardar saldos utilizando archivos CSV y ejecutar una máquina tragamonedas basada en matrices 3x3 con premios, animaciones y eventos especiales.

El proyecto integra los temas vistos durante el curso:

- Variables y estructuras básicas
- Funciones y modularidad
- Arreglos y matrices
- Archivos CSV
- Lectura y escritura de archivos
- Programación orientada a objetos
- Menús en consola
- ASCII Art
- Generación aleatoria con `Math.random()`

Además incluye funcionalidades extra como ranking de jugadores y un Easter Egg especial.

---

# 👥 Integrantes del equipo

Jordan Restrepo Tobon

Felipe Londoño Ospina

Juan Andres Vallejo Orozco

---

# 🎯 Objetivo

Crear un casino en consola con persistencia de saldo para cada jugador, utilizando una máquina tragamonedas con premios y sistema de apuestas.

---

# ⚙ Funcionalidades implementadas

✅ Registro de jugadores

✅ Persistencia mediante archivo CSV

✅ Saldo automático para nuevos usuarios

✅ Máquina tragamonedas con matriz 3x3

✅ Símbolos aleatorios

✅ Detección de líneas ganadoras

✅ Premios horizontales

✅ Premios diagonales

✅ Multiplicadores

✅ Menú interactivo

✅ Ranking de jugadores

✅ ASCII Art

✅ Animación del giro

✅ Easter Egg especial

---

# 🗂 Estructura del proyecto

```txt
PROYECTO_FINAL_ARCADE
│
├── Main.java
├── Casino.java
├── Jugador.java
├── ArchivoCSV.java
├── ConsoleInput.java
├── jugadores.csv
├── README.md
└── .gitignore
```

---

# 📄 Descripción de archivos

### Main.java

Punto de entrada del programa.

Contiene:

- Menú principal
- Navegación
- Ejecución general

---

### Casino.java

Clase principal del juego.

Funciones:

- Generar matriz 3x3
- Animación
- Apuestas
- Premios
- Easter Egg
- Ranking

---

### Jugador.java

Clase que representa un jugador.

Atributos:

- nombre
- saldo

---

### ArchivoCSV.java

Permite:

- Leer jugadores
- Guardar jugadores
- Actualizar saldo

---

### ConsoleInput.java

Clase utilizada para estandarizar las lecturas de datos desde consola.

---

### jugadores.csv

Archivo encargado de almacenar:

```csv
nombre,saldo
Jordan,1000
Lucky,5000
```

---

# 🎰 Funcionamiento del tragamonedas

La pantalla utiliza una matriz:

```txt
[ X ][ $ ][ 7 ]
[ * ][ * ][ * ]
[ @ ][ X ][ # ]
```

Los símbolos disponibles son:

```java
"7"
"X"
"$"
"*"
"@"
"#"
```

Cada giro genera símbolos aleatorios.

---

# 🏆 Sistema de premios

El programa detecta:

### Líneas horizontales

Ejemplo:

```txt
[ X ][ X ][ X ]
```

---

### Diagonal principal

```txt
[ X ][ ? ][ ? ]
[ ? ][ X ][ ? ]
[ ? ][ ? ][ X ]
```

---

### Diagonal secundaria

```txt
[ ? ][ ? ][ X ]
[ ? ][ X ][ ? ]
[ X ][ ? ][ ? ]
```

---

### Multiplicadores

Si existen varias líneas ganadoras simultáneamente:

Premio × multiplicador

---

# 🥚 Easter Egg

El proyecto incluye un modo especial:

Se activa si:

- el jugador se llama:

```txt
LUCKY
```

o

- realiza una apuesta:

```txt
777
```

Efectos:

- Bonificaciones especiales
- Probabilidades aumentadas
- Eventos sorpresa

---

# ▶ Instrucciones para ejecutar el programa

## 1.

Abrir una terminal en la carpeta del proyecto.

---

## 2.

Compilar:

```bash
javac *.java
```

---

## 3.

Ejecutar:

```bash
java Main
```

---

# 📋 Menú principal

```txt
1. Apostar
2. Ver saldo
3. Ranking
4. Salir
```

---

# 💾 Persistencia de datos

El programa guarda automáticamente:

- nombre
- saldo

en:

```txt
jugadores.csv
```

Los datos permanecen guardados incluso después de cerrar el programa.

---

# 🧠 Temas aplicados

Durante este proyecto se utilizaron:

- Arreglos
- Matrices
- Strings
- Métodos
- Funciones
- Archivos CSV
- BufferedReader
- FileWriter
- Programación modular
- Programación orientada a objetos
- ASCII Art
- Manejo de excepciones

---

# Presentación del Proyecto

https://canva.link/bsh141xc5rud5fc

---

# 📚 Recursos utilizados

### Java CSV

https://www.baeldung.com/java-csv-file-array

### W3Schools Java Arrays

https://www.w3schools.com/java/java_arrays.asp

### W3Schools Java Methods

https://www.w3schools.com/java/java_methods.asp

### W3Schools Java Files

https://www.w3schools.com/java/java_files.asp

### ASCII Art Archive

https://www.asciiart.eu/

### Documentación Java

https://docs.oracle.com/javase/

### ConsoleInput.java del profesor

Material proporcionado en clase.

---
