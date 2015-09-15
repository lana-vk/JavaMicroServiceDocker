FROM java:openjdk-8-jdk

ADD target/JavaMSDocker-swarm.jar /opt/JavaMSDocker-swarm.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/JavaMSDocker-swarm.jar"]
