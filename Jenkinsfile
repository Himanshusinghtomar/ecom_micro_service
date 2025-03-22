pipeline {
    agent any

    environment {
        MAVEN_CMD = './mvnw'
    }

    stages {
        stage('Build & Test') {
            steps {
                script {
                    sh '${MAVEN_CMD} -f eureka-server/pom.xml clean package'
                    sh '${MAVEN_CMD} -f order-service/pom.xml clean package'
                    sh '${MAVEN_CMD} -f product-service/pom.xml clean package'
                    sh '${MAVEN_CMD} -f user-service/pom.xml clean package'
                }
            }
        }

        stage('Run Eureka Server') {
            steps {
                script {
                    sh 'nohup java -jar eureka-server/target/*.jar > eureka.log 2>&1 &'
                }
            }
        }

        stage('Run Order Service') {
            steps {
                script {
                    sh 'nohup java -jar order-service/target/*.jar > order.log 2>&1 &'
                }
            }
        }

        stage('Run Product Service') {
            steps {
                script {
                    sh 'nohup java -jar product-service/target/*.jar > product.log 2>&1 &'
                }
            }
        }

        stage('Run User Service') {
            steps {
                script {
                    sh 'nohup java -jar user-service/target/*.jar > user.log 2>&1 &'
                }
            }
        }
    }
}
