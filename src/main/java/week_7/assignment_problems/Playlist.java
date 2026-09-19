class PlaylistData {

    private String[] songs;
    private int songCount;

    public PlaylistData(int maxSongs) {

        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {

        if (songCount >= songs.length) {
            System.out.println("Song rejected: Playlist is full");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {

        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}

public class Playlist {

    public static void main(String[] args) {

        PlaylistData p = new PlaylistData(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs:");
        for (String song : copy) {
            System.out.println(song);
        }

        copy[0] = "Hacked";

        System.out.println("First song in playlist: "
                + p.getSongs()[0]);

        System.out.println("Song count: " + p.getSongCount());
    }
}

