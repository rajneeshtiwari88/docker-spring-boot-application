From tomcat:8-jre8

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]

COPY @project.build.finalName@.war /usr/local/tomcat/webapps/ROOT.war

COPY tomcat/logging.properties /usr/local/tomcat/conf/logging.properties

COPY tomcat/server.xml /usr/local/tomcat/conf/server.xml

EXPOSE 8080

CMD [ "catalina.sh", "run" ]

