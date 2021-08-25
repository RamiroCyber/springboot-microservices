package com.br.jdev.exercicio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.jdev.exercicio.DTO.ProductDTO;
import com.br.jdev.exercicio.entities.Product;
import com.br.jdev.exercicio.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}

	public List<ProductDTO> getProductByCategory(Long categoryId) {
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}

	public ProductDTO save(ProductDTO productDTO) {
		Product product = productRepository.save(Product.convert(productDTO));
		return ProductDTO.convert(product);
	}

	public void delete(Long productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			productRepository.delete(product.get());
		}

	}

}
