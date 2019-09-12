## Project Setup

### Java

Forge and Pixelmon will be running on Java 8 so you will need the Java JDK 8. It is important to get the version that works with your system's
architecture so if you are running 32-bit make sure to get 32-bit and if you're running 64-bit then get 64-bit. Where you choose to get this is up to you
but an easy way to get it is through AdoptOpenJDK as shown in [this video](https://www.youtube.com/watch?v=aY1ynlrrrTU).

Check if you downloaded this correctly by typing `java --version` in your terminal/command prompt.

### IntelliJ

The second step will be downloading and installing IntelliJ Community version. This will be out IDE to create our project. <br>

1.) Head over to [Jetbrains' IntelliJ download page](https://www.jetbrains.com/idea/download/#section=windows) <br>
2.) Select the OS you are using (Windows, MacOS, Linux) <br>
3.) Choose the community version (you can use ultimate for free with a valid college email) <br>
4.) Install IntelliJ <br>
    - Windows: Double click the executable and follow the instructions <br>
    - MacOS: Drag the application from the DMG and place it into Applications <br>
    - Linux: Decompress the tar file and run the idea.sh script <br>
    
### Forge MDK

Now that we have Java and IntelliJ setup, we will need our forge workspace setup.

1.) Download one of the many versions of the Forge MDK from [Forge](https://files.minecraftforge.net/) <br>
    - Depending on what version pixelmon is on, the recommended forge version will change. <br>
    - To find the recommended version, check out [Reforged's website](https://reforged.gg/) <br>
2.) Find a spot for this to stay and extract the files into that folder <br>
    - I often keep a libraries folder in a Code folder where I put various libraries I need access to <br>
3.) Open a command prompt/terminal up to this folder <br>
4.) Run the setupDecompWorkspace command <br>
    - Windows: `gradlew setupDecompWorkspace` <br>
    - MacOS/Linux: `./gradlew setupDecompWorkspace` <br>
    - Note: This will take a few minutes and this is normal <br>
5. Open IntelliJ and click `Import Project` <br>
6. Select `build.gradle` inside of the folder you chose to extract your forge mdk to <br>
7. Once it is done setting up the project entirely, close out of intelliJ <br>
8. Run the genIntelliJRuns command <br>
    - Windows: `gradlew genIntellijRuns` <br>
    - MacOS/Linux: `./gradlew genIntellijRuns`
    
### Minecraft Dev Plugin

To reduce some of of the boilerplate setup each time we want to make a new project, there is an incredibly helpful plugin 
for IntelliJ called the Minecraft Dev Plugin. With this, we can easily add Forge to our workspace as well as any other APIs with a 
helpful GUI menu.

1.) Find the `Minecraft Dev Plugin` from the IntelliJ Marketplace <br>
    - From the editor window, press <ctrl + shift + a> (<cmd + shift + a> for Macs) and search for plugins <br>
    - From the start screen, click the gear in the bottom right corner and find "Plugins" <br>
2. Search into the marketplace "Minecraft Dev Plugin" and press install <br>
2. Restart IntelliJ 

### Creating our Project

Now that we have all our tools setup, we just need to get our project made. 

1.) Create a new project and select the Minecraft tab <br>
2.) Select Forge as your API (You can include others if desired) <br>
    - When prompted, choose to put these in the same project instead of two separate projects if you're using Sponge
3.) Fill in the prompted boxes <br>
    - For the forge versions, pick the versions that go with the MDK you installed earlier <br>
4.) Create the project and wait till its done being setup entirely <br>
5.) Download the latest server jar from [Reforged's website](https://reforged.gg/) <br>
6.) Create a folder inside of your project called libs (this is our library folder and can be called whatever you want) <br>
7.) Open up your `build.gradle` and add `compile files(libs/PixelmonJarName.jar)` <br>
    - Replace `PixelmonJarname.jar` with the full name of the Pixelmon jar you downloaded <br>
    - If you renamed the folder, you will have to change it here as well <br>
8.) Refresh your project by clicking on the gradle tab on the right of your screen and pressing the circular refresh icon

### Look through the rest of this Cookbook

Now that you have your project ready to go, its time for development. Look through this cookbook for examples and helper classes
that will show you how Pixelmon works. Also check out the `README.md` for information on useful links such as the Reforged JavaDocs
for easy reference to how Pixelmon's API functions

Good Luck!
