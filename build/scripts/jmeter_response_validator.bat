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
@rem  jmeter_response_validator startup script for Windows
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

@rem Add default JVM options here. You can also use JAVA_OPTS and JMETER_RESPONSE_VALIDATOR_OPTS to pass JVM options to this script.
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

set CLASSPATH=%APP_HOME%\lib\mdqa.jmeter.response.validator-0.1.jar;%APP_HOME%\lib\ApacheJMeter_java-5.4.1.jar;%APP_HOME%\lib\ApacheJMeter_components-5.4.1.jar;%APP_HOME%\lib\ApacheJMeter_core-5.4.1.jar;%APP_HOME%\lib\groovy-ant-3.0.7.jar;%APP_HOME%\lib\groovy-astbuilder-3.0.7.jar;%APP_HOME%\lib\groovy-cli-picocli-3.0.7.jar;%APP_HOME%\lib\groovy-groovysh-3.0.7.jar;%APP_HOME%\lib\groovy-console-3.0.7.jar;%APP_HOME%\lib\groovy-datetime-3.0.7.jar;%APP_HOME%\lib\groovy-groovydoc-3.0.7.jar;%APP_HOME%\lib\groovy-docgenerator-3.0.7.jar;%APP_HOME%\lib\groovy-jmx-3.0.7.jar;%APP_HOME%\lib\groovy-json-3.0.7.jar;%APP_HOME%\lib\groovy-jsr223-3.0.7.jar;%APP_HOME%\lib\groovy-macro-3.0.7.jar;%APP_HOME%\lib\groovy-nio-3.0.7.jar;%APP_HOME%\lib\groovy-servlet-3.0.7.jar;%APP_HOME%\lib\groovy-sql-3.0.7.jar;%APP_HOME%\lib\groovy-swing-3.0.7.jar;%APP_HOME%\lib\groovy-templates-3.0.7.jar;%APP_HOME%\lib\groovy-test-3.0.7.jar;%APP_HOME%\lib\groovy-test-junit5-3.0.7.jar;%APP_HOME%\lib\groovy-testng-3.0.7.jar;%APP_HOME%\lib\groovy-xml-3.0.7.jar;%APP_HOME%\lib\groovy-dateutil-3.0.7.jar;%APP_HOME%\lib\groovy-3.0.7.jar;%APP_HOME%\lib\jmespath-jackson-0.5.0.jar;%APP_HOME%\lib\jackson-databind-2.10.5.jar;%APP_HOME%\lib\jackson-annotations-2.10.5.jar;%APP_HOME%\lib\jackson-core-2.10.5.jar;%APP_HOME%\lib\darklaf-core-2.5.4.jar;%APP_HOME%\lib\darklaf-windows-2.5.4.jar;%APP_HOME%\lib\darklaf-macos-2.5.4.jar;%APP_HOME%\lib\darklaf-theme-2.5.4.jar;%APP_HOME%\lib\darklaf-property-loader-2.5.4.jar;%APP_HOME%\lib\svgSalamander-1.1.2.3.jar;%APP_HOME%\lib\caffeine-2.8.8.jar;%APP_HOME%\lib\darklaf-extensions-rsyntaxarea-0.3.4.jar;%APP_HOME%\lib\miglayout-swing-5.2.jar;%APP_HOME%\lib\httpasyncclient-4.1.4.jar;%APP_HOME%\lib\httpclient-4.5.6.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\jorphan-5.4.1.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\commons-math3-3.6.1.jar;%APP_HOME%\lib\commons-text-1.9.jar;%APP_HOME%\lib\tika-core-1.24.1.jar;%APP_HOME%\lib\xmlgraphics-commons-2.3.jar;%APP_HOME%\lib\freemarker-2.3.30.jar;%APP_HOME%\lib\jodd-props-5.0.13.jar;%APP_HOME%\lib\jodd-lagarto-5.0.13.jar;%APP_HOME%\lib\jodd-core-5.0.13.jar;%APP_HOME%\lib\rhino-1.7.13.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.30.jar;%APP_HOME%\lib\ApacheJMeter-5.4.1.jar;%APP_HOME%\lib\bsf-2.4.0.jar;%APP_HOME%\lib\rsyntaxtextarea-3.1.1.jar;%APP_HOME%\lib\jtidy-r938.jar;%APP_HOME%\lib\xstream-1.4.15.jar;%APP_HOME%\lib\log4j-1.2-api-2.13.3.jar;%APP_HOME%\lib\log4j-slf4j-impl-2.13.3.jar;%APP_HOME%\lib\log4j-core-2.13.3.jar;%APP_HOME%\lib\log4j-api-2.13.3.jar;%APP_HOME%\lib\apiguardian-api-1.1.0.jar;%APP_HOME%\lib\oro-2.0.8.jar;%APP_HOME%\lib\xalan-2.7.2.jar;%APP_HOME%\lib\Saxon-HE-9.9.1-8.jar;%APP_HOME%\lib\tika-parsers-1.24.1.jar;%APP_HOME%\lib\xercesImpl-2.12.0.jar;%APP_HOME%\lib\serializer-2.7.2.jar;%APP_HOME%\lib\xml-apis-1.4.01.jar;%APP_HOME%\lib\commons-lang3-3.11.jar;%APP_HOME%\lib\commons-io-2.8.0.jar;%APP_HOME%\lib\jmespath-core-0.5.0.jar;%APP_HOME%\lib\jcharts-0.7.5.jar;%APP_HOME%\lib\json-path-2.4.0.jar;%APP_HOME%\lib\json-smart-2.3.jar;%APP_HOME%\lib\accessors-smart-1.2.jar;%APP_HOME%\lib\commons-pool2-2.9.0.jar;%APP_HOME%\lib\asm-9.0.jar;%APP_HOME%\lib\jodd-log-5.0.13.jar;%APP_HOME%\lib\httpcore-nio-4.4.13.jar;%APP_HOME%\lib\jsoup-1.13.1.jar;%APP_HOME%\lib\bsh-2.0b6.jar;%APP_HOME%\lib\mail-1.5.0-b01.jar;%APP_HOME%\lib\javax.activation-1.2.0.jar;%APP_HOME%\lib\ant-junit-1.10.9.jar;%APP_HOME%\lib\ant-1.10.9.jar;%APP_HOME%\lib\ant-launcher-1.10.9.jar;%APP_HOME%\lib\ant-antlr-1.10.9.jar;%APP_HOME%\lib\picocli-4.5.2.jar;%APP_HOME%\lib\qdox-1.12.1.jar;%APP_HOME%\lib\javaparser-core-3.17.0.jar;%APP_HOME%\lib\jline-2.14.6.jar;%APP_HOME%\lib\junit-4.13.1.jar;%APP_HOME%\lib\junit-platform-launcher-1.7.0.jar;%APP_HOME%\lib\junit-platform-engine-1.7.0.jar;%APP_HOME%\lib\junit-platform-commons-1.7.0.jar;%APP_HOME%\lib\junit-jupiter-engine-5.7.0.jar;%APP_HOME%\lib\junit-jupiter-api-5.7.0.jar;%APP_HOME%\lib\testng-7.3.0.jar;%APP_HOME%\lib\checker-qual-3.8.0.jar;%APP_HOME%\lib\error_prone_annotations-2.4.0.jar;%APP_HOME%\lib\darklaf-utils-2.5.4.jar;%APP_HOME%\lib\darklaf-native-utils-2.5.4.jar;%APP_HOME%\lib\darklaf-platform-base-2.5.4.jar;%APP_HOME%\lib\jxlayer-3.0.4.jar;%APP_HOME%\lib\miglayout-core-5.2.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\slf4j-api-1.7.30.jar;%APP_HOME%\lib\xmlpull-1.1.3.1.jar;%APP_HOME%\lib\xpp3_min-1.1.4c.jar;%APP_HOME%\lib\httpcore-4.4.13.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\opentest4j-1.2.0.jar;%APP_HOME%\lib\jcommander-1.78.jar;%APP_HOME%\lib\jna-5.5.0.jar


@rem Execute jmeter_response_validator
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %JMETER_RESPONSE_VALIDATOR_OPTS%  -classpath "%CLASSPATH%"  %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable JMETER_RESPONSE_VALIDATOR_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%JMETER_RESPONSE_VALIDATOR_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
