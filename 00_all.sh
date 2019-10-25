git pull
./01_mvn_package.sh
docker rm -f simple-server
docker rmi simple-server
./02_build_image.sh
./03_start_container.sh
docker logs -f simple-server
