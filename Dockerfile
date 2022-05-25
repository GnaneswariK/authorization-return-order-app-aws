FROM public.ecr.aws/docker/library/openjdk:11-oracle
EXPOSE 9001
ADD target/authorization-service.jar authorization-service.jar
ENTRYPOINT ["java","-jar","/authorization-service.jar"]
