FROM java:8
VOLUME /tmp
ADD ./target/winter-server.tar.gz /app
# RUN bash -c 'tar -zxf winter-server.tar.gz'
#RUN bash -c 'cd /app/winter-server'
RUN bash -c 'touch /app/winter-server/winter-server.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/winter-server/winter-server.jar"]
#  todo 动态配置
EXPOSE 3300