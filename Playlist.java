package MusicApp;
import java.util.LinkedList;
import java.util.Random;
public class Playlist extends ContentCollection {

    public Playlist(){
        super();
    }

    public Playlist(String title, LinkedList<Content> LL){
        super(title, LL);
    }

    public void play(){

        Random rand = new Random();

        LinkedList<Content> listCopy = new LinkedList<Content>(); // making a copy of the list so I can remove songs from it. 
        for(Content c: m_contentList){
            listCopy.add(c);
        }

        while(listCopy.size() > 0){
            int number = rand.nextInt(0, listCopy.size());
            listCopy.get(number).play();
            listCopy.remove(number);
        }

    }

    public void addSong(Songs s){
        m_contentList.add(s);
    }

    public void removeSong(Songs s){
        m_contentList.remove(s);
    }
    

    public int compareTo(Playlist p) { // sorts the playlists by their size
        int ret;
        if (this.m_contentList.size() > p.m_contentList.size()) {
          ret = 1;
        } else if (this.m_contentList.size() < p.m_contentList.size()) {
          ret = -1;
        } else { // if the size is the same
          ret = 0;
        }
        return ret;
    }

}
