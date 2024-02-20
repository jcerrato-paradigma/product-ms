FROM openjdk:17-jdk-alpine
ADD target/product-0.0.1-SNAPSHOT.jar /usr/share/product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["/opt/openjdk-17/bin/java", "-jar", "/usr/share/product-0.0.1-SNAPSHOT.jar"]