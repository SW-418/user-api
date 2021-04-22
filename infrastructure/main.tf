terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "3.37.0"
    }
  }

  backend "remote" {
    organization = "sw-418"

    workspaces {
      name = "user-api-dev"
    }
  }
}

provider "aws" {
  region = "eu-west-1"
}
