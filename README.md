# Formularioregistro 📋

## Descripción 📌

Este proyecto es una aplicación web construida con **Spring Boot** que permite a los usuarios registrar datos personales, profesionales y bancarios a través de una serie de formularios. Utiliza validaciones de datos y almacena la información en la sesión HTTP durante todo el proceso. Los usuarios pueden llenar los formularios en varias etapas y, al final, revisar la información que han ingresado.

## Funcionalidades 🚀

1. **Formulario Personal:**
   - Recopila datos personales como nombre, apellidos, fecha de nacimiento, género, estado civil, hijos, y nacionalidades.
   
2. **Formulario Profesional:**
   - Permite introducir el departamento de trabajo, salario y comentarios adicionales.
   
3. **Formulario Bancario:**
   - Recopila información bancaria, como el número de cuenta bancaria del usuario.

4. **Validaciones:**
   - Validación de campos obligatorios (por ejemplo, nombre, salario, número de cuenta).
   - Validaciones específicas de formato (por ejemplo, fecha de nacimiento en formato dd/MM/yyyy y número de cuenta de 20 dígitos).

5. **Persistencia en sesión:**
   - Los datos introducidos en cada formulario se guardan en la sesión HTTP, permitiendo la persistencia durante la navegación entre formularios.

6. **Reinicio:**
   - El sistema ofrece la opción de reiniciar el proceso de registro, borrando los datos almacenados en la sesión.

## Tecnologías 🛠️

- **Spring Boot:** Framework principal para el desarrollo de la aplicación web.
- **Java 17+**: Lenguaje de programación.
- **Thymeleaf:** Motor de plantillas para la interfaz de usuario.
- **Jakarta Validation:** Para realizar las validaciones de datos.
- **Session Management:** Gestión de sesiones para almacenar datos durante el proceso de registro.

## Endpoints 🧭

- **GET /reinicio:** Reinicia el proceso de registro y vuelve a mostrar el formulario personal.
- **GET /formularioPersonal:** Muestra el formulario para los datos personales.
- **POST /formularioPersonal:** Guarda los datos personales y redirige al formulario profesional.
- **GET /formularioProfesional:** Muestra el formulario para los datos profesionales.
- **POST /formularioProfesional:** Guarda los datos profesionales y redirige al formulario bancario.
- **GET /formularioBancario:** Muestra el formulario para los datos bancarios.
- **POST /formularioBancario:** Guarda los datos bancarios y redirige a la vista de resumen.
- **GET /total:** Muestra un resumen de toda la información registrada.
- **GET /volverInicio:** Vuelve al inicio y reinicia el proceso de registro.

## Uso 🏃‍♂️

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/usuario/formularioregistro.git
   cd formularioregistro
   ```

2. **Ejecutar la aplicación:**

   Puedes ejecutar la aplicación con Maven:

   ```bash
   mvn spring-boot:run
   ```

   O con tu IDE favorito como IntelliJ IDEA o Eclipse.

3. **Acceder a la aplicación:**
   
   Una vez que la aplicación esté en funcionamiento, abre tu navegador y visita:

   ```
   http://localhost:8080
   ```

4. **Llenar los formularios:**
   - Completa los formularios en las distintas secciones: Personal, Profesional y Bancario.
   - Al final, revisa la información que has ingresado y reinicia el proceso si es necesario.

## Validaciones de Datos 🛡️

- **Datos Personales:**
  - El campo "Nombre" no puede estar vacío.
  - La fecha de nacimiento debe estar en el formato `dd/MM/yyyy` y no puede ser una fecha futura.
  - Se debe seleccionar al menos dos nacionalidades.
  
- **Datos Profesionales:**
  - El salario debe ser un número válido con hasta dos decimales.
  
- **Datos Bancarios:**
  - El número de cuenta bancaria debe tener exactamente 20 dígitos.

## Licencia 📄

Este proyecto está bajo la Apache License 2.0 - ver el archivo [LICENSE](LICENSE) para más detalles.

