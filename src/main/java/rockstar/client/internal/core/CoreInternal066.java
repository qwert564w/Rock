package rockstar.client.internal.core;



import rockstar.client.bot.*;
import rockstar.client.*;
import rockstar.client.bot.BotTargetManager;

public interface CoreInternal066 {
    public void internalMethod07229(BotTargetManager localValue1);

    default public String internalMethod06553() {
        String string = this.getClass().getSimpleName();
        return string.endsWith("Behavior") ? string.substring(0, string.length() - "Behavior".length()) : string;
    }
}

