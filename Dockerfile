FROM bellsoft/liberica-openjdk-alpine:17

#Install currl jq
RUN apk add curl jq

# Workspace
WORKDIR /home/selenium-docker
# Add the required files
ADD target/docker-resources ./
ADD runner.sh runner.sh

# Start the runner.sh
ENTRYPOINT sh runner.sh