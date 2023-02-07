import groovy.xml.*
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
    def config = new XmlParser().parseText(xml)
    def dependencies = config.dependencies.dependency.collect { dep ->
      "${dep.groupId}"
  	}
  	println "Dependencies groupids:"
    dependencies.each { println "- $it" }
    
    //println "${config.dependencyManagement/dependencies/dependency[2]/groupId.toString()}"
  }
  call ("jithin")