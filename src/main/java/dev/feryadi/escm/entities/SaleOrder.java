package dev.feryadi.escm.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sale_orders")
@Getter
@Setter
public class SaleOrder extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    private Merchant merchant;

    @Column(name = "checkout")
    private Boolean checkout;

    @OneToMany(mappedBy = "saleOrder")
    private List<SaleOrderDetail> saleOrderDetails;
}
