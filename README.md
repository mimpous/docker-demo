# docker-demo
 

docker build -f Dockerfile -t mimpous/consid-demo:latest --push .

docker pull mimpous/consid-demo
docker run 8080:8080 mimpous/consid-demo
