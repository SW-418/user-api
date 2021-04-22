resource "aws_ecr_repository" "create-repository" {
  name                 = "user-api"
  image_tag_mutability = "MUTABLE"
}

resource "aws_ecr_lifecycle_policy" "create-repository-policy" {
  repository = aws_ecr_repository.create-repository.name

  policy = <<EOF
{
    "rules": [
        {
            "rulePriority": 1,
            "description": "Expire images outside of image count",
            "selection": {
                "tagStatus": "any",
                "countType": "imageCountMoreThan",
                "countNumber": 3
            },
            "action": {
                "type": "expire"
            }
        }
    ]
}
EOF
}
