![Example Image](https://i.imgur.com/nU0fRMh.jpg)

# Eco Plugin Template!

A simple way to begin learning `Java` minecraft development. We provide a ready and simple template
that is specifically made for beginners. This template also includes some commonly used classes in miencraft
development such as `Config` and `Gui` classes made just so you don't have to.

If you are a veteran developer, this is most likely not for you. This is made specifically for teaching new
developers the ropes of it all, not to give a complex template that covers every possible scenario. Goal is to
lower the barrier for beginners.

## Sections
- Create the project.
  - Download
  - Setup
  - Build
  - Test
- Using commands.
- Using listeners.
- Using guis.
- Using configs.

## Create the project

Setup is made as simple as possible and should take much less time than making one from scratch.

### Download

Start by cloning this repository to your local device. If you have never used github before we suggest you to use this youtube video that explains everything about github.

### IDE

Setup your IDE () for where you will be viewing your code. We highly suggest using `IntelliJ IDEA` for this
as this editor is highly focused on Java and offers a free version.

### Build



### Test


## Using commands

We have provided you with 3 different command templates, but they all use the same principle.
Here is a step-by-step guide for creating your own commands:

Let's start off, by creating a simple class that implements `CommandExecutor`. It allows us to listen for when
a command is called.

<sub><sub>ExamplePlayerCommand.Java</sub>
```java
public class ExamplePlayerCommand implements CommandExecutor {

}
```

Now we can create an `@Override` method that listens for the command event. The method will execute any
code inside it once the command is executed. This will be how every base command will look, which means
this part can just be copied from other commands as it is always the same.

<sub><sub>ExamplePlayerCommand.Java</sub>
```java
public class ExamplePlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String title, @NotNull String[] strings) {
        return true;
    }
}
```

For safety reasons we will check if the `entity` that executed said command is an actual player. Once we
have confirmed that it is a player we save it in a `player` variable for later use.

<sub><sub>ExamplePlayerCommand.Java</sub>
```java
public class ExamplePlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String title, @NotNull String[] strings) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        return true;
    }
}
```

Now that we know it's a player, we can go wild and execute any code our hearts desire. Here is a very simple
example of us sending a message to the player that executed the command.

<sub><sub>ExamplePlayerCommand.Java</sub>
```java
public class ExamplePlayerCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String title, @NotNull String[] strings) {
        
        if (!(sender instanceof Player player)) {
            return false;
        }
        
        player.sendMessage(parse("&6You &fexecuted the example &6player &fcommand!"));

        return true;
    }
}
```

If you test the command, you might have noticed that it doesn't work. It is because we still need to do one
very important thing. We must register our command in the `plugin.yml` and then register the
`CommandExecutor` class in our `Main` class.

<sub><sub>plugin.yml</sub>
```yml
name: Minecraft-Paper-Plugin-Template
main: roustytousty.minecraftPaperPluginTemplateJava.Main
version: '1.0'
author: RoustyTousty
api-version: '1.21'

commands:
  exampleplayercommand:
```

We can also add some of the built-in attributes such as `aliases`, `description`, `usage`, `permission`
and `permission-message`.

<sub><sub>plugin.yml</sub>
```yml
name: Minecraft-Paper-Plugin-Template
main: roustytousty.minecraftPaperPluginTemplateJava.Main
version: '1.0'
author: RoustyTousty
api-version: '1.21'

commands:
  exampleplayercommand:
    description: "This is an example command"
    usage: "/command"
    aliases: [examplecmd, epc]
    permission: my.permission
    permission-message: "You do not have permission to use this command!"
```

Now lets set the executor of this command to the class we previously made. This has to be placed in the
`OnEnable()` method for it to work. In our template we seperated in to its own function. For simplicity i will
put it in the base `OnEnable()` method.

When registering a command we provide the `.getCommand(<name>)` method with the name of our command,
following with a `.setExecutor(<class>)` method with the class that we made for it.

`this.getCommand("exampleplayercommand").setExecutor(new ExamplePlayerCommand());`

Heres how it would look like in our `Main` class. In the template this would look slightly differrent.

<sub><sub>Main.Java</sub>
```java
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("exampleplayercommand").setExecutor(new ExamplePlayerCommand());
        
        getLogger().info("Plugin Setup!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled!");
    }
}
```

Congratulations! You just made a minecraft command. This method is universal and every command will just
be a copy of each other. Meaning you only need to make it once and every command after will be a 
copy/paste.

## Using listeners

## Using guis

## Using configs









