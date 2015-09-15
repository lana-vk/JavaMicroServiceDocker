
## Create a WildFly-Swarm microservice running on Docker to monitor a Bitcoin NOde and display result in a ReactJS web page . This is based on a wildFly, ReactJS exSamples. 

## First install a Bitcoin node and configure it to accept JSON-RPC calls

https://bitcoin.org/en/full-node#what-is-a-full-node

## Second install Maven, NetBeans ( if you want to edit the project, makes it easier


https://maven.apache.org/download.cgi

## Install Docker (Docker Tool Box if not running linux) 

https://docs.docker.com/linux/started/

## Install Docker Compose (helps if you want to define multiple services to run together)

https://docs.docker.com/compose/install/

### Packaging your application
  
Run `mvn clean package`. A `JavaMSDocker-swarm.jar` file will be built in your target folder  
 
### Building the Docker image

You build the Docker image with the command: `docker-compose build`

This will add the `jar` file to the Docker image and build it.  

### Running Docker with a Wildfly-Swarm microservice inside

You run the Docker container and start the Wildfly-Swarm microservice (a simple JAX-RS application) with the following commands:

`docker-compose up` 



### Inspect your running Docker containers

From a terminal run `docker ps` and you should see something like: 

````
CONTAINER ID        IMAGE                                COMMAND                CREATED              STATUS              PORTS                    NAMES
c618ed118938        dockerjaxrsapp_wildflyswarm:latest   "java -jar /opt/Dock   About a minute ago   Up About a minute   0.0.0.0:8080->8080/tcp   dockerjaxrsapp_wildflyswarm_1
````


````
### Download and Install React 

http://facebook.github.io/react/

install npm and build your own copy of react ( follow instrauctions in README file)

### Display the bitcoin NOde status in a React WEb Page 

Configure the page to send requests to the IP address your service is running on.

View page in the browser to see a live ticker of the BitCoin node status










