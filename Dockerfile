FROM openjdk:8
EXPOSE 8089
ARG JAR_FILE=target/spring-boot-mysql.jar
COPY ${JAR_FILE} spring-boot-mysql.jar
ENTRYPOINT ["java","-jar","spring-boot-mysql.jar"]