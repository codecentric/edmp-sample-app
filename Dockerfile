FROM java:8

MAINTAINER Marcel Birkner <marcel.birkner@codecentric.de>

ADD target/edmp-sample-app*.jar app.jar

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
