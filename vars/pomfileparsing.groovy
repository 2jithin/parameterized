def call(def responsedata)
{   
    println " = = = = Parsing Initialized = = = = "
    def xml = responsedata
    def config = new XmlParser().parseText(xml)

    def parsed = config.version.text()
    println(parsed)
    // project.dependencyManagement.dependencies.dependency.each{
    //     println it.@groupId
    }
    // config.Config.Servers.Server.each{
        // println it.@Name
    //println "${env.WORKSPACE}/parameters.xml"
    //}
}