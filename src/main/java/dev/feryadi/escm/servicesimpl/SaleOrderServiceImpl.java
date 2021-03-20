package dev.feryadi.escm.servicesimpl;

import dev.feryadi.escm.entities.*;
import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.mappers.SaleOrderMapper;
import dev.feryadi.escm.models.CreateSaleOrderRequest;
import dev.feryadi.escm.models.SaleOrderResponse;
import dev.feryadi.escm.repositories.MerchantRepository;
import dev.feryadi.escm.repositories.ProductQuotaRepository;
import dev.feryadi.escm.repositories.SaleOrderDetailRepository;
import dev.feryadi.escm.repositories.SaleOrderRepository;
import dev.feryadi.escm.services.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private SaleOrderDetailRepository saleOrderDetailRepository;
    @Autowired
    private ProductQuotaRepository productQuotaRepository;


    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Transactional
    @Override
    public SaleOrderResponse createSaleOrder(CreateSaleOrderRequest createSaleOrderRequest) throws Exception {

        Merchant merchant = findMerchantByIdOrThrowNotFoundException(createSaleOrderRequest.getMerchantId());

        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setMerchant(merchant);
        saleOrderRepository.save(saleOrder);

        createSaleOrderRequest.getSaleOrderDetailRequests().forEach(saleOrderDetailRequest -> {
            ProductQuota productQuota = productQuotaRepository.findProductQuotaByProductIdNative(saleOrderDetailRequest.getProductId());
            productQuota.setQuota(productQuota.getQuota() - saleOrderDetailRequest.getQuantity());
            productQuotaRepository.save(productQuota);

            SaleOrderDetail saleOrderDetail = new SaleOrderDetail();
            saleOrderDetail.setSaleOrder(saleOrder);
            saleOrderDetail.setQuantity(saleOrderDetailRequest.getQuantity());
            saleOrderDetail.setProduct(productQuota.getProduct());
            saleOrderDetailRepository.save(saleOrderDetail);
        });

        return saleOrderMapper.mapSaleOrderToSaleOrderResponse(saleOrder);
    }

    private Merchant findMerchantByIdOrThrowNotFoundException(Long merchantId) throws Exception {
        Optional<Merchant> optionalMerchant = merchantRepository.findById(merchantId);
        if (optionalMerchant.isPresent()) {
            return optionalMerchant.get();
        }
        throw new NotFoundException("merchant with specified id not found, merchant id = '" + merchantId + "'");
    }
}
