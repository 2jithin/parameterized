def call(def userarg1 , def responsedata)
{
    println "user input is  $userarg1"
    println responsedata
    
    // filevalue = readFile "$filepath/parameters.xml"
    
    def xml = userarg1
    xml = '''
    <AS Name="123">
        <Config Name="Configuration1">
            <Servers>
                <Server Name="server1"/>
                <Server Name="server2"/>
                <Server Name="server3"/>
                <Server Name="server4"/>
            </Servers>
        </Config>
    </AS>
    '''

def config = new XmlParser().parseText(xml)

config.Config.Servers.Server.each{
    println it.@Name
    //println "${env.WORKSPACE}/parameters.xml"
    }
}