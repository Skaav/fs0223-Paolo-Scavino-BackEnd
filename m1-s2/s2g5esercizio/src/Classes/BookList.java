package Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.io.Serializable;

public class BookList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ClassPropShared> books;

	public BookList() {
		books = new ArrayList<>();
	}

	public void addBook(ClassPropShared element) {
		books.add(element);
	}

	public void removeBookISBN(String isbn) {
		books.removeIf(element -> element.getIsbn().equals(isbn));
	}

	public Optional<ClassPropShared> searchBookISBN(String isbn) {
		return books.stream().filter(element -> element.getIsbn().equals(isbn)).findFirst();
	}

	public List<ClassPropShared> searchByYP(int yP) {
		return books.stream().filter(element -> element.getyP() == yP).toList();
	}

	public List<ClassPropShared> searchByAutor(String autor) {
		return books.stream().filter(element -> element instanceof ClassBook)
				.filter(element -> ((ClassBook) element).getAutor().equals(autor)).toList();
	}

	public List<ClassMagazine> searchPeriodicity(Periodicity period) {
		return books.stream().filter(element -> element instanceof ClassMagazine)
				.map(element -> (ClassMagazine) element).filter(magazine -> magazine.getPeriod() == period).toList();
	}

	public void saveOnDisk(String fileName) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			outputStream.writeObject(books);
			System.out.println("Saved successfully on Disk.");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void loadFromDisk(String nomeFile) {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeFile))) {
			books = (List<ClassPropShared>) inputStream.readObject();
			System.out.println("Loaded from Disk.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public List<ClassPropShared> getA() {
		return Collections.unmodifiableList(books);
	}
}
