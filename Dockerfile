# Tomcat을 실행할 기본 이미지
FROM alpine:latest

# Java 및 Tomcat 환경 변수 설정
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$JAVA_HOME/bin:$CATALINA_HOME/bin:$PATH

# 필요한 패키지 설치 및 Tomcat 다운로드
RUN apk add --no-cache openjdk17 bash curl && \
    mkdir -p $CATALINA_HOME && \
    curl -o /tmp/apache-tomcat.tar.gz https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.98/bin/apache-tomcat-9.0.98.tar.gz && \
    tar -xzf /tmp/apache-tomcat.tar.gz -C $CATALINA_HOME --strip-components=1 && \
    rm -rf /tmp/apache-tomcat.tar.gz $CATALINA_HOME/webapps/examples $CATALINA_HOME/webapps/docs

# 서버 설정 파일(server.xml) 복사
COPY server.xml ${CATALINA_HOME}/conf/server.xml

# 애플리케이션 파일(ROOT.war) 복사
RUN rm -rf ${CATALINA_HOME}/webapps/ROOT
COPY ROOT.war ${CATALINA_HOME}/webapps/ROOT.war

# Tomcat 사용자 생성 및 권한 설정
RUN adduser -D -h ${CATALINA_HOME} -s /bin/false tomcat && \
    chown -R tomcat:tomcat ${CATALINA_HOME} && \
    chmod -R 777 ${CATALINA_HOME}

# Tomcat 포트 노출
EXPOSE 8080 8009

# Tomcat 사용자로 실행
USER tomcat

# Tomcat 실행
CMD ["catalina.sh", "run"]
