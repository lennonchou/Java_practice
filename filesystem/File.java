package filesystem;

public class File extends Entry{
	String content;
	int size;
	
	public File(String name, Directory p, int size) {
		super(name, p);
		this.size = size;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String getContent() {
		return content;
	}
	
	public void changeContent(String newContent) {
		content = newContent;
	}
	
//	public static void main(String[] args) {
//		String s = "//foo/bar";
//		String[] ss = s.split("/");
//		System.out.println(ss.length);
//		for (String sss : ss) {
//			System.out.println(sss);
//		}
//	}
}
