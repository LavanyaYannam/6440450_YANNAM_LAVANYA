
public class task19 {
    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play();
        p.play();
    }
}
class Piano implements Playable {
    public void play() {
        System.out.println("Playing piano...");
    }
}
class Guitar implements Playable {
    public void play() {
        System.out.println("Playing guitar...");
    }
}
interface Playable {
    void play();
}



