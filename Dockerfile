FROM adoptopenjdk/openjdk11

COPY . app/

WORKDIR app

RUN ./gradlew clean bootJar
ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "build/libs/foodorder.jar"]