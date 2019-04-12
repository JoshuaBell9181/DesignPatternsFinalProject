package sweProject.Iterator;

public class FindIterator implements Iterator{
	
	int index = 0;
	String[] list;
	
	public FindIterator(String[] list){
		this.list = list;
	}

	@Override
	public void first() {
		index = 0;
	}

	@Override
	public void next() {
		index = index + 1;	
	}

	@Override
	public boolean isDone() {
		try {
			String test = list[index + 1];
			return false;
		} catch(Exception e){
			return true;
		}

	}

	@Override
	public String currentItem() {
		return list[index];
	}

}
