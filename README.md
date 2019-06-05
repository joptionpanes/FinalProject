# Journeyman's Quest
Journeyman's Quest is a text-based RPG made in Java. In it, you walk aimlessly, encountering enemies and cities in your path. You build up your gear, as you feel a presence that is lurking underneath. Still aimlessly walking, but with intent, you've found this dark, otherworldly presence. It is a cute little bunny rabbit, *not*. <br/>
This game has the following features:

* Fully fleged character
  * Levels and xp
  * Scoring
* Encounters
  * Cities
  * Enemy battles
  * Wandering trader
* Map
* Saving and loading
* And more!
## Character
<h3 align = "center"> Inventory </h3>

* 20 slots
  * Armor and weapons are not stackable
  * Normal items are (Catalysts and rocks, currently)
* 4 slots for armor and 1 for equipped weapon
* GUI to show items and equipment
<h3 align = "center"> XP and Levels </h3>

Affects shops and enemy encounter.

<h3 align = "center"> Class </h3>

* Classes do 1.5x more damage with their weapons
  * Swordsman => sword
  * Archer => Bows
  * Mage => Wands
Who'd've thunk it?
 
 ## Encounters
<h3 align = "center"> Enemy </h3>
 
 * Slime, Goblin, Undead, Orc, Giant
   * Do more damage, have higher defence, (higher stats in general) the further right
 * Main way to get coins and levels
 * Most common encounter
 
<h3 align = "center"> City </h3>
 
* Randomly generated
* Chance to spawn with:
  * Shop
    * Buy & sell items
    * Randomly generated items
  * Inn
    * Heal health
  * Forge
    * Upgrade tools with rocks and coins
  * Quest
    * Kill enemies for coins
    * Only one quest can be accepted at a time
* Saved on the map, so you can go back and buy an item that was previously too expensive for you, or access the quest/forge/inn that existed there!
* Second most common encounter
 
<h3 align = "center"> Wandering Trader </h3>
  
* Buy randomly generated items only
  * Cheaper and better items
* Once you leave, you cannot go back, he wanders away. (It is not saved on the map)
* Rarest encounter

<h3 align = "center"> Rocks </h3>
 
Sometimes you're wandering around and a litte glimmer catches your eye. You find some rocks that look to be of some value. These can be used in the forge to upgrade your items
 
## Map

The map is stored in the save folder, and is randomly generated as you walk around. The Boss areas are generated in advance, in one location that per multiple of 100 (x/y) up to 1000, 10 spaces radius.<br/>
The below image is a representation of the boss spawning. Red is any coordinate at a mutiple of 100, up to 1000. Boss will spawn anywhere inside the black box.

<img src="./images/Grid.png" alt="Grid example" width="192" image-rendering="pixelated">

## Flow Chart
 <img src="./images/Final Flow Chart.png" alt="Project Flow Chart" height="400" width="400">

## Video
<iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0"width="788.54" height="443" type="text/html" src="https://www.youtube.com/embed/fryWuiGTE58?autoplay=0&fs=1&iv_load_policy=3&showinfo=0&rel=0&cc_load_policy=0&start=0&end=0&origin=https://youtubeembedcode.com"><div><small><a href="https://youtubeembedcode.com/en">youtubeembedcode en</a></small></div><div><small><a href="http://add-link-exchange.com">ww://add-link-exchange.com</a></small></div><div><small><a href="https://youtubeembedcode.com/pl/">youtubeembedcode.com/pl/</a></small></div><div><small><a href="http://add-link-exchange.com">ww://add-link-exchange.com</a></small></div></iframe>
<a href="https://youtu.be/fryWuiGTE58">Link here</a>
