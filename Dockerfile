from java:8u111-jdk
ENV LANG C.UTF-8
ENV TZ Asia/Shanghai
RUN mkdir -p /file/excel
COPY target/cn-cjd-springboot-1.6-SNAPSHOT.jar /
ENTRYPOINT java -Xms128M -Xmx128M -Xss228k -Xmn256M -jar /cn-cjd-springboot-1.6-SNAPSHOT.jar
