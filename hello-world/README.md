## kotlinc && run

    cd src    
    kotlinc app.kt -include-runtime -d hello.jar
    java -jar hello.jar
    
    
    kotlinc-native app.kt -o hello