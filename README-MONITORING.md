## Мониторинг

### Термины
- Ingress - an k8s API object that manages external access to the services in a cluster, typically HTTP. 

### Системные метрики
В инфраструктурном namespace Open Shift  подымается Prometheus и считывает системные метрики k8s. 
Доступ к этому Prometheus открывается через Ingress.

### Прикладные метрики
В namespace Open Shift нашего прикладного сервиса подымается Prometheus.
Prometheus считывает метрики прикладного сервиса через эндпойнт /actuator/prometheus. 
Доступ к этому Prometheus открывается через Ingress.

#### Типы метрик
https://micrometer.io/docs/concepts
- Счетчик (Counters)
Считает элементы за период времени.
С его помощью особенно удобно считать количество наступлений определенного события за период времени, т. е. показатель изменения метрики со временем.
- Измерители (Gauges)
Измерители идеально подходят для измерения текущего значения метрики, которое со временем может уменьшиться.
Измеритель не показывает развитие метрики за период времени. 

#### Spring Boot Default supported metrics
https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-metrics-meter
Spring Boot registers the following core metrics when applicable:
- JVM metrics, report utilization of:
    - Various memory and buffer pools
    - Statistics related to garbage collection
    - Threads utilization
    - Number of classes loaded/unloaded
- CPU metrics
- File descriptor metrics
- Kafka consumer and producer metrics
- Log4j2 metrics: record the number of events logged to Log4j2 at each level
- Logback metrics: record the number of events logged to Logback at each level
- Uptime metrics: report a gauge for uptime and a fixed gauge representing the application’s absolute start time
- Tomcat metrics
- Spring Integration metrics
- Spring MVC Metrics
- HTTP Client Metrics
- Cache Metrics
- DataSource Metrics
- Hibernate Metrics
- RabbitMQ Metrics
- Kafka Metrics



