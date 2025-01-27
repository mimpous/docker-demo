# docker-demo
 

#Build image 
docker build -f Dockerfile -t mimpous/consid-demo:latest --push .

#Pull Image
docker pull mimpous/consid-demo

#Run Image
docker run 8080:8080 mimpous/consid-demo

If you run it local then open http://localhost:8080