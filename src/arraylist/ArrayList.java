package arraylist;

import util.Dog;

public class ArrayList {
	private Dog[] list;
	public static final int CAPACITY_DEFAULT = 20;
	private int size;
	
	public ArrayList() {
		this(CAPACITY_DEFAULT);
	}
	
	public ArrayList(int capacity) {
		this.list = new Dog[capacity];
		this.size = 0;
	}
	
	// Basic operations: add, remove, get
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public Dog get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return this.list[index];
	}
	
	public boolean add(Dog dog) {
		assureCapacity(this.size + 1);
		this.list[this.size++] = dog;
		return true;
	}
	
	public void add(int index, Dog dog) {
		assureCapacity(this.size + 1);
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		shiftRight(index);
		
		this.list[index] = dog;
		this.size++;
	}
	
	public void shiftRight(int index) {
		for (int i = this.size; i > index; i--) {
			this.list[i] = this.list[i - 1];
		}
	}
	
	public void set(int index, Dog dog) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}	
		this.list[index] = dog;
	}
	
	public Dog remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		Dog dog = this.list[index];
		
		shiftLeft(index);
		this.size--;
		
		return dog;
	}
	
	
	public void shiftLeft(int index) {
		for (int i = index; i < this.size - 1; i++) { 
			this.list[i] = this.list[i + 1];
		}
	}
	
	
	public boolean remove(Dog dog) { 
		if (dog == null) return false;
		
		for (int i = 0; i < this.size; i++) {
			if (this.list[i].equals(dog)) {
				this.remove(i);
				return true;
			}
		}
		return false;		
	}
	
	
	public int indexOf(Dog dog) {
		for (int i = 0; i < this.size; i++) {
			if (this.list[i] == dog) {
				return i;
			}
		}
		return -1;
	}
	

	public boolean contains(Dog dog) {
		return indexOf(dog) != -1;
	}
	
	public void assureCapacity(int requiredCapacity) {
		if (requiredCapacity > this.list.length) {
			resize(Math.max(this.list.length * 2, requiredCapacity));
		}
	}
	
	public void resize(int newCapacity) {
		Dog[] new_list = new Dog[newCapacity];
		for (int i = 0; i < this.list.length; i++) {
			new_list[i] = this.list[i];
		}
		this.list = new_list;	
	}
	
}
