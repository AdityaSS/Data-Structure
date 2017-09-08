package Datastructure;

public class HashTable {
	int TABLE_SIZE = 100;
	Record[] tableData = new Record[TABLE_SIZE];

	public void put(Object key, Object value) {
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode, step);
		while (!isEmpty(slot)) {
			slot = hash(keyCode, ++step);
		}
		tableData[slot] = new Record(key, value);
	}

	private boolean isEmpty(int slot) {
		return tableData[slot] == null;
	}

	private int hash(int keyCode, int step) {
		if (step == 0) {
			return keyCode % TABLE_SIZE;
		} else {
			return (keyCode % TABLE_SIZE + step * step) % TABLE_SIZE;
		}
	}
	
	public boolean keyExists(Object key){
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode,step);
		while(tableData[slot]!=null && !tableData[slot].getKey().equals(key)){
			slot = hash(keyCode,++step);
		}
		if(tableData[slot]!=null) return true;
		return false;
	}
	
	public Object get(Object key){
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode,step);
		while(tableData[slot]!=null && !tableData[slot].getKey().equals(key)){
			slot = hash(keyCode,++step);
		}
		if(tableData[slot]!=null) return tableData[slot].getData();
		return null;
	}

	public class Record {

		Object key;
		Object data;

		public Record(Object key, Object data) {
			this.key = key;
			this.data = data;
		}

		public Object getKey() {
			return key;
		}

		public Object getData() {
			return data;
		}
	}
	
	public static void main(String[] args){
		HashTable ht = new HashTable();
		ht.put("4", 40);
		ht.put("6", 60);
		ht.put("7", 70);
		ht.put("8", 80);
		ht.put("9", 90);
		ht.put("5", 50);
		System.out.println(ht.keyExists("2"));
		System.out.println(ht.keyExists("4"));
		System.out.println(ht.get("4"));

	}
}
