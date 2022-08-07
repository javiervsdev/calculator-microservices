<h1 align="center">🧮 calculator-microservices</h1>

<h2 id="table-of-contents"> 📖 Índice</h2>

<ol>
    <li><a href="#introduccion"> ➤ Introducción</a></li>
    <li><a href="#requisitos-tecnicos"> ➤ Requisitos técnicos</a></li>
    <li><a href="#tecnologias"> ➤ Tecnologías</a></li>
    <li><a href="#estructura-proyecto"> ➤ Estructura del proyecto</a></li>
    <ol>
        <li><a href="#proyecto-padre"> ➤ Proyecto padre</a></li>
    </ol>
</ol>

<h2> 📝 Introducción</h2>

API REST para realizar operaciones aritméticas a partir de unos parámetros de entrada.

Esta versión solo es capaz de realizar operaciones de suma y resta ya que es una prueba de concepto.

<h2> 📏 Requisitos técnicos</h2>

<ul>
    <li>Hacer uso de control de versiones en Git.</li>
    <li>Uso de Maven como manejador de dependencias.</li>
    <li>Incluir la dependencia del jar mediante el plugin maven-install-plugin.</li>
    <li>Deberá ser una aplicación Spring Boot.</li>
    <li>Uso de JUnit5 para la realización de Pruebas Unitarias.</li>
    <li>Manejar una versión actual de JAVA para su desarrollo (mínimo JDK11).</li>
    <li>Construcción de la API RESTful con el estándar de OpenAPI.</li>
    <li>Aplicar los principios SOLID.</li>
    <li>Plantear un manejo de excepciones (operaciones invalidas).</li>
    <li>Deberá compilar sin errores en una instalación de Maven Limpia.</li>
    <li>Uso de operandos de tipo BigDecimal.</li>
</ul>

<h2 id="tecnologias"> 💻 Tecnologías</h2>

<ul>
    <li>Java 18</li>
    <li>Spring Boot 2.7.2</li>
    <li>Swagger</li>
    <li>JUnit 5</li>
    <li>Mockito 4.5.1</li>
    <li>Jackson 2.13.3</li>
</ul>

<h2 id="estructura-proyecto"> 📁 Estructura del proyecto</h2>

Consta de un proyecto padre y tres módulos hijos (addition, subtraction y common).
<ol>
<li>
<h3 id="proyecto-padre">Proyecto padre</h3>

Contiene a los módulos hijos así como el pom principal del que dependerán todos los módulos.

En él se definen las dependencias que usarán los módulos hijos según las necesidades de cada uno.

También contiene un <strong>fichero json para importar en postman</strong> y poder realizar las llamadas a la api.

<h4>Dependencias:</h4>
<ul>
    <li>
        <p><strong>spring-boot-dependencies:</strong> se añade como dependencyManagement para que, tanto el proyecto padre 
        como los módulos hijos puedan usar las dependencias que necesiten de Spring Boot 2.7.2</p>
    </li>
    <li>
        <p><strong>lombok:</strong> utilizada para generar código boilerplate en los módulos hijos y así generar un código 
        más limpio.</p>
    </li>
    <li>
        <p><strong>spring-boot-starter-web:</strong> proporciona todas las dependencias necesarias para ejecutar una 
        aplicación web.</p>
    </li>
    <li>
        <p><strong>spring-boot-starter-test:</strong> proporciona todas las dependencias necesarias para realizar las
        pruebas de la aplicación.</p>
    </li>
</ul>
</li>
</ol>