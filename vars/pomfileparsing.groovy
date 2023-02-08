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

    // ======================= Mock Test ============

    xml = '''
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>javax.servlet
                </groupId>
                <artifactId>servlet-api
                </artifactId>
                <version>2.5
                </version>
            </dependency>
            <dependency>
                <groupId>javax.servlet.jsp
                </groupId>
                <artifactId>jsp-api
                </artifactId>
                <version>2.2
                </version>
            </dependency>
            <dependency>
                <groupId>junit
                </groupId>
                <artifactId>junit-dep
                </artifactId>
                <version>4.10
                </version>
                <scope>test
                </scope>
            </dependency>
            <dependency>
                <groupId>org.hamcrest
                </groupId>
                <artifactId>hamcrest-core
                </artifactId>
                <version>1.2.1
                </version>
                <scope>test
                </scope>
            </dependency>
            <dependency>
                <groupId>org.hamcrest
                </groupId>
                <artifactId>hamcrest-library
                </artifactId>
                <version>1.2.1
                </version>
                <scope>test
                </scope>
            </dependency>
            <dependency>
                <groupId>org.mockito
                </groupId>
                <artifactId>mockito-core
                </artifactId>
                <version>1.8.5
                </version>
                <scope>test
                </scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    '''

    // Using parser function parsing the xml
    def config = new XmlParser().parseText(xml)

    // dependency value get using as xpath
    def dependencies = config.'**'.findAll { node ->
      node.name() == 'groupId'
    }.collect { node ->
      node.text()
    }

    // def dependencies = config.dependency.collect { dep ->
    //     // dep.groupId.text()
    //     "${dep.groupId.text()}"
  	// }
    dependencies.each {
        println "- $it" 
    }
    // def resultfile = new file("dependency_groupIds.txt")
    // resultfile.withWriter { writer ->
    //     dependencies.each { writer.println " - $it" }
    // }

    // ================================================================================

    // project.dependencyManagement.dependencies.dependency.each{
    //     println it.@groupId
    //}
    // config.Config.Servers.Server.each{
        // println it.@Name
    //println "${env.WORKSPACE}/parameters.xml"
    //}
}