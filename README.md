
# ⚔️ Dungeon Crawl - A JAVA Game ⚔️

✨ In this project, we had to design and implement a **Roguelike** game in Java language.

**The Team behind this game:**

👩‍💻 Sára (***@soosdsara***) <br>
👨‍💻 Balázs (***@zarka1***) <br>
👩‍💻 Zsófi (***@zsigray***) <br>

🔍 For exact contributions of each member, please see **commit history**!

Starter code including *JavaFX toolkit* was provided by @Codecool. 

### How to play

0. ❗Make sure you can run a .java file on your machine!
1. ⬇️Download this repository
2. ▶️Run the **\src\main\java\com\codecool\dungeoncrawl\App.java** file
3. 🌻Play the day away!

### Game Rules

😁 The goal of the game is making friends with all enemies <br>
☠️ This is a non-violent game, so you cannot hurt anyone, you can die however <br>
👾 Monsters will hurt you if you step to the field next to them <br>
🌻 Monsters will become your friends if you give them the flowers you can pick up <br>
🏆 You win the game once all your friends <br> <br>
🤫 *Shhh! Are you stuck? Hit Ctrl+K, then enter "Sara" or "Balazs" of "Zsofi" in the confirmation field, you will have secret superpowers!*


ℹ️ You can navigate through the map with your arrow keys! <br>
ℹ️ You can monitor your health and the number of flowers in your hand on the side panel <br>
ℹ️ Skeletons will not move, spiders move randomly, but beware of Goblins (evil Mike Wazowski) as they will follow you! <br>
ℹ️ You have to collect a key to move through the closed door!

## What were we learning?

- 💡Getting more practice in OOP.
- 💡Understanding design patterns: layer separation. (All of the game logic, such as player
  movement, game rules, and so on), is in the `logic` package, completely
  independent of user interface code. 



## 📃 Here you can find the original tasks and requirements that we had to keep in mind while designing the game:

1. **Analyze the project**\
   Understand the existing code, classes, and tests so you can make changes. Do this before planning anything else. It helps you understand what is going on.
   - A plan is created with task lists.

2. **Restrict movement**\
   Create a game logic which restricts the movement of the player so they cannot run into walls and monsters.
    - The hero is not able to move into walls.
    - The hero is not able to move into monsters.

3. **Dungeon items**\
There are items lying around the dungeon. They are visible in the GUI. 
   - There are at least two item types, such as a key and a sword.
   - There can be one item in a map square.
   - A player can stand on the same square as an item.
   - The item must be displayed on screen (unless somebody stands on the same square).

4. **Pick up items**\
Create a feature that allows the hero to pick up an item.
   - There is a way to pick up items.
   - After the player picks up the item, the item the hero is standing on is gone from map.

5. **Show picked up items**\
   Show picked up items in the inventory list.
   - There is an `Inventory` list on the screen.
   - After the hero picks up an item, it appears in the inventory.

6. **Attack monsters**\
   Make the hero able to attack monsters by moving into them.
   - Attacking a monster removes 5 health points. If the health of a monster goes below 0, it dies and disappears.
   - If the hero attacks a monster and it does not die, it also attacks the hero at the same time (it only removes 2 health points).
   - Having a weapon increases attack strength.
   - Different monsters have different health and attack strengths.

7. **Doors and keys**\
   Create doors in the dungeon that are opened using keys.
   - There are two new square types, closed door and open door.
   - The hero cannot pass through a closed door unless there is a key in the inventory. After moving through, the closed door becomes an open door.

8. **Different monsters**\
   Create three different monster types with different behaviors.
    - There are at least three different monster types with different behaviors.
    - One type of monster does not move at all.
    - One type of monster moves randomly. It cannot go trough walls or open doors.

9. **OPTIONAL TASK: Better movement AI**\
   Create a more sophisticated movement AI.
    - A custom movement logic is implemented (such as a monster that chases the player).

10. **More map features**\
    Create maps that have more varied scenery. Take a look at the tile sheet (tiles.png). Get inspired!
    - At least three more tiles are used. These can be more monsters, items, or background. At least one of them must be not purely decorative, but have some effect on gameplay.

11. **OPTIONAL TASK: Character name**\
    Allow the player to set a name for the character. This name can also function as a cheat code.
    - There is a `Name` label and text field on the screen.
    - If the name given is one of the game developers' name, the player can walk through walls.
  
      ℹ️ **This task was not implemented, but we used the cheat code idea. It can be entered any time during the game by pressing Ctrl+k**


