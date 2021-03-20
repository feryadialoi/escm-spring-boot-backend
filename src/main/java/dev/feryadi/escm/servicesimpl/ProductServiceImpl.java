package dev.feryadi.escm.servicesimpl;

import dev.feryadi.escm.entities.Product;
import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.mappers.ProductMapper;
import dev.feryadi.escm.models.CreateProductRequest;
import dev.feryadi.escm.models.ListProductRequest;
import dev.feryadi.escm.models.ProductResponse;
import dev.feryadi.escm.models.UpdateProductRequest;
import dev.feryadi.escm.repositories.ProductRepository;
import dev.feryadi.escm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;


    private Product findProductByIdOrThrowNotFoundException(Long productId) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new NotFoundException("product with specified id not found, product id = '" + productId + "'");
    }

    @Override
    public List<ProductResponse> getProducts(ListProductRequest listProductRequest) {
        Page<Product> pageOfProducts = productRepository.findAll(PageRequest.of(listProductRequest.getPage(), listProductRequest.getSize()));
        List<Product> products = pageOfProducts.get().collect(Collectors.toList());
        return products.stream().map(product -> productMapper.mapProductToProductResponse(product)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProduct(Long productId) throws NotFoundException {
        Product product = findProductByIdOrThrowNotFoundException(productId);
        return productMapper.mapProductToProductResponse(product);
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());

        productRepository.save(product);

        return productMapper.mapProductToProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(UpdateProductRequest updateProductRequest, Long productId) throws NotFoundException {
        Product product = findProductByIdOrThrowNotFoundException(productId);

        if (updateProductRequest.getName() != null) {
            product.setName(updateProductRequest.getName());
        }
        if (updateProductRequest.getPrice() != null) {
            product.setPrice(updateProductRequest.getPrice());
        }
        if (updateProductRequest.getQuantity() != null) {
            product.setQuantity(updateProductRequest.getQuantity());
        }

        productRepository.save(product);

        return productMapper.mapProductToProductResponse(product);

    }

    @Override
    public ProductResponse deleteProduct(Long productId) throws NotFoundException {
        Product product = findProductByIdOrThrowNotFoundException(productId);

        productRepository.delete(product);

        return productMapper.mapProductToProductResponse(product);
    }
}
