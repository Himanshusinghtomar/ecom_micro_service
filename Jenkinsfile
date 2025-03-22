pipeline {
    agent {
        docker { image 'maven:3.8.6-eclipse-temurin-17' }
    }

    environment {
        MAVEN_CMD = 'mvn'
    }

    stages {
        stage('Build All Microservices') {
            steps {
                sh '''
                for pom in $(find . -name "pom.xml"); do
                    dir=$(dirname "$pom")
                    (cd "$dir" && mvn clean package -DskipTests)
                done
                '''
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
