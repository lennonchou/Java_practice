package filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
	private final Directory root;
	
	public FileSystem() {
		root = new Directory("/", null);
	}
	
	private List<Entry> resolve(String path) {
		String[] components = path.substring(1).split("/");
		List<Entry> entries = new ArrayList<>(components.length + 1);
		entries.add(root);
		Entry entry = root;
		for (String component : components) {
			if (entry == null || (entry instanceof Directory)) {
				throw new IllegalArgumentException("Invalid path " + path);
			} 
			if (!component.isEmpty()) {
				entry = ((Directory)entry).getChild(component);
				entries.add(entry);
			}
		}
		return entries;
	}
	
	public void mkdir(String path) {
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) != null) {
			throw new IllegalArgumentException("Directory already exists: " + path);
		}
		String[] components = path.split("/");
		final String dirName = components[components.length - 1];
		final Directory dirParent = (Directory) entries.get(entries.size() - 2);
		Directory d = new Directory(dirName, dirParent);
		dirParent.addEntry(d);
	}
	
	public void createFile(String path) {
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) != null) {
			throw new IllegalArgumentException("File already exists: " + path);
		}
		String[] components = path.split("/");
		final String fileName = components[components.length - 1];
		final Directory fileParent = (Directory) entries.get(entries.size() - 2);
		File f = new File(fileName, fileParent, 0);
		fileParent.addEntry(f);
	}
	
	public void delete(String path) {
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) == null) {
			throw new IllegalArgumentException("No named file/directory exists: " + path);
		}
		final Entry entry = entries.get(entries.size() - 1);
		final Directory parent = (Directory) entries.get(entries.size() - 2);
		parent.deleteEntry(entry);
	}
	
	public FileStatus[] list(String path) {
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) == null || !(entries.get(entries.size() - 1) instanceof Directory)) {
			throw new IllegalArgumentException("No named directory exists: " + path);
		}
		Directory dir = (Directory) entries.get(entries.size() - 1);
		return (FileStatus[]) dir.getContents().toArray();
	}
	
	public int count() {
		return root.numberOfFiles();
	}
}
