#!/usr/bin/env groovy

def call(def userarg1)
{
    echo "user input message is ${userarg1}"
	input message: 'Please Confirm to Proceed deployment', ok: 'Confirm'
    def username = System.console().readLine 'What is your name?'
    println "Hello $username"
        // Variables for input
    // def inputConfig
    // def inputTest

    // // Get the input
    // def userInput = input(
    //         id: 'userInput', message: 'Enter path of test reports:?',
    //         parameters: [

    //                 string(defaultValue: 'None',
    //                         description: 'Path of config file',
    //                         name: 'Config'),
    //                 string(defaultValue: 'None',
    //                         description: 'Test Info file',
    //                         name: 'Test'),
    //         ])

    // // Save to variables. Default to empty string if not found.
    // inputConfig = userInput.Config?:''
    // inputTest = userInput.Test?:''
}