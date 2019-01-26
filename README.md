# spring-cloud-contract-consumer

### Running stubs using docker
```$xslt
export STUB_PORT=9000
export STUBRUNNER_IDS=com.example.spring.cloud.contract:producer:0.0.1.RELEASE:stubs:$STUB_PORT
export STUBRUNNER_REPOSITORY_ROOT=http://192.168.0.2:8081/artifactory/libs-release-local
export STUBRUNNER_PORT=8083

$ docker run --rm -e "STUBRUNNER_IDS=$STUBRUNNER_IDS" -e "STUBRUNNER_STUBS_MODE=remote" -e "STUBRUNNER_REPOSITORY_ROOT=$STUBRUNNER_REPOSITORY_ROOT" -p "$STUBRUNNER_PORT:$STUBRUNNER_PORT" -p "$STUB_PORT:$STUB_PORT" springcloud/spring-cloud-contract-stub-runner:2.1.0.RELEASE
```