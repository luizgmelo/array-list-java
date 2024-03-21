package arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Dog;;
class ArrayListTest {

	@Test
	public void test() {
		ArrayList list = new ArrayList(5);
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testAddDogParam() {
		ArrayList list = new ArrayList(5);
		list.add(new Dog("Caramelo", "Chihuahua"));
		assertFalse(list.isEmpty());
		assertTrue(list.size() == 1);
		
		list.add(new Dog("Branquinho", "Boxer"));
		list.add(new Dog("Milgrau", "Pastor Alemão"));
		list.add(new Dog("Max", "Bulldog Francês"));
		list.add(new Dog("Luna", "Poodle"));
		list.add(new Dog("Buddy", "Labrador Retriever"));
		list.add(new Dog("Maggie", "Poodle"));
		assertTrue(list.size() == 7);
		
		assertEquals("Caramelo", list.get(0).getName());
		assertEquals("Chihuahua", list.get(0).getBreed());
		assertEquals("Luna", list.get(4).getName());
		assertEquals("Poodle", list.get(4).getBreed());
		assertEquals("Maggie", list.get(6).getName());
		assertEquals("Poodle", list.get(6).getBreed());
	}
	
	@Test
	public void testAddIndexAndDogParam() {
		ArrayList list = new ArrayList(5);
		
		list.add(0, new Dog("Branquinho", "Boxer"));
		list.add(1, new Dog("Buddy", "Labrador Retriever"));
		list.add(2, new Dog("Max", "Bulldog Francês"));
		list.add(3, new Dog("Luna", "Poodle"));
		list.add(1, new Dog("Caramelo", "Chihuahua"));
		
		assertEquals("Branquinho", list.get(0).getName());
		assertEquals("Caramelo", list.get(1).getName());
		assertEquals("Buddy", list.get(2).getName());
		assertEquals("Luna", list.get(4).getName());
	}
	
	@Test
	public void testSet() {
		ArrayList list = new ArrayList(5);
		list.add(new Dog("Branquinho", "Boxer"));
		list.add(new Dog("Milgrau", "Pastor Alemão"));
		list.add(new Dog("Max", "Bulldog Francês"));
		list.add(new Dog("Luna", "Poodle"));
		list.add(new Dog("Buddy", "Labrador Retriever"));
		list.add(new Dog("Maggie", "Poodle"));
		
		
		// testando set com índice inválido
        try {
            list.set(list.size(), new Dog("Dog inválido", "Dog inválido"));
            fail("esta linha não pode ser executada.");
        } catch (IndexOutOfBoundsException e){}
        
        try {
            list.set(-1, new Dog("Dog inválido", "Dog inválido"));
            fail("esta linha não pode ser executada.");
        } catch (IndexOutOfBoundsException e){}
    
        // testando set com índice válido
        list.set(list.size() - 1, new Dog("Brutus", "Boxer"));
        assertEquals(list.get(list.size() - 1).getName(), "Brutus");
        
        list.set(0, new Dog("Caramelo", "Chihuahua"));
        assertEquals(list.get(0).getName(), "Caramelo");
        
        list.set(2, new Dog("Charlie", "Golden Retriever"));
        assertEquals(list.get(2).getName(), "Charlie");
	}
	
	@Test
	public void testRemove() {
		ArrayList list = new ArrayList(6);
		list.add(new Dog("Branquinho", "Boxer"));
		list.add(new Dog("Milgrau", "Pastor Alemão"));
		list.add(new Dog("Max", "Bulldog Francês"));
		list.add(new Dog("Luna", "Poodle"));
		list.add(new Dog("Buddy", "Labrador Retriever"));
		list.add(new Dog("Maggie", "Poodle"));
		
		
		// removendo o primeiro elemento
		list.remove(0);
		assertTrue(list.size() == 5);
		assertEquals("Milgrau", list.get(0).getName());
		assertEquals("Max", list.get(1).getName());
		assertEquals("Luna", list.get(2).getName());
       
        
        // removendo um elemento central Luna
		list.remove(2);
		assertEquals("Milgrau", list.get(0).getName());
		assertEquals("Max", list.get(1).getName());
		assertEquals("Buddy", list.get(2).getName());
		assertEquals("Maggie", list.get(3).getName());
		
        // removendo todos
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testResize() {
		ArrayList list = new ArrayList(3);
		
		list.add(new Dog("Branquinho", "Boxer"));
		list.add(new Dog("Milgrau", "Pastor Alemão"));
		list.add(new Dog("Max", "Bulldog Francês"));
		list.add(new Dog("Luna", "Poodle"));
		list.add(new Dog("Buddy", "Labrador Retriever"));
		list.add(new Dog("Maggie", "Poodle"));
        
        assertEquals(6, list.size());
	}
	
	@Test
	public void testGet() {
		ArrayList list = new ArrayList(3);
		list.add(new Dog("Branquinho", "Boxer"));
		list.add(new Dog("Milgrau", "Pastor Alemão"));
		list.add(new Dog("Max", "Bulldog Francês"));
        
		// acessando posição inválida.
        try {
            list.get(-1);
            fail("esta linha não pode ser executada.");
        } catch (IndexOutOfBoundsException e){}
        
        try {
            list.get(5);
            fail("esta linha não pode ser executada.");
        } catch (IndexOutOfBoundsException e){}
	}

}
