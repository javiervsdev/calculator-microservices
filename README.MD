<h1 align="center">🧮 calculator-microservices</h1>

<h2 id="table-of-contents"> 📖 Índice</h2>

<ol>
    <li><a href="#introduccion"> ➤ Introducción</a></li>
    <li><a href="#requisitos-tecnicos"> ➤ Requisitos técnicos</a></li>
    <li><a href="#tecnologias"> ➤ Tecnologías</a></li>
    <li><a href="#estructura-proyecto"> ➤ Estructura del proyecto</a></li>
    <ol>
        <li><a href="#proyecto-padre"> ➤ Proyecto padre</a></li>
        <li><a href="#addition-subtraction"> ➤ addition y subtraction</a></li>
        <li><a href="#common"> ➤ common</a></li>
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
<li>
<h3 id="addition-subtraction">addition y subtraction</h3>

Son los módulos hijos que contienen las operaciones de suma y resta respectivamente. Son módulos independientes entre
sí, pero su estructura es la misma.

<h4>En estos módulos se organizan las clases java en los paquetes controller, service y dto:</h4>

<ul>
    <li>
        <p><strong>controller:</strong> contiene los componentes encargados de recibir las peticiones a la api.</p>
            <ul>
                <li>
                    <p><strong>AdditionController/SubtractionController:</strong> carecen de lógica de negocio y su 
                    función es enviar los datos recibidos a la capa de servicio para que los procese y devuelva el 
                    resultado.</p>
                </li>
            </ul>
    </li>
    <li>
        <p><strong>service:</strong> contiene los componentes encargados de realizar la lógica de negocio.</p>
            <ul>
                <li>
                    <p><strong>AdditionService/SubtractionService:</strong> interfaces de los servicios que se encargan 
                    de definir un contrato que las implementaciones deberán de cumplir.</p>
                    <p>Esta interfaz es la que se inyecta en el controlador correspondiente aplicando así el principio
                    de inversión de dependencias correspondiente a la D de SOLID.</p>
                </li>
                <li>
                    <p><strong>AdditionServiceImpl/SubtractionServiceImpl:</strong> implementaciones de las interfaces
                    anteriores que contiene la lógica de negocio. Genera la operación aritmética correspondiente, 
                    tracea el resultado y lo retorna.</p>
                </li>
            </ul>
    </li>
    <li>
        <p><strong>dto:</strong> contiene los objetos con los datos del proceso</p>
            <ul>
                <li>
                    <p><strong>AdditionRequest/SubtractionRequest:</strong> contienen los datos que se reciben de la
                    petición</p>
                </li>
                <li>
                    <p><strong>Addition/Subtraction:</strong> representan las operaciones de suma y resta.</p>
                    <p>El constructor de estas clases es privado para evitar la creación de objetos con un estado erróneo.
                    En su lugar se proporciona un método estático que valida que los datos sean correctos, y si es así,
                    construye el objeto el cual retornará. En caso contrario lanza una excepción personalizada. Con esto
                    se consigue crear un <strong>constructor semántico</strong> o <strong>named constructor</strong></p>
                    <p>Por otra parte, estas clases tienen la peculiaridad de no implementar getters ni setters. Esto
                    se realiza así para aplicar el principio 
                    <a href="https://martinfowler.com/bliki/TellDontAsk.html">Tell-Don't-Ask</a> pidiéndole así al 
                    objeto Addition/Subtraction que nos dé el resultado en lugar de pedir los operandos y realizar 
                    la operación. Con esto se consigue llevar la lógica hacia el punto más cohesionado favoreciendo
                    la S de SOLID</p>
                </li>
            </ul>
    </li>
</ul>

<h4>Los test de estos módulos se encuentran en las clases:</h4>

<ul>
    <li>
        <strong>AdditionControllerTest/SubtractionControllerTest:</strong> contiene las pruebas de los controladores 
        verificando que el tipo de resultado de la petición y el estado sea el correcto, tanto si la operación es 
        correcta como si se produce una excepción de validación de datos de entrada. Con estos test se comprueba el 
        correcto funcionamiento de los controladores y del handlerException.
    </li>
    <li>
        <strong>AdditionServiceTest/SubtractionServiceTest</strong> contiene los test de los servicios que prueban
        que la ejecución de las operaciones(suma/resta) es correcta o en caso de recibir parámetros de entrada 
        incorrectos lanzar una excepción. Con estos test se comprueba el correcto funcionamiento de los servicios y 
        lógica de las clases Addition/Subtraction.
    </li>
</ul>

<h4>Las dependencias especificadas en estos proyectos son: (no se mencionan las dependencias heredadas porque ya se
han explicado anteriormente)</h4>

<ul>
    <li>
        <strong>common:</strong> se añade como dependencia el módulo common para que puedan hacer uso de las clases comunes.
    </li>
    <li>
        <strong>springdoc-openapi-ui:</strong> permite documentar la API REST y proporciona una interfaz de usuario para 
        visualizar la documentación.
    </li>
</ul>

<h4>Además, ha sido necesario especificar los siguientes plugins en los poms:</h4>

<ul>
    <li><p><strong>maven-surefire-plugin</strong> y <strong>maven-failsafe-plugin:</strong> Se han añadido estos
    plugins debido a bug de maven que provocaba que al hacer uso de comandos como mvn test no ejecutase los tests.
    Al añadir estos plugins con la versión 2.2.0 ya se reconocen y ejecutan. Para información más detallada acceder
    <a href="https://dzone.com/articles/why-your-junit-5-tests-are-not-running-under-maven">aquí</a></p></li>
</ul>
</li>
<li>
<h3 id="common">common</h3>

Módulo que contiene las clases comunes que se utilizan en los módulos de Addition/Subtraction.

<h4>Las clases java comunes se organizan en los paquetes advice, configuration, dto y exception:</h4>

<ul>
    <li>
        <p><strong>advice:</strong> contiene la clase <strong>ExceptionAdvice</strong> donde se controla la excepción
        personalizada OperandException</p>
    </li>
    <li>
        <p><strong>configuration:</strong> contiene la clase <strong>TracerConfiguration</strong> en la cual se genera 
        un bean con el tracer importado del jar indicado en el enunciado de la prueba</p>
    </li>
    <li>
        <p><strong>dto:</strong></p>
        <ul>
            <li>
                <p><strong>ApiError:</strong> clase usada como respuesta al controlar la excepción OperandException.</p>
            </li>
            <li>
                <p><strong>ResultResponse:</strong> clase usada como respuesta correcta de las operaciones de suma 
                y resta. Contiene el resultado de la operación</p>
            </li>
            <li>
                <p><strong>ArithmeticOperation:</strong> interfaz que implementan las clases de Addition/Subtraction.
                Esta interfaz está enfocada en generar el comportamiento de una operación aritmética obligando a 
                implementar un método que devuelva el resultado de la operación correspondiente. Al utilizar una 
                interfaz para modelar el comportamiento se aplica el principio 
                <a href="https://en.wikipedia.org/wiki/Composition_over_inheritance">Composición sobre herencia</a></p>
            </li>
        </ul>
    </li>
    <li>
        <p><strong>exception:</strong> contiene la excepción personalizada OperandException que se utiliza para indicar 
        que alguno de los operandos recibidos es incorrecto</p>
    </li>
</ul>
<h4>Pom:</h4>

En este caso solo hay una única dependencia en el módulo, siendo esta la dependencia del jar tracer proporcionado.
Para que esta dependencia del jar se pueda utilizar en el proyecto, se configura en el pom el plugin
<strong>maven-install-plugin</strong> indicándole la ruta del jar dentro del proyecto. Esta ruta se encuentra en common
en "src/main/resources/dependencies/tracer-1.0.0.jar"
</li>
</ol>