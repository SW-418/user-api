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
            "description": "Expire images older than 14 days",
            "selection": {
                "tagStatus": "any",
                "countType": "imageCountMoreThan",
                "countNumber": 14
            },
            "action": {
                "type": "expire"
            }
        }
    ]
}
EOF
}
