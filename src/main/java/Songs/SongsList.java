package Songs;

import java.util.ArrayList;

public class SongsList {

	int capacity;
	int queuecapacity;
	int index;
	Boolean flag;
	Song start;

	
	


	public SongsList(int capacity,int queuecapacity) {
		this.capacity = capacity;
		this.queuecapacity = queuecapacity;
		this.index=0;
		this.start = null;
		if(capacity>=queuecapacity) {
			flag=true;
		}else {
			flag=false;
		}
	}

	public ArrayList<String> getSongsList(){
		
		ArrayList<String> al = new ArrayList<String>();
		
		if(start!=null) {
			Song curr = this.start;
			do {
				System.out.println(curr.songname);
				al.add(curr.songname);
				curr = curr.next;
			}while(curr!=this.start);
			return al;
		}
		
		return null;
		
		
	}
	
	public void printSongs() {
		System.out.println("Current list starts:");
		Song curr = this.start;
		if(start!=null) {
			do {
				System.out.println(curr.songname);
				curr = curr.next;
			}while(curr!=this.start);
		}
		System.out.println("Current list ends:");
	}

	public Song isSongPresent(String songname) {
		Song curr = this.start;
		if(this.start!=null) {
			while(curr!=this.start) {
				System.out.println(this.start.songname);
				if(curr.songname.equals(songname))
					return curr;
			}
		}

		return null;

	}


	public void  addSong(String songname) {

		if(flag) {
			Song newsong = new Song(songname,null,null);
			newsong.next=this.start;

			if(this.start==null) {
				this.start = newsong;
				newsong.next = start;
				index++;

			}
			else {
				if(isSongPresent(songname)!=null) {
					Song song = isSongPresent(songname);
					this.start = song;
				}else {
					Song curr = this.start;
					while(curr.next!=this.start) {
						curr = curr.next;
					}
					curr.next= newsong;
					index++;
					
					if(index>queuecapacity) {
						
						Song lcurr = this.start;
						while(lcurr.next!=this.start)
							lcurr= lcurr.next;
						
						lcurr.next = this.start.next;
						this.start = this.start.next;
						
					}
					
				}
			}

			




		}


	} 









}
