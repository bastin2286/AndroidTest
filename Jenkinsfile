pipeline 
{
    agent none
    stages 
    {
        stage('SCM Poll') 
        {
            agent any
            steps 
            {  	
				sh '''ls -la'''
				sh '''pwd'''
				sh '''ssh \'318356@10.10.196.130\' docker volume create volAndroidTest'''
				
               echo "********Waiting for SCM event - IN PROGRESS***********"
                /*
				script 
				{
				    properties([pipelineTriggers([pollSCM('* * * * *')])])
				}
				echo "Waiting for SCM event - Done"
				git branch: 'master', credentialsId: 'nandu', url: 'https://github.com/nandunarayanan/Android_Demo.git'
				*/
				
				/*
				
				checkout([$class: 'GitSCM', 
				branches: [[name: "origin/master"]], 
				userRemoteConfigs: [[
                url: 'https://github.com/nandunarayanan/Android_Demo.git']]
				])
				*/
				echo "Testing for SCM event - Done"
				echo "************copying the git update to the volume- IN PROGRESS***********"
				sh '''ssh \'318356@10.10.196.130\' /home/318356/copy.sh'''
				echo  "************copying the git update to the volume - DONE ****************"
				sh '''ls -la'''
				sh '''pwd'''
				
            }
        }
        
        stage('BuildManager')
        {   
            agent any
            steps
            {
                sh '''ssh \'318356@10.10.196.130\' docker pull localhost:5000/android_test_build:v5'''
                sh '''ssh \'318356@10.10.196.130\' docker run --name Build -v volAndroidTest:/src localhost:5000/android_test_build:v5'''
            }
        }
        
        
        
        stage('TestRunner')
        {   
            agent any
            steps
            {
                 echo "********Test Runner***********"
               sh '''ssh \'318356@10.10.196.130\' docker pull localhost:5000/android_test_run:v5'''
               sh '''ssh \'318356@10.10.196.130\' docker run --name Runner -p 27017 -v volAndroidTest:/src localhost:5000/android_test_run:v5'''
            }
        }
        
        stage('Publishing Result')
        {
            agent any
            steps
            {
                sh '''ssh \'318356@10.10.196.130\' /home/318356/copy_xml.sh'''
                step([$class: 'Publisher'])
            }
            
        }
        
        
        stage('Removal of build and volumes')
        {   
            agent any
            steps
            {
                sh '''ssh \'318356@10.10.196.130\' docker stop Build'''
                sh '''ssh \'318356@10.10.196.130\' docker rm Build'''
                sh '''ssh \'318356@10.10.196.130\' docker stop Runner'''
                sh '''ssh \'318356@10.10.196.130\' docker rm Runner'''
		sh '''ssh \'318356@10.10.196.130\' docker volume rm -f volAndroidTest'''
            }
        }
    }
}
