#!/bin/bash

# Navigate to the target directory
cd ./src/main/resources/static/swagger-ui || {
  echo "Directory ./src/main/resources/static/swagger-ui not found. Exiting."
  exit 1
}

# Start the Python HTTP server
echo "Starting Python server at port 8081..."
python3 -m http.server 8081


