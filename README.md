# user-api

Basic Java API backed by DynamoDB. Deployed via Terraform using ECS. 

### Running Locally

1. Ensure docker is installed
2. Navigate to the root directory of the repository and run `docker build . -t user-api`
3. Run `docker-compose up` - This will expose the API via port 8080 - This can be configured by modifying the ports in `docker-compose.yml`

