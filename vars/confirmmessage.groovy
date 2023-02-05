#!/usr/bin/env groovy

def call(def userarg1)
{
    echo "user input message is ${userarg1}"
    println "Hello $userarg1"

    def xml = '''\
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <AS Name="123">
        <Config Name="Configuration1">
            <Servers>
                <Server Name="server1"/>
                <Server Name="server2"/>
                <Server Name="server3"/>
                <Server Name="server4"/>
            </Servers>
        </Config>

    </AS>'''

    def config = new XmlParser().parseText(xml) // defining the the variable

    config.Config.Servers.Server.each {
        println it['Name']
    }
}