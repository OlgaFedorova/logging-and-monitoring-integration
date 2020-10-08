VERSION=0.0.1
NAMESPACE=dev-system

gradle clean build

docker build --tag integration-template:$VERSION --file deployments/Dockerfile .

oc login -u developer -p developer https://api.crc.testing:6443
docker login -u developer -p $(oc whoami -t) default-route-openshift-image-registry.apps-crc.testing
oc new-project $NAMESPACE

cd deployments
cd openshift

sh kafka-dev-install.sh

cd integration-template-service
sh integration-template-service-push-image.sh $VERSION $NAMESPACE
sh integration-template-service-deploy.sh  $VERSION
cd ..

cd ..
cd ..




