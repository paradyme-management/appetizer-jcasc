# appetizer-jcasc

To build and deploy appetizer, github and artifactory credentials are required.
See the appetizer-deploy project where an appetizer-jenkins.yaml file can be edited with API tokens for Jenkins and Artifactory.
Then run the appetizer.sh shell script which will apply the credentials, then apply this code-as-configuration project and finally once the builds complete, will configure ArgoCD to deploy the application to the local cluster.

