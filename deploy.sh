# Enable buildx if not already enabled
docker buildx create --use

# Build the image for both amd64 and arm64
docker buildx build --platform linux/amd64,linux/arm64 -t mimpous/consid-demo:latest --push .
