# helidon-knowyourcountry-app
<<<<<<< HEAD

Minimal Helidon MP project suitable to start from scratch.

## Build and run


With JDK17+
```bash
mvn package
java -jar target/helidon-knowyourcountry-app.jar
```

## Exercise the application
```
curl -X GET http://localhost:8080/simple-greet
{"message":"Hello World!"}
```

```
curl -X GET http://localhost:8080/greet
{"message":"Hello World!"}

curl -X GET http://localhost:8080/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting

curl -X GET http://localhost:8080/greet/Jose
{"message":"Hola Jose!"}
```



## Try health

```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...

```



## Building a Native Image

Make sure you have GraalVM locally installed:

```
$GRAALVM_HOME/bin/native-image --version
```

Build the native image using the native image profile:

```
mvn package -Pnative-image
```

This uses the helidon-maven-plugin to perform the native compilation using your installed copy of GraalVM. It might take a while to complete.
Once it completes start the application using the native executable (no JVM!):

```
./target/helidon-knowyourcountry-app
```

Yep, it starts fast. You can exercise the application’s endpoints as before.


## Try metrics

```
# Prometheus Format
curl -s -X GET http://localhost:8080/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
{"base":...
. . .
```



## Building the Docker Image

```
docker build -t helidon-knowyourcountry-app .
```

## Running the Docker Image

```
docker run --rm -p 8080:8080 helidon-knowyourcountry-app:latest
```

Exercise the application as described above.
                                

## Run the application in Kubernetes

If you don’t have access to a Kubernetes cluster, you can [install one](https://helidon.io/docs/latest/#/about/kubernetes) on your desktop.

### Verify connectivity to cluster

```
kubectl cluster-info                        # Verify which cluster
kubectl get pods                            # Verify connectivity to cluster
```

### Deploy the application to Kubernetes

```
kubectl create -f app.yaml                              # Deploy application
kubectl get pods                                        # Wait for quickstart pod to be RUNNING
kubectl get service  helidon-knowyourcountry-app                     # Get service info
kubectl port-forward service/helidon-knowyourcountry-app 8081:8080   # Forward service port to 8081
```

You can now exercise the application as you did before but use the port number 8081.

After you’re done, cleanup.

```
kubectl delete -f app.yaml
```


## Building a Custom Runtime Image

Build the custom runtime image using the jlink image profile:

```
mvn package -Pjlink-image
```

This uses the helidon-maven-plugin to perform the custom image generation.
After the build completes it will report some statistics about the build including the reduction in image size.

The target/helidon-knowyourcountry-app-jri directory is a self contained custom image of your application. It contains your application,
its runtime dependencies and the JDK modules it depends on. You can start your application using the provide start script:

```
./target/helidon-knowyourcountry-app-jri/bin/start
```

Class Data Sharing (CDS) Archive
Also included in the custom image is a Class Data Sharing (CDS) archive that improves your application’s startup
performance and in-memory footprint. You can learn more about Class Data Sharing in the JDK documentation.

The CDS archive increases your image size to get these performance optimizations. It can be of significant size (tens of MB).
The size of the CDS archive is reported at the end of the build output.

If you’d rather have a smaller image size (with a slightly increased startup time) you can skip the creation of the CDS
archive by executing your build like this:

```
mvn package -Pjlink-image -Djlink.image.addClassDataSharingArchive=false
```

For more information on available configuration options see the helidon-maven-plugin documentation.
                                
=======
Build a Microservice with Microprofile -Helidon

To create a Helidon MP (Micro Profile) project using the Helidon Start (Helidon https://helidon.io/starter/4.1.5?step=1)

The example application is based on the Helidon MP version 3.2.11

Prerequisite product versions for Helidon 3.2.11

Java SE 17 (Open JDK 17) 	 Helidon requires Java 17+.

Maven 3.6.1+ 	             Helidon requires Maven 3.6.1+.

Docker 18.09+ 	           You need Docker if you want to build and deploy Docker containers.

Kubectl 1.16.5+            If you want to deploy to Kubernetes, you need kubectl and a Kubernetes cluster.
>>>>>>> dceb9c38a4f85407821e6c9d304f01ca2cada2c2
