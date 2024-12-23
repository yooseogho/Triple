# 베이스 이미지 선택
FROM ubuntu:latest

# Tomcat 버전 및 경로 설정
ENV TOMCAT_VERSION=9.0.98
ENV CATALINA_HOME=/opt/tomcat
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$CATALINA_HOME/bin:$PATH

# JDK 설치 및 필요 패키지 설치
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk wget tar vim && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Tomcat 다운로드 및 설치
RUN wget https://dlcdn.apache.org/tomcat/tomcat-9/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
    tar -xf apache-tomcat-${TOMCAT_VERSION}.tar.gz -C /opt && \
    mv /opt/apache-tomcat-${TOMCAT_VERSION} ${CATALINA_HOME} && \
    rm apache-tomcat-${TOMCAT_VERSION}.tar.gz

# ROOT 애플리케이션 삭제 및 새 ROOT.war 배포
RUN rm -rf ${CATALINA_HOME}/webapps/ROOT
COPY server.xml ${CATALINA_HOME}/conf/server.xml
COPY ROOT.war ${CATALINA_HOME}/webapps/ROOT.war

# Tomcat 사용자 생성 및 권한 설정
RUN useradd -r -m -d ${CATALINA_HOME} -s /usr/sbin/nologin tomcat && \
    chown -R tomcat:tomcat ${CATALINA_HOME} && \
    chmod -R 777 ${CATALINA_HOME}


# Tomcat 포트 노출
EXPOSE 8888 8009

# Tomcat 실행
USER tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]

