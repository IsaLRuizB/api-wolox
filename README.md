# api-wolox
Esta es una Api conformada por dos servicios. ApiController es la api en donde se exponen los servicios responsables de:
1.Registrar un álbum compartido con un usuario y sus permisos.
2. Cambiar los permisos de un usuario para un álbum determinado.
3. Traer todos los usuarios que tienen un permiso determinado respecto a un
álbum específico.

El segudno servicio es el ClientController y es el encargado de acceder a:
1.Los usuarios.
2. Las fotos.
3. Los álbumes del sistema y de cada usuario.
4. Las fotos de un usuario.

#Prerequisitos
1.Instalar Maven y crear la variable de entorno MAVEN_HOME apuntando al ubicación donde quedo la descarga del Maven realizada
2.Crear en el path una nueva entrada que haga referencia a la nuva variable de MAVEN. Ejemplo: %MAVEN_HOME%\bin
3. validar a traves de la consola que quedó instalado verficando la version con la siguiente instrucción mvn -v
4. Correr los scripts de la base de datos para generar la base de datos


#Para instalarlo se debe hacer lo siguiente:
1. Descargar o clonar el proyecto desde URL https://github.com/IsaLRuizB/api-wolox
2. hacer clic en el boton Clone
3. si se escoge la opción descargar, ubicar la descargar y extraer del .zip
4. Abrir el IDE utilizado, en mi caso, usé IntelliJ y se debe hacer clic en File->Open->Ubicar el proyecto->Seleccionarlo->clicar opcion Ok
5. en caso, de otro IDE, solo se debe importar al Workspace.

#Para correr las pruebas que se definieron con Junit
(Solo se hicieron pruebas para el ClientController)
1. se necesita indicar en el POM cuál es la ubicacion del JDK que este instalado enla máquina donde se despliegue y se hagan las pruebas.
Ejemplo: <executable>C:\Program Files\Java\jdk1.8.0_251\bin\javac</executable>
2. Abrir la consola y correr el siguiente comando mvn test ubicados desde la carpeta donde está el proyecto.

#Para el despliegue.
1 Ubicarse por consola en el directorio donde se encuentra el proyecto. Ejemplo C:\Users\Wolox\api-wolox
2. Unave ubicados dentro del proyecto correr el siguiente comando: mvn clean install
3. ubicarse dentro de la carpeta target.Correr la siguiente instrucción java -jar api-wolox-0.0.1-SNAPSHOT.jar
De este modo ya comienza a desplegarse el proyecto.

#Para probar el aplicativo
 Se tienen las siguientes urls
 Para obtener los datos desde el Servicio Externo se utilizan las siguientes URL's
 Para las fotos:localhost:8080/photos
 Para los usuarios: localhost:8080/users
 Para obtener los albumes: localhost:8080/albums
 Para el PLUS: localhost:8080/photos/{idUser}. Ejemplo:localhost:8080/photos/1
 
 Registrar un álbum compartido con un usuario y sus permisos. 
 Se utiliza la sieguinte URL localhost:8080/Api/compartir/album y se envía la siguiente estructura:
 {
	"idUser":2,
	"idUserComp":3,
	"idAlbum":1,
	"tipoPermiso":"2"	
}

Para cambiar los permisos de un usuario para un álbum determinado.
Se utiliza la sieguinte URL localhost:8080/Api/cambiar/album y se envía la siguiente estructura:
{
	"idUser":1,
	"idUserComp":4,
	"idAlbum":1,
	"tipoPermiso":"2"	
}

Traer todos los usuarios que tienen un permiso determinado respecto a un álbum específico.
Se utiliza la sieguinte URL localhost:8080/Api/consultar/1/1 y se obtiene lo siguiente:
[
    "Ervin Howell",
    "Clementine Bauch",
    "Patricia Lebsack"
]

En cuanto a los comentarios:

Se desarrolló 2 servicios. Uno que recibiera el nombre y otro el usuario que realizó dicho comentario.
Si sse filtra por nombre este es el url:localhost:8080/comments/{name}. Ejemplo:localhost:8080/comments/id labore ex et quam laborum
Si se filtra por el usuario esta es la url: localhost:8080/commentsByUser/{idUser} Ejemplo:localhost:8080/commentsByUser/1


#Construido con
1 Spring Boot
2 Java 1.8
3 MAVEN
4 y el IDE utilizado fue IntelliJ
5 la base de datos utilizada fue MariaDB







