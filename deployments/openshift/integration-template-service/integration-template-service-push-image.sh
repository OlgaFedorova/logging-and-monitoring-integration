VERSION=$1
NAMESPACE=$2

docker image tag integration-template:$VERSION default-route-openshift-image-registry.apps-crc.testing/$NAMESPACE/integration-template-service:$VERSION
docker push default-route-openshift-image-registry.apps-crc.testing/$NAMESPACE/integration-template-service:$VERSION
