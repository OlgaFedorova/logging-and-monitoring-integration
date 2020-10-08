### Конфигурация
#### Общее описание
- Логи сервиса записываются в консоль в plain-text формате и в файл в формате JSON 
(ротация каждый день / при достижении определённого объёма)
- Fluent bit считывает логи из файлов и перенаправляет их в Kafka 

#### OpenShift check:
- Получим список всех под
```
kubectl get pods
```
- Проанализируем содержимое логов, сохраняемых на диск
```
kubectl exec -c integration-template-service -it integration-template-service-1-9vj2c  -- /bin/bash
cd /usr/app/logs
cat logs-2020-10-07-1.log
```
- Убедимся, что получаем сообщения вида
```
{
"appName":"integration-template-service",
"localTime":"2020-10-07T18:02:38.812Z",
"level":"INFO",
"text":"First-service: get hello",
"eventId":"f1151185-fdf2-4baa-ab5f-da65ad41a6b9",
"extEventId":"93a535df-9786-4ec6-9aa6-04a8212ba1ea",
"appType":"JAVA",
"levelInt":6,
"loggerName":"com.example.integrationtemplate.resources.GreetingController",
"threadName":"http-nio-8081-exec-6",
"callerClass":"com.example.integrationtemplate.resources.GreetingController",
"callerMethod":"getHello",
"callerLine":24
}
```

- Запустим и проанализируем consumer для топика tslg-app-logs
```
kubectl exec -c cp-kafka-broker -it kafka-dev-cp-kafka-0 -- /bin/bash  /usr/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic tslg-app-logs --from-beginning
```
- Убедимся, что получаем сообщения вида
```
{
"@timestamp":1602093758.814013,
"appName":"integration-template-service",
"localTime":"2020-10-07T18:02:38.812Z",
"level":"INFO",
"text":"First-service: get hello",
"eventId":"f1151185-fdf2-4baa-ab5f-da65ad41a6b9",
"extEventId":"93a535df-9786-4ec6-9aa6-04a8212ba1ea",
"appType":"JAVA",
"levelInt":6,
"loggerName":"com.example.integrationtemplate.resources.GreetingController",
"threadName":"http-nio-8081-exec-6",
"callerClass":"com.example.integrationtemplate.resources.GreetingController",
"callerMethod":"getHello",
"callerLine":24,
"envType":"K8S",
"namespace":"dev-system",
"podName":"integration-template-service-1-9vj2c",
"target_es_index":"distributed-systems.springboot-log4j2-file",
"tec":{"nodeName":"crc-mk4pg-master-0","podIp":"10.116.0.74"}
}
```
 

#### Docker compose check
- Проанализируем содержимое логов, сохраняемых на диск
```
docker exec -it integration-template /bin/bash
cd /usr/app/logs
cat logs-2020-10-07-1.log
```
- Убедимся, что получаем сообщения вида
```
{
"appName":"integration-template-service",
"localTime":"2020-10-07T18:02:38.812Z",
"level":"INFO",
"text":"First-service: get hello",
"eventId":"f1151185-fdf2-4baa-ab5f-da65ad41a6b9",
"extEventId":"93a535df-9786-4ec6-9aa6-04a8212ba1ea",
"appType":"JAVA",
"levelInt":6,
"loggerName":"com.example.integrationtemplate.resources.GreetingController",
"threadName":"http-nio-8081-exec-6",
"callerClass":"com.example.integrationtemplate.resources.GreetingController",
"callerMethod":"getHello",
"callerLine":24
}
```

- Запустим и проанализируем consumer для топика tslg-app-logs
```
docker exec -it kafka /bin/bash
/usr/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic tslg-app-logs --from-beginning
```
- Убедимся, что получаем сообщения вида
```
{
"@timestamp":1602093758.814013,
"appName":"integration-template-service",
"localTime":"2020-10-07T18:02:38.812Z",
"level":"INFO",
"text":"First-service: get hello",
"eventId":"f1151185-fdf2-4baa-ab5f-da65ad41a6b9",
"extEventId":"93a535df-9786-4ec6-9aa6-04a8212ba1ea",
"appType":"JAVA",
"levelInt":6,
"loggerName":"com.example.integrationtemplate.resources.GreetingController",
"threadName":"http-nio-8081-exec-6",
"callerClass":"com.example.integrationtemplate.resources.GreetingController",
"callerMethod":"getHello",
"callerLine":24,
"envType":"K8S",
"namespace":"dev-system",
"podName":"integration-template-service-1-9vj2c",
"target_es_index":"distributed-systems.springboot-log4j2-file",
"tec":{"nodeName":"crc-mk4pg-master-0","podIp":"10.116.0.74"}
}
```





