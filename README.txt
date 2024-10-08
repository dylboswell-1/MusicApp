Dylan Boswell

OVERVIEWS
- Accounts (Parent class)
* Parent Class for Artist and Listener Class
* Member Variables: m_name, m_ID
* Default Constructor and Specified Constructor
- Artist (Child class)
* Inherits from Accounts
* Default constructor with super();
* Specified constructor with super(name, id);
- Listener (Child class)
* Inherits from Accounts
* Uses a linkedlist member variable that stores Content objects: m_favoritedContent.
* Default constructor with super();
* Specified constructor with super(name, id);
* Has a method called 'favorite' which takes in a Content object as a parameter
*       This method will add a Content object to the m_favorited linkedlist


- ContentCollection (Parent class)
* Abstract class that implements the Comparable interface to compare ContentCollection
* Member variable: m_title and a linkedlist of type Content: m_contentList
* There is a default and overloaded constructor for ContentCollection
* Abstract method play();
* Method shuffle() which will call the play() method on a random piece of Content from the m_contentList.
* Method compareTo() which will compare ContentCollections based on their size and either return -1, 1, or 0.
*    (The compareTo() method could have been abstract since it is in both the playlist and album classes)
- Album (Child class)
* Child class of ContentCollection
* Default and overloaded constructor
*          The overloaded constructor takes in a String for the Album name, and a LinkedList of type Content which is a collection of all of the songs in the album.
* Abstract Method play() which goes through every song in the ContentCollection and calls the play() method on it.
* Method compareTo() which takes in an Album parameter and sorts the album based on its size. 
*       (Now that I am writing this I see that the compareTo method could have been abstract)
- Playlist (Child class)
* Child class of ContentCollection
* Default and Overloaded constructors.
*       The overloaded constructor takes in a String for the playlist name, and a LinkedList of type Content which is a collection of all of the songs in the playlist.
* The required play() method which plays every song from the playlist randomly
* The addsong() method which adds a song to the m_contentList linkedList. 
*       In this case that linkedlist represents a class.
* The removesong() method which removes a song from the m_contentList linkedlist.
* The compareTo() method which sorts playlists by their size().
*       This method could have been abstract, but isn't within my program.


- Content (Parent Class)
* Parent class for Podcasts, and Songs
* Member variables m_title, m_artist, m_numStreams.
* Default and Overloaded constructors
* Abstract Method play()
* The compareTo() method which sorts Content by its number of streams
- Podcasts (Child class)
* Child class of Content
* Member variable: m_episodeNumber
* Default and Overloaded constructors
* The required play() method which adds 1 to m_numStreams and prints out *Podcast noises* to imitate a podcast being played.
- Songs (Child Class)
* Child class of Content
* Default and overloaded constructors
* The required play() method which prints out * Song noises * to imitate a song being played.



- Driver (User Interface Class)
* I create multiple Songs, Artists, and Podcasts
* I made a hashMap<String, Songs> with all of the songs so I could easily access them later 
* I create 2 linkedlist filled with Songs.
*   One to represent a Playlist
*   One to represent an Album
* I also create a HashMap for the Podcasts

* Once I created all of my objects I started to work on the interface.
* First I ask the user to create an account, so that I have somewhere to save their favorited songs.
* Then a while loop begins, and I show the user all of the options 1-8.
* I make sure that the user inputs an integer using a try/catch statement.
*   If the user doesn't put in an integer then I simply then rerun the loop
*   I rerun the loop, by setting the following switch statement to a condition that does nothing but ask the user for a number 1-8.
* Once the user does input an int I use a switch statement tomatch the user's selection, to code that accomplishes that task.

* 1. Create an Accounts
- I ask for the users account name, then create a listener account with that name and a randomly generated ID.

* 2. Print out playlits, albums, and Podcasts
- I use an enhanced for loop to print out the title, artist, and number of streams for each piece of content.

* 3. Add a song to playlist
- I get the song name from the user as a String, then I take take the object version of that song and call the addSong() method on it.

* 4. Shuffle an existing playlist or listen to an album
- I give the user two options: One for the playlist, and one for the album.
- For option 1. I call the play() method on the playlist
- For option 2. I call the play() method on the album

* 5. Add a song or podcast to favorites
- I give the user two options: One to add a song, and one to add a playlist
- For option 1. I get the song name from the user, then call the favorite() method on the corresponding Songs object.
- For option 2. I get the podcast name from the user, then call the favorite() method on the corresponding Podcasts object.

* 6. Export all of a listener’s favorites out to a file in ascending order by times streamed
- I call Collections.sort() on the listenters m_favorited content in order to sort the linkedlist by number of streams.
- I use the PrintWriter and FileWriter classes to write out all of the favorited-content's names, artists, and number of streams
-       in a text file called "MP4_NumberedSongs_output.txt".
- I do this in a try/catch statement in order to handle exceptions.

* 7. Display all favorited content within the terminal. (I added this because it was relevant, and simple)
- I use an enhanced for loop to cycle through all of the Content in m_favoritedContent and print out the content's title and artist
- I do this in a try/catch statement, in case the user attempts to show favorited content before anthing is added to the linkedlist.

* 8. Exit
- I thank the user for using my app.
- I then break out of the while loop.

* Default
- I have a default section at the bottom of my Switch statement, in case the user inputs anything other than an integer from 1-8.
- In my code you will probably see that I set the Switch statment's conditional variable, userInput, eqaul to 0000 if the user doesn't enter a number 1-8.
- I do this so that my switch statement will run the code in the default section. 
- In this section I simply ask the user to give me a number 1-8.




DIAGRAM

Parent Classes:             Accounts                                    ContentCollection (Implements Comparable <ContentCollection>)                              Content (Impliments Comparable <Content>)                Driver
                                ^                                               ^                                                                                       ^
Child Classes:         Listener     Artist                               Album    Playlist                                                                      Podcasts    Songs






Why I Chose This Approach:

I decided to organize my classes this way, because of how the question was presented on Notion.
It seem apparent that the Listener and Artist classes would both fall under the Accounts class, because they all shared member variables such as names and IDs.
I made Albums, and Playlists child classes of ContentCollection, because they both meant to represent grouptions/collections of either Songs or Podcasts.
I made Songs and Podcasts child classes of Content because the classes were both meant to reperesent a single object, and because they would all have
titles, artists, and a number of streams. The ContentCollection and Content classes both implement a Comparable interface, because those classes need to be able to sort their objects my a given member variable.
ContentCollection sorts by the collection's size, whereas Content sorts by the object's number of streams.





Challenges I Faced
I struggled the most with sorting by using the Comparable interface. I ended up mostly just copying class notes in order to finish the compareTo() methods.
I also had a difficult time with outputing to a file. I understand the area a bit better, after studying for the final, but at the time I was really uncomfortable with the PrintWriter and FileWriter syntax.


Places I Could Seet Developer Expanding On
Obviously, it would be possible to take what I have now, and make it actually function for a real world music app such as Spotify.
You could make it so that a user's most played songs within a playlist are automatically sorted for them by number of streams.
Right now on Spotify you are unable to see the number of streams a song has unless it is in the Artist's top ten, so you could possibly make it so that each song's number of streams is displayed.
I would also like to add ability to automatically remove duplicate songs from a playlist. This is a feature that Spotify currently doesn't have, but that I have wanted for years.