# Stubby code

Start IMQ

    docker run --rm --name activemq -p 8161:8161 -p 61616:61616 -p 61613:61613     -p 61617:61617 smaject/activemq

The models match up to the otares objects in the get customer end point.

## Run in a docker

    sudo chown -R 1001:$(id -g) standalone && sudo chmod -R ug+rw standalone
    docker-compose up

You may need to wait 2-3 minutes and then restart the docker.

    docker-compose restart

Create a user:

    ./curl-create-user | python -m json.tool

