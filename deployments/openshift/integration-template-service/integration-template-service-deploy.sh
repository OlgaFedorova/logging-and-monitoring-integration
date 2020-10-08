helm uninstall integration-template-service
helm install integration-template-service ./ --set service.version=$1