VERSION=0.0.1

gradle clean build
docker build --tag integration-template:$VERSION --file deployments/Dockerfile .

cd deployments
docker-compose -f docker-compose.yaml up -d
cd ..




