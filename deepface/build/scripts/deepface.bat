@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  deepface startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and DEEPFACE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\deepface-backend-0.1.0-plain.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-2.6.3.jar;%APP_HOME%\lib\spring-boot-starter-data-rest-2.6.3.jar;%APP_HOME%\lib\spring-boot-starter-thymeleaf-2.6.3.jar;%APP_HOME%\lib\lombok-1.18.22.jar;%APP_HOME%\lib\temporal-sdk-1.15.1.jar;%APP_HOME%\lib\slf4j-simple-2.0.0-beta1.jar;%APP_HOME%\lib\spring-boot-starter-data-mongodb-2.7.2.jar;%APP_HOME%\lib\spring-boot-starter-webflux-2.7.3.jar;%APP_HOME%\lib\spring-boot-starter-aop-2.6.3.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-2.6.3.jar;%APP_HOME%\lib\spring-boot-starter-web-2.6.3.jar;%APP_HOME%\lib\spring-boot-starter-json-2.6.3.jar;%APP_HOME%\lib\spring-boot-starter-2.6.3.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.6.3.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\httpclient5-5.1.3.jar;%APP_HOME%\lib\spring-data-jpa-2.6.1.jar;%APP_HOME%\lib\spring-data-rest-webmvc-3.6.1.jar;%APP_HOME%\lib\thymeleaf-spring5-3.0.14.RELEASE.jar;%APP_HOME%\lib\thymeleaf-extras-java8time-3.0.4.RELEASE.jar;%APP_HOME%\lib\spring-data-mongodb-3.3.1.jar;%APP_HOME%\lib\HikariCP-4.0.3.jar;%APP_HOME%\lib\spring-data-rest-core-3.6.1.jar;%APP_HOME%\lib\spring-data-commons-2.6.1.jar;%APP_HOME%\lib\thymeleaf-3.0.14.RELEASE.jar;%APP_HOME%\lib\temporal-serviceclient-1.15.1.jar;%APP_HOME%\lib\spring-hateoas-1.4.1.jar;%APP_HOME%\lib\spring-plugin-core-2.0.0.RELEASE.jar;%APP_HOME%\lib\log4j-to-slf4j-2.17.1.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.33.jar;%APP_HOME%\lib\json-path-2.6.0.jar;%APP_HOME%\lib\slf4j-api-2.0.0-beta1.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.1.jar;%APP_HOME%\lib\jackson-annotations-2.13.1.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.1.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.1.jar;%APP_HOME%\lib\jackson-core-2.13.1.jar;%APP_HOME%\lib\jackson-databind-2.13.3.jar;%APP_HOME%\lib\commons-configuration-1.10.jar;%APP_HOME%\lib\grpc-services-1.48.1.jar;%APP_HOME%\lib\protobuf-java-util-3.21.4.jar;%APP_HOME%\lib\grpc-netty-shaded-1.48.1.jar;%APP_HOME%\lib\grpc-core-1.48.1.jar;%APP_HOME%\lib\gson-2.9.1.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\hibernate-core-5.6.4.Final.jar;%APP_HOME%\lib\spring-aspects-5.3.15.jar;%APP_HOME%\lib\grpc-stub-1.48.1.jar;%APP_HOME%\lib\grpc-protobuf-1.48.1.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.48.1.jar;%APP_HOME%\lib\grpc-api-1.48.1.jar;%APP_HOME%\lib\guava-31.1-jre.jar;%APP_HOME%\lib\micrometer-core-1.8.2.jar;%APP_HOME%\lib\logback-core-1.2.10.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\commons-logging-1.1.1.jar;%APP_HOME%\lib\mongodb-driver-sync-4.4.1.jar;%APP_HOME%\lib\spring-boot-starter-reactor-netty-2.6.3.jar;%APP_HOME%\lib\spring-webflux-5.3.15.jar;%APP_HOME%\lib\spring-webmvc-5.3.15.jar;%APP_HOME%\lib\spring-web-5.3.15.jar;%APP_HOME%\lib\httpcore5-h2-5.1.3.jar;%APP_HOME%\lib\httpcore5-5.1.3.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.6.3.jar;%APP_HOME%\lib\spring-boot-2.6.3.jar;%APP_HOME%\lib\spring-context-5.3.15.jar;%APP_HOME%\lib\spring-aop-5.3.15.jar;%APP_HOME%\lib\aspectjweaver-1.9.7.jar;%APP_HOME%\lib\spring-orm-5.3.15.jar;%APP_HOME%\lib\spring-jdbc-5.3.15.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.2.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.3.Final.jar;%APP_HOME%\lib\byte-buddy-1.11.22.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.4.2.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\jaxb-runtime-2.3.5.jar;%APP_HOME%\lib\spring-tx-5.3.15.jar;%APP_HOME%\lib\spring-beans-5.3.15.jar;%APP_HOME%\lib\spring-expression-5.3.15.jar;%APP_HOME%\lib\spring-core-5.3.15.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.6.3.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\snakeyaml-1.29.jar;%APP_HOME%\lib\mongodb-driver-core-4.4.1.jar;%APP_HOME%\lib\bson-4.4.1.jar;%APP_HOME%\lib\reactor-netty-http-1.0.15.jar;%APP_HOME%\lib\reactor-netty-core-1.0.15.jar;%APP_HOME%\lib\reactor-core-3.4.14.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\txw2-2.3.5.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.12.jar;%APP_HOME%\lib\jakarta.activation-1.2.2.jar;%APP_HOME%\lib\spring-jcl-5.3.15.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.56.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.56.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.56.jar;%APP_HOME%\lib\evo-inflector-1.3.jar;%APP_HOME%\lib\attoparser-2.0.5.RELEASE.jar;%APP_HOME%\lib\unbescape-1.1.6.RELEASE.jar;%APP_HOME%\lib\grpc-context-1.48.1.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\tally-core-0.11.1.jar;%APP_HOME%\lib\HdrHistogram-2.1.12.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\netty-codec-http2-4.1.73.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.73.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.73.Final.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.73.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-classes-macos-4.1.73.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.73.Final-linux-x86_64.jar;%APP_HOME%\lib\reactive-streams-1.0.3.jar;%APP_HOME%\lib\log4j-api-2.17.1.jar;%APP_HOME%\lib\proto-google-common-protos-2.9.0.jar;%APP_HOME%\lib\protobuf-java-3.21.4.jar;%APP_HOME%\lib\error_prone_annotations-2.14.0.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.21.jar;%APP_HOME%\lib\perfmark-api-0.25.0.jar;%APP_HOME%\lib\netty-handler-4.1.73.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.73.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.73.Final.jar;%APP_HOME%\lib\netty-codec-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-4.1.73.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.73.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.73.Final.jar;%APP_HOME%\lib\netty-common-4.1.73.Final.jar;%APP_HOME%\lib\json-smart-2.4.7.jar;%APP_HOME%\lib\netty-tcnative-classes-2.0.46.Final.jar;%APP_HOME%\lib\accessors-smart-2.4.7.jar;%APP_HOME%\lib\asm-9.1.jar


@rem Execute deepface
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %DEEPFACE_OPTS%  -classpath "%CLASSPATH%" com.deepface.deepface.DeepfaceApplication %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable DEEPFACE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%DEEPFACE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
