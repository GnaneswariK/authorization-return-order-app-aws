FROM public.ecr.aws/docker/library/openjdk:11-oracle
EXPOSE 9001
ADD target/authorization.jar authorization.jar
ENTRYPOINT ["java","-jar","/authorization.jar"]