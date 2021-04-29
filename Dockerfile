FROM hub.c.163.com/housan993/centos7_jdk8:latest

MAINTAINER binbinmax

# COPY mall-0.0.1-SNAPSHOT.jar /
# CMD java -jar mall-0.0.1-SNAPSHOT.jar
ADD mall-0.0.1-SNAPSHOT.jar app.jar
# 运行jar包
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]