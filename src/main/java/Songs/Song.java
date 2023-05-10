package Songs;

public class Song{
	String songname;
	Song next;

	public Song() {
		this.songname = "";
		this.next = null;

	}

	public Song(String songname, Song prev, Song next) {
		this.songname = songname;
		this.next = next;
	}


}
