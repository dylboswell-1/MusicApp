package MusicApp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Driver {
    
    public static void main(String[] args) {
        Random rand = new Random(); 
        Scanner scnr = new Scanner(System.in);
        Scanner scnr2 = new Scanner(System.in);

        //Making song objects
        Songs s1 = new Songs("Heartless", "Kanye West", 3);
        Songs s2 = new Songs("Temptation", "Joey Baddass", 8);
        Songs s3 = new Songs("Fear", "Kendrick Lamar", 7);
        Songs s4 = new Songs("Business", "Eminem", 11);
        Songs s5 = new Songs("Love Lockdown", "Kanye West", 8);
        Songs s6 = new Songs("Paranoid", "Kanye West", 1);
        Songs s7 = new Songs("Amazing", "Kanye West", 7);

        // Making a hashmap of all the songs
        HashMap<String, Songs> songHashMap = new HashMap<String, Songs>();
        songHashMap.put("Heartless",s1);
        songHashMap.put("Temptation",s2);
        songHashMap.put("Fear",s3);
        songHashMap.put("Business",s4);
        songHashMap.put("Love Lockdown",s5);
        songHashMap.put("Paranoid",s6);
        songHashMap.put("Amazing",s7);

        //-------------------------------------------------------------

        //Making artist objects
        Artist a1 = new Artist("Kanye West", 00001);
        Artist a2 = new Artist("Joey Baddass", 00002);
        Artist a3 = new Artist("Kendrick Lamar", 00003);
        Artist a4 = new Artist("Eminem", 00004);

        //-------------------------------------------------------------


        //Making podcasts
            // TED TALK
        Podcasts p1 = new Podcasts("Ted Talks Daily", "TED", 1, 1);
        Podcasts p2 = new Podcasts("Ted Talks Daily", "TED", 1, 2);

            // Computer Science Podcast
        Podcasts p3 = new Podcasts("Computer Science Podcast!", "Dylan Boswell", 1, 1);
        Podcasts p4 = new Podcasts("Computer Science Podcast!", "Dylan Boswell", 1,2);

        // Making hashmap of the pocasts
        HashMap<String, Podcasts> podcastHashMap = new HashMap<String, Podcasts>();
        podcastHashMap.put("Ted Talks Daily", p1);
        podcastHashMap.put("Computer Science Podcast!", p3);
        podcastHashMap.put("Ted Talks Daily", p2);
        podcastHashMap.put("Computer Science Podcast!", p4);

        

        //-----------------------
            // Making an album: 808's and HeartBreak
        LinkedList<Content> c1 = new LinkedList<Content>(); // Putting songs from an album into a collection
        c1.add(s1);
        c1.add(s5);
        c1.add(s6);
        c1.add(s7);
        //public Album(String title, LinkedList<Content> ll){
        Album al1 = new Album("808's and HeartBreak",c1); // making the album using the c1 collection

        //-------------------------
            // Making a playlist
        LinkedList<Content> c2 = new LinkedList<Content>(); 
        c2.add(s1);
        c2.add(s2);
        c2.add(s3);
        c2.add(s4);
        Playlist pL1 = new Playlist("My Killer Playlist!",c2);

        // -------------------------------------------------------------------------------------------------------

        // Making initial account
        int firstIDNumber = rand.nextInt(1000,9999);
        System.out.println("Please enter a username.");
        String firstUsername = scnr.nextLine();
        Listener l1 = new Listener(firstUsername, firstIDNumber);
        System.out.println("Your initial account has been created.");


        // User Interface
        Boolean run = true;
        while(run == true)
        {
            
            String s = "1. Create a listener account.\n";
            s += "2. List all Playlists, Albums, Podcasts, and their contents.\n";
            s += "3. Add songs to an existing playlist.\n";
            s += "4. Shuffle an existing Playlist or listen to an Album.\n";
            s += "5. Add a song or podcast to favorites.\n";
            s += "6. Export all of a listener's favorites out to a file in ascending order by times streamed.\n";
            s += "7. Show favorited content.\n"; // I added this just because it was easy and seemed relevant
            s += "8. Exit.\n";

            //---------------------------------------------------------------------------
            // I use this section to make sure the user enters an integer.
            System.out.println("\n\n\nPlease select a number the options listed below: \n" + s);
            String getInput = scnr2.nextLine();
            int userInput;
            try{
                userInput = Integer.valueOf(getInput);
            }
            catch(Exception e){
                userInput = 0000;
            }
            //--------------------------------------------------------------------------

            switch(userInput)
            {
                case 1:
                    int idNumber = rand.nextInt(1000,9999);
                    System.out.println("Please enter a username.");
                    String username = scnr.nextLine();
                    Listener l2 = new Listener(username, idNumber);
                    System.out.println("Your new listener account " + username + " has been created.");
                    break;

                case 2:
                    System.out.println("Now listing all playlists, albums, and podcasts.");

                    // printing out playlist
                    System.out.println("\n" + pL1.m_title);
                    int counter = 1;
                    for(Content c: pL1.m_contentList){
                        System.out.println(counter + ". " + c.m_title + " - " + c.m_artist + ", Number of streams: " + c.m_numStreams);
                        counter+=1;
                    }

                    // printing out album
                    System.out.println("\n" + al1.m_title);
                    int counter2 = 1;
                    for(Content c: al1.m_contentList){
                        System.out.println(counter2 + ". " + c.m_title + " - " + c.m_artist + ", Number of streams: " + c.m_numStreams);
                        counter2+=1;
                    }

                    System.out.println("\n" + "Podcasts:");
                    System.out.println(p1.m_title);
                    System.out.println(p3.m_title);
                    break;

                case 3:

                //Songs(String title, String artist, int numStreams)
                    System.out.println("Enter Song Title. ");
                    String songTitle = scnr.nextLine();
                    System.out.println( "Song: " + songTitle);
                    try{
                    Songs newSong = songHashMap.get(songTitle);
                    // In this case I am just going to add the newSong to the already existing playlist pL1, but if I needed to I could always just create another playlist for the user using their inputs.
                    pL1.addSong(newSong);
                    System.out.println(newSong.m_title + " has been added to your playlist.");
                    }catch(Exception e){
                        System.out.println("Please enter a valid song name.");
                    }
                    break;
                    

                case 4:
                    System.out.println("Please select from the provided options.");
                    System.out.println("1. Shuffle a playlist \n2. Play an entire album\n");
                    String playOption = scnr.nextLine();
                    if(playOption.equals("1")){
                        System.out.println("Now shuffling through " + pL1.m_title);
                        pL1.play();
                    }
                    else if (playOption.equals("2")){
                        System.out.println("Now playing through " + al1.m_title);
                        al1.play();
                    }
                    else{
                        System.out.println("Please select from the provided options.");
                    }
                    break;

                case 5:
                    System.out.println("Which would you like to do?");
                    System.out.println("1. Add a song to favorites. ");
                    System.out.println("2. Add a podcast to favorites. ");

                    String selection = scnr.nextLine();

                    if(selection.equals("1")){
                        try{
                        System.out.println("Give me the song title. "); // Getting the song name from the user
                        String favoriteSongTitle = scnr.nextLine();

                        Songs favoriteSong = songHashMap.get(favoriteSongTitle); // Getting the song object from the hashmap using the userinput as the key
                        l1.favorite(favoriteSong); // Putting the song object into the favorite list
                        System.out.println(favoriteSong.m_title + " has been added to favorites.");
                        }catch(Exception e){
                            System.out.println("You need to enter a valid song name.");
                        }
                    }
                    else if(selection.equals("2")){
                        try
                        {
                        System.out.println("Give me the podcast title. ");
                        String favoritePodcastTitle = scnr.nextLine();

                        Podcasts favoritePodcast = podcastHashMap.get(favoritePodcastTitle);
                        l1.favorite(favoritePodcast);
                        System.out.println(favoritePodcast.m_title + " has been added to favorites.");
                        }catch(Exception e){
                            System.out.println("You need to enter a valid podcast name.");
                        }
                    }
                    else{
                        System.out.println("Please select one of the provided options.");
                    }
                    break;
                    
                case 6:
                    Collections.sort(l1.m_favoritedContent);
                        try
                        {
                            PrintWriter pw = new PrintWriter(new FileWriter("MP4_NumberedSongs_output.txt"));
                            
                            for(Content c: l1.m_favoritedContent){
                                pw.write(c.m_title + " - " + c.m_artist + " - Number of streams: " + c.m_numStreams + "\n");
                            }
                            pw.close();

                            System.out.println("The file 'MP4_NumberedSongs_output.txt' has been made on your computer.");
                        }catch(Exception e){ // can catch multiple different exceptions
                            System.err.println("Something went wrong..");
                            e.printStackTrace(); // This prints out the last thing that happened in the stack
                        }
                    break;

                case 7:
                    try
                    {
                        for(Content c: l1.m_favoritedContent){
                            System.out.println(c.m_title + " by " + c.m_artist + ".");
                        }
                    }catch(Exception e){
                        System.out.println("No songs have been added to favorites yet!");
                    }
                    break;
                case 8:
                    System.out.println("Thank you for using my app!");
                    run = false;
                    break;
                default:
                    System.out.println("Please enter a number 1-8");
            }

        }
        scnr.close();
        scnr2.close();
    }
    

}
