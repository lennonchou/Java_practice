package filesystem;

public abstract class Entry {
	private Directory parent;
	protected long created;
	private long lastAccessed;
	protected long lastUpdated;
	protected String name;
	
	public Entry(String name, Directory p) {
		this.name = name;
		this.parent = p;
		this.created = System.currentTimeMillis();
	}
	
	public boolean delete() {
		if (parent == null) {
			return false;
		}
		return parent.deleteEntry(this);
	}
	
	public String getFullPath() {
		if (parent == null) {
			return name;
		}
		return parent.getFullPath() + "/" + name;
	}
	
	public long getCreationTime() {
		return created;
	}
	public long getLastAccessedTime() {
		return lastAccessed;
	}
	public long getLastUpdatedTime() {
		return lastUpdated;
	}
	public void changeName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
