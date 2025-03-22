pipeline {
    agent any

    environment {
        MAVEN_CMD = './mvnw'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Himanshusinghtomar/ecom_micro_service.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'find . -name "pom.xml" -execdir ${MAVEN_CMD} clean package'
            }
        }

        stage('Run Eureka Server') {
            steps {
                sh 'nohup java -jar eureka-server/target/*.jar > eureka.log 2>&1 &'
            }
        }

        stage('Run Order Service') {
            steps {
                sh 'nohup java -jar order-service/target/*.jar --server.port=8081 > order.log 2>&1 &'
            }
        }

        stage('Run Product Service') {
            steps {
                sh 'nohup java -jar product-service/target/*.jar --server.port=8082 > product.log 2>&1 &'
            }
        }

        stage('Run User Service') {
            steps {
                sh 'nohup java -jar user-service/target/*.jar --server.port=8083 > user.log 2>&1 &'
            }
        }
    }
}
