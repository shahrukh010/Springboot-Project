package com.code.main;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.code.main.model.Product;

@SpringBootApplication
public class ReadingCsvSpringbootApplication {

	private static final String COMMA_DELIMITER = ",";

	public static void main(String[] args) {
		SpringApplication.run(ReadingCsvSpringbootApplication.class, args);
		prepareDataset();
	}

	public static Collection<Product> prepareDataset() {

		Resource resource = new ClassPathResource("fashion-products.csv");
		List<Product> productList = new ArrayList<Product>();

		try {

			InputStream input = resource.getInputStream();
			Scanner scanner = new Scanner(resource.getInputStream());
			int lineNo = 0;
			while (scanner.hasNext()) {
				++lineNo;
				String line = scanner.nextLine();
				if (lineNo == 1)
					continue;
				Optional<Product> product = csvRowToProductMapper(line);

				if (product.isPresent()) {
					productList.add(product.get());
				}
			}

		} catch (Exception e) {
			System.out.println("file read error" + " " + e);
		}
		return null;

	}

	private static Optional<Product> csvRowToProductMapper(String line) {

		try {

			Scanner rowScanner = new Scanner(line);
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {

				String name = rowScanner.next();
				String description = rowScanner.next();
				String manufacturer = rowScanner.next();
				System.out.println(name + "\n" + description + "\n" + manufacturer);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
