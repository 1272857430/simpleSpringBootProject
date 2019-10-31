docker run -d --log-opt max-size=1g --log-opt max-file=3 \
	--name simple-server \
	-p 81:81 \
	-v /data/logs/simple-server:/data/logs/simple-server \
	--restart=always \
	simple-server
