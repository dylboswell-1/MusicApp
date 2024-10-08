package MusicApp;
import java.util.LinkedList;

public class Listener extends Accounts {

    LinkedList<Content> m_favoritedContent;

    public Listener(){
        super();
        m_favoritedContent = new LinkedList<Content>();
    }

    public Listener(String name, int id){
        super(name, id);
        m_favoritedContent = new LinkedList<Content>();
    }

    public void favorite(Content c){
        m_favoritedContent.add(c);
    }
}
