def call(def responsedata)
{   
    println " = = = = Parsing Initialized = = = = "
    def xml = responsedata
    xml = xml.replace("""<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">""","")
    xml = xml.replace("</project>","")
    string config = new XmlParser().parseText(xml)
    // def dependencies = config.dependencies.dependency.collect { dep ->
    //     dep.groupId.text()
  	// }
    // dependencies.each { println "- $it" }

    // ================================================================================

    // project.dependencyManagement.dependencies.dependency.each{
    //     println it.@groupId
    //}
    // config.Config.Servers.Server.each{
        // println it.@Name
    //println "${env.WORKSPACE}/parameters.xml"
    //}
}