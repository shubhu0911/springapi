pipeline {
    agent any
    tools{
        maven "mvn"
    }
    stages {
        stage('Clean') {
            steps {
                bat 'mvn -f restApi/pom.xml clean'
                echo 'Cleaning..'
            }
        }
        stage('Compile') {
            steps {
                bat 'mvn -f restApi/pom.xml compile'
                echo 'Compiling..'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn -f restApi/pom.xml test'
                echo 'Testing..'
            }
        }
        stage('Packaging') {
            steps {
                bat 'mvn -f restApi/pom.xml package'
                echo 'Packaging..'
            }
        }
        stage('Install') {
            steps {
                bat 'mvn -f restApi/pom.xml install'
                echo 'Installing..'
            }
        }
        stage('Docker Build'){
            steps{
                
                bat 'docker image rm -f restapiimg'
                echo 'previous docker image removed'
            }
        }

         
        
    }
}
