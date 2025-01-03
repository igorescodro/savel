## 🎧 Sävel (server)

## How to build the server

### 1. Create a configuration file with the API keys

Each service requires a set of keys in order to send requests. The keys are stored in a configuration file that is not
tracked by the version control system. The file must be created in the following path:

```
../src/main/resources/secrets.conf
```

The file must have the following structure:

```hocon
service {
    google {
        projectId = "<my-google-cloud-project-id>"
    }
}

api {
    spotify {
        clientId = "<my-client-id>"
        clientSecret = "<my-client-secret>"
    }
}
```

### 2. Build the Docker image

The project provides a Dockerfile to build the image. To build the image, run the following command:

```shell
docker buildx build --platform linux/amd64 -t igorescodro/savel:<version> --load .
```

### 3. Run the Docker image locally

To run the image locally, a Google Cloud Default Credential is required. To generate this file locally, run the
following command:

```shell
gcloud auth application-default login
```

After the login, the file `~/.config/gcloud/application_default_credentials.json` will be created. To run the image, run
the following command:

```shell
docker run -e GOOGLE_APPLICATION_CREDENTIALS=/app/application_default_credentials.json \
    -v ~/.config/gcloud/application_default_credentials.json:/app/application_default_credentials.json \
    -p 8080:8080 --platform linux/amd64 igorescodro/savel:<version>
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
