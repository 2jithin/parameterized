def call(string responsedata)
{   
    println responsedata
    def xml = responsedata
    def config = new XmlParser().parseText(xml)
    project.dependencyManagement.dependencies.dependency.each{
        println it.@groupId
    }
    // config.Config.Servers.Server.each{
        // println it.@Name
    //println "${env.WORKSPACE}/parameters.xml"
    }
}