from java:8u111-jdk
ENV LANG C.UTF-8
ENV TZ Asia/Shanghai
RUN mkdir -p /file/excel
COPY target/cn-cjd-springboot-1.6-SNAPSHOT.jar /
ENTRYPOINT java -Xms256M -Xmx256M -Xss228k -Xmn512M -jar /pay-server-1.0.0.102-SNAPSHOT.jar
