# drools-integration
Este es un proyecto Java desarrollado con MAVEN. Tiene tres clases principales que representan las opciones de integración de un proyecto Java con proyectos de reglas de negocio desarrollados en [KIE-DROOLS]. Para usar este proyecto se debe clonar este repositorio desde eclipse y seguir las instrucciones consignadas en la sección de configuración. 

* [KieBaseInclusionRuleLocalFile.java] [LOCAL]: es un ejemplo de ejecución de reglas de negocio que están contenidas en archivos .drl locales, es decir dentro del mismo proyecto.
* [KieContainerFromKIEServer.java] [REMOTEKIE]: es un ejemplo de integración con reglas desarrolladas en KIE-Drools, que es un servicio que se despliega en un contendor JAVA (JBOSS EAP, WILDFLY o TOMCAT). Este me permite gestionar, validar, compilar y desplegar como repositorio maven remoto, un proyecto de reglas de negocio. 
* [KieContainerFromRemoteMvnRepo.java] [REMOTEMAVEN]: es un ejemplo de integración con un repositorio maven remoto. Puede ser un caso de integración con un repositorio Nexus o cualquier otro que pueda configurar como espejo en mi repositorio local de maven.

## Configuración

Para que funciones tanto el uso del respositorio remoto de KIE-Drools, como de cualquier otro repositorio maven remoto, se debe configurar este en el archivo de configuración de maven (setting.xml). Cuando se usa desde eclipse, este archivo puede ser configurado desde el menú: window > preferences > Maven > User Settings. 

- Para el caso de KIE-DROOLS se debe agregar lo siguiente:

```xml
...<servers>
    <server>
			<id>guvnor</id>
			<username>[usuario]</username>
			<password>[contraseña]</password>
			<configuration>
				<wagonProvider>httpclient</wagonProvider>
				<httpConfiguration>
					<all>
						<usePreemptive>true</usePreemptive>
					</all>
				</httpConfiguration>
			</configuration>
		</server>
</servers>...
```
Y en la sección de repositorios agregar lo siguiente:

```xml  
</repositories>
    <repository>
		<id>guvnor</id>
		<name>JBoss BRMS 6.0.0 ER7 Guvnor M2 Repository</name>
		<url>http://[IP-KIE-DROOLS]:[PUERTO-KIE-DROOLS]/drools-wb/maven2/</url>
		<layout>default</layout>
		<releases>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		</releases>
		<snapshots>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		</snapshots>
	</repository>
</repositories>
```

y finalmente activar el perfil donde se encuentra el repositorio antes configurado.

   [KIE-DROOLS]: <http://www.drools.org/>
   [LOCAL]: <https://github.com/gaalvarez/drools-integration/blob/master/BRIntegration/src/main/java/org/cluster/drools/KieBaseInclusionRuleLocalFile.java>
   [REMOTEKIE]: <https://github.com/gaalvarez/drools-integration/blob/master/BRIntegration/src/main/java/org/cluster/drools/KieContainerFromKIEServer.java>
   [REMOTEMAVEN]: <https://github.com/gaalvarez/drools-integration/blob/master/BRIntegration/src/main/java/org/cluster/drools/KieContainerFromRemoteMvnRepo.java>
   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [@thomasfuchs]: <http://twitter.com/thomasfuchs>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [marked]: <https://github.com/chjj/marked>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [keymaster.js]: <https://github.com/madrobby/keymaster>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>
   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]:  <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>

