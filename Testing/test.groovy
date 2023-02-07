def call(def userarg1)
{     
    println "Hello $userarg1"
    def xml = '''
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
    xml = xml.replace("""<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">""","")
    xml = xml.replace("</project>","")
    def config = new XmlParser().parseText(xml)
    def dependencies = config.dependencies.dependency.collect { dep ->
      dep.groupId.text()
      // dep.children().find { it.name() == 'groupId' }.text()
  	}
    dependencies.each { println "- $it" }
  }
  call ("jithin")