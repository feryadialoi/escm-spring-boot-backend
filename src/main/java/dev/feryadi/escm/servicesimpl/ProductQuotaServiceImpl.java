package dev.feryadi.escm.servicesimpl;

import dev.feryadi.escm.entities.Merchant;
import dev.feryadi.escm.entities.Product;
import dev.feryadi.escm.entities.ProductQuota;
import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.mappers.ProductQuotaMapper;
import dev.feryadi.escm.models.CreateProductQuotaRequest;
import dev.feryadi.escm.models.ListProductQuota;
import dev.feryadi.escm.models.ProductQuotaResponse;
import dev.feryadi.escm.models.UpdateProductQuotaRequest;
import dev.feryadi.escm.repositories.MerchantRepository;
import dev.feryadi.escm.repositories.ProductQuotaRepository;
import dev.feryadi.escm.repositories.ProductRepository;
import dev.feryadi.escm.services.ProductQuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductQuotaServiceImpl implements ProductQuotaService {
    @Autowired
    private ProductQuotaRepository productQuotaRepository;
    @Autowired
    private ProductQuotaMapper productQuotaMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public List<ProductQuotaResponse> getProductQuotas(ListProductQuota listProductQuota) {
        Page<ProductQuota> pageOfProductQuota = productQuotaRepository.findAll(PageRequest.of(listProductQuota.getPage(), listProductQuota.getSize()));
        List<ProductQuota> productQuotas = pageOfProductQuota.get().collect(Collectors.toList());
        return productQuotas.stream().map(productQuota -> productQuotaMapper.mapProductQuotaToProductQuotaResponse(productQuota)).collect(Collectors.toList());
    }

    @Override
    public ProductQuotaResponse getProductQuota(Long productQuotaId) throws NotFoundException {
        ProductQuota productQuota = findProductQuotaByIdOrThrowNotFound(productQuotaId);
        return productQuotaMapper.mapProductQuotaToProductQuotaResponse(productQuota);
    }

    @Transactional
    @Override
    public ProductQuotaResponse createProductQuota(CreateProductQuotaRequest createProductQuotaRequest) throws NotFoundException {
        ProductQuota productQuota = new ProductQuota();
        productQuota.setQuota(createProductQuotaRequest.getQuota());

        Product product = findProductByIdOrThrowNotFound(createProductQuotaRequest.getProductId());
        productQuota.setProduct(product);

        Merchant merchant = findMerchantByIdOrThrowNotFound(createProductQuotaRequest.getMerchantId());
        productQuota.setMerchant(merchant);

        productQuotaRepository.save(productQuota);

        return productQuotaMapper.mapProductQuotaToProductQuotaResponse(productQuota);
    }

    @Transactional
    @Override
    public ProductQuotaResponse updateProductQuota(UpdateProductQuotaRequest updateProductQuotaRequest, Long productQuotaId) throws NotFoundException {
        ProductQuota productQuota = findProductQuotaByIdOrThrowNotFound(productQuotaId);
        if (updateProductQuotaRequest.getQuota() != null) {
            productQuota.setQuota(updateProductQuotaRequest.getQuota());
        }

        if (updateProductQuotaRequest.getProductId() != null) {
            Product product = findProductByIdOrThrowNotFound(updateProductQuotaRequest.getProductId());
            productQuota.setProduct(product);
        }

        if (updateProductQuotaRequest.getMerchantId() != null) {
            Merchant merchant = findMerchantByIdOrThrowNotFound(updateProductQuotaRequest.getMerchantId());
            productQuota.setMerchant(merchant);
        }

        productQuotaRepository.save(productQuota);

        return productQuotaMapper.mapProductQuotaToProductQuotaResponse(productQuota);

    }

    @Override
    public ProductQuotaResponse deleteProductQuota(Long productQuotaId) throws NotFoundException {
        ProductQuota productQuota = findProductQuotaByIdOrThrowNotFound(productQuotaId);
        productQuotaRepository.delete(productQuota);
        return productQuotaMapper.mapProductQuotaToProductQuotaResponse(productQuota);
    }

    private Merchant findMerchantByIdOrThrowNotFound(Long merchantId) throws NotFoundException {
        Optional<Merchant> optionalMerchant = merchantRepository.findById(merchantId);
        if (optionalMerchant.isPresent()) {
            return optionalMerchant.get();
        }
        throw new NotFoundException("merchant with specified id not found, merchant id = '" + merchantId + "'");
    }

    private Product findProductByIdOrThrowNotFound(Long productId) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new NotFoundException("product with specified id not found, product id = '" + productId + "'");
    }

    private ProductQuota findProductQuotaByIdOrThrowNotFound(Long productQuotaId) throws NotFoundException {
        Optional<ProductQuota> optionalProductQuota = productQuotaRepository.findById(productQuotaId);
        if (optionalProductQuota.isPresent()) {
            return optionalProductQuota.get();
        }
        throw new NotFoundException("product quota with specified id not found, product quota id = '" + productQuotaId + "'");
    }
}
