resource "aws_ecr_repository" "create-repository" {
    name                    = "user-api"
    image_tag_mutability    = "MUTABLE"
}
