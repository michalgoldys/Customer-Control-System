FROM openjdk:8
ADD target/ZarzadzaniePracownikami-0.0.1-SNAPSHOT.war .
EXPOSE 20365
CMD java -jar ZarzadzaniePracownikami-0.0.1-SNAPSHOT.war