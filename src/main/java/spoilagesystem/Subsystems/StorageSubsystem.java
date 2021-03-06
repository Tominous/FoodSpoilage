package spoilagesystem.Subsystems;

import spoilagesystem.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StorageSubsystem {

    Main main = null;

    // values
    public int Bread = 24;
    public int Potato = 48;
    public int Carrot = 48;
    public int Beetroot = 48;
    public int Beef = 24;
    public int Porkchop = 24;
    public int Chicken = 24;
    public int Cod = 24;
    public int Salmon = 24;
    public int Mutton = 24;
    public int Rabbit = 24;
    public int Tropical_Fish = 24;
    public int Pufferfish = 24;
    public int Mushroom_Stew = 72;
    public int Rabbit_Stew = 96;
    public int Beetroot_Soup = 72;
    public int Cooked_Beef = 72;
    public int Cooked_Porkchop = 72;
    public int Cooked_Chicken = 72;
    public int Cooked_Salmon = 72;
    public int Cooked_Mutton = 72;
    public int Cooked_Rabbit = 72;
    public int Cooked_Cod = 72;
    public int Wheat = 48;
    public int Melon = 48;
    public int Pumpkin = 48;
    public int Brown_Mushroom = 48;
    public int Red_Mushroom = 48;
    public int Nether_Wart = 168;
    public int Melon_Slice = 24;
    public int Cake = 24;
    public int Pumpkin_Pie = 24;
    public int Sugar = 72;
    public int Egg = 72;
    public int Sugar_Cane = 48;
    public int Apple = 48;
    public int Cookie = 94;
    public int Poisonous_Potato = 24;
    public int Chorus_Fruit = 94;
    public int Dried_Kelp = 72;
    public int Baked_Potato = 94;

    public String createdText = "Created:";
    public String expiryDateText = "Expiry Date:";
    public String valuesLoadedText = "Values Loaded!";
    public String noPermsText = "Sorry! In order to use this command, you need the following permission: 'fs.reload'";
    public String spoiledFoodName = "Spoiled Food";
    public String spoiledFoodLore = "This food has gone bad.";

    public StorageSubsystem(Main plugin) {
        main = plugin;
    }

    public void saveValuesToConfig() {
        try {
            File saveFolder = new File("./plugins/Food-Spoilage/");
            if (!saveFolder.exists()) {
                saveFolder.mkdir();
            }
            File saveFile = new File("./plugins/Food-Spoilage/" + "food-spoilage-times.txt");
            if (saveFile.createNewFile()) {
                System.out.println("Save file for food spoilage times created.");
            } else {
                System.out.println("Save file for food spoilage times already exists. Overwriting.");
            }

            FileWriter saveWriter = new FileWriter(saveFile);

            // actual saving takes place here
            saveWriter.write(main.version + "\n");
            saveWriter.write("== Food Spoilage Times ==\n");
            saveWriter.write("Bread: " + Bread + " hours\n");
            saveWriter.write("Potato: " + Potato + " hours\n");
            saveWriter.write("Carrot: " + Carrot + " hours\n");
            saveWriter.write("Beetroot: " + Beetroot + " hours\n");
            saveWriter.write("Beef: " + Beef + " hours\n");
            saveWriter.write("Porkchop: " + Porkchop + " hours\n");
            saveWriter.write("Chicken: " + Chicken + " hours\n");
            saveWriter.write("Cod: " + Cod + " hours\n");
            saveWriter.write("Salmon: " + Salmon + " hours\n");
            saveWriter.write("Mutton: " + Mutton + " hours\n");
            saveWriter.write("Rabbit: " + Rabbit + " hours\n");
            saveWriter.write("Tropical_Fish: " + Tropical_Fish + " hours\n");
            saveWriter.write("Pufferfish: " + Pufferfish + " hours\n");
            saveWriter.write("Mushroom_Stew: " + Mushroom_Stew + " hours\n");
            saveWriter.write("Rabbit_Stew: " + Rabbit_Stew + " hours\n");
            saveWriter.write("Beetroot_Soup: " + Beetroot_Soup + " hours\n");
            saveWriter.write("Cooked_Beef: " + Cooked_Beef + " hours\n");
            saveWriter.write("Cooked_Porkchop: " + Cooked_Porkchop + " hours\n");
            saveWriter.write("Cooked_Chicken: " + Cooked_Chicken + " hours\n");
            saveWriter.write("Cooked_Salmon: " + Cooked_Salmon + " hours\n");
            saveWriter.write("Cooked_Mutton: " + Cooked_Mutton + " hours\n");
            saveWriter.write("Cooked_Rabbit: " + Cooked_Rabbit + " hours\n");
            saveWriter.write("Cooked_Cod: " + Cooked_Cod + " hours\n");
            saveWriter.write("Wheat: " + Wheat + " hours\n");
            saveWriter.write("Melon: " + Melon + " hours\n");
            saveWriter.write("Pumpkin: " + Pumpkin + " hours\n");
            saveWriter.write("Brown_Mushroom: " + Brown_Mushroom + " hours\n");
            saveWriter.write("Red_Mushroom: " + Red_Mushroom + " hours\n");
            saveWriter.write("Nether_Wart: " + Nether_Wart + " hours\n");
            saveWriter.write("Melon_Slice: " + Melon_Slice + " hours\n");
            saveWriter.write("Cake: " + Cake + " hours\n");
            saveWriter.write("Pumpkin_Pie: " + Pumpkin_Pie + " hours\n");
            saveWriter.write("Sugar: " + Sugar + " hours\n");
            saveWriter.write("Egg: " + Egg + " hours\n");
            saveWriter.write("Sugar_Cane: " + Sugar_Cane + " hours\n");
            saveWriter.write("Apple: " + Apple + " hours\n");
            saveWriter.write("Cookie: " + Cookie + " hours\n");
            saveWriter.write("Poisonous_Potato: " + Poisonous_Potato + " hours\n");
            saveWriter.write("Chorus_Fruit: " + Chorus_Fruit + " hours\n");
            saveWriter.write("Dried_Kelp: " + Dried_Kelp + " hours\n");
            saveWriter.write("Baked_Potato: " + Baked_Potato + " hours\n");

            saveWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while saving food spoilage times.");
        }

    }

    public void loadValuesFromConfig() {

        try {
            System.out.println("Attempting to load food spoilage times...");
            File loadFile = new File("./plugins/Food-Spoilage/" + "food-spoilage-times.txt");
            Scanner loadReader = new Scanner(loadFile);

            // actual loading

            // check version
            if (!loadReader.nextLine().equalsIgnoreCase(main.version)) {
                System.out.println("[ALERT] Mismatched version found in './plugins/Food-Spoilage/food-spoilage-times.txt'!");
                System.out.println("[ALERT] Values will not be loaded. Defaults will be used.");
                System.out.println("[ALERT] To fix this, please delete the following folder: './plugins/Food-Spoilage/'");
                return;
            }

            // ignore second line
            String temp = loadReader.nextLine();

            int value = -1;
            if (loadReader.hasNextLine()) {
                // get value from each config line and set it to corresponding field
                value = getValueFromConfigLine(loadReader.nextLine()); // line 2
                if (value != -1) {
                    Bread = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine()); // line 3
                if (value != -1) {
                    Potato = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine()); // line 4
                if (value != -1) {
                    Carrot = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine()); // line 5
                if (value != -1) {
                    Beetroot = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Beef = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Porkchop = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Chicken = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cod = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Salmon = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Mutton = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Rabbit = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Tropical_Fish = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Pufferfish = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Mushroom_Stew = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Rabbit_Stew = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Beetroot_Soup = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cooked_Beef = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cooked_Porkchop = value;
                }

            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cooked_Chicken = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cooked_Salmon = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cooked_Mutton = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cooked_Rabbit = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cooked_Cod = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Wheat = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Melon = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Pumpkin = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Brown_Mushroom = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Red_Mushroom = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Nether_Wart = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Melon_Slice = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cake = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Pumpkin_Pie = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Sugar = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Egg = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Sugar_Cane = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Apple = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Cookie = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Poisonous_Potato = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Chorus_Fruit = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Dried_Kelp = value;
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    Baked_Potato = value;
                }
            }

            loadReader.close();
            System.out.println("Food spoilage times successfully loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("There was a problem loading the food spoilage times!");
        }
    }

    public int getValueFromConfigLine(String line) {

        // format: "FoodType: (value) hours"

        int firstSpaceIndex = line.indexOf(" ");
        int lastSpaceIndex = line.lastIndexOf(" ");

        int value = 0;
        try {
            value = Integer.parseInt(line.substring(firstSpaceIndex + 1, lastSpaceIndex));
        } catch(Exception e) {
            System.out.println("Something went wrong when getting a value from a config line.");
            return -1;
        }

        System.out.println("Got value " + value + " from the config line!");
        return value;
    }

    public boolean foodSpoilageFolderExists() {
        File saveFolder = new File("./plugins/Food-Spoilage/");
        if (saveFolder.exists()) {
            System.out.println("food-spoilage folder found!");
            return true;
        }
        System.out.println("food-spoilage folder not found!");
        return false;
    }

    public void saveCustomText() {
        try {
            File saveFolder = new File("./plugins/Food-Spoilage/");
            if (!saveFolder.exists()) {
                saveFolder.mkdir();
            }
            File saveFile = new File("./plugins/Food-Spoilage/" + "food-spoilage-text.txt");
            if (saveFile.createNewFile()) {
                System.out.println("Save file for food spoilage text created.");
            } else {
                System.out.println("Save file for food spoilage text already exists. Overwriting.");
            }

            FileWriter saveWriter = new FileWriter(saveFile);

            // actual saving takes place here
            saveWriter.write(createdText + "\n");
            saveWriter.write(expiryDateText + "\n");
            saveWriter.write(valuesLoadedText + "\n");
            saveWriter.write(noPermsText + "\n");
            saveWriter.write(spoiledFoodName + "\n");
            saveWriter.write(spoiledFoodLore + "\n");

            saveWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while saving food spoilage text.");
        }
    }

    public void loadCustomText() {
        try {
            System.out.println("Attempting to load food spoilage text...");
            File loadFile = new File("./plugins/Food-Spoilage/" + "food-spoilage-text.txt");
            Scanner loadReader = new Scanner(loadFile);

            // actual loading

            if (loadReader.hasNextLine()) {
                createdText = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                expiryDateText = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                valuesLoadedText = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                noPermsText = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                spoiledFoodName = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                spoiledFoodLore = loadReader.nextLine();
            }


            loadReader.close();
            System.out.println("Food spoilage text successfully loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("There was a problem loading the food spoilage text!");
        }
    }




}
