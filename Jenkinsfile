pipeline {
    agent {
        docker { image 'maven:3.8.6-openjdk-17' }
    }

    environment {
        MAVEN_CMD = 'mvn'
    }

    stages {
        stage('Build All Microservices') {
            steps {
                sh 'find . -name "pom.xml" -execdir ${MAVEN_CMD} clean package -DskipTests'
            }
        }

        stage('Run Eureka Server') {
            steps {
                sh 'nohup java -jar eureka-server/target/*.jar > eureka.log 2>&1 &'
            }
        }

        stage('Run Order Service') {
            steps {
                sh 'nohup java -jar order-service/target/*.jar > order.log 2>&1 &'
            }
        }

        stage('Run Product Service') {
            steps {
                sh 'nohup java -jar product-service/target/*.jar > product.log 2>&1 &'
            }
        }

        stage('Run User Service') {
            steps {
                sh 'nohup java -jar user-service/target/*.jar > user.log 2>&1 &'
            }
        }
    }
}
