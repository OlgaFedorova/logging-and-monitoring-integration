# https://docs.confluent.io/4.1.2/quickstart/cp-helm-charts/docs/index.html
# https://github.com/confluentinc/cp-helm-charts
helm uninstall kafka-dev
helm repo add confluentinc https://confluentinc.github.io/cp-helm-charts/
helm install kafka-dev \
    --set cp-schema-registry.enabled=false \
    --set cp-kafka-rest.enabled=false \
    --set cp-kafka-connect.enabled=false \
    --set cp-control-center.enabled=false \
    --set cp-ksql-server.enabled=false \
    --set cp-kafka.brokers=1 \
    --set cp-zookeeper.servers=1 \
    --set cp-kafka.prometheus.jmx.enabled=false \
    --set cp-zookeeper.prometheus.jmx.enabled=false \
    confluentinc/cp-helm-charts