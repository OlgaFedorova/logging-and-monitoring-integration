## Build and deploy
###### OpenShift
```
sh build-and-install-all-to-openshift.sh
```

###### Docker compose
```
sh build-and-install-all-to-docker-compose.sh
```

## Environment
###### OpenShift:
- http://integration-template-dev-system.apps-crc.testing/swagger-ui.html

## Дополнительная информация
#### OpenShift with Red Hat CodeReady Containers
- To  start  the  OpenShift  cluster:
```crc start -p OpenShiftSecret/pull-secret.txt```

OpenShift: https://oauth-openshift.apps-crc.testing/
User:     developer       
Password: developer 

- Set up your shell environment to find the oc program:
```eval $(crc oc-env)```

- To  shut  down  the  OpenShift  cluster:
```crc  stop```

#### Adding Self-signed Registry Certs to Docker & Docker for Mac
https://github.com/IBM/cloud-native-starter/blob/master/documentation/OS4Requirements.md#access-the-openshift-internal-image-registry
```
oc login -u kubeadmin -p ILWgF-VfgcQ-p6mJ4-Jztez https://api.crc.testing:6443  
oc extract secret/router-ca --keys=tls.crt -n openshift-ingress-operator
sudo security add-trusted-cert -d -r trustRoot -k /Library/Keychains/System.keychain tls.crt
oc login -u developer -p developer https://api.crc.testing:6443
docker login -u developer -p $(oc whoami -t) default-route-openshift-image-registry.apps-crc.testing
```

#### Install and use HELM
https://docs.openshift.com/container-platform/4.3/cli_reference/helm_cli/getting-started-with-helm-on-openshift-container-platform.html
```helm list```





