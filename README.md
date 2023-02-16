# TMS

## 실행
`java -jar ./target/tms-0.0.1-SNAPSHOT.jar --spring.profiles.active={dev, prod} --port={포트번호} --upload-dir={/절대경로/} --console-log-charset={UTF-8, MS949...}`
```
java -jar ./target/tms-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --port=8080 --upload-dir=/var/upload/ --console-log-charset=UTF-8
```