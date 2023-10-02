package com.farhad.example.ddd_hexagonal_spring_data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Invoice;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.InvoiceRepository;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.LineItem;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Product;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.ProductRepository;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository.invoice.SpringDataInvoiceRepository;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository.invoice.SpringDataProductRepository;


@SpringBootTest
public class InvoiceEntityTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SpringDataInvoiceRepository springDataInvoiceRepository;
    @Autowired
    private SpringDataProductRepository springDataProductRepository;

    @Test
    public void productTest() {
        
    }

    @Test
    public void invoiceTest() {

        springDataInvoiceRepository.deleteAll();
        springDataProductRepository.deleteAll();

        Product productA = new Product(1L, "ProductA");
        productRepository.save(productA);
        Product productB = new Product(2L, "ProductB");
        productRepository.save(productB);
        Product productC = new Product(3L,"ProductC");
        productRepository.save(productC);

        Invoice invoice01 = new Invoice(1L,"Invoice-01");
        invoice01.addItem(new LineItem(productA, 10));
        invoice01.addItem(new LineItem(productB, 20));
        invoice01 = invoiceRepository.save(invoice01);

        Invoice invoice02 = new Invoice(2L,"Invoice-02");
        invoice02.addItem(new LineItem(productB, 30));
        invoice02.addItem(new LineItem(productC, 40));
        invoice02 = invoiceRepository.save(invoice02);

        System.out.println("Invoice-01: =============================================================");
        System.out.println(invoiceRepository.findById(invoice01.getId()));

        System.out.println("Invoice-02: +==========================================================");
        System.out.println(invoiceRepository.findById(invoice02.getId()));

        springDataInvoiceRepository.deleteAll();
        springDataProductRepository.deleteAll();
    } 
}
