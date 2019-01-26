# spring-cloud-contract-consumer

### Running stubs using docker
```$xslt
$ docker run --rm -e "STUBRUNNER_IDS=com.example.spring.cloud.contract:producer:0.0.1.RELEASE:stubs:9876" -e "STUBRUNNER_STUBS_MODE=remote" -e "STUBRUNNER_REPOSITORY_ROOT=http://192.168.0.2:8081/artifactory/libs-release-local" -p "8083:8083" -p "9876:9876" springcloud/spring-cloud-contract-stub-runner:2.1.0.RELEASE
```