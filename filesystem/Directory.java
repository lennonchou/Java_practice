package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
	protected List<Entry> contents;
	
	public Directory(String name, Directory p) {
		super(name, p);
		contents = new ArrayList<Entry>();
	}
	
	public List<Entry> getContents() {
		return contents;
	}
	
	public int getTotalSize() {
		int size = 0;
		for (Entry e : contents) {
			if (e instanceof Directory) {
				size += ((Directory) e).getTotalSize();
			} else if (e instanceof File) {
				size += ((File)e).size();
			}
		}
		return size;
	}
	
	public Entry getChild(String child) {
		for (Entry e : contents) {
			if (e.getName().equals(child)) {
				return e;
			}
		}
		return null;
	}
	
	public int numberOfFiles() {
		int num = 0;
		for (Entry e : contents) {
			if (e instanceof Directory) {
				num++;
				num += ((Directory)e).numberOfFiles();
			} else if (e instanceof File){
				num++;
			}
		}
		return num;
	}
	
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
}
