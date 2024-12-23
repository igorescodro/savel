# 🎧 Savel

Sävel (_music note_, _melody_ in Finnish) is a open-source application that connects different music services and
provides a unified experience to follow your favorite artists.

## How to build the Backend

### 1. Create a configuration file with the API keys

Each service requires a set of keys in order to send requests. The keys are stored in a configuration file that is not
tracked by the version control system. The file must be created in the following path:

```
../src/main/resources/application.conf
```

The file must have the following structure:

```hocon
api {
    spotify {
        clientId = "<my-client-id>"
        clientSecret = "<my-client-secret>"
    }
}
```

### 2. Generate a shadowJar

The project uses the Gradle build system and the shadowJar plugin to generate a fat jar with all dependencies. To
generate the jar, run the following command:

```shell
./gradlew shadowJar
```

### 3. Build the Docker image

The project provides a Dockerfile to build the image. To build the image, run the following command:

```shell
docker buildx build --platform linux/amd64 -t igorescodro/savel:latest --load .
```

## License

```
Copyright 2024 Igor Escodro

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
