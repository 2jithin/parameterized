import groovy.xml.*
def call(def responsedata)
{   
    println " = = = = Parsing Initialized = = = = "
    // assigning argument variable value to xml variable
    def xml = responsedata

    // replacing and removing the namespace things from xml
    xml = xml.replace("""xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd""","")
    xml = xml.replace(' "',"")
    // Using parser function parsing the xml
    def config = new XmlParser().parseText(xml)
    def dependencies = config.dependencies.dependency.collect { dep ->
        dep.groupId.text()
        //"${dep.groupId}"
  	}
    dependencies.each {
        println "- $it.value" 
    }
    def resultfile = new file("dependency_groupIds.txt")
    resultfile.withWriter { writer ->
        dependencies.each { writer.println " - $it" }
    }

    // ================================================================================

    // project.dependencyManagement.dependencies.dependency.each{
    //     println it.@groupId
    //}
    // config.Config.Servers.Server.each{
        // println it.@Name
    //println "${env.WORKSPACE}/parameters.xml"
    //}
}